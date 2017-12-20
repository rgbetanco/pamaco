package com.nicahost.module.hotelreserve.dao;

/**
 * @author Henry
 * version 1.1 Sep 13, 2006
 * 
 * playaelcoco.com.ni
 */
public class ConstantsDAO {
	
	public static final String ROOM_AVAILABILITY = 
	"SELECT a.roomid, a.roomtype, a.briefdescription, a.blocked "
		+ "FROM rooms a "
		+ "WHERE roomid = ? AND blocked = '0' AND roomid NOT IN "
		+ "(SELECT b.roomid FROM roomreservation b WHERE  a.roomid = b.roomid AND b.status = 1 "
		+ "AND (((checkindate - ? <0) OR (checkindate - ? <0)) AND "
		+ "((?-checkoutdate<0) OR (? - checkoutdate <0)) )) ";

	public static final String ROOMTYPE_AVAILABILITY =
		"SELECT a.roomid, a.roomtype, a.briefdescription, a.blocked, count(a.roomid) as rooms "
			+ "FROM rooms a "
			+ "WHERE roomtype = ? AND blocked = '0' AND roomid NOT IN "
			+ "(SELECT b.roomid FROM roomreservation b WHERE  a.roomid = b.roomid AND b.status = 1 "
			+ "AND (((checkindate - ? <0) OR (checkindate - ? <0)) AND "
			+ "((?-checkoutdate<0) OR (? - checkoutdate <0)) )) " +				"group by roomtype";

}
