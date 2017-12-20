/*
 * Created on Aug 21, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.nicahost.module.hotelreserve.common.Constants;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PlanRateBean implements Serializable, Comparable {
	private String planNo;
	private String name;
	private BigDecimal price;
	private BigDecimal additional;
	private int minNights;
	private Calendar iniDate;
	private Calendar endDate;
	private boolean active;
	private int maxGuests;
	
	
/* (non-Javadoc)
 * @see java.lang.Comparable#compareTo(java.lang.Object)
 */
public int compareTo(Object arg0) {
	PlanRateBean bean = (PlanRateBean) arg0;
	
	if (bean.getIniDate().getTime().getTime() - this.iniDate.getTime().getTime() >= 0 &&
		bean.getEndDate().getTime().getTime() - this.endDate.getTime().getTime() <= 0 ) {
		
		return 1;
	} else {
	
		return -1;
	}
	
	
}
	
	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @return
	 */
	public BigDecimal getAdditional() {
		return additional;
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
	public int getMinNights() {
		return minNights;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getPlanNo() {
		return planNo;
	}

	/**
	 * @return
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param b
	 */
	public void setActive(boolean b) {
		active = b;
	}

	/**
	 * @param decimal
	 */
	public void setAdditional(BigDecimal decimal) {
		additional = decimal;
	}

	/**
	 * @param calendar
	 */
	public void setEndDate(Calendar calendar) {
		endDate = calendar;
	}

	/**
	 * @param calendar
	 */
	public void setIniDate(Calendar calendar) {
		iniDate = calendar;
	}

	/**
	 * @param i
	 */
	public void setMinNights(int i) {
		minNights = i;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param string
	 */
	public void setPlanNo(String string) {
		planNo = string;
	}

	/**
	 * @param decimal
	 */
	public void setPrice(BigDecimal decimal) {
		price = decimal;
	}

	/**
	 * @return
	 */
	public int getMaxGuests() {
		return maxGuests;
	}

	/**
	 * @param i
	 */
	public void setMaxGuests(int i) {
		maxGuests = i;
	}
	
	
	
	
	public void setIniDate(long fecha) {
		iniDate = Calendar.getInstance();
		iniDate.setTime(new Date(fecha));		
	}
	
	public void setIniDate(String fecha) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT);
		iniDate = Calendar.getInstance();
		iniDate.setTime(dateFormat.parse(fecha));	
	}

	public void setEndDate(long fecha) {
		endDate = Calendar.getInstance();
		endDate.setTime(new Date(fecha));		
	}
	
	public void setEndDate(String fecha) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT);
		endDate = Calendar.getInstance();
		endDate.setTime(dateFormat.parse(fecha));	
	}

}
