package com.appspot.cp0806.elementpresentvalidation;
import com.appspot.cp0806.base.DriverFactory;
import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;
import com.appspot.cp0806.pageObjects.homepage.HomePages;
import com.appspot.cp0806.pageObjects.homepage.homePagecomponents.HomePageLibraryList;
import com.appspot.cp0806.pageObjects.homepage.homePagecomponents.HomePageSideBar;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appspot.cp0806.pageObjects.application.ApplicationHeaderVerification;
import com.appspot.cp0806.pageObjects.libraries.LibraryElementVerification;

public class HomePageElementValidation extends BaseTest {

	private VdocsApplication vDocsApp;
	private HomePages homePages;
	private HomePageLibraryList homePageLibraryList;
	private LibraryElementVerification libraryElementVerification;
	private ApplicationHeaderVerification applicationHeaderVerification;

	@BeforeTest
	public void initializePages() {
		vDocsApp = new VdocsApplication(this.driver);
		homePages = new HomePages(this.driver);
		libraryElementVerification = new LibraryElementVerification(this.driver);
		applicationHeaderVerification = new ApplicationHeaderVerification(this.driver);
		vDocsApp.loginToVDocs("valeo.smartdocs.technical@valeo.com", "Welcome2Apps4U@2019");
//		vDocsApp.goToVDocs();
	}

	@Test(dataProvider = "libName")
	public void VerifyApplicationHeaderElements(String libName) throws IOException {
		applicationHeaderVerification.getElementPresentValidators().stream().map(ev -> ev.validate())
				.forEach(b -> assertTrue(b));

		homePages.getAdvanceSearch().enterSearchText(libName);
		homePages.getHomePageLibraryList().clickLibrary(libName);
		libraryElementVerification.expandLibraryName();
		libraryElementVerification.getElementPresentValidator().stream().map(ev -> ev.validate())
				.forEach(b -> assertTrue(b));

		boolean value = libraryElementVerification.validateAll();
		Assert.assertTrue(value);
	}

	@DataProvider(name = "libName")
	public Object[][] getData() {
		return new Object[][] { { "Release 28 Test" } };
	}
}
