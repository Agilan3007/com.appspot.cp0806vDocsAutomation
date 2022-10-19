package com.appspot.cp0806.homePageTest;
import com.appspot.cp0806.pageObjects.homepage.HomePages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;

public class VerifyLibrariesPresenceTest extends BaseTest {

	private VdocsApplication vDocsApp;
	private HomePages homePages;

	@BeforeTest
	public void initializePages() {
		vDocsApp = new VdocsApplication(this.driver);
		homePages = new HomePages(this.driver);
//		vDocsApp.loginToVDocs();
		vDocsApp.goToVDocs();
	}

	@Test(dataProvider = "libraries")
	public void verifyLibrariesPresent(String alLib, String stdLib, String encryLib) {
		homePages.getHomePageSideBar().clickAllLibraries();
		homePages.getHomePageLibraryList().verifyIfTheLibraryIsPresent(alLib);

		homePages.getHomePageSideBar().clickStandardLibraries();
		homePages.getHomePageLibraryList().verifyIfTheLibraryIsPresent(stdLib);

		homePages.getHomePageSideBar().clickValeoEncryptedLibraries();
		homePages.getHomePageLibraryList().verifyIfTheLibraryIsPresent(encryLib);
	}

	@DataProvider(name = "libraries")
	public Object[][] checkLibraries() {
		return new Object[][] { { "Sprint 40", "AutoSuggest", "VDOCS-K Release 21" } };
	}

}
