/*
 * Created on Sep 27, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;
import com.nicahost.module.hotelreserve.admin.service.ResStatistics;
import com.nicahost.module.hotelreserve.common.Constants;

/**
 * @author Ronald
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class showStatistic extends AdminBaseAction {
	
	private Calendar cal = Calendar.getInstance();
	private Calendar cal1 = Calendar.getInstance();
	private Collection col = null;
	
	private DateFormat sdf = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT, Locale.US);
	
	public ActionForward adminExecuteAction(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response,
			HeaderForm headerForm,
			FooterForm footerForm)
			throws Exception {

			ActionForward forward = null;
			
			String cliente = request.getParameter("cliente");
			String rooms = request.getParameter("rooms");
			
			String dateIni = request.getParameter("dateIniN");
			String dateFin = request.getParameter("dateFinN");
			
			cal.setTime(sdf.parse(dateIni));
			cal1.setTime(sdf.parse(dateFin));
			
			long dateIniL = cal.getTime().getTime();
			long dateFinL = cal1.getTime().getTime();
			
			HotelAdminService service = new HotelAdminService();
			col = service.getStatistics(dateIniL, dateFinL, rooms, cliente);
			
			new ResStatistics(dateIni, dateFin, cliente, rooms, col);
			
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
			return forward;

			}
}
