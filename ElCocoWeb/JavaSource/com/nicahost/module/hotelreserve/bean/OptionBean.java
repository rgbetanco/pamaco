/*
 * Created on Sep 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;
import java.util.ArrayList;

import com.nicahost.module.authentication.bean.*;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OptionBean implements Serializable, Comparable {
	
	private String optionId;
	private String description;
	private ArrayList permissions;
	
	public OptionBean() {
		this("","");
	}
	
	public OptionBean(String optionId, String description) {
		this.optionId = optionId;
		this.description = description;
		permissions = new ArrayList();
	}
	
	
	public int compareTo(Object arg0) {
		OptionBean bean = (OptionBean) arg0;
		
		return description.compareTo(bean.getDescription());
	}
	
	public void addPermission(PermInfoBean bean) {
		permissions.add(bean);
	}
	
/*	public void addPermission(String permId, String permission) {
		addPermission(new PermInfoBean(permId,permission));
	}
*/	
	public void addPermission(String permId, String permission, String optionId) {
		addPermission(new PermInfoBean(permId,permission,optionId));
	}
	

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return
	 */
	public String getOptionId() {
		return optionId;
	}

	/**
	 * @return
	 */
	public ArrayList getPermissions() {
		return permissions;
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
	public void setOptionId(String string) {
		optionId = string;
	}

	/**
	 * @param list
	 */
	public void setPermissions(ArrayList list) {
		permissions = list;
	}

}
