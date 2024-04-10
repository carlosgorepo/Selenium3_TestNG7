package testng.tests;

public class SomeClassToTest {

	public int sumNumbers(int a, int b) {
		return a + b;
	}

	public String addString(String a, String b) {
		return a + " " + b;
	}

	public int[] getArray() {
		return new int[]{1, 2, 3};
	}
}