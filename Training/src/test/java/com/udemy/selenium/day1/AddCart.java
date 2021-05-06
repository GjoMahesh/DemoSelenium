package com.udemy.selenium.day1;

import org.testng.annotations.Test;

import day1.BrowserUtility;
import day1.TakeScreenShot;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class AddCart {
	WebDriver driver;

	@Test
	public void f() throws IOException, InterruptedException {

		String[] arrProductToBeAdded = { "Cucumber", "Brocolli", "Beetroot" };

		// save all the products in the list from Web site
		List<WebElement> lstAllProductName = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < lstAllProductName.size(); i++) {

			// split the lstAllProductName (cucumber | 1 KG)
			String[] strSplitedProductName = lstAllProductName.get(i).getText().split("-"); // index[0] is
																							// strSplitedProductName

			// get the product name and save it in strProductName variable
			String strFormatedProductName = strSplitedProductName[0].trim(); // Example : Cucumber, Beetroot,

			// changing arrProductToBeAdded to List, because List data type have contains.
			// it good practice to declare variable as String(less memory) and convert it to
			// List(use more memory then string) in Run Time.
			List<String> lstProductToBeAdded = Arrays.asList(arrProductToBeAdded);

			if (lstProductToBeAdded.contains(strFormatedProductName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				Thread.sleep(2000);
				TakeScreenShot.capturescreen(driver);
				if (j==arrProductToBeAdded.length){
					break;
				}
			}
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
