/*
 * Created on Aug 23, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.view;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Ronald
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DateRangeView implements Serializable{
	private Calendar daterange;
	/**
	 * @return
	 */
	public Calendar getDaterange() {
		return daterange;
	}

	/**
	 * @param string
	 */
	public void setDaterange(Calendar string) {
		daterange = string;
	}

}
