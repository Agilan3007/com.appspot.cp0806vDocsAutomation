package com.appspot.cp0806.pageObjects.application;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VdocsApplication extends com.appspot.cp0806.base.ProjectMethods {

	public Logger logger;

	@FindBy(css = "input#identifierId")
	WebElement googleEmailID;

	@FindBy(css = "div#identifierNext")
	WebElement nextBtn;

	@FindBy(id = "approve_button")
	WebElement allowButton;

	@FindBy(css = "input#username")
	private WebElement emailID;

	@FindBy(css = "input[value='Connection']")
	private WebElement connectionBtn;

	@FindBy(id = "IDToken2")
	private WebElement password;

	@FindBy(css = "input[name='Login.Submit']")
	private WebElement loginBtn;

	public VdocsApplication(WebDriver driver) {
		super(driver);
		logger = Logger.getLogger(VdocsApplication.class.getName());
	}

	public void loginToVDocs() {
		loginToVDocs(prop.getProperty("URL"), prop.getProperty("superUserEmail"),
				prop.getProperty("superUserPassword"));
	}

	public void loginToVDocs(String userName, String password) {
		loginToVDocs(prop.getProperty("URL"), userName, password);
	}

	public void loginToVDocs(String URL, String userName, String password) {
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.driver.get(URL);
		this.wait.until(ExpectedConditions.elementToBeClickable(googleEmailID));
		this.googleEmailID.sendKeys(userName);
		this.click(nextBtn);
		this.wait.until(ExpectedConditions.elementToBeClickable(emailID));
		this.emailID.sendKeys(userName);
		this.connectionBtn.click();
		this.wait.until(ExpectedConditions.elementToBeClickable(this.password));
		this.password.sendKeys(password);
		this.loginBtn.click();
//		this.click(allowButton);
		this.wait.until(ExpectedConditions.titleIs("vDocs"));
		logger.info("Title vDocs has been verified");
//		this.waitForLoaderToFinish();
	}

	public void goToVDocs() {
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.openNewTabAndNavigate("https://valeo-cp0806-acp.appspot.com/");//https://valeo-cp0806-acp.appspot.com/
	}

}
