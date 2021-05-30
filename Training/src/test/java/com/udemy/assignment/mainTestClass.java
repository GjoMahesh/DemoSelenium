package com.udemy.assignment;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import day1.BrowserUtility;
class TestClass1 implements Runnable {
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "chrome");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
    	capsHashtable.put("build", "browserstack-build-1");
		capsHashtable.put("name", "Thread 1");
		mainTestClass r1 = new mainTestClass();
		r1.executeTest(capsHashtable);
    }
}
class TestClass2 implements Runnable {
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "firefox");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
		capsHashtable.put("build", "browserstack-build-1");
		capsHashtable.put("name", "Thread 2");
		mainTestClass r2 = new mainTestClass();
    	r2.executeTest(capsHashtable);
  	}
}
class TestClass3 implements Runnable {
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "safari");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "OS X");
		capsHashtable.put("os_version", "Big Sur");
		capsHashtable.put("build", "browserstack-build-1");
		capsHashtable.put("name", "Thread 3");
		mainTestClass r3 = new mainTestClass();
    	r3.executeTest(capsHashtable);
  	}
}
public class mainTestClass {
	public static final String USERNAME = "jijomahesh_ZxE1s9";
	public static final String AUTOMATE_KEY = "2ksacipme8znezGEpQfL";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static void main(String[] args) throws Exception {
		Thread object1 = new Thread(new TestClass1());
		object1.start();
//		Thread object2 = new Thread(new TestClass2());
//		object2.start();
//		Thread object3 = new Thread(new TestClass3());
//		object3.start();
  	}
	public void executeTest(Hashtable<String, String> capsHashtable) {
		String key;
		DesiredCapabilities caps = new DesiredCapabilities();
		// Iterate over the hash table and set the capabilities
		Set<String> keys = capsHashtable.keySet();
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext()) {
       		key = itr.next();
       		caps.setCapability(key, capsHashtable.get(key));
    	}
    	WebDriver driver;
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.get("https://www.amazon.in/");
			driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
    		
    		WebElement un=driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
    		  
    		  Actions act2=new Actions(driver);
    		  act2.moveToElement(un).build().perform();
    		  
    		 
    		WebDriverWait SignInWait= new WebDriverWait(driver,5);  
    		SignInWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Sign in']"))));
    		
    		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
    		  
    		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Sapr7124@gmail.com");
    		driver.findElement(By.cssSelector("input#continue")).click();
    		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Mohammedsha27@");
    		driver.findElement(By.cssSelector("input#signInSubmit")).click();
    		
    	
    	
    	
    	
    		 Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Cart')]")).isDisplayed());
    		 
    		 driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Monitor");
    		 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']/parent::div/parent::div/following-sibling::div/div/span/input[@type='submit']")).click();
    		 
    	
    	
    
    
//    		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Showing results for ']/parent::div/parent::div/parent::span/parent::div/following-sibling::div")).isDisplayed());
//    		driver.findElement(By.xpath("//span[text()='Showing results for ']/parent::div/parent::div/parent::span/parent::div/following-sibling::div")).click();
    		
    		
    		WebElement product= driver.findElement(By.xpath("//span[@aria-label=\"Amazon's Choice\"]/parent::div/parent::div/following-sibling::div/div[2]/div/div[1]/h2/a"));
    		Assert.assertTrue(product.isDisplayed());
    		product.click();
    		
    		
    		  //Get handles of the windows
            String mainWindowHandle = driver.getWindowHandle();
            Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> iterator = allWindowHandles.iterator();
     
            // Here we will check if child window has other child windows and will fetch the heading of the child window
            String ActiveWindow = null;
            while (iterator.hasNext()) {
                String ChildWindow = iterator.next();
                    if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    ActiveWindow = ChildWindow;
                }
            }
           
    		
    		WebDriverWait Cart= new WebDriverWait(driver,5);  
    		Cart.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='add-to-cart-button']"))));
    		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    		
//    		 driver.switchTo().frame(driver.findElement(By.xpath("//frame[@id='attach-view-cart-button-form']")));
    		
//    		Cart.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Cart')]/preceding-sibling::input[contains(@aria-labelledby,'attach-sidesheet-view-cart-button-announce')]"))));
//    		driver.findElement(By.xpath("//span[contains(text(),'Cart')]/preceding-sibling::input[contains(@aria-labelledby,'attach-sidesheet-view-cart-button-announce')]")).click();//*[@*='attach-view-cart-button-form']/span/span/span//span/preceding-sibling::input
    		
    		String WindowHandle = driver.getWindowHandle();
    		Set<String> allwindowHandles = driver.getWindowHandles();
//            Iterator<String> windowIterator = allWindowHandles.iterator();
    		System.out.println(allwindowHandles.size());
    		System.out.println(driver.getTitle());
    		if(WindowHandle.equalsIgnoreCase(ActiveWindow)) {
    			System.out.println(driver.getTitle());
    		}
    
    		
   		 WebElement CartBtn=driver.findElement(By.xpath("//span[contains(text(),'Cart')]/preceding-sibling::input[contains(@aria-labelledby,'attach-sidesheet-view-cart-button-announce')]"));
   		 driver.switchTo().defaultContent();
   		 CartBtn.click();
    		
    		
    		
//    		WebElement CartBtn=driver.findElement(By.xpath("//span[contains(text(),'Cart')]/preceding-sibling::input[contains(@aria-labelledby,'attach-sidesheet-view-cart-button-announce')]"));
//    		 
//    		 int size = driver.findElements(By.tagName("iframe")).size();
//    		 int i =0;
//    		 while(i<=size) {
//    			 driver.switchTo().frame(i);
//    			 if(CartBtn.isDisplayed()) {
//    				 CartBtn.click();
//    				 break;
//    			 }
//    			 i++;
//    		 }
//    		
    		
    		 String actualTitle=driver.getTitle();
    		 String expectedTitle="Amazon.in Shopping Cart";
    		 assertEquals(actualTitle, expectedTitle);
    		 
    		
	    	System.out.println(driver.getTitle());
	    	driver.quit();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
	}}	
    	
//    	
    		
    	
	
    	
	
