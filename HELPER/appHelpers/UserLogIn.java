package appHelpers;

import testData.ExcelDataConfiguration;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import sysHelpers.Utility;

public class UserLogIn {
	
    private static  void login(WebDriver driver, String username, String password)
    {    	
        LogInPage page = new LogInPage(driver);
        page.isInitialized();
        page.logIn(username, password);
        
        HomePage homepage = new HomePage(driver);
        Utility.wait(5);
        assertTrue(homepage.isInitialized());
    	   	
    }

    //user credentials are retrieved from the file name passed below
	public static void logIn(WebDriver driver, String State)
	{
		ExcelDataConfiguration creds = new ExcelDataConfiguration("LogInData.xlsx");	
    	
		if(State.equals("OH"))
		{
	        String username = creds.getData(0,1, 1);
	        String password = creds.getData(0,1, 2);
	        login(driver, username, password);
		}
		
		if(State.equals("PA"))
		{
	        String username = creds.getData(0,2, 1);
	        String password = creds.getData(0,2, 2);
	        login(driver, username, password);
		}
	
		if(State.equals("WI"))
		{
	        String username = creds.getData(0,3, 1);
	        String password = creds.getData(0,3, 2);
	        login(driver, username, password);
		}
		
		if(State.equals("IL"))
		{
	        String username = creds.getData(0,4, 1);
	        String password = creds.getData(0,4, 2);
	        login(driver, username, password);
		}
	}
}
