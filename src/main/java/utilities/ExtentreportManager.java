package utilities;

import java.security.DrbgParameters.Capability;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ecom.baseclass.BaseTest;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ExtentreportManager extends ScreenshotsUtils implements ITestListener {

	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		String doctitle = "ecom-AutomationSuite";
		String reportname = "Functional testing";
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + ".html";
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(".//Test-Reports//" + timeStamp + repName);
		sparkreporter.config().setDocumentTitle(doctitle);
		sparkreporter.config().setReportName(reportname);
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("os",System.getProperty("os.name") + " " + System.getProperty("os.version"));
		extent.setSystemInfo("java version", System.getProperty("java.version"));
		extent.setSystemInfo("environment", "local");
		extent.setSystemInfo("testername", System.getProperty("user.name"));
		extent.setSystemInfo("browser",BaseTest.browserName);
		extent.setSystemInfo("browserversion",BaseTest.browserVersion);
		extent.setSystemInfo("platform",BaseTest.platforminfo);
		
	}
	
	public void onTestsuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "test case is passed" + result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "testcase failed" + result.getName());
		String screenshotPath = screenshotmanager(result.getName());
		if (screenshotPath != null) {
			try {
				test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "testcase has been skipped" +" " + result.getName());
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Flushing Extent Report...");
		extent.flush();
	}
	
}
