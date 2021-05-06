package com.udemy.selenium.day1;

import org.testng.annotations.Test;

import day1.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class WindowHandlesTest {
	WebDriver driver;

	@Test
	public void f() {

		driver.findElement(By.cssSelector(".blinkingText")).click();

		Set<String> objWindows = driver.getWindowHandles();

		Iterator<String> strWindowId = objWindows.iterator();
		String strPraentWindowId = strWindowId.next();
		String strChildWindowId = strWindowId.next();

		driver.switchTo().window(strChildWindowId);

		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		String strEmail = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];

		driver.switchTo().window(strPraentWindowId);
		driver.findElement(By.cssSelector("input#username")).sendKeys(strEmail);

	}

	@BeforeTest
	public void beforeTest() {
		driver = BrowserUtility.GetDrivers("chrome");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
	}

}
