package day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class JavaScriptExecutorTest {
	WebDriver driver;
  @Test
  public void f() throws IOException {
	  //JavaScriptExecutor for scroll by
	  driver.findElement(By.partialLinkText("SignUp")).click();
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,50)");
	  
	  //TakeScreenshot after we Scrolled
	  TakeScreenShot.capturescreen(driver);
	  
	  //user javascriptsExecutor for creating Alerts
	  js.executeScript("alert('welcome to selenium 3 plus');");
	  String text=driver.switchTo().alert().getText();
	  System.out.println("Alert text:"+text);
	  if(text.contains("Selenium 3 pluse")) {
		  driver.switchTo().alert().accept();
	  }
	  //use JavascriptsExecutor for returning the title of web page
	  String title=js.executeScript("return document.title;").toString();
	  System.out.println("Title of the page is:" + title);
	  
	  //use JavascriptExecutor for finding an element
	  WebElement un=driver.findElement(By.name("userName"));
	  js.executeScript("arguments[0]", un);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=BrowserUtility.GetDrivers("chrome");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://lkmdemouat.accenture.com/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
