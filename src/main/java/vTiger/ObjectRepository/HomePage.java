package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	// Inizialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	//Business Library
	/**
	 * this method will click on organizations link in home page
	 */
	public void clickOnOrganizationLink()
	{
		OrganizationsLink.click();
		
	}
	
/**
 * this method will click on contacts link in home page
 */
   public void clickOnContactsLink()
   {
	ContactsLink.click();
   }
   
   /**
    *  this method will sign out from application
    * @param driver
    */
   public void LogOutOfApp(WebDriver driver)
   {
	mouseHoverAction(driver, AdministratorImg);
	SignOutLink.click();
   }
}