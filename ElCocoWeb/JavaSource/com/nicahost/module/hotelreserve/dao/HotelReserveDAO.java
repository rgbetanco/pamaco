/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.nicahost.common.dao.DBBaseDAO;
import com.nicahost.common.util.UniqueIdentifierGenerator;
import com.nicahost.module.hotelreserve.bean.PlanRateBean;
import com.nicahost.module.hotelreserve.bean.RoomBean;
import com.nicahost.module.hotelreserve.dbase.wrapper.ClientInsertWrapper;
import com.nicahost.module.hotelreserve.dbase.wrapper.RoomReservationWrapper;
import com.nicahost.module.hotelreserve.dto.ClientDTO;
import com.nicahost.module.hotelreserve.dto.RoomDTO;
import com.nicahost.module.hotelreserve.dto.RoomReservationDTO;
import com.nicahost.module.hotelreserve.dto.Step01DTO;
import com.nicahost.module.hotelreserve.view.GalleryView;
import com.nicahost.module.hotelreserve.view.PlacedReservationView;
import com.nicahost.module.hotelreserve.view.ReservationView;
import com.nicahost.module.hotelreserve.view.ReservedRoomView;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HotelReserveDAO extends DBBaseDAO {

	static Logger log = Logger.getLogger(HotelReserveDAO.class);

	//private static final int DBASEVENDOR = DriversUtils.MSACCESS; //El identificador del vendor para una conexion
	private static final String DBASEKEY = "dsHotel";
	//El identificador para una conexion con pool

	private static final String ROOMAVAILABILITY_SQL =
		//		1			2			3			  4				5				6				  7				8				9
	"SELECT a.roomid, a.roomtype, a.maxpeople, a.briefdescription, a.pricepernight, b.checkindate, b.checkoutdate "
		+ "FROM rooms a, roomreservation b "
		+ "WHERE a.roomid = b.roomid AND a.roomtype = ? AND a.blocked = 'N' AND b.confirmed = 'Y' AND b.anulled = 'N'";

	private static final String ROOMFEATURES_SQL =
		"SELECT label from roomfeatures WHERE roomid = ?";
	private static final String PHOTOGALLERY_SQL =
		"SELECT * FROM gallery WHERE id = ?";

	private static final String RESERVATION_SQL =
		"SELECT a.roomnum, a.email, a.reservationdate, a.checkindate, a.checkoutdate, "
			+ "a.guest, a.confirmed, a.anulled, a.total, b.firstname, b.lastname FROM roomreservation a, clientes b WHERE a.email=b.email";

	private static final String ROOMAVAILABILITY_SQL2 =
		"SELECT a.roomid, a.roomtype, a.maxpeople, a.briefdescription, a.pricepernight, count(a.roomid) as maxrooms "
			+ "FROM rooms a "
			+ "WHERE roomtype = ? AND blocked = '0' AND roomid NOT IN "
			+ "(SELECT b.roomid FROM roomreservation b WHERE  a.roomid = b.roomid AND b.status = 1 "
			+ "AND (((checkindate - ? <0) OR (checkindate - ? <0)) AND "
			+ "((?-checkoutdate<0) OR (? - checkoutdate <0)) )) "
			+ "GROUP BY a.pricepernight " 
			+ "ORDER BY a.pricepernight desc";
			
	private static final String PLACEDRESERVATION_SQL =
		"SELECT a.email, a.firstname, a.lastname, b.id, b.roomid, b.reservationdate, b.checkindate, b.checkoutdate, b.status, c.briefdescription, b.guest, c.roomtype "
			+ "FROM clientes a INNER JOIN roomreservation b ON a.email = b.email AND a.email = ? AND b.confirmationcode = ? " 
			+ "INNER JOIN rooms c ON b.roomid = c.roomid";
	
	private static final String CANCELRESERVATION_SQL = 
		"UPDATE roomreservation set status=3, statusdate=?, approver=? " 
		+ " WHERE email=? AND confirmationcode=?"; 

	private static final String ROOMSBYTYPE_SQL = "SELECT roomid FROM rooms WHERE blocked in('0')";

	private static final String ROOMDESCRIPTION_SQL = "SELECT briefdescription from rooms where roomid = ? and blocked in('0')";
	
	public String getRoomDescription(int roomid)throws Exception{
		String description = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ROOMDESCRIPTION_SQL);
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
	
	public ArrayList getRooms()throws Exception{
		//Collection col = getRooomDescription(roomType);
		ArrayList rooms = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{	
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ROOMSBYTYPE_SQL);
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


		
	public boolean cancelReservation(String email, String code) throws SQLException {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		try {
			
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(CANCELRESERVATION_SQL);
			Date todays = new Date();
			ps.setString(1,df.format(todays));
			ps.setString(2,email);
			ps.setString(3,email);
			ps.setString(4,code);
			
			result = ps.executeUpdate()>0?true:false;
			
		} finally {
			closeConnection(ps,conn);
		}
		
		return result;
	}

	public boolean addClient(ClientDTO dto) throws SQLException {

		ClientInsertWrapper clientWrapper = new ClientInsertWrapper();
		boolean success = clientWrapper.execute(dto);

		return success;
	}

	/**
	 * @deprecated 
	 * @param rooms
	 * @return
	 * @throws SQLException
	 */
	public ArrayList reserveRooms(ArrayList rooms) throws SQLException {
		ArrayList resultList = new ArrayList();
		RoomReservationDTO dto;
		boolean isSuccess;

		String confirmationId = UniqueIdentifierGenerator.generateCode();

		for (Iterator iter = rooms.iterator(); iter.hasNext();) {
			ReservedRoomView view = new ReservedRoomView();
			dto = (RoomReservationDTO) iter.next();
			RoomReservationWrapper roomWrapper =
				new RoomReservationWrapper(dto);
			roomWrapper.setConfirmationCode(confirmationId);
			isSuccess = roomWrapper.execute();
			view.setRoomId(Integer.toString(dto.getRoomId()));
			view.setSubTotal(Double.toString(dto.getTotal()));
			view.setReserved(isSuccess);
			view.setConfirmationId(roomWrapper.getConfirmationCode());

			resultList.add(view);
		}

		return resultList;
	}
	
	/**
	 * 
	 * @param rooms
	 * @param confirmationId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList reserveRooms(ArrayList rooms, String confirmationId) throws SQLException {
		ArrayList resultList = new ArrayList();
		RoomReservationDTO dto;
		boolean isSuccess;

		for (Iterator iter = rooms.iterator(); iter.hasNext();) {
			ReservedRoomView view = new ReservedRoomView();
			dto = (RoomReservationDTO) iter.next();
			RoomReservationWrapper roomWrapper =
				new RoomReservationWrapper(dto);
			roomWrapper.setConfirmationCode(confirmationId);
			isSuccess = roomWrapper.execute();
			view.setRoomId(Integer.toString(dto.getRoomId()));
			view.setSubTotal(Double.toString(dto.getTotal()));
			view.setReserved(isSuccess);
			view.setConfirmationId(roomWrapper.getConfirmationCode());

			resultList.add(view);
		}

		return resultList;
	}




	public ArrayList getPlacedReservation(String email, String code) throws SQLException {
		ArrayList result = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(PLACEDRESERVATION_SQL);
			ps.setString(1,email);
			ps.setString(2,code);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				PlacedReservationView view = new PlacedReservationView();	
				view.setEmail(email);
				view.setFirstName(rs.getString(2));
				view.setLastName(rs.getString(3));
				view.setId(rs.getString(4));
				view.setRoomId(rs.getString(5));
				cal1.setTime(new Date(rs.getLong(6)));
				view.setReservationDate(cal1);
				cal2.setTime(new Date(rs.getLong(7)));
				view.setCheckInDate(cal2);
				cal3.setTime(new Date(rs.getLong(8)));
				view.setCheckOutDate(cal3);
				view.setStatus(rs.getString(9));
				view.setDescription(rs.getString(10));
				//view.setGuest(rs.getString(11));
				view.setRoomTypeId(rs.getString(12));
				
				result.add(view);
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return result;
	}
	
	public Collection getDatesTakenForRoom(int roomId, long iniDate, long endDate) throws Exception {
		ArrayList l = new ArrayList();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		long ini, end;		
		long aDay = 60*60*24*1000;
		
		try {
			String sql = "SELECT checkindate, checkoutdate  " +						 "FROM roomreservation b " +						 "WHERE  b.roomid = ? and b.status in (1,3,4) " +						 "and (((checkindate - ? <0) OR (checkindate - ? <0)) " +						 "and ((? - checkoutdate<0) OR (? - checkoutdate <0)) )";
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, roomId);
			ps.setLong(2, iniDate);
			ps.setLong(3, endDate);
			ps.setLong(4, iniDate);
			ps.setLong(5, endDate);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				ini = rs.getLong(1);
				end = rs.getLong(2);
				for(long i=ini;i<end;i += aDay) {
					Calendar gc = new GregorianCalendar();
					gc.setTime(new Date(i));
					l.add(gc);
				}
			}
			
		} finally {
			closeConnection(rs,ps,conn);
		}
		
		
		return l;
	}


	public ArrayList getPlanRatesForRoom(int roomId, long iniDate, long endDate) throws Exception {
		ArrayList l = new ArrayList();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		PlanRateBean bean;
		
		try {
			
			String sql = "SELECT a.planno, a.name, a.price, a.additional, a.minnights, a.fromdate, a.todate, a.active, a.maxguests " +						"FROM planrates a " +						"where a.planno in (select planno from roomplans where roomid = ?) " +						"and a.active in (1) " +						"and ( ( ( (fromdate - ? <=0 ) and (? - ? >= a.minnights * 86400000)) OR ((? - fromdate >= a.minnights * 86400000) and (fromdate > 0)) ) " +						"and   ( ((todate - ? >= a.minnights * 86400000) and (todate < 9999999999999)) OR ( (? - todate <= 0) and (? - ? >= a.minnights * 86400000)) ) )";			
									 
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, roomId);
			ps.setLong(2, iniDate);
			ps.setLong(3, endDate);
			ps.setLong(4, iniDate);
			ps.setLong(5, endDate);
			ps.setLong(6, iniDate);
			ps.setLong(7, endDate);
			ps.setLong(8, endDate);
			ps.setLong(9, iniDate);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				bean = new PlanRateBean();
				bean.setPlanNo(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setPrice(rs.getBigDecimal(3));
				bean.setAdditional(rs.getBigDecimal(4));
				bean.setMinNights(rs.getInt(5));
				Calendar gc1 = new GregorianCalendar();
				gc1.setTime(new Date(rs.getLong(6)));
				bean.setIniDate(gc1);
				Calendar gc2 = new GregorianCalendar();
				gc2.setTime(new Date(rs.getLong(7)));
				bean.setEndDate(gc2);
				bean.setActive(rs.getBoolean(8));
				bean.setMaxGuests(rs.getInt(9));
				
				l.add(bean);
			}
			
		} finally {
			closeConnection(rs,ps,conn);
		}
		
		
		return l;
	}



	public String getRoomName(String roomId) throws SQLException {		
		String result = null;

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			String sql = "select briefdescription from rooms where roomid = ?";
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,roomId);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getString(1);
			}

			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}
	
	public Collection getRoomsByType(String roomTypeId) throws SQLException {		
		ArrayList result = new ArrayList();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			RoomBean bean;
			String sql = "select roomid, briefdescription, blocked from rooms where roomtype = ?";
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
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

	public Map getAvailability(Step01DTO dtoParm) throws Exception {
		Map result = new Hashtable();

		Connection conn = null;
		Connection conn2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		long numIniParm = dtoParm.getDateTimeIn();
		long numFinParm = dtoParm.getDateTimeOut();

		try {

			conn = getPooledConnection(DBASEKEY);
			conn2 = getPooledConnection(DBASEKEY);

			ps = conn.prepareStatement(ROOMAVAILABILITY_SQL2);
			ps.setInt(1, dtoParm.getRoomType());
			ps.setLong(2, numIniParm);
			ps.setLong(3, numFinParm);
			ps.setLong(4, numIniParm);
			ps.setLong(5, numFinParm);

			rs = ps.executeQuery();

			ps2 = conn2.prepareStatement(ROOMFEATURES_SQL);
			int roomId;
			while (rs.next()) {
				RoomDTO dto = new RoomDTO();
				roomId = rs.getInt(1);
				dto.setId(roomId);
				dto.setRoomType(rs.getInt(2));
				dto.setMaxPeople(rs.getInt(3));
				dto.setDescription(rs.getString(4));
				dto.setPrice(rs.getDouble(5));
				dto.setMaxRooms(rs.getInt(6));

				//Obtiene las features
				ps2.setInt(1, roomId);

				rs2 = ps2.executeQuery();
				while (rs2.next()) {
					dto.addFeature(rs2.getString(1));
				}
				result.put(Long.toString(dto.getId()), dto);

				rs2 = null;
			} //end while

		} finally {
			closeConnection(rs, ps, conn);
			closeConnection(rs2, ps2, conn2);
		}

		return result;
	}
	
	
	/**
	 * Metodo para obtener los cuartos disponibles a partir del roomId
	 * 
	 * @param dtoParm
	 * @return
	 * @throws Exception
	 */	
	public RoomBean getRoomAvailability(Step01DTO dtoParm) throws Exception {
		RoomBean bean = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			
			long numIniParm = dtoParm.getDateTimeIn();
			long numFinParm = dtoParm.getDateTimeOut();

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.ROOM_AVAILABILITY);
						
			ps.setInt(1, dtoParm.getRoomType());
			ps.setLong(2, numIniParm);
			ps.setLong(3, numFinParm);
			ps.setLong(4, numIniParm);
			ps.setLong(5, numFinParm);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				bean = new RoomBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));				
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}
		return bean;
	}

	/**
	 * Metodo para obtener la disponibilidad de los cuartos por tipo
	 * 
	 * @param dtoParm
	 * @return
	 * @throws Exception
	 */
	public RoomBean getRoomTypeAvailability(Step01DTO dtoParm) throws Exception {
		RoomBean bean = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			
			long numIniParm = dtoParm.getDateTimeIn();
			long numFinParm = dtoParm.getDateTimeOut();

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.ROOMTYPE_AVAILABILITY);
						
			ps.setInt(1, dtoParm.getRoomType());
			ps.setLong(2, numIniParm);
			ps.setLong(3, numFinParm);
			ps.setLong(4, numIniParm);
			ps.setLong(5, numFinParm);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				bean = new RoomBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));				
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}
		return bean;
	}




	/**
	 * ejecutar el query que nos da las habitaciones que estan reservadas para despues 
	 * revisar cuales estan disponibles para reserva en la fecha y hora que el cliente define
	 * en el step 01
	 * @param dtoParm
	 * @return
	 */
	public Map getAvailability2(Step01DTO dtoParm) throws Exception {

		Map result = new Hashtable();

		Connection conn = null;
		Connection conn2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		long numIni;
		long numFin;
		long numIniParm = dtoParm.getDateTimeIn();
		long numFinParm = dtoParm.getDateTimeOut();

		try {

			conn = getPooledConnection(DBASEKEY);
			conn2 = getPooledConnection(DBASEKEY);

			ps = conn.prepareStatement(ROOMAVAILABILITY_SQL);
			ps.setInt(1, dtoParm.getRoomType());
			rs = ps.executeQuery();

			ps2 = conn2.prepareStatement(ROOMFEATURES_SQL);
			int roomId;
			while (rs.next()) {
				numIni = rs.getLong(6);
				numFin = rs.getLong(7);
				if (!((numIniParm > numIni
					&& numFinParm < numFin
					|| numIniParm == numIni
					&& numIniParm == numFin
					|| numFinParm >= numIni
					&& numFinParm <= numFin
					|| numIni >= numIniParm
					&& numIni <= numFinParm
					|| numFin >= numIniParm
					&& numFin <= numFinParm))) {
					RoomDTO dto = new RoomDTO();
					roomId = rs.getInt(1);
					dto.setId(roomId);
					dto.setRoomType(rs.getInt(2));
					dto.setMaxPeople(rs.getInt(3));
					dto.setDescription(rs.getString(4));
					dto.setPrice(rs.getDouble(5));

					//Obtiene las features
					ps2.setInt(1, roomId);

					rs2 = ps2.executeQuery();
					while (rs2.next()) {
						dto.addFeature(rs2.getString(1));
					}
					result.put(Long.toString(dto.getId()), dto);
				} //endif

				rs2 = null;
			} //end while

		} finally {
			closeConnection(rs, ps, conn);
			closeConnection(rs2, ps2, conn2);
		}

		return result;
	}

	public Collection getGallery(String idParm) throws Exception {

		ArrayList result = new ArrayList();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int roomIDLocal = Integer.parseInt(idParm);

		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(PHOTOGALLERY_SQL);
			ps.setInt(1, roomIDLocal);
			rs = ps.executeQuery();

			while (rs.next()) {
				GalleryView gallery = new GalleryView();
				gallery.setId(rs.getString(1));
				gallery.setPicName(rs.getString(2));
				gallery.setToolTipLabel(rs.getString(2));
				result.add(gallery);
			}
		} finally {
			closeConnection(rs, ps, conn);
		}
		return result;
	}

	/**
	 * Ejecuta una consulta con y retorna un numero maximo de registros maxRows
	 * 
	 * @param <code>String</code> La consulta SELECT
	 * @return <code>int</code> El numero de registros afectados
	 * @exception <code>SQLException</code>
	 */

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
				reserveView.setRoomNumV(rs.getString(1));
				reserveView.setEmailV(rs.getString(2));
				reserveView.setReservationDateV(
					df.format(new Date(rs.getLong(3))));
				reserveView.setCheckinDateV(df.format(new Date(rs.getLong(4))));
				reserveView.setCheckoutDateV(
					df.format(new Date(rs.getLong(5))));
				reserveView.setGuestV(rs.getString(6));
				reserveView.setStatusV(rs.getString(7));
				reserveView.setTotalV(rs.getString(8));
				reserveView.setFirstNameV(rs.getString(9));
				reserveView.setLastNameV(rs.getString(10));
				result.add(reserveView);
			}

		} finally {
			closeConnection(rs, stm, con);
		}
		return result;
	}

	public boolean insertUpdateCliente(ClientDTO clientDto)
		throws SQLException {
		ClientInsertWrapper clientWrapper = new ClientInsertWrapper(clientDto);

		return clientWrapper.execute();
	}

	protected ResultSet runQuery(String query) throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = getPooledConnection(DBASEKEY);
			st = conn.createStatement();
			rs = st.executeQuery(query);
		} finally {
			//			closeConnections(rs,st,conn);
		}

		return rs;
	} //runQuery

}
