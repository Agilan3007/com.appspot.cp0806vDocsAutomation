package com.appspot.cp0806.base;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	private static ChromeOptions chromeOptions;

	private static ChromeOptions options() {
		chromeOptions = new ChromeOptions();
		// chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

		chromeOptions.addArguments(
				"user-data-dir=C:\\Users\\amuthusa\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
		// chromeOptions.addArguments("incognito");
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("--disable-notifications ");
		return chromeOptions;
	}

	private static ChromeOptions options1() {

		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");

		return chromeOptions;

	}

	private final static Supplier<WebDriver> chromeSupplierWithProfile = () -> {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		options();
		return new ChromeDriver(chromeOptions);
	};

	private final static Supplier<WebDriver> chromeSupplier = () -> {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		options1();
		return new ChromeDriver(chromeOptions);
	};

	private final static Supplier<WebDriver> edgeSupplier = () -> {
		System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		return new EdgeDriver();
	};

	public static final Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();

	static {
		driverMap.put("chrome", chromeSupplier);
		driverMap.put("chromeWithProfile", chromeSupplierWithProfile);
		driverMap.put("edge", edgeSupplier);
	}

	public static WebDriver getDriver(String browserName) {
		return driverMap.get(browserName).get();
	}

}
