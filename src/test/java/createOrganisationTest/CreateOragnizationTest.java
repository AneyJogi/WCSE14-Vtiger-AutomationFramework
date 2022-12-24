package createOrganisationTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOragnizationTest 
 {
	@Test
	public void createOrgTest() throws IOException
	{
		
	
	//Step 1: Create all the Objects
	PropertyFileUtility pUtil = new PropertyFileUtility();
	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	/*Property File - Common Data*/
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	/*Excel File - Test Data*/
	String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
	
	WebDriver driver = null;
	
	
	//Step 2: Launch Browser - run time polymorphism - driver
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browser name");
	}
	
	wUtil.maximiseWindow(driver);
	wUtil.waitForPageLoad(driver);
	driver.get(URL);
	
	//Step 3: Login To Application
      LoginPage lp= new LoginPage(driver);
      lp.LoginToApp(USERNAME, PASSWORD);
	
	//Step 4: Click on Organisations Link
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