package Rahulshettyacademy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
    
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//driver.findElement(By.cssSelector("input[placeholder='Select Country']"))
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectcountry;
	
	// driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		waitForElementToApper(results);
		selectcountry.click();
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
		 ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		 return confirmationpage;
	}
	

}


