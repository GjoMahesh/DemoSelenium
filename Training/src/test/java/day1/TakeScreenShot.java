package day1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TakeScreenShot {
  @Test
  public static void capturescreen(WebDriver driver) throws IOException {
	  TakesScreenshot srcshot=(TakesScreenshot)driver;
	  //user getScreenShotAs method to create image file
	  File src = srcshot.getScreenshotAs(OutputType.FILE);
	  
	  // you can also right
	  // File src = ((TakeScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  //use FileUtils class to copy the src file and save it in specified destination
	  FileUtils.copyFile(src, new File("C:\\Users\\Mijo\\selenium Output\\Screenshot\\"+Timestamp()+"screenshot.png"));
	 }
  public static String Timestamp(){
	return new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(new Date());
	  
  }
  
}
