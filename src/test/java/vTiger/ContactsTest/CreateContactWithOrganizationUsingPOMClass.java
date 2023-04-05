package vTiger.ContactsTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationUsingPOMClass {

	public static void main(String[] args) throws IOException {
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
				String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
				
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
				LoginPage lp= new LoginPage(driver);
				lp.LoginToApp(USERNAME, PASSWORD);
				 
				//step 5: navigate to organization
				HomePage hp= new HomePage(driver);
				hp.clickOnOrganizationLink();
				
				//Step 6: click on create organization lookup image
			    OrganizationsPage op= new OrganizationsPage(driver);
			    op.ClickOnCreateOrgLookUpImg();
						
			    //Step 7: Create new organization with mandatory information and save
				 CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
				 cnop.CreateNewOrganization(ORGNAME);
			      
			   //Step 8: validation for organization	
			     OrganizationInfoPage oip= new OrganizationInfoPage(driver);
			     String OrgHeader = oip.getOrganizationHeaderText();
				 if(OrgHeader.contains(ORGNAME))
				 {
					 System.out.println(OrgHeader);
					 System.out.println("Organization created");
				 }
				 else
				 {
					System.out.println("Organization not created");
				 }
				 
			   //step 9: navigate to contacts link
			    hp.clickOnContactsLink();
			   
			    
			   //step 10: lick on create contact lookup image
			   ContactsPage cp= new ContactsPage(driver);
			   cp.clickOnCreateContactImg();
			    
			   //step 11:Create new contact with mandatory information 
			   CreateNewContactPage cncp =new CreateNewContactPage(driver);
			   cncp.createNewContact(LASTNAME, ORGNAME, driver);
			    
			  //step 12:validation for  Contacts
			   ContactsInfoPage cip= new ContactsInfoPage(driver);
			   String ContactHeader = cip.getContactHeader();
			   if(ContactHeader.contains(LASTNAME))
				 {
					 System.out.println(ContactHeader);
					 System.out.println("Pass");
				 }
				 else
				 {
					System.out.println("fail");
				 }
			 
			  //step 17: Logout
			   hp.LogOutOfApp(driver);
				
 
	}

}
