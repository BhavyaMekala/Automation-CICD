package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver) {
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
//	//WebElent spinner = driver.findElement(By.cssSelector(".ng-animating")));
//	@FindBy(css=".ng-animating")
//	WebElement spinner1;
	
	//WebElement routerlink = driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//	@FindBy(css="[routerlink*='cart']")
//	WebElement routerlink;
	
	By productlist  = By.cssSelector(".mb-3");
	By addToCart    = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By spinner = By.cssSelector(".ng-animating");
	
	
	public List<WebElement> getproductList() {
		waitForElementToApper(productlist);
		return products;
	}
	
	public WebElement getProductName(String productName) {
		WebElement prod = getproductList().stream().filter(product->product.findElement(By.tagName("b")).getText().equals(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		
		WebElement prod = getProductName(productName);
		prod.findElement(addToCart).click();
		waitForElementToApper(toastMessage);
		waitForElementToDisappear(spinner);
	
		
	}
	
	
	

}
