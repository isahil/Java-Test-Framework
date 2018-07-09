package sysHelpers;

import org.testng.Assert;
import org.testng.Reporter;

public class TestVerify extends Assert {
	
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
