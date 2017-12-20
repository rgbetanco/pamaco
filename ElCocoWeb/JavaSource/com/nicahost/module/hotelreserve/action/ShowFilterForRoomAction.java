package com.nicahost.module.hotelreserve.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.common.Constants;
import com.nicahost.module.hotelreserve.form.ReserveForm;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * 
 * @author Henry
 * version 1.1 Sep 6, 2006
 * 
 * playaelcoco.com.ni
 */
public class ShowFilterForRoomAction extends BaseAction {

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
			ActionForward forward;
			DateFormat dateFormat = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT,getLocale(request));
						
			// Obtiene valores del request
			String roomId = request.getParameter("roomId");
			String roomTypeId = request.getParameter("roomTypeId");
			String next = request.getParameter("next");
			String prev = request.getParameter("prev");
			
			String off = request.getParameter("offset");
			int offset = 32;
			
			if (!GenericValidator.isBlankOrNull(off) && GenericValidator.isInt(off)) {
				offset = Integer.parseInt(off);
			}
			 
			//Invocacion de servicio
			HotelReserveService service = HotelReserveService.getInstance();

			Calendar initDateCal = Calendar.getInstance();
			Calendar endDateCal = Calendar.getInstance();			
			initDateCal.setTime(dateFormat.parse(dateFormat.format(new Date())));
			endDateCal.setTime(dateFormat.parse(dateFormat.format(new Date())));
			endDateCal.add(Calendar.DATE,offset);
			
			if(!GenericValidator.isBlankOrNull(next)) {
				initDateCal.setTime(dateFormat.parse(next));
				endDateCal.setTime(dateFormat.parse(next));
				endDateCal.add(Calendar.DATE,offset);
				prev = dateFormat.format(initDateCal.getTime());
			} else 
			
			if(!GenericValidator.isBlankOrNull(prev)) {
				initDateCal.setTime(dateFormat.parse(prev));
				initDateCal.add(Calendar.DATE,-offset);
				endDateCal.setTime(dateFormat.parse(prev));
				Calendar tmp = Calendar.getInstance();
				tmp.setTime(dateFormat.parse(dateFormat.format(new Date())));				
				if (initDateCal.after(tmp)) {
					 prev = dateFormat.format(initDateCal.getTime()); 
				} 
			}
			
			next = dateFormat.format(endDateCal.getTime());
						
			Collection c = new ArrayList();
			
			if (!GenericValidator.isBlankOrNull(roomId)) {
				c = service.getCalendarAvailabilityForRoom(roomId,initDateCal,endDateCal);
			} else if (!GenericValidator.isBlankOrNull(roomTypeId)) {
				c = service.getCalendarAvailability(initDateCal,endDateCal);
			}
			
			String roomName = service.getRoomName(roomId);
			String roomTypeName = service.getRoomTypeName(roomTypeId);
			
			((ReserveForm) form).setRoomId(roomId);
			((ReserveForm) form).setRoomName(roomName);
			((ReserveForm) form).setRoomTypeId(roomTypeId);
			((ReserveForm) form).setRoomTypeName(roomTypeName);
			((ReserveForm) form).setInitDate(dateFormat.format(initDateCal.getTime()));
			initDateCal.add(Calendar.DATE,5);
			((ReserveForm) form).setEndDate(dateFormat.format(initDateCal.getTime()));
			//seteo el roomid en los selectedrooms de una vez
			String[] r = new String[1];
			r[0] = roomId;
			((ReserveForm) form).setSelectedIdRooms(r);			
			
			//Guardar objetos en el request	
			HashMap plnk = new HashMap();
			plnk.put("prev",prev);
			plnk.put("roomId",roomId);
			plnk.put("roomTypeId",roomTypeId);
			plnk.put("offset",Integer.toString(offset));
			
			HashMap nlnk = new HashMap();
			nlnk.put("next",next);
			nlnk.put("roomId",roomId);
			nlnk.put("roomTypeId",roomTypeId);
			nlnk.put("offset",Integer.toString(offset));
								
			request.setAttribute("roomView", c);
			request.setAttribute("prev",prev);
			request.setAttribute("plnk", plnk);
			request.setAttribute("nlnk", nlnk);
			
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
