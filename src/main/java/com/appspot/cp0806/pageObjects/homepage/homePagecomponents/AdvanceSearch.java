package com.appspot.cp0806.pageObjects.homepage.homePagecomponents;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.appspot.cp0806.base.ProjectMethods;
import com.appspot.cp0806.pageObjects.application.DateRange;

public class AdvanceSearch  extends ProjectMethods {

	private DateRange dateRange;

	@FindBy(css = "input#homeGlobalSearch")
	private WebElement advanceSearchBar;

	@FindBy(id = "homeGlobalSearch")
	private WebElement advanceSearchBarID;

	@FindBy(id = "advanceSearch-btn")
	private WebElement advanceSearchBtn;

	@FindBy(id = "advancesearch-body-id")
	private WebElement advanceSearchDropDown;

	@FindBy(id = "adv-libraryName-id")
	private WebElement libraryName;

	@FindBy(id = "adv-libraryDesc-id")
	private WebElement libraryDesc;

	@FindBy(id = "adv-createdOn-id")
	private WebElement createdOn;

	@FindBy(id = "resetAdvanceSearch")
	private WebElement resetBtn;

	@FindBy(id = "advanceSearchButton-submit")
	private WebElement searchBtn;

	public AdvanceSearch(WebDriver driver) {
		super(driver);
		this.dateRange = new DateRange(driver);
	}

	public void enterSearchText(String searchItem) throws IOException {
		this.waitForLoaderToFinish();
		this.clearAndType(advanceSearchBar, searchItem);
		this.advanceSearchBar.sendKeys(Keys.ENTER);
		//Reporter.log("<br><img src='" + this.takeScreenshot() + "' height='400' width='600'/><br>");
	}

	public void clickAdvanceSearchIcon() throws IOException {
		this.waitForLoaderToFinish();
		this.advanceSearchBtn.click();
		this.wait.until((d) -> this.advanceSearchDropDown.isDisplayed());
		Reporter.log("<br><img src='" + this.takeScreenshot() + "' height='600' width='800'/><br>");

	}

	public void enterLibraryName(String libraryName) {
		this.libraryName.sendKeys(libraryName);
	}

	public void enterLibraryDescription(String libraryDescription) {
		this.libraryDesc.sendKeys(libraryDescription);
	}

	public void selectCreatedOn() {
		this.createdOn.click();
	}

	public DateRange getDateRange() {
		return this.dateRange;
	}

	public void clickResetButton() {
		this.resetBtn.click();
	}

	public void clickSearchButton() {
		this.searchBtn.click();
	}

}

	


