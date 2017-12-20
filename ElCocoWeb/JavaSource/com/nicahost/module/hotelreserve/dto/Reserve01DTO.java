/*
 * Created on Aug 27, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.dto;

/**
 * @author Ronald
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Reserve01DTO {
	private int roomid;
	private long checkindate;
	private long checkoutdate;
	private boolean iniRange;
	private boolean finRange;
	private boolean iniRes;
	private boolean finRes;
	
	/**
	 * @return
	 */
	public long getCheckindate() {
		return checkindate;
	}

	/**
	 * @return
	 */
	public long getCheckoutdate() {
		return checkoutdate;
	}

	/**
	 * @return
	 */
	public int getRoomid() {
		return roomid;
	}

	/**
	 * @param l
	 */
	public void setCheckindate(long l) {
		checkindate = l;
	}

	/**
	 * @param l
	 */
	public void setCheckoutdate(long l) {
		checkoutdate = l;
	}

	/**
	 * @param i
	 */
	public void setRoomid(int i) {
		roomid = i;
	}

	/**
	 * @return
	 */
	public boolean isFinRange() {
		return finRange;
	}

	/**
	 * @return
	 */
	public boolean isIniRange() {
		return iniRange;
	}

	/**
	 * @param b
	 */
	public void setFinRange(boolean b) {
		finRange = b;
	}

	/**
	 * @param b
	 */
	public void setIniRange(boolean b) {
		iniRange = b;
	}

	/**
	 * @return
	 */
	public boolean isFinRes() {
		return finRes;
	}

	/**
	 * @return
	 */
	public boolean isIniRes() {
		return iniRes;
	}

	/**
	 * @param b
	 */
	public void setFinRes(boolean b) {
		finRes = b;
	}

	/**
	 * @param b
	 */
	public void setIniRes(boolean b) {
		iniRes = b;
	}

}
