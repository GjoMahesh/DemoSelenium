package com.udemy.selenium.day1;

import org.testng.annotations.Test;

import day1.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class FrameTest {
	WebDriver driver;
  @Test
  public void f() {
	  driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));

	  driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
	  
	  System.out.println(driver.findElement(By.cssSelector("div#content")).getText());
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=BrowserUtility.GetDrivers("chrome");
	  driver.get("https://the-internet.herokuapp.com/nested_frames");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
