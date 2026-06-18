package Rahulshettyacademy.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Rahulshettyacademy.TestComponents.BaseTest;
import Rahulshettyacademy.TestComponents.Retry;

public class ErrorValidations extends BaseTest{

	@Test(retryAnalyzer=Retry.class)
	public void submitorder() throws IOException
	{
		
		String productName="ZARA COAT 3";
		landingpage.LoginApplication("bhavyasrinivas2000@gmail.com", "Bhavya@1892311");
		AssertJUnit.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());

	}
}
	




