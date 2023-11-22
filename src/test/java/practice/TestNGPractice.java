package practice;

import org.testng.annotations.Test;

public class TestNGPractice {
	@Test(priority=-1)
	
	public void cretaeCustomer() {
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
