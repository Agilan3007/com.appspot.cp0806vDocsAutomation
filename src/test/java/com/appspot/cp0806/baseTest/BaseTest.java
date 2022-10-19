package com.appspot.cp0806.baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.appspot.cp0806.base.DriverFactory;

public class BaseTest {
	protected WebDriver driver;

	
//	@BeforeTest
//	public void setDriver() {
//		this.driver = DriverFactory.getDriver("chromeWithProfile");
//	
//}
//	
//	@AfterTest
//	public void closeBrowser() { 
//		this.driver.quit();
//	}

}
