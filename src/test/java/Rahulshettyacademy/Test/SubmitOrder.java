package Rahulshettyacademy.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Rahulshettyacademy.TestComponents.BaseTest;
import Rahulshettyacademy.pageobjects.CartPage;
import Rahulshettyacademy.pageobjects.CheckoutPage;
import Rahulshettyacademy.pageobjects.ConfirmationPage;
import Rahulshettyacademy.pageobjects.LandingPage;
import Rahulshettyacademy.pageobjects.OrderPage;
import Rahulshettyacademy.pageobjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest{
	
	String productName="ZARA COAT 3";
	
	//@Test(groups= {"submitHandling"})
	@Test(dataProvider="getData")
	public void submitorder(HashMap<String,String> input) throws IOException
	{
		
		ProductCatalog productcatalog =landingpage.LoginApplication(input.get("email"), input.get("password"));
        List <WebElement> product = productcatalog.getproductList();
		productcatalog.addProductToCart(input.get("product"));
		CartPage cartpage = productcatalog.goToCartPage();
		Boolean match = cartpage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.goToCheckOut();
		checkoutpage.selectCountry("ind");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		ConfirmationPage confirmationpage =checkoutpage.submitOrder();
        String confirm_msg= confirmationpage.confirmationmsg();
        AssertJUnit.assertTrue(confirm_msg.equalsIgnoreCase("Thankyou for the order."));

	}
	
	@Test(dependsOnMethods= {"submitorder"})
	public void ordersPage() {
		ProductCatalog productcatalog =landingpage.LoginApplication("bhavyasrinivas2000@gmail.com", "Bhavya@189231");
		OrderPage orderpage =productcatalog.goToOrdersPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map= new HashMap();
//		map.put("email", "bhavyasrinivas2000@gmail.com");
//		map.put("password","Bhavya@189231");
//		map.put("product","ZARA COAT 3");
//		
//		HashMap<String,String> map1= new HashMap();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password","Iamking@000");
//		map1.put("product","ADIDAS ORIGINAL");
//		
		List<HashMap<String,String>> data =getJsonDataToMap((System.getProperty("user.dir")+"\\src\\test\\java\\Rahulshettyacademy\\data\\purchaseOrder.json"));
		return new Object[] [] {{data.get(0)},{data.get(1)}};
	}
}
	




