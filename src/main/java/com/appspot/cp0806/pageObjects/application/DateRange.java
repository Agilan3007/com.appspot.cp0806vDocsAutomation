package com.appspot.cp0806.pageObjects.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DateRange extends com.appspot.cp0806.base.ProjectMethods {

	@FindBy(css = "div[class*='daterangepicker ltr show-ranges opensright'][style*='display: block']")
	private WebElement dateRange;

	@FindBy(id = "adv-createdOn-id")
	private WebElement customRange;

	public DateRange(WebDriver driver) {
		super(driver);
	}

	public void clickToday() {
		this.dateRange.findElement(By.cssSelector("div[class='ranges'] li[data-range-key='Today']")).click();
	}

	public void clickYesterday() {
		this.dateRange.findElement(By.cssSelector("div[class='ranges'] li[data-range-key='Yesterday']")).click();
	}

	public void clickLast7Days() {
		this.dateRange.findElement(By.cssSelector("div[class='ranges'] li[data-range-key='Last 7 Days']")).click();
	}

	public void clickLast30Days() {
		this.dateRange.findElement(By.cssSelector("div[class='ranges'] li[data-range-key='Last 30 Days']")).click();
	}

	public void clickThisMonth() {
		this.dateRange.findElement(By.cssSelector("div[class='ranges'] li[data-range-key='This Month']")).click();
	}

	public void clickLastMonth() {
		this.dateRange.findElement(By.cssSelector("div[class='ranges'] li[data-range-key='Last Month']")).click();
	}

	public void clickCustomRange() {
		this.dateRange.findElement(By.cssSelector("div[class='ranges'] li[data-range-key='Custom Range']")).click();
	}

	public void selectCustomDateRange(String dateRange) {
		this.customRange.clear();
		this.customRange.sendKeys(dateRange);
	}

	public void clickApplyButton() {
		this.dateRange.findElement(By.cssSelector("div.drp-buttons button.applyBtn")).click();
	}

	public void clickCancelButton() {
		this.dateRange.findElement(By.cssSelector("div.drp-buttons button.cancelBtn")).click();
	}

}
