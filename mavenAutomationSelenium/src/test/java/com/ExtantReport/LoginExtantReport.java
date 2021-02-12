package com.ExtantReport;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Demo.Home;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import mavenAutomationSelenium.BaseClass;

public class LoginExtantReport extends BaseClass {
  
	//Extend Report 
	
		ExtentHtmlReporter extendhtmlreport; 
		ExtentReports reports; 
		ExtentTest logger; 
		

	@Test
	public void Login() throws InterruptedException, IOException {
		
		extendhtmlreport= new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\LoginTestReport.html");
		
		reports=new ExtentReports();
		
		reports.attachReporter(extendhtmlreport);
		
		logger=reports.createTest("Login Test"); 
		
		lunchChrome();
		logger.log(Status.INFO, "Chrome launch succesfully");
		
		
		Home.OpenHomeURL(); 
		logger.log(Status.INFO, "URL launch succesfully");
		
		com.Demo.Login.OpenLoginURL(); 
		logger.log(Status.INFO, "LoginURL launch succesfully");
		
		//InValidEmailInValidPass();
		//ValidEmailInValidPass(); 
		//InValidEmailValidPass(); 
		com.Demo.Login.InValidEmailValidPass();
		logger.log(Status.PASS, "Login launch Unsuccesfully");
		
		com.Demo.Login.ValidEmailValidPass(); 
		logger.log(Status.PASS, "Login launch succesfully");
		
		reports.flush(); 
		
		
	}
	
	
}
