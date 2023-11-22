package practice;

import org.testng.annotations.Test;

public class TestNGPractice1 {
//@Test(invocationCount=-1)//disabled
//@Test(invoactionCount=3,priority=2)
	@Test(enabled=false)
	public void createCustomer() {
		System.out.println("create");
	}
	@Test(priority=0)
	public void modifycustomer() {
		System.out.println("modify");
		
	}
	@Test(priority=-3)
	public void deleteCustomer() {
		System.out.println("delete");

}
}