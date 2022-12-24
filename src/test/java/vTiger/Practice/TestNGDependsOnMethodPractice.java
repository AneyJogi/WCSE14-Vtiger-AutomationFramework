package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDependsOnMethodPractice {
	
	@Test()
	
	public void createCustomerTest()
	{
		Assert.fail();
		System.out.println("Create Customer");
	}

	@Test(dependsOnMethods="createCustomerTest")
	public void modifyCustomerTest()
	{
		System.out.println("Modify customer");
	}
	
	@Test(dependsOnMethods={"createCustomerTest","modifyCustomerTest"})
	public void deleteCustomerTest()
	{
		System.out.println("Delete customer");
	}

}
