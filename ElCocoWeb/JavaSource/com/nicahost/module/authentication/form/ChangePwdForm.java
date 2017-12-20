
package com.nicahost.module.authentication.form;

import org.apache.struts.validator.ValidatorForm;
/**
 * 
 * @author Henry
 * version 1.1 Sep 3, 2006
 * 
 * playaelcoco.com.ni
 */
public class ChangePwdForm extends ValidatorForm {
	private String userId;
	private String password;
	private String retypepassword;
	private String oldPassword;
	
	
	/**
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param string
	 */
	public void setUserId(String string) {
		userId = string;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string) {
		password = string;
	}

	/**
	 * @return
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param string
	 */
	public void setOldPassword(String string) {
		oldPassword = string;
	}

	/**
	 * @return
	 */
	public String getRetypepassword() {
		return retypepassword;
	}

	/**
	 * @param string
	 */
	public void setRetypepassword(String string) {
		retypepassword = string;
	}

}
