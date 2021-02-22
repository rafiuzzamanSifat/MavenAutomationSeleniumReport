package ScreenshotPDF;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.Demo.Home;

import mavenAutomationSelenium.BaseClass;

public class BugReport extends BaseClass {

	public static void main(String[] args) throws IOException {
		
		lunchChrome(); 
		Home.OpenHomeURL();
		
		// select element
        WebElement searchbox=driver.findElement(By.name("search")); 
		
        
        JavascriptExecutor jse=(JavascriptExecutor)driver; 
		jse.executeScript("arguments[0].style.border='3px solid green'", searchbox); 
		
		byte[] img_byte=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); 
		BufferedImage img=ImageIO.read(new ByteArrayInputStream(img_byte)); 
		
		Point point=searchbox.getLocation(); 
		int xcoordinate= point.getX(); 
		int ycoordinate=point.getY(); 
		
		System.out.println(xcoordinate+" "+ycoordinate);
		
		int imagewidth=searchbox.getSize().getWidth(); 
		int imageheight=searchbox.getSize().getHeight();
		
		// Add Text
		Graphics g=img.getGraphics(); 
		g.setColor(Color.red);
		g.setFont(new Font("sansSerif", Font.BOLD, 14));
		g.drawString("This is it",494,64); 
		
		//if want to draw
		
		//g.drawRect(xcoordinate,ycoordinate,imagewidth,imageheight);
		g.dispose();
		
		// save
		ImageIO.write(img, "PNG", new File(System.getProperty("user.dir")+"\\Screenshot\\BugReports.png"));

	}

}
