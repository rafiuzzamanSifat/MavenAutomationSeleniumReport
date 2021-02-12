package com.DDF;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestNG {
	
	static WebDriver driver; 
  
	@BeforeMethod
	public void OpenLoginURL() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.opencart.com/");
		WebElement MyAccout = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
		MyAccout.click();
		Thread.sleep(3000);

		WebElement LoginBtton = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		LoginBtton.click();
		Thread.sleep(3000);
	}

	
@Test(priority=4)	
public static void ValidEmailValidPass() throws IOException, InterruptedException {
		
		
		WebElement mail=driver.findElement(By.cssSelector("#input-email"));
		WebElement pass=driver.findElement(By.cssSelector("#input-password"));
		WebElement button=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
		
		mail.clear();
		mail.sendKeys("mail12@gmail.com");
		Thread.sleep(1000);
		pass.clear();
		pass.sendKeys("123456");
		Thread.sleep(1000);
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
	
	@Test (priority=1)
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
	
	@Test(priority=2)
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
	
	@Test(priority=3)
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
		
	@AfterMethod
	public void completTest() {
		driver.close();
	}

}
