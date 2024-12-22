package com.ubix.pages.modelSpace;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.ubix.base.TestBase;

public class AddWorkSpacePage extends TestBase {

	public void typeWorkSpaceName(String input) {
		type("txt_workspaceName_CSS", input);
	}

	public void typeDescription(String input) {
		type("txt_description_CSS", input);
	}

	public void selectUserFromDropdown() {
		click("dd_selectUser_CSS");
		click("option_selectUser_CSS");
	}

	public void selectPermissionFromDropdown() {
		click("dd_selectPermission_CSS");
		click("option_selectPermission_CSS");
	}

	public void selectPermissionTypeFromDropdown() {
		click("dd_selectPermissionType_CSS");
		click("option_selectPermissionType_CSS");
	}

	public void clickAddUser() {
		click("btn_addUser_CSS");
	}

	public void clickAddWorkspace() {
		click("btn_addWorkspace_CSS");
	}

	public void verifyWorkSpaceAddedSuccessMsg() throws IOException {
		verifyTrue("txt_workSpaceAddedSuccessMsg_XPATH", "Validation failing...");
	}

	public void verifyWorkSpaceDeleteSuccessMsg() throws IOException {
		verifyTrue("txt_workSpaceDeleteSuccessMsg_XPATH", "Validation failing...");
	}

	public void clickNewlyCreatedWorkSpace(String input) {
		driver.findElement(By.xpath("//p[contains(text(),'" + input + "')]")).click();
	}

	public void validateNewlyCreatedWorkSpace(String input) {
		// validate the newly created workspace
		boolean workspace = driver.findElement(By.xpath("//p[contains(text(),'" + input + "')]")).isDisplayed();
		Assert.assertTrue(workspace, "The newly created workspace is not displayed.");

	}

	public void validateDeletedWorkSpace(String workSpaceName) {
		// validate the newly created workspace
		boolean workspace = driver.findElement(By.xpath("//p[contains(text(),'" + workSpaceName + "')]")).isDisplayed();
		Assert.assertFalse(workspace, "The newly created workspace is displayed.");
	}

	public void refreshWorkSpacePage() {
		// Refresh the page
		driver.navigate().refresh();
	}
}
