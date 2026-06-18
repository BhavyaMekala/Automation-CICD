package Rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

	

	public static ExtentReports getReportObject() {
		
		//ExtentReports //ExtentSparkReporter
		
		//ExtentSparkReporter expects that html file where it has to create
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		System.out.println(path);
		//reporter object is responsible to make all configuration to report
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		
		//ExtentReports object is responsible to drive all your reporting execution
		//ExtentReports extent = new ExtentReports();
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Bhavya");
		return extent;
		}



}
