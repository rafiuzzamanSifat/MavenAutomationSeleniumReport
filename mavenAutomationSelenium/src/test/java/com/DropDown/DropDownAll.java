package com.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import mavenAutomationSelenium.BaseClass;

public class DropDownAll extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		lunchChrome(); 
		openURL(); 
		AllOptionView(); 
		//selectDropByIndex();
		//selectDropByValue();
		//selectDropByVisibleText();


	}

	public static void openURL() {

		driver.get("https://the-internet.herokuapp.com/dropdown");

	}

	public static void selectDropByIndex() throws InterruptedException {

		WebElement DropByIndex=driver.findElement(By.id("dropdown")); 

		Select obj=new Select(DropByIndex);
		obj.selectByIndex(2);
		Thread.sleep(3000);

	}


	public static void selectDropByValue() throws InterruptedException {


		WebElement DropByValue=driver.findElement(By.id("dropdown")); 
		Select obj=new Select(DropByValue);
		obj.selectByValue("1");
		Thread.sleep(3000);

	}


	public static void selectDropByVisibleText() throws InterruptedException {

		WebElement DropByVisibleText=driver.findElement(By.id("dropdown")); 
		Select obj=new Select(DropByVisibleText);
		obj.selectByVisibleText("Option 2");
		Thread.sleep(3000); 

	}

	public static void AllOptionView() {

		WebElement AllOptionView=driver.findElement(By.id("dropdown")); 
		String allOption=AllOptionView.getText(); 
		System.out.println(allOption);

	}

}
