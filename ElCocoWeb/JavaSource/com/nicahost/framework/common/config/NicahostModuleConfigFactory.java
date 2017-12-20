package com.nicahost.framework.common.config;

import java.io.Serializable;

import org.apache.struts.config.ModuleConfig;
import org.apache.struts.config.ModuleConfigFactory;

/**
 * 
 * @author Henry
 * version 1.1 Sep 9, 2006 
 * 
 * playaelcoco.com.ni
 */

public class NicahostModuleConfigFactory
	extends ModuleConfigFactory
	implements Serializable {

	/* (non-Javadoc)
	 * @see org.apache.struts.config.ModuleConfigFactory#createModuleConfig(java.lang.String)
	 */
	public ModuleConfig createModuleConfig(String prefix) {
		
		return new NicahostModuleConfigImpl(prefix);
	}

}
