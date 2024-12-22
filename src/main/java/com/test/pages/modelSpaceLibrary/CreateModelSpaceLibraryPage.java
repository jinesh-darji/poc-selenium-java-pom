package com.ubix.pages.modelSpaceLibrary;

import java.io.IOException;

import com.ubix.base.TestBase;

public class CreateModelSpaceLibraryPage extends TestBase {
	
	public void selectDistribution(String option) {
		select("dd_distribution_XPATH", option);
	}

	public void selectProductItemCategories(String option) {
		select("dd_productItemCategories_XPATH", option);
	}

	public void typeProductItemDescription(String input) {
		type("txt_productItemDescription_XPATH", input);
	}

	public void clickCreateModelSpaceLibrarySubmit() {
		click("btn_createModelSpaceLibrary_submit_XPATH");
	}
	
	public void verifyCreateModelSpaceLibraryTitle() throws IOException {
		verifyTrue("lbl_createModelSpaceLibraryTitle_XPATH", "The create model space library title is not displayed.");
	}
	
	public void scrollToSubmitButton() {
		scrollToElement("btn_createModelSpaceLibrary_submit_XPATH");
	}
	
}
