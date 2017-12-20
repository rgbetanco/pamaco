/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.form.LanguageForm;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SwitchLanguageAction extends BaseAction {
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
		
		LanguageForm langForm = (LanguageForm) form;
		String lang = langForm.getLang();
		//String country = CommonService.getInstance().getCountry(lang);
		
		String host = request.getHeader("Referer");
		
		String country = HotelReserveService.getInstance().getCountryLanguage(lang);
		
		setLocale(request,lang,country);
		
		//String d = (String) request.getSession().getAttribute("org.apache.struts.action.LOCALE");
		//String x = (String) request.getSession().getAttribute("idioma");
				
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		response.sendRedirect(host);

		return forward;
	}

}
