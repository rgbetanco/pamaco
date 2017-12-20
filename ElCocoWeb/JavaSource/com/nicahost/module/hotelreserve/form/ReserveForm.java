/*
 * Created on Jul 9, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.form;

import java.util.Calendar;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorActionForm;

/**
 * 
 * @author Henry
 * version 1.1 Sep 6, 2006
 * 
 * playaelcoco.com.ni
 */
public class ReserveForm extends ValidatorActionForm {
	//inician variables para la seleccion de rooms 
	private String[] selectedIdRooms= new String[20];
	private String initDate;
	private String endDate;
	private String roomTypeId;
	private String roomTypeName;
	private String roomId;
	private String roomName;
	private String adult;
	//private String child = "1";
	//inician variables para el Guest Info 
	private Calendar initDateCal;
	private Calendar endDateCal;
	private Collection selectedRooms;
	private String firstName;
	private String lastName;
	private String address;
	private String ethnicity;
	private String country;
	private String city;
	private String zip;
	private String phone;
	private String email1;
	private String email2;	
	//inician varibales par el input de tarjeta 
	private String paymentMethod;
	private String cardType;
	private String cardNumber;
	private String cardMonth;
	private String cardYear;
	private String cardHolder;
	private String policyCancelation;
	
	private String comment;



	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return
	 */
	public String getEmail1() {
		return email1;
	}

	/**
	 * @return
	 */
	public String getEmail2() {
		return email2;
	}

	/**
	 * @return
	 */
	public String getEthnicity() {
		return ethnicity;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param string
	 */
	public void setAddress(String string) {
		address = string;
	}

	/**
	 * @param string
	 */
	public void setCity(String string) {
		city = string;
	}

	/**
	 * @param string
	 */
	public void setCountry(String string) {
		country = string;
	}

	/**
	 * @param string
	 */
	public void setEmail1(String string) {
		email1 = string;
	}

	/**
	 * @param string
	 */
	public void setEmail2(String string) {
		email2 = string;
	}

	/**
	 * @param string
	 */
	public void setEthnicity(String string) {
		ethnicity = string;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param string
	 */
	public void setPhone(String string) {
		phone = string;
	}

	/**
	 * @param string
	 */
	public void setZip(String string) {
		zip = string;
	}


	/**
	 * @return
	 */
	public Calendar getEndDateCal() {
		return endDateCal;
	}

	/**
	 * @return
	 */
	public Calendar getInitDateCal() {
		return initDateCal;
	}

	/**
	 * @return
	 */
	public String getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * @param calendar
	 */
	public void setEndDateCal(Calendar calendar) {
		endDateCal = calendar;
	}

	/**
	 * @param calendar
	 */
	public void setInitDateCal(Calendar calendar) {
		initDateCal = calendar;
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
	public Collection getSelectedRooms() {
		return selectedRooms;
	}

	/**
	 * @param collection
	 */
	public void setSelectedRooms(Collection collection) {
		selectedRooms = collection;
	}

	/**
	 * @return
	 */
	public String getCardHolder() {
		return cardHolder;
	}

	/**
	 * @return
	 */
	public String getCardMonth() {
		return cardMonth;
	}

	/**
	 * @return
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @return
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @return
	 */
	public String getCardYear() {
		return cardYear;
	}

	/**
	 * @return
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @return
	 */
	public String getPolicyCancelation() {
		return policyCancelation;
	}

	/**
	 * @param string
	 */
	public void setCardHolder(String string) {
		cardHolder = string;
	}

	/**
	 * @param string
	 */
	public void setCardMonth(String string) {
		cardMonth = string;
	}

	/**
	 * @param string
	 */
	public void setCardNumber(String string) {
		cardNumber = string;
	}

	/**
	 * @param string
	 */
	public void setCardType(String string) {
		cardType = string;
	}

	/**
	 * @param string
	 */
	public void setCardYear(String string) {
		cardYear = string;
	}

	/**
	 * @param string
	 */
	public void setPaymentMethod(String string) {
		paymentMethod = string;
	}

	/**
	 * @param string
	 */
	public void setPolicyCancelation(String string) {
		policyCancelation = string;
	}

	/**
	 * @return
	 */
	public String[] getSelectedIdRooms() {
		return selectedIdRooms;
	}

	/**
	 * @param strings
	 */
	public void setSelectedIdRooms(String[] strings) {
		selectedIdRooms = strings;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		//super.reset(mapping, request);
		//selectedIdRooms = new String[2];
		
	}

	/**
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param string
	 */
	public void setComment(String string) {
		comment = string;
	}


	/**
	 * @return
	 */
	public String getAdult() {
		return adult;
	}

	/**
	 * @param string
	 */
	public void setAdult(String string) {
		adult = string;
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
	public String getInitDate() {
		return initDate;
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
	public void setInitDate(String string) {
		initDate = string;
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
	public void setRoomTypeName(String string) {
		roomTypeName = string;
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


}
