package com.appspot.cp0806.pageObjects.libraries;

import org.openqa.selenium.WebDriver;

import com.appspot.cp0806.base.ProjectMethods;
import com.appspot.cp0806.pageObjects.libraries.librarypage.CreateFile;
import com.appspot.cp0806.pageObjects.libraries.librarypage.CreateFolder;
import com.appspot.cp0806.pageObjects.libraries.librarypage.DynamicApproval;
import com.appspot.cp0806.pageObjects.libraries.librarypage.librarypagecomponent.CreateFileOrLibraryOrLink;
import com.appspot.cp0806.pageObjects.libraries.librarypage.librarypagecomponent.LibraryFilesAndFolder;
import com.appspot.cp0806.pageObjects.libraries.librarypage.librarypagecomponent.LibrarySideBar;

public class Libraries extends ProjectMethods {

	private LibraryPage libraryPage;
	private LibrarySideBar librarySideBar;
	private CreateFileOrLibraryOrLink createFileOrFolder;
	private LibraryFilesAndFolder libraryFilesAndFolder;
	private CreateFile createFile;
	private CreateFolder createFolder;
	private DynamicApproval dynamicApproval;
	
	
	public Libraries(WebDriver driver) {
		super(driver);
		this.libraryPage = new LibraryPage(driver);
		librarySideBar = new LibrarySideBar(driver);
		createFileOrFolder = new CreateFileOrLibraryOrLink(driver);
		libraryFilesAndFolder = new LibraryFilesAndFolder(driver);
		this.createFile = new CreateFile(driver);
		this.createFolder = new CreateFolder(driver);
		this.dynamicApproval = new DynamicApproval(driver);
	}

	public LibraryPage getLibraryPage() {
		return libraryPage;
	}
	public LibrarySideBar getLibrarySideBar() {
		return librarySideBar;
	}

	public CreateFileOrLibraryOrLink getCreateFileOrFolder() {
		return createFileOrFolder;
	}

	public LibraryFilesAndFolder getLibraryFilesAndFolder() {
		return libraryFilesAndFolder;
	}
	

	public CreateFile getCreateFile() {
		return createFile;
	}
	
	public CreateFolder getCreateFolder() {
		return createFolder;

}
	 public DynamicApproval getDynamicApproval() {
			return dynamicApproval;
		}
}
