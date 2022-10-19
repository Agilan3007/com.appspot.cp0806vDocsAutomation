package com.appspot.cp0806.pageObjects.libraries.librarypage.librarypagecomponent.LibraryFileAndFolderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

import com.appspot.cp0806.base.ProjectMethods;

public class LibraryDetails extends ProjectMethods {

	@FindBy(css = "div#rightbarLoader")
	WebElement informationLoader;

	public LibraryDetails(WebDriver driver) {
		super(driver);
	}

	public void waitForInformationLoaderToFinish() {
		this.wait.until(ExpectedConditions.invisibilityOf(informationLoader));
	}

}
