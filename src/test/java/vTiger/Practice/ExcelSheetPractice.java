package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TextData.xlsx");
		
		//Step2:Create a workbook
		Workbook wb= WorkbookFactory.create(fis);
		
		//step3: navigate to required sheet
		Sheet sh = wb.getSheet("Organisation");
		
		//step4: navigate to required row
		Row rw = sh.getRow(7);
		
		//step5: navigate to required cell
		Cell ce = rw.getCell(4);
		
		//step6:Capture data Present in cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		String value1 = rw.getCell(2).getStringCellValue(); //methodChaining
		
		System.out.println(value1);
		
		
	}

}
