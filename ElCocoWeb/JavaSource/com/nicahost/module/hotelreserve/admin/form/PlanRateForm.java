/*
 * Created on Sep 2, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author k
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PlanRateForm extends ValidatorForm {
	private String planNo;
	private String name;
	private String price;
	private String additional;
	private String minNights;
	private String iniDate;
	private String endDate;
	private String active;
	private String maxGuests;
	
	
	/**
	 * @return
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @return
	 */
	public String getAdditional() {
		return additional;
	}

	/**
	 * @return
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @return
	 */
	public String getIniDate() {
		return iniDate;
	}

	/**
	 * @return
	 */
	public String getMaxGuests() {
		return maxGuests;
	}

	/**
	 * @return
	 */
	public String getMinNights() {
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
	public String getPrice() {
		return price;
	}

	/**
	 * @param string
	 */
	public void setActive(String string) {
		active = string;
	}

	/**
	 * @param string
	 */
	public void setAdditional(String string) {
		additional = string;
	}

	/**
	 * @param string
	 */
	public void setEndDate(String string) {
		endDate = string;
	}

	/**
	 * @param string
	 */
	public void setIniDate(String string) {
		iniDate = string;
	}

	/**
	 * @param string
	 */
	public void setMaxGuests(String string) {
		maxGuests = string;
	}

	/**
	 * @param string
	 */
	public void setMinNights(String string) {
		minNights = string;
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
	 * @param string
	 */
	public void setPrice(String string) {
		price = string;
	}

}
