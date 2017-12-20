
package com.nicahost.framework.common.action;

import org.apache.struts.action.ActionMapping;

/**
 * 
 * @author Henry
 * version 1.1 Sep 9, 2006
 * 
 * playaelcoco.com.ni
 */

public class PermissionActionMapping extends ActionMapping {
	private String optionId;
	private String permId;
	
	public PermissionActionMapping() {
		super();
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
	public String getPermId() {
		return permId;
	}

	/**
	 * @param string
	 */
	public void setOptionId(String string) {
		optionId = string;
	}

	/**
	 * @param string
	 */
	public void setPermId(String string) {
		permId = string;
	}

}
