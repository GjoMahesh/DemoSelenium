package day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class HomepageFactory extends LoadableComponent<HomepageFactory>{
	// LoadableComponent is predefined Class
	// it will implement  load() and isLoaded() methods
	// it use to find weather we navigated to correct URL
	public WebDriver driver;
	
	public HomepageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(partialLinkText="Log in") public WebElement loginlink;
	@FindBy(linkText="Register") public WebElement registerlink;
	
	
	public void loginlink_click() {
		loginlink.click();
	}
	
	public void registerlink_click() {
		registerlink.click();
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get("http://demowebshop.tricentis.com/");
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("demo"));
	}
		

}
