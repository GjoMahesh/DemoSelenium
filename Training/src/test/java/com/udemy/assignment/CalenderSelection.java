package com.udemy.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderSelection {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		// Launch URL
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.findElement(By.cssSelector("#travel_date")).click();
		
		WebElement monthYear= driver.findElement(By.cssSelector("div.datepicker-days th.datepicker-switch"));
		
		monthYear.click();
		
		WebElement year = driver.findElement(By.cssSelector("div.datepicker-months th.datepicker-switch"));
		
		System.out.println(year.getText());
		
		while(!year.getText().contains("2021")) {
			
			driver.findElement(By.cssSelector("div.datepicker-months th.next")).click();
			
		}
		
		List<WebElement> month = driver.findElements(By.cssSelector("div.datepicker-months span.month"));
		
		int monthCount = month.size();
		
		for(int i = 0; i < monthCount; i++) {
			
			String monthText=month.get(i).getText();
			
			if(monthText.contains("Jun")) {
			
			month.get(i).click();
			Thread.sleep(2000L);
			System.out.println(monthText);
			
			break;
			}	
			
		}
		
		
		List<WebElement> dates = driver.findElements(By.cssSelector("div.datepicker-days td.day"));
		
		int dateCount= dates.size();
		 
		for(int i = 0; i < dateCount; i++) {
			
			String dateText = dates.get(i).getText();
			if(dateText.contentEquals("10")) {
			
				System.out.println(dateText);
				dates.get(i).click();
				break;
				
			}
			
		}
		

	}

}
