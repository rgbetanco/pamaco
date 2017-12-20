/*
 * Created on Aug 23, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoomReserveDetailBean implements Serializable {
	private Calendar fecha;
	private PlanRateBean planRate;
	
	public RoomReserveDetailBean() {
	}
	
	
	/**
	 * @return
	 */
	public Calendar getFecha() {
		return fecha;
	}

	/**
	 * @return
	 */
	public PlanRateBean getPlanRate() {
		return planRate;
	}

	/**
	 * @param calendar
	 */
	public void setFecha(Calendar calendar) {
		fecha = calendar;
	}
	
	public void setFecha(long fec) {
		fecha = Calendar.getInstance();
		fecha.setTime(new Date(fec));
	}

	/**
	 * @param bean
	 */
	public void setPlanRate(PlanRateBean bean) {
		planRate = bean;
	}

}
