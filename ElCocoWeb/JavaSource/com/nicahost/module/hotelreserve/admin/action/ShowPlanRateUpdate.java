/*
 * Created on Aug 31, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.framework.common.view.OptionView;
import com.nicahost.module.hotelreserve.admin.form.PlanRateForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;
import com.nicahost.module.hotelreserve.bean.PlanRateBean;
import com.nicahost.module.hotelreserve.common.Constants;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowPlanRateUpdate extends AdminBaseAction {

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
		PlanRateForm frm = (PlanRateForm) form;
		String planNo = frm.getPlanNo();
		
		HotelAdminService service = HotelAdminService.getInstance();
		PlanRateBean bean = service.getPlanRate(planNo);
		BeanUtils.copyProperties(frm,bean);
		SimpleDateFormat df = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT);
		String iniDate = df.format(bean.getIniDate().getTime());
		String endDate = df.format(bean.getEndDate().getTime());
		frm.setIniDate(iniDate);
		frm.setEndDate(endDate);
		
		ArrayList guests = new ArrayList();
		for (int i = 1; i <= 15; i++) {
			OptionView view = new OptionView(Integer.toString(i), Integer.toString(i));
			guests.add(view);			
		}	
		
		ArrayList nights = new ArrayList();
		for (int i = 1; i <= 31; i++) {
			OptionView view = new OptionView(Integer.toString(i), Integer.toString(i));
			nights.add(view);			
		}	
		
		request.setAttribute("guests", guests);
		request.setAttribute("nights",nights);				
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
