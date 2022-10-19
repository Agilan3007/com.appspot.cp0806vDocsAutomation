package com.appspot.cp0806.createlibrarytest;
import com.appspot.cp0806.base.DriverFactory;
import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;
import com.appspot.cp0806.pageObjects.homepage.HomePages;
import com.appspot.cp0806.pageObjects.libraries.Libraries;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class UpdateFolderTest extends BaseTest {
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

	@Test(dataProvider="FolderData")
     public void runFolder(String libraryName,String title, String emailName, String email, String orgaloc, String category,
 			String pjCode, String cusNumbr, String prodSpec, String cmnt) throws IOException {
		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getCreateFolder().addNewFolder(title, emailName, email, orgaloc, category, pjCode, cusNumbr, prodSpec, cmnt);

	}
	
	@Test(dataProvider="updateFolderData")
    public void runUpdateFolder(String folderNme , String orgaloc) {
		libraries.getCreateFolder().editFolder(folderNme, orgaloc);

	}
	@DataProvider(name="FolderData")
	public Object[][] getFolder() {
      return new Object[][] {{"Sample reference test", "Testing13Folder", "agilan.muthusamy.ext@valeo.com", "agilan.muthusamy.ext@valeo.com",
			"Chennai", "General", "4124", "122", "confidential", "Code working"}};
	}
	
	@DataProvider(name="updateFolderData")
	public Object[][] getUpdateFolder() {
      return new Object[][] {{"Testing13Folder","ValeoFolder"}};
	}
}
