package com.nicahost.module.authentication.bean;

import java.io.Serializable;

/**
 * @author hjiron
 * version 1.0 Jul 2, 2006
 */
public class PermInfoBean implements Serializable, Comparable {
	private String optionId;
	private String permId;
	private String permission;
	
	public PermInfoBean() {
		this("","");		
	}
	
	public PermInfoBean(String permId, String optionId) {
		this(permId,"",optionId);
	}
	
	public PermInfoBean(String permId, String permission, String optionId) {
		this.permId = permId;
		this.permission = permission;
		this.optionId = optionId;		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		PermInfoBean bean = (PermInfoBean) arg0;		
		return permission.compareTo(bean.getPermission());
	}

	
	/**
	 * @return
	 */
	public String getPermId() {
		return permId;
	}

	/**
	 * @return
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * @param string
	 */
	public void setPermId(String string) {
		permId = string;
	}

	/**
	 * @param string
	 */
	public void setPermission(String string) {
		permission = string;
	}

	/**
	 * @return
	 */
	public String getOptionId() {
		return optionId;
	}

	/**
	 * @param string
	 */
	public void setOptionId(String string) {
		optionId = string;
	}

}
