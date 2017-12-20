
package com.nicahost.module.authentication.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * 
 * @author Henry
 * version 1.1 Sep 3, 2006
 * 
 * playaelcoco.com.ni
 */
public class ForgotPwdForm extends ValidatorForm {
	private String userId;
	
	
	/**
	 * @return
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @param string
	 */
	public void setUserId(String string) {
		userId = string;
	}

}
