package api.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportFiles  implements ITestListener{
	ExtentSparkReporter  htmlReporter;//user interface/ look & feel of the report
	ExtentReports reports;//common information
	ExtentTest test;//entries for test
	public void configureReport() {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String reportName = "PetStoreAutomationTestReport-" + timestamp +".html";
        htmlReporter = new ExtentSparkReporter("/home/user/eclipse-workspace/RestAssured/Reports/" + reportName);
	    reports = new ExtentReports();
	    reports.attachReporter(htmlReporter);
	}
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("on start method invoked...");
	}
	public void onFinish(ITestContext Result) {
	
		System.out.println("on finish method invoked...");
		reports.flush();
	}
   public void onTestFailure (ITestResult Result) {
	   System.out.println("Name of test method failed" + Result.getName());
		test = reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
	   String screenshotPath = "/home/user/eclipse-workspace/RestAssured/Screenshots" + Result.getName() + ".png";
	   File screenshotFile = new File (screenshotPath);
	   if(screenshotFile.exists())
		{
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
			
		}
   }
   public void onTestSuccess(ITestResult Result)					
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}		
}
