package com.multipleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import mavenAutomationSelenium.BaseClass;

public class WindowHandle extends BaseClass {

	public static void main(String[] args) throws InterruptedException  {


		lunchChrome(); 
		OpenURL();
		MultipleWindows();


	}

	public static void OpenURL() {

		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();

	}
	
	public static void MultipleWindows() throws InterruptedException {
		
		
		String singleGUID=driver.getWindowHandle();
		System.out.println("Parents GUID: "+singleGUID); 
		
		WebElement multipleWindows=driver.findElement(By.cssSelector("#content > div > a")); 
		multipleWindows.click();
		Thread.sleep(3000);
		
		Set<String> allGUID=driver.getWindowHandles(); 
		System.out.println("All GUID:"+allGUID);
	
		int size=allGUID.size(); 
		System.out.println("Total window:"+size);
		
		
	}
	
	
	 
	 



}
