package com.appspot.cp0806.createlibrarytest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appspot.cp0806.base.DriverFactory;
import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;
import com.appspot.cp0806.pageObjects.homepage.HomePages;
import com.appspot.cp0806.pageObjects.libraries.Libraries;

public class ContributorNewIconCheck  extends BaseTest {

	private VdocsApplication vdocsApp;
	private HomePages homePages;
	private Libraries libraries;

	@BeforeTest
	public void openVDocs() {
		this.driver = DriverFactory.getDriver("chrome");
	}

	@BeforeClass
	public void initialisePages() {
		// this.driver = DriverFactory.getDriver("chrome");
		vdocsApp = new VdocsApplication(this.driver);
		libraries = new Libraries(this.driver);
		homePages = new HomePages(driver);
		vdocsApp.loginToVDocs("vedm.technical@valeo.com", "1S0ff1c3_2019");
		//vdocsApp.goToVdocs();
	}

	@Test(dataProvider = "selectLib")
	public void runlib(String libraryName) throws IOException {
		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibraryPage().iconNewCheck();

	}
	@DataProvider(name = "selectLib")
	public Object[][] libraryName() {
		return new Object[][] { { "Sample reference test" } };
	}
}

 
