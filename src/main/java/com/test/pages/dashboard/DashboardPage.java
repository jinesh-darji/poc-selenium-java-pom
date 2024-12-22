package com.ubix.pages.dashboard;

import com.ubix.base.TestBase;

public class DashboardPage extends TestBase {

	public boolean isModuleNavigatorDisplayed(String locator) {

		return isDisplay(locator);
	}

	public void clickModuleNavigator() {

		click("dd_moduleNavigator_CSS");
	}

	public void clickModuleNavigatorChatUBIX() {
		click("lbl_moduleNavigator_chatUBIX_XPATH");
	}

	public void clickModuleNavigatorSolutionSpace() {
		click("lbl_moduleNavigator_solutionSpace_XPATH");
	}

	public void clickModuleNavigatorModelSpace() {
		click("lbl_moduleNavigator_modelSpace_XPATH");
	}

	public void clickModuleNavigatorDataSpace() {
		click("lbl_moduleNavigator_dataSpace_XPATH");
	}

	public void clickModuleNavigatorProductionSpace() {
		click("lbl_moduleNavigator_productionSpace_XPATH");
	}

	public void clickModuleNavigatorCloudSpace() {
		click("lbl_moduleNavigator_cloudSpace_XPATH");
	}

	public void clickModuleNavigatorTrainingSpace() {
		click("lbl_moduleNavigator_trainingSpace_XPATH");
	}

	public void clickModuleNavigatorModelSpaceLibrary() {
		click("lbl_moduleNavigator_modelSpaceLibrary_XPATH");
	}

	public void clickChatUBIX() {

		click("card_chatUBIX_XPATH");
	}

	public void clickSolutionSpace() {

		click("card_solutionSpace_XPATH");
	}

	public void clickModelSpace() {
		explicitWait("card_modelSpace_XPATH");
		click("card_modelSpace_XPATH");
	}

	public void clickDataSpace() {

		click("card_dataSpace_XPATH");
	}

	public void clickProductionSpace() {

		click("card_productionSpace_XPATH");
	}

	public void clickCloudSpace() {

		click("card_cloudSpace_XPATH");
	}

	public void clickTrainingSpace() {

		click("card_trainingSpace_XPATH");
	}

	public void clickModelSpaceLibrary() {

		click("card_modelSpaceLibrary_XPATH");
	}

	public void clickProfile() {

		click("lbl_profile_CSS");
	}

	public void clickCompanyAccountChange() {

		click("lbl_companyAccountChange_XPATH");
	}

	public void clickCustomers() {

		click("lbl_customers_XPATH");
	}

	public void clickPartners() {

		click("lbl_partners_XPATH");
	}

	public void clickRecordPaymentReceipt() {

		click("lbl_recordPaymentReceipt_XPATH");
	}

	public void clickOnBoardingContract() {

		click("lbl_onBoardingContract_XPATH");
	}

	public void clickAccountInvoicing() {

		click("lbl_accountInvoicing_XPATH");
	}

	public void clickPaymentAdmin() {

		click("lbl_paymentAdmin_XPATH");
	}

	public void clickUserManagement() {

		click("lbl_userManagement_XPATH");
	}

	public void clickUserRoleHistory() {

		click("lbl_userRoleHistory_XPATH");
	}

	public void clickProfileOption() {

		click("lbl_profileOption_XPATH");
	}

	public void clickSignOut() {

		click("lbl_signOut_XPATH");
	}

	public void clickUbixLogo() throws InterruptedException {

		
		driver.navigate().refresh();
		Thread.sleep(3000);
		click("ele_ubixLogo_XPATH");
		Thread.sleep(3000);
	}
}
