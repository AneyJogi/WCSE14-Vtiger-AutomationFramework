package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility
{
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public  CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business Library
	//Method Overloading concept
	
	/**
	 * this method will create organization with mandatory details
	 * @param orgname
	 */
	public void CreateNewOrganization(String orgname)
	{
		OrgNameEdt.sendKeys(orgname);
		saveBtn.click();
	}
	
	/**
	 * This method will create new  organization with industry dropdown
	 * @param OrgName
	 * @param industryType
	 */
	

	public void CreateNewOrganization(String OrgName, String industryType) {
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(IndustryDropDown, industryType);
		saveBtn.click();
		
	}
	 
}
