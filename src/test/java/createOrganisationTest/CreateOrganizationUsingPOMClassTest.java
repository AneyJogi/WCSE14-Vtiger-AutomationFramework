package createOrganisationTest;

import java.io.IOException;

import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationUsingPOMClassTest extends BaseClass {

	@Test 
	public void CreateOrganizationPOMTest() throws IOException {
		
		
		/*Excel File - Test Data*/
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();

		
		//Step 4: Click on Organizations Link
		   HomePage hp= new HomePage(driver);
		   hp.clickOnOrganizationLink();
		
		//Step 5: click on create organization lookup image
		OrganizationsPage op= new OrganizationsPage(driver);
		op.ClickOnCreateOrgLookUpImg();

		//Step 6: Create new organization with mandatory information and save 
		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.CreateNewOrganization(ORGNAME);
		
		//Step 7: validation
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
         String OrgHeader = oip.getOrganizationHeaderText();
		
		if (OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("pass");
		}
		else
			System.out.println("fail");
		
		//Step 8: logout
				hp.LogOutOfApp(driver);
		
	}

}
