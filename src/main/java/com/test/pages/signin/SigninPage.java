package com.ubix.pages.signin;

import com.ubix.base.TestBase;

public class SigninPage extends TestBase {

	public void enterEmail(String input) {
		type("txt_email_CSS", input);
	}

	public void enterPassword(String input) {
		type("txt_password_CSS", input);
	}

	public void clickSubmit() {
		click("btn_signbtn_XPATH");
	}
}
