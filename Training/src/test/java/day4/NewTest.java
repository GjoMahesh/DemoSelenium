package day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
		
	// To create the Hub
	//C:\Users\Mijo\grid>java -jar selenium-server-standalone-3.141.59.jar -role hub
	// To create the Node
	//C:\Users\Mijo\grid>java -Dwebdriver.chrome.driver="C:\Users\Mijo\grid\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.29.35:4444/grid/register/ -port 5431
  
	
  @Test
  public void f() throws MalformedURLException {
	  DesiredCapabilities capability=new DesiredCapabilities();
	  //set the Browser and Platform
	  capability.setBrowserName("chrome");
	  capability.setPlatform(Platform.WINDOWS);
	  
	  //RemoteWebDriver user to run your test on node machine
	  driver=new RemoteWebDriver(new URL("http://localhost:5431/wd/hub"),capability);
	  driver.get("http://demowebshop.tricentis.com/");
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
