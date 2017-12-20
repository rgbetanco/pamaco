
package com.nicahost.module.authentication.exception;

import com.nicahost.framework.common.exception.BaseException;

/**
 * 
 * @author Henry
 * version 1.1 Sep 4, 2006
 * 
 * playaelcoco.com.ni
 */
public class NoPermissionException extends BaseException {
	private static final String _msgKey = "error.nopermission";
	
	public NoPermissionException() {
		setMessageKey(_msgKey);
	}
}
