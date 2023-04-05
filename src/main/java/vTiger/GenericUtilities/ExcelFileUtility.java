package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility
   {
	/**
	 * this method is used to read data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFromExcel(String  sheetName, int rowNum,int colNum) throws EncryptedDocumentException, IOException 
	{
		 FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFIlePath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		Cell ce = rw.getCell(colNum);
		String value=ce.getStringCellValue();
		wb.close();
		return value;	
		
	}
	
	/**
	 * this method will read the key from property file and return value
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis= new FileInputStream(IConstantsUtility.ExcelFIlePath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				int rowCount = sh.getLastRowNum();
				wb.close();
				return rowCount;
	}
	
	
	/**
	 * This method will write data to excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param celNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	/*public void writeDataIntoExcel(String sheetName, int rowNum, int celNo, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFIlePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		Cell ce= rw.createCell(celNo);
		
		ce.setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream(IConstantsUtility.ExcelFIlePath);
		wb.write(fos);
		wb.close();
	}*/
	
	public void writeDataIntoExcel(String sheetName, int rowNum, int celNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFIlePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		Cell ce = rw.createCell(celNo);
		
		ce.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFIlePath);
		wb.write(fos);
		
		wb.close();
	}
	

	public Object[][] readMultipleDataIntoDataProvider(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IConstantsUtility.ExcelFIlePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum(); 
		
		Object[][] data= new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				
			}
		}
		return data;
	}
		
	} 