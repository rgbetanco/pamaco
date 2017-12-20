
package com.nicahost.module.hotelreserve.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.nicahost.common.dao.DBBaseDAO;
import com.nicahost.common.util.UtilCrypto;
import com.nicahost.module.authentication.bean.PermInfoBean;
import com.nicahost.module.authentication.bean.UserBean;
import com.nicahost.module.hotelreserve.admin.dto.AnnulledDTO;
import com.nicahost.module.hotelreserve.admin.dto.ConfirmedDTO;
import com.nicahost.module.hotelreserve.admin.dto.Restatistics;
import com.nicahost.module.hotelreserve.admin.dto.RoomsTableDTO;
import com.nicahost.module.hotelreserve.bean.ClienteInfo;
import com.nicahost.module.hotelreserve.bean.DateTakenBean;
import com.nicahost.module.hotelreserve.bean.OptionBean;
import com.nicahost.module.hotelreserve.bean.PlanRateBean;
import com.nicahost.module.hotelreserve.bean.RoomBean;
import com.nicahost.module.hotelreserve.bean.RoomReservePendingBean;
import com.nicahost.module.hotelreserve.bean.RoomReserveQueryBean;
import com.nicahost.module.hotelreserve.bean.RoomTypeBean;
import com.nicahost.module.hotelreserve.bean.Rooms;
import com.nicahost.module.hotelreserve.bean.UserGroupBean;
import com.nicahost.module.hotelreserve.common.Constants;
import com.nicahost.module.hotelreserve.dto.Reserve01DTO;
import com.nicahost.module.hotelreserve.view.HistoryView;
import com.nicahost.module.hotelreserve.view.ReservationView;
import com.nicahost.module.hotelreserve.view.RoomView;

/**
 * 
 * @author Henry
 * version 1.1 Sep 3, 2006
 * 
 * playaelcoco.com.ni
 */
public class HotelAdminDAO extends DBBaseDAO {
	
	static Logger log = Logger.getLogger(HotelAdminDAO.class);

	private static final String DBASEKEY = "dsHotel";
	private static final String RESERVATIONPERITEM_SQL =
		"SELECT * FROM roomreservation WHERE id = ?";
	private static final String RESERVATION_SQL =
		//	  1			2		3			4					5			6
	"SELECT a.id, a.roomid, a.email, a.reservationDate, a.checkinDate, a.checkoutdate, "
		//			7		8		 9		   10		   11			12	  
	+"a.guest, a.status, a.total, b.firstName, b.lastName, a.comment FROM roomreservation a, clientes b WHERE a.email = b.email and a.status = 2 ORDER BY a.reservationDate desc";
	private static final String CONFIRMEDANULLED_SQL =
		//	  1			2		3			4					5			6
	"SELECT a.id, a.roomid, a.email, a.reservationDate, a.checkinDate, a.checkoutdate, "
		//			7		8		 9		   10		   11			12	  
	+"a.guest, a.status, a.total, b.firstName, b.lastName, a.comment FROM roomreservation a, clientes b "+
	"WHERE a.email = b.email and a.status <> 0 and a.checkindate >= ? and a.checkoutdate <= ? ORDER BY a.checkindate ASC";
	private static final String COPYTOHISTORY_SQL =
		"INSERT INTO roomreservationhist (id, roomid, reservationDate, checkindate, checkoutdate, guest, status, total, email, comment, confirmationcode, statusdate, approver, planno) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETERESERVATION_SQL =
		"DELETE FROM roomreservation WHERE id=?";
	private static final String HISTORY1_SQL = "SELECT * FROM roomreservation WHERE checkoutdate < ? ORDER BY checkoutdate";
	private static final String HISTORY2_SQL = "SELECT * FROM roomreservation WHERE id = ? ORDER BY checkoutdate ASC";
	private static final String HISTORY_SQL =
		//		  1			2		3			4				5					6		   
	"SELECT a.id, a.roomid, a.email, a.reservationDate, a.checkinDate, a.checkoutdate, "
		//     7		8		  9			10			11		   12	
	+"a.guest, a.status, a.total, b.firstname, b.lastname, a.comment FROM roomreservationhist a, clientes b WHERE a.email = b.email";
	private static final String LOGIN_SQL =
		"SELECT * FROM administrator WHERE login=? and password=?";

	private static final String UPDATEROOM_SQL =
		"UPDATE rooms SET roomid =?, roomType =?, maxpeople=?, briefdescription=?, pricepernight=?, blocked = ? WHERE roomid =?";
	
	private static final String INSERTROOM_SQL =
		"INSERT INTO rooms VALUES(?,?,?,?,?,?)";
	private static final String ROOMS_SQL = "SELECT * FROM rooms";

	private static final String SELECT_RESTATISTICAL = "SELECT a.briefdescription, c.email, b.FirstName, b.LastName, COUNT(a.briefdescription) as nights, SUM(c.total) as total FROM rooms a, clientes b, roomreservation c WHERE c.roomid = a.roomid AND c.email = b.email " +
	"AND (checkindate >= ? AND checkindate <=?) GROUP BY a.briefdescription, c.email";
	private static final String SELECT_RESTATISTICAL01 = "SELECT a.briefdescription, c.email, b.FirstName, b.LastName, COUNT(a.briefdescription) as nights, SUM(c.total) as total FROM rooms a, clientes b, roomreservation c WHERE c.roomid = a.roomid AND c.email = b.email " +
	"AND (checkindate >= ? AND checkindate <=?) AND a.roomid = ? GROUP BY a.briefdescription, c.email";
	private static final String SELECT_RESTATISTICAL02 = "SELECT a.briefdescription, c.email, b.FirstName, b.LastName, COUNT(a.briefdescription) as nights, SUM(c.total) as total FROM rooms a, clientes b, roomreservation c WHERE c.roomid = a.roomid AND c.email = b.email " +
	"AND (checkindate >= ? AND checkindate <=?) AND c.email = ? GROUP BY a.briefdescription, c.email";
	private static final String SELECT_RESTATISTICAL03 = "SELECT a.briefdescription, c.email, b.FirstName, b.LastName, COUNT(a.briefdescription) as nights, SUM(c.total) as total FROM rooms a, clientes b, roomreservation c WHERE c.roomid = a.roomid AND c.email = b.email " +
	"AND (checkindate >= ? AND checkindate <=?) AND a.roomid = ? AND c.email = ? GROUP BY a.briefdescription, c.email";
	private static final String SELECT_RESERVATIONS_ONHOLD = "SELECT reservationid, duedate FROM reservationsonhold WHERE duedate < ?";
	

	public Collection copyResOnHoldToHist() {
		Collection col = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		Calendar cal = Calendar.getInstance();
		long l = cal.getTime().getTime();
		try {
			con = getPooledConnection(DBASEKEY);
			ps = con.prepareStatement(SELECT_RESERVATIONS_ONHOLD);
			ps.setLong(1, l);
			rs = ps.executeQuery();
			while (rs.next()){
				col.add(new Integer(rs.getInt(1)));
			}
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return col;
	}
	
	public void copyResToHist(){
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		Calendar cal = Calendar.getInstance();
		long l = cal.getTime().getTime();
		
		try{
			con = getPooledConnection(DBASEKEY);
			ps = con.prepareStatement(HISTORY1_SQL);
			ps1 = con.prepareStatement(COPYTOHISTORY_SQL);
			ps2 = con.prepareStatement(DELETERESERVATION_SQL);
			ps.setLong(1, l);
			rs = ps.executeQuery();
			while (rs.next()){
				ps1.setInt(1, rs.getInt(1));
				ps1.setInt(2, rs.getInt(2));
				ps1.setLong(3, rs.getLong(3));
				ps1.setLong(4, rs.getLong(4));
				ps1.setLong(5, rs.getLong(5));
				ps1.setInt(6, rs.getInt(6));
				ps1.setInt(7, rs.getInt(7));
				ps1.setDouble(8, rs.getDouble(8));
				ps1.setString(9, rs.getString(9));
				ps1.setString(10, rs.getString(10));
				ps1.setString(11, rs.getString(11));
				ps1.setString(12, rs.getString(12));
				ps1.setString(13, rs.getString(13));
				ps1.setInt(14, rs.getInt(14));
				ps1.execute();
				ps2.setInt(1, rs.getInt(1));
				ps2.execute();
			}
			closeConnection(rs, ps, con);
			
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
	public void copyResToHist1(int resId){
			Connection con = null;
			PreparedStatement ps = null;
			PreparedStatement ps1 = null;
			PreparedStatement ps2 = null;
			ResultSet rs = null;

			try{
				con = getPooledConnection(DBASEKEY);
				ps = con.prepareStatement(HISTORY2_SQL);
				ps1 = con.prepareStatement(COPYTOHISTORY_SQL);
				ps2 = con.prepareStatement(DELETERESERVATION_SQL);
				ps.setLong(1, resId);
				rs = ps.executeQuery();
				while (rs.next()){
					ps1.setInt(1, rs.getInt(1));
					ps1.setInt(2, rs.getInt(2));
					ps1.setLong(3, rs.getLong(3));
					ps1.setLong(4, rs.getLong(4));
					ps1.setLong(5, rs.getLong(5));
					ps1.setInt(6, rs.getInt(6));
					ps1.setInt(7, rs.getInt(7));
					ps1.setDouble(8, rs.getDouble(8));
					ps1.setString(9, rs.getString(9));
					ps1.setString(10, rs.getString(10));
					ps1.setString(11, rs.getString(11));
					ps1.setString(12, rs.getString(12));
					ps1.setString(13, rs.getString(13));
					ps1.setInt(14, rs.getInt(14));
					ps1.execute();
					ps2.setInt(1, resId);
					ps2.execute();
				}
				closeConnection(rs, ps, con);
			
			} catch (SQLException ex){
				ex.printStackTrace();
			}
		
		}
	
	public Collection getStatistics(long iniDate, long endDate, String habitacion, String cliente){
		
		String Todo = "Todos";
		Collection col = new ArrayList();
		try {
			if (habitacion.equals(Todo) && cliente.equals(Todo)){
			Connection conn = getPooledConnection(DBASEKEY);
			PreparedStatement ps = conn.prepareStatement(SELECT_RESTATISTICAL);
			ps.setLong(1, iniDate);
			ps.setLong(2, endDate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Restatistics res = new Restatistics();
				res.setRoomdescription(rs.getString(1));
				res.setEmail(rs.getString(2));
				res.setFirstname(rs.getString(3));
				res.setLastname(rs.getString(4)); 
				res.setNonights(rs.getInt(5));
				res.setTotal(rs.getDouble(6));
				col.add(res);
				}
				closeConnection(rs, ps, conn);
			}
            
			if (!habitacion.equals(Todo) && cliente.equals(Todo)){
				Connection conn = getPooledConnection(DBASEKEY);
				PreparedStatement ps = conn.prepareStatement(SELECT_RESTATISTICAL01);
				ps.setLong(1, iniDate);
				ps.setLong(2, endDate);
				ps.setInt(3, Integer.parseInt(habitacion));
				ResultSet rs = ps.executeQuery();
				while (rs.next()){
					Restatistics res = new Restatistics();
					res.setRoomdescription(rs.getString(1));
					res.setEmail(rs.getString(2));
					res.setFirstname(rs.getString(3));
					res.setLastname(rs.getString(4));
					res.setNonights(rs.getInt(5));
					res.setTotal(rs.getDouble(6));
					col.add(res);
				}
				closeConnection(rs, ps, conn);
                
			} 
			if (habitacion.equals(Todo) && !cliente.equals(Todo)){
				//int index = cliente.indexOf(",");
				//String firstName = cliente.substring(0, index);
				//String lastName = cliente.substring(index+1);
					Connection conn = getPooledConnection(DBASEKEY);
					PreparedStatement ps = conn.prepareStatement(SELECT_RESTATISTICAL02);
					ps.setLong(1, iniDate);
					ps.setLong(2, endDate);
					ps.setString(3, cliente);
					//ps.setString(4, lastName);
					ResultSet rs = ps.executeQuery();
					while (rs.next()){
						Restatistics res = new Restatistics();
						res.setRoomdescription(rs.getString(1));
						res.setEmail(rs.getString(2));
						res.setFirstname(rs.getString(3));
						res.setLastname(rs.getString(4));
						res.setNonights(rs.getInt(5));
						res.setTotal(rs.getDouble(6));
						col.add(res);
					}
					closeConnection(rs, ps, conn);
			}
                
				if (!habitacion.equals(Todo) && !cliente.equals(Todo)){
					//int index = cliente.indexOf(",");
					//String firstName = cliente.substring(0, index);
					//String lastName = cliente.substring(index+1);
						Connection conn = getPooledConnection(DBASEKEY);
						PreparedStatement ps = conn.prepareStatement(SELECT_RESTATISTICAL03);
						ps.setLong(1, iniDate);
						ps.setLong(2, endDate);
						ps.setInt(3, Integer.parseInt(habitacion));
						ps.setString(4, cliente);
						//ps.setString(5, lastName);
						ResultSet rs = ps.executeQuery();
						while (rs.next()){
							Restatistics res = new Restatistics();
							res.setRoomdescription(rs.getString(1));
							res.setEmail(rs.getString(2));
							res.setFirstname(rs.getString(3));
							res.setLastname(rs.getString(4));
							res.setNonights(rs.getInt(5));
							res.setTotal(rs.getDouble(6));
							col.add(res);
						}
						closeConnection(rs, ps, conn);
				}
                
			} catch (Exception ex){
				ex.printStackTrace();
			}
            
		return col;
	}

	
	
	public Collection getUsers() throws SQLException {		
		ArrayList result = new ArrayList();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		UserBean bean = null;
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.USER_SELECT_ALL);
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setUserId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setStatus(rs.getString(4));
				bean.setEmail(rs.getString(5));
				bean.setGroupId(rs.getString(6));
				bean.setGroupName(rs.getString(7));
				
				result.add(bean);	
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}
	
	public Collection getUsersForGroup(String groupId) throws SQLException {		
		ArrayList result = new ArrayList();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		UserBean bean = null;
		
		try {
			StringBuffer sql = new StringBuffer(ConstantsDAO.USER_SELECT_ALL);
			sql.append(ConstantsDAO.USER_FILTERED_BY_GROUPID);
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1,groupId);
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setUserId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setStatus(rs.getString(4));
				bean.setEmail(rs.getString(5));
				bean.setGroupId(rs.getString(6));
				bean.setGroupName(rs.getString(7));
				
				result.add(bean);	
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}

	public boolean insertUser(UserBean bean) throws SQLException {		
		boolean result = false;

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int res = -1;		
		try {
			String pwdencrypted = UtilCrypto.encrypt(bean.getPassword());
						
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.USER_INSERT);
			ps.setString(1,bean.getUserId());
			ps.setString(2,bean.getName());
			ps.setString(3,pwdencrypted);
			ps.setString(4,bean.getStatus());
			ps.setString(5,bean.getEmail());
			ps.setString(6,bean.getGroupId());
			
			res = ps.executeUpdate();
			
			result = res > 0 ? true:false;
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}


	/**
	 * Este metodo no actualiza la contrasenha del usuario.  Utilizar changePwd o updatePwd. HJ
	 * 
	 * @param bean
	 * @return
	 * @throws SQLException
	 * @throws InvalidLoginException
	 */
	public boolean updateUser(UserBean bean) throws SQLException {
		boolean result = false;
		int res = -1;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
						
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.USER_UPDATE);
									
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getStatus());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getGroupId());
			ps.setString(5, bean.getUserId());

			res = ps.executeUpdate();
			
			result = res > 0 ? true:false;
				
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return result;
	}	
	
	public Collection getUserGroups() throws SQLException {		
		ArrayList result = new ArrayList();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		UserGroupBean bean = null;
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.GROUP_SELECT_ALL);
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new UserGroupBean(rs.getString(1), rs.getString(2), rs.getString(3));
				result.add(bean);	
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}
	
	public boolean insertUserGroup(UserGroupBean bean)
		throws SQLException
	{
		boolean result = false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int res = -1;
		try
		{
			
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.GROUP_INSERT);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getDescription());
			res = ps.executeUpdate();
			result = res > 0;
		}
		finally
		{
			closeConnection(rs, ps, conn);
		}
		return result;
	}

	public boolean updateUserGroup(UserGroupBean bean)
		throws SQLException
	{
		boolean result = false;
		int res = -1;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try
		{
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.GROUP_UPDATE);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getDescription());
			ps.setString(3, bean.getGroupId());
			res = ps.executeUpdate();
			result = res > 0;
		}
		finally
		{
			closeConnection(rs, ps, conn);
		}
		return result;
	}

	public Collection getOptionPermissions() throws SQLException {
		HashMap uBeanTemp = new HashMap();		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try
		{
			StringBuffer sql = new StringBuffer(ConstantsDAO.OPTIONS_PERMISSIONS);

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql.toString());
			
			rs = ps.executeQuery();
			
			OptionBean oBean;
			String permid;
			String permission;
			
			for (;rs.next();) {
				String optionId = rs.getString(1);
				String desc = rs.getString(2);
				permid = rs.getString(3);
				permission = rs.getString(4);
				if (!uBeanTemp.containsKey(optionId)) {
					oBean = new OptionBean(optionId,desc);					
					uBeanTemp.put(optionId,oBean);	
				} else {
					oBean = (OptionBean) uBeanTemp.get(optionId);
				}
				
				oBean.addPermission(permid,permission,optionId);
			}			
			
			
		} finally
		{
			closeConnection(rs, ps, conn);
		}
		
		
		return uBeanTemp.values();
					
	}
	

	public UserGroupBean getGroupPermissions(String groupId) throws SQLException {
		HashMap uBeanTemp = new HashMap();
		UserGroupBean oBean = new UserGroupBean();		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try
		{
			StringBuffer sql = new StringBuffer(ConstantsDAO.GROUP_SELECT_PERMISSIONS);
			sql.append(ConstantsDAO.GROUP_PERMISSION_FILTERED_BY_GROUPID);

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1,groupId);
			rs = ps.executeQuery();
			String grpId, groupName, desc, permid, opid;
			
			for (;rs.next();) {
				grpId = rs.getString(1);
				groupName = rs.getString(2);
				desc = rs.getString(3);
				permid = rs.getString(4);
				opid = rs.getString(5);
				
				if (!uBeanTemp.containsKey(grpId)) {
					oBean = new UserGroupBean(grpId,groupName,desc);					
					uBeanTemp.put(grpId,oBean);	
				} else {
					oBean = (UserGroupBean) uBeanTemp.get(grpId);
				}
				
				oBean.addPermission(permid,opid);
			}						
			
		} finally
		{
			closeConnection(rs, ps, conn);
		}
		
		
		return oBean;
					
	}	
	
	
	public boolean updateGroupPermissions(UserGroupBean bean)
		throws SQLException
	{
		boolean result = false;
		int res = -1;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		StringBuffer sql = null;
		try
		{
			deleteGroupPermissions(bean.getGroupId());
			
			if (bean.getPermissions().size() <= 0) {
				return true;
			}
			
			conn = getPooledConnection(DBASEKEY);
			sql = new StringBuffer(ConstantsDAO.GROUP_INSERT_PERMISSION);
			for(int i=1; i<bean.getPermissions().size();i++) {
				sql.append(",").append("(").append("?,?,?").append(")");					
			}			
			ps = conn.prepareStatement(sql.toString());			

			PermInfoBean element;
			int i = 1;
			for (Iterator iter = bean.getPermissions().iterator(); iter.hasNext();) {				
				element = (PermInfoBean) iter.next();
				ps.setString(i++,bean.getGroupId());
				ps.setString(i++,element.getOptionId());
				ps.setString(i++,element.getPermId());	
			}
			
			res = ps.executeUpdate();
			result = res > 0;
		}
		finally
		{
			closeConnection(rs, ps, conn);
		}
		return result;
	}	
	
	private int deleteGroupPermissions(String gid) {
		int res = -1;
		StringBuffer sql;
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try { 			
			conn = getPooledConnection(DBASEKEY);
			sql = new StringBuffer(ConstantsDAO.GROUP_DELETE_PERMISSIONS);
			ps = conn.prepareStatement(sql.toString());			
			ps.setString(1,gid);						
			
			res = ps.executeUpdate();
		} catch (SQLException sqlex) {
			log.error(sqlex.getMessage());	
		
		} finally {
			try {
				closeConnection(rs, ps, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return res;
	}	
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Collection getRoomTypes() throws SQLException {		
		ArrayList result = new ArrayList();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		RoomTypeBean bean = null;
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement("SELECT id, description FROM roomtypes");
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new RoomTypeBean(rs.getString(1), rs.getString(2));
				result.add(bean);	
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}

	public Collection getRooms(String roomTypeId) throws SQLException {		
		ArrayList result = new ArrayList();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		RoomBean bean = null;
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement("SELECT roomid, briefdescription, blocked FROM rooms where roomtype = ?");
			ps.setString(1,roomTypeId);
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new RoomBean(rs.getString(1), rs.getString(2), rs.getString(3));
				result.add(bean);	
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}		
	
	public Collection getPlanRatesForRoom(String roomId) throws SQLException {		
		ArrayList result = new ArrayList();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		PlanRateBean bean = null;
		
		try {
			String sql = "SELECT pr.planno, pr.name, pr.price, pr.additional, pr.minnights, pr.fromdate, pr.todate, pr.active, pr.maxguests " +						 "FROM planrates pr, roomplans rp " +						 "WHERE rp.planno = pr.planno " +						 "AND rp.roomid = ?";
			
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,roomId);
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new PlanRateBean();
				bean.setPlanNo(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setPrice(rs.getBigDecimal(3));
				bean.setAdditional(rs.getBigDecimal(4));
				bean.setMinNights(rs.getInt(5));
				bean.setIniDate(rs.getLong(6));
				bean.setEndDate(rs.getLong(7));
				bean.setActive(rs.getBoolean(8));
				bean.setMaxGuests(rs.getInt(9));
				
				result.add(bean);	
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}		


	public Collection getPlanRates() throws SQLException {		
			ArrayList result = new ArrayList();

			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
			PlanRateBean bean = null;
		
			try {
				String sql = "SELECT pr.planno, pr.name, pr.price, pr.additional, pr.minnights, pr.fromdate, pr.todate, pr.active, pr.maxguests " +
							 "FROM planrates pr ";
			
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();

				while (rs.next()) {
					bean = new PlanRateBean();
					bean.setPlanNo(rs.getString(1));
					bean.setName(rs.getString(2));
					bean.setPrice(rs.getBigDecimal(3));
					bean.setAdditional(rs.getBigDecimal(4));
					bean.setMinNights(rs.getInt(5));
					bean.setIniDate(rs.getLong(6));
					bean.setEndDate(rs.getLong(7));
					bean.setActive(rs.getBoolean(8));
					bean.setMaxGuests(rs.getInt(9));
				
					result.add(bean);	
				}
			
			} finally {
				closeConnection(rs, ps, conn);
			}

			return result;
		}


	public PlanRateBean getPlanRate(String planNo) throws SQLException {		
			
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
			PlanRateBean bean = new PlanRateBean();
		
			try {
				String sql = "SELECT pr.planno, pr.name, pr.price, pr.additional, pr.minnights, pr.fromdate, pr.todate, pr.active, pr.maxguests " +
							 "FROM planrates pr " +							 "WHERE pr.planno = ?";
			
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(sql);
				ps.setString(1,planNo);
				
				rs = ps.executeQuery();

				if (rs.next()) {					
					bean.setPlanNo(rs.getString(1));
					bean.setName(rs.getString(2));
					bean.setPrice(rs.getBigDecimal(3));
					bean.setAdditional(rs.getBigDecimal(4));
					bean.setMinNights(rs.getInt(5));
					bean.setIniDate(rs.getLong(6));
					bean.setEndDate(rs.getLong(7));
					bean.setActive(rs.getBoolean(8));
					bean.setMaxGuests(rs.getInt(9));
				}
			
			} finally {
				closeConnection(rs, ps, conn);
			}

			return bean;
		}

	public boolean insertRoomType(String description) throws SQLException {		

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;		
		int res = -1;
		boolean result = false;
			
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement("insert into roomtypes (description) values (?)");
			ps.setString(1,description);
			res = ps.executeUpdate();
			result = res > 0 ? true:false;		
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}


	public boolean updateRoomType(String roomTypeId, String description) throws SQLException {		

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;		
		int res = -1;
		boolean result = false;
			
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement("update roomtypes set description = ? where id = ?");
			ps.setString(1,description);
			ps.setString(2,roomTypeId);
			res = ps.executeUpdate();
			result = res > 0 ? true:false;		
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}
	

	public boolean insertRoom(RoomBean bean, String planNo) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;		
		int res = -1;
		boolean result = false;
			
		try {
			long fecha = getCurrentDate();
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement("insert into rooms (roomtype, briefdescription, blocked, creationdate) values(?,?,?,?)");
			String blocked = null;
			if (null == bean.getBlocked() || "".equals(bean.getBlocked())) {
				blocked = "0";
			} else {
				blocked = "1";
			}			
			ps.setString(1,bean.getRoomTypeId());
			ps.setString(2,bean.getDescription());
			ps.setString(3,blocked);
			ps.setLong(4,fecha);
			
			res = ps.executeUpdate();
			
			closeConnection(rs,ps,conn);
			
			String pid = null;
			
			if (res > 0) {
				pid = getRoomId(fecha);
				insertPlanForRoom(pid,planNo);			
				result = true;	
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
		
	}
	
	public boolean updateRoom(RoomBean bean) throws SQLException {		

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;		
		int res = -1;
		boolean result = false;
			
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement("update rooms set roomtype = ?, briefdescription = ?, blocked = ? where roomid = ?");
			String blocked = null;
			if (null == bean.getBlocked() || "".equals(bean.getBlocked())) {
				blocked = "0";
			} else {
				blocked = "1";
			}
			
			ps.setString(1, bean.getRoomTypeId());
			ps.setString(2, bean.getDescription());
			ps.setString(3, blocked);
			ps.setString(4, bean.getRoomId());
			
			res = ps.executeUpdate();
			result = res > 0 ? true:false;		
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}
	
	public boolean insertPlanForRoom(String roomId, String planNo) throws SQLException {
		boolean result = false;
		int res = -1;
		StringBuffer sql;
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try { 			
			conn = getPooledConnection(DBASEKEY);
			sql = new StringBuffer("insert into roomplans values (?,?)");
			ps = conn.prepareStatement(sql.toString());			
			ps.setString(1,roomId);
			ps.setString(2,planNo);						
			
			res = ps.executeUpdate();
			result = res > 0 ? true:false;
			
		} catch (SQLException sqlex) {
			log.error(sqlex.getMessage());		
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return result;		
	}

	public boolean deletePlanForRoom(String roomId, String planNo) throws SQLException {
		boolean result = false;
		int res = -1;
		StringBuffer sql;
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try { 			
			conn = getPooledConnection(DBASEKEY);
			sql = new StringBuffer("delete from roomplans where roomid = ? and planno = ?");
			ps = conn.prepareStatement(sql.toString());			
			ps.setString(1,roomId);
			ps.setString(2,planNo);						
			
			res = ps.executeUpdate();
			result = res > 0 ? true:false;
			
		} catch (SQLException sqlex) {
			log.error(sqlex.getMessage());		
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return result;		
	}

	public boolean insertPlanRate(PlanRateBean bean) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;		
		int res = -1;
		boolean result = false;
			
		try {			
			String sql = "insert into planrates (name, price, additional, minnights, fromdate, todate, active, maxguests) values(?,?,?,?,?,?,?,?)";
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,bean.getName());
			ps.setBigDecimal(2,bean.getPrice());
			ps.setBigDecimal(3,bean.getAdditional());
			ps.setInt(4,bean.getMinNights());
			ps.setLong(5,bean.getIniDate().getTime().getTime());
			ps.setLong(6,bean.getEndDate().getTime().getTime());
			ps.setBoolean(7,bean.isActive());
			ps.setInt(8,bean.getMaxGuests());
			res = ps.executeUpdate();
			
			closeConnection(rs,ps,conn);

			result = res > 0 ? true:false;			
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
		
	}


	public Collection getPendingReservations() throws Exception {
		ArrayList result = new ArrayList();

		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			RoomReservePendingBean bean;
			con = getPooledConnection(DBASEKEY);
			stm = con.prepareStatement(ConstantsDAO.RESERVATION_PENDING);
			rs = stm.executeQuery();

			while (rs.next()) {
				bean = new RoomReservePendingBean();
				bean.setReserveId(rs.getString(1));
				bean.setRoomId(rs.getString(2));
				bean.setRoomName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setReserveDate(rs.getLong(5));
				bean.setIniDate(rs.getLong(6));
				bean.setEndDate(rs.getLong(7));
				bean.setGuests(rs.getInt(8));
				bean.setSubTotal(rs.getBigDecimal(10));
				bean.setFirstName(rs.getString(11));
				bean.setLastName(rs.getString(12));
				bean.setComments(rs.getString(13));
				bean.setCode(rs.getString(14));

				result.add(bean);
			}

		} finally {
			closeConnection(rs, stm, con);
		}
		return result;
	}



	public ArrayList queryReservations(HashMap params) throws Exception {
		ArrayList result = new ArrayList();
		
		String status = null;
		Calendar iniDate = null;
		Calendar endDate = null;
		boolean bStatus = false, bDate = false;
		StringBuffer sql;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			RoomReserveQueryBean bean;
			sql = new StringBuffer(ConstantsDAO.QUERY_RESERVATION);
			con = getPooledConnection(DBASEKEY);			
			
			
			status = (String) params.get(Constants.FILTERED_BY_STATUS);
			iniDate = (Calendar) params.get(Constants.FILTERED_BY_INIDATE);
			endDate = (Calendar) params.get(Constants.FILTERED_BY_ENDDATE);
			
			if (null != iniDate && null != endDate) {
				sql.append(ConstantsDAO.QUERY_RESERVATION_FILTERED_BY_DATE);
				bDate = true;
			}

			if (null != status && !"".equals(status.trim())) {
				sql.append(ConstantsDAO.QUERY_RESERVATION_FILTERED_BY_STATUS);
				bStatus = true;
			}
			
			sql.append(ConstantsDAO.QUERY_RESERVATION_GROUPED_BY);
			
			ps = con.prepareStatement(sql.toString());
			
			if (bDate && bStatus) {
				ps.setLong(1,iniDate.getTime().getTime());
				ps.setLong(2,endDate.getTime().getTime());
				ps.setString(3,status);
			}
			
			if (bDate && !bStatus) {
				ps.setLong(1,iniDate.getTime().getTime());
				ps.setLong(2,endDate.getTime().getTime());				
			}

			if (!bDate && bStatus) {
				ps.setString(1,status);				
			}			
		
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new RoomReserveQueryBean();
				bean.setReserveId(rs.getString(1));
				bean.setRoomId(rs.getString(2));
				bean.setRoomName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setReserveDate(rs.getLong(5));
				bean.setIniDate(rs.getLong(6));
				bean.setEndDate(rs.getLong(7));
				bean.setGuests(rs.getInt(8));
				bean.setStatus(rs.getString(9));
				bean.setSubTotal(rs.getBigDecimal(10));
				bean.setFirstName(rs.getString(11));
				bean.setLastName(rs.getString(12));
				bean.setComments(rs.getString(13));
				bean.setCode(rs.getString(14));
				
				bean.setApproverDate(rs.getString(16));
				bean.setApprover(rs.getString(17));
				bean.setReference(rs.getString(18));
				bean.setStatusName(rs.getString(19));

				result.add(bean);
			}

		} finally {
			closeConnection(rs, ps, con);
		}
		return result;
	}


	/**
	 * @param confirmedParm
	 * @param annulledDTO
	 * @throws Exception
	 * Este metodo debe de actualizar la informacion de la tabla de reservaciones 
	 * cambia es status de 2 a 1 siendo 1 == confirmado, 2==null, 0==anulado
	 */
	public void updateConfirmations(ArrayList confirmedParm, String userParm) throws Exception {

		Connection con0 = null;
		SimpleDateFormat sf = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT);
		Date today = new Date();
		con0 = getPooledConnection(DBASEKEY);

		PreparedStatement ps0 = con0.prepareStatement(ConstantsDAO.UPDATERESERVATION_SQL);

		for (Iterator iter = confirmedParm.iterator(); iter.hasNext();) {
			ConfirmedDTO element = (ConfirmedDTO) iter.next();
			ps0.setString(1, Constants.STATUS_APPROVED);
			ps0.setString(2, sf.format(today));
			ps0.setString(3, userParm);
			
			ps0.setString(4, element.getCode());
			ps0.setString(5,element.getRoomId());
			//Create the PDF file with the note to send by email
			CreatePDFConfirmNote createNote =
				new CreatePDFConfirmNote(element.getId());
			createNote.CreateFile();

			ps0.executeUpdate();

		}
		closeConnection(ps0, con0);
	}

	public void updateAnnullment(ArrayList annulledParm, String userParm) throws Exception {

		Connection con0 = null;
		SimpleDateFormat sf = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT);
		Date today = new Date();
		con0 = getPooledConnection(DBASEKEY);

		PreparedStatement ps0 = con0.prepareStatement(ConstantsDAO.UPDATERESERVATION_SQL);

		for (Iterator iter = annulledParm.iterator(); iter.hasNext();) {
			AnnulledDTO element = (AnnulledDTO) iter.next();

			ps0.setString(1, Constants.STATUS_DENIED_BY_ADMIN);
			ps0.setString(2, sf.format(today));
			ps0.setString(3, userParm);
			ps0.setString(4, element.getCode());
			ps0.setString(5,element.getRoomId());
			//Create the PDF file with the note to send by email
			CreatePDFAnulledNote createNoteAnulled = new CreatePDFAnulledNote(element.getId());
			createNoteAnulled.CreateFile();

			ps0.executeUpdate();

		}

		closeConnection(ps0, con0);

	}

	private String getRoomId(long creationddate) throws SQLException {
		String res = "-1";
		StringBuffer sql;
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try { 			
			conn = getPooledConnection(DBASEKEY);
			sql = new StringBuffer("select roomid from rooms where creationdate = ?");
			ps = conn.prepareStatement(sql.toString());
			ps.setLong(1,creationddate);		
			rs = ps.executeQuery();
			
			if (rs.next()) 
				res = rs.getString(1);
		
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
	}


	/**
	 * 
	 * @return
	 */
	private long getCurrentDate() {
		long result = System.currentTimeMillis();
		
		return result;
	}













	

	public Collection getRooms() throws Exception {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			con = getPooledConnection(DBASEKEY);
			ps = con.prepareStatement(ROOMS_SQL);
			rs = ps.executeQuery();

			ArrayList rooms = new ArrayList();
			while (rs.next()) {
				RoomView roomsV = new RoomView();
				roomsV.setId(rs.getString(1));
				roomsV.setRoomType(Integer.toString(rs.getInt(2)));
				roomsV.setMaxPeople(rs.getString(3));
				roomsV.setDescription(rs.getString(4));
				roomsV.setPrice(rs.getString(5));
				roomsV.setBlocked(rs.getString(6));
				rooms.add(roomsV);
			}
	

			closeConnection(rs, ps, con);

		return rooms;
	}

	public void insertRoomsTable(RoomsTableDTO roomsTableDTO)
		throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		con = getPooledConnection(DBASEKEY);
		ps = con.prepareStatement(INSERTROOM_SQL);

		ps.setInt(1, roomsTableDTO.getRoomId());
		ps.setInt(2, roomsTableDTO.getRoomType());
		ps.setInt(3, roomsTableDTO.getMaxPeople());
		ps.setString(4, roomsTableDTO.getDescription());
		ps.setDouble(5, roomsTableDTO.getPrice());
		ps.setString(6, roomsTableDTO.getBlocked());

		ps.execute();
		
		closeConnection(ps, con);

	}

	public void updateRoomsTable(ArrayList roomsParm) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;

		con = getPooledConnection(DBASEKEY);
		ps = con.prepareStatement(UPDATEROOM_SQL);

		for (Iterator iter = roomsParm.iterator(); iter.hasNext();) {
			RoomsTableDTO roomsTableDTO = new RoomsTableDTO();
			roomsTableDTO = (RoomsTableDTO) iter.next();
			ps.setInt(1, roomsTableDTO.getRoomId());
			ps.setInt(2, roomsTableDTO.getRoomType());
			ps.setInt(3, roomsTableDTO.getMaxPeople());
			ps.setString(4, roomsTableDTO.getDescription());
			ps.setDouble(5, roomsTableDTO.getPrice());
			ps.setString(6, roomsTableDTO.getBlocked());
			ps.setInt(7, roomsTableDTO.getRoomId());

			ps.execute();
		}
		closeConnection(ps, con);
	}
	

	public boolean grantDenyAccess(String loginParm, String passParm)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = getPooledConnection(DBASEKEY);
		ps = con.prepareStatement(LOGIN_SQL);
		ps.setString(1, loginParm);
		ps.setString(2, passParm);

		rs = ps.executeQuery();
		int counter = 0;
		while (rs.next()) {
			counter += 1;
		}
		if (counter > 0) {
			closeConnection(rs, ps, con);
			return true;
		} else {
			closeConnection(rs, ps, con);
			return false;
		}
	}

	public Collection getRoomReservations() throws Exception {
		ArrayList result = new ArrayList();

		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			con = getPooledConnection(DBASEKEY);
			stm = con.prepareStatement(RESERVATION_SQL);
			rs = stm.executeQuery();

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			while (rs.next()) {
				ReservationView reserveView = new ReservationView();
				reserveView.setId(rs.getString(1));
				reserveView.setRoomNumV(rs.getString(2));
				reserveView.setEmailV(rs.getString(3));
				reserveView.setReservationDateV(
					df.format(new Date(rs.getLong(4))));
				reserveView.setCheckinDateV(df.format(new Date(rs.getLong(5))));
				reserveView.setCheckoutDateV(
					df.format(new Date(rs.getLong(6))));
				reserveView.setGuestV(rs.getString(7));
				reserveView.setStatusV(rs.getString(8));
				reserveView.setTotalV(rs.getString(9));
				reserveView.setFirstNameV(rs.getString(10));
				reserveView.setLastNameV(rs.getString(11));
				reserveView.setCommentV(rs.getString(12));
				result.add(reserveView);
			}

		} finally {
			closeConnection(rs, stm, con);
		}
		return result;
	}
	
	public Collection getConfirmedAnulled(long initDate, long finDate) throws Exception {
			ArrayList result = new ArrayList();

			Connection con = null;
			PreparedStatement stm = null;
			ResultSet rs = null;

			try {
				con = getPooledConnection(DBASEKEY);
				stm = con.prepareStatement(CONFIRMEDANULLED_SQL);
				stm.setLong(1, initDate);
				stm.setLong(2, finDate);
				
				rs = stm.executeQuery();

				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

				while (rs.next()) {
					ReservationView reserveView = new ReservationView();
					reserveView.setId(rs.getString(1));
					reserveView.setRoomNumV(rs.getString(2));
					reserveView.setEmailV(rs.getString(3));
					reserveView.setReservationDateV(
						df.format(new Date(rs.getLong(4))));
					reserveView.setCheckinDateV(df.format(new Date(rs.getLong(5))));
					reserveView.setCheckoutDateV(
						df.format(new Date(rs.getLong(6))));
					reserveView.setGuestV(rs.getString(7));
					reserveView.setStatusV(rs.getString(8));
					reserveView.setTotalV(rs.getString(9));
					reserveView.setFirstNameV(rs.getString(10));
					reserveView.setLastNameV(rs.getString(11));
					reserveView.setCommentV(rs.getString(12));
					result.add(reserveView);
				}

			} finally {
				closeConnection(rs, stm, con);
			}
			return result;
		}


	public Collection getHistory() throws Exception {
		ArrayList result = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {
			con = getPooledConnection(DBASEKEY);
			ps = con.prepareStatement(HISTORY_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				HistoryView historyView = new HistoryView();
				historyView.setId(rs.getString(1));
				historyView.setRoomNumV(rs.getString(2));
				historyView.setEmailV(rs.getString(3));
				historyView.setReservationDateV(
					df.format(new Date(rs.getLong(4))));
				historyView.setCheckinDateV(df.format(new Date(rs.getLong(5))));
				historyView.setCheckoutDateV(
					df.format(new Date(rs.getLong(6))));
				historyView.setGuestV(rs.getString(7));
				historyView.setStatusV(rs.getString(8));
				historyView.setTotalV(rs.getString(9));
				historyView.setFirstNameV(rs.getString(10));
				historyView.setLastNameV(rs.getString(11));
				historyView.setCommentV(rs.getString(12));
				result.add(historyView);
			}
		} finally {
			closeConnection(rs, ps, con);
		}

		return result;
	}


// =======================================================================

	public void insertAdminReservation(Collection dto) throws SQLException {
		Connection conn = null;
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		PreparedStatement ps = null;
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.INSERT_ROOMRESERVATION_SQL);
		
		for (Iterator iter = dto.iterator(); iter.hasNext();) {
			Reserve01DTO element = (Reserve01DTO) iter.next();
			try {
				ps.setInt(1, element.getRoomid());
				ps.setLong(2, cal.getTime().getTime());
				ps.setLong(3, element.getCheckindate());
				ps.setLong(4, element.getCheckoutdate());
				ps.setInt(5, 1);
				ps.setInt(6, 4);
				ps.setDouble(7, 0);
				ps.setString(8, "rgbetanco@hotmail.com");
				ps.setString(9, "null");
				ps.setString(10, "code");
				ps.execute();
			} catch (SQLException ex){
				ex.printStackTrace();
			}
			
		}
		
		} finally {
			closeConnection(ps,conn);
		}		
	}
	
	public void deleteAdminReservation(Collection dto) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.DELETE_ROOMRESERVATION_SQL);


		
		for (Iterator iter = dto.iterator(); iter.hasNext();) {
			 Reserve01DTO element = (Reserve01DTO) iter.next();
			 try {
				ps.setInt(1, element.getRoomid());
				ps.setLong(2, element.getCheckindate());
				ps.setLong(3, element.getCheckoutdate());
				ps.execute();
			 } catch (SQLException ex){
				ex.printStackTrace();
			 }
		}
		
		} finally {
			closeConnection(null,ps,conn);
		}		
	}
	
	public ArrayList getRoomsCalendar()throws Exception{
			//Collection col = getRooomDescription(roomType);
			ArrayList rooms = new ArrayList();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
		
			try{	
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(ConstantsDAO.ROOMSBYTYPE_SQL);
				//ps.setInt(1, roomType);
				rs = ps.executeQuery();
				int i = 0;
			
				while(rs.next()){
					rooms.add(Integer.toString(rs.getInt(1)));
					i++;
				}
			} catch(Exception ex){
				ex.printStackTrace();
			} finally {
				closeConnection(rs, ps, conn);
			}
			return rooms;
		}		

	public Collection getDatesTakenForRoom(int roomId, long iniDate, long endDate) throws Exception {
			ArrayList l = new ArrayList();
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
			long ini, end;		
			long aDay = 60*60*24*1000;
		
			try {
				String sql = "SELECT checkindate, checkoutdate, status " +
							 "FROM roomreservation b " +
							 "WHERE  b.roomid = ? and b.status in (1,2,3,4) " +
							 "and (checkindate >= ? and checkindate <= ?)";
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(sql);
			
				ps.setInt(1, roomId);
				ps.setLong(2, iniDate);
				ps.setLong(3, endDate);

				rs = ps.executeQuery();
			
				while (rs.next()) {
					ini = rs.getLong(1);
					end = rs.getLong(2);
					//for(long i=ini;i<=end;i += aDay) {
						DateTakenBean bean = new DateTakenBean();
						Calendar gc = Calendar.getInstance();
						gc.setTime(new Date(ini));
						bean.setCal(gc.getTime().getTime());
						bean.setStatus(rs.getInt(3));
						l.add(bean);
					//}
				}
			
			} finally {
				closeConnection(rs,ps,conn);
			}
		
		
			return l;
		}

	public String getRoomDescription(int roomid)throws Exception{
			String description = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(ConstantsDAO.ROOMDESCRIPTION_SQL);
				ps.setInt(1, roomid);
				rs = ps.executeQuery();
				while (rs.next()){
					description = rs.getString(1);
				}
			} catch (Exception ex){
				ex.printStackTrace();
			} finally {
				closeConnection(rs, ps, conn);
			}
			return description;
		}

	public Collection getClientes() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		Collection clientes = new ArrayList();
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.SELECT_CLIENTS);
			rs = ps.executeQuery();
			while (rs.next()){
				ClienteInfo info = new ClienteInfo();
				info.setName(rs.getString(1));
				info.setLastName(rs.getString(2));
				info.setEmail(rs.getString(3));
				clientes.add(info);
			}
		} finally {
			closeConnection(rs,ps,conn);
		}
		return clientes;
	}
	
	public Collection getRoomsDescription() throws SQLException {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Collection rooms = new ArrayList();
	try {
		conn = getPooledConnection(DBASEKEY);
		ps = conn.prepareStatement(ROOMS_SQL);
		rs = ps.executeQuery();
		while (rs.next()){
			Rooms info = new Rooms();
			info.setRoomid(rs.getInt(1));
			info.setBriefdescription(rs.getString(4));
			rooms.add(info);
		}
	} finally {
		closeConnection(rs,ps,conn);
	}
	return rooms;
}


}
