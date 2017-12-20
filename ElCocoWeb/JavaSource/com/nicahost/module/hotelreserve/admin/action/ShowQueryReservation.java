
package com.nicahost.module.hotelreserve.admin.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.common.util.vlh.ValueListHandler;
import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.form.QueryForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;
import com.nicahost.module.hotelreserve.common.Constants;

/**
 * 
 * @author henry
 * Version 1.0 Oct 5, 2006
 *
 * playaelcoco.com.ni
 */
public class ShowQueryReservation extends AdminBaseAction{

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
		
		ArrayList status = new ArrayList();
		DateFormat dateFormat = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT,getLocale(request));
		QueryForm frm = (QueryForm) form;
		
		String checkIn = frm.getCheckIn();
		String checkOut = frm.getCheckOut();
		String stat = frm.getStatus();

		Calendar initDateCal = Calendar.getInstance();
		Calendar endDateCal = Calendar.getInstance();									

		if(!GenericValidator.isBlankOrNull(checkIn)) {			
			initDateCal.setTime(dateFormat.parse(checkIn));
		} else {
			initDateCal.set(Calendar.DAY_OF_MONTH,1);
			frm.setCheckIn(dateFormat.format(initDateCal.getTime()));
		}

		if(!GenericValidator.isBlankOrNull(checkOut)) {			
			endDateCal.setTime(dateFormat.parse(checkOut));
		} else {
			endDateCal.setTime(dateFormat.parse(dateFormat.format(new Date())));
			frm.setCheckOut(dateFormat.format(endDateCal.getTime()));
		}

		HotelAdminService service = HotelAdminService.getInstance();
		status = service.getReservationStatus();
		request.setAttribute("status",status);
				
		resultList = service.queryReservations(initDateCal,endDateCal,stat);		
		prepareValueListHandlerForView(resultList,request,20);
		
		// link 
		qLnk.put("checkIn",frm.getCheckIn());
		qLnk.put("checkOut",frm.getCheckOut());
		qLnk.put("status",frm.getStatus());

				
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		return forward;
	}



}
