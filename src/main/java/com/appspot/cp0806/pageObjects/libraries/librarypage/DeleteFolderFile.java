package com.appspot.cp0806.pageObjects.libraries.librarypage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteFolderFile extends com.appspot.cp0806.base.ProjectMethods {

	public DeleteFolderFile(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//span[text()='Testing13Folder']")
	private WebElement delFolderClick;
	
	@FindBy(xpath = "//i[text()='delete']")
	private WebElement delFolderIcon;
	
	@FindBy(xpath = "//span[text()='Testing1File']")
	private WebElement delFileClick;
	
	@FindBy(xpath = "//i[text()='delete']")
	private WebElement delFileIcon;
	
	@FindBy(css = "input#homeGlobalSearch")
	private WebElement libLevelSearch;
	
	
	
	public void deleteFolder(String folderNme ) {
	this.waitForLoaderToFinish();
	this.libLevelSearch.sendKeys(folderNme,Keys.ENTER);
	this.waitForLoaderToFinish();	
    this.delFolderClick.click();
    this.waitForLoaderToFinish();
    boolean displayed = this.delFolderIcon.isDisplayed();
    System.out.println("DeleteFolderIcon is Displayed: "+ displayed);
	}
	
	public void deleteFile(String fileNme ) {
	this.waitForLoaderToFinish();
	this.libLevelSearch.sendKeys(fileNme,Keys.ENTER);
	this.waitForLoaderToFinish();	
    this.delFileClick.click();
    this.waitForLoaderToFinish();
    boolean displayed1 = this.delFileIcon.isDisplayed();
    System.out.println("DeleteFileIcon is Displayed: "+displayed1);
    
	}
	
}
