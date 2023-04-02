package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase{

	
	public static void scrollToElement(WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(false);", ele); //default is true 
		je.executeScript("scrollBy(0,300)", "");
	}
	
	public static void scrollToElementAction(WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.scrollToElement(ele).perform();
		((JavascriptExecutor)driver).executeScript("scrollBy(0,300)", "");
	}
	public static void clickOnElementAction(WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.click(ele).perform();
	}
	
	public static void captureScreeshot() throws IOException
	{
		File src=new File("screenshot/images");
		if(!src.isDirectory())
		{
			src.mkdirs();
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(src+"/"+getDate()+"_image.png"));
		getDate();

	}
	
	public static void attachImages()
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String file = ts.getScreenshotAs(OutputType.BASE64);
		String tag = "<img src=\"data:image/jpg;base64,"+file+"\" height=\"500\" width=\"800\" />";
		Reporter.log(tag);
	}
	private static String getDate()
	{
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss_SSS");
		String ss= sdf.format(dt);
		System.out.println(ss);
		return ss;
		
	}
	
}
