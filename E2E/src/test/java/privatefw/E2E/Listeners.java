package privatefw.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReport;

public class Listeners extends Base implements ITestListener {
	
	ExtentTest test;

	ExtentReports extent = ExtentReport.getReportObject(); //access the method in a static manner without creating object

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //for parallel execution
	
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //move objects into a pool

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.get().log(Status.PASS, "Test Passed"); //returns the specific object

	}

	public void onTestFailure(ITestResult result) {

		extentTest.get().fail(result.getThrowable()); //gets failure log
		WebDriver driver=null;
		String methodName = result.getMethod().getMethodName(); //returning the method name that failed
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 

		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShot(methodName, driver), result.getMethod().getMethodName());
			/* getScreenShot(methodName, driver); */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		extent.flush();

	}

}
