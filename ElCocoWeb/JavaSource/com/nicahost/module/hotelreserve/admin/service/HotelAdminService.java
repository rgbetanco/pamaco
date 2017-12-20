
package com.nicahost.module.hotelreserve.admin.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.nicahost.common.util.vlh.ValueListHandler;
import com.nicahost.framework.common.exception.BaseException;
import com.nicahost.module.authentication.bean.UserBean;
import com.nicahost.module.hotelreserve.admin.dao.HotelAdminDAO;
import com.nicahost.module.hotelreserve.admin.dto.RoomsTableDTO;
import com.nicahost.module.hotelreserve.admin.handler.AdminResultHandler;
import com.nicahost.module.hotelreserve.bean.DateTakenBean;
import com.nicahost.module.hotelreserve.bean.PlanRateBean;
import com.nicahost.module.hotelreserve.bean.RoomBean;
import com.nicahost.module.hotelreserve.bean.UserGroupBean;
import com.nicahost.module.hotelreserve.common.Constants;
import com.nicahost.module.hotelreserve.config.bean.HotelReserveInitParamBean;
import com.nicahost.module.hotelreserve.config.bean.HotelReserveInitParamDAO;
import com.nicahost.module.hotelreserve.view.DateRangeView;
import com.nicahost.module.hotelreserve.view.ReservationCalendarView;
/**
 * 
 * @author Henry
 * version 1.1 Sep 3, 2006
 * 
 * playaelcoco.com.ni
 */
public class HotelAdminService {

	private static HotelAdminService hotelAdminService = null;
	private static HotelAdminDAO daoHotelAdmin = new HotelAdminDAO();

	public static HotelAdminService getInstance() {
		if (hotelAdminService == null) {
			hotelAdminService = new HotelAdminService();
		}
		return hotelAdminService;
	}
	
	
	public boolean insertUser(String userId, String name, String unencryptPwd, 
								String status, String email, String groupId) throws Exception {
		UserBean bean = new UserBean();
		bean.setUserId(userId);
		bean.setName(name);
		bean.setPassword(unencryptPwd);
		bean.setStatus(status);
		bean.setEmail(email);
		bean.setGroupId(groupId);
		
		return daoHotelAdmin.insertUser(bean);	
	}

	public boolean updateUser(String userId, String name, String status, String email, String groupId) throws Exception {
		UserBean bean = new UserBean();
		bean.setUserId(userId);
		bean.setName(name);
		bean.setStatus(status);
		bean.setEmail(email);
		bean.setGroupId(groupId);
		
		return daoHotelAdmin.updateUser(bean);	
	}
	
	public Collection getUserGroups() throws Exception {
		return daoHotelAdmin.getUserGroups();
	}

	public ValueListHandler getUsersHandler() throws Exception {
		Map params = new HashMap();
		params.put(AdminResultHandler.ACTION,AdminResultHandler.ACTION_USERS);

		AdminResultHandler listHandler = new AdminResultHandler(params);
		listHandler.executeSearch();

		if (listHandler.getSize() <= 0) {
			throw new BaseException("error.result.empty");
		}
		
		return listHandler;		
	}
	
	public Collection getUsersForGroup(String groupId) throws Exception {
		return daoHotelAdmin.getUsersForGroup(groupId);
	}
	
	public ValueListHandler getUserGroupsHandler()
		throws Exception
	{
		Map params = new HashMap();
		params.put(AdminResultHandler.ACTION, AdminResultHandler.ACTION_USERGROUPS);
		AdminResultHandler listHandler = new AdminResultHandler(params);
		listHandler.executeSearch();
		if(listHandler.getSize() <= 0)
			throw new BaseException("error.result.empty");
		else
			return listHandler;
	}
	public boolean insertUserGroup(String name, String description)
		throws Exception
	{
		UserGroupBean bean = new UserGroupBean(name,description);
		return daoHotelAdmin.insertUserGroup(bean);
	}
	public boolean updateUserGroup(String groupId, String name, String description)
		throws Exception
	{
		UserGroupBean bean = new UserGroupBean(groupId,name,description);
		return daoHotelAdmin.updateUserGroup(bean);
	}
	public Collection getOptionPermissions() throws Exception {
		return daoHotelAdmin.getOptionPermissions();
	}
	
	public UserGroupBean getGroupPermissions(String groupId) throws Exception {
		return daoHotelAdmin.getGroupPermissions(groupId);
	}
	
	public boolean updateGroupPermissions(String groupId, String[] permissions) throws Exception {
		
		UserGroupBean bean = new UserGroupBean();
		bean.setGroupId(groupId);
		
		if (permissions != null) {		
			for (int i = 0; i < permissions.length; i++) {
				String perm = permissions[i];
				int index = perm.indexOf("_");
				String permid = perm.substring(0,index);
				String opid = perm.substring(index+1);
				bean.addPermission(permid,opid);			
			}
		}

		return daoHotelAdmin.updateGroupPermissions(bean);
	}

	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Collection getRoomTypes() throws Exception {
		return daoHotelAdmin.getRoomTypes();
	}
	
	public ValueListHandler getRoomTypesHandler() throws Exception {
		Map params = new HashMap();
		params.put(AdminResultHandler.ACTION,AdminResultHandler.ACTION_ROOMTYPES);

		AdminResultHandler listHandler = new AdminResultHandler(params);
		listHandler.executeSearch();

		if (listHandler.getSize() <= 0) {
			throw new BaseException("error.result.empty");
		}
		
		return listHandler;		
	}
	
	public boolean insertRoomType(String description) throws Exception {
		return daoHotelAdmin.insertRoomType(description);
	}
	
	public boolean updateRoomType(String roomTypeId, String description) throws Exception {
		return daoHotelAdmin.updateRoomType(roomTypeId, description);
	}
	
	
	public Collection getRooms(String roomTypeId) throws Exception {
		return daoHotelAdmin.getRooms(roomTypeId);
	}
	
	public boolean insertRoom(String roomId, String roomTypeId, String description, String blocked, String planNo) throws Exception {
		boolean res = false;
		RoomBean bean = new RoomBean(roomId, roomTypeId, description, blocked);
		
		res = daoHotelAdmin.insertRoom(bean,planNo);
		
		return res;
	}
	
	public boolean updateRoom(String roomId, String roomTypeId, String description, String blocked) throws Exception {
			boolean res = false;
			RoomBean bean = new RoomBean(roomId, roomTypeId, description, blocked);
		
			res = daoHotelAdmin.updateRoom(bean);
		
			return res;
	}
	
	public ValueListHandler getRoomsHandler(String roomTypeId) throws Exception {
		Map params = new HashMap();
		params.put(AdminResultHandler.ACTION,AdminResultHandler.ACTION_ROOMS_FOR_ROOMTYPE);
		params.put(AdminResultHandler.PARAMS,roomTypeId);

		AdminResultHandler listHandler = new AdminResultHandler(params);
		listHandler.executeSearch();
		

		if (listHandler.getSize() <= 0) {
			throw new BaseException("error.result.empty");
		}
		
		return listHandler;
	}
	
	public Collection getPlanRatesForRoom(String roomId) throws Exception {
		return daoHotelAdmin.getPlanRatesForRoom(roomId); 
	}
	
	public boolean insertPlanRateForRoom(String roomId, String planno) throws Exception {
		return daoHotelAdmin.insertPlanForRoom(roomId, planno);
	}
	
	public boolean deletePlanRateForRoom(String roomId, String planno) throws Exception {
		return daoHotelAdmin.deletePlanForRoom(roomId, planno);
	}
	
	public ValueListHandler getPlanRatesForRoomHandler(String roomId) throws Exception {
		Map params = new HashMap();
		params.put(AdminResultHandler.ACTION,AdminResultHandler.ACTION_PLAN_RATES_FOR_ROOM);
		params.put(AdminResultHandler.PARAMS,roomId);

		AdminResultHandler listHandler = new AdminResultHandler(params);
		listHandler.executeSearch();

		if (listHandler.getSize() <= 0) {
			throw new BaseException("error.result.empty");
		}
		
		return listHandler;			
	}
	
	public Collection getPlanRates() throws Exception {
		return daoHotelAdmin.getPlanRates();
	}
	
	public boolean insertPlanRate(String name, String price, String additional, String minnights, String fromdate, String todate, String active, String maxguests) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT);
		PlanRateBean bean = new PlanRateBean();
		bean.setName(name);
		bean.setPrice(new BigDecimal(price));
		bean.setAdditional(new BigDecimal(additional));
		bean.setMinNights(Integer.parseInt(minnights));
		bean.setIniDate(df.parse(fromdate).getTime());
		bean.setEndDate(df.parse(todate).getTime());
		bean.setActive(Boolean.getBoolean(active));
		bean.setMaxGuests(Integer.parseInt(maxguests));
		
		return daoHotelAdmin.insertPlanRate(bean);
	}
	
	public ValueListHandler getPlanRatesHandler() throws Exception {
		Map params = new HashMap();
		params.put(AdminResultHandler.ACTION,AdminResultHandler.ACTION_PLAN_RATES);
		
		AdminResultHandler listHandler = new AdminResultHandler(params);
		listHandler.executeSearch();

		if (listHandler.getSize() <= 0) {
			throw new BaseException("error.result.empty");
		}
		
		return listHandler;			
	}
		
	public PlanRateBean getPlanRate(String planno) throws Exception {
		return daoHotelAdmin.getPlanRate(planno);
	}
	
	public ValueListHandler getPendingReservationsHandler() throws Exception {
		Map params = new HashMap();
		params.put(AdminResultHandler.ACTION,AdminResultHandler.ACTION_PENDING_RESERVATIONS);
		
		AdminResultHandler listHandler = new AdminResultHandler(params);
		listHandler.executeSearch();

		if (listHandler.getSize() <= 0) {
			throw new BaseException("error.result.empty");
		}
		
		return listHandler;			
		
	}
	
	public ValueListHandler queryReservations(Calendar checkIn, Calendar checkOut, String status) throws Exception {
		Map params = new HashMap();
		HashMap consulta = new HashMap();
		consulta.put(Constants.FILTERED_BY_INIDATE,checkIn);
		consulta.put(Constants.FILTERED_BY_ENDDATE,checkOut);
		consulta.put(Constants.FILTERED_BY_STATUS,status);
		
		params.put(AdminResultHandler.ACTION,AdminResultHandler.ACTION_QUERY_RESERVATIONS);
		params.put(AdminResultHandler.PARAMS,consulta);
		
		AdminResultHandler listHandler = new AdminResultHandler(params);
		listHandler.executeSearch();
		
		if (listHandler.getSize() <= 0) {
					throw new BaseException("error.result.empty");
		}
		
		return listHandler;	
	}
	
	
	public ArrayList getReservationStatus() throws Exception {
		ArrayList res = HotelReserveInitParamDAO.getInstance().getReserveStatus();

		return res;		
	}

	public Collection getStatistics(long iniDate, long endDate, String habitacion, String cliente){
		Collection col = null;
		col = daoHotelAdmin.getStatistics(iniDate, endDate, habitacion, cliente);
		return col;
	}
	
	
	
		
	
	
	
	
	
	
	
	public void updateRooms(ArrayList roomsToUpdate) throws Exception{
		daoHotelAdmin.updateRoomsTable(roomsToUpdate);
	}
	
	public void insertRooms(RoomsTableDTO roomsToInsert) throws Exception{
		daoHotelAdmin.insertRoomsTable(roomsToInsert);
	}

	public void commitChanges(ArrayList anulled, ArrayList confirmed, String userParm)
		throws Exception {

		daoHotelAdmin.updateConfirmations(confirmed, userParm);
		daoHotelAdmin.updateAnnullment(anulled, userParm);

	}
	public Collection getReservation() throws Exception {
		Collection result;
		HotelAdminDAO dao = new HotelAdminDAO();
		result = dao.getRoomReservations();
		return result;
	}
	public Collection getConfirmedAnulled(long initDate, long finDate) throws Exception {
			Collection result;
			HotelAdminDAO dao = new HotelAdminDAO();
			result = dao.getConfirmedAnulled(initDate, finDate);
			return result;
		}
	public Collection getRooms() throws Exception{
		Collection result;
		HotelAdminDAO dao = new HotelAdminDAO();
		result = dao.getRooms();
		return result;
	}

	public Collection getHistory() throws Exception {
		Collection result;
		result = daoHotelAdmin.getHistory();
		return result;
	}
	
	public boolean getAccessibility(String loginParm, String passParm) throws Exception {
		boolean result;
		result = daoHotelAdmin.grantDenyAccess(loginParm, passParm);
		return result;
	}
	
	
	//****************************************************************
	
	public void insertResAdmin(Collection dto) throws Exception {
		HotelAdminDAO dao = new HotelAdminDAO();
		dao.insertAdminReservation(dto);
	}
	
	public void deleteResAdmin(Collection dto) throws Exception{
			HotelAdminDAO dao = new HotelAdminDAO();
			dao.deleteAdminReservation(dto);
		}
	
	public Collection getReservationCalendar(Calendar dateIni, Calendar dateFin) throws Exception{
			HotelAdminDAO dao = new HotelAdminDAO();
			//Collection NoRooms = dao.getRooomDescription(roomType);
			Collection resultCol = new ArrayList();
			ArrayList col = new ArrayList();
			ArrayList rooms = new ArrayList();
	
			rooms = dao.getRoomsCalendar();
			for (Iterator ii = rooms.iterator(); ii.hasNext();) {
				try {
					String ele = (String) ii.next();
					col = getAvailabilityForRoom(Integer.parseInt(ele), dateIni, dateFin);
					for (Iterator iter = col.iterator(); iter.hasNext();) {
						ReservationCalendarView element = (ReservationCalendarView) iter.next();
						resultCol.add(element);
					}	
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}
			return resultCol;
		}
	public String daysDiff(Calendar initDate, Calendar endDate) {
			String result = convertMilliToDays(this.parseDate(initDate),this.parseDate(endDate));
			return result;
		}
	
	private String convertMilliToDays(Long initDate, Long endDate) {
			long numFinParm = endDate.longValue();
			long numIniParm = initDate.longValue();
	
			long numNights = (numFinParm - numIniParm) / Constants.ONE_DAY_MILLISECOND;
		
			String result = Long.toString(numNights);
		
			return result;
		}

	private Long parseDate(Calendar dateParam) {

			long millis = dateParam.getTime().getTime();
			Long result = new Long(millis);

			return result;
	}	

	public ArrayList getAvailabilityForRoom(int roomId, Calendar iniDate, Calendar endDate) throws Exception {
			ArrayList l = new ArrayList();
			HotelAdminDAO dao = new HotelAdminDAO();
			ReservationCalendarView view;
			SimpleDateFormat df = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT);
		
			String iniDateS = df.format(iniDate.getTime());
			String endDateS = df.format(endDate.getTime());
			iniDate.setTime(df.parse(iniDateS));
			endDate.setTime(df.parse(endDateS));
		
			int room = roomId;
			long ini = parseDate(iniDate).longValue();
			long end = parseDate(endDate).longValue();
		
			Collection occupied = dao.getDatesTakenForRoom(room, ini, end);
			long i = ini;
			while(i <= end) {
				view = new ReservationCalendarView();
				Calendar c = Calendar.getInstance();
				c.setTime(new Date(i));			
				view.setRoomid(room);
				view.setRoomdescription(dao.getRoomDescription(room));
				view.setCheckindate(i);
				view.setCheckoutdate(end);
				view.setDate(c);
				
				DateTakenBean bean1 = new DateTakenBean();
				bean1.setCal(c.getTime().getTime());
				bean1.setStatus(1);
				DateTakenBean bean2 = new DateTakenBean();
				bean2.setCal(c.getTime().getTime());
				bean2.setStatus(2);
				DateTakenBean bean3 = new DateTakenBean();
				bean3.setCal(c.getTime().getTime());
				bean3.setStatus(3);
				DateTakenBean bean4 = new DateTakenBean();
				bean4.setCal(c.getTime().getTime());
				bean4.setStatus(4);
				
				for (Iterator iter = occupied.iterator(); iter.hasNext();) {
					DateTakenBean element = (DateTakenBean) iter.next();
					if (element.getCal() == bean1.getCal() && element.getStatus() == bean1.getStatus()){
						view.setUpdateDB(false);
						view.setStatus(1);
					}
					if (element.getCal() == bean2.getCal() && element.getStatus() == bean2.getStatus()){
						view.setUpdateDB(false);
						view.setStatus(2);
					}
					if (element.getCal() == bean3.getCal() && element.getStatus() == bean3.getStatus()){
						view.setUpdateDB(false);
						view.setStatus(3);
					}
					if (element.getCal() == bean4.getCal() && element.getStatus() == bean4.getStatus()){
						view.setUpdateDB(false);
						view.setStatus(4);
					}
					if (element.getCal() == bean4.getCal() && element.getStatus() == 5){
						view.setUpdateDB(true);
						view.setStatus(5);
					}
				}
				l.add(view);
				i += Constants.ONE_DAY_MILLISECOND;
			}
		
			return l;
		}

	public Collection getDateRange(Calendar iniDate, Calendar endDate){
			Collection col = new ArrayList();
		
		
			long ini = parseDate(iniDate).longValue();
			long end = parseDate(endDate).longValue();
		
			DateRangeView view;
		
		
			for(long i=ini;i<=end;i += Constants.ONE_DAY_MILLISECOND) {
				view = new DateRangeView();
				Calendar c = Calendar.getInstance();
				c.setTime(new Date(i));			
				view.setDaterange(c);
				col.add(view);
			}
		
		
			return col;
		}


	public int getDefaultNights() {
			int numNights = 2;
			try {
		
				String nights =	(String) HotelReserveInitParamBean.getInstance().getList().get(HotelReserveInitParamBean.DEFAULT_NIGHTS);
				numNights = Integer.parseInt(nights);	
			} catch (Exception ex) {/* Do nothing */}
		
			return numNights;
		}
		
	public Collection getList(int flag) throws Exception {
		//El flag lo utilizo para reconocer el tipo de lista que voy a llenar
		HotelAdminDAO dao = new HotelAdminDAO();
		
		Collection col = new ArrayList();
		if (flag == 0){
			col = dao.getClientes();
		} else if (flag == 1){
			col = dao.getRoomsDescription();
		}
		return col;
	}		
}
