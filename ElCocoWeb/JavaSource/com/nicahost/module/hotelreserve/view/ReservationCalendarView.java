/*
 * Created on Aug 17, 2006
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
public class ReservationCalendarView implements Serializable{
	private int roomid;
	private String roomdescription;
	private long reservationdate;
	private long checkindate;
	private long checkoutdate;
	private int guests;
	private int status;
	private double total;
	private String email;
	private String comments;
	private String confirmationcode;
	private boolean updateDB; //si es true then insert bean into the database. Otherwise es un bean con una reservacion ya hecha, no need to update
	private Calendar date;
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
	public String getComments() {
		return comments;
	}

	/**
	 * @return
	 */
	public String getConfirmationcode() {
		return confirmationcode;
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
	public int getGuests() {
		return guests;
	}

	/**
	 * @return
	 */
	public long getReservationdate() {
		return reservationdate;
	}

	/**
	 * @return
	 */
	public int getRoomid() {
		return roomid;
	}

	/**
	 * @return
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @return
	 */
	public boolean isUpdateDB() {
		return updateDB;
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
	 * @param string
	 */
	public void setComments(String string) {
		comments = string;
	}

	/**
	 * @param string
	 */
	public void setConfirmationcode(String string) {
		confirmationcode = string;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param i
	 */
	public void setGuests(int i) {
		guests = i;
	}

	/**
	 * @param l
	 */
	public void setReservationdate(long l) {
		reservationdate = l;
	}

	/**
	 * @param i
	 */
	public void setRoomid(int i) {
		roomid = i;
	}

	/**
	 * @param d
	 */
	public void setTotal(double d) {
		total = d;
	}

	/**
	 * @param b
	 */
	public void setUpdateDB(boolean b) {
		updateDB = b;
	}

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
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param calendar
	 */
	public void setDate(Calendar calendar) {
		date = calendar;
	}

	/**
	 * @return
	 */
	public String getRoomdescription() {
		return roomdescription;
	}

	/**
	 * @param string
	 */
	public void setRoomdescription(String string) {
		roomdescription = string;
	}

}
