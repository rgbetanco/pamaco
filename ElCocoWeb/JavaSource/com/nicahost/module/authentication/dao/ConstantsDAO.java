
package com.nicahost.module.authentication.dao;

/**
 * @author henry
 * Version 1.0 Sep 12, 2006
 *
 * playaelcoco.com.ni
 */
public class ConstantsDAO {
//	================= DATABASE KEY
	public static final String DBASEKEY = "dsHotel";
	
//	================= AUTHENTICATION
	public static final String AUTHENTICATE = 
				"select userid, password from users where userid = ?"; 		

	public static final String PROFILE_SELECT = 
				"select u.userid, u.name, u.password, u.status, u.email, u.groupid, p.permid, p.permission, p.opid" +
				"  from users u, usergroups ug, grouppermissions gp, permissions p" +
				"  where u.groupid = ug.groupid and ug.groupid = gp.groupid and gp.permid = p.permid and gp.opid = p.opid";

	public static final String PROFILE_FILTERED_BY_USERID = " and u.userid = ? ";
	
	public static final String PROFILE_FILTERED_BY_STATUS = " and u.status <> ? ";
	
//	================= GENERAL CONSTANTS	
	public static final String USER_UPDATE_PASSWORD =
				"UPDATE users SET status = ?, password = ? WHERE userid = ?";

//	================= GENERAL CONSTANTS
	 public static final String STATUS_DISABLED = "0";
	 public static final String STATUS_ENABLED = "1";
	 public static final String STATUS_NEWPASSWORD = "3";				
	
	/**
	 * 
	 *
	 */
	private ConstantsDAO() {/* empty constructor */}
}
