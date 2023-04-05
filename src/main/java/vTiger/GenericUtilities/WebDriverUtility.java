package vTiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains generic methods to perform all web driver related actions
 * @author alwin
 *
 */
public class WebDriverUtility
{
	
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
    }
	
	
	public void minimiseWindow(WebDriver driver)
	{
			driver.manage().window().minimize();
	}
	

	
	/**
	 * This method will wait for entire page to load for 20 seconds
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	/**
	 * This method is used to wait for a element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementsToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	/**
	 * This method will wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementsToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This is a custom wait for a second to wait foe element to becme clickable
	 * @param element
	 * @throws InterruptedException 
	 */
	public void customWaitForSecond(WebElement element) throws InterruptedException
	{
		int count =0;
		while(count<5)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
			/**
			 *  This method will handle dropdown with index
			 * @param element
			 * @param index
			 */
	
			public void handleDropdown(WebElement element, int index)
			{
				Select sel= new Select(element);
				sel.selectByIndex(index);
			}
		
			
			/**
			 * This method will handle dropdown with visible text
			 * @param visibleText
			 * @param element
			 */
			public void handleDropdown(String visibleText,WebElement element)
			{
				Select sel= new Select(element);
				sel.selectByVisibleText(visibleText);
			}
			
			public void handleDropDown(WebElement element,String value)
			{
				Select sel= new Select(element);
				sel.selectByValue(value);
			}
		
			public void mouseHoverAction(WebDriver driver,WebElement element)
			{
				Actions act= new Actions(driver);
				act.moveToElement(element).perform();
				
			}
			
			public void mouseHoverAction(WebDriver driver,WebElement element, int x, int y)
			{
				Actions act= new Actions(driver);
				act.moveToElement(element,x,y).perform();
			}
	
			
			/**
			 * This method will perform right click randomly on web page
			 * @param driver
			 */
			public void rightClickActions(WebDriver driver)
			{
				Actions act= new Actions(driver);
				act.contextClick();
				
			}
			
			
			/**
			 * This method will perform right click on particular web element
			 * @param driver
			 * @param element
			 */
			public void rightClickActions(WebDriver driver,WebElement element)
			{
				Actions act= new Actions(driver);
				act.contextClick().perform();
			}
			
			/**
			 *  This method will perform  double click randomly on  web page
			 * @param driver
			 */
			
			public void doubleClickActions(WebDriver driver)
			{
				
					Actions act= new Actions(driver);
					act.doubleClick();
			}
			
			
			/**
			 * This method will perform  double click on  web element
			 * @param driver
			 * @param element
			 */
			public void doubleClickActions(WebDriver driver, WebElement element )
			{
					Actions act= new Actions(driver);
					act.doubleClick();
			}
 
			
			/**
			 * This method will drag and drop from source element to target element
			 * @param driver
			 * @param srcElement
			 * @param tarElement
			 */
			public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement tarElement)
			{
				Actions act = new Actions(driver);
				act.dragAndDrop(srcElement, tarElement).perform();
			}
			
		
			/**
			 * This method will press and release the enter key
			 * @throws AWTException
			 */
			public void pressEnterKey() throws AWTException
			{
				Robot r= new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}

			/**
			 * this method will switch to frame on index
			 * @param driver
			 * @param index
			 */
			public void switchToFrame(WebDriver driver,int index)
			{
				driver.switchTo().frame(index);
	  
			}
			
  
			/**
			 * This method will switch to frame based on name or ID
			 * @param driver
			 * @param nameOrID
			 */
			public void switchToFrame(WebDriver driver,String nameOrID)
			{
				driver.switchTo().frame(nameOrID);
			}
  
			/**
			 * This method will switch to frame based on WebElement
			 * @param driver
			 * @param element
			 */
  
			public void switchToFrame(WebDriver driver,WebElement element)
			{
				driver.switchTo().frame(element);
			}
  
			/**m
			 * This method will switch to default frame
			 * @param driver
			 */
			public void switchToDefaultFrame(WebDriver driver)
			{
				driver.switchTo().defaultContent();
			}
			 
			/**
			 * This method will scroll down for 500 units
			 * @param driver
			 */
			public void sccrollAction(WebDriver driver)
			{
				JavascriptExecutor js =(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0, 500)","");
			}
			
			/**
			 * This method will scroll until particular element
			 * @param driver
			 * @param element
			 */
			public void sccrollAction(WebDriver driver, WebElement element)
			{
				JavascriptExecutor js =(JavascriptExecutor)driver;
				int y=element.getLocation().getY();
				js.executeScript("window.scrollBy(0, "+y+")", element);
			}
			
			/**
			 * This method will take screenshot and save it in ScreenShots folder
			 * @param driver
			 * @param screenShotName
			 * @return
			 * @throws IOException 
			 */
			public String taketheScreenShot(WebDriver driver,String screenShotName) throws IOException 
			{
				TakesScreenshot ts= (TakesScreenshot)driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File dst = new File(".\\ScreenShots\\ "+screenShotName+".png");
				Files.copy(src, dst);
				
				return dst.getAbsolutePath();  //used for extent Reports
			}
			
			
			/**
			 * This method will switch to window based on partial window Title
			 * @param driver
			 * @param partialWinTitle
			 */
			public void switchToWindow(WebDriver driver,String partialWinTitle)
			{
				Set<String> allWindows = driver.getWindowHandles();
				for(String Indwindow:allWindows)
				{
					String currentWinTitle = driver.switchTo().window(Indwindow).getTitle();
					if(currentWinTitle.contains(partialWinTitle))
					{
						break;
					}
				}
			}
	}