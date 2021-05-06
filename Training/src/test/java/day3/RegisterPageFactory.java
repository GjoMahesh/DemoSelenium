package day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageFactory {
	public WebDriver driver;
	
	public RegisterPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="gender-female") WebElement gender;
	@FindBy(id="FirstName") WebElement fn;
	@FindBy(id="LastName") WebElement ln;
	@FindBy(name="Email") WebElement email;
	
	public void register(String firstname, String lastname, String emailid) {
		gender.click();
		fn.sendKeys(firstname);
		ln.sendKeys(lastname);
		email.sendKeys(emailid);
		
	}
	
}
