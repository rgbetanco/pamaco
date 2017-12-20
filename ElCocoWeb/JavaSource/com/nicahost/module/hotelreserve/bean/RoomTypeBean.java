package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Henry
 * version 1.1 Sep 15, 2006
 * 
 * playaelcoco.com.ni
 */
public class RoomTypeBean implements Serializable, Comparable {
	private String roomTypeId;
	private String description;
	private ArrayList rooms;
	
	public RoomTypeBean() {
		rooms = new ArrayList();
	}
	
	public RoomTypeBean(String roomTypeId, String desc) {
		this();
		this.roomTypeId = roomTypeId;
		this.description = desc;
	}
	
	public void addRoom(RoomBean bean) {
		rooms.add(bean);
	}
	
	public void addRoom(String roomId, String description) {
		rooms.add(new RoomBean(roomId, description));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		int res = 0;
		try {
			RoomTypeBean bean = (RoomTypeBean) arg0;
			res = this.description.compareTo(bean.getDescription());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
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
	public ArrayList getRooms() {
		return rooms;
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
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param list
	 */
	public void setRooms(ArrayList list) {
		rooms = list;
	}

	/**
	 * @param string
	 */
	public void setRoomTypeId(String string) {
		roomTypeId = string;
	}

}
