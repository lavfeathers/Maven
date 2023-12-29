package generic_library;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base_class {
	public WebDriver driver;
	@BeforeSuite
	public void beforesuit() {
		Reporter.log("Connect to database",true);
	
	}
	@BeforeTest
	public void beforetest() {
		Reporter.log("Before Test",true);
		
	}
	@AfterTest
	public void aftertest() {
		Reporter.log("After Test",true);
	}
	@BeforeClass
	public void beforeclass() {
		Reporter.log("Before class",true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		
	}
	@BeforeMethod
	public void beforemethod() {
		
		
	}
	@AfterMethod
	public void aftermethod() {
		Reporter.log("Logout");
		driver.close();
	}
	@AfterClass
	public void afterclass() {
		driver.quit();
		
	}
	@AfterSuite
	public void aftersuit() {
		Reporter.log("Close connection to database",true);
		
	}
	

}
