/*
 * Created on Sep 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoomForm extends ValidatorForm {
	private String roomTypeId;
	private String roomTypeName;
	private String roomId;
	private String description;
	private String blocked;
	private String planNo;
	private String newRoomTypeId;
	
	
	/**
	 * @return
	 */
	public String getBlocked() {
		return blocked;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * @return
	 */
	public String getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * @return
	 */
	public String getRoomTypeName() {
		return roomTypeName;
	}

	/**
	 * @param string
	 */
	public void setBlocked(String string) {
		blocked = string;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param string
	 */
	public void setRoomId(String string) {
		roomId = string;
	}

	/**
	 * @param string
	 */
	public void setRoomTypeId(String string) {
		roomTypeId = string;
	}

	/**
	 * @param string
	 */
	public void setRoomTypeName(String string) {
		roomTypeName = string;
	}

	/**
	 * @return
	 */
	public String getPlanNo() {
		return planNo;
	}

	/**
	 * @param string
	 */
	public void setPlanNo(String string) {
		planNo = string;
	}

	/**
	 * @return
	 */
	public String getNewRoomTypeId() {
		return newRoomTypeId;
	}

	/**
	 * @param string
	 */
	public void setNewRoomTypeId(String string) {
		newRoomTypeId = string;
	}

}
