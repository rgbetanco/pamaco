/*
 * Created on Aug 31, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.common.util.vlh.ValueListHandler;
import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.framework.common.view.OptionView;
import com.nicahost.module.hotelreserve.admin.form.RoomPlanForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;
import com.nicahost.module.hotelreserve.bean.PlanRateBean;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowRoomPlanDetail extends AdminBaseAction{

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
		String roomId = null;
		ValueListHandler resultList = null;
		RoomPlanForm f = (RoomPlanForm) form;
	
		roomId = f.getRoomId();
		
		HotelAdminService service = HotelAdminService.getInstance();
		Collection planRates = service.getPlanRates();
		Collection planRatesView = new ArrayList();		
		for (Iterator iter = planRates.iterator(); iter.hasNext();) {
			PlanRateBean element = (PlanRateBean) iter.next();
			OptionView view = new OptionView(element.getName(),element.getPlanNo());
			planRatesView.add(view);
		}
		
		//f.setPlans(roomPlans);		
		request.setAttribute("planRates",planRatesView);

		
		
		//ArrayList roomPlans = (ArrayList) service.getPlanRatesForRoom(roomId);
		resultList = service.getPlanRatesForRoomHandler(roomId);
		prepareValueListHandlerForView(resultList,request);
		
		
		
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		return forward;
	}

}
