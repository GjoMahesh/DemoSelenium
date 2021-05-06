package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserUtility {
  @Test
  public static WebDriver GetDrivers(String browsername) {
	  if(browsername.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		  return new ChromeDriver();
	  }else if(browsername.equalsIgnoreCase("IE")) {
		  return null;
		 
	  }
	  return null;
  }
}
