package sysHelpers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class TestTransformer implements IAnnotationTransformer {

	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
	{		
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		 
		 if (retry == null) {
			 annotation.setRetryAnalyzer(sysHelpers.TestRetry.class);			 
		 }
		
	}
}
