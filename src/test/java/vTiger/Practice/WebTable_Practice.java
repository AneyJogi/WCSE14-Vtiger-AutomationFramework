package vTiger.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;

public class WebTable_Practice extends BaseClass{
	@Test
	public void  orgWebTable()
	{
		driver.get("http://localhost:8888/");
		driver.findElement(By.linkText("Organizations")).click();
		 List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
		 System.out.println(ele.size());
		 for(WebElement b:ele)
		 {
			 System.out.println(b.getText());
		 }

	}
}
