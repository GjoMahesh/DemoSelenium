package day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UploadTest {
	WebDriver driver;
  @Test
  public void f() {
	  //call the driver from utility package
	  driver=BrowserUtility.GetDrivers("chrome");
	  // To manage timeouts
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("http://demo.guru99.com/test/upload");
	  driver.manage().window().maximize();
	  driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\Public\\Documents\\dgc_DC.txt");
  }
}
