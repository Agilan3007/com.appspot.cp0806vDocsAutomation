package com.appspot.cp0806.pageObjects.libraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.appspot.cp0806.base.ProjectMethods;

public class LibraryPage extends ProjectMethods {

	public LibraryPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".informationicon")
	private WebElement infoIcon;

	@FindBy(css = "#custom-rightbaredit-btn")
	private WebElement editLibSettings;

	@FindBy(xpath = "(//li[@class='select2-search select2-search--inline'] //input[@id='select2-search'])[2]")
	private WebElement tags;

	@FindBy(css = "div[role='alertdialog']")
	private WebElement popUp;

	@FindBy(css = "div#newLibraryItem-btn button[type='button']")
	private WebElement iconNew;

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

	@FindBy(css = ".select2-results ul li")
	private List<WebElement> tagsSubValue;

	@FindBy(css = "input#homeGlobalSearch")
	private WebElement libLevelSearch;

	@FindBy(css = ".content_copy")
	private WebElement copyIcon;

	@FindBy(css = "#copyFilenameTxt")
	private WebElement copyEnterName;

	@FindBy(xpath = "(//button[text()='Yes'])[1]")
	private WebElement acceptBtn;

	@FindBy(xpath = "//input[@id='libraryDesc-row']")
	private WebElement libraryDescription;

	@FindBy(xpath = "(//div[@class='bardetails-right'])[2]")
	private WebElement libraryDescriptionVerify;

	@FindBy(xpath = "(//div[@class='bardetails-right'])[3]") // tr[id^='oldMemTempId']
	private WebElement libraryOwner;

	@FindBy(css = "#select2-form-control-owner-container")
	private WebElement libraryOwnerEmail;

	@FindBy(xpath = "//span[@class='select2-dropdown select2-dropdown--below'] //input[@id='select2-search']")
	private WebElement emailDropDownClick;

	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']") // .select2-results
																									// ul li
	private List<WebElement> libraryOwnerEmailUpdate;

	@FindBy(css = "label[for='allowCreAcesForFile-radio-true']")
	private WebElement allowContributorFileTrue;

	@FindBy(css = "label[for='allowCreAcesForFile-radio-false']")
	private WebElement allowContributorFileFalse;

	@FindBy(css = "label[for='allowCreAcesForFolder-radio-true']")
	private WebElement allowContributorFolderTrue;

	@FindBy(css = "label[for='allowCreAcesForFolder-radio-false']")
	private WebElement allowContributorFolderFalse;
	
	@FindBy(css = "label[for='enableRelation-radio-true']")
	private WebElement allowEnableRelationTrue;

	@FindBy(css = "label[for='enableRelation-radio-false']")
	private WebElement allowEnableRelationFalse;
	
	@FindBy(css = "button[onclick^='displayRelationModal']")
	private WebElement editRelationButton;

	@FindBy(css = "#addNewRowBtn-id")
	private WebElement Update;

	@FindBy(css = "div#newLibraryItem-btn button[type='button']")
	private WebElement contributorNew;

	@FindBy(css = "span.informationicon")
	private WebElement libInfo;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[1]")
	private WebElement libName;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[2]")
	private WebElement libDesc;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[3]")
	private WebElement libOwner;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[4]")
	private WebElement libCreatedOn;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[5]")
	private WebElement libTags;

	@FindBy(xpath = "(//div[@class='d-flex flex-row comment-row'])[1]")
	private WebElement libActivity;

	@FindBy(id = "workflow-scrollablebtn")
	private WebElement activityTab;
	
	public void refresh() {
		driver.navigate().refresh();
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
		this.waitForLoaderToFinish();
		this.infoIcon.click();

	}

	public void editLibrarySetting() {

		this.wait.until(ExpectedConditions.elementToBeClickable(editLibSettings));
		this.editLibSettings.click();
		this.wait.until(ExpectedConditions.invisibilityOf(popUp));
		this.waitForLoaderToFinish();
	}

	public void libraryEditSettingsUpdateButton() {
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

	public void makeCopy(String copyName) {

		this.waitForLoaderToFinish();
		this.copyIcon.click();
		this.wait.until(ExpectedConditions.elementToBeClickable(copyEnterName));
		this.copyEnterName.clear();
		this.copyEnterName.sendKeys(copyName);
		this.acceptBtn.click();
		this.waitForLoaderToFinish();

	}

	public void libDescription(String url) {
		this.libraryDescription.clear();
		this.libraryDescription.sendKeys(url, Keys.ENTER);
	}

	public void libDescriptionVerify(String link) {
		String text = this.libraryDescriptionVerify.getText();
		Assert.assertEquals(text, link);

	}

	public void libraryOwnerEmail(String email) {
		this.libraryOwnerEmail.click();
		this.emailDropDownClick.click();
		this.emailDropDownClick.sendKeys(email);
		this.waitForLoaderToFinish();
		this.selectEmailID(libraryOwnerEmailUpdate, email);
		this.waitForLoaderToFinish();

	}

	public void verifyOwner(String updatedEmail) {
		String text = this.libraryOwner.getText();
		Assert.assertEquals(text, updatedEmail);
	}

	public void tagVerify(String nme) {

		this.wait.until(ExpectedConditions.elementToBeClickable(tags));
		this.tags.click();
		this.tags.sendKeys(nme);
		this.waitForLoaderToFinish();
		this.selectEmailID(tagsSubValue, nme);

	}

	public void contributorLibraryLevelAllow() {
		if (allowContributorFileTrue.isSelected()) {
			System.out.println("Contributor already have access");
		} else {
			allowContributorFileTrue.click();
			System.out.println("CLICKED CONTRIBUTOR FILE ACCESS");
		}
		if (allowContributorFolderTrue.isSelected()) {
			System.out.println("Contributor already have access");
		} else {
			allowContributorFolderTrue.click();
			System.out.println("CLICKED CONTRIBUTOR FOLDER ACCESS");
		}
	}

	public void contributorFalseAccess() {
		this.allowContributorFileFalse.click();
		this.allowContributorFolderFalse.click();
		System.out.println("RemovedAccessForContributor");// de
	}

	public void enableRelationAllowTrue() {
		this.allowEnableRelationTrue.click();
	}

	public void enableRelationAllowFalse() {
		this.allowEnableRelationFalse.click();
	}

	

	public void LibraryDetails(String libName, String libDesc, String libOwner, String libCreatedOn, String libTags) {

		String actTitle = this.libName.getText();
		String expTitle = libName;
		Assert.assertEquals(actTitle, expTitle, "Libraryname is not Displayed");
		System.out.println("Libraryname is  Displayed");

		String actTitle1 = this.libDesc.getText();
		String expTitle1 = libDesc;
		Assert.assertEquals(actTitle1, expTitle1, "LibraryDescription is not Displayed");
		System.out.println("LibraryDescription is  Displayed");

		String actTitle2 = this.libOwner.getText();
		String expTitle2 = libOwner;
		Assert.assertEquals(actTitle2, expTitle2, "LibraryOwner is not Displayed");
		System.out.println("LibraryOwner is  Displayed");

		String actTitle3 = this.libCreatedOn.getText();
		String expTitle3 = libCreatedOn;
		Assert.assertEquals(actTitle3, expTitle3, "LibraryCreatedOnDate is not Displayed");
		System.out.println("LibraryCreatedOnDate is  Displayed");

		String actTitle4 = this.libTags.getText();
		String expTitle4 = libTags;
		Assert.assertEquals(actTitle4, expTitle4, "LibraryTag is not Displayed");
		System.out.println("LibraryTag is  Displayed");
	}

	public void activityTab() {

		this.activityTab.click();
		this.wait.until(ExpectedConditions.elementToBeClickable(libActivity));
		boolean displayed = this.libActivity.isDisplayed();
		System.out.println("Library Activity Is Dsiplayed Correctly " + displayed);

	}

}
