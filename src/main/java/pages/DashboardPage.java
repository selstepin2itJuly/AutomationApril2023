package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage {
	private static final Logger logger = LogManager.getLogger(DashboardPage.class);
	
	public DashboardPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboardheader;
	
	@FindBy(css="[class='oxd-userdropdown-name']")
	private WebElement profile;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	public boolean isDashboardDisplayed()
	{
		boolean temp=false;
		try {
			temp = dashboardheader.isDisplayed();
		}catch(Exception e)
		{
			e.getMessage();
		}
		return temp;
	}
	
	public void logout()
	{
		profile.click();
		logout.click();
	}
}
