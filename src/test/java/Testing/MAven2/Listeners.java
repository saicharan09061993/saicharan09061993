package Testing.MAven2;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.CommonDriver;
import resources.ExtentTestNG;

public class Listeners implements ITestListener{
	
	public ExtentTest test;
	ExtentReports extent=ExtentTestNG.getExtent();
	ThreadLocal<ExtentTest> extenttest= new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.get().log(Status.PASS, "test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		WebDriver driver =null;
		String method=result.getMethod().getMethodName();
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		CommonDriver cmn=new CommonDriver();
		
			extenttest.get().addScreenCaptureFromPath(cmn.getScreenshotPath(method,driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}


}
