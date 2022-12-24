package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertPractice 
{
	
	@Test
	public void hardAssertPractice()
	{
		SoftAssert sa= new SoftAssert();
	System.out.println("Step1");
	System.out.println("Step2");
	System.out.println("Step3");
	sa.assertEquals(false, true);
	System.out.println("Step4");
	System.out.println("Step5");
	sa.assertTrue(false);
	System.out.println("Step6");
	sa.assertAll();
	} 	

}
