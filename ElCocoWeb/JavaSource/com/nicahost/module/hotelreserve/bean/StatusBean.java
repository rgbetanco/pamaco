package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;

/**
 * @author henry
 * Version 1.0 Oct 5, 2006
 *
 * playaelcoco.com.ni
 */
public class StatusBean implements Serializable, Comparable {
	private String code;
	private String description;
	
	
	public StatusBean(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		StatusBean bean = (StatusBean) arg0;
		return description.compareTo(bean.getDescription());
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param string
	 */
	public void setCode(String string) {
		code = string;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

}
