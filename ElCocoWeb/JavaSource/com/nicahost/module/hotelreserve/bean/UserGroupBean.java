package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;
import java.util.ArrayList;

import com.nicahost.module.authentication.bean.*;

public class UserGroupBean implements Serializable, Comparable {

	private String groupId;
	private String name;
	private String description;
	private ArrayList permissions;

	public UserGroupBean() {
		permissions = new ArrayList();
	}

	public UserGroupBean(String name, String description) {
		this();
		this.name = name;
		this.description = description;
	}

	public UserGroupBean(String groupId, String name, String description) {
		this();
		this.groupId = groupId;
		this.name = name;
		this.description = description;
	}

	public int compareTo(Object arg0) {
		UserGroupBean bean = (UserGroupBean) arg0;
		return name.compareTo(bean.getName());
	}

	public void addPermission(PermInfoBean bean) {
		permissions.add(bean);
	}
	
	public void addPermission(String permId, String optionId) {
		addPermission(new PermInfoBean(permId,optionId));
	}
	
	public void addPermission(String permId, String permission, String optionId) {
		addPermission(new PermInfoBean(permId,permission,optionId));
	}
	
	public void delPermission(PermInfoBean bean) {
		permissions.remove(bean);
	}
	
	public void delPermission(String permId, String permission, String optionId) {
		delPermission(new PermInfoBean(permId,permission,optionId));
	}
	
	public void delPermission(String permId, String optionId) {
		delPermission(new PermInfoBean(permId,optionId));
	}

	public String getDescription() {
		return description;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String string) {
		description = string;
	}

	public void setGroupId(String string) {
		groupId = string;
	}

	public void setName(String string) {
		name = string;
	}
	/**
	 * @return
	 */
	public ArrayList getPermissions() {
		return permissions;
	}

	/**
	 * @param list
	 */
	public void setPermissions(ArrayList list) {
		permissions = list;
	}

}