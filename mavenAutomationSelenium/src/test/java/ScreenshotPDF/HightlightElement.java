package ScreenshotPDF;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.Demo.Home;

import mavenAutomationSelenium.BaseClass;

public class HightlightElement extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		lunchChrome(); 
		Home.OpenHomeURL();

		// select element 
		WebElement searchbox=driver.findElement(By.name("search")); 
		
		//Hightlight by javascript 
		
		JavascriptExecutor jse=(JavascriptExecutor)driver; 
		jse.executeScript("arguments[0].style.border='3px solid red'", searchbox); 
		
		Thread.sleep(3000);
		
		// Take screenshot 
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//save final image 
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshot\\HightlightScreenshot.png")); 
	}

}
