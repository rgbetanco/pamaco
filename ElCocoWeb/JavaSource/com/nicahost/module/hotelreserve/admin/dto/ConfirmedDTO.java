/*
 * Created on Jul 7, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.dto;

import java.io.Serializable;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ConfirmedDTO implements Serializable {
	private int id;
	private String code;
	private String roomId;
	
	public ConfirmedDTO()
	{
		this.id =0;
	}
	
	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param string
	 */
	public void setCode(String string) {
		code = string;
	}

	/**
	 * @return
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * @param string
	 */
	public void setRoomId(String string) {
		roomId = string;
	}

}
