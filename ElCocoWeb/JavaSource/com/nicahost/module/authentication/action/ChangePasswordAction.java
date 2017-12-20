package com.nicahost.module.authentication.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.authentication.form.ChangePwdForm;
import com.nicahost.module.authentication.service.AuthenticationService;

/**
 * 
 * @author Henry
 * version 1.0 Jul 9, 2006
 * 
 * nicarealty.com
 */
public class ChangePasswordAction extends BaseAction {

	/**
	 * @see com.nicahost.framework.common.action.BaseAction#executeAction(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse, HeaderForm, FooterForm)
	 */
	public ActionForward executeAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {
			
		ActionForward forward = null;
		ChangePwdForm chgPassword = (ChangePwdForm) form;
		
		
		AuthenticationService service = AuthenticationService.getInstance();		
		
		service.changePassword(chgPassword.getUserId(),chgPassword.getOldPassword(),chgPassword.getPassword());
				
		forward = mapping.findForward("Success");
		
		return forward;
	}

}
