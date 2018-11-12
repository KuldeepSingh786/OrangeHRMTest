package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Usercreation
{
		WebDriver driver;
		Actions ac;
		public Usercreation(WebDriver driver)
		{
			this.driver=driver;
		}
			@FindBy(id="menu_admin_viewAdminModule")
			WebElement click_Admin;
			
			@FindBy(id="menu_admin_UserManagement")
			WebElement click_usermngnt;
			
			@FindBy(id="menu_admin_viewSystemUsers")
			WebElement click_users;
			
			@FindBy(id="btnAdd")
			WebElement click_Add;
			
			@FindBy(id="systemUser_userType")
			WebElement select_role;
			
			@FindBy(id="systemUser_employeeName_empName")
			WebElement Enter_ename;
			
			@FindBy(id="systemUser_userName")
			WebElement enter_user;
			
			@FindBy(id="systemUser_password")
			WebElement enter_password;
			
			@FindBy(id="systemUser_confirmPassword")
			WebElement enter_cpwd;
			
			@FindBy(id="btnSave")
			WebElement click_save;
		public void Verify_user(int role,String ename,String username,String password,String cpassword) throws InterruptedException
		{
				ac=new Actions(driver);
			ac.moveToElement(click_Admin).click().perform();
			Thread.sleep(3000);
			
			ac.moveToElement(click_usermngnt).click().perform();
			Thread.sleep(3000);
			
			ac.moveToElement(click_users).click().perform();
			Thread.sleep(3000);
			
			ac.moveToElement(click_Add).click().perform();
			Thread.sleep(3000);
			
			new Select(select_role).selectByIndex(role);
			this.Enter_ename.sendKeys(ename);
			this.enter_user.sendKeys(username);
			this.enter_password.sendKeys(password);
			this.enter_cpwd.sendKeys(cpassword);
			ac.moveToElement(click_save).click().perform();
			Thread.sleep(4000);
		}
}

















