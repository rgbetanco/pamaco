/*
 * Created on Aug 16, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.view;

import java.util.Calendar;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoomDateView {

	private String index;
	private Calendar value;
	private boolean enable;
	/**
	 * @return
	 */
	public String getIndex() {
		return index;
	}

	/**
	 * @return
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @return
	 */
	public Calendar getValue() {
		return value;
	}

	/**
	 * @param string
	 */
	public void setIndex(String string) {
		index = string;
	}

	/**
	 * @param b
	 */
	public void setEnable(boolean b) {
		enable = b;
	}

	/**
	 * @param calendar
	 */
	public void setValue(Calendar calendar) {
		value = calendar;
	}

}
