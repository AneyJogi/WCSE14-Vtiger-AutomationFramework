package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.ObjectRepository.LoginPage;

public class POMPractice
{
	public static void main(String[] args) {

     WebDriver driver = new ChromeDriver();
     driver.get("http://localhost:8888/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

     //Login to Application
     
       LoginPage lp= new LoginPage(driver);
       
     //lp.getUsernameEdt().sendKeys("admin");
     //lp.getPasswordEdt().sendKeys("manager");
     //lp.getSubmitBtn().click();
       
       lp.LoginToApp("admin", "admin");
     
     		
     
}
}