package MainTestcase;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExcelUtil.ExcelUtilMethods;
import PageClasses.AdminLogin;
import PageClasses.Adminlogout;
import PageClasses.EmpCreation;

import org.testng.annotations.BeforeTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class DriverScript 
	{
	  WebDriver driver;
	  ExtentReports report;
	  ExtentTest logger;
	  String inputpath="./Input/EmpCreation.xlsx";
	  String outputpath="./Output/Resultsemp.xlsx";
	  
	  
	    @BeforeTest
	    public void beforeTest() 
	    {
			  report=new ExtentReports("./Reports/ExtentsReports.html");
			  System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			  driver=new ChromeDriver();
			  driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
			  driver.manage().window().maximize();
			  
			  AdminLogin login=PageFactory.initElements(driver, AdminLogin.class);
			  login.Verify_Login("Admin", "Admin");
	    }
		 @Test
		 public void EmpCreation() throws InterruptedException
		 {
			 logger=report.startTest("Verify Emp crfeation");
			ExcelUtilMethods xl=new ExcelUtilMethods(inputpath);
			EmpCreation emp=PageFactory.initElements(driver, EmpCreation.class);
			int rc=xl.getRowCount("Emp");
			int cc=xl.getCellCount("Emp");
			Reporter.log("no of rows are::"+rc+"  "+"no of columns are::"+cc,true);
			logger.log(LogStatus.INFO, "no of rows are::"+rc+"  "+"no of columns are::"+cc);
			for(int i=1;i<=rc;i++)
			{
				String fname=xl.getcellData("Emp", i, 0);
				String mname=xl.getcellData("Emp", i, 1);
				String lname=xl.getcellData("Emp", i, 2);
				String eid=xl.getcellData("Emp", i, 3);
				logger.log(LogStatus.INFO, fname+" "+mname+" "+lname+"  "+eid );
				Reporter.log(fname+" "+mname+" "+lname+"  "+eid,true);
				emp.Verify_emp(fname, lname, eid);
				String Acval="empNumber";
				  String Expval=driver.getCurrentUrl();
				  if(Expval.contains(Acval))
				  {
				  Reporter.log("Emp creation success",true);
				  logger.log(LogStatus.PASS, "Emp creation success");
				  xl.setCellDatanewfile("Emp", i, 4, "pass", outputpath);
				  xl.fillGreenColor("Emp", i, 4, outputpath);
				  }
				  else {
				  Reporter.log("Emp creation unsuccess",true);
				  logger.log(LogStatus.FAIL,"Emp creation unsuccess");
				  xl.setCellDatanewfile("Emp", i, 4, "fail", outputpath);
				  xl.fillRedColor("Emp", i, 4, outputpath);
				  }
				    }
		  }
	  @AfterTest
	  public void afterTest() throws InterruptedException {
	   Adminlogout logout=PageFactory.initElements(driver, Adminlogout.class);
	    logout.Verify_logout();
	    report.endTest(logger);
		  report.flush();
	    driver.quit();
		    		
		  
	  }
	
}
