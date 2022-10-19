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

public class  MultipleDocumentWorkflowApprovalTest extends BaseTest {
	
	
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
  @Test(dataProvider="dynamicApprovalNewFile1Data", priority = -1)
  public void runNewFile1(String libraryName,String fileTitle, String userEmail) throws IOException {
	  homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibrarySideBar().clickNewButton().selectFileOption();
	 libraries.getCreateFileOrFolder().createFile(fileTitle, userEmail);
	 
   
}
  @Test(dataProvider="dynamicApprovalNewFile2Data", priority = 0)
  public void runNewFile2(String fileTitle, String userEmail) {
	  libraries.getLibrarySideBar().clickNewButton().selectFileOption();
	  libraries.getCreateFileOrFolder().createFile(fileTitle, userEmail);	
   
}
  @Test(dataProvider="dynamicApprovalData" , priority = 1)
  public void runDynamicApproval(String file) {
	  
	  
	  libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().multipleDocumentWorkflowApprovalDraft();
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().multipleDocumentWorkflowApprovalValidator();
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().multipleDocumentWorkflowApprovalApprover();
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().multipleDocumentWorkflowApprovalPublished(file);
	  
	  
	 
	
   
}
  @DataProvider(name="dynamicApprovalNewFile1Data")
  public Object[][] getNewFileData1() {
	  return new Object[][] {{"Sample reference test","DynamicApproval","agilan.muthusamy.ext@valeo.com"}};
	  

}
  @DataProvider(name="dynamicApprovalNewFile2Data")
  public Object[][] getNewFileData2() {
	  return new Object[][] {{"DynamicApproval","agilan.muthusamy.ext@valeo.com"}};
	  

}
  
  @DataProvider(name="dynamicApprovalData")
  public Object[][] getDynamicApprovalData() {
	  return new Object[][] {{"DynamicApproval"}};
	  

}
}
