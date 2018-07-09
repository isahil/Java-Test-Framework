package sysHelpers;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Utility {
	
	//call this method to make the application wait for the test's required time 
	public static void wait(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//random nine digit numbers
	public static String randomId() {
		Random rnd = new Random();
		int randomStateId = rnd.nextInt(999999999) + 123456789;
		String randomStateIdstring = "" + randomStateId;
		return randomStateIdstring;
	}

	//random date between the years passed below. 
	public static String dateOfBirth() {
		GregorianCalendar gc = new GregorianCalendar();

		int year = 2010 + (int) Math.round(Math.random() * (2014 - 2010));
		gc.set(Calendar.YEAR, year);

		int day = 1 + (int) Math.round(Math.random() * (gc.getActualMaximum(Calendar.DAY_OF_YEAR) - 1));
		gc.set(Calendar.DAY_OF_YEAR, day);

		String randomBirthDateString = (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH) + "-"
				+ gc.get(Calendar.YEAR);

		return randomBirthDateString;
	}

	
	//call this method to switch frame to a pop up window/notification
	public static void switchFrame(WebDriver driver, String title) {
		driver.switchTo().frame(title);
	}
	
	//The below method will save the screen shot in screenshot folder with test method name. screenShot method is executed during the AfterMethod execution in BaseTest
	public static void screenShot(WebDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshot/" + screenshotName + ".png"));

			System.out.println("screen shot captured");
			} 
		catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}
}
