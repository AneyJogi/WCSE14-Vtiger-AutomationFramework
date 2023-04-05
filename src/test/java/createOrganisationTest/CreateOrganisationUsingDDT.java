 package createOrganisationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class  CreateOrganisationUsingDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// step1: read necessary data
		/*PropertyFile - Common Data*/
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		 String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		System.out.println(BROWSER);
		
		/*Excel File -Test Data*/
		FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\TextData.xlsx");
		 Workbook wb= WorkbookFactory.create(fis1);
		 Sheet sh = wb.getSheet("Organization");
		 Row rw = sh.getRow(1);
		 Cell ce = rw.getCell(2);
		 String ORGNAME=ce.getStringCellValue();
		 System.out.println(ORGNAME);
		 
		
		 
		 WebDriver driver= null;
		
		//Step 2: LaunchBrowser- Runtime Polymorphism -driver
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		 }
		 
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		 }
		 else
		 {
			 System.out.println("invalid browser name");
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(URL);
		
		 //Step 3: Login To Application
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 
		//Step 4: Click on Organizations Link
		 driver.findElement(By.linkText("Organizations")).click();
			
		//Step 5: click on create organization lookup image
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
		//Step 6: Create new organization with mandatory information and save
	   	 driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
		 //step7: signOut
	
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act= new Actions(driver);
		 act.moveToElement(ele);
		 driver.findElement(By.linkText("Sign Out")).click();
		
		 

	}

	

}
