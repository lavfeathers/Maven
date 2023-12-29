package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class report {
	ExtentReports report=new ExtentReports("./Reports/report.html");
	ExtentTest test=report.startTest("Login");
	@Test
	public void demo() {
		WebDriver driver=new ChromeDriver();
		test.log(LogStatus.INFO, "Chrome Browser Launcher");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Chrome browser maximized");
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("vaishumercy@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("swetha@123");
		driver.findElement(By.cssSelector("[value='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.linkText("Log out")).isDisplayed(),true, "Log out not Displayed");
		test.log(LogStatus.FAIL,"Log in successfully" );
		report.endTest(test);
		report.flush();
		driver.quit();
		driver.quit();
	}
	

}
