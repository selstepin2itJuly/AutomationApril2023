package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {
	
	private static final Logger logger = LogManager.getLogger(TestBase.class);
	public static WebDriver driver;
	public static String browser;
	public static Properties prop;
	
	public static WebDriver getDriver() throws IOException
	{
		prop = new Properties();
		String config="./src/main/resources/config/config.properties";
		logger.info("configuration file:"+config.toString());
		FileInputStream inStream = new FileInputStream(new File(config));
		prop.load(inStream);
		browser=prop.getProperty("browser");
		logger.info("Browser:"+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
		
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeAgent"));
			driver= new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions opt = new FirefoxOptions();
		    opt.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxAgent"));
			driver= new FirefoxDriver(opt);
		} else if(browser.equalsIgnoreCase("edge")){
			ChromeOptions opt = new ChromeOptions();
		
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgeAgent"));
			driver= new EdgeDriver();
		}else {
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
		logger.info("URL"+prop.getProperty("url"));
		return driver;
	}
}
