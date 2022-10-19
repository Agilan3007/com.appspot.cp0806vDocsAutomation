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

public class LibraryDescriptionWithLinks extends BaseTest {
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

	@Test(dataProvider = "libraryDescriptionLinks")
	public void runLibraryDescriptionWithLinks(String libraryName, String url, String link) throws IOException {

		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibraryPage().libraryInfoIconButton();
		libraries.getLibraryPage().editLibrarySetting();
		libraries.getLibraryPage().libDescription(url);
		libraries.getLibraryPage().libraryEditSettingsUpdateButton();
		libraries.getLibraryPage().libDescriptionVerify(link);

	}

	@DataProvider(name = "libraryDescriptionLinks")
	public Object[][] getLibraryDescriptionWithLinks() {
		return new Object[][] { { "Sample reference test", "https://valeo-cp0806-acp.appspot.com/",
				"https://valeo-cp0806-acp.appspot.com/" } };

	}

}
