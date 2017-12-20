package com.nicahost.module.hotelreserve.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author Henry
 * version 1.1 Sep 23, 2006
 * 
 * playaelcoco.com.ni
 */
public class ShowReserveInfo extends BaseAction {

	/* (non-Javadoc)
	 * @see com.nicahost.module.hotelreserve.admin.action.AdminBaseAction#adminExecuteAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.nicahost.framework.common.form.HeaderForm, com.nicahost.framework.common.form.FooterForm)
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

		//Invocacion de servicio
		HotelReserveService service = HotelReserveService.getInstance();		
		Collection countries = service.getCountry();
		
		request.setAttribute("countries", countries);
		forward = mapping.findForward("Success");
		
		return forward;
	}

}
