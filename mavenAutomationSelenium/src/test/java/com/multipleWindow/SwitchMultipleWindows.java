package com.multipleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import mavenAutomationSelenium.BaseClass;

public class SwitchMultipleWindows extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		lunchChrome(); 
		WindowHandle.OpenURL();
		SwitchWindows();


	}

	public static void SwitchWindows() throws InterruptedException {

		String parentGUID=driver.getWindowHandle();
		System.out.println("Parents GUID: "+parentGUID);

		WebElement childWindow=driver.findElement(By.cssSelector("#content > div > a"));  
		childWindow.click();
		Thread.sleep(3000);

		Set<String> allGUID=driver.getWindowHandles(); 
		System.out.println("All GUID"+ allGUID);

		int size=allGUID.size(); 
		System.out.println("Total Window:"+size);


		for(String childGUID:allGUID) {

			if(!childGUID.equals(parentGUID)) {
				driver.switchTo().window(parentGUID);
				System.out.println("parents window title"+driver.getTitle());
				break; 
			}
		}

		for(String childGUID:allGUID) {

			if(!childGUID.equals(parentGUID )) {
				driver.switchTo().window(childGUID);
				System.out.println("child window title"+driver.getTitle());
				break; 
			}
			
		}
		
		for (String childGUID:allGUID) {
			if(!childGUID.equals(parentGUID)) {
				
				driver.switchTo().window(parentGUID); 
				System.out.println("Parents Window title:"+driver.getTitle());
				break; 
			}
		}

}

}
