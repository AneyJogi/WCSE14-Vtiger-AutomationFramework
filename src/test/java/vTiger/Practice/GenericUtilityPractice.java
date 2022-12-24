package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	

		public static void main(String[] args) throws IOException {
			PropertyFileUtility pUtil =new PropertyFileUtility();
		   String value = pUtil.readDataFromPropertyFile("browser");
			System.out.println(value);
			
			ExcelFileUtility eUtil= new ExcelFileUtility();
			String data= eUtil.readDataFromExcel("Organization",1,2);
			System.out.println(data);
			
			int row = eUtil.getRowCount("Organization");
			System.out.println(row);
			
			eUtil.writeDataIntoExcel("Organization", 1, 7, "Alwin");
			System.out.println("data added");

		}


}
