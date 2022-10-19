package com.appspot.cp0806.homePageTest;
import com.appspot.cp0806.pageObjects.homepage.HomePages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;

public class CreateLibraryTest extends BaseTest {

	private VdocsApplication vDocsApp;
	private HomePages homePages;
	@BeforeTest
	public void initializePages() {
		vDocsApp = new VdocsApplication(this.driver);
		homePages = new HomePages(this.driver);
		vDocsApp.loginToVDocs("valeo.smartdocs.technical@valeo.com", "Welcome2Apps4U@2019");
	}

	@Test(dataProvider = "createLib")
	public void createLibraryTest(String libName, String libDesc, String shareDriveID, String referID) {
		homePages.getHomePageSideBar().clickNewLibrary();
		homePages.getNewLibrary().createNewLibrary(libName, libDesc, shareDriveID, referID);
	}

	@DataProvider(name = "createLib")
	public Object[][] newLibrary() {
		return new Object[][] { { "Siva_Test", "Automation Testing", "23421321#2331223", "1312351@5231" },{ "AutoTest", "Testing", "2323434#2331223", "" } };
	}

}
