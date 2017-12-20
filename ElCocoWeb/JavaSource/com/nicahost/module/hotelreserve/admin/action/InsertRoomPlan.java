
package com.nicahost.module.hotelreserve.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.form.RoomPlanForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;

/**
 * 
 * @author Henry
 * version 1.1 Sep 3, 2006
 * 
 * playaelcoco.com.ni
 */
public class InsertRoomPlan extends AdminBaseAction {

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
		RoomPlanForm frm = (RoomPlanForm) form;
		String planno = request.getParameter("newRoomPlan");	
		HotelAdminService service = HotelAdminService.getInstance();
		if (service.insertPlanRateForRoom(frm.getRoomId(),planno)) {
			saveMessage(request,"msg.insert.success", "1");
		} else {
			saveError(request,"msg.insert.failure");
		}
		
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
