package day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MEvent {
	
	WebDriver driver;
	
	
  @Test(priority=1)
  public void testcase1() throws IOException {
	  WebElement aboutus=driver.findElement(By.xpath("//span[contains(text(),'AboutUs')]"));
	  WebElement office=driver.findElement(By.xpath("//span[contains(text(),'Offices')]"));
	  WebElement chennai=driver.findElement(By.xpath("//span[contains(text(),'Chennai')]"));
	  
	  //Implement Actions
	  Actions act1=new Actions(driver);
	  
	  act1.moveToElement(aboutus).moveToElement(office).moveToElement(chennai).build().perform();
	  TakeScreenShot.capturescreen(driver);
	  
  }
  
  @Test(priority=2)
  public void testcase2() throws IOException{
	  driver.findElement(By.partialLinkText("SignIn")).click();
	  Assert.assertTrue(driver.getTitle().contains("Login"));
	  WebElement un=driver.findElement(By.id("userName"));
	  
	  Actions act2=new Actions(driver);
	  act2.moveToElement(un).keyDown(Keys.SHIFT)
	  			.sendKeys("jijo")
	  			.keyUp(Keys.SHIFT)
	  			.doubleClick()
	  			.contextClick()
	  			.build().perform();
	  
	  TakeScreenShot.capturescreen(driver);
	  
	  
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
