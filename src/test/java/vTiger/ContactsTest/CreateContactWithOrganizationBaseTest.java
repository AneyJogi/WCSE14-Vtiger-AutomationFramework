package vTiger.ContactsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
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

public class CreateContactWithOrganizationBaseTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void CreateContactWithOrgBaseTest() throws EncryptedDocumentException, IOException
	{
	
	
	//Step 1: Read Test Data
	String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
	String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
	
	 
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
	 Assert.assertTrue(OrgHeader.contains(ORGNAME));
	 
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
   Assert.assertEquals(ContactHeader.contains(LASTNAME), true);
 
	}
	
	
	@Test(groups = "RegressionSuite")
	public void DemoTest()
	{
		//Assert.fail();
		System.out.println("This is Demo ");
	}

}
