package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}
	
	//No findElment required in pagefactory
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(css="input[placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement errorMsg;
	
	public LoginPage enterUsername(String user)
	{
		username.sendKeys(user);
		return this;
	}

	public LoginPage enterPassword(String user)
	{
		password.sendKeys(user);
		return this;
	}
	
	public LoginPage clickOnLoginButton()
	{
		loginButton.click();
		return this;
	}
	
	public boolean isErrorMessageDisplayed()
	{
		boolean temp=false;
		try {
			temp = errorMsg.isDisplayed();
		}catch(Exception e)
		{
			e.getMessage();
		}
		return temp;
	}
	
	public void loginToApplication(String user, String pass)
	{
		enterUsername(user)
		.enterPassword(pass)
		.clickOnLoginButton();
	}
	
}
