package com.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import mavenAutomationSelenium.BaseClass;

public class AlertAll extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		lunchChrome(); 
		OpenUrl(); 
		promptalert();
		//tearDownChrome(); 

	}


	public static void OpenUrl() throws InterruptedException {

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.manage().window().maximize();
	}

	public static void normalAlert() throws InterruptedException {

		WebElement normalalert=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button")); 
		normalalert.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

	}

	public static void confirmAlert() throws InterruptedException {

		WebElement confirmalert=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button")); 
		confirmalert.click();
		Thread.sleep(3000);
	}

	public static void promptalert() throws InterruptedException {

		WebElement promptalert=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button")); 
		promptalert.click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("sifat");
		driver.switchTo().alert().accept();

	}


}
