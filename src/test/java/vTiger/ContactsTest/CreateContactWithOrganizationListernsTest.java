package vTiger.ContactsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationListernsTest extends BaseClass{
	@Test(groups = "SmokeSuite")
	public void CreateContactWithOrgBaseTest() throws EncryptedDocumentException, IOException
	{
	
	
	//Step 1: Read Test Data
	String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
	String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
	
	 
	//step 2: navigate to organization
	HomePage hp= new HomePage(driver);
	hp.clickOnOrganizationLink();
	Reporter.log("Organization is clicked",true);
	
	//Step 3: click on create organization lookup image
    OrganizationsPage op= new OrganizationsPage(driver);
    op.ClickOnCreateOrgLookUpImg();
    Reporter.log("Organization lookup image is clicked",true);
    //Assert.fail();
			
    //Step 4: Create new organization with mandatory information and save
	 CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
	 cnop.CreateNewOrganization(ORGNAME);
	 Reporter.log("Organization is created with"+ORGNAME,true); 
     // Assert.fail();
	 
   //Step 5: validation for organization	
     OrganizationInfoPage oip= new OrganizationInfoPage(driver);
     String OrgHeader = oip.getOrganizationHeaderText();
	 Assert.assertTrue(OrgHeader.contains(ORGNAME));
	 
   //step 6: navigate to contacts link
    hp.clickOnContactsLink();
    Reporter.log(" is clicked",true);
    
   //step 7: click on create contact lookup image
   ContactsPage cp= new ContactsPage(driver);
   cp.clickOnCreateContactImg();
   Reporter.log("Contact look up image  is clicked",true);
    
   //step 9:Create new contact with mandatory information 
   CreateNewContactPage cncp =new CreateNewContactPage(driver);
   cncp.createNewContact(LASTNAME, ORGNAME, driver);
   Reporter.log("New contact with orgnaisation is created"+LASTNAME,true);
    
  //step 10:validation for  Contacts
   ContactsInfoPage cip= new ContactsInfoPage(driver);
   String ContactHeader = cip.getContactHeader();
   Assert.assertEquals(ContactHeader.contains(LASTNAME), true);
   
 //step 17: Logout
   hp.LogOutOfApp(driver);
 
	}
	

	@Test(groups = "RegressionSuite")
	public void DemoTest()
	{
		//Assert.fail();
		System.out.println("This is Demo ");
	}

}



