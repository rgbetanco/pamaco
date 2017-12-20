
package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Henry
 * version 1.1 Sep 3, 2006
 * 
 * playaelcoco.com.ni
 */
public class RoomBean implements Serializable, Comparable {
	private String roomId;	
	private String roomTypeId;
	private String description;	
	private String blocked;
	private int maxRooms;
	private ArrayList roomPlans;
	
	public RoomBean() {
		roomPlans = new ArrayList();
		maxRooms = 1;
	}
	
	public RoomBean(String roomId, String description, String blocked) {
		this();
		this.roomId = roomId;
		this.description = description;
		this.blocked = blocked;
	}
	
	public RoomBean(String roomId, String roomTypeId, String description, String blocked) {
		this(roomId, description, blocked);
		this.roomTypeId = roomTypeId;
		
	}
	
	public RoomBean(String roomId, String roomTypeId, String description, String blocked, String hits) {
		this(roomId, roomTypeId, description, blocked);
		this.maxRooms = Integer.parseInt(hits); 
	}
	
	public RoomBean(String roomId, String description) {
		this();
		this.roomId = roomId;
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		int res = 0;
		try {
			RoomBean bean = (RoomBean) arg0;
			res = this.description.compareTo(bean.getDescription());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	
	public void addPlanRate(PlanRateBean bean) {
		roomPlans.add(bean);
	}
	
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
	public ArrayList getRoomPlans() {
		return roomPlans;
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
	 * @param list
	 */
	public void setRoomPlans(ArrayList list) {
		roomPlans = list;
	}

	/**
	 * @return
	 */
	public String getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * @param string
	 */
	public void setRoomTypeId(String string) {
		roomTypeId = string;
	}

	/**
	 * @return
	 */
	public int getMaxRooms() {
		return maxRooms;
	}

	/**
	 * @param string
	 */
	public void setMaxRooms(String string) {
		maxRooms = Integer.parseInt(string);
	}
	
	public void setMaxRooms(int i) {
		maxRooms = i;
	}

}
