package com.appspot.cp0806.createlibrarytest;
import com.appspot.cp0806.base.DriverFactory;
import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;
import com.appspot.cp0806.pageObjects.homepage.HomePages;
import com.appspot.cp0806.pageObjects.libraries.Libraries;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteFolderTest extends BaseTest {
	
	private VdocsApplication vdocsApp;
	private HomePages homePages;
	private Libraries libraries;
	
	@BeforeClass
	public void initialisePages() {
		this.driver = DriverFactory.getDriver("chromeWithProfile");
		vdocsApp = new VdocsApplication(this.driver);
		libraries = new Libraries(this.driver);
		homePages = new HomePages(driver);
        vdocsApp.goToVDocs();
	}
	@Test(dataProvider="deleteFolderData")
	public void runDeleteFolder(String libraryName,String folderNme) throws IOException {
		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibraryFilesAndFolder().deleteFolderIconCheck(folderNme);
	}
    @DataProvider(name = "deleteFolderData")
	public Object[][] getDeleteFolderData() {
   return new Object[][] {{"Sample reference test","Testing13Folder"}};
	}
}
