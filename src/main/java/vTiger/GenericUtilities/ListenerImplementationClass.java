package vTiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * This class provides implementation to the ItestListener Interface of TestNG
 * @author alwin
 *
 */
public class ListenerImplementationClass implements ITestListener
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 String methodName= result.getMethod().getMethodName();
		 System.out.println(methodName+"---> test execution started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 String methodName= result.getMethod().getMethodName();
		 System.out.println(methodName+"---> test execution successful");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil= new JavaUtility();
	
		 String methodName= result.getMethod().getMethodName();
		 System.out.println(methodName+"---> test execution failed");
		 System.out.println(result.getThrowable());
		 String screenshotname= methodName+"-"+jUtil.getSystemDateInFormat();
		 
		 try {
			wUtil.taketheScreenShot(BaseClass.sdriver, screenshotname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 String methodName= result.getMethod().getMethodName();
		 System.out.println(methodName+"---> test execution skipped");
		 System.out.println(result.getThrowable());
		 
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution started");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution Finished");
	}
}
