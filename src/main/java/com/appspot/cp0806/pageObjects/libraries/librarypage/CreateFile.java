package com.appspot.cp0806.pageObjects.libraries.librarypage;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateFile extends com.appspot.cp0806.base.ProjectMethods {

	public CreateFile(WebDriver driver) {
		super(driver);
	}


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

	@FindBy(css = "input#Column5_cat")
	private WebElement category;

	@FindBy(css = "select[data-label='Customer Name']")
	private WebElement customerName;

	@FindBy(css = "select[data-label='Production Site']")
	private WebElement productionSite;

	@FindBy(css = "select[data-label='Business Unit']")
	private WebElement businessUnit;

	@FindBy(id = "Column9_cat")
	private WebElement pjCode;

	@FindBy(id = "Column10_cat")
	private WebElement customerDevNo;

	@FindBy(id = "Column13_cat")
	private WebElement productSpec;

	@FindBy(id = "Column14_cat")
	private WebElement comments;

	@FindBy(css = "select[data-label='Car Brand Name']")
	private WebElement carBrandName;

	@FindBy(css = "select[data-label='Brand Model']")
	private WebElement brandModel;

	@FindBy(css = "select[data-label='Brand Year']")
	private WebElement brandYear;

	@FindBy(xpath = "//div[@id='newrow-modal']//button[text()='Cancel']")
	private WebElement cancelBtn;

	@FindBy(css = "#addNewRowBtn-id")
	private WebElement addButton;
	
	@FindBy(css = "input#homeGlobalSearch")
	private WebElement libLevelSearch;
	
	@FindBy(xpath = "//span[text()='Testing1File']")
	private WebElement editFile;
	
	@FindBy(id = "custom-rightbaredit-btn")
	private WebElement editSettings;
	
	@FindBy(xpath = "//input[@id='Column4_cat']")
	private WebElement editSettingsOrgaloc;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement editSettingsUpdate;
	
	@FindBy(id = "add-file-new")
	private WebElement addFile;
	
	@FindBy(id = "rightbarLoader")
	private WebElement sideBarLoader;
	
	@FindBy(css="#ui-id-1 li a")
	private List<WebElement> emailOptions;
	
	@FindBy(css="#ui-id-3 li a")
	private List<WebElement> emailOptions1;
	
	@FindBy(css="#ui-id-4 li a")
	private List<WebElement> emailOptions2;
	

	
	@FindBy(css = "input#Column31_cat")
	private WebElement email2;
	
	
	
	public  void addNewFile(String titleNam,String emailName,String email, String orgaloc,String category,String pjCode,String cusNumbr,String prodSpec, String cmnt) {
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(newFile));
		this.newFile.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOf(newTab));
		//this.wait.until(ExpectedConditions.elementToBeClickable(createFile));
		this.createFile.click();
		this.waitForLoaderToFinish();
		CreateFolder obj = new CreateFolder(driver);
		obj.commonMethodsFileFolder(titleNam,emailName,email,orgaloc,category,pjCode,cusNumbr,prodSpec,cmnt);
		this.waitForLoaderToFinish();
//		this.wait.until(ExpectedConditions.elementToBeClickable(email2));
//		this.email2.sendKeys(emailNam);
//		this.waitForLoaderToFinish();
//		this.selectEmailID(emailOptions2,emailNam);
		this.addButton.click();
		this.waitForLoaderToFinish();

}


	
	
	public void editFile(String fileNme,String orgaloc) {
		this.waitForLoaderToFinish();
		this.libLevelSearch.clear();
		this.libLevelSearch.sendKeys(fileNme,Keys.ENTER);
		this.waitForLoaderToFinish();
		this.editFile.click();
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
		this.wait.until(ExpectedConditions.elementToBeClickable(editSettings));
		this.editSettings.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(editSettingsOrgaloc));
		this.waitForLoaderToFinish();
		this.editSettingsOrgaloc.sendKeys(orgaloc);  // "ValeoFile"
		this.editSettingsUpdate.click();
		this.waitForLoaderToFinish();
		
	

	}
	
	private void File(String titleNmeFil,String emailName) {
		
		this.waitForLoaderToFinish();
		this.newFile.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOf(newTab));
		this.createFile.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(title));
        this.waitForLoaderToFinish();
		this.title.sendKeys(titleNmeFil);
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(email));
		this.email.sendKeys(emailName);
		this.waitForLoaderToFinish();
		this.selectEmailID(emailOptions,emailName);
		this.waitForLoaderToFinish();
		this.addButton.click();
		this.waitForLoaderToFinish();
	}
	
	
}
