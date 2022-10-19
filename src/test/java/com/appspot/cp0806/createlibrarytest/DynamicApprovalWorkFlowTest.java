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

public class DynamicApprovalWorkFlowTest extends BaseTest {
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

	@Test(dataProvider = "fileCreation")
	public void runDynamicFile(String libraryName, String titleNmeFil, String emailName, String emailNam,
			String fileName) throws IOException {

		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getDynamicApproval().newFile(titleNmeFil, emailName, emailNam);
		libraries.getLibraryFilesAndFolder().verifyIfFileIsPresent(fileName);
		

	}

	@Test(dataProvider = "dynamicData", dependsOnMethods = "runDynamicFile")
	public void runDynamicWorkFlow(String file) {

		
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
		libraries.getLibraryFilesAndFolder().draftDynamicApprover();
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
		libraries.getLibraryFilesAndFolder().validator();
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
		libraries.getLibraryFilesAndFolder().approver();
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
		libraries.getLibraryFilesAndFolder().published();
		
	}

	@Test(dataProvider = "deleteData", dependsOnMethods = "runDynamicWorkFlow")
	public void runDeleteData(String deleteFolder) {

		libraries.getDynamicApproval().delete(deleteFolder);

	}

	@DataProvider(name = "fileCreation")
	public Object[][] getDynamicFile() {
		return new Object[][] { { "Sample reference test", "DynamicApprovalCheck", "agilan.muthusamy.ext@valeo.com",
				"ashwin.kumar@valeo.com", "DynamicApprovalCheck" } };

	}

	@DataProvider(name = "dynamicData")
	public Object[][] getDynamicWorkFlow() {
		return new Object[][] { { "DynamicApprovalCheck"} };

	}

	@DataProvider(name = "deleteData")
	public Object[][] getDeleteData() {
		return new Object[][] { { "DynamicApprovalCheck" } };

	}

}


