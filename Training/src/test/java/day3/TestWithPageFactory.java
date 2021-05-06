package day3;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import day1.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestWithPageFactory {
	
	public static final Logger LOGGER=(Logger) LogManager.getLogger(TestWithPageFactory.class.getName());
	WebDriver driver;
	public static HomepageFactory hpf;
	public static RegisterPageFactory rpf;
	ExtentSparkReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	
  @Test(priority=0)
  public void tc01() {
	  logger=extent.createTest("This is my TC01");
	  logger.log(Status.INFO, MarkupHelper.createLabel("Running TC01", ExtentColor.INDIGO));
	  hpf.get(); // it call Load and isLoaded() method automatically by implemting Loadable Compent class
	  
  }
  
  @Test(priority=1)
  public void tc02() {
	  logger=extent.createTest("This is my TC02");
	  logger.log(Status.INFO, MarkupHelper.createLabel("Running TC02", ExtentColor.INDIGO));
	  hpf.registerlink_click();
	  rpf.register("saranya", "Shanumugam", "saranya@gmail.com");
//	  Assert.assertEquals(driver.getTitle(), "Home"); // wantedly failing this testcase
	  
	  
  }
  
  @AfterMethod
  public void getResults(ITestResult result) throws IOException {
	  if(result.getStatus()==ITestResult.SUCCESS) {
		  logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed: " + result.getName(), ExtentColor.GREEN));
	  }else if(result.getStatus()==ITestResult.SKIP) {
		  logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Skipped: " + result.getName(), ExtentColor.YELLOW));
	  }else if(result.getStatus()==ITestResult.FAILURE) {
		  logger.log(Status.FAIL, MarkupHelper.createLabel("Test Case Failed: " + result.getName(), ExtentColor.RED));
		  TakesScreenshot srcshot=(TakesScreenshot)driver;
		  File src=srcshot.getScreenshotAs(OutputType.FILE);
		  String imagePath = "C:\\Users\\Mijo\\selenium Output\\Screenshot\\" + result.getName()+ ".png";
		  
		  FileUtils.copyFile(src, new File(imagePath));
		  
		  logger.addScreenCaptureFromPath(imagePath, result.getName());
	  }
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver=BrowserUtility.GetDrivers("chrome");
	  hpf=PageFactory.initElements(driver, HomepageFactory.class);
	  rpf=PageFactory.initElements(driver, RegisterPageFactory.class);
	  
	  //initialize Extent Report class
	  
	  reporter=new ExtentSparkReporter("C:\\Users\\Mijo\\selenium Output\\Report\\MyReport.html");
	  extent=new ExtentReports();
	  extent.attachReporter(reporter);
	  extent.setSystemInfo("Created by:", "Jijo Mahesh");
	  extent.setSystemInfo("Environment", "Funcitonal Testing");
	  extent.setSystemInfo("Platform", "WIN 10");
	  
	  reporter.config().setDocumentTitle("My ExtentReport");
	  reporter.config().setReportName("Extent Report");
	  reporter.config().setTheme(Theme.STANDARD);
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
