package MainTestcase;

import org.testng.annotations.Test;

import PageClasses.AdminLogin;
import PageClasses.Adminlogout;
import PageClasses.EmpCreation;
import PageClasses.Usercreation;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
public class TestScript 
{
		  WebDriver driver;
		  
		  @BeforeMethod
		  public void admin_login() 
		  {
			  System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			  driver=new ChromeDriver();
			  
				  driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
				  driver.manage().window().maximize();
				  
			 AdminLogin login=PageFactory.initElements(driver, AdminLogin.class);
			 login.Verify_Login("Admin", "Admin");
		  }
		  
		  @Test(priority=0)
		  public void user_creation() throws InterruptedException 
		  {
			Usercreation user=PageFactory.initElements(driver, Usercreation.class);
			user.Verify_user(1, "Admin pal", "Akhilesh123678", "test12345", "test12345");
			String Actval="viewSystemUsers";
			String Expval=driver.getCurrentUrl();
			if(Expval.contains(Actval))
			{
			Reporter.log("User creation success",true);
			}
			else {
			Reporter.log("User creation unsuccess",true);
			}
		  }
		  
		  @Test(priority=1)
		  public void emp_creation() throws InterruptedException
		  {
			  EmpCreation emp=PageFactory.initElements(driver, EmpCreation.class);
			  
			  emp.Verify_emp("test12345", "rita12394", "8767965");
			  String Acval="empNumber";
			  String Expval=driver.getCurrentUrl();
			  
			  if(Expval.contains(Acval))
			  {
			  Reporter.log("Emp creation success",true);
			  }
			  else {
			  Reporter.log("Emp creation unsuccess",true);
			  }
		  }
		  @AfterMethod
		  public void admin_logout() throws InterruptedException
		  {
			  Adminlogout logout=PageFactory.initElements(driver, Adminlogout.class);
				logout.Verify_logout();
				driver.quit();
		  }
		
}
