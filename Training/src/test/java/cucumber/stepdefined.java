package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import day1.BrowserUtility;

public class stepdefined {
WebDriver driver;

@Given("User launch testmeapp on chrome browser")
public void user_launch_testmeapp_on_chrome_browser() {
    // Write code here that turns the phrase above into concrete actions
	driver=BrowserUtility.GetDrivers("chrome");
	driver.get("http://demowebshop.tricentis.com/");
//    throw new cucumber.api.PendingException();
    
}

@When("User navigates to login screen")
public void user_navigates_to_login_screen() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.partialLinkText("Log in")).click();
//    throw new cucumber.api.PendingException();
}

@When("User enters login credentials like username and password")
public void user_enters_login_credentials_like_username_and_password() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("Email")).sendKeys("jijo");
	driver.findElement(By.id("Password")).sendKeys("summa");
//    throw new cucumber.api.PendingException();
}

@When("User clicks on login button")
public void user_clicks_on_login_button() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.cssSelector("input[type='Submit']")).click();
//    throw new cucumber.api.PendingException();
}

@Then("User verify login success")
public void user_verify_login_success() {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertEquals(driver.getTitle(), "Demo");
//    throw new cucumber.api.PendingException();
}

@And("User close the browser")
public void user_close_the_browser() {
    // Write code here that turns the phrase above into concrete actions
	driver.close();
//    throw new cucumber.api.PendingException();
}
	
}
