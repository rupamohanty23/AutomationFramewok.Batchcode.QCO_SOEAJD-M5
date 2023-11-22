package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice2 {
@Test
	
	public void createCustomer() {
	    Assert.fail();//fail
		System.out.println("create");
	}
	@Test(dependsOnMethods="createCustomer")
	public void modifycustomer() {
		System.out.println("modify");
		
	}
	@Test(priority=-3)
	public void deleteCustomer() {
		System.out.println("delete");//passed
	}

}
