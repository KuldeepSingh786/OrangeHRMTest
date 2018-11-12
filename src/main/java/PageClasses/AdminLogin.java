package PageClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AdminLogin {
WebDriver driver;

	public AdminLogin(WebDriver driver)
	{
		this.driver = driver;
	}
	//define locators
		@FindBy(name="txtUsername")
		WebElement enter_username;
		
		@FindBy(name="txtPassword")
		WebElement enter_password;
		
		@FindBy(name="Submit")
		WebElement Click_login;
		
		public void Verify_Login(String username,String password)
		{
			this.enter_username.sendKeys(username);	
			this.enter_password.sendKeys(password);
			this.Click_login.click();
		}
}
