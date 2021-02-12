package com.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
	FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ReadData.xlsx");
	
	Workbook wb=WorkbookFactory.create(fin); 
	
	Sheet sht=wb.getSheet("mydata"); 
	
	Iterator<Row> rowIterator = sht.iterator(); 
	while(rowIterator.hasNext())
	{
	  Row row=	rowIterator.next(); 
	  Iterator<Cell> cellIterator=row.cellIterator(); 
		  while (cellIterator.hasNext()) 
		  {
			  Cell cell=cellIterator.next(); 
			  System.out.println(cell.getStringCellValue());
		  }
	}

	
	fin.close(); 


	}
}
