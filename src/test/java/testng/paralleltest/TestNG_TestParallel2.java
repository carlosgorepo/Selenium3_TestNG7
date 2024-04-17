package testng.paralleltest;

import org.testng.annotations.Test;

public class TestNG_TestParallel2 {

	@Test
	public void test1() throws InterruptedException {
		System.out.println("TestNG_TestParallel2 --> Test 1");
		Thread.sleep(6000);
		System.out.println("TestNG_TestParallel2 --> Test 1 --> More Steps");
	}

	@Test
	public void test2() throws InterruptedException {
		System.out.println("TestNG_TestParallel2 --> Test 2");
		Thread.sleep(6000);
		System.out.println("TestNG_TestParallel2 --> Test 2 --> More Steps");
	}

	@Test
	public void test3() throws InterruptedException {
		System.out.println("TestNG_TestParallel2 --> Test 3");
		Thread.sleep(6000);
		System.out.println("TestNG_TestParallel2 --> Test 3 --> More Steps");
	}
}
