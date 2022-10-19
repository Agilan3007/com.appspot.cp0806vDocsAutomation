package com.appspot.cp0806.validator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import com.appspot.cp0806.base.ProjectMethods;



public class ElementPresentValidator extends ProjectMethods implements ElementValidator {

	private List<WebElement> checkElementPresent;

	public ElementPresentValidator(WebDriver driver, List<WebElement> elements) {
		super(driver);
		this.checkElementPresent = elements;
	}

	@Override
	public boolean validate() {
		this.highlightElement(checkElementPresent.get(0));
		return !this.checkElementPresent.isEmpty();
	}


}
