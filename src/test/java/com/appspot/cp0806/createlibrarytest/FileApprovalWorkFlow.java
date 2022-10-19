package com.appspot.cp0806.createlibrarytest;

import com.appspot.cp0806.base.DriverFactory;
import com.appspot.cp0806.baseTest.BaseTest;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;
import com.appspot.cp0806.pageObjects.homepage.HomePages;
import com.appspot.cp0806.pageObjects.libraries.Libraries;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileApprovalWorkFlow extends BaseTest {
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

	@Test(dataProvider = "fileOneData", priority = -1)
	public void runNewFile(String libraryName, String fileTitle, String userEmail) throws IOException {

		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibrarySideBar().clickNewButton().selectFileOption();
		libraries.getCreateFileOrFolder().createFile(fileTitle, userEmail);

	}

	@Test(dataProvider = "approvalData", priority = 0)
	public void runFileApproval(String file) throws InterruptedException {

		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
		libraries.getLibraryFilesAndFolder().draft();
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

	@DataProvider(name = "fileOneData")
	public Object[][] getNewFileData() {
		return new Object[][] { { "Sample reference test", "ApprovalVerify", "agilan.muthusamy.ext@valeo.com" } };

	}

	@DataProvider(name = "approvalData")
	public Object[][] getFileApprovalData() {
		return new Object[][] { { "ApprovalVerify" } };

	}

}
