package testng.listeners.isuite;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ISuiteListenerImplementation implements ISuiteListener {

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
}