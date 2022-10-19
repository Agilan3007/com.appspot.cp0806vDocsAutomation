package com.appspot.cp0806.homePageTest;
import com.appspot.cp0806.pageObjects.homepage.HomePages;
import com.appspot.cp0806.pageObjects.homepage.homePagecomponents.HomePageSideBar;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appspot.cp0806.base.DriverFactory;
import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;
import com.google.common.util.concurrent.Uninterruptibles;

public class SearchLibraryTest extends BaseTest {

	private VdocsApplication vDocsApp;
	private HomePages homePages;

	@BeforeTest
	public void initializePages() {
		vDocsApp = new VdocsApplication(this.driver);
		homePages = new HomePages(this.driver);
//		vDocsApp.loginToVDocs();
		vDocsApp.goToVDocs();
	}

	@Test(dataProvider = "searchLib", priority = 1)
	public void TestGlobalSearchLibrary(String searchItem) throws IOException {
		homePages.getAdvanceSearch().enterSearchText(searchItem);
		homePages.getHomePageLibraryList().verifyIfTheLibraryIsPresent(searchItem);
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
	}

	@Test(dependsOnMethods = "TestGlobalSearchLibrary", dataProvider = "AdvanceSearchLib")
	public void TestAdvanceSearchLibrary(String libName, String libDesc) throws IOException {
		homePages.getAdvanceSearch().clickAdvanceSearchIcon();
		homePages.getAdvanceSearch().enterLibraryName(libName);
		homePages.getAdvanceSearch().enterLibraryDescription(libDesc);
		homePages.getAdvanceSearch().selectCreatedOn();
		homePages.getAdvanceSearch().getDateRange().clickLast7Days();
		homePages.getAdvanceSearch().selectCreatedOn();
		homePages.getAdvanceSearch().getDateRange().clickYesterday();
		homePages.getAdvanceSearch().selectCreatedOn();
		homePages.getAdvanceSearch().getDateRange().clickLastMonth();
		homePages.getAdvanceSearch().selectCreatedOn();
		homePages.getAdvanceSearch().getDateRange().clickLast30Days();
//		homePage.getAdvanceSearch().getDateRange().selectCustomDateRange("09/01/2022 - 25/01/2022");
//		homePage.getAdvanceSearch().getDateRange().clickApplyButton();
		homePages.getAdvanceSearch().clickSearchButton();
		homePages.getHomePageLibraryList().verifyIfTheLibraryIsPresent(libName);
	}

	@DataProvider(name = "searchLib")
	public Object[][] getData() {
		return new Object[][] { { "Sprint 40" }, { "VDOCS-K Release 23" }, { "AutoSuggest" } };
	}

	@DataProvider(name = "AdvanceSearchLib")
	public Object[][] getAdvSearchLib() {
		return new Object[][] { { "BR Document Approval", "" } };
	}
//
//	@AfterTest
//	public void quitBrowser() {
//		this.driver.quit();
//	}

}
