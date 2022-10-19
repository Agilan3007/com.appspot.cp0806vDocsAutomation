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

public class TagsTest extends BaseTest {
	private VdocsApplication vdocsApp;
	private Libraries libraries;
	private HomePages homePages;

	@BeforeClass
	public void initialisePages() {
		this.driver = DriverFactory.getDriver("chromeWithProfile");
		vdocsApp = new VdocsApplication(this.driver);
		homePages = new HomePages(driver);
		libraries = new Libraries(this.driver);
		vdocsApp.goToVDocs();
	}

	@Test(dataProvider = "tagsCreation")
	public void runTagsCreation(String libraryName, String nme, String libraryNam) throws IOException {

		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibraryPage().libraryInfoIconButton();
		libraries.getLibraryPage().editLibrarySetting();
		libraries.getLibraryPage().tagVerify(nme);
		libraries.getLibraryPage().libraryEditSettingsUpdateButton();
		libraries.getLibraryPage().libraryToHomeButton();
		libraries.getLibraryPage().enterTagNameAndVerifyLibrary(nme, libraryNam);

	}

	@DataProvider(name = "tagsCreation")
	public Object[][] getTagsCreation() {
		return new Object[][] { { "Sample reference test", "Agilan5", "Sample reference test" } };

	}

}
