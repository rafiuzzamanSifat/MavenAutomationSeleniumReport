package com.ExtantReport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Demo.Home;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import mavenAutomationSelenium.BaseClass;

public class LoginExtantCustomizeReport extends BaseClass {
  
	//Extend Report 
	
		ExtentHtmlReporter extendhtmlreport; 
		ExtentReports reports; 
		ExtentTest logger; 
		
		
//		@Parameters({"OS","browser"})
@BeforeTest 
		
		public void startreport() {
			
			extendhtmlreport= new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\LoginCustomizeTestReport.html");
			reports=new ExtentReports();
			reports.attachReporter(extendhtmlreport);
			
			
         	reports.setSystemInfo("OS", "Windows");
         	reports.setSystemInfo("OS versoion", "Windows 10");
 			reports.setSystemInfo("Browser", "Chrome");
 			reports.setSystemInfo("Browser Version", "88");
 			reports.setSystemInfo("Screen Size", "1317*709");
			
			extendhtmlreport.config().setDocumentTitle("Test Report");
			extendhtmlreport.config().setReportName("Md.Rafiuzzaman Sifat");
			extendhtmlreport.config().setTheme(Theme.DARK);
			extendhtmlreport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy,hh:mm a");
			
		}
		

	@Test
	public void LoginTC_001() throws InterruptedException, IOException {
		
		
		
		logger=reports.createTest("Login Test 1"); 
		
		lunchChrome();
		logger.log(Status.INFO, "Chrome launch succesfully");
		
		
		Home.OpenHomeURL(); 
		logger.log(Status.INFO, "URL launch succesfully");
		
		com.Demo.Login.OpenLoginURL(); 
		logger.log(Status.INFO, "LoginURL launch succesfully");
		
		com.Demo.Login.InValidEmailValidPass(); 
		logger.log(Status.PASS, "Invalid email and valid pass test done");
		
		tearDownChrome(); 
		logger.log(Status.INFO, "Chrome Close succesfully");
		
		logger.log(Status.PASS, "Invalid email and Valid password test Executed");
		Assert.assertTrue(true);
		logger.log(Status.PASS, "Test case 1 done");
		
	}
	
	
	@Test
	public void LoginTC_002() throws InterruptedException, IOException {
		
		
		
		logger=reports.createTest("Login Test 2"); 
		
		lunchChrome();
		logger.log(Status.INFO, "Chrome launch succesfully");
		
		
		Home.OpenHomeURL(); 
		logger.log(Status.INFO, "URL launch succesfully");
		
		com.Demo.Login.OpenLoginURL(); 
		logger.log(Status.INFO, "LoginURL launch succesfully");
		
	
		com.Demo.Login.ValidEmailInValidPass();
		logger.log(Status.PASS, "valid email and invalid password test done");
		 
				
		logger.log(Status.PASS, "Valid email and Invalid password test Executed");
		Assert.assertTrue(false);
		logger.log(Status.PASS, "Test case 2 done");
	   
	   
	   
	}
	
	@Test
	public void LoginTC_003() throws InterruptedException, IOException {
		
		
		
		logger=reports.createTest("Login Test 3"); 
		
		lunchChrome();
		logger.log(Status.INFO, "Chrome launch succesfully");
		
		
		Home.OpenHomeURL(); 
		logger.log(Status.INFO, "URL launch succesfully");
		
		com.Demo.Login.OpenLoginURL(); 
		logger.log(Status.INFO, "LoginURL launch succesfully");
	
		
		com.Demo.Login.ValidEmailValidPass(); 
		logger.log(Status.PASS, "Valid Email valid password Test done");
		
		logger.log(Status.PASS, "Valid email and valid password test Executed");
		Assert.assertTrue(true);
		logger.log(Status.PASS, "Test case 3 done");
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
			logger.fail(result.getThrowable()); 
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS) 
		{
			
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSES", ExtentColor.GREEN));
			
		}
		else{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
			
		}
			
			
		}
	
	@AfterTest
	public void TestComplete() {
		
		reports.flush(); 
	}
		
		
	}
	
