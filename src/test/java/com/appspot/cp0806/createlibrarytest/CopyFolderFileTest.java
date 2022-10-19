package com.appspot.cp0806.createlibrarytest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appspot.cp0806.base.DriverFactory;
import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;
import com.appspot.cp0806.pageObjects.homepage.HomePages;
import com.appspot.cp0806.pageObjects.libraries.Libraries;

public class CopyFolderFileTest extends BaseTest {

	private VdocsApplication vdocsApp;
	private HomePages homePages;
	private Libraries libraries;

	@BeforeClass
	public void initialisePages() {
		this.driver = DriverFactory.getDriver("chromeWithProfile");
		vdocsApp = new VdocsApplication(this.driver);
		homePages = new HomePages(driver);
		libraries = new Libraries(this.driver);
		vdocsApp.goToVDocs();
	}

	@Test(dataProvider = "createFolderFile")
	public void runCreateFolderFile(String libraryName,String folderTitle, String userEmail, String fileTitle, String userEmail1) throws IOException {

		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibrarySideBar().clickNewButton().selectFolderOption();
		libraries.getCreateFileOrFolder().createFolder( folderTitle,  userEmail);
		libraries.getLibrarySideBar().clickNewButton().selectFileOption();
		libraries.getCreateFileOrFolder().createFile(fileTitle, userEmail1);

	}

	@Test(dataProvider = "copyFolderFile", dependsOnMethods = "runCreateFolderFile")
	public void runCopyFolderFile(String title, String copyName) {

		libraries.getLibraryFilesAndFolder().selectFolder(title);
		libraries.getLibrarySideBar().makeCopy(copyName);

	}

	@Test(dataProvider = "copyFolderFile1", dependsOnMethods = "runCopyFolderFile")
	public void runCopyFolderFile1(String title, String copyName) {
		libraries.getLibraryFilesAndFolder().selectFile(title);
		libraries.getLibrarySideBar().makeCopy(copyName);
	}

	@Test(dataProvider = "verifyFolderFile", dependsOnMethods = "runCopyFolderFile1")
	public void runVerifyFolderFile(String folderName, String fileName) {

		libraries.getLibraryFilesAndFolder().verifyFolderIsPresent(folderName);
		libraries.getLibraryFilesAndFolder().verifyIfFileIsPresent(fileName);
	}
	
	@Test(dataProvider="deleteData",dependsOnMethods="runVerifyFolderFile")
	public void runDeleteData(String deleteFolder,String deleteFile) {
		libraries.getLibraryFilesAndFolder().deleteFolder(deleteFolder);
		libraries.getLibraryFilesAndFolder().deleteFiles(deleteFile);
		
	
		
	}

	@DataProvider(name = "createFolderFile")
	public Object[][] getCreateFolderFile() {
		return new Object[][] { { "Sample reference test", "AgilanFolderOne", "agilan.muthusamy.ext@valeo.com",
				"AgilanFileOne", "agilan.muthusamy.ext@valeo.com" } };

	}

	@DataProvider(name = "copyFolderFile")
	public Object[][] getCopyFolderFile() {
		return new Object[][] { { "AgilanFolderOne", "COPYFOLDER" } };

	}

	@DataProvider(name = "copyFolderFile1")
	public Object[][] getCopyFolderFile1() {
		return new Object[][] { { "AgilanFileOne", "COPYFILE" } };

	}

	@DataProvider(name = "verifyFolderFile")
	public Object[][] getVerifyFolderFile() {
		return new Object[][] { { "COPYFOLDER", "COPYFILE" } };

	}
	
	@DataProvider(name="deleteData")
	public Object[][] getDeleteData() {
		return new Object[][] {{"AgilanFolderOne" ,"AgilanFileOne"},{"COPYFOLDER", "COPYFILE" }};

	}

}
