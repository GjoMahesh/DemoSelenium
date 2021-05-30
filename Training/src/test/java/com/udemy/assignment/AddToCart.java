package com.udemy.assignment;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import day1.BrowserUtility;

public class AddToCart {

		
		WebDriver driver;

	@Test(priority=1)
	public void login() {
		driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
		
		WebElement un=driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
		  
		  Actions act2=new Actions(driver);
		  act2.moveToElement(un).build().perform();
		  
		 
//		WebDriverWait SignInWait= new WebDriverWait(driver,5);  
//		SignInWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Sign in']"))));
		
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		  
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Sapr7124@gmail.com");
		driver.findElement(By.cssSelector("input#continue")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Mohammedsha27@");
		driver.findElement(By.cssSelector("input#signInSubmit")).click();
		
	}
	
	@Test(priority=2)
	public void SearchProduct() {
		 Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Cart')]")).isDisplayed());
		 
		 driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Monitor");
		 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']/parent::div/parent::div/following-sibling::div/div/span/input[@type='submit']")).click();
		 
	}
	
	@Test(priority=3)
	public void AddtoCart(){
//		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Showing results for ']/parent::div/parent::div/parent::span/parent::div/following-sibling::div")).isDisplayed());
//		driver.findElement(By.xpath("//span[text()='Showing results for ']/parent::div/parent::div/parent::span/parent::div/following-sibling::div")).click();
		
		
		WebElement product= driver.findElement(By.xpath("//span[@aria-label=\"Amazon's Choice\"]/parent::div/parent::div/following-sibling::div/div[2]/div/div[1]/h2/a"));
		Assert.assertTrue(product.isDisplayed());
		product.click();
		
		
		  //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
 
        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                
            }
        }
		
		WebDriverWait Cart= new WebDriverWait(driver,10);  
		Cart.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='add-to-cart-button']"))));
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
//		 driver.switchTo().frame(driver.findElement(By.xpath("//frame[@id='attach-view-cart-button-form']")));
//		Cart.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='attach-view-cart-button-form']/span/span"))));
//		 driver.findElement(By.xpath("//form[@id='attach-view-cart-button-form']/span/span")).click();//span/preceding-sibling::input
		 
		 WebElement CartBtn=driver.findElement(By.xpath("//span[contains(text(),'Cart')]/preceding-sibling::input[contains(@aria-labelledby,'attach-sidesheet-view-cart-button-announce')]"));
		 driver.switchTo().defaultContent();
		 CartBtn.click();
		 
//		 int size = driver.findElements(By.tagName("iframe")).size();
//		 int i =0;
//		 while(i<=size) {
//			 driver.switchTo().frame(i);
//			 if(CartBtn.isDisplayed()) {
//				 CartBtn.click();
//				 break;
//			 }
//			 i++;
//		 }
		
		
		 String actualTitle=driver.getTitle();
		 String expectedTitle="Amazon.in Shopping Cart";
		 assertEquals(actualTitle, expectedTitle);
	}
	
	
	
	@BeforeTest
	public void beforeTest() {
		driver = BrowserUtility.GetDrivers("chrome");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
//		driver.close();
	}

}
