package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sysHelpers.TestVerify;

public class LogInPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id ='Username' and @type = 'text']")
    private WebElement UsernameBox;

    @FindBy(id = "Password")
    private WebElement PasswordBox;

    @FindBy(className = "btn-primary btn-full-width btn idm-control idm-button ng-scope ng-isolate-scope")
    private WebElement SignInButton;




    public LogInPage(WebDriver Driver)
    {
        driver = Driver;
        PageFactory.initElements(driver, this);

    }


    public boolean isInitialized()
    {
        return UsernameBox.isDisplayed();
    }


    public void logIn(String username, String password) {
    	try {
        UsernameBox.sendKeys(username);
        PasswordBox.sendKeys(password);
        PasswordBox.sendKeys(Keys.ENTER);

        //SharedActions.javascriptClick(driver, SignInButton);
    	} catch(Exception e){
    		TestVerify.Equal(e, "passing user credentials");
    	}
    }
}