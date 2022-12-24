package createOrganisationTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationBaseClassTest extends BaseClass{
	@Test(groups = "RegressionSuite")
	public void createOrgTest() throws IOException
	{
		
	
	//Step 1:Excel File- TestData
	String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
	
	//Step 2: Click on Organizations Link
	   HomePage hp= new HomePage(driver);
	   hp.clickOnOrganizationLink();
	
	//Step 3: click on create organization lookup image
	OrganizationsPage op= new OrganizationsPage(driver);
	op.ClickOnCreateOrgLookUpImg();

	//Step 4: Create new organization with mandatory information and save 
	CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
	cnop.CreateNewOrganization(ORGNAME);
	
	//Step 5: validation
	OrganizationInfoPage oip= new OrganizationInfoPage(driver);
     String OrgHeader = oip.getOrganizationHeaderText();
     Assert.assertTrue(OrgHeader.contains(ORGNAME));
	
	/* if (OrgHeader.contains(ORGNAME))
	{
		System.out.println(OrgHeader);
		System.out.println("pass");
	}
	else
		System.out.println("fail"); */
	
	
}
	}