package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Rahulshettyacademy.AbstractComponents.AbstractComponent;


public class OrderPage extends AbstractComponent{
	
	    WebDriver driver;
	 
	    //List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
//	    @FindBy(css=".cartSection h3")
//	    List<WebElement> cartproducts;
	    
	    //List<WebElement> cartproducts = driver.findElements(By.cssSelector("tr td:nth-child(3)"));
	    @FindBy(css="tr td:nth-child(3)")
	    List<WebElement> productsName;
	    
	    //driver.findElement(By.cssSelector(".totalRow button")).click();
	    @FindBy(css=".totalRow button")
	    WebElement checkoutEle;

		
	    public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
		
	
	public Boolean VerifyOrderDisplay(String productName) {
		Boolean match = productsName.stream().anyMatch(cartproduct->cartproduct.getText().equals(productName));
		return match;
		
	}
	
	
	



}

	

