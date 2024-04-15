package testng.functionalities;

import org.testng.annotations.Test;

public class TestNG_Priority {

	@Test(priority = 2)
	public void test1() {                                // TestNG siempre empieza por orden alfabetico -> Ej : test1, No recomendado poner prioridad
		System.out.println("Priority --> test1");
	}

	@Test(priority = 1)
	public void test2() {
		System.out.println("Priority --> test2");
	}

	@Test(priority = 0)
	public void test3() {
		System.out.println("Priority --> test3");
	}
}