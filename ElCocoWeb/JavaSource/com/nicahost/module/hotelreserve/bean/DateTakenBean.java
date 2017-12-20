/*
 * Created on Sep 17, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Ronald
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DateTakenBean implements Serializable{
	private long cal;
	private int status;

	/**
	 * @return
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * @param i
	 */
	public void setStatus(int i) {
		status = i;
	}

	/**
	 * @return
	 */
	public long getCal() {
		return cal;
	}

	/**
	 * @param l
	 */
	public void setCal(long l) {
		cal = l;
	}

}
