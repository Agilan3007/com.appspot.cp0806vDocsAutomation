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

public class DeleteFileTest extends BaseTest {
	private VdocsApplication vdocs;
	private HomePages homePages;
	private Libraries libraries;

	@BeforeClass
	public void initialisePages() {
		this.driver = DriverFactory.getDriver("chromeWithProfile");
		vdocs = new VdocsApplication(this.driver);
		homePages = new HomePages(driver);
		libraries = new Libraries(this.driver);
		vdocs.goToVDocs();

	}

	@Test(dataProvider = "deleteFileData")
	public void runDeleteFile(String libraryName, String fileNme) throws IOException {

		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibraryFilesAndFolder().deleteFileIconCheck(fileNme);

	}

	@DataProvider(name = "deleteFileData")
	public Object[][] getDeleteFileData() {

		return new Object[][] { { "Sample reference test", "Testing1File" } };

	}
}
