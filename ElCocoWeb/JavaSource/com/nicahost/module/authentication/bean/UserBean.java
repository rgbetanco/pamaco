package com.nicahost.module.authentication.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author hjiron
 * version 1.0 Jul 2, 2006
 */
public class UserBean implements Serializable, Comparable {
	private String userId;
	private String name;
	private String password;
	private String status;
	private String email;
	private String groupId;
	private String groupName;	
	private List permissions;
	
	
	public UserBean() {
		permissions = new ArrayList();
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		int res = -1;
		try {
			UserBean bean = (UserBean) arg0;
			res = name.compareTo(bean.getName());			
		} catch (Exception ex) {/* do nothing*/}
	
		return res;
	}

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
	public List getPermissions() {
		return permissions;
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
	 * @param list
	 */
	public void setPermissions(List list) {
		permissions = list;
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

	public void addPermission(PermInfoBean bean) {
		permissions.add(bean);
	}
	
/*	public void addPermission(String permId, String permission) {
		permissions.add(new PermInfoBean(permId,permission));		
	}
*/	
	public void addPermission(String permId, String permission, String optionId) {
		addPermission(new PermInfoBean(permId,permission,optionId));
	}
	
	public boolean delPermission(PermInfoBean bean) {
		return permissions.remove(bean);
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
	public void setGroupName(String string) {
		groupName = string;
	}

}
