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

public class LibraryOwnerUpdateTest  extends BaseTest{
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
	   
	
	@Test(dataProvider="libraryOwnerCreation")
	public void runLibraryOwnerCreation(String libraryName,String email,String updatedEmail,String email1,String updatedEmail1) throws IOException {
		
		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibraryPage().libraryInfoIconButton();
		libraries.getLibraryPage().editLibrarySetting();
		libraries.getLibraryPage().libraryOwnerEmail(email);
		libraries.getLibraryPage().libraryEditSettingsUpdateButton();
		libraries.getLibraryPage().verifyOwner(updatedEmail);
		//libraries.getLibraryPage().libraryInfoIconButton();
		libraries.getLibraryPage().editLibrarySetting();
		libraries.getLibraryPage().libraryOwnerEmail(email1);
		libraries.getLibraryPage().libraryEditSettingsUpdateButton();
		libraries.getLibraryPage().verifyOwner(updatedEmail1);		
		
		
		
	} 
	
	@DataProvider(name="libraryOwnerCreation")
	public Object[][] getLibraryOwnerCreation() {
		return new Object[][] {{"Sample reference test","ashwin.kumar@valeo.com","Ashwin KUMAR","agilan.muthusamy.ext@valeo.com","me"}};

	}

}
