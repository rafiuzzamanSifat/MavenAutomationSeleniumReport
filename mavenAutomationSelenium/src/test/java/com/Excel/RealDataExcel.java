package com.Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Demo.Home;
import com.Demo.Login;

import mavenAutomationSelenium.BaseClass;

public class RealDataExcel extends BaseClass {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ReadData.xlsx"); 

		// Create workbook 
		
		Workbook wb= WorkbookFactory.create(fin); 
		
		// Excel sheet find 
		
		Sheet sht=wb.getSheet("mydata"); 
		
		Row rw=sht.getRow(0); 
		
		Cell cel=rw.getCell(0); 
		String username1=cel.getStringCellValue(); 
		//System.out.println("Mail Row name:"+username1);
		
		Row rw2=sht.getRow(0);
		Cell cel2=rw2.getCell(1);
		
		//for String
//		String pass1=cel2.getStringCellValue(); 
//		System.out.println("Password:"+pass1);
		
		// for Numeric 
		DataFormatter dataformatter=new DataFormatter(); 
		String numaricvalue=dataformatter.formatCellValue(cel2); 
		
		fin.close();
		
		lunchChrome();
		Home.OpenHomeURL(); 
		Login.OpenLoginURL(); 
		
		WebElement mail=driver.findElement(By.cssSelector("#input-email"));
		WebElement pass=driver.findElement(By.cssSelector("#input-password"));
		WebElement button=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
		
		mail.clear();
		mail.sendKeys(username1);
		//Thread.sleep(1000);
		pass.clear();
		pass.sendKeys(numaricvalue);
		//Thread.sleep(1000);
		button.click();
		
		Thread.sleep(4000);
		
		
//		JavascriptExecutor js =(JavascriptExecutor) driver; 
//		js.executeAsyncScript("window.scroll(0,1400)"); 
		
		WebElement logout=driver.findElement(By.cssSelector("#column-right > div > a:nth-child(13)"));
        logout.click(); 
//		
		
		// message print if function pass 
		
	
		String LoginSuccess="My Orders";
		String ActualLogin=driver.findElement(By.cssSelector("#content > h2:nth-child(3)")).getText();
		 if(ActualLogin.contains(LoginSuccess)) 
		 {
			 String result="Pass"; 
			 sht.getRow(0).createCell(2).setCellValue(result);

		 } else
		 
		 {
			 String result="Fail"; 
			 sht.getRow(0).createCell(2).setCellValue(result);
		 }
		
		 
		 FileOutputStream fout= new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ReadData.xlsx");
		 wb.write(fout);
		
	}
	
	

}
