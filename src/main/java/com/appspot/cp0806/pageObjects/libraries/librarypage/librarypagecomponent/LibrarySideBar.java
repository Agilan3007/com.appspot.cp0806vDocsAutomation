package com.appspot.cp0806.pageObjects.libraries.librarypage.librarypagecomponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

import com.appspot.cp0806.base.ProjectMethods;

public class LibrarySideBar extends ProjectMethods {

	@FindBy(css = "#newLibraryItem-btn")
	private WebElement newButton;
//d
	@FindBy(css = "div#newLibraryItem-btn ul")
	private WebElement newWindow;

	@FindBy(xpath = "//a[text()=' Folder']")
	private WebElement createFolder;

	@FindBy(xpath = "//i[text()=' note_add ']")
	private WebElement createFile;

	@FindBy(xpath = "//a[text()=' Link']")
	private WebElement createLink;
	
	
	@FindBy(css = ".informationicon")
	private WebElement infoIcon;
	
	@FindBy(css = "#custom-rightbaredit-btn")
	private WebElement editLibSettings;
	
	@FindBy(xpath = "(//li[@class='select2-search select2-search--inline'] //input[@id='select2-search'])[2]")
	private WebElement tags;
	
	@FindBy(css = "div[role='alertdialog']")
	private WebElement popUp;
	
	@FindBy(css = "div#newLibraryItem-btn button[type='button']")
	private WebElement iconNew ;
	
	@FindBy(css = "#addNewRowBtn-id")
	WebElement tagsUpdate;
	
	@FindBy(css = "a[onclick^='backToHome()']")
	private WebElement backTwoHome;
	
	@FindBy(xpath = "//li[@class='select2-search select2-search--inline'] //input[@id='select2-search']")
	private WebElement enterTagName;
	
	@FindBy(xpath = "//h4[text()='Sample reference test']")
	WebElement libraryVerify;

	@FindBy(css = ".select2-selection__choice__remove")
	private WebElement tagsRemoveButton;
	
	@FindBy(css=".select2-results ul li")
	private List<WebElement> tagsSubValue;
	
	
	@FindBy(css = "input#homeGlobalSearch")
	private WebElement libLevelSearch;
	
	@FindBy(css = ".content_copy")
	private WebElement copyIcon;
	
	@FindBy(css = "#copyFilenameTxt")
	private WebElement copyEnterName;
	
	@FindBy(xpath = "(//button[text()='Yes'])[1]")
	private WebElement acceptBtn;
	
	@FindBy(css = "label[for='allowCreAcesForFile-radio-true']")
	private WebElement allowContributorFileTrue;

	@FindBy(css = "label[for='allowCreAcesForFile-radio-false']")
	private WebElement allowContributorFileFalse;

	@FindBy(css = "label[for='allowCreAcesForFolder-radio-true']")
	private WebElement allowContributorFolderTrue;

	@FindBy(css = "label[for='allowCreAcesForFolder-radio-false']")
	private WebElement allowContributorFolderFalse;

	@FindBy(css = "#addNewRowBtn-id")
	private WebElement Update;

	@FindBy(css = "div#newLibraryItem-btn button[type='button']")
	private WebElement contributorNew;


	public LibrarySideBar(WebDriver driver) {
		super(driver);
	}

	public LibrarySideBar clickNewButton() {
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(newButton));
		this.newButton.click();
		this.wait.until(ExpectedConditions.attributeContains(newWindow, "style", "transform: scale(1);"));
		this.wait.until(ExpectedConditions.visibilityOf(newWindow));
		this.sleepFor(2);
		return this;
	}

	public void selectFolderOption() {
		this.wait.until(ExpectedConditions.visibilityOf(createFolder));
		this.wait.until(ExpectedConditions.elementToBeClickable(createFolder));
		this.clickUsingActions(createFolder);
	}

	public void selectFileOption() {
		this.wait.until(ExpectedConditions.visibilityOf(createFile));
		this.wait.until(ExpectedConditions.elementToBeClickable(createFile));
		this.clickUsingActions(createFile);
	}

	public void selectLink() {
		this.wait.until(ExpectedConditions.visibilityOf(newWindow));
		this.wait.until(ExpectedConditions.elementToBeClickable(createLink));
		this.clickUsingActions(createLink);
	}
	public void iconNewCheck() {
		this.waitForLoaderToFinish();
		this.sleepFor(2000);
		if (iconNew.isDisplayed()) {
			System.out.println("NewIconIsDisplayed");
		} else {
			System.out.println("NotDisplayedNewIcon");
		}
	}
	
	public void libraryInfoIconButton() {
		this.infoIcon.click();
	}

	public void editLibrarySetting() {
		this.waitForLoaderToFinish();
		this.infoIcon.click();
		this.wait.until(ExpectedConditions.elementToBeClickable(editLibSettings));
		this.editLibSettings.click();
		this.wait.until(ExpectedConditions.invisibilityOf(popUp));
		this.waitForLoaderToFinish();
	}

	public void updateEditLibrarySetting() {
		this.tagsUpdate.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.invisibilityOfAllElements(popUp));
	}

	public void libraryToHomeButton() {
		this.backTwoHome.click();
		this.waitForLoaderToFinish();
	}

	public void selectTag(String tags) {
		selectTag(tagsSubValue, tags);
	}

	public void selectTag(List<WebElement> ele, String tags) {
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOfAllElements(ele));
		for (WebElement elemnt : ele) {
			System.out.println(elemnt.getText());
			if (elemnt.getText().contains(tags)) {
				elemnt.click();
				break;
			}
		}
	}

	public void enterTagNameAndVerifyLibrary(String nme, String libraryNam) {
		this.enterTagName.click();
		this.enterTagName.sendKeys(nme);
		this.waitForLoaderToFinish();
		this.selectTag(tagsSubValue, nme);
		this.waitForLoaderToFinish();
		boolean displayed2 = driver.findElement(By.xpath("//h4[text()='" + libraryNam + "']")).isDisplayed();
		if (!displayed2) {
			System.out.println("Tags Failed");
		} else {
			System.out.println("Tags Passed");
		}
		this.tagsRemoveButton.click();
		this.waitForLoaderToFinish();
	}
	
	public void popUpAlert() {
		this.wait.until(ExpectedConditions.invisibilityOf(popUp));
	}
	
	public void makeCopy( String copyName) {
		this.waitForAdvanceLevelLoader();
		this.waitForLoaderToFinish();
		this.waitForInformationLoaderToFinish();
		this.copyIcon.click();
		this.wait.until(ExpectedConditions.elementToBeClickable(copyEnterName));
		this.copyEnterName.clear();
		this.copyEnterName.sendKeys(copyName);
		this.waitForAdvanceLevelLoader();
	this.wait.until(ExpectedConditions.elementToBeClickable(acceptBtn));
	this.acceptBtn.click();
		this.waitForLoaderToFinish();
	}
	
	public void contributorLibraryLevelAllow() {
		if (allowContributorFileTrue.isSelected()) {
			System.out.println("Contributor already have access");
	} 
		else
		{
			allowContributorFileTrue.click();
			System.out.println("CLICKED CONTRIBUTOR FILE ACCESS");
		}
		if (allowContributorFolderTrue.isSelected()) {
			System.out.println("Contributor already have access");
		} else {
			allowContributorFolderTrue.click();
			System.out.println("CLICKED CONTRIBUTOR FOLDER ACCESS");
		}
		this.Update.click();
	}

	public void selectFalseAccess() {
		this.allowContributorFileFalse.click();
		this.allowContributorFolderFalse.click();
		this.Update.click();
		System.out.println("RemovedAccessForContributor");
	}
}






