package sysHelpers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {
	
	private int counter = 0;
	private int retrylimit = 2;

	public boolean retry(ITestResult result) {
		if(counter < retrylimit) {
			System.out.println("Retrying " + result.getName() + " again and the count is " + (counter+1));
			
			counter++;
			return true;
		}
		return false;
	}
}
