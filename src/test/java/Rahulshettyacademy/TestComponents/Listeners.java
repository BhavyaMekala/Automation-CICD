package Rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Rahulshettyacademy.resources.ExtentReportsNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	WebDriver driver = null;
	ExtentReports extent = ExtentReportsNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>(); //concurrency 
	 @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("Test started: " + result.getName());
	        test =extent.createTest(result.getMethod().getMethodName()); //Here we are using method got the method name not the class name
	        extentTest.set(test);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test passed: " + result.getName());
	        extentTest.get().log(Status.PASS, "Test is passed");
	    }
   
	    
	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("Test passed: " + result.getName());
	        extentTest.get().fail(result.getThrowable());
	        
	        try {
	        	//interview ques for below
	        //I can't use the test method to get the driver because fields are associated in class level not in method level
	        	driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	        } catch (Exception e1){
	        	e1.printStackTrace();
	        }
	        String filePath = null;
	        try {
	        filePath = getScreenshot(result.getMethod().getMethodName());
	        }catch (IOException e) {
	        	e.printStackTrace();
	        }
	        extentTest.get().addScreenCaptureFromPath(filePath ,result.getMethod().getMethodName());
//)
	    }
	    

	    @Override
	    public void onFinish(ITestContext context) {
	       extent.flush();
	    }
   


}
