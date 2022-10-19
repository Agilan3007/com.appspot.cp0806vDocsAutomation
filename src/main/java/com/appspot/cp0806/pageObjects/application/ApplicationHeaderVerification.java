package com.appspot.cp0806.pageObjects.application;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.appspot.cp0806.base.ProjectMethods;
import com.appspot.cp0806.validator.ElementPresentValidator;

public class ApplicationHeaderVerification extends ProjectMethods {

	@FindBy(css = "span[class*='sidebar'] i")
	private List<WebElement> sideBarIcon;

	@FindBy(id = "myApprovalsHomeBtn")
	private List<WebElement> myApprovals;

	@FindBy(id="export-items-admin-id")
	private List<WebElement> exportButton; 
	
	@FindBy(id="admin-settings-ui-id")
	private List<WebElement> adminSettingsIcon; 
	
	@FindBy(css = "a#navbarDropdownMenuLink-5")
	private List<WebElement> userIcon;

	@FindBy(css = "div[aria-labelledby='navbarDropdownMenuLink-5'] a")
	private List<WebElement> userName;

	@FindBy(css = "a[data-original-title='User Guide']")
	private List<WebElement> userGuide;

	@FindBy(css = "input#homeGlobalSearch")
	private List<WebElement> searchBar;
	
	public ApplicationHeaderVerification(WebDriver driver) {
		super(driver);
	}

	public List<ElementPresentValidator> getElementPresentValidators() {
		List<ElementPresentValidator> elementPresentValidators = new ArrayList<ElementPresentValidator>();
		elementPresentValidators.add(new ElementPresentValidator(this.driver, searchBar));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, myApprovals));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, userGuide));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, userIcon));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, userName));
		return elementPresentValidators;
	}
}
