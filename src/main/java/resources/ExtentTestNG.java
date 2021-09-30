package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestNG {
	public static ExtentReports getExtent() {
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reporter\\index.html");
		reporter.config().setReportName("WebAutomation results");
		reporter.config().setDocumentTitle("Test results");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "saicharan");
		return extent;
		
	}

}
