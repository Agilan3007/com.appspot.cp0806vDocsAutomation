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

public class NplusOneWorkFlowValidationTest  extends BaseTest{
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
		   
		
		@Test(dataProvider="fileCreation")
		public void runNplusOneFile(String libraryName,String fileTitle, String userEmail,String fileName) throws IOException {
			
			homePages.getAdvanceSearch().enterSearchText(libraryName);
			homePages.getHomePageLibraryList().clickLibrary(libraryName);
			libraries.getCreateFileOrFolder().createFile(fileTitle, userEmail);
			libraries.getLibraryFilesAndFolder().verifyIfFileIsPresent(fileName);
			
			
		}

		
		
		@Test(dataProvider="nPlusOneData",dependsOnMethods="runNplusOneFile")
		public void runNplusOneWorkFlow(String file) {
			
			libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
			libraries.getLibraryFilesAndFolder().selectFile(file);
			libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
			libraries.getLibraryFilesAndFolder().draft();
			libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
			libraries.getLibraryFilesAndFolder().selectFile(file);
			libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
			libraries.getLibraryFilesAndFolder().validatorNplusOne();
			libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
			libraries.getLibraryFilesAndFolder().selectFile(file);
			libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
			libraries.getLibraryFilesAndFolder().approver();
			libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
			libraries.getLibraryFilesAndFolder().selectFile(file);
			libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
			libraries.getLibraryFilesAndFolder().published();
			
		}
		
		
		
		
		@Test(dataProvider="deleteData",dependsOnMethods="runNplusOneWorkFlow")
		public void runDeleteData(String deleteFolder) {
			
		
			libraries.getLibraryFilesAndFolder().deleteFolder(deleteFolder);
			
		}

		
		
		
		@DataProvider(name="fileCreation")
		public Object[][] getNplusOneFile() {
			return new Object[][] {{"Sample reference test","N+1File","agilan.muthusamy.ext@valeo.com","N+1File"}};

		}
		
		
		@DataProvider(name="nPlusOneData")
		public Object[][] getNplusOneWorkFlow() {
			return new Object[][] {{"N+1File"}};

		}
		
		
		@DataProvider(name="deleteData")
		public Object[][] getDeleteData() {
			return new Object[][] {{"N+1File"}};

		}


	}


