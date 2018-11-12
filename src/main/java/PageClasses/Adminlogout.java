package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Adminlogout 
{
	WebDriver driver;
	Actions ac;
	public Adminlogout(WebDriver driver)
	{
	this.driver=driver;
	}
		@FindBy(xpath="//*[text()='Welcome Admin']")
		WebElement click_welcome;
		
		@FindBy(xpath="//*[text()='Logout']")
		WebElement click_logout;
	public void Verify_logout() throws InterruptedException
	{
			ac=new Actions(driver);
			ac.moveToElement(click_welcome).click().perform();
			Thread.sleep(4000);
			ac.moveToElement(click_logout).click().perform();
			Thread.sleep(4000);
	}
}
