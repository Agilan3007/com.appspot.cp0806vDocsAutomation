package com.appspot.cp0806.pageObjects.homepage.homePagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appspot.cp0806.base.ProjectMethods;

public class HomePageSideBar extends ProjectMethods {

	@FindBy(id = "createNewLibrary-btn")
	private WebElement newLibrary;

	@FindBy(id = "all-libs-home")
	private WebElement allLibraryName;

	@FindBy(id = "std-libs-home")
	private WebElement standardLibraries;

	@FindBy(id = "vdocsk-libs-home")
	private WebElement valeoEncryptedLibraries;

	@FindBy(id = "#syncGroupBUttonhomePage")
	private WebElement syscGoogleGroup;

	public HomePageSideBar(WebDriver driver) {
		super(driver);
	}

	public void clickNewLibrary() {
		this.newLibrary.click();
	}

	public void clickAllLibraries() {
		this.allLibraryName.click();
	}

	public void clickStandardLibraries() {
		this.standardLibraries.click();
	}

	public void clickValeoEncryptedLibraries() {
		this.valeoEncryptedLibraries.click();
	}

	public void clickSyncGoogleGroup() {
		this.syscGoogleGroup.click();
	}

}
