package vTiger.Practice;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice 
{
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("Before Method");
	}

	@Test
	public void testA()
	{
		System.out.println("testA");
	}
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("Before class");
	}
	
	@Test
	public void test()
	{
		System.out.println("testB");
	}
	@AfterMethod
	public void amConfig()
	{
		System.out.println("After Method");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("After Suite");
	}
	
	@AfterClass 
	public void acConfig()
	{
		System.out.println("After Class ");
	}
	
	
}


