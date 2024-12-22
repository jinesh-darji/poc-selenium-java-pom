package com.ubix.pages.modelSpace;

import com.ubix.base.TestBase;

public class WorkSpaceListPage extends TestBase {

	public void clickCreateWorkSpace() {

		click("btn_createWorkSpace_XPATH");
	}

	public void clearWorkSpaceSearch() {

		clear("txt_workSpaceSearch_CSS");
	}

	public void typeWorkSpaceSearch(String input) {

		type("txt_workSpaceSearch_CSS", input);
	}

	public void clickEditWorkSpace() {
		click("btn_editWorkSpace_CSS");
	}

	public void clickDeleteWorkSpace() {
		click("btn_deleteWorkSpace_CSS");
	}

	public void clickDeleteWorkSpaceYes() {
		click("btn_deleteWorkSpace_yes_XPATH");
	}

	public void clickDeleteWorkSpaceCancel() {
		click("btn_deleteWorkSpace_cancel_XPATH");
	}

	public boolean isCreatedWorkSpaceLabelDisplayed() {
		return isDisplay("lbl_createdWorkSpace_XPATH");
	}
	

}
