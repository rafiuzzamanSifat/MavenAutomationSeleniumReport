package com.Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import mavenAutomationSelenium.BaseClass;

public class Register extends BaseClass {


	public static void main(String[] args) throws InterruptedException, IOException {
		
		lunchChrome(); 
		Home.OpenHomeURL();
		OpeRegistration();
		register();
		//tearDownChrome();
		}
	
	
	
	public static void OpeRegistration() throws InterruptedException {
		
		WebElement MyAccout=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")); 
		MyAccout.click();
		Thread.sleep(3000);
		
		WebElement RegistarionBtn=driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a")); 
		RegistarionBtn.click();
		Thread.sleep(3000);
		
	}
	
	public static void register() throws InterruptedException, IOException {
		
		FileInputStream input= new FileInputStream (System.getProperty("user.dir")+"\\PropertiesFolder\\OR.properties"); 
		Properties prop=new Properties(); 
		prop.load(input);
		
		WebElement firstname=driver.findElement(By.cssSelector("#input-firstname"));
		firstname.click();
		driver.switchTo().activeElement().sendKeys("rafiuzzaman");
		
		WebElement lastname=driver.findElement(By.cssSelector("#input-lastname"));
		lastname.click();
		driver.switchTo().activeElement().sendKeys("sifat");
		
		WebElement email=driver.findElement(By.cssSelector("#input-email"));
		email.click();
		driver.switchTo().activeElement().sendKeys(prop.getProperty("email"));
		
		WebElement telephone=driver.findElement(By.cssSelector("#input-telephone"));
		telephone.click();
		driver.switchTo().activeElement().sendKeys("123456");
		

		WebElement pass=driver.findElement(By.cssSelector("#input-password"));
		pass.click();
		driver.switchTo().activeElement().sendKeys(prop.getProperty("password"));
		
		
		WebElement confrimpass=driver.findElement(By.cssSelector("#input-confirm"));
		confrimpass.click();
		driver.switchTo().activeElement().sendKeys(prop.getProperty("password"));
		
		
		WebElement radio=driver.findElement(By.cssSelector("#content > form > fieldset:nth-child(3) > div > div > label:nth-child(1) > input[type=radio]"));
		radio.click();
		driver.switchTo().activeElement().click();
		
		
		WebElement policy=driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
		policy.click();

		WebElement select=driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
		select.click(); 
		
		WebElement Continue=driver.findElement(By.cssSelector("#content > div > div > a"));
		
		Continue.click();
		
		WebElement logout=driver.findElement(By.cssSelector("#column-right > div > a:nth-child(13)"));
		logout.click(); 
		
		
		Thread.sleep(3000);
		
		
		//String ExpectedText1="Your Account Has Been Created!"; 
		//String ActualText1=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText(); 
		
	}

}
