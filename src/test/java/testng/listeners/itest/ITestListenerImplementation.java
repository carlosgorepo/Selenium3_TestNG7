package testng.listeners.itest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class ITestListenerImplementation implements ITestListener {

	//Runs when test method starts -> Each @Test
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart --> Test Name: " + result.getName());
	}

	//Runs when test method is successful -> @Test
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
		System.out.println("onStart --> Test Name: " + context.getName()); //context.getName() me trae el name del tag Test
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
}
