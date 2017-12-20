package com.nicahost.module.hotelreserve.admin.form;

import org.apache.struts.validator.ValidatorActionForm;

public class UserGroupForm extends ValidatorActionForm {
	private String groupId;
	private String groupName;
	private String description;
	private String[] selectedPermissions;
	
	
	/**
	 * @return
	 */
	public String getDescription() {
		return description;
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
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
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
	public void setGroupName(String string) {
		groupName = string;
	}

	/**
	 * @return
	 */
	public String[] getSelectedPermissions() {
		return selectedPermissions;
	}

	/**
	 * @param strings
	 */
	public void setSelectedPermissions(String[] strings) {
		selectedPermissions = strings;
	}

}
