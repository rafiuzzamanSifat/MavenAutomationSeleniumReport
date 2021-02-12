package com.Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// set test data path 
		
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ReadData.xlsx"); 

		// Create workbook 
		
		Workbook wb= WorkbookFactory.create(fin); 
		
		// Excel sheet find 
		
		Sheet sht=wb.getSheet("mydata"); 
		
		Row rw=sht.getRow(0); 
		
		Cell cel=rw.getCell(0); 
		String username1=cel.getStringCellValue(); 
		System.out.println("mail name:"+username1);
		
		Row rw2=sht.getRow(0);
		Cell cel2=rw2.getCell(1);
		String pass1=cel2.getStringCellValue(); 
		System.out.println("mail name:"+pass1);
		
		
		
	}

}
