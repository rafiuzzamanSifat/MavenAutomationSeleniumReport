package com.IFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import mavenAutomationSelenium.BaseClass;

public class IFrameClass extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		

		lunchChrome(); 
		OpenUrl(); 
		SingleIframe(); 
		//promptalert();
		//tearDownChrome(); 

	}


	public static void OpenUrl() throws InterruptedException {

		driver.get("https://the-internet.herokuapp.com/iframe");

		driver.manage().window().maximize();
	}
	
	
	public static void SingleIframe() throws InterruptedException {
		
		driver.switchTo().frame("mce_0_ifr"); 
		
		WebElement iFrame = driver.findElement(By.id("tinymce")); 
		
		iFrame.clear();
		iFrame.sendKeys("sifat");
	    Thread.sleep(3000); 
		
		
	}
		
	}


