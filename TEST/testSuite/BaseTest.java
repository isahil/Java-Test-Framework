package testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	WebDriver Driver;

	@Parameters({ "browser", "environment", "qaurl", "liveurl" })
	@BeforeMethod()
	public void setUp(String browser, String environment, String qaurl, String liveurl) throws Exception {

		// set up the webdriver to kick off the tests. can add additional browsers here
		if (browser.equals("edge")) {
			Driver = new EdgeDriver();
		}

		else if (browser.equals("chrome")) {
			Driver = new ChromeDriver();
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
	public void testQuit()
	{
		Driver.close();
		Driver.quit();
	}

//	@AfterClass()
//	public void tearDown() throws Exception {
//		Driver.close();
//		Driver.quit();
//	}
}