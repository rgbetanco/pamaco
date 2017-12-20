package com.nicahost.module.authentication.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.authentication.bean.UserBean;
import com.nicahost.module.authentication.common.Constants;
import com.nicahost.module.authentication.exception.ChangePasswordException;
import com.nicahost.module.authentication.form.SignInForm;
import com.nicahost.module.authentication.service.AuthenticationService;


/**
 * @author Henry
 * version 1.0 Jul 9, 2006
 * 
 * nicarealty.com
 */
public class LoginAction extends BaseAction {

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
			SignInForm signForm = (SignInForm) form;

			HttpSession session = request.getSession(true);
			
			String userid = signForm.getUserId();
			String password = signForm.getPassword();
			
			
			AuthenticationService service = AuthenticationService.getInstance();
		
			try {
				UserBean bean = service.authenticate(userid,password);
				
				synchronized(session) {
					// Hay que matar la session y crear una nueva
					session.invalidate();
					session = request.getSession(true);				
					session.setAttribute(Constants.USERPROFILE,bean);
				}
				
			} catch (ChangePasswordException cex) {
				forward = mapping.findForward("ChangePassword");
				return forward;
			}
		

			forward = mapping.findForward("Success");
			
			return forward;		
	}
	
	

}
