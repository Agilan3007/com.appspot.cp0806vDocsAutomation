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

public class DocumentDetailsTest extends BaseTest {

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

	@Test(dataProvider = "fileData")
	public void runCreateFile(String libraryName, String title, String emailName, String email, String orgaloc,
			String category, String pjCode, String cusNumbr, String prodSpec, String cmnt) throws IOException {
		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getCreateFile().addNewFile(title, emailName, email, orgaloc, category, pjCode, cusNumbr, prodSpec, cmnt);
		
	}

	@Test(dataProvider = "documentData", dependsOnMethods = "runCreateFile")
	public void runDocumentDeatils(String title, String parentName, String requestedBy, String createdOn, String email,
			String orgaloc, String comments, String cmnt) throws IOException {
		libraries.getLibraryFilesAndFolder().selectFile(title);
        libraries.getLibraryFilesAndFolder().detailsTab(parentName, requestedBy, createdOn, email, orgaloc, comments);
        libraries.getLibraryFilesAndFolder().activityTab();
        libraries.getLibraryFilesAndFolder().approvalsTab(cmnt);

	}

	@DataProvider(name = "fileData")
	public Object[][] getFileData() {

		return new Object[][] { { "Sample reference test", "Testing1File", "agilan.muthusamy.ext@valeo.com",
				"agilan.muthusamy.ext@valeo.com", "Valeo", "General", "4124", "122", "confidential",
				"AutomatingDocuments" } };

	}
	

	@DataProvider(name = "documentData")
	public Object[][] getDocumentDetailsData() {
		return new Object[][] { { "Testing1File", "Sample reference test", "me", "Sep 26, 2022",
				"agilan.muthusamy.ext@valeo.com", "Valeo", "AutomatingDocuments", "Comment Working" } };

	}
	
	
	
}
