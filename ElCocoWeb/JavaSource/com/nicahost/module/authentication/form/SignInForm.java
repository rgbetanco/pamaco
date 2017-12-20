
package com.nicahost.module.authentication.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * 
 * @author Henry
 * version 1.0 Jul 9, 2006
 * 
 * nicarealty.com
 */
public class SignInForm extends ValidatorForm {
	private String userId;
	private String password;
	private String nextview;
	
	
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
	public String getNextview() {
		return nextview;
	}

	/**
	 * @param string
	 */
	public void setNextview(String string) {
		nextview = string;
	}

}
