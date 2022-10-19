package com.appspot.cp0806.createlibrarytest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appspot.cp0806.base.DriverFactory;
import com.appspot.cp0806.base.ProjectMethods;
import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;
import com.appspot.cp0806.pageObjects.homepage.HomePages;
import com.appspot.cp0806.pageObjects.libraries.Libraries;

public class LibraryDetailsTest extends BaseTest {

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

	@Test(dataProvider = "libData")
	public void runLibraryDetails(String libraryName, String libName, String libDesc, String libOwner,
			String libCreatedOn, String libTags) throws IOException {
		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibraryPage().libraryInfoIconButton();
		libraries.getLibraryPage().LibraryDetails(libName, libDesc, libOwner, libCreatedOn, libTags);
		libraries.getLibraryPage().activityTab();
	}

	@DataProvider(name = "libData")
	public Object[][] getLibraryDetailsData() {
		return new Object[][] { { "Sample reference test", "Sample reference test", "https://valeo-cp0806-acp.appspot.com/",
				"me", "Jan 5, 2022", "Agilan5" } };

	}

}
