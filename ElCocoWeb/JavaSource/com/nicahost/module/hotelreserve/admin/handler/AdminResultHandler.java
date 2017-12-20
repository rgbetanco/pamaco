package com.nicahost.module.hotelreserve.admin.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nicahost.common.util.vlh.ValueListHandler;
import com.nicahost.common.util.vlh.ValueListHandlerException;
import com.nicahost.module.hotelreserve.admin.dao.HotelAdminDAO;

/**
 * 
 * @author Henry
 * version 1.1 Sep 9, 2006
 * 
 * playaelcoco.com.ni
 */
public class AdminResultHandler extends ValueListHandler {
	public static final String ACTION = "action";
	public static final String ACTION_PLAN_RATES = "getPlanRates";
	public static final String ACTION_PLAN_RATES_FOR_ROOM = "getPlanRatesFoRoom";
	public static final String ACTION_ROOMS_FOR_ROOMTYPE = "getRoomsForRoomType";
	public static final String ACTION_ROOMTYPES = "getRoomTypes";
	public static final String ACTION_USERS = "getUsers";
	public static final String ACTION_USERGROUPS = "getUserGroups";
	public static final String ACTION_PENDING_RESERVATIONS = "getPendingReservations";
	public static final String ACTION_QUERY_RESERVATIONS = "queryReservations";

	public static final String PARAMS = "params";

	private Map projectCriteria = null;
	private Map linkParams = null;

	private AdminResultHandler() {/* obligar a que llamen al constructor */
	}
	
	public AdminResultHandler(Map criteria) {
		this.projectCriteria = criteria;
		linkParams = new HashMap();
	}
		
	/* (non-Javadoc)
	 * @see com.nicahost.common.util.vlh.ValueListHandler#executeSearch(java.lang.Object)
	 */
	public void executeSearch(Object criteria)
		throws ValueListHandlerException {
		if (criteria instanceof Map) {
			this.projectCriteria = (Map) criteria;
			linkParams = new HashMap();
		} else {
			throw new ValueListHandlerException("Invalid parameters");
		}
		
		executeSearch();
	}

	public void executeSearch() throws ValueListHandlerException {
		try {
			List resultList = null;	
		  	if (projectCriteria == null) {
				throw new ValueListHandlerException("Project Criteria required...");
		  	}		  	
		  	
		  	HotelAdminDAO dao = new HotelAdminDAO();
			String m = (String) projectCriteria.get(ACTION);
			if (ACTION_PLAN_RATES_FOR_ROOM.equals(m)) {
				String roomid = (String) projectCriteria.get(PARAMS);
				resultList = (ArrayList) dao.getPlanRatesForRoom(roomid);				
			} else
				
			if (ACTION_PLAN_RATES.equals(m)) {
				resultList = (ArrayList) dao.getPlanRates();				
			} else 
			
			if (ACTION_ROOMTYPES.equals(m)) {
				resultList = (ArrayList) dao.getRoomTypes();
			} else 
			
			if (ACTION_ROOMS_FOR_ROOMTYPE.equals(m)) {
				String roomtypeid = (String) projectCriteria.get(PARAMS);
				resultList = (ArrayList) dao.getRooms(roomtypeid);
			} else
			
			if (ACTION_USERS.equals(m)) {
				resultList = (ArrayList) dao.getUsers();
			} else
			
			if (ACTION_USERGROUPS.equals(m)) {
				resultList = (ArrayList) dao.getUserGroups();
			} else
			
			if (ACTION_PENDING_RESERVATIONS.equals(m)) {
				resultList = (ArrayList) dao.getPendingReservations();
			} else
			
			if (ACTION_QUERY_RESERVATIONS.equals(m)) {
				HashMap params = (HashMap) projectCriteria.get(PARAMS);
				resultList = (ArrayList) dao.queryReservations(params);
			}
		
			
			setList(resultList);
		  
		} catch (Exception ex) {
			throw new ValueListHandlerException(ex.getMessage());		
		}
	}
	/**
	 * @return
	 */
	public Map getLinkParams() {
		return linkParams;
	}

	/**
	 * @param map
	 */
	public void setLinkParams(Map map) {
		linkParams = map;
	}
	
	public void addLinkParam(String key, String value) {
		linkParams.put(key,value);
	}

}
