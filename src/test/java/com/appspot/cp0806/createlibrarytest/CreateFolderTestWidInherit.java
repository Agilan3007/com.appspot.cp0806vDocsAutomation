package com.appspot.cp0806.createlibrarytest;
import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;
import com.appspot.cp0806.pageObjects.homepage.HomePages;
import com.appspot.cp0806.pageObjects.libraries.Libraries;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateFolderTestWidInherit extends BaseTest {
	
	 private VdocsApplication  vdocsApp;
	 private HomePages homePages;
	 private Libraries libraries;
	 
	 @BeforeClass
	 public void testPage() {
	 this.driver = com.appspot.cp0806.base.DriverFactory.getDriver("chromeWithProfile");	 
     vdocsApp = new VdocsApplication(this.driver);
     homePages = new HomePages(driver);
     libraries = new Libraries(this.driver);
     vdocsApp.goToVDocs();
     System.out.println("This method run - testpage()");
     
	}
	 
	 @Test(dataProvider="folderDataWidInherit")
    public void runFolderWidInherit(String libraryName,String title,String emailName,String email,String orgaloc,String category,String pjCode,String cusNumbr,String prodSpec, String cmnt) throws IOException {
		 System.out.println("create folder with inherit");
		 homePages.getAdvanceSearch().enterSearchText(libraryName);
			homePages.getHomePageLibraryList().clickLibrary(libraryName);
			libraries.getCreateFolder().addNewFolderWithInherit(title, emailName, email, orgaloc, category, pjCode, cusNumbr, prodSpec, cmnt);
			

	}
	 
	 @DataProvider(name="folderDataWidInherit")
	 public Object[][] getFolderDataWidInherit() {
		 
		 return new Object[][] {{"Sample reference test","Testing1Folder","agilan.muthusamy.ext@valeo.com","agilan.muthusamy.ext@valeo.com","Chennai","General","4124","122","confidential","Code working"}};

	}
}
