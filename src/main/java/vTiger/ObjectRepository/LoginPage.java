package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule1
	
	
	//Rule2: -Declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	//Rule 3: Initialization
	public LoginPage(WebDriver driver)
	{
	 PageFactory.initElements(driver,this);
	}

	//Rrle 4:
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	// Rule 5:Business Libraries
	/**
	 * This business library will perform login action
	 * @param Username
	 * @param Password
	 */
	public void LoginToApp(String Username,String Password)
	{
		usernameEdt.sendKeys(Username);
		passwordEdt.sendKeys(Password);
		submitBtn.click();
	}
	
}
