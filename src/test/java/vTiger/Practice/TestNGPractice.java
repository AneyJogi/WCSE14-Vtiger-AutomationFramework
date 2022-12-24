package vTiger.Practice;

import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class TestNGPractice {
	
	@Test(priority =-1,invocationCount = 2)
	public void createCustomerTest()
	{
		System.out.println("Create Customer");
	}

	@Test(priority=0)
	public void modifyCustomerTest()
	{
		System.out.println("Modify customer");
	}
	
	@Test(priority = 1)
	public void deleteCustomerTest()
	{
		System.out.println("Delete customer");
	}
}
