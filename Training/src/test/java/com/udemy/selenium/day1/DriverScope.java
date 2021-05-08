package com.udemy.selenium.day1;

import org.testng.annotations.Test;

import day1.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class DriverScope {
	WebDriver driver;
  @Test
  public void f() {
	  
	  WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
	  WebElement linkDriver=footerDriver.findElement(By.xpath("//tr/td/ul[1]"));
	  
	  System.out.println(footerDriver.findElements(By.tagName("a")).size());
	  System.out.println(linkDriver.findElements(By.tagName("a")).size());
	  
	 for(int i=1; i<linkDriver.findElements(By.tagName("a")).size(); i++ ) {
		
		 System.out.println(linkDriver.findElements(By.tagName("a")).get(i).getText()); 
		 String strClickLinks=Keys.chord(Keys.CONTROL,Keys.ENTER);
		 linkDriver.findElements(By.tagName("a")).get(i).sendKeys(strClickLinks);
		 
	 }
	 
	 Set<String> strWindows=driver.getWindowHandles();
	 Iterator<String> strWindowID=strWindows.iterator();
	 
	 while(strWindowID.hasNext()) {
		 driver.switchTo().window(strWindowID.next());
		 System.out.println(driver.getTitle());
	 }
	  
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
