package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider="PhonesData")
	public void dataProvidePractice(String Name,String Model,int price, int qty ) 
	{
		System.out.println("test run  => "+Name+" "+Model+" "+price+" "+qty);	 
	}
	
	@DataProvider(name="PhonesData")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		data[0][0]= "samsung";
		data[0][1]="A80";
		data[0][2]=10000;
		data[0][3]=12;
		
		data[1][0]="Iphone";
		data[1][1]="S13";
		data[1][2]=30000;
		data[1][3]=10;
		 
		data[2][0]="Realme";
		data[2][1]="R13";
		data[2][2]=25000;
		data[2][3]=20;
		return data;
		
	}


}
