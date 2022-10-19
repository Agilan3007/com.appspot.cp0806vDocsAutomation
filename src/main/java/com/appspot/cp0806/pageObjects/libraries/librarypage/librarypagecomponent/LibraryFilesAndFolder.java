package com.appspot.cp0806.pageObjects.libraries.librarypage.librarypagecomponent;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.appspot.cp0806.base.ProjectMethods;
import com.appspot.cp0806.pageObjects.application.GlobalSearch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LibraryFilesAndFolder extends ProjectMethods {

	private GlobalSearch globalSearch;

	@FindBy(css = "span#shareFolder")
	WebElement shareIcon;

	@FindBy(css = "div#share-folder-modal div.modal-content")
	WebElement shareModelContent;

	@FindBy(css = "table#shareFolderdataTable input#select2-search")
	WebElement enterPeopleOrGroupOfShareFolder;

	@FindBy(css = "span.select2-results li")
	List<WebElement> listOfUsers;

	@FindBy(css = "div#share-folder-modal select#ActualRoles_cat")
	WebElement selectScopeForShare;

	@FindBy(css = "div#share-folder-modal div.modal-footer>button")
	WebElement shareButtonInShareWindow;

	// Share folder elements - end

	@FindBy(id = "copyitem")
	WebElement copyIcon;

	@FindBy(css = "span#moveto")
	WebElement moveIcon;

	@FindBy(id = "deleteItem")
	WebElement deleteIcon;

	@FindBy(css = "tr[ondblclick^='folderSearch'] span.contenttileText")
	List<WebElement> listOfFolders;

	@FindBy(css = "tr[ondblclick^='window.open'] span.contenttileText")
	List<WebElement> listOfFiles;

	@FindBy(id = "move-to-section")
	WebElement moveToWindow;

	@FindBy(css = "div.moveto-footer button#moveto-submit")
	WebElement moveToButton;

	@FindBy(css = "div#moveto-confirmation-Modal")
	WebElement moveToConfirmationWindow;

	@FindBy(css = "div#moveto-confirmation-Modal div#moveto-confirmation-text")
	WebElement moveToConfirmationMessage;

	@FindBy(css = "div#moveto-confirmation-Modal button#ok-move-inherit")
	WebElement moveToOKButton;

	@FindBy(css = "div#rightbarLoader")
	WebElement informationLoader;

	@FindBy(css = "div#title-header-div div#breadcrumbs-div-id a")
	List<WebElement> folderBreadcCrumb;

	@FindBy(css = "span#undo-action-text")
	WebElement removeItemMessage;

	@FindBy(css = "a#loadMoreItem")
	WebElement loadMoreButton;

	@FindBy(css = "span.backbtn i")
	WebElement searchBackButton;

	@FindBy(xpath = "//i[text()='delete']")
	private WebElement delFolderIcon;

	@FindBy(xpath = "//i[text()='delete']")
	private WebElement delFileIcon;

	@FindBy(css = "input#homeGlobalSearch")
	private WebElement libLevelSearch;

	@FindBy(id = "details-scrollablebtn")
	private WebElement detailsTab;

	@FindBy(id = "approvals-scrollablebtn")
	private WebElement approvalsTab;

	@FindBy(css = "div.approvalPending-wrapper")
	private WebElement approvalPendingDispalyed;

	@FindBy(css = "#approveComments")
	private WebElement apaComment;

	@FindBy(xpath = "//button[@id='0_aprovalBtn']")
	private WebElement sendForApprovalDisplayed;

	@FindBy(xpath = "(//button[@id='0_aprovalBtn'])[2]")
	private WebElement forceSendForApproval;

	@FindBy(id = "custom-manage-version-btn")
	private WebElement manageVersionButton;

	@FindBy(id = "custom-rightbaredit-btn")
	private WebElement editPropertiesButton;

	@FindBy(id = "save-edit-relation-btn")
	private WebElement saveEditRealtionButton;

	@FindBy(id = "workflow-scrollablebtn")
	private WebElement activityTab;

	@FindBy(xpath = "//div[@class='comment-holder']//div")
	private WebElement documentLastModifiedDate;

	@FindBy(xpath = "//div[@class='comment-holder']//div[2]")
	private WebElement documentLastModifiedActivity;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[2]")
	private WebElement parentName;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[3]")
	private WebElement requestedBy;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[4]")
	private WebElement createdOn;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[8]")
	private WebElement email;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[9]")
	private WebElement orgaloc;

	@FindBy(xpath = "(//div[@id='details-scrollable-data'] //div[@class='bardetails-right'])[19]")
	private WebElement comments;

	@FindBy(id = "rightbarLoader")
	private WebElement sideBarLoader;

	@FindBy(css = "#copyFilenameTxt")
	private WebElement copyEnterName;

	@FindBy(xpath = "(//button[text()='Yes'])[1]")
	private WebElement acceptBtn;

	@FindBy(css = "li#approvals-scrollablebtn")
	private WebElement approvalTab;

	@FindBy(xpath = "//button[text()='Send For Approval']")
	private WebElement draftClick;

	@FindBy(xpath = "//button[text()='Approve']")
	private WebElement approverClick;

	@FindBy(xpath = "//span[text()='Published']")
	private WebElement checkStatus;

	@FindBy(css = "span.informationicon")
	private WebElement info;

	@FindBy(css = "div[role='alertdialog']")
	private WebElement popUp;

	@FindBy(css = "li#workflow-scrollablebtn")
	private WebElement activity;

	@FindBy(xpath = "(//span[@class='comment-view'])[1]")
	private WebElement verifyActivity;

	@FindBy(xpath = "(//span[text()='2'])[1]")
	private WebElement versionNo;

	@FindBy(css = "img[data-original-title='ashwin.kumar@valeo.com']")
	private WebElement dynamicApproverName;

	@FindBy(id = "add-on-approval")
	private WebElement multiApproval;

	@FindBy(xpath = "//div[@id='mutliapproval-btn-html']//button")
	private WebElement approveButton;

	@FindBy(id = "nextApproversDivMultiSelect-id")
	private WebElement verifyPublished;

	@FindBy(css = "div#addonapproval-modal h4")
	private WebElement window;

	@FindBy(xpath = "(//span[text()='Published'])[1]")
	private WebElement statusCheckOne;

	@FindBy(xpath = "(//span[text()='Published'])[2]")
	private WebElement statusCheckTwo;

	@FindBy(xpath = "//span[text()='DynamicApproval']")
	private WebElement fileOne;

	@FindBy(xpath = "(//span[text()='DynamicApproval'])[2]")
	private WebElement fileTwo;

	@FindBy(css = "span#custom-manage-version-btn")
	private WebElement versionIcon;

	@FindBy(css = "button#manage-versions-upload-new-version-btn")
	private WebElement versionUpload;

	@FindBy(css = "input#itemName-Row")
	private WebElement title1;

	@FindBy(css = "#addNewRowBtn-id")
	private WebElement addButton;

	@FindBy(xpath = "//span[@class='status-col_span']")
	private WebElement checkDraft;

	@FindBy(xpath = "//span[text()='Validator']")
	private WebElement checkValidator;

	@FindBy(xpath = "//span[text()='Approver']")
	private WebElement checkApprover;

	@FindBy(xpath = "//span[text()='Published']")
	private WebElement checkPublished;

	@FindBy(xpath = "//button[@id='manage-version-close']")
	WebElement close;

	@FindBy(css = "#ui-id-23 li a")
	private List<WebElement> emailOptions1;

	@FindBy(css = "Column31_cat")
	private WebElement emailnPlus;

	@FindBy(css = "li#admin-settings-ui-id")
	private WebElement adminSettingsIcon;

	@FindBy(css = "a[onclick^='showAdminScreenFromHomePage']")
	private WebElement administrationIcon;

	@FindBy(css = "img[data-original-title='rajesh.sivakumar@valeo.com']")
	private WebElement nplusOneValidatorName;

	@FindBy(css = "div#advanceSearchLoader .loader-content")
	WebElement libraryLoader;
	
	@FindBy(css = "button[onclick^='displayRelationModal']")
	private WebElement editRelationButton;
	
	@FindBy(css = "input#select2-search[placeholder='Enter Items']")
	private WebElement editRelationButtonTextBox;
	
	@FindBy(css = "#fileSelectValues")
	private WebElement editRelationButtonTextBoxSave ;



	public LibraryFilesAndFolder(WebDriver driver) {
		super(driver);
		globalSearch = new GlobalSearch(driver);
	}

	public void invisibilityOfSideBarLaoder() {
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
	}

	public void waitForLibraryLoaderToFinish() {
		long loaderStart = System.currentTimeMillis();
		this.wait.until(ExpectedConditions.invisibilityOf(libraryLoader));
		long loaderEnd = System.currentTimeMillis();
		totalTimeOfLibraryLoader += loaderEnd - loaderStart;
	}

	public void waitForLibraryToAppear() {
		this.wait.until(ExpectedConditions.visibilityOf(libraryLoader));
	}

	public boolean verifyFolderIsPresent(String folderName) {
		this.waitForLibraryLoaderToFinish();
		this.waitForLoaderToFinish();
		for (WebElement folder : listOfFolders) {
			if (folder.getText().equals(folderName))
				return true;
		}
		return false;
	}

	public boolean verifyIfFileIsPresent(String fileName) {
		this.waitForLibraryLoaderToFinish();
		this.waitForLoaderToFinish();
		for (WebElement folder : listOfFiles) {
			if (folder.getText().equals(fileName))
				return true;
		}
		return false;
	}

	public WebElement findFolder(String folderName) {
		this.waitForLoaderToFinish();
		this.waitForInformationLoaderToFinish();
		this.waitForLibraryLoaderToFinish();
		this.waitForAdvanceLevelLoader();

		this.wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//tr[contains(@ondblclick,'folderSearch')] //span[text()='" + folderName + "']")));
		WebElement folderElement = driver.findElement(
				By.xpath("//tr[contains(@ondblclick,'folderSearch')] //span[text()='" + folderName + "']"));
		return folderElement;

	}

	public WebElement findFile(String fileName) {
		this.waitForLoaderToFinish();
		this.waitForInformationLoaderToFinish();
		this.waitForLibraryLoaderToFinish();
		this.waitForAdvanceLevelLoader();
		this.wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//tr[contains(@ondblclick,'window.open')] //span[text()='" + fileName + "']")));
		WebElement folderElement = driver
				.findElement(By.xpath("//tr[contains(@ondblclick,'window.open')] //span[text()='" + fileName + "']"));
		return folderElement;
	}

	public void selectFolder(String folderName) {
		this.waitForAdvanceLevelLoader();
		this.findFolder(folderName).click();
	}

	public void selectFile(String fileName) {
		this.waitForAdvanceLevelLoader();
		this.findFile(fileName).click();
	}

	public void openFolder(String folderName) {
		WebElement folderEle = this.findFolder(folderName);
		this.waitForLibraryLoaderToFinish();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(folderEle));
		this.doubleClick(folderEle);
	}

	public void openFile(String fileName) {
		this.waitForLoaderToFinish();
		WebElement fileEle = this.findFile(fileName);
		this.wait.until(ExpectedConditions.elementToBeClickable(fileEle));
		this.doubleClick(fileEle);
	}

	// This method will go to the required folder
	public void goToTheRequiredFolder(String folderPath) {
		String folderPaths[] = folderPath.split(",");
		boolean isPathMultiple = folderPath.contains(",");
		if (isPathMultiple) {
			for (int i = 0; i < folderPaths.length - 1; i++) {
				this.openFolder(folderPaths[i]);
			}
		} else {
			this.openFolder(folderPaths[0]);
		}
		this.waitForLibraryLoaderToFinish();
		this.waitForLoaderToFinish();
	}

	public void waitForMoveIcon() {
		this.wait.until(ExpectedConditions.elementToBeClickable(moveIcon));
	}

	public boolean verifyMoveIconIsPresent() {
		return this.moveIcon.isDisplayed();

	}

	public boolean verifyIfMoveIconIsNotPresent() {
		return !this.moveIcon.isDisplayed();
	}

	private void moveToTheFolder(String folderPath) {
		String folderPaths[] = folderPath.split("/");
		waitForMoveIcon();
		this.moveIcon.click();
		this.wait.until(ExpectedConditions.visibilityOf(moveToWindow));
		boolean ifPathIsMultiple = folderPath.contains("/");
		if (ifPathIsMultiple) {
			for (int i = 0; i < folderPaths.length - 1; i++) {
				this.wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//a[text()='" + folderPaths[i] + " " + "']/../..//div[@class='moveto-arrow open']")));
				WebElement folderEle = this.driver.findElement(
						By.xpath("//a[text()='" + folderPaths[i] + " " + "']/../..//div[@class='moveto-arrow open']"));
				folderEle.click();
			}
			this.wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@id='move-item-body'] //div[@class='moveto-contenttileText'] //a[text()='"
							+ folderPaths[folderPaths.length - 1] + " " + "']")));
			this.driver.findElement(
					By.xpath("//div[@id='move-item-body'] //div[@class='moveto-contenttileText'] //a[text()='"
							+ folderPaths[folderPaths.length - 1] + " " + "']"))
					.click();
		} else {
			this.wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@id='move-item-body'] //div[@class='moveto-contenttileText'] //a[text()='"
							+ folderPaths[0] + " " + "']")));
			this.driver.findElement(
					By.xpath("//div[@id='move-item-body'] //div[@class='moveto-contenttileText'] //a[text()='"
							+ folderPaths[0] + " " + "']"))
					.click();

		}
		this.moveToButton.click();
		this.waitForLoaderToFinish();

		this.wait.until((driver) -> moveToConfirmationWindow.isDisplayed());
		this.wait.until(ExpectedConditions.visibilityOf(moveToConfirmationMessage));
		String confirmationMessage = this.moveToConfirmationMessage.getText();
		Assert.assertEquals(confirmationMessage, prop.getProperty("moveFolderVerify"));
		this.wait.until(ExpectedConditions.elementToBeClickable(moveToOKButton));
		this.moveToOKButton.click();
	}

	public void moveToRequiredFolder(String folderPath) {
		moveToTheFolder(folderPath);
		String moveToNotifyMsg = this.verifyNotificaitonMessage();
		Assert.assertEquals(moveToNotifyMsg, prop.getProperty("moveToNotifyMsg"));
		this.waitForLoaderToFinish();
	}

	public void moveTheFolderAndVerifyAccessDenial(String folderPath) {
		moveToTheFolder(folderPath);
		String moveToNoAccesss = this.verifyNotificaitonMessage();
		Assert.assertEquals(moveToNoAccesss, prop.getProperty("moveToNotifyMsgWithNoAccess"));
		this.waitForLoaderToFinish();
	}

	// Share option methods - start
	public void waitForShareIcon() {
		this.wait.until(ExpectedConditions.visibilityOf(shareIcon));
	}

	public boolean veirfyIfShareIconIsPresent() {
		this.waitForInformationLoaderToFinish();
		return this.shareIcon.isDisplayed();

	}

	public void shareTheFolder(String userEmailIDs, String folderAccess) {
		waitForShareIcon();
		this.shareIcon.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOf(shareModelContent));

		boolean ifUserIsMultiple = userEmailIDs.contains(",");
		if (ifUserIsMultiple) {
			String[] listOfUserEmailSplit = userEmailIDs.split(",");
			for (String userEmail : listOfUserEmailSplit) {
				this.enterPeopleOrGroupOfShareFolder.click();
				this.enterPeopleOrGroupOfShareFolder.sendKeys(userEmail);
				for (WebElement user : listOfUsers) {
					if (user.getText().equals(userEmail)) {
						user.click();
						continue;

					}
				}
			}
		} else {
			this.enterPeopleOrGroupOfShareFolder.click();
			this.enterPeopleOrGroupOfShareFolder.sendKeys(userEmailIDs);
			for (WebElement user : listOfUsers) {
				if (user.getText().equals(userEmailIDs)) {
					user.click();
					break;
				}
			}

		}
		this.selectDropDownUsingText(selectScopeForShare, folderAccess);
		this.shareButtonInShareWindow.click();

		String notifyMsg = this.verifyNotificaitonMessage();
		Assert.assertEquals(notifyMsg, prop.getProperty("sharedSuccessfully"));
		this.waitForLoaderToFinish();
	}

	public void goBackToRequiredFolder(String folderNameOrLibararyName) {
		for (WebElement ele : folderBreadcCrumb) {
			if (ele.getText().equals(folderNameOrLibararyName)) {
				ele.click();
				this.waitForLibraryLoaderToFinish();
				break;
			}
		}
	}

	public void goBackToLibrary() {
		this.wait.until(ExpectedConditions.visibilityOfAllElements(folderBreadcCrumb));
		this.wait.until(ExpectedConditions.elementToBeClickable(folderBreadcCrumb.get(0)));
		this.folderBreadcCrumb.get(0).click();
		this.waitForLibraryLoaderToFinish();
		this.waitForLoaderToFinish();
		System.out.println("Redirect to the library is successful");
		System.out.println("LoaderTime Final " + totalTimeOfGeneralLoader);
	}

	public void clickLoadMoreIfAvailable() {
		this.waitForLoaderToFinish();
		this.waitForLibraryLoaderToFinish();
		boolean isLoadMoreAvailable = this.loadMoreButton.isDisplayed();
		if (isLoadMoreAvailable)
			this.loadMoreButton.click();
	}

// Delete the folders and file methods starts 
	public void deleteFolder(String folderNames) {
		String[] listOfFolders = folderNames.split(",");
		for (String folder : listOfFolders) {
			this.selectFolder(folder);
			this.waitForInformationLoaderToFinish();
			this.wait.until(ExpectedConditions.visibilityOf(deleteIcon));
			this.deleteIcon.click();
			this.wait.until(ExpectedConditions.visibilityOf(removeItemMessage));
			String removeMsg = this.removeItemMessage.getText();
			Assert.assertEquals(removeMsg, prop.getProperty("removedItemMsg"));

			boolean isPresent = this.verifyFolderIsPresent(folder);
			Assert.assertFalse(isPresent);
			this.waitForLoaderToFinish();
		}
	}

	public void deleteFiles(String fileNames) {
		this.waitForLoaderToFinish();
		clickLoadMoreIfAvailable();
		String[] listOfFiles = fileNames.split(",");
		for (String file : listOfFiles) {
			this.selectFile(file);
			this.waitForInformationLoaderToFinish();
			this.wait.until(ExpectedConditions.visibilityOf(deleteIcon));
			this.deleteIcon.click();
			this.wait.until(ExpectedConditions.visibilityOf(removeItemMessage));
			String removeMsg = this.removeItemMessage.getText();
			Assert.assertEquals(removeMsg, prop.getProperty("removedItemMsg"));

			boolean isPresent = this.verifyFolderIsPresent(file);
			Assert.assertFalse(isPresent);
			this.waitForLoaderToFinish();

		}
	}

	public void searchTheLibrary(String fileOrFolder) {

		this.globalSearch.enterSearchItem(fileOrFolder);
		this.waitForLibraryLoaderToFinish();
		this.waitForLoaderToFinish();
	}

	public void goBackFromSearchResults() {
		this.waitForLoaderToFinish();
		this.waitForLibraryLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(searchBackButton));
		this.searchBackButton.click();
		this.waitForLibraryLoaderToFinish();
	}

	public void deleteFolderIconCheck(String folderNme) {
		this.waitForLoaderToFinish();
		boolean displayed = this.delFolderIcon.isDisplayed();
		System.out.println("DeleteFolderIcon is Displayed: " + displayed);
	}

	public void deleteFileIconCheck(String fileNme) {

		this.waitForLoaderToFinish();
		boolean displayed1 = this.delFileIcon.isDisplayed();
		System.out.println("DeleteFileIcon is Displayed: " + displayed1);

	}

	public void detailsTab(String parentName, String requestedBy, String createdOn, String email, String orgaloc,
			String comments) {
		this.invisibilityOfSideBarLaoder();
		this.detailsTab.click();

		boolean displayed = this.manageVersionButton.isDisplayed();
		System.out.println("ManageVersionButton is Displayed : " + displayed);
		boolean displayed2 = this.editPropertiesButton.isDisplayed();
		System.out.println("editPropertiesButton is Displayed : " + displayed2);

		String actTitle = this.parentName.getText();
		String expTitle = parentName;
		Assert.assertEquals(actTitle, expTitle, "Parentname is not Displayed");
		System.out.println("Parentname " + actTitle + " is  Displayed");
		String actTitle1 = this.requestedBy.getText();
		String expTitle1 = requestedBy;
		Assert.assertEquals(actTitle, expTitle, "Parentname is not Displayed");
		System.out.println("Requestedby " + actTitle1 + " is  Displayed");
		String actTitle2 = this.createdOn.getText();
		String expTitle2 = createdOn;
		Assert.assertEquals(actTitle, expTitle, "Parentname is not Displayed");
		System.out.println("Createdon " + actTitle2 + " is  Displayed");
		String actTitle3 = this.email.getText();
		String expTitle3 = email;
		Assert.assertEquals(actTitle, expTitle, "Parentname is not Displayed");
		System.out.println("EmailId " + actTitle3 + " is  Displayed");
		String actTitle4 = this.orgaloc.getText();
		String expTitle4 = orgaloc;
		Assert.assertEquals(actTitle, expTitle, "Parentname is not Displayed");
		System.out.println("Orgaloc " + actTitle4 + " is  Displayed");
		String actTitle5 = this.comments.getText();
		String expTitle5 = orgaloc;
		Assert.assertEquals(actTitle, expTitle, "Parentname is not Displayed");
		System.out.println(" Comments " + actTitle5 + " is  Displayed");
		boolean displayed3 = this.saveEditRealtionButton.isDisplayed();
		System.out.println("SaveEditRelationButton is Displayed : " + displayed3);
	}

	public void activityTab() {

		this.activityTab.click();
		this.wait.until(ExpectedConditions.visibilityOf(documentLastModifiedDate));
		boolean displayed = this.documentLastModifiedDate.isDisplayed();
		System.out.println("Document LastModified Date is Displayed : " + displayed);
		this.wait.until(ExpectedConditions.visibilityOf(documentLastModifiedActivity));
		boolean displayed2 = this.documentLastModifiedActivity.isDisplayed();
		System.out.println("Document LastModified Activity is Displayed : " + displayed2);

	}

	public void approvalsTab(String cmnt) {
		this.approvalsTab.click();
		boolean displayed = this.approvalPendingDispalyed.isDisplayed();
		System.out.println("Approval Pending Is Displayed : " + displayed);
		boolean displayed2 = this.apaComment.isDisplayed();
		System.out.println("Approval Comment Is Displayed " + displayed2);
		this.apaComment.sendKeys(cmnt);
		String text = this.getAttributeValue(apaComment, "value");
		System.out.println(text + " fine in Comment Section");
		this.apaComment.clear();
		boolean displayed3 = this.sendForApprovalDisplayed.isDisplayed();
		System.out.println("Send For Approval Button Is Displayed : " + displayed3);
		boolean displayed4 = this.forceSendForApproval.isDisplayed();
		System.out.println("Force Send For Approval Button Is Displayed : " + displayed3);
		this.getAttributeValue(apaComment, "value");

	}

	public void makeCopy(String copyName) {
		this.waitForLoaderToFinish();
		this.copyIcon.click();
		this.wait.until(ExpectedConditions.elementToBeClickable(copyEnterName));
		this.copyEnterName.clear();
		this.copyEnterName.sendKeys(copyName);
		this.acceptBtn.click();
		this.waitForLoaderToFinish();
	}

	public void detailsTabFolderAndFile() {

		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
		this.detailsTab.click();

	}

	public void activityTabFolderAndFile() {
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
		this.activityTab.click();
	}

	public void approvalTabFolderAndFile() {
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));

		this.approvalTab.click();

	}

	public void draft() {
		this.draftClick.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(popUp));
		this.waitForLoaderToFinish();
		String text = this.checkDraft.getText();
		System.out.println("Version Of Status : " + text);

	}

	public void validator() {
		this.approverClick.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(popUp));
		this.waitForLoaderToFinish();
		String text = this.checkValidator.getText();
		System.out.println("Version Of Status : " + text);
	}

	public void approver() {
		this.approverClick.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(popUp));
		this.waitForLoaderToFinish();
		String text = this.checkApprover.getText();
		System.out.println("Version Of Status : " + text);
	}

	public void published() {
		this.wait.until(ExpectedConditions.elementToBeClickable(activity));
		this.activity.click();
		String attribute = this.verifyActivity.getText();
		System.out.println("Agilan " + attribute);
		boolean displayed = this.verifyActivity.isDisplayed();
		System.out.println("Single validation is passed : " + displayed);
		this.waitForLoaderToFinish();
		String text = this.checkPublished.getText();
		System.out.println("Version Of Status : " + text);

	}

	public void draftDynamicApprover() {
		boolean displayed = this.dynamicApproverName.isDisplayed();
		if (!displayed) {
			System.out.println("DynamicApprover Failed");

		} else {
			System.out.println("DynamicApprover Passed");

		}
		this.draftClick.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(popUp));
		this.waitForLoaderToFinish();
		String text = this.checkDraft.getText();
		System.out.println("Version Of Status : " + text);

	}

	public void validatorNplusOne() {
		boolean displayed = this.nplusOneValidatorName.isDisplayed();
		if (!displayed) {
			System.out.println("N+1 Validator Failed");

		} else {
			System.out.println("N+1 Validator Passed");

		}

		this.approverClick.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(popUp));
		this.waitForLoaderToFinish();
		String text = this.checkValidator.getText();
		System.out.println("Version Of Status : " + text);
	}

	public void multipleDocumentWorkflowApprovalDraft() {
		this.wait.until(ExpectedConditions.elementToBeClickable(fileOne));
		this.wait.until(ExpectedConditions.elementToBeClickable(fileTwo));
		List<WebElement> fileList = new ArrayList<WebElement>();
		fileList.add(fileOne);
		fileList.add(fileTwo);
		this.clickMultiple(fileList);
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.elementToBeClickable(multiApproval));
		this.multiApproval.click();
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOf(window));
		this.wait.until(ExpectedConditions.elementToBeClickable(approveButton));
		this.approveButton.click();
		this.wait.until(ExpectedConditions.visibilityOf(popUp));

	}

	public void multipleDocumentWorkflowApprovalValidator() {
		multipleDocumentWorkflowApprovalDraft();

	}

	public void multipleDocumentWorkflowApprovalApprover() {
		multipleDocumentWorkflowApprovalDraft();
	}

	public void multipleDocumentWorkflowApprovalPublished(String fileName) {
		String text = this.statusCheckOne.getText();
		System.out.println("Status Moved Draft to : " + text);
		String text2 = this.statusCheckTwo.getText();
		System.out.println("Status Moved Draft to : " + text2);

	}

	public void versionIcon() {
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
		this.versionIcon.click();
	}

	public void versionUpload() {
		this.waitForLoaderToFinish();
		this.versionUpload.click();
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
		this.waitForLoaderToFinish();
	}

	public void newVersionFile(String title) {
		this.wait.until(ExpectedConditions.elementToBeClickable(title1));
		this.title1.clear();
		this.title1.sendKeys(title);
		this.waitForLoaderToFinish();
		this.addButton.click();
		this.waitForLoaderToFinish();
		this.waitForLibraryLoaderToFinish();

	}

	public void newVersionCheck() {
		this.waitForLoaderToFinish();
		// driver.findElement(By.xpath("//span[text()='" + title + "']")).click();
		String text = this.checkDraft.getText();
		System.out.println("Initial Version Of Status : " + text);
		String text1 = this.versionNo.getText();
		System.out.println("Version Number Of Document : " + text1);

	}

	public void versionIconCheck() {
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
		boolean displayed = this.versionIcon.isDisplayed();
		if (!displayed) {
			System.out.println("version icon it's not visible so version got created");

		} else {
			System.out.println("version icon it's still visible so no version created");

		}

	}

	public void approvalTabFolderAndFileWithComment(String Comment) {

		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
		this.approvalTab.click();
		this.apaComment.sendKeys(Comment);

	}

	public void versionCreationWrokFlow(String movFolderNme, String Folder) {

		this.detailsTab.click();
		this.wait.until(ExpectedConditions.invisibilityOf(sideBarLoader));
		this.versionIcon.click();
		this.waitForLoaderToFinish();
		String eleResult = driver.findElement(By.xpath("(//span[@class='filename-spandata'])[2]")).getText();
		System.out.println("VERSION-1: " + eleResult);
		Assert.assertEquals(eleResult, "ApprovalVerify");
		String eleResult2 = driver.findElement(By.xpath("(//span[@class='filename-spandata'])[1]")).getText();
		System.out.println("CURRENT VERSION: " + eleResult2);
		Assert.assertEquals(eleResult2, "VersionFile");
		this.close.click();

	}
	
	public void enableRelationButton() {
		//	this.pageScrollDown();
			this.waitForInformationLoaderToFinish();
			this.scrollToTheElement(editRelationButton);
			if (editRelationButton.isDisplayed()) {
				this.editRelationButton.click();
				System.out.println("EDIT RELATION BUTTON IS DISPLAYED");
			} else {
				System.out.println("EDIT RELATION BUTTON IS NOT DISPLAYED");
			}
		}
	
	public void enableRelationButtonAddingFile(String relationFileNme) {
		this.waitForLoaderToFinish();
		//this.editRelationButtonTextBox.click();
		this.editRelationButtonTextBox.sendKeys(relationFileNme,Keys.ENTER);
		this.waitForLoaderToFinish();
		this.editRelationButtonTextBoxSave.click();
		this.waitForLoaderToFinish();

	}

	
}
