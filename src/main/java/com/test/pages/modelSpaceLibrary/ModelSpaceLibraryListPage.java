package com.ubix.pages.modelSpaceLibrary;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.ubix.base.TestBase;

public class ModelSpaceLibraryListPage extends TestBase {

	public void typeWorkSpaceLibraryListSearch(String input) {
		type("txt_workSpaceLibraryList_search_XPATH", input);
	}

	public void clickModelSpaceLibraryTab() {
		click("lbl_workSpaceLibraryList_modelSpaceLibraryTab_XPATH");
	}

	public void clickProductionizedLibraryTab() {
		click("lbl_workSpaceLibraryList_productionizedLibraryTab_XPATH");
	}

	public void clickPartnerLibraryTab() {
		click("lbl_workSpaceLibraryList_partnerLibraryTab_XPATH");
	}

	public void clickPublicLibraryTab() {
		click("lbl_workSpaceLibraryList_publicLibraryTab_XPATH");
	}

	public void clickActionDefinitionTemplateTab() {
		click("lbl_workSpaceLibraryList_actionDefinitionTemplateTab_XPATH");
	}

	public void clickSolutionTypeBuilderTab() {
		click("lbl_workSpaceLibraryList_solutionTypeBuilderTab_XPATH");
	}

	public void clickDataEventMappingTab() {
		click("lbl_workSpaceLibraryList_dataEventMappingTab_XPATH");
	}

	public void clickFunctionTab() {
		click("lbl_workSpaceLibraryList_functionTab_XPATH");
	}

	public void clickWidgetTab() {
		click("lbl_workSpaceLibraryList_widgetTab_XPATH");
	}

	public void clickWorkSpaceCardBox() {
		click("ele_workSpaceLibraryList_cardBox_XPATH");
	}

	public void clickWidgetLayoutTab() {
		click("lbl_workSpaceLibraryList_widgetLayoutTab_XPATH");
	}

	public void clickDeleteWorkSpace() {
		click("btn_workSpaceLibraryList_deleteWorkSpace_XPATH");
	}

	public void clickDeleteWorkSpaceYes() {
		click("btn_workSpaceLibraryList_deleteWorkSpace_yes_XPATH");
	}

	public void verifyLibraryDeletedSuccessfullyPopUp() throws IOException {

		verifyEquals("txt_workSpaceLibraryList_libraryDeletedSuccessfully_XPATH", "Library deleted successfully.");

	}

	public void verifyWorkspaceAvailabilityInProductionized(String workSpaceName) throws IOException {
		boolean productionized = driver
				.findElement(By.xpath("//h4[contains(text(),'"+workSpaceName+"')]")).isDisplayed();
		Assert.assertTrue(productionized,
				"The newly created workspace library is not displayed in productionized tab.");
		
	}
	
	public void verifyWorkspaceAvailabilityInModelSpaceLibrary(String workSpaceName) throws IOException {
		
		boolean modelspacelibrary = driver
				.findElement(By.xpath("//h4[contains(text(),'"+workSpaceName+"')]")).isDisplayed();
		Assert.assertTrue(modelspacelibrary,
				"The newly created workspace library is not displayed in model space library tab.");

	}
	


}
