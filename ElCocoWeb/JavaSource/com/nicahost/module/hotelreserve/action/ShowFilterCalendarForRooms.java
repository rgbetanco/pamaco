
package com.nicahost.module.hotelreserve.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @author henry
 * Version 1.0 Oct 4, 2006
 *
 * playaelcoco.com.ni
 */
public class ShowFilterCalendarForRooms extends BaseAction {

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
			String submitted = request.getParameter("submitted");

			//Invocacion de servicio
			HotelReserveService service = HotelReserveService.getInstance();
			
			Collection roomTypes = service.getRoomTypes();			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());			
			DateFormat dateFormat = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT,getLocale(request));
			String serverDate = dateFormat.format(cal.getTime());
			int defaultNights = service.getDefaultNights();
			cal.add(Calendar.DATE,defaultNights); //Agrego 15 dias a la fecha actual			
			String endDate = dateFormat.format(cal.getTime());
			
			//Guardar objetos en el form si en caso es la primera vez que se ejecuta la pigina
			if (submitted == null){
				((ReserveForm) form).setInitDate(serverDate);
				((ReserveForm) form).setEndDate(endDate);	
			}
			
			
			ReserveForm step01Form = (ReserveForm) form;
			
			//Obtiene el bean con todas las reservaciones de aqui en 15 dias
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			
			cal1.setTime(dateFormat.parse(step01Form.getInitDate()));
			//cal1.setTime(new Date());
			//cal2.add(Calendar.DATE, 15);
			cal2.setTime(dateFormat.parse(step01Form.getEndDate()));
			
			Collection ReservationCal = service.getReservationCalendar(cal1, cal2);
			Collection dateRange = service.getDateRange(cal1, cal2);
			
			String txtTotal = service.daysDiff(cal1,cal2);
			
			//Guardar objetos en el request
			request.setAttribute("txtTotal",txtTotal);
			request.setAttribute("roomTypes", roomTypes);
			request.setAttribute("defaultNights",Integer.toString(defaultNights));
			request.setAttribute("ReservationCal", ReservationCal);
			request.setAttribute("DateRange", dateRange);
						
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}


}
