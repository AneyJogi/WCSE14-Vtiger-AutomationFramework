package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisationWithIndustry {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
	
		
		driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.xpath("//img[@alt='Cre\"submitButton\")).click();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("ate Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Aney1");
		
		WebElement dropdown = driver.findElement(By.name("industry"));
		Select s = new Select(dropdown);
		s.selectByValue("Healthcare");
		
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		

	}

}
