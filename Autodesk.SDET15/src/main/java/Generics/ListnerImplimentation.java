package Generics;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentation extends BaseClass implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		//@Test
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//After Method
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//After Method
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		try {
			String sysdate = new JavaUtility().getCurrentDate();
			new WebDriverUtility().takeScreenShot(BaseClass.staticDriver,
					result.getMethod().getMethodName()+"_"+sysdate);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//After Method
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is Skipped");
		test.log(Status.SKIP, result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	@Override
	public void onStart(ITestContext context) {
		//On start like before suite
		String sysDate=new JavaUtility().getCurrentDate();
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(IPathConstants.EXTENT_REPORT+sysDate+".html");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setDocumentTitle("Vtiger vs");
		htmlReport.config().setReportName("SmokeTest");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReport);
		
		PropertyFileUtility pLib=new PropertyFileUtility();
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Platform", "Windows 10");
		try {
			extent.setSystemInfo("App Url", pLib.readDataFromPropertyFile("url"));
			extent.setSystemInfo("Browser Type", pLib.readDataFromPropertyFile("browser"));
			extent.setSystemInfo("Reporter tName", "Saurabh");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void onFinish(ITestContext context) {
		//After Suite
		extent.flush();

	}

}
