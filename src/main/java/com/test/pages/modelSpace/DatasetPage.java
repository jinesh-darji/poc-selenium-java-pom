package com.ubix.pages.modelSpace;

import java.io.IOException;

import com.ubix.base.TestBase;

public class DatasetPage extends TestBase {

	public void clickDataAccessTab() {
		click("btn_dataAccessTab_CSS");
	}

	public void clickExternalData() {
		click("btn_externalData_CSS");
	}

	public void clickDataTypeDropdown() {
		click("dd_dataType_CSS");
	}

	public void clickDataSetDropdown() {
		click("dd_dataSet_CSS");
	}

	public void typeSearchDataSets(String input) {
		type("txt_searchDatasets_XPATH", input);
	}

	public void clickSearchedDatasetsGoogle() {
		click("lbl_searchedDatasets_google_XPATH");
	}
	
	public void clickSearchedDatasetsDocuments() {
		click("lbl_searchedDatasets_documents_XPATH");
	}

	public void typeAvailableAttributeSearch(String input) {
		type("txt_availableAttributeSearch_CSS", input);
	}

	public void checkInsuranceData() {

		click("ckbx_insuranceData_XPATH");
	}

	public void checkOnlineElectronicsStoreData() {
		click("ckbx_onlineElectronicsStore_XPATH");
	}
	
	public void checkGoogleAnalyticsUserBasic() {
		click("ckbx_googleAnalyticsUserBasic_XPATH");
	}
	
	public void checkUbixDocs() {
		click("ckbx_ubixdocs_XPATH");
	}

	public boolean isSelectedAttributeInsuranceDataDisplayed() {
		return isDisplay("lbl_selectedAttribute_insuranceData_CSS");
	}

	public void clickAddToWorkspace() {
		click("btn_addToWorkspace_CSS");
	}

	public boolean isAddedDataAccessInsuranceDataDisplayed() {
		return isDisplay("lbl_addedDataAccess_insuranceData_CSS");
	}

	public void clickAddSolutionTab() {
		click("btn_addSolutionTab_CSS");
	}

	public void clickAddSolutionSpaceAppBuilder() {
		click("btn_addSolutionSpaceAppBuilder_XPATH");
	}

	public void clickAddProductionSpace() {
		click("btn_addProductionSpace_XPATH");
	}

	public void doubleClickInsuranceDataAction() {
		doubleClick("lbl_insurance_data_action_CSS");
	}

	public void verifyWorkSpaceDataUpdatedSuccessMsg() throws IOException {
		verifyTrue("txt_workSpaceDataUpdatedSuccessMsg_XPATH", "Validation failing...");
	}

	public void clickPublish() {
		click("btn_publish_XPATH");
	}

}
