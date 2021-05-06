package com.udemy.assignment;

import org.testng.annotations.Test;

import day1.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class WaitAssignment {
	WebDriver driver;
  @Test
  public void f() {
	  
	  WebDriverWait explictWait= new WebDriverWait(driver,5);
	  
	  driver.findElement(By.partialLinkText("Click to load")).click();
	  explictWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#results"))));
	  System.out.println(driver.findElement(By.cssSelector("div#results")).getText());
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=BrowserUtility.GetDrivers("chrome");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
