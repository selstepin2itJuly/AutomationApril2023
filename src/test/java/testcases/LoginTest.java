package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	WebDriver dr; 
	LoginPage lp;
	DashboardPage dp;
	
  @Test
  public void verifyLoginSuccess_001() {
	  logger.info("Verify Login Success");
	  lp.enterUsername("Admin")
		.enterPassword("admin123")
		.clickOnLoginButton();
	  logger.info("Assertion for Dashboard Msg display");
	  TestUtility.attachImages();
	  Assert.assertTrue(dp.isDashboardDisplayed());
	  dp.logout();
	  TestUtility.attachImages();
  }
  
  @Test
  public void verifyLoginUnsuccessfull_002()
  {
	  logger.info("Verify Login Unsuccessful");
	  lp.enterUsername("Admin")
		.enterPassword("admin1234")
		.clickOnLoginButton();
	  logger.info("Assertion for Error Msg display");
	  TestUtility.attachImages();
	  Assert.assertTrue(lp.isErrorMessageDisplayed());
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  dr = TestBase.getDriver();
	  logger.info("Initializing WebDriver Page");
	  lp = new LoginPage(dr);
	  logger.info("Initializing Login Page");
	  dp = new DashboardPage(dr);
	  logger.info("Initializing Dashboard Page");
  }

  @AfterMethod
  public void afterMethod() {
	  dr.quit();
  }

}
