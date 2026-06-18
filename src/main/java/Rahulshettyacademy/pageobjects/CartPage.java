package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Rahulshettyacademy.AbstractComponents.AbstractComponent;


public class CartPage extends AbstractComponent{
	
	    WebDriver driver;
	 
	    //List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
	    @FindBy(css=".cartSection h3")
	    List<WebElement> cartproducts;
	    
	    //driver.findElement(By.cssSelector(".totalRow button")).click();
	    @FindBy(css=".totalRow button")
	    WebElement checkoutEle;

		
	    public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
		
	
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(productName));
		return match;
		
	}
	
	public CheckoutPage goToCheckOut() {
		checkoutEle.click();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		return checkoutpage;
	}
	



}

	

