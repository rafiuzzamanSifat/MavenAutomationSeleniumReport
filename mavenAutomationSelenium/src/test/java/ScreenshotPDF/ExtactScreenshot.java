package ScreenshotPDF;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.Demo.Home;

import mavenAutomationSelenium.BaseClass;

public class ExtactScreenshot extends BaseClass {

	public static void main(String[] args) throws IOException {
		
		
		lunchChrome(); 
		Home.OpenHomeURL();
		
		// select element 
		WebElement searchbox=driver.findElement(By.name("search")); 
		
		// Take screenshot 
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Point point=searchbox.getLocation(); 
		int xcoordinate= point.getX(); 
		int ycoordinate=point.getY(); 
		
		int imagewidth=searchbox.getSize().getWidth(); 
		int imageheight=searchbox.getSize().getHeight(); 
		
		// Reading full image
		BufferedImage image=ImageIO.read(srcFile); 
		
		//cut image with necessary element 
		BufferedImage finalImage=image.getSubimage(xcoordinate, ycoordinate, imagewidth, imageheight); 
		
		ImageIO.write(finalImage, "PNG", srcFile);
		
		//save final image 
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshot\\ElementScreenshot.png")); 
		
		tearDownChrome(); 

	}

}
