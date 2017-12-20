
package com.nicahost.framework.common.config;

import org.apache.struts.config.impl.ModuleConfigImpl;
/**
 * 
 * @author Henry
 * version 1.1 Sep 9, 2006
 * 
 * playaelcoco.com.ni
 */
public class NicahostModuleConfigImpl extends ModuleConfigImpl {
	
	public NicahostModuleConfigImpl(String prefix) {
		super(prefix);
		super.actionMappingClass = "com.nicahost.framework.common.action.PermissionActionMapping";
	}

}
