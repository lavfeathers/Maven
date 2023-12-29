package generic_library;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class webdriver_Utility implements FrameworkConstants {
	public static Actions action;
	public static JavascriptExecutor je;
	/**
	 * webdriver utility used for all reusable methods*/
	public static void selectOptionByIndex(WebElement dropdown,int index) {
		Select select=new Select(dropdown);
		select.selectByIndex(index);
		
	}
	public static void selectOptionByValue(WebElement dropdown,String value) {
		Select select=new Select(dropdown);
		select.selectByValue(value);
		
	}
	public static void selectOptionByVisibleText(WebElement dropdown,String text) {
		Select select=new Select(dropdown);
		select.selectByVisibleText(text);
		
	}
	
	//Switch to window
	public static void swithchTowindowByTitle(WebDriver driver,String title) {
		 Set<String> allwindows = driver.getWindowHandles();
		for(String window:allwindows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title)) {
				break;
			}
		}
		
		//Switch to window by using URL
	public static void SwitchToWindowByURL(WebDriver driver ,String url) {
		Set<String> allwindow=driver.getWindowHandles();
		for(String window:allwindow) {
			if (driver.getCurrentUrl().contains(url)){
				break;
			}
		}
		
	}
	//switch to frame using index
	public static void switchToFramebyindex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	//switch to frame using webelement
	public static void switchtoFrameByWebelement(WebDriver driver,Webelement frameElement) {
		driver.switchTo().frame(frameElement);
		
	}
	//all webdriver methods
	public static void clickElement(WebElement element,String text) {
		element.click();
	}
	public static void enterText(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	/**
	 * take screenshot of entire webpage*/
	public static void getScreenshotofWebPage(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File(SCREENSHOT_PATH+getSystemDate()+".png");
		try {
		FileHandler.copy(temp, perm);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//take screenshot of webelement
	public static void getScreenshotofWebElement(WebElement element) {
		File temp=element.getScreenshotAs(OutputType.FILE);
		File perm=new File(SCREENSHOT_PATH+getSystemDate()+".png");
		try {
			FileHandler.copy(temp, perm);
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	public static String getSystemDate(){
		
		return LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
	}
	//handle Alert
	//Accecpt
	public static void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	//Dismiss
	public static void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	//gettext
	public static void switchToAlertgetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	//sendkeys
	public static void switchToAlertsendkeys(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	//MouseActions
	//movetoelement
	public static void mouseHover(WebDriver driver,WebElement element) {
		action.moveToElement(element).perform();
	}
	//click
	public static void mouseClick(WebDriver driver,WebElement element) {
		action.click(element).perform();
		
	}
	
	//rightclick
	public static void rightClick(WebDriver driver,WebElement element) {
		action.contextClick().perform();
	}
	/***
	 * Scroll the window to the given x and y*/
	public static void scrolltoXandYvalue(Webdriver driver,int x,int y) {
		je.executeScript("window.scrollTo("+x+","+y+");");
	}
	/**
	 * scroll the window to the given x and y*/
	public static void scrollIntoView(WebDriver driver,WebElement element,boolean position) {
		je.executeScript("arguments[0].scrollIntoView("+position+");",element);
	}
	 
	/**
	 * To handle hidden or Disabled button*/
	public static void clickOnHiddenOrDisabledElement(WebDriver driver,WebElement element) {
		je.executeScript("arguments[0].click();", element);
		
	}
	/**
	 *To handle Hidden or Disabled textfield */
	public static void enterTextToHiddenOrDisabledElement(WebDriver driver,WebElement element,String value) {
		je.executeScript("argument[0].value="+value+";",element);
	}
	/**
	 */
	public static void initObjects(WebDriver driver) {
		action=new Actions(driver);
		je=(JavascriptExecutor)driver;
	}
	
}
	private static void getSystemDate() {
		// TODO Auto-generated method stub
		
	}
	

}
