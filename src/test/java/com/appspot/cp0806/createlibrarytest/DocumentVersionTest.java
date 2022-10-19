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

public class DocumentVersionTest  extends BaseTest{
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
	   
	
	@Test(dataProvider="fileApproval")
	public void runVersionFile(String libraryName,String fileTitle, String userEmail,String file) throws IOException {
		
		homePages.getAdvanceSearch().enterSearchText(libraryName);
		homePages.getHomePageLibraryList().clickLibrary(libraryName);
		libraries.getLibrarySideBar().clickNewButton().selectFileOption();
		libraries.getCreateFileOrFolder().createFile(fileTitle, userEmail);
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

	
	
	@Test(dataProvider="versionData",dependsOnMethods="runVersionFile")
	public void runVersionCreation(String file,String title) {
		
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().detailsTabFolderAndFile();
		libraries.getLibraryFilesAndFolder().versionIcon();
		libraries.getLibraryFilesAndFolder().versionUpload();	
		libraries.getLibraryFilesAndFolder().newVersionFile(title);
		libraries.getLibraryFilesAndFolder().newVersionCheck();
		libraries.getLibraryFilesAndFolder().versionIconCheck();
	
		
		
	}
	
	
	@Test(dataProvider="versionDataWorkFlow",dependsOnMethods="runVersionFile")
	public void runVersionCreationWrokFlow(String file,String Comments) {
		
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().approvalTabFolderAndFileWithComment(Comments);
		libraries.getLibraryFilesAndFolder().draft();
		libraries.getLibraryFilesAndFolder().newVersionCheck();
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().approvalTabFolderAndFileWithComment(Comments);
		libraries.getLibraryFilesAndFolder().validator();
		libraries.getLibraryFilesAndFolder().newVersionCheck();
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().approvalTabFolderAndFileWithComment(Comments);
		libraries.getLibraryFilesAndFolder().approver();
		libraries.getLibraryFilesAndFolder().newVersionCheck();
		libraries.getLibraryFilesAndFolder().searchTheLibrary(file);
		libraries.getLibraryFilesAndFolder().selectFile(file);
		libraries.getLibraryFilesAndFolder().approvalTabFolderAndFile();
		libraries.getLibraryFilesAndFolder().published();
		libraries.getLibraryFilesAndFolder().newVersionCheck();
	
		
		
	}
	
	@Test(dataProvider="deleteData",dependsOnMethods="runVersionCreationWrokFlow")
	public void runDeleteData(String deleteFile) {
		libraries.getLibraryFilesAndFolder().deleteFiles(deleteFile);
		
	
		
	}

	
	
	
	@DataProvider(name="fileApproval")
	public Object[][] getVersionFileData() {
		return new Object[][] {{"Sample reference test","ApprovalVerify","agilan.muthusamy.ext@valeo.com","ApprovalVerify"}};

	}
	
	
	@DataProvider(name="versionData")
	public Object[][] getNewVersionData() {
		return new Object[][] {{"ApprovalVerify","VersionFile"}};

	}
	
	@DataProvider(name="versionDataWorkFlow")
	public Object[][] getNewVersionDataWrokFlow() {
		return new Object[][] {{"VersionFile","Comment for version"}};

	}
	
	
	@DataProvider(name="deleteData")
	public Object[][] getDeleteData() {
		return new Object[][] {{"VersionFile"}};

	}


}
