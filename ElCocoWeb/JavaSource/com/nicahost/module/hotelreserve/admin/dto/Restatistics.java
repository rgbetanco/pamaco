/*
 * Created on Oct 4, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.dto;

/**
 * @author Ronald
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.io.Serializable;

public class Restatistics implements Serializable {
	private String roomdescription;
	private String email;
	private String firstname;
	private String lastname;
	private int nonights;
	private double total;
    
	public Restatistics() {
	}

	public void setRoomdescription(String roomdescription) {
		this.roomdescription = roomdescription;
	}

	public String getRoomdescription() {
		return roomdescription;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setNonights(int nonights) {
		this.nonights = nonights;
	}

	public int getNonights() {
		return nonights;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}
}
