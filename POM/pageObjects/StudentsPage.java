package pageObjects;

import appHelpers.SharedActions;
import sysHelpers.DataNames;
import sysHelpers.TestVerify;
import sysHelpers.Utility;
import testData.ExcelDataConfiguration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentsPage
{
	WebDriver driver;

    @FindBy(xpath = "//a[contains(@data-dynamicid,'Organization_Students')]")
    private WebElement OrganizationStudentsTab;

    //Page Objects in the new Student's wizard
    @FindBy(xpath = "//a[contains(@href,'javascript:addStudent()')]")
    private WebElement AddStudentButton;

    @FindBy(xpath = "//input[contains(@name,'TFIRSTNAME')]")
    private WebElement FirstNameBox;

    @FindBy(xpath = "//input[contains(@name,'TLASTNAME')]")
    private WebElement LastNameBox;

    @FindBy(xpath = "//input[contains(@name,'DANISDUMB')]")
    private WebElement DobBox;

    @FindBy(xpath = "//input[contains(@name,'TSTATEID')]")
    private WebElement StateIdBox;
    
    @FindBy(xpath ="//input[@id='localID']")
    private WebElement LocalIdBox;

    @FindBy(xpath = "//select[contains(@name,'TLANGUAGE')]")
    private WebElement LanguageList;
    
    @FindBy(xpath = "//select[contains(@name,'TETHNICITY')]")
    private WebElement EthnicityList;
    
    @FindBy(xpath = "//input[contains(@name,'TSTREET1')]")
    private WebElement Street1Box;
    
    @FindBy(xpath = "//input[contains(@name,'TCITY')]")
    private WebElement CityBox;
    
    @FindBy(xpath = "//input[contains(@name,'TPOSTALCODE')]")
    private WebElement ZipBox;
    
    @FindBy(xpath = "//a[@id='linkbuttonNextSave-button' and @href='javascript:next()']")
    private WebElement NextButton;
    
    @FindBy(xpath = "//a[contains(@href,'toPrograms')]")
    private WebElement NextButton2;
    
    @FindBy(xpath = "//a[contains(@href,'SaveAndFinish()')]")
    private WebElement SaveFinishButton;

    public StudentsPage(WebDriver Driver)
    {
        driver = Driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isInitialized()
    {
        return OrganizationStudentsTab.isDisplayed();
    }

    public void createANewStudent(String fileName)
    {
    	try {
        SharedActions.click(driver,OrganizationStudentsTab);
        Utility.wait(5);
        
        SharedActions.click(driver, AddStudentButton);
        Utility.wait(5);

        Utility.switchFrame(driver, "bigOverlayIframe");
        Utility.wait(5);        
        
        //students' name are extracted from the excel file below in a random order 
        ExcelDataConfiguration names = new ExcelDataConfiguration(fileName);
        
        //New Student Info Wizard    	
    	String fname = names.getRandomData(0, 0);         
    	String lname = names.getRandomData(0, 0);
    	String language = names.getData(0, 1, 11);
    	String ethnicity = names.getData(0, 1, 2);
    	String street = names.getData(0, 1, 3);
    	String city = names.getData(0, 1, 4);
    	String zip = names.getData(0, 1, 6);
    	
        DataNames.FIRST_NAME = fname;
        DataNames.LAST_NAME = lname;        
        FirstNameBox.sendKeys(fname);
        LastNameBox.sendKeys(lname);        
        String  dob = Utility.dateOfBirth(); 
        DobBox.clear();        
        DobBox.sendKeys(dob);
        DobBox.sendKeys(Keys.ENTER);        
        String id = Utility.randomId();
        DataNames.STATE_ID = id;  
        StateIdBox.sendKeys(id);
        LocalIdBox.sendKeys(id);        
        LanguageList.sendKeys(language);
        LanguageList.sendKeys(Keys.ENTER);        
        EthnicityList.sendKeys(ethnicity);
        EthnicityList.sendKeys(Keys.ENTER);        
        Street1Box.sendKeys(street);        
        CityBox.sendKeys(city);        
        ZipBox.sendKeys(zip);
        ZipBox.sendKeys(Keys.ENTER);        
        SharedActions.javascriptClick(driver, NextButton);        

        //Guardian Information wizard
        Utility.wait(5);
        FirstNameBox.sendKeys(fname);
        LastNameBox.sendKeys(lname);
        Utility.wait(5);
        LanguageList.sendKeys(language);
        LanguageList.sendKeys(Keys.ENTER);
        SharedActions.javascriptClick(driver, NextButton);        
        
        //Enrollment wizard
        Utility.wait(5);
        SharedActions.javascriptClick(driver, NextButton2);
        
        //Other Information wizard
        Utility.wait(5);
        SharedActions.javascriptClick(driver, SaveFinishButton);
        Utility.wait(5);
        }
    	catch(Exception e)
    	{
    		TestVerify.Equal(e, "create a student");    		
    		throw(e);
    	}
    	
    	

    }
}