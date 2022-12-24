package vTiger.ContactsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganization 
 {
	public static void main(String[] args) throws IOException
	{
		//step 1: create the necessary objects of all utilities
		JavaUtility jUtil= new JavaUtility();
		ExcelFileUtility eUtil= new ExcelFileUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		WebDriverUtility wUtil= new WebDriverUtility();
		
		WebDriver driver= null;
		
		//Step 2: read required data
		String Browser = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3);
		
		//Step 3:Launch the browser
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else 
		{
			System.out.println("Invalid browser name");
		}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step 4: Login Application
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 
		 //step 5: navigate to organization
		 driver.findElement(By.linkText("Organizations")).click();
			
		 //Step 6: click on create organization lookup image
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
		 //Step 7: Create new organization with mandatory information and save
		  driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	      driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	      
	     //Step 8: validation for organization	
	      String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText(); 
		 	if (OrgHeader.contains(ORGNAME))
			{
				System.out.println(OrgHeader);
				System.out.println("Organization created sucessfully");
			} 
			else
			{
				System.out.println("Organization creation failed");
			}
		 
		//step 9: navigate to contacts link
	    driver.findElement(By.linkText("Contacts")).click();
	    
	    //step10: lick on create contact lookup image
	    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	    
	    //step 11:Create new contact with mandatory information 
	    driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	    
	   //step 12:navigate to organization look up image
	    driver.findElement(By.xpath("//input[@name=\"account_name\"] /following-sibling::img[@alt='Select']")).click();
	    
	    //step 13: switch control to organizations window
	    wUtil.switchToWindow(driver, "Accounts");
	    driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
	    driver.findElement(By.name("search")).click();
	    
	    driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();  //Dynamic xpath-Xpath generated on run time
	    
	    //step14 : swtich control back to parent window 
	    wUtil.switchToWindow(driver, "Contacts");
	    
	    //step15: save
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //Step 16: validation for  Contacts	
	    String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText(); 
			if (ContactHeader.contains(LASTNAME))
			{
				System.out.println(ContactHeader);
				System.out.println("PASS");
			} 
			else
			{
				System.out.println("FAIL");
			}
			
		//step 17: Logout
			WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverAction(driver, adminImg);
			driver.findElement(By.linkText("Sign Out")).click();
			
		
	}
		
	
 }
