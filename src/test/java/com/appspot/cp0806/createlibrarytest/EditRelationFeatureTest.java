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

public class EditRelationFeatureTest  extends BaseTest {

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
	
	@Test(dataProvider="enableRelationFalseData")
	public void runEditRelationButtonFunctionalityFalse(String libraryName,String fileTitle, String userEmail1,String relationFileNme) throws IOException {
		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibraryPage().libraryInfoIconButton();
		libraries.getLibraryPage().editLibrarySetting();
		libraries.getLibraryPage().enableRelationAllowTrue();
		libraries.getLibraryPage().libraryEditSettingsUpdateButton();
		libraries.getLibrarySideBar().clickNewButton().selectFileOption();
		libraries.getCreateFileOrFolder().createFile(fileTitle, userEmail1);
		libraries.getLibraryFilesAndFolder().selectFile(fileTitle);
		//libraries.getLibraryFilesAndFolder().detailsTabFolderAndFile();
		libraries.getLibraryFilesAndFolder().enableRelationButton();
		libraries.getLibraryFilesAndFolder().enableRelationButtonAddingFile(relationFileNme);
		

	}
	@Test(dataProvider="enableRelationTrueData",dependsOnMethods="runEditRelationButtonFunctionalityFalse")
	public void runEditRelationButtonFunctionalityTrue(String fileTitle1, String userEmail1) throws IOException {
		libraries.getLibraryPage().refresh();
		libraries.getLibraryPage().libraryInfoIconButton();
		libraries.getLibraryPage().editLibrarySetting();
		libraries.getLibraryPage().enableRelationAllowTrue();
		libraries.getLibraryPage().libraryEditSettingsUpdateButton();
		libraries.getLibrarySideBar().clickNewButton().selectFileOption();
		libraries.getCreateFileOrFolder().createFile(fileTitle1, userEmail1);
		libraries.getLibraryFilesAndFolder().selectFile(fileTitle1);
		//libraries.getLibraryPage().enableRelationButton();
		

	}
	
	


	
//	
//	@Test(dataProvider="deleteData",dependsOnMethods="runVerifyFolderFile")
//	public void runDeleteData(String deleteFolder,String deleteFile) {
//		libraries.getLibraryFilesAndFolder().deleteFolder(deleteFolder);
//		libraries.getLibraryFilesAndFolder().deleteFiles(deleteFile);
//		
//	
//		
//	}

	@DataProvider(name = "enableRelationFalseData")
	public Object[][] getEditRelationButtonFunctionalityFalse() {
		return new Object[][] { { "Sample reference test", "EnableRelationFileOne", "agilan.muthusamy.ext@valeo.com","EnableRelationFileOne"} };

	}

	@DataProvider(name = "enableRelationTrueData")
	public Object[][] getEditRelationButtonFunctionalityTrue() {
		return new Object[][] { { "EnableRelationFileTwo", "agilan.muthusamy.ext@valeo.com" } };

	}

	
	
//	@DataProvider(name="deleteData")
//	public Object[][] getDeleteData() {
//		return new Object[][] {{"AgilanFolderOne" ,"AgilanFileOne"},{"COPYFOLDER", "COPYFILE" }};
//
//	}
}