package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateContactLookUpImg;
	
	

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
	
	//Business Library
	/**
	 * This method is used to click on contact look up image
	 * 
	 */
	public void clickOnCreateContactImg() {
		CreateContactLookUpImg.click();
	}

	

}
