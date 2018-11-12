package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EmpCreation
{
	WebDriver driver;
	Actions ac;
	
	public EmpCreation(WebDriver driver)
	{
		this.driver=driver;
	}
		@FindBy(id="menu_pim_viewPimModule")
		WebElement click_pim;
		
		@FindBy(id="btnAdd")
		WebElement click_add;
		
		@FindBy(id="firstName")
		WebElement Enter_fname;
		
		@FindBy(id="lastName")
		WebElement Enter_lname;
		
		@FindBy(id="employeeId")
		WebElement Enter_eid;
		
		@FindBy(id="btnSave")
		WebElement click_save;
		
	public void Verify_emp(String fname,String lname,String eid) throws InterruptedException
	{
		ac=new Actions(driver);
		ac.moveToElement(click_pim).click().perform();
		Thread.sleep(3000);
		ac.moveToElement(click_add).click().perform();
		Thread.sleep(3000);
		this.Enter_fname.sendKeys(fname);
		this.Enter_lname.sendKeys(lname);
		this.Enter_eid.clear();
		this.Enter_eid.sendKeys(eid);
		this.click_save.click();
	}

}

















