package com.Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import mavenAutomationSelenium.BaseClass;

public class Login extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		lunchChrome();
		Home.OpenHomeURL(); 
		OpenLoginURL(); 
		//InValidEmailInValidPass();
		//ValidEmailInValidPass(); 
		//InValidEmailValidPass(); 
		ValidEmailValidPass(); 
	}
	
	public static void OpenLoginURL() throws InterruptedException {

		WebElement MyAccout=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")); 
		MyAccout.click();
		Thread.sleep(3000);
		
		WebElement LoginBtton=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")); 
		LoginBtton.click();
		Thread.sleep(3000);
		
		
	}
	
	public static void ValidEmailValidPass() throws IOException, InterruptedException {
		
		FileInputStream input= new FileInputStream (System.getProperty("user.dir")+"\\PropertiesFolder\\OR.properties"); 
		Properties prop=new Properties(); 
		prop.load(input);
		
		
		WebElement mail=driver.findElement(By.cssSelector("#input-email"));
		WebElement pass=driver.findElement(By.cssSelector("#input-password"));
		WebElement button=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
		
		mail.clear();
		mail.sendKeys(prop.getProperty("email"));
		//Thread.sleep(1000);
		pass.clear();
		pass.sendKeys(prop.getProperty("password"));
		//Thread.sleep(1000);
		button.click();
		
		// Java Script ScrollDown 
		JavascriptExecutor js=(JavascriptExecutor) driver; 
		js.executeScript("window.scroll(0,1400)"); 
		
		//String LoginSuccess="My Orders";
		//String ActualLogin=driver.findElement(By.cssSelector("#content > h2:nth-child(3)")).getText();
		//Assert.assertEquals=(ActualLogin, LoginSuccess); 
		//System.out.println("Successfully login");
		
		
		WebElement logout=driver.findElement(By.cssSelector("#column-right > div > a:nth-child(13)"));
		logout.click(); 
	
	}
	
	public static void ValidEmailInValidPass() {
		WebElement mail=driver.findElement(By.cssSelector("#input-email"));
		WebElement pass=driver.findElement(By.cssSelector("#input-password"));
		WebElement button=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
		
		mail.clear();
		mail.sendKeys("abc@mail.com");
		pass.clear();
		pass.sendKeys(" ");
		button.click();
		
	}
	
	public static void InValidEmailValidPass() {
		WebElement mail=driver.findElement(By.cssSelector("#input-email"));
		WebElement pass=driver.findElement(By.cssSelector("#input-password"));
		WebElement button=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
		
		mail.clear();
		mail.sendKeys("");
		pass.clear();
		pass.sendKeys(" 234567 ");
		button.click();
		
	}
	
	public static void InValidEmailInValidPass() {
		WebElement mail=driver.findElement(By.cssSelector("#input-email"));
		WebElement pass=driver.findElement(By.cssSelector("#input-password"));
		WebElement button=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
		
		mail.clear();
		mail.sendKeys(" ");
		pass.clear();
		pass.sendKeys(" ");
		button.click();
		
	}

}
