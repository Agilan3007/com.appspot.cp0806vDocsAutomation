package com.appspot.cp0806.baseTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.appspot.cp0806.pageObjects.application.VdocsApplication;

public class OpenVdocs  extends BaseTest{
	
	
	
	private VdocsApplication vdocsApp;	
	
	@BeforeTest
	public void setUp() {
		vdocsApp = new VdocsApplication(this.driver);
		
	}
	@Test
	public void goToVdocs() {
		vdocsApp.goToVDocs();
		
	}
}
