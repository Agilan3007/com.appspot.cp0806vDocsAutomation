package com.appspot.cp0806.pageObjects.libraries.librarypage.librarypagecomponent;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.appspot.cp0806.base.ProjectMethods;

public class CreateFileOrLibraryOrLink extends ProjectMethods {
	@FindBy(css = "div#newrow-modal")
	private WebElement newModelWindow;

	@FindBy(css = "div#newrow-modal-data")
	private WebElement newModelContent;

	@FindBy(css = "input#itemName-Row")
	private WebElement title;

	@FindBy(css = "input#Column3_cat")
	private WebElement email;

	@FindBy(css = "ul[id^=ui-id] li a")
	private List<WebElement> listOfEmails;

	@FindBy(css = "button#addNewRowBtn-id")
	private WebElement addButton;

	@FindBy(css = "div#advanceSearchLoader .loader-content")
	private WebElement libraryLoader;

	public CreateFileOrLibraryOrLink(WebDriver driver) {
		super(driver);
	}

	private void waitForLibraryLoaderToFinish() {
		this.wait.until(ExpectedConditions.invisibilityOf(libraryLoader));
	}

	private void createFields(String folderOrFileName, String userEmail) {
		this.waitForLoaderToFinish();
		this.waitForInformationLoaderToFinish();
		this.wait.until(ExpectedConditions.attributeContains(newModelWindow, "style", "display: block;"));
		this.sleepFor(2000);
		this.wait.until(ExpectedConditions.visibilityOf(title));
		this.wait.until(ExpectedConditions.elementToBeClickable(title));
		this.clickUsingJS(title);
		this.clearAndType(title, folderOrFileName);
		this.clickUsingJS(email);
		this.clearAndType(email, userEmail);
		this.selectEmailID(listOfEmails, userEmail);
		this.addButton.click();
		String notifyMsg = this.verifyNotificaitonMessage();
		Assert.assertEquals(notifyMsg, prop.getProperty("actionMessage"));
		this.waitForLoaderToFinish();
		this.waitForLibraryLoaderToFinish();
	}

	public void createFolder(String folderTitle, String userEmail) {
		createFields(folderTitle, userEmail);		
	}

	public void createFile(String fileTitle, String userEmail) {
		createFields(fileTitle, userEmail);
	}

}
