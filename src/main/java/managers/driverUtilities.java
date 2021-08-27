package managers;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class driverUtilities {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	private WebElement element;
	private JavascriptExecutor js;
	private Select select;

	// Constructor
	public driverUtilities(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	// Wait Wrapper Method
	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));	
	}
	
	
	public void waitVisibilityEle(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}

	// Click Method
	public void click(By elementBy) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).click();
	}
	
	
	public void clickEle(WebElement webElement) {		
		waitVisibilityEle(webElement);
		webElement.click();
	}
	
	// Clear Method
	public void clear(By elementBy) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).clear();
	}


	// Write Text
	public void writeText(By elementBy, String text) throws Exception {
		waitVisibility(elementBy);	
		driver.findElement(elementBy).sendKeys(text);
		Thread.sleep(500);
	}
	// Write Text element
	public void writeTextEle(WebElement element, String text) throws Exception {
		waitVisibilityEle(element);
		element.sendKeys(text);
		Thread.sleep(500);
	}

	// send Keys
	public void sendKeys(By elementBy, Keys keys) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).sendKeys(keys);
	}

	// Read Text
	public String readText(By elementBy) {
		waitVisibility(elementBy);
		return driver.findElement(elementBy).getText();
	}
	
	// Read Text
	public String readTextEle(WebElement element) {
		waitVisibilityEle(element);
		return element.getText();
	}

	// AssertEquals
	public void assertEquals(By elementBy, String expectedText) {
		waitVisibility(elementBy);
		Assert.assertEquals(readText(elementBy), expectedText);
	}
	
	// AssertTextEquals
	public void assertTextEquals(String object, String expectedText) {		
		Assert.assertEquals(object, expectedText);
	}

	// Move to Element
	public void movetoElement(By elementBy) {
		waitVisibility(elementBy);
		action = new Actions(driver);
		element = driver.findElement(elementBy);
		action.moveToElement(element).perform();
	}


	// select by index
	public void selectIndex(By elementBy, int index  ) {
		waitVisibility(elementBy);
		action = new Actions(driver);
		element = driver.findElement(elementBy);
		select = new Select(element);
		select.selectByIndex(index);
	}
	

	
	// select by value
	public void selectValue(By elementBy, String value  ) {
		waitVisibility(elementBy);
		action = new Actions(driver);
		element = driver.findElement(elementBy);
		select = new Select(element);
		select.selectByValue(value);
	}

	
	
	public void selectEleValue(WebElement element, String value  ) {
		waitVisibilityEle(element);
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectEleIndex(WebElement element, int index  ) {
		waitVisibilityEle(element);
		select = new Select(element);
		select.selectByIndex(index);
	}
	
	// Java script Click
	public void Jsclick(By elementBy) {
		waitVisibility(elementBy);
		WebElement element = driver.findElement(elementBy);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	
	// Java script Click
	public void JsclickEle(WebElement element) {
		waitVisibilityEle(element);

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	
	
	
	// Java script Click
	public void JsScroll(By elementBy) throws Exception {
		waitVisibility(elementBy);
		WebElement element = driver.findElement(elementBy);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 		
	}
	
	// Java script Click
	public void displayAlert() throws Exception {
		
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 		
	}
	
	
	public void JsScrollToLocation(int distance) throws Exception {

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+distance+")");
		Thread.sleep(500); 		
	}

	public void JsSetAttribute(String attribute, String value ) throws Exception {		
		String set = "document.getElementsByName('file')[0].setAttribute('"+attribute+"','"+value+"');";		
		js = (JavascriptExecutor) driver;
		js.executeScript(set);
		Thread.sleep(500); 		
	}

	// screenShot
	public void screenShot(String filename) throws Exception {
		File shots = null;
		try {
			shots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(shots, new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public byte[] screenShotByte() throws Exception {

			byte[] shots =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);		
			return shots;
	}
	
	
	// mrkdir
	public void mkdir(String outputPath) {
		try {
			File output = new File(outputPath);
			output.mkdir();
		} catch (Exception e) {
		}
	}
		
	// mrkdir
	public void select(By elementBy,String value) throws Exception {		
		WebElement element = driver.findElement(elementBy);
		Select select = new Select(element);
		select.selectByValue(value);
		Thread.sleep(2000);
	}


	
}