package com.appspot.cp0806.pageObjects.libraries.librarypage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClickLibrary extends com.appspot.cp0806.base.ProjectMethods {

	@FindBy(xpath = "//h4[text()='Sample reference test']")
	WebElement oneLibrary;
	
	@FindBy(css="input#homeGlobalSearch")
	WebElement search;

	public ClickLibrary(WebDriver driver) {
		super(driver);
	}

	public void clickOneLibrary() {
		waitForLoaderToFinish();
		this.search.sendKeys("Sample reference test",Keys.ENTER);
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOf(oneLibrary));
		this.oneLibrary.click();
	}

}
