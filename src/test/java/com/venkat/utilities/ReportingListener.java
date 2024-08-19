package com.venkat.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportingListener implements ITestListener {
	ExtentSparkReporter reporter;
	ExtentReports extent;

	public void onStart(ITestContext context) {
		reporter = new ExtentSparkReporter(".\\test-output\\ExtentReports\\index.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
	}

	public void onTestFailure(ITestResult result) {
		// not implemented
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}
}
