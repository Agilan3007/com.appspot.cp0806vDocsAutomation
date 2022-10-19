package com.appspot.cp0806.base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectMethods extends BaseMethods {
	@FindBy(css = "div#globalLoader")
	private WebElement loader;

	@FindBy(css = "div#rightbarLoader")
	protected WebElement informationLoader;

	@FindBy(css = "div#globalLoader2")
	private WebElement libLoader;

	@FindBy(css = "div#advanceSearchLoader")
	private WebElement advanceLoader;

	@FindBy(css = "#ui-id-1 li a")
	private List<WebElement> userIDs;

	@FindBy(css = ".informationicon")
	private WebElement infoIcon;

	@FindBy(css = "#custom-rightbaredit-btn")
	private WebElement editLibSettings;

	@FindBy(css = "a[onclick^='backToHome()']")
	private WebElement backTwoHome;

	@FindBy(css = "div.ui-pnotify-text ")
	protected WebElement notificationMessage;

	public ProjectMethods(WebDriver driver) {
		super(driver);
	}

	public long totalTimeOfGeneralLoader;

	protected void waitForLoaderToFinish() {
		long loaderStart = System.currentTimeMillis();
		this.wait.until(ExpectedConditions.invisibilityOf(loader));
		long loaderEnd = System.currentTimeMillis();
		totalTimeOfGeneralLoader += loaderEnd - loaderStart;
		// System.out.println("LoaderTime "+totalTimeOfGeneralLoader);
	}

	public void waitForlibraryLevelLoader() {
		long loaderStart = System.currentTimeMillis();
		this.wait.until(ExpectedConditions.invisibilityOf(libLoader));
		long loaderEnd = System.currentTimeMillis();
		totalTimeOfGeneralLoader += loaderEnd - loaderStart;
	}

	public void waitForAdvanceLevelLoader() {
		// long loaderStart = System.currentTimeMillis();
		this.wait.until(ExpectedConditions.invisibilityOf(advanceLoader));
		// long loaderEnd = System.currentTimeMillis();
		// totalTimeOfGeneralLoader += loaderEnd - loaderStart;
	}

	public void waitForLoaderToAppear(int num) {
		long loaderStart = System.currentTimeMillis();
		this.wait.until(ExpectedConditions.visibilityOf(loader));
		long loaderEnd = System.currentTimeMillis();

		totalTimeOfGeneralLoader += loaderEnd - loaderStart;
	};

	protected void waitForInformationLoaderToFinish() {
		long loaderStart = System.currentTimeMillis();
		this.wait.until(ExpectedConditions.invisibilityOf(informationLoader));
		long loaderEnd = System.currentTimeMillis();
		totalTimeOfInformationLoader += loaderEnd - loaderStart;
	}

	protected String verifyNotificaitonMessage() {
		this.wait.until(ExpectedConditions.visibilityOf(notificationMessage));
		return this.notificationMessage.getText();

	}

	public void selectEmailID(String userEmail) {
		selectEmailID(userIDs, userEmail);

	}

	public void selectEmailID(List<WebElement> elements, String userEmail) {
		this.waitForLoaderToFinish();
		this.wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		for (WebElement ele : elements) {
			System.out.println(ele.getText());
			if (ele.getText().contains(userEmail)) {
				ele.click();
				break;
			}

		}
	}

	public void libraryInformationIcon() {
		this.infoIcon.click();

	}

	public void libraryEditSettings() {
		this.editLibSettings.click();

	}

	public void libraryToHome() {
		this.backTwoHome.click();

	}

}
