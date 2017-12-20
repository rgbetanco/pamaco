/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.bean.RoomReserveBean;
import com.nicahost.module.hotelreserve.common.Constants;
import com.nicahost.module.hotelreserve.dto.Reserve01DTO;
import com.nicahost.module.hotelreserve.form.ReserveForm;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowQuoteForRoomsAction extends BaseAction {

	/* (non-Javadoc)
	 * @see com.nicahost.framework.common.action.BaseAction#executeAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.nicahost.framework.common.form.HeaderForm, com.nicahost.framework.common.form.FooterForm)
	 */
	private int roomid = 0;
	private long checkindate = 0;
	private long checkoutdate = 0;
	
	private Collection col1 = null;
	
	public ActionForward executeAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

		ActionForward forward = null;

		col1 = new ArrayList();
		roomid = 0;
		checkindate = 0;
		checkoutdate = 0;
		
		String[] idDate = request.getParameterValues("dayroom");
		Collection col = new ArrayList();
		int idRoomini = 0;
		int idRoomL = 0;
		
		long checkindateL = 0;
		long checkoutdateL = 0;
		
		for (int i=0; i<idDate.length; i++){
			
			int j = idDate[i].indexOf(",");
			String no = idDate[i].substring(0, j);
			String iniDate = idDate[i].substring(j+1);
			
			try{
				Reserve01DTO dto = new Reserve01DTO();
				idRoomL = Integer.parseInt(no);
				
				if(idRoomL != idRoomini && idRoomini == 0){
					dto.setIniRange(true);
				}
				if (i == idDate.length - 1){
					dto.setFinRange(true);
				}
				
				checkoutdateL = Long.parseLong(iniDate);
				checkindateL = Long.parseLong(iniDate);
				
				dto.setRoomid(idRoomL);
				dto.setCheckindate(checkindateL);
				dto.setCheckoutdate(checkoutdateL);
				col.add(dto);
				idRoomini = idRoomL;
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
			
			//variables to add to the bean
			int conId = 0;
			long conDate = 0;
			boolean ini = false;
			boolean fin = false;
			
			
			for (Iterator items = col.iterator(); items.hasNext();) {
					Reserve01DTO element = (Reserve01DTO) items.next();
					 conId = element.getRoomid();
					 conDate = element.getCheckindate();
					 ini = element.isIniRange();
					 fin = element.isFinRange();
					if (ini){
						updateValues(conId, conDate, conDate, false);
					} else if (this.roomid != conId){
						addCollection();
						updateValues(conId, conDate, conDate, false);
					} else if(roomid == conId && conDate != (this.checkoutdate + Constants.ONE_DAY_MILLISECOND)){
						addCollection();
						updateValues(conId, conDate, conDate, true);
					} else if (roomid == conId && conDate == (this.checkoutdate + Constants.ONE_DAY_MILLISECOND)){
						updateValues(conId, conDate, conDate, false);
					}
					if(fin){
						addCollection();
					}
				}

		//Chele aqui esta para que te divirtas jijijijiji		
		
		//request.setAttribute("reservations", col1);
		((ReserveForm) form).setSelectedRooms(null);
		((ReserveForm) form).setSelectedRooms(col1);
		
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

	public void updateValues(int id, long inDate, long outdate, boolean sameDay){
		if (this.roomid < id){
			roomid = id;
			checkindate = inDate;	
		}
		if (sameDay){
			checkindate = inDate;
		}
		checkoutdate = outdate;
	}
	public void addCollection() throws Exception {
		/*Reserve01DTO dto1 = new Reserve01DTO();
		dto1.setRoomid(roomid);
		dto1.setCheckindate(checkindate);
		dto1.setCheckoutdate(checkoutdate);
		col1.add(dto1);
		*/
		RoomReserveBean quoteBean; 
		HotelReserveService service = HotelReserveService.getInstance();
		Calendar initDateCal = Calendar.getInstance();
		initDateCal.setTime(new Date(checkindate));
		Calendar endDateCal = Calendar.getInstance();
		endDateCal.setTime(new Date(checkoutdate));
		quoteBean = service.getRoomQuote(Integer.toString(roomid), initDateCal, endDateCal);
		
		col1.add(quoteBean);
		
	}

}
