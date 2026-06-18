package Rahulshettyacademy.TestComponents;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Rahulshettyacademy.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException {
		
		//properties class
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Rahulshettyacademy\\resources\\GobalData.properties");
		prop.load(fis);
		
		//when client asked you to run browser from the firefox , go and get from the maven command  prompt
		String browserName =System.getProperty("browser")!=null? System.getProperty("browser"): prop.getProperty("browser"); //ternary operator
		
		//String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Edge"))
		{
			
		//Edge
			
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		
		}
		
		else if (browserName.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.edgedriver().setup();
			if(browserName.contains("headless")){
				{
					options.addArguments("headless");
				}
			}
			driver = new ChromeDriver(options);	
//when browser is running it will respect to options what are all the settings to I need to do.
			 //options argument tells that can u run me in headless mode
			
		}
		
		else if (browserName.equalsIgnoreCase("Firefox")) {
			//firefox 
			WebDriverManager.edgedriver().setup();
			 driver = new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
		}
	
	public  List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		//Read Json to String
		//readFileToString is depricated, in the newest method wt they did is apart from first argument ,
		//when it is trying to read json to string it is also asking 
		//in what encoding format your trying to write the string, so standar encoding formating is StandardCharsets.UTF_8 
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	
		//String to HashMap- jackson Databind
		//readValue which can read the String and convert to Hashmap, which expects 2 arguments, one is string what i want to convert and second argument how we want to convert , go ahead creates hashmaps in the form of list 
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data =mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
		//{map,map}
		
		
		
	}
	
	public String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" +testCaseName+ ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" +testCaseName+ ".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	 public LandingPage LaunchingApplication() throws IOException {
		 driver = initializeDriver();
		landingpage= new LandingPage(driver);
			landingpage.goTO();
			return landingpage;
	 }
	
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
		
	}


