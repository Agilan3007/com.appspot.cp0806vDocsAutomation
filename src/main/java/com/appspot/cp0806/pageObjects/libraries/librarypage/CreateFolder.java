package com.appspot.cp0806.pageObjects.libraries.librarypage;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateFolder extends com.appspot.cp0806.base.ProjectMethods {

	public CreateFolder(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='newLibraryItem-btn']//ul")
	private WebElement newTab;
	
	@FindBy(css = "div#newLibraryItem-btn")
	private WebElement newFolder;

	@FindBy(css = "a.createNewLibraryItem-folder-btn")
	private WebElement createFolder;

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

	@FindBy(id = "Column11_cat")
	private WebElement productName;

	@FindBy(id = "Column12_cat")
	private WebElement carName;

	@FindBy(id = "Column13_cat")
	private WebElement productSpec;

	@FindBy(id = "Column14_cat")
	private WebElement comments;

	@FindBy(id = "Column15_cat")
	private WebElement googleDocLink;

	@FindBy(css = "label[for='add-new-folder-radio-yes']")
	private WebElement inheritPropertiesYes;

	@FindBy(css = "label[for='add-new-folder-radio-no']")
	private WebElement inheritPropertiesNo;
	
	@FindBy(css = ".select2-search.select2-search--dropdown #select2-search")
	private WebElement searchDropdownOptions;

	@FindBy(css = "li.select2-results__option")
	private List<WebElement> dropDownOptions;

	@FindBy(xpath = "//div[@id='newrow-modal']//button[text()='Cancel']")
	private WebElement cancelBtn;

	@FindBy(css = "#addNewRowBtn-id")
	private WebElement addButton;
	
	@FindBy(css = "input#homeGlobalSearch")
	private WebElement libLevelSearch;
	
	@FindBy(xpath = "//span[text()='Testing13Folder']")
	private WebElement editFolder;
	
	@FindBy(id = "custom-rightbaredit-btn")
	private WebElement editSettings;
	
	@FindBy(xpath = "//input[@id='Column4_cat']")
	private WebElement editSettingsOrgaloc;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement editSettingsUpdate;
	
	@FindBy(css = "#ui-id-1 li a")
    private List<WebElement> userIDs;
	
	@FindBy(id = "rightbarLoader")
	private WebElement sideBarLoader;
	
	@FindBy(css="input#homeGlobalSearch")
	private WebElement search;
	

	@FindBy(css = "div#advanceSearchLoader .loader-content")
	WebElement libraryLoader;
	

	@FindBy(css = "tr[ondblclick^='folderSearch'] span.contenttileText")
	List<WebElement> listOfFolders;
	
	

	
	private HashMap<String, WebElement> elementID = new HashMap<String, WebElement>();

	private HashMap<String, WebElement> mappingElements() {
		elementID.put("customerName", this.customerName);
		elementID.put("productionSite", this.productionSite);
		elementID.put("businessUnit", this.businessUnit);
		return elementID;
	}

	public void fillElements(String elementName, String elementOption) {

		this.waitForLoaderToFinish();
		mappingElements().get(elementName).click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOfAllElements(searchDropdownOptions));
		this.dropDownOptions.stream().filter(ele -> ele.getText().equals(elementOption)).findFirst().get().click();
	}
//		for (WebElement ele : dropDownOptions){			
//			if (ele.getText().equals(elementOption)){				
//				ele.click();
//				}else {
//				System.out.println("Dropdown not working");
//			}}}
		    
		

	public void commonMethodsFileFolder(String titleNam,String emailName,String email, String orgaloc,String category,String pjCode,String cusNumbr,String prodSpec, String cmnt) {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(title));
		this.waitForLoaderToFinish();
		this.title.sendKeys(titleNam);
		this.waitForLoaderToFinish();	
		this.email.sendKeys(emailName);
		this.selectEmailID(email);
		this.waitForLoaderToFinish();
		this.editSettingsOrgaloc.sendKeys(orgaloc);
        this.category.sendKeys(category);
		fillElements("customerName", "380 HONDA");
		fillElements("productionSite", "IIT");
		fillElements("businessUnit", "Lighting");
		this.pjCode.sendKeys(pjCode);
		this.customerDevNo.sendKeys(cusNumbr);
		this.productSpec.sendKeys(prodSpec);
		this.comments.sendKeys(cmnt);
		this.waitForLoaderToFinish();

	}

	public void waitForLibraryLoaderToFinish() {
		this.wait.until(ExpectedConditions.invisibilityOf(libraryLoader));
	}
	public boolean verifyFolderIsPresent(String title) {
		this.waitForLibraryLoaderToFinish();
		this.waitForLoaderToFinish();
		
		
	      for(int i = 0; i< listOfFolders.size(); i++) {
	         String s = listOfFolders.get(i).getText();
	         System.out.println("Text is: " + s);
	      }
	
		for (WebElement folder : listOfFolders) {
			System.out.println("libNme "+folder.getText());
			if (folder.getText().equals(title))
				System.out.println("our input"+title);
				return true;
		}
		return false;
	}


	public void addNewFolder(String title, String emailName, String email, String orgaloc, String category, String pjCode, String cusNumbr, String prodSpec, String cmnt) {
		this.waitForLoaderToFinish();
		this.newFolder.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOf(newTab));
		this.createFolder.click();
		this.waitForLoaderToFinish();
		commonMethodsFileFolder(title,emailName,email,orgaloc,category,pjCode,cusNumbr,prodSpec,cmnt);
		this.waitForLoaderToFinish();
		this.addButton.click();
		this.waitForLoaderToFinish();
		this.libLevelSearch.sendKeys(title, Keys.ENTER);
		this.waitForLoaderToFinish();
		WebElement eleFolder = driver.findElement(By.xpath("//span[text()='" + title + "']"));
		eleFolder.click();
		this.verifyFolderIsPresent(title);
		
	}
	
//	this.libLevelSearch.sendKeys(title, Keys.ENTER);
//	this.waitForLoaderToFinish();
//	WebElement eleFolder = driver.findElement(By.xpath("//span[text()='" + title + "']"));
//	eleFolder.click();
//	this.verifyFolderIsPresent(title);

	public void addNewFolderWithInherit(String title, String emailName, String email, String orgaloc, String category, String pjCode, String cusNumbr, String prodSpec, String cmnt) {
		this.waitForLoaderToFinish();
		this.newFolder.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOf(newTab));
		this.createFolder.click();
		this.waitForLoaderToFinish();
		commonMethodsFileFolder(title,emailName,email,orgaloc,category,pjCode,cusNumbr,prodSpec,cmnt);
		this.waitForLoaderToFinish();
		this.inheritPropertiesYes.click();
		this.waitForLoaderToFinish();
		this.addButton.click();
		this.waitForLoaderToFinish();


	}

	public void editFolder(String folderNme,String orgaloc) {
		this.waitForLoaderToFinish();
		this.libLevelSearch.clear();
		this.libLevelSearch.sendKeys(folderNme,Keys.ENTER);
		this.waitForLoaderToFinish();
		this.editFolder.click();
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
		this.wait.until(ExpectedConditions.elementToBeClickable(editSettings));
		this.editSettings.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(editSettingsOrgaloc));
		this.editSettingsOrgaloc.sendKeys(orgaloc);   //"Valeo"
		this.editSettingsUpdate.click();
		this.waitForLoaderToFinish();

		
	}

	

}
