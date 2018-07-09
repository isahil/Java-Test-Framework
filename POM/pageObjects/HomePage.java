package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;


    @FindBy(className = "last-element")
    private WebElement MyStudentButton;

    @FindBy(xpath = "//div[@class='content' and @title= 'eSTAR Test District']")
    private WebElement OrgName;
    
    @FindBy(xpath = "//a[@class='sk--main-menu-item-container sk-tooltip-container' and contains(@href, 'v4qaoh.estarseries.com/v4/organization/tabs/studentTabs') ]")
    private WebElement StudentsTab;


    public HomePage(WebDriver Driver) {
        driver = Driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isInitialized() {

        return StudentsTab.isDisplayed();

    }

}