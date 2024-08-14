package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



public class ListenersClass extends Screenshot implements ITestListener{
	
	
	public void onTestStart(ITestResult result) {
		Reporter.log(" New Test Started- " +result.getName());
		//Reporter.log("link");
			System.out.println("Test case is starting");
			
		//ITestListener.super.onTestStart(result);
		}
		
		public void onTestSuccess(ITestResult result) {
			
		Reporter.log("onTestSuccess Method - "+result.getStatus());
			System.out.println("Test case is onTest");
			//Assert.assertTrue(false);
		//ITestListener.super.onTestSuccess(result);
		}
		
		public void onTestFailure(ITestResult result) {
			System.out.println("Test case is failed");
			Reporter.log("onTestFailure Method "+result.getStatus());
		ITestListener.super.onTestFailure(result);
			try {
				getScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Test failed - screenshot captured");
		Reporter.log("Test case failed- screenshort");
		}
		
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
//			ITestListener.super.onTestSkipped(result);
			Reporter.log("onTestSkipped Method- "+result.getStatus());
		}
		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
//			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
			Reporter.log("onTestFailedButWithinSuccessPercentage" +result.getName());
		}
		
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
//			ITestListener.super.onTestFailedWithTimeout(result);
		}
		
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			Reporter.log("onStart method started");
//			ITestListener.super.onStart(context);
		}
		
		public void onFinish(ITestContext context) {
			Reporter.log(" onFinish method finished");
			System.out.println("Test case is finished");
//			ITestListener.super.onFinish(context);
		}
	

}
