package com.appspot.cp0806.pageObjects.homepage;

import org.openqa.selenium.WebDriver;

import com.appspot.cp0806.base.ProjectMethods;
import com.appspot.cp0806.pageObjects.homepage.homePagecomponents.AdvanceSearch;
import com.appspot.cp0806.pageObjects.homepage.homePagecomponents.CreateNewLibrary;
import com.appspot.cp0806.pageObjects.homepage.homePagecomponents.HomePageLibraryList;
import com.appspot.cp0806.pageObjects.homepage.homePagecomponents.HomePageSideBar;

public class HomePages extends ProjectMethods {

	private HomePageSideBar homePageSideBar;
	private AdvanceSearch advanceSearch;
	private HomePageLibraryList homePageLibraryList;
	private CreateNewLibrary createNewLib;

	public HomePages(WebDriver driver) {
		super(driver);
		this.advanceSearch = new AdvanceSearch(driver);
		this.homePageLibraryList = new HomePageLibraryList(driver);
		this.homePageSideBar = new HomePageSideBar(driver);
		this.createNewLib = new CreateNewLibrary(driver);
	}

	public AdvanceSearch getAdvanceSearch() {
		return advanceSearch;
	}

	public HomePageLibraryList getHomePageLibraryList() {
		return homePageLibraryList;
	}

	public HomePageSideBar getHomePageSideBar() {
		return homePageSideBar;
	}

	public CreateNewLibrary getNewLibrary() {
		return createNewLib;
	}

}
