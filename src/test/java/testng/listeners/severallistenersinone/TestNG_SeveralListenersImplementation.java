package testng.listeners.severallistenersinone;

import org.testng.*;

public class TestNG_SeveralListenersImplementation implements ITestListener, ISuiteListener, IInvokedMethodListener {

	//---------------------------------- ITEST LISTENER ----------------------------------------------------------------

	//Runs when test method starts
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart --> Test Name: " + result.getName());
	}

	//Runs when test method is successful
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess --> Test Name: " + result.getName());
	}

	//Runs when test method is failed
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure --> Test Name: " + result.getName());
	}

	//Runs when test method is skipped
	@Override
	public void onTestSkipped(ITestResult result) {
	}

	//Runs BEFORE <test> tag of Xml file
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart --> Test Name: " + context.getName());
		ITestNGMethod[] methods = context.getAllTestMethods();
		System.out.println("These methods will be executed in this test tag:");
		for (ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
		}
	}

	//Runs AFTER <test> tag of Xml file
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish --> Test Name: " + context.getName());
	}

//---------------------------------- ISUITE LISTENER ---------------------------------------------------------------

	//Runs when <suite> tag on the Xml file STARTS
	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart --> BEFORE suite starts");
	}

	//Runs when <suite> tag on the Xml file COMPLETES
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish --> AFTER suite completes");
	}

//---------------------------------- IINVOKEDMETHOD LISTENER -------------------------------------------------------

	//Runs BEFORE every method in the Test Class
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("BeforeInvocation: " + testResult.getTestClass().getName()
				+ " --> " + method.getTestMethod().getMethodName());
	}

	//Runs AFTER every method in the Test Class
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("AfterInvocation: " + testResult.getTestClass().getName()
				+ " --> " + method.getTestMethod().getMethodName());
	}

}
