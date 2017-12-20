/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.form.Step01Form;
import com.nicahost.module.hotelreserve.helper.ReserveSession;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Step00Action extends BaseAction {

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
			//Vector de navegacion	
	
			//Aqui creo una nueva session tipo ReserveSession con el objetivo de persitir los datos
			//de la reserva.  hjiron
			//Obtengo del request si la pagina fue ya submitted
			String submitted = request.getParameter("submitted");
			HttpSession httpSession = request.getSession();
			ReserveSession reserveSession = (ReserveSession) httpSession.getAttribute("reserveSession");
			if (reserveSession == null) {
				reserveSession = new ReserveSession();
				httpSession.setAttribute("reserveSession",reserveSession);				
			} else { /*Si viene llena, hay que vaciar la session*/
				//reserveSession.clearSession();
			}

			//Invocacion de servicio
			HotelReserveService service = HotelReserveService.getInstance();
			
			Collection roomTypes = service.getRoomTypes();			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",getLocale(request));
			String serverDate = dateFormat.format(cal.getTime());
			int defaultNights = service.getDefaultNights();
			cal.add(Calendar.DATE,defaultNights); //Agrego 15 dias a la fecha actual			
			String endDate = dateFormat.format(cal.getTime());
			
			//obtiene los idiomas disponibles
			Collection languages = service.getLanguage();
			
			//Guardar objetos en el form si en caso es la primera vez que se ejecuta la pigina
			if (submitted == null){
				((Step01Form) form).setServerDate(serverDate);
				((Step01Form) form).setInitDate(serverDate);
				((Step01Form) form).setEndDate(endDate);	
			}
			
			
			Step01Form step01Form = (Step01Form) form;
			
			//Obtiene el bean con todas las reservaciones de aqui en 15 dias
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			
			cal1.setTime(dateFormat.parse(step01Form.getInitDate()));
			//cal1.setTime(new Date());
			//cal2.add(Calendar.DATE, 15);
			cal2.setTime(dateFormat.parse(step01Form.getEndDate()));
			
			Collection ReservationCal = service.getReservationCalendar(cal1, cal2);
			Collection dateRange = service.getDateRange(cal1, cal2);
			//Guardar objetos en el request
			request.setAttribute("roomTypes", roomTypes);
			request.setAttribute("languages",languages);
			request.setAttribute("defaultNights",Integer.toString(defaultNights));
			request.setAttribute("ReservationCal", ReservationCal);
			request.setAttribute("DateRange", dateRange);
						
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}


}
