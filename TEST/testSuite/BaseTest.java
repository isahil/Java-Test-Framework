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

	@Parameters({ "browser", "environment", "qaurl", "liveurl"})
	@BeforeMethod()
	public void setUp(String browser, String environment, String qaurl, String liveurl) throws Exception {

		// set up the webdriver to kick off the tests. add additional webdrivers here
		  String USERNAME = "isahil";
		  String AUTOMATE_KEY = "dcd8af30-f4e6-412d-86da-f92150233116";
		  String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		  
//		  options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//		  options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//		  options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		  
		if (browser.equals("edge")) {
			//Driver = new EdgeDriver();
			EdgeOptions eo = new EdgeOptions();
			eo.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			Driver = new  RemoteWebDriver(new URL(URL), eo);
		}

		else if (browser.equals("chrome")) {
			//Driver = new ChromeDriver();
			ChromeOptions co = new ChromeOptions();
			Driver = new RemoteWebDriver(new URL(URL), co);
		}

		Driver.manage().window().maximize();

		// add more parameters for environment links in the loop if necessary.
		if (environment.equals("qa")) {
			Driver.get(qaurl);
		}

		else if (environment.equals("live")) {
			Driver.get(liveurl);
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