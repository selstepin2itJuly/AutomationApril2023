package pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

private static final Logger logger = LogManager.getLogger(DashboardPage.class);
	
	public MyInfoPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//span[text()='My Info']/ancestor::a[@class='oxd-main-menu-item']")
	private WebElement myInfo;
	
	@FindBy(css="[class='orangehrm-tabs'] a")
	private List<WebElement> sidemenu;
	
	public void clickOnMyInfo()
	{
		myInfo.click();
	}
	
	public int getSideMenuItemCount()
	{
		return sidemenu.size();
	}
	
	public List<String> getSideMenuItems()
	{
		List<String> tmp = new ArrayList<String>();
		for(WebElement e:sidemenu)
		{
			tmp.add(e.getText());
		}
		return tmp;
	}
}
