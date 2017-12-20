package com.nicahost.module.hotelreserve.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

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
import com.nicahost.framework.common.view.OptionView;
import com.nicahost.module.hotelreserve.bean.RoomBean;
import com.nicahost.module.hotelreserve.bean.RoomReserveBean;
import com.nicahost.module.hotelreserve.common.Constants;
import com.nicahost.module.hotelreserve.exception.EmptyResultException;
import com.nicahost.module.hotelreserve.form.ReserveForm;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * 
 * @author Henry
 * version 1.1 Sep 6, 2006
 * 
 * playaelcoco.com.ni
 */

public class ShowQuoteAction extends BaseAction {

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
			//inicializacion de objetos session

			//Vector de navegacion			

			//Recuperacion de datos del request
			ReserveForm frm = (ReserveForm) form;			
			String[] roomIds = frm.getSelectedIdRooms();
			String roomId = frm.getRoomId();
			String roomTypeId = frm.getRoomTypeId();						
			String initDate = frm.getInitDate();
			String endDate = frm.getEndDate();
			
			DateFormat dateFormat = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT, getLocale(request));
			Calendar initDateCal = new GregorianCalendar();
			Calendar endDateCal = new GregorianCalendar();

			initDateCal.setTime(dateFormat.parse(initDate));
			endDateCal.setTime(dateFormat.parse(endDate));

			//Invocacion de servicio
			RoomBean roomBean;
			ArrayList checkedRooms = new ArrayList();
			RoomReserveBean quoteBean; 
			String[] maxRooms;
			
			HotelReserveService service = HotelReserveService.getInstance();
			
			if (!GenericValidator.isBlankOrNull(roomTypeId)) {
				roomBean = service.getAvailabilityForRoomType(roomTypeId,initDateCal, endDateCal);	
			} else {
				roomBean = service.getAvailabilityForRoom(roomId,initDateCal,endDateCal);
			}

			if(roomBean == null) 
				throw new EmptyResultException();

			quoteBean = service.getRoomQuote(roomBean.getRoomId(), initDateCal, endDateCal);			
			checkedRooms.add(quoteBean);

			
			//Guardar objetos en el form (tipo session)
			((ReserveForm) form).setSelectedRooms(checkedRooms);
			((ReserveForm) form).setInitDateCal(initDateCal);
			((ReserveForm) form).setEndDateCal(endDateCal);
			
			maxRooms = new String[roomBean.getMaxRooms()];
			for (int i = 1; i <= roomBean.getMaxRooms(); i++) {
				maxRooms[i-1] = Integer.toString(i);
			}
						
			request.setAttribute("maxRooms",maxRooms);
									
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
