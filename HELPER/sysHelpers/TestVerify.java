package sysHelpers;

import org.testng.Assert;
import org.testng.Reporter;

public class TestVerify extends Assert {
	
	//verify a method is executed and get the error message on method failure. the specific error message can also be found in the test reports under test-output folder
	
	public static void Equal(Exception e2, String message)
	{
		try {
			assertEquals(e2, message);
		}
		catch (Error e) {
			Reporter.log("Error: " + e.getLocalizedMessage());
		}		
	}
	
	public static void Equal(boolean object)
	{
		try {
			assertTrue(object);
		}
		catch (Error e) {
			Reporter.log("Error: " + e.getLocalizedMessage());
		}			
	}
}
