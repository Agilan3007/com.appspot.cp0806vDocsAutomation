package com.appspot.cp0806.pageObjects.libraries.librarypage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.appspot.cp0806.base.ProjectMethods;
import com.appspot.cp0806.pageObjects.libraries.librarypage.librarypagecomponent.LibraryFilesAndFolder;

public class DynamicApproval extends ProjectMethods {

	public DynamicApproval(WebDriver driver) {
		super(driver);
	}


	
	
	



	@FindBy(css = "li#admin-settings-ui-id")
	private WebElement adminSettingsIcon;
	
	@FindBy(css = "a[onclick^='showAdminScreenFromHomePage']")
	private WebElement administrationIcon ;
	
	@FindBy(css = "img[data-original-title='rajesh.sivakumar@valeo.com']")
	private WebElement nplusOneValidatorName;
	
	@FindBy(css = "div#advanceSearchLoader .loader-content")
	WebElement libraryLoader;
	
	
	@FindBy(xpath = "//div[@id='newLibraryItem-btn']//ul")
	private WebElement newTab;
	
	@FindBy(css = "div#newLibraryItem-btn")
	private WebElement newFile;

	@FindBy(css = "a.createNewLibraryItem-file-btn")
	private WebElement createFile;
	
	@FindBy(css = "input#itemName-Row")
	private WebElement title;

	@FindBy(css = "input#Column3_cat")
	private WebElement email;

	@FindBy(css = "ul[id^='ui-id-'] li a")
	private List<WebElement> emailOptions;

	@FindBy(css = "#addNewRowBtn-id")
	private WebElement addButton;
	
	@FindBy(css="#ui-id-4 li a")
	private List<WebElement> emailOptions1;
	

	
	@FindBy(css = "input#Column31_cat")
	private WebElement email2;
	
	@FindBy(css = "div[role='alertdialog']")
	private WebElement popUp;

	
	
	
	LibraryFilesAndFolder obj1 = new LibraryFilesAndFolder(driver);
	
	
	public void selectEmailID(List<WebElement> elements, String userEmail) {
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		for (WebElement ele : elements) {
			System.out.println(ele.getText());
			if (ele.getText().contains(userEmail)) {

				ele.click();
				break;
			

		}}}


	
	public void newFile(String titleNmeFil, String emailName,String emailNam) {
		this.waitForLoaderToFinish();
		this.newFile.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOf(newTab));
		this.createFile.click();
		this.waitForLoaderToFinish();
		this.sleepFor(2000);
		this.wait.until(ExpectedConditions.elementToBeClickable(title));
		this.waitForLoaderToFinish();
		this.title.sendKeys(titleNmeFil);
		this.waitForLoaderToFinish();
	//	this.scrollToTheElement(email2);
		this.wait.until(ExpectedConditions.elementToBeClickable(email));
		this.email.sendKeys(emailName);
		this.waitForLoaderToFinish();
		this.selectEmailID(emailOptions, emailName);
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(email2));
		this.email2.sendKeys(emailNam);
		this.waitForLoaderToFinish();
		this.selectEmailID(emailOptions1,emailNam);
		this.addButton.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.invisibilityOf(popUp));
	}
	
	
	public void verifyFile(String fileName) {
   obj1.verifyIfFileIsPresent(fileName);
	}

	public void delete(String deleteFolder) {
		obj1.deleteFiles(deleteFolder);

	}
//	public void dynamic(String movFolderNme, String Folder) {
//		obj1.draft(movFolderNme, Folder);
//		obj1.validator(movFolderNme, Folder);
//		obj1.approver(movFolderNme, Folder);
//		obj1.published(movFolderNme, Folder);
//
//	} 

}
