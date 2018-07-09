package appHelpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SharedActions {	

    public static void click(WebDriver driver, WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click(element).perform();
    }
    
    public static void javascriptClick(WebDriver driver, WebElement element)
    {
    	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
    	jse2.executeScript("arguments[0].click();", element); 
    }
}