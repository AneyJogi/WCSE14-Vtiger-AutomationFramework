package vTiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.GenericUtilities.WebDriverUtility;


public class MakeMyTripTest  extends WebDriverUtility 
{
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wUtil= new WebDriverUtility();
		
		driver.get("https://www.makemytrip.com/");
		wUtil.maximiseWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		driver.findElement(By.id("root")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thu Jan 05 2023']")).click();
		
		
}
}

