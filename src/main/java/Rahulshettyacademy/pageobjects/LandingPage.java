package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//pageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//WebElement userPassword = driver.findElement(By.id("userPassword"))
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	//WebElement submit =driver.findElement(By.cssSelector("input[name='login']"))
	@FindBy(css="input[name='login']")
	WebElement submit;
	
	//WebElement errorMessage=driver.findElement(By.cssSelector("[class*='flyInOut']"))
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	//Action Method
	public ProductCatalog LoginApplication(String email , String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalog productcatalog = new ProductCatalog(driver);
		return productcatalog;
		}
	
	public String getErrorMessage() {
		waitForWebElementToApper(errorMessage);
		return errorMessage.getText();
	
	}
	
	
	
	//for url
	public void goTO() {
		driver.get("https://rahulshettyacademy.com/client/auth/login");
	}
	

}
