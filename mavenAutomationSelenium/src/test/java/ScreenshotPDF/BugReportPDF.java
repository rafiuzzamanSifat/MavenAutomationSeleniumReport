package ScreenshotPDF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.Demo.Home;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import mavenAutomationSelenium.BaseClass;

public class BugReportPDF extends  BaseClass {

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		
		lunchChrome(); 
		Home.OpenHomeURL();
		
		// select element
        WebElement searchbox=driver.findElement(By.name("search")); 
		
        
        JavascriptExecutor jse=(JavascriptExecutor)driver; 
		jse.executeScript("arguments[0].style.border='3px solid green'", searchbox); 
		
		byte[] input=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		Document doc = new Document(); 
		String output= System.getProperty("user.dir")+"\\Screenshot\\BugReportsPDF.pdf"; 
		
		FileOutputStream fos=new FileOutputStream(output);
		
		PdfWriter writer= PdfWriter.getInstance(doc, fos); 
		
		
		writer.open();
		doc.open();
		
		Image img=Image.getInstance(input);
		
		img.scaleToFit(PageSize.A4.getHeight()/2, PageSize.A4.getWidth()/2);
		
		doc.add(img); 
		doc.add(new Paragraph("Bug Report PDF")); 
		doc.add(new Paragraph("Priority: High")); 
		
		doc.close();
		writer.close();
		
		
		tearDownChrome(); 
		
		

	}

}
