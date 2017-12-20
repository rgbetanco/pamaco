package com.nicahost.module.authentication.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.authentication.form.ForgotPwdForm;
import com.nicahost.module.authentication.service.AuthenticationService;

/**
 * @author Henry
 * version 1.0 Jul 9, 2006
 * 
 * nicarealty.com
 */
public class ForgotPasswordAction extends BaseAction {

	/* (non-Javadoc)
	 * @see com.nicahost.framework.common.action.BaseAction#executeAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.nicahost.framework.common.form.HeaderForm, com.nicahost.framework.common.form.FooterForm)
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
		ForgotPwdForm pwdForm = (ForgotPwdForm) form;
		
		AuthenticationService service = AuthenticationService.getInstance();
		
		service.resetPassword(pwdForm.getUserId());
		
		forward = mapping.findForward("Success");

		return forward;
	}

}
