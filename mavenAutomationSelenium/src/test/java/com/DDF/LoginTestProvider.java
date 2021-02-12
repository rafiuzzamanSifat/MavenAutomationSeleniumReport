package com.DDF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestProvider {

	static WebDriver driver;

	@DataProvider(name = "logindata")
	public Object[][] data() {
		Object[][] data = new Object[3][2];

		data[0][0] = "mail1@gmail.com";
		data[0][1] = "123456";

		data[1][0] = "mail2@gmail.com";
		data[1][1] = "123456";

		data[2][0] = "mail3@gmail.com";
		data[2][1] = "123456";

		return data;

	}


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

	@Test(dataProvider = "logindata")
	public void LoginTest(String email, String password) throws InterruptedException {

		WebElement mail = driver.findElement(By.cssSelector("#input-email"));
		WebElement pass = driver.findElement(By.cssSelector("#input-password"));
		WebElement button = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		Thread.sleep(3000);
		mail.clear();
		mail.sendKeys(email);
		pass.clear();
		pass.sendKeys(password);
		Thread.sleep(3000);
		button.click();
	}
	
	@AfterMethod
	public void completTest() {
		driver.close();
	}
	


}
