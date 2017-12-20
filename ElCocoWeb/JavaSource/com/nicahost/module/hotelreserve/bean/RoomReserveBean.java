
package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import com.nicahost.module.hotelreserve.common.Constants;

/**
 * 
 * @author Henry
 * version 1.1 Sep 13, 2006
 * 
 * playaelcoco.com.ni
 */
public class RoomReserveBean implements Serializable {
	private String roomId;
	private String roomName;
	private Calendar iniDate;
	private Calendar endDate;
	private ArrayList detail;
	private int guests;
	private int pets;
	private int rooms;
	
	
	public RoomReserveBean() {
		roomId = "";
		detail = new ArrayList();
		roomName = "";
		guests = 1;
		rooms = 1;
				
	}
	/**
	 * @return
	 */
	public ArrayList getDetail() {
		return detail;
	}

	/**
	 * @return
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 * @return
	 */
	public Calendar getIniDate() {
		return iniDate;
	}

	/**
	 * @return
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * @return
	 */
	public String getRoomName() {
		return roomName;
	}

	/**
	 * @param list
	 */
	public void setDetail(ArrayList list) {
		detail = list;
	}

	/**
	 * @param calendar
	 */
	public void setEndDate(Calendar calendar) {
		endDate = calendar;
	}

	public void setEndDate(long fec) {
		endDate = Calendar.getInstance();
		endDate.setTime(new Date(fec));
	}	

	/**
	 * @param calendar
	 */
	public void setIniDate(Calendar calendar) {
		iniDate = calendar;
	}
	
	public void setIniDate(long fec) {
		iniDate = Calendar.getInstance();
		iniDate.setTime(new Date(fec));
	}	

	/**
	 * @param string
	 */
	public void setRoomId(String string) {
		roomId = string;
	}

	/**
	 * @param string
	 */
	public void setRoomName(String string) {
		roomName = string;
	}

	/**
	 * @return
	 */
	public int getGuests() {
		return guests;
	}

	/**
	 * @return
	 */
	public int getPets() {
		return pets;
	}

	/**
	 * @param i
	 */
	public void setGuests(int i) {
		guests = i;
	}

	/**
	 * @param i
	 */
	public void setPets(int i) {
		pets = i;
	}
	
	public BigDecimal getSubTotal() {
		BigDecimal res = new BigDecimal("0.00");
		RoomReserveDetailBean element;
		PlanRateBean rate;
		for (Iterator iter = detail.iterator(); iter.hasNext();) {
			element = (RoomReserveDetailBean) iter.next();
			rate = element.getPlanRate();	
			res = res.add(rate.getPrice());			
		}
		
		res = res.multiply(new BigDecimal(rooms));
		
		for (Iterator iter = detail.iterator(); iter.hasNext();) {
			element = (RoomReserveDetailBean) iter.next();
			rate = element.getPlanRate();			
			
			if (guests > rate.getMaxGuests()) {
				int additional = guests - rate.getMaxGuests();
				double a = additional * rate.getAdditional().doubleValue();
				res = res.add(new BigDecimal(a));
			}

		}
				
		
		
		return res;
	}
	
	public BigDecimal getIVA() {
		BigDecimal res = getSubTotal();
		res = res.multiply(new BigDecimal(Constants.IVA));
		
		return res;
	}
	
	public BigDecimal getTotal() {
		BigDecimal res = getSubTotal();
		res = res.add(getIVA());
		
		return res;
	}
	

	
	public String getNumNights() {
		return convertMilliToDays(parseDate(iniDate), parseDate(endDate));
	}
	
	
	private Long parseDate(Calendar dateParam) {

		long millis = dateParam.getTime().getTime();
		Long result = new Long(millis);

		return result;
	}

	
	private String convertMilliToDays(Long initDate, Long endDate) {
		long numFinParm = endDate.longValue();
		long numIniParm = initDate.longValue();
		
		long numNights = (numFinParm - numIniParm) / Constants.ONE_DAY_MILLISECOND;
		
		String result = Long.toString(numNights);
		
		return result;
	}	

	/**
	 * @return
	 */
	public int getRooms() {
		return rooms;
	}

	/**
	 * @param i
	 */
	public void setRooms(int i) {
		rooms = i;
	}

}
