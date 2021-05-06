package com.udemy.selenium.day1;

import org.testng.annotations.Test;

import day1.BrowserUtility;
import day1.TakeScreenShot;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class AddToCartXpathStyle {
	WebDriver driver;

	@Test
	public void f() throws IOException, InterruptedException {
		String[] strProductToBeAdded = { "Brocolli", "Cucumber", "Beetroot" };

		for (int i = 0; i <= strProductToBeAdded.length; i++) {
			driver.findElement(By.xpath("//div[@class='product']/h4[contains(text(),'" + strProductToBeAdded[i]
					+ "')]/following-sibling::div[@class='product-action']/button")).click();
			Thread.sleep(2000);
			TakeScreenShot.capturescreen(driver);
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = BrowserUtility.GetDrivers("chrome");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
//		driver.close();
	}

}
