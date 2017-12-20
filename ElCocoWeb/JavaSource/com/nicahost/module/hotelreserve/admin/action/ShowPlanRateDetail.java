/*
 * Created on Aug 31, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.common.util.vlh.ValueListHandler;
import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowPlanRateDetail extends AdminBaseAction{

	 /* (non-Javadoc)
	 * @see com.nicahost.module.hotelreserve.admin.action.AdminBaseAction#adminExecuteAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.nicahost.framework.common.form.HeaderForm, com.nicahost.framework.common.form.FooterForm)
	 */
	public ActionForward adminExecuteAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {
				
		ActionForward forward = null;
		ValueListHandler resultList = null;				

		HotelAdminService service = HotelAdminService.getInstance();			
		resultList = service.getPlanRatesHandler();
		
		prepareValueListHandlerForView(resultList,request);
				
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		return forward;
	}



}
