package day2;

import org.testng.annotations.Test;

import day1.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ExcelFileTest {
	WebDriver driver;
	
  @Test
  public void f() throws IOException {
	  //access the excel
	  FileInputStream file=new FileInputStream("C:\\selenium\\logindata.xlsx");
	  
	  //use XSSFWorkbook
	  XSSFWorkbook wb=new XSSFWorkbook(file);
	  
	  //use XSSFSheet to access the sheet
	  XSSFSheet sh=wb.getSheet("Sheet1");
	  
	  //access cell data
	  String un=sh.getRow(0).getCell(0).getStringCellValue();
	  String psd=sh.getRow(0).getCell(1).getStringCellValue();
	  
	  System.out.println(un+"---------"+psd);
	  
	  // To know how many rows
	  int rc=sh.getLastRowNum();
	  System.out.println("Get Last row number is: " + rc); // start from 0
	  int phyrc=sh.getPhysicalNumberOfRows();
	  System.out.println("Get Physical Number of Row is "+ phyrc); // start from 1
	  
	  //for loop to iterate all the row and column data
	  for(int i=1; i<=rc; i++) {
		  String username=sh.getRow(i).getCell(0).getStringCellValue();
		  String password=sh.getRow(i).getCell(1).getStringCellValue();
		  
		  System.out.println(username+"---------"+password);
		  
		  driver.findElement(By.name("username")).sendKeys(username);
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.name("Login")).click();
		  if(driver.getTitle().contains("Home")) {
			  driver.navigate().back();
			  sh.getRow(i).createCell(2).setCellValue("Valid User");
			  FileOutputStream fo=new FileOutputStream("C:\\selenium\\logindata.xlsx");
			  wb.write(fo);
			  
		  }else {
			  driver.navigate().refresh();
			  sh.getRow(i).createCell(2).setCellValue("Invalid User");
			  FileOutputStream fo=new FileOutputStream("C:\\selenium\\logindate.xlsx");
			  wb.write(fo);
		  }
	  
		  wb.close();
	  }
	  
	  
			  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=BrowserUtility.GetDrivers("chrome");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://lkmdemouat.accenture.com/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
