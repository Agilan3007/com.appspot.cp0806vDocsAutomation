package com.appspot.cp0806.pageObjects.libraries.librarypage;

import org.openqa.selenium.WebDriver;

public class HomePage extends com.appspot.cp0806.base.ProjectMethods {
	
	private ClickLibrary clickLibrary;
	
	private DeleteFolderFile deleteFolderFile;
	private DynamicApproval dynamicApproval;

	
	

	public HomePage(WebDriver driver) {
		super(driver);
	this.clickLibrary = new ClickLibrary(driver);
	
	this.deleteFolderFile = new DeleteFolderFile(driver);
	
	this.dynamicApproval = new DynamicApproval(driver);
	
	
		
}
	
	public ClickLibrary getClickLibrary() {
		return clickLibrary;
	}
	
	
	public DeleteFolderFile getDeleteFolderFile() {
		return deleteFolderFile;
	}

	
   
    public DynamicApproval getDynamicApproval() {
		return dynamicApproval;
	}
	
}