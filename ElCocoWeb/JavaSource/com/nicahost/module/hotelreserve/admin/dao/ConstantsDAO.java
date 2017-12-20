package com.nicahost.module.hotelreserve.admin.dao;

/**
 * @author Henry
 * version 1.1 Sep 3, 2006
 * 
 * playaelcoco.com.ni
 */
public class ConstantsDAO {
//	================ CREATE USERGROUP
  public static final String GROUP_INSERT = 
				"insert into usergroups (groupname, description) values (?,?)";
	
	public static final String GROUP_UPDATE = 
				"update usergroups set groupname = ?, description = ? where groupid = ?";
				
//	================ READ USERGROUP
	public static final String GROUP_SELECT_ALL =
				"select groupid, groupname, description from usergroups ";				


//  ================ READ OPTIONS PERMISSIONS
	public static final String OPTIONS_PERMISSIONS = 
				"select o.opid, o.description, p.permid, p.permission from options o, permissions p where o.opid = p.opid";

//	================ READ USERGROUP PERMISSIONS
	public static final String GROUP_SELECT_PERMISSIONS = 
				"select ug.groupid, ug.groupname, ug.description, gp.permid, gp.opid " +				"from usergroups ug, grouppermissions gp " +				"where ug.groupid = gp.groupid";
	
	public static final String GROUP_PERMISSION_FILTERED_BY_GROUPID =
				" and ug.groupid = ?"; 
				
//	================ CREATE USERGROUP PERMISSION
	public static final String GROUP_INSERT_PERMISSION = 
				"insert into grouppermissions (groupid, opid, permid) values (?,?,?)";
  //			,(?,?)....

//	================ DELETE USERGROP PERMISSION
	public static final String GROUP_DELETE_PERMISSION = 
				"delete from grouppermissions where groupid = ? and permid = ? and opid = ? "; 

	public static final String GROUP_DELETE_PERMISSIONS = 
				"delete from grouppermissions where groupid = ?"; 
  //			(?,?,...)


//	================ CREATE USER
	public static final String USER_INSERT = 
				"insert into users (userid, name, password, status, email, groupid) values (?,?,?,?,?,?)";

//	================ READ USERS
	public static final String USER_SELECT_ALL = 
				//"select u.userid, u.name, u.password, u.status, u.email, u.groupid from users u";
				"select u.userid, u.name, u.password, u.status, u.email, u.groupid, ug.groupname from users u  left join usergroups ug on u.groupid = ug.groupid";
	
	public static final String USER_FILTERED_BY_GROUPID = 
				" where ug.groupid = ?";
				
		



//	================ UPDATE USER
	public static final String USER_UPDATE = 
				"update users set name = ?, status = ?, email = ?, groupid = ? " +
				" where userid = ?";
	




//	================= RESERVATIONS	 
	public static final String RESERVATION_PENDING =
	"SELECT a.id, a.roomid, r.briefdescription, a.email, a.reservationDate, min(a.checkinDate), max(a.checkoutdate), a.guest, a.status, sum(a.total), b.firstName, b.lastName, a.comment, a.confirmationcode, a.planno" +	" FROM roomreservation a, clientes b, rooms r" +	" WHERE a.email = b.email and a.status = 2  and r.roomid = a.roomid" +	" group by confirmationcode, roomid" +	" ORDER BY a.reservationDate desc";	 

	public static final String UPDATERESERVATION_SQL =
		"UPDATE roomreservation SET status=?, statusdate = ?, approver=? WHERE confirmationcode=? and roomid=?";
		
	public static final String QUERY_RESERVATION = 
		"SELECT a.id, a.roomid, r.briefdescription, a.email, a.reservationDate, min(a.checkinDate), max(a.checkoutdate), a.guest, a.status, sum(a.total), b.firstName, b.lastName, a.comment, a.confirmationcode, a.planno, a.statusdate, a.approver, a.reference, rs.description " +		"FROM roomreservation a, clientes b, rooms r, reservestatus rs " +		"WHERE a.email = b.email  and r.roomid = a.roomid and rs.status = a.status ";	
	public static final String QUERY_RESERVATION_FILTERED_BY_DATE =	"and a.checkindate >= ? and a.checkoutdate <= ? ";	
	public static final String QUERY_RESERVATION_FILTERED_BY_STATUS = "and a.status = ? ";	public static final String QUERY_RESERVATION_GROUPED_BY = "group by confirmationcode, roomid ";

//  ================= Statistics 
	public static final String DELETE_ROOMRESERVATION_SQL = "DELETE FROM roomreservation WHERE roomid = ? AND (checkindate >= ? AND checkoutdate <= ?)";
	public static final String SELECT_RESTATISTICAL = "SELECT a.briefdescription, c.email, b.FirstName, b.LastName, COUNT(a.briefdescription) as nights, SUM(c.total) as total FROM rooms a, clientes b, roomreservation c WHERE c.roomid = a.roomid AND c.email = b.email " +
	"AND (checkindate >= ? AND checkindate <=?) GROUP BY a.briefdescription, c.email";
	public static final String SELECT_RESTATISTICAL01 = "SELECT a.briefdescription, c.email, b.FirstName, b.LastName, COUNT(a.briefdescription) as nights, SUM(c.total) as total FROM rooms a, clientes b, roomreservation c WHERE c.roomid = a.roomid AND c.email = b.email " +
	"AND (checkindate >= ? AND checkindate <=?) AND a.briefdescription = ? GROUP BY a.briefdescription, c.email";
	public static final String SELECT_RESTATISTICAL02 = "SELECT a.briefdescription, c.email, b.FirstName, b.LastName, COUNT(a.briefdescription) as nights, SUM(c.total) as total FROM rooms a, clientes b, roomreservation c WHERE c.roomid = a.roomid AND c.email = b.email " +
	"AND (checkindate >= ? AND checkindate <=?) AND b.FirstName = ? AND b.LastName = ? GROUP BY a.briefdescription, c.email";
	public static final String SELECT_RESTATISTICAL03 = "SELECT a.briefdescription, c.email, b.FirstName, b.LastName, COUNT(a.briefdescription) as nights, SUM(c.total) as total FROM rooms a, clientes b, roomreservation c WHERE c.roomid = a.roomid AND c.email = b.email " +
	"AND (checkindate >= ? AND checkindate <=?) AND a.briefdescription = ? AND b.FirstName = ? AND b.LastName = ? GROUP BY a.briefdescription, c.email";
	public static final String SELECT_CLIENTS = "SELECT firstName, lastName, email FROM clientes";
	 
	public static final String INSERT_ROOMRESERVATION_SQL =
			"insert into roomreservation (roomid,reservationdate,checkindate,checkoutdate,guest,status,total,email,comment,confirmationcode) "
				+ " values(?,?,?,?,?,?,?,?,?,?)";
	 
	public static final String ROOMSBYTYPE_SQL = "SELECT roomid FROM rooms WHERE blocked in('0')";

	public static final String ROOMDESCRIPTION_SQL = "SELECT briefdescription from rooms where roomid = ? and blocked in('0')";
	 
	 private ConstantsDAO() {
	 }
}
