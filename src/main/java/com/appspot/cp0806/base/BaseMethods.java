package com.appspot.cp0806.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.function.Supplier;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

public class BaseMethods {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Select select;
	static protected Properties prop;
	int i = 1;
	public static float totalTimeOfGlobalLoader;
	public static float totalTimeOfInformationLoader;
	public static float totalTimeOfLibraryLoader;

	Map<String, Supplier<List<WebElement>>> getListOfWebElement = new HashMap<>();
	Map<String, Supplier<WebElement>> getElement = new HashMap<>();

	public BaseMethods(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		PageFactory.initElements(driver, this);
		loadProperties();

	}

	protected void loadProperties() {
		prop = new Properties();
		String projectPath = System.getProperty("user.dir");

		try {
			FileInputStream input = new FileInputStream(projectPath + "/src/main/resources/config/config.properties");
			prop.load(input);
		} catch (IOException e) {
			System.out.println("Configuration property file is not avaialble. Exception occured: " + e.getMessage());
			e.printStackTrace();
		}
	}

	protected boolean verifyTitle(String url) {
		String getTittle = this.driver.getTitle();
		if (getTittle.equals(url))
			return true;
		else
			return false;
	}

	public void sleepFor(int delayInMiilieconds) {
		Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(delayInMiilieconds));
	}

	public void waitFor(int delayInSeconds) {
		Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(delayInSeconds));
	}

	protected void click(WebElement ele) {
		this.wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}

	protected void clickUsingActions(WebElement ele) {
		this.wait.until(ExpectedConditions.elementToBeClickable(ele));
		new Actions(this.driver).moveToElement(ele).perform();
		ele.click();
	}

	protected void clickUsingJS(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
	}

	protected void clickMatchingElement(List<WebElement> listOfEle, String text) {
		this.wait.until(ExpectedConditions.visibilityOfAllElements(listOfEle));
		listOfEle.stream().filter((ele) -> ele.getText().equals(text)).findFirst().get().click();
	}

	protected boolean verifyExactText(WebElement ele, String text) {
		this.wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
		return ele.getText().trim().equals(text);
	}

	protected boolean verifyExactText(List<WebElement> listOfEle, String text) {
		this.wait.until(ExpectedConditions.visibilityOfAllElements(listOfEle));
		boolean present = listOfEle.stream().map((ele) -> ele.getText().equals(text)).findFirst().isPresent();
		return present;
	}

	protected boolean verifyTextContains(WebElement ele, String text) {
		this.wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
		return ele.getText().trim().contains(text);
	}

	protected void clearAndType(WebElement ele, String text) {
		this.wait.until(ExpectedConditions.visibilityOf(ele));
		ele.clear();
		for (char ch : text.toCharArray()) {
			waitFor(5);
			ele.sendKeys(ch + "");
		}
	}

	protected void appendAndType(WebElement ele, String text) {
		this.wait.until(ExpectedConditions.visibilityOf(ele));
		for (char ch : text.toCharArray()) {
			waitFor(5);
			ele.sendKeys(ch + "");
		}
	}

	protected String getAttributeValue(WebElement ele, String attributeName) {
		return ele.getAttribute(attributeName);
	}

	protected String getElementBackground(WebElement ele) {
		return ele.getCssValue("background-color");
	}

	protected String getColorOfTheText(WebElement ele) {
		return ele.getCssValue("color");
	}

	protected String getValueOfElement(WebElement ele) {
		return ele.getAttribute("value");
	}

	protected void selectDropDownUsingText(WebElement ele, String value) {
		new Select(ele).selectByVisibleText(value);
	}

	protected void selectDropDownUsingIndex(WebElement ele, int index) {
		new Select(ele).selectByIndex(index);

	}

	protected void selectDropDownUsingValue(WebElement ele, String value) {
		new Select(ele).selectByValue(value);
	}

	protected void selectMultipleDropDownByValues(WebElement ele, String values) { // values = "chennai, pune,
																					// bangalore" ;
		select = new Select(ele);
		String[] arrValues = values.split(",");
		for (String value : arrValues)
			select.selectByValue(value);
	}

	protected void selectMultipleDropDownByText(WebElement ele, String values) {
		select = new Select(ele);
		String[] arrValues = values.split(",");
		for (String value : arrValues)
			select.selectByVisibleText(value);
	}

	protected void selectMultipleDropDownByIndex(WebElement ele, String index) {
		select = new Select(ele);
		String[] arrValues = index.split(",");
		for (String value : arrValues)
			select.selectByIndex(Integer.parseInt(value));
	}

	protected void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	protected void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	protected String getAlertText() {
		return this.driver.switchTo().alert().getText();
	}

	protected void typeAlert(String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	protected void pageScrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)");
	}

	protected void pageScrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-350)");
	}

	protected void scrollToTheElement(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", ele);
	}

	protected void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	protected void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	protected void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	protected void defaultContent() {
		driver.switchTo().defaultContent();
	}

	protected WebElement locateElement(String locatoryType, String locator) {
		getElement.put("id", () -> driver.findElement(By.id(locator)));
		getElement.put("name", () -> driver.findElement(By.name(locator)));
		getElement.put("classname", () -> driver.findElement(By.className(locator)));
		getElement.put("css", () -> driver.findElement(By.cssSelector(locator)));
		getElement.put("linkText", () -> driver.findElement(By.linkText(locator)));
		getElement.put("partialLinkText", () -> driver.findElement(By.partialLinkText(locator)));
		getElement.put("tag", () -> driver.findElement(By.tagName(locator)));
		getElement.put("xpath", () -> driver.findElement(By.xpath(locator)));
		return getElement.get(locatoryType).get();
	}

	protected List<WebElement> locateElements(String locatoryType, String locator) {
		getListOfWebElement.put("id", () -> driver.findElements(By.id(locator)));
		getListOfWebElement.put("name", () -> driver.findElements(By.name(locator)));
		getListOfWebElement.put("classname", () -> driver.findElements(By.className(locator)));
		getListOfWebElement.put("css", () -> driver.findElements(By.cssSelector(locator)));
		getListOfWebElement.put("linkText", () -> driver.findElements(By.linkText(locator)));
		getListOfWebElement.put("partialLinkText", () -> driver.findElements(By.partialLinkText(locator)));
		getListOfWebElement.put("tag", () -> driver.findElements(By.tagName(locator)));
		getListOfWebElement.put("xpath", () -> driver.findElements(By.xpath(locator)));
		return getListOfWebElement.get(locatoryType).get();
	}

	protected WebElement WebElement(String xpathOrCss) {
		boolean isXpath = xpathOrCss.substring(0, 4).contains("//");
		if (isXpath)
			return this.driver.findElement(By.xpath(xpathOrCss));
		else
			return this.driver.findElement(By.cssSelector(xpathOrCss));
	}

	protected void openNewWindow() {
		this.driver.switchTo().newWindow(WindowType.WINDOW);
	}

	protected void openNewTab() {
		this.driver.switchTo().newWindow(WindowType.TAB);
	}

	protected void openNewWindowAndNavigate(String url) {
		openNewWindow();
		this.driver.navigate().to(url);
	}

	protected void openNewTabAndNavigate(String url) {
		openNewTab();
		this.driver.navigate().to(url);
	}

	protected void rightClick(WebElement ele) {
		new Actions(this.driver).contextClick(ele).build().perform();
	}

	protected void doubleClick(WebElement ele) {
		new Actions(this.driver).doubleClick(ele).build().perform();
	}

	protected void clickMultiple(List<WebElement> eleList) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.LEFT_CONTROL).build().perform();
		for (WebElement ele : eleList)
			ele.click();
		actions.keyUp(Keys.LEFT_CONTROL).build().perform();
	}

	protected void clickSingle(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.LEFT_CONTROL).build().perform();
		ele.click();
		actions.keyUp(Keys.LEFT_CONTROL).build().perform();
	}

	protected void clickCheckBoxUsingJS(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);

	}

	public void highlightElement(WebElement ele) {
		// scrollByVisibleElement(ele);
		String border = ele.getCssValue("border");
		String backgroud = ele.getCssValue("background");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border= '2px solid red'", ele);
//		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
//		js.executeScript("arguments[0].style.background='yellow'", ele);
		Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(200));
		js.executeScript("arguments[0].style.border= '" + border + "'", ele);
//		js.executeScript("arguments[0].style.background= '" + backgroud + "'", ele);

	}

	public boolean isElementAvailableAndDisplayed(List<WebElement> elements) {
		return elements.size() > 0 && elements.get(0).isDisplayed();
	}

	public boolean isElementPresent(List<WebElement> elements) {
		return !elements.isEmpty();
	}

	protected void openNewWindowUsingJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");

	}

	protected void openAndSwitchToNewWindow(String url) {
		String currentWindowHandle = driver.getWindowHandle();
		openNewWindowUsingJS();
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		for (String handle : windowHandles) {
			if (handle != currentWindowHandle)
				continue;
			else {
				driver.switchTo().window(handle);
			}
		}
		driver.navigate().to(url);
	}

	protected int generateRandonNumber() {
		return new Random().nextInt(1000);
	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "/screenshots/" + getClass().getName()
				+ generateRandonNumber() + ".png ";
		File img = new File(filePath);
		FileUtils.copyFile(srcFile, img);
		return filePath;
	}

}
   




