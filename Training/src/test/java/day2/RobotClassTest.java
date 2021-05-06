package day2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import day1.BrowserUtility;
import day1.TakeScreenShot;

public class RobotClassTest {
	WebDriver driver;
	@Test
  public void f() throws AWTException, InterruptedException, IOException {
		driver=BrowserUtility.GetDrivers("chrome");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.edureka.co/");
		driver.manage().window().maximize();
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.mouseMove(50, 50);
		TakeScreenShot.capturescreen(driver);
		driver.close();
		
		
  }
}
