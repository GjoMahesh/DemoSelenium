package com.udemy.assignment;

import org.testng.annotations.Test;

import day1.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MultiUseValue {
  WebDriver driver;
  @Test
  public void f() {
	  
	  WebElement chkOptValue=driver.findElement(By.xpath("//label[@for='benz']/input"));
	  chkOptValue.click();
	  
	  WebElement chkOptLabel=driver.findElement(By.xpath("//label[@for='benz']"));
	  String strChkValue=chkOptLabel.getText();
	  System.out.println(strChkValue);
	  
	  Select option=new Select(driver.findElement(By.id("dropdown-class-example")));
	  option.selectByVisibleText(strChkValue);
	  

	  driver.findElement(By.id("name")).sendKeys(strChkValue);
	  driver.findElement(By.id("alertbtn")).click();
	  
	  Assert.assertTrue(driver.switchTo().alert().getText().contains(strChkValue));
	  System.out.println(driver.switchTo().alert().getText());
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=BrowserUtility.GetDrivers("chrome");
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
