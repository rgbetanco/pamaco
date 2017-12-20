package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * @author henry
 * Version 1.0 Sep 21, 2006
 *
 * playaelcoco.com.ni
 */
public class RoomReservePendingBean extends RoomReserveBean implements Serializable, Comparable {
	
	private String reserveId;
	private Calendar reserveDate;
	private String lastName;
	private String firstName;
	private String email;
	private String comments;
	private String code;
	private BigDecimal subTotal;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		RoomReservePendingBean bean = (RoomReservePendingBean) arg0;		
		return reserveDate.getTime().compareTo(bean.getReserveDate().getTime());		
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public Calendar getReserveDate() {
		return reserveDate;
	}

	/**
	 * @return
	 */
	public String getReserveId() {
		return reserveId;
	}

	/**
	 * @param string
	 */
	public void setCode(String string) {
		code = string;
	}

	/**
	 * @param string
	 */
	public void setComments(String string) {
		comments = string;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param calendar
	 */
	public void setReserveDate(Calendar calendar) {
		reserveDate = calendar;
	}
	
	public void setReserveDate(long fec) {
		reserveDate = Calendar.getInstance();
		reserveDate.setTime(new Date(fec));
	}	

	/**
	 * @param string
	 */
	public void setReserveId(String string) {
		reserveId = string;
	}

	/**
	 * @return
	 */
	public BigDecimal getSubTotal() {
		return subTotal;
	}

	/**
	 * @param decimal
	 */
	public void setSubTotal(BigDecimal decimal) {
		subTotal = decimal;
	}

}
