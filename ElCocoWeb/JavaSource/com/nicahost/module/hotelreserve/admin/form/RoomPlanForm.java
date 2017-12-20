/*
 * Created on Sep 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.form;

import java.util.ArrayList;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoomPlanForm extends ValidatorForm {
	private String roomTypeId;
	private String roomTypeName;
	private String roomId;
	private String roomName;
	private String newRoomPlan;
	private ArrayList plans;
	
	/**
	 * @return
	 */
	public ArrayList getPlans() {
		return plans;
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
	public String getRoomName() {
		return roomName;
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
	 * @param list
	 */
	public void setPlans(ArrayList list) {
		plans = list;
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
	public void setRoomName(String string) {
		roomName = string;
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
	public String getNewRoomPlan() {
		return newRoomPlan;
	}

	/**
	 * @param string
	 */
	public void setNewRoomPlan(String string) {
		newRoomPlan = string;
	}

}
