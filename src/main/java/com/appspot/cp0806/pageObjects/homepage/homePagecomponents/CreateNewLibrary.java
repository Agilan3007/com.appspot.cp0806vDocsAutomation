package com.appspot.cp0806.pageObjects.homepage.homePagecomponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import com.appspot.cp0806.base.ProjectMethods;
import com.google.common.util.concurrent.Uninterruptibles;

public class CreateNewLibrary extends ProjectMethods {

	@FindBy(css = "#newlibrary-modal div[class=modal-content")
	private WebElement newLibModel;

	@FindBy(id = "libraryName")
	private WebElement libraryName;

	@FindBy(id = "librarydes")
	private WebElement libraryDescription;

	@FindBy(id = "teamDriveId")
	private WebElement shareDriveID;

	@FindBy(id = "refLibId")
	private WebElement refrenceLibID;

	@FindBy(css = "div[id='newlibrary-modal'] div[class^='modal-footer'] button:first-of-type")
	private WebElement cancelButton;

	@FindBy(css = "div[id='newlibrary-modal'] div[class^='modal-footer'] button:last-of-type")
	private WebElement createButton;

	public CreateNewLibrary(WebDriver driver) {
		super(driver);
	}

	public void createNewLibrary(String libName, String libDesc, String shareDriveID, String referID) {
		this.newLibModel.isDisplayed();
		this.libraryName.sendKeys(libName);
		this.libraryDescription.sendKeys(libDesc);
		this.shareDriveID.sendKeys(shareDriveID);
		this.refrenceLibID.sendKeys(referID);
		Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
		this.cancelButton.click();
	}

}
