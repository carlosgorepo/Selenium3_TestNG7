package testng.listeners.iinvokedmethod;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IInvokeMethodListenerImplementation implements IInvokedMethodListener {

	// Su comportamiento es agregar antes y después de cada método de prueba, es como tener un BeforeBefore de cada anotacion (@) y un afterafter de cada (@)
	// Runs BEFORE every method in the Test Class, es como un before suite, está a un nivel superior
	// Bueno para Logs
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) { //IInvokedMethod = En que @coso estoy, ITestResult = Ruta en donde estoy e información sobre la clase
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