package day2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import day1.BrowserUtility;

public class cookiesTest {
	WebDriver driver;

  @Test
  public void f() {
	  driver=BrowserUtility.GetDrivers("chrome");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://lkmdemoaut.accenture.com/TesstMeApp/fetch.htm");
	  Cookie addcookie=new Cookie("username","TestMeApp");
	  driver.manage().addCookie(addcookie);
	  
	  driver.manage().deleteAllCookies();
	  
	  Set<Cookie> cookieslist = driver.manage().getCookies();
	  for(Cookie c:cookieslist) {
		  System.out.println("Cookie Name:" + c.getName()+
				  "Cookie value:" +c.getValue()+
				  "Cookie Expiry:" +c.getExpiry()+
				  "Cookie Domain:" +c.getDomain()+
				  "Cookie Path:" +c.getPath());
		  
	  }
	  driver.close();
  }
}
