package com.nicahost.module.hotelreserve.admin.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author henry
 * Version 1.0 Oct 6, 2006
 *
 * playaelcoco.com.ni
 */
public class QueryForm extends ValidatorForm {
	private String checkIn;
	private String checkOut;
	private String status;
	
	
	
	/**
	 * @return
	 */
	public String getCheckIn() {
		return checkIn;
	}

	/**
	 * @return
	 */
	public String getCheckOut() {
		return checkOut;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param string
	 */
	public void setCheckIn(String string) {
		checkIn = string;
	}

	/**
	 * @param string
	 */
	public void setCheckOut(String string) {
		checkOut = string;
	}

	/**
	 * @param string
	 */
	public void setStatus(String string) {
		status = string;
	}

}
