package appHelpers;

import org.openqa.selenium.WebDriver;
import pageObjects.StudentsPage;
import sysHelpers.Utility;

public class NewStudentHelper {
	
	 public static void createANewStudent(WebDriver driver, String fileName)
	 {		//pass the fileName when you call this method. you can create a new file for the testcase.
		 	//follow the same data format when u create a new file for test case.
	        SideKick.goToStudentsPage(driver);
	        Utility.wait(5);
	    	
	    	StudentsPage sp = new StudentsPage(driver);
	    	sp.isInitialized();
	    	sp.createANewStudent(fileName);
	 }
}
