package com.nicahost.module.hotelreserve.admin.form;

import org.apache.struts.validator.ValidatorActionForm;

/**
 * @author Henry
 * version 1.1 Sep 4, 2006
 * 
 * playaelcoco.com.ni
 */
public class UserForm extends ValidatorActionForm {
	
	private String userId;
	private String name;
	private String password;
	private String password2;
	private String status;
	private String email;
	private String groupId;

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 */
	public void setGroupId(String string) {
		groupId = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string) {
		password = string;
	}

	/**
	 * @param string
	 */
	public void setPassword2(String string) {
		password2 = string;
	}

	/**
	 * @param string
	 */
	public void setStatus(String string) {
		status = string;
	}

	/**
	 * @param string
	 */
	public void setUserId(String string) {
		userId = string;
	}

}
