package com.appspot.cp0806.pageObjects.libraries;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.appspot.cp0806.base.ProjectMethods;
import com.appspot.cp0806.validator.ElementPresentValidator;

public class LibraryElementVerification extends ProjectMethods {

	@FindBy(id = "addalertuser")
	private List<WebElement> alertIcon;

	@FindBy(id = "gridview_btn")
	private List<WebElement> gridView;

	@FindBy(className = "informationicon")
	private List<WebElement> informationIcon;

	@FindBy(css = "span#titleheader")
	private List<WebElement> librayHeader;

	@FindBy(css = "div.dataTables_scrollHead tr#libraryDataTable-head th[data-colname='title']")
	private List<WebElement> titleColumn;

	@FindBy(css = "div.dataTables_scrollHead tr#libraryDataTable-head th[name='Reference']")
	private List<WebElement> referenceColumn;

	@FindBy(css = "div.dataTables_scrollHead tr#libraryDataTable-head th[data-colname='Status']")
	private List<WebElement> statusColumn;

	@FindBy(css = "div.dataTables_scrollHead tr#libraryDataTable-head th[data-colname='lastModified']")
	private List<WebElement> lastModifiedColumn;

	@FindBy(css = "div.dataTables_scrollHead tr#libraryDataTable-head th[data-colname='Version']")
	private List<WebElement> versionColumn;

	@FindBy(css = "div.foldercontent-holder")
	private List<WebElement> leftLibName;

	public LibraryElementVerification(WebDriver driver) {
		super(driver);
	}

	public List<ElementPresentValidator> getElementPresentValidator() {
		List<ElementPresentValidator> elementPresentValidators = new ArrayList<ElementPresentValidator>();
		elementPresentValidators.add(new ElementPresentValidator(this.driver, alertIcon));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, gridView));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, informationIcon));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, librayHeader));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, titleColumn));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, referenceColumn));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, statusColumn));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, lastModifiedColumn));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, versionColumn));
		elementPresentValidators.add(new ElementPresentValidator(this.driver, leftLibName));
		return elementPresentValidators;
	}

	public void expandLibraryName() {
		if (leftLibName.size() > 0) {
			this.driver.findElement(By.cssSelector("a[class='folderTree-arrow collapse-link']")).click();
		}
	}

	public boolean validateAll() {
		boolean status = false;
		for (WebElement ele : leftLibName) {
			this.highlightElement(ele);
			ele.isDisplayed();
			status = true;
		}
		return status;
	}

}
