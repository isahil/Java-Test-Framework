package sysHelpers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	
	@Override
	public void onStart(ITestContext result) {

		System.out.println("Test suite execution started  for: " + result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started for the following: " + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed for the following: " + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed for the following: " + result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("Test skipped for the following: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	@Override
	public void onFinish(ITestContext result) {

		System.out.println("Test suite execution finished  for: " + result.getName());
	}

}
