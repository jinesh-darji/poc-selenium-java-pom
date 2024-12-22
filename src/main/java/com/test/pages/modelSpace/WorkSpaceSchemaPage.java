package com.ubix.pages.modelSpace;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.ubix.base.TestBase;

public class WorkSpaceSchemaPage extends TestBase {

	public void typeTags(String input) {
		type("txt_tags_XPATH", input);
		driver.findElement(By.xpath(OR.getProperty("txt_tags_XPATH"))).sendKeys(Keys.ENTER);
	}

	public void clickSave() {
		click("btn_save_XPATH");
	}

	public void clickPublish() {
		click("btn_publish2_XPATH");
	}
	
	public void enterTag(String input) {
		type("txt_tags_XPATH", input);
		pressEnter("txt_tags_XPATH");
		
	}
	
	public void verifySaveWorkSpaceSchema() throws IOException {
		verifyTrue("txt_saveWorkSpaceSchemaSuccessMsg_XPATH", "Verification failling");
	}

}
