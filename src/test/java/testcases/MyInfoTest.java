package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.asserts.SoftAssert;

public class MyInfoTest {
	
private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	WebDriver dr; 
	LoginPage lp;
	DashboardPage dp;
	MyInfoPage mip;
	
  @Test(priority=1, description="My Info Menu Count")
  public void verifyMyInfoSideMenuItemCount() {
	  int act = mip.getSideMenuItemCount();
	  TestUtility.attachImages();
	  Reporter.log(act+"--->"+11);
	  Assert.assertEquals(act, 11);
	  
  }
  @Test(enabled=true)
  public void verifyMyInfoSideMenuItemsText() {
	  List<String> act = mip.getSideMenuItems();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Personal Details");
	  exp.add("Contact Details");
	  exp.add("Emergency Contacts");
	  exp.add("Dependents");
	  exp.add("Immigration");
	  exp.add("Job");
	  exp.add("Salary");
	  exp.add("Tax exemptions");
	  exp.add("Report-to");
	  exp.add("qualifications");
	  exp.add("Memberhips");
	  SoftAssert sa = new SoftAssert();
	  for(int i=0;i<exp.size();i++)
	  {
		  sa.assertEquals(act.get(i), exp.get(i));
		  Reporter.log(act.get(i)+"-->"+exp.get(i));
	  }
	  
	  sa.assertAll();
	  TestUtility.attachImages();
	 
  }
  
  @BeforeClass
  public void beforeClass() throws IOException 
  {
	  dr = TestBase.getDriver();
	  TestUtility.attachImages();
	  logger.info("Initializing WebDriver Page");
	  lp = new LoginPage(dr);
	  logger.info("Initializing Login Page");
	  dp = new DashboardPage(dr);
	  logger.info("Initializing Dashboard Page");
	  mip = new MyInfoPage(dr);
	  logger.info("Initializing MyInFo Page");
	  TestUtility.attachImages();
	  lp.loginToApplication("Admin", "admin123");
	  Assert.assertTrue(dp.isDashboardDisplayed());
	  mip.clickOnMyInfo();
	  TestUtility.attachImages();
  }

  @AfterClass
  public void afterClass() {
	  dr.quit();
  }

}
