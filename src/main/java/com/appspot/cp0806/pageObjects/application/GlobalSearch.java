package com.appspot.cp0806.pageObjects.application;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.appspot.cp0806.base.ProjectMethods;

public class GlobalSearch extends ProjectMethods {

	@FindBy(css = "input#homeGlobalSearch")
	private WebElement globalSearchBar;

	public GlobalSearch(WebDriver driver) {
		super(driver);
	}

	public void enterSearchItem(String searchItem) {
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(globalSearchBar));
		this.globalSearchBar.clear();
		this.globalSearchBar.sendKeys(searchItem);
		this.globalSearchBar.sendKeys(Keys.ENTER);
	}

}
