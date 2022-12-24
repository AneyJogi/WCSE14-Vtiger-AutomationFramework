package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException  {
		
		//Step1: Load the file location into file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		 
		//step2:Create object of properties from java.util package
		Properties pObj= new Properties();
		
		//step3: load file input stream into properties
		pObj.load(fis);
		
		//step4: read the value using key
		String value=pObj.getProperty("username");
		System.out.println(value);
	
		
		
	}

}
