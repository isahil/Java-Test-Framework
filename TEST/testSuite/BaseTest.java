package testSuite;

import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import sysHelpers.Utility;

public class BaseTest {
	
	WebDriver Driver;

	@Parameters({"platform", "browser",
			"environment", "qaUrl", "liveUrl",
			"gridHub", "gridUrl", "gridUser", "gridKey"})

	@BeforeMethod()
	public void setUp(String platform, String browser,
					  String environment, String qaUrl, String liveUrl,
					  String gridHub, String gridUser, String gridKey, String gridUrl) throws Exception {

		//configure the webdrivers to kick off the tests.

		if(gridHub.equals("true"))
		{
			String url = "https://" + gridUser + ":" + gridKey + gridUrl;

			if (browser.equals("edge"))
			{
				EdgeOptions eo = new EdgeOptions();
				eo.setCapability(CapabilityType.PLATFORM_NAME, Platform.valueOf(platform));
				Driver = new RemoteWebDriver(new URL(url), eo);
			}
			else if (browser.equals("chrome"))
			{
				ChromeOptions co = new ChromeOptions();
				co.setCapability(CapabilityType.PLATFORM_NAME, Platform.valueOf(platform));
				Driver = new RemoteWebDriver(new URL(url), co);
			}
		}
		else if(gridHub.equals("false"))
		{
			if(browser.equals("edge"))
			{
				Driver = new EdgeDriver();
			}
			if(browser.equals("chrome"))
			{
				Driver = new ChromeDriver();
			}
		}

		Driver.manage().window().maximize();

		// add more parameters for environment links in the loop if necessary.
		if (environment.equals("qa"))
		{
			Driver.get(qaUrl);
		}

		else if (environment.equals("live"))
		{
			Driver.get(liveUrl);
		}
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.screenShot(Driver, result.getName());
		}
		
		Driver.close();
		Driver.quit();
	}
}