package com.appspot.cp0806.pageObjects.homepage.homePagecomponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appspot.cp0806.base.ProjectMethods;

public class HomePageLibraryList extends ProjectMethods {

	public HomePageLibraryList(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "div[class='card-body'] h4")
	private List<WebElement> libraryNames;

	@FindBy(css = "div#parentDivHome h4[class*='card-title']")
	private List<WebElement> allLibraries;

	@FindBy(css = "div#parentDivHome h4[class*='card-title']:not(h4[class='card-title vdocsk']")
	private List<WebElement> standardLibraries;

	@FindBy(css = "div#parentDivHome h4[class*='card']")
	private List<WebElement> valeoEncryptedLibraries;

	

	public boolean verifyIfTheLibraryIsPresent(String libraryName) {
		this.waitForLoaderToFinish();
		return this.verifyExactText(libraryNames, libraryName);
	}

	public boolean verifyIfLibrariesArePresent() {
		this.waitForLoaderToFinish();
		return this.allLibraries.size() > 0;
	}

	public boolean verifyIfStandardLibrariesArePresent() {
		this.waitForLoaderToFinish();
		return this.standardLibraries.size() > 0;
	}

	public boolean verifyIfValeoEncryptedArePresent() {
		this.waitForLoaderToFinish();
		return !this.valeoEncryptedLibraries.isEmpty();
	}

	public void clickLibrary(String libraryName) {
		this.waitForLoaderToFinish();
		this.clickMatchingElement(allLibraries, libraryName);
		this.waitForLoaderToFinish();
	}

}
