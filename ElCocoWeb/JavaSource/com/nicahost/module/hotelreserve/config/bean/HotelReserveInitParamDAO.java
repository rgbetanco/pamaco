
package com.nicahost.module.hotelreserve.config.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;

import com.nicahost.module.hotelreserve.dao.HotelReserveInitDAO;

/**
 * 
 * @author henry
 * Version 1.0 Oct 6, 2006
 *
 * playaelcoco.com.ni
 */
public final class HotelReserveInitParamDAO {

	static Logger log = Logger.getLogger(HotelReserveInitParamDAO.class);
	
	private static HotelReserveInitParamDAO hotelReserveInit = null;
	private static Map countries = null;
	private static Map ethnicities = null;
	private static Map roomTypes = null;
	private static Map languages = null;
	private static Map countryLanguages = null;
	private static ArrayList reserveStatus = null;

	static  {
		loadCountry();
		loadEthnicGroup();
		loadRoomTypes();	
		loadLanguages();
		loadReserveStatus();	
	}
	
	private HotelReserveInitParamDAO() {/*Constructor vacio*/}
	

	public static HotelReserveInitParamDAO getInstance() {
		if (null == hotelReserveInit ) {
			hotelReserveInit = new HotelReserveInitParamDAO();
		}		
		return hotelReserveInit;
	}

	public Map getCountries() {
		return countries;
	}
	
	public Map getEthnicities() {
		return ethnicities;
	}
	
	public Map getRoomTypes() {
		return roomTypes;
	}
	
	public Map getLanguages() {
		return languages; 
	}
	
	public Map getCountryLanguage() {
		return countryLanguages;
	}
	
	private synchronized static void loadCountry() {
		log.debug("Loading countries...");
		HotelReserveInitDAO hotelReserveInitDAO = new HotelReserveInitDAO();
		
		try {
			countries = hotelReserveInitDAO.getCountry();	
		} catch (Exception ex) {
			//ex.printStackTrace();
			log.error(ex.getMessage(), ex);	
		}		
	}
	
	private synchronized static void loadEthnicGroup() {
			log.debug("Loading ethnic groups...");
			
			HotelReserveInitDAO hotelReserveInitDAO = new HotelReserveInitDAO();
			try {
				ethnicities = hotelReserveInitDAO.getEthnicity();	
			} catch (Exception ex) {
				//ex.printStackTrace();
				log.error(ex.getMessage(), ex);	
			}		
	}
	

	private synchronized static void loadRoomTypes() {
			log.debug("Loading room types ...");
			
			HotelReserveInitDAO hotelReserveInitDAO = new HotelReserveInitDAO();
			try {
				roomTypes = hotelReserveInitDAO.getRoomTypes();	
			} catch (Exception ex) {
				//ex.printStackTrace();
				log.error(ex.getMessage(), ex);	
			}		
	}	

	private synchronized static void loadLanguages() {
			log.debug("Loading languages ...");
			
			HotelReserveInitDAO hotelReserveInitDAO = new HotelReserveInitDAO();
			try {
				languages = hotelReserveInitDAO.getLanguage();
				countryLanguages = hotelReserveInitDAO.getCountryLanguage();	
			} catch (Exception ex) {
				//ex.printStackTrace();
				log.error(ex.getMessage(), ex);	
			}		
	}
	
	private synchronized static void loadReserveStatus() {
		log.debug("Loading reserve status ...");

		HotelReserveInitDAO hotelReserveInitDAO = new HotelReserveInitDAO();
		try {
			reserveStatus = hotelReserveInitDAO.getReserveStatus();
			Collections.sort(reserveStatus);				
		} catch (Exception ex) {
			//ex.printStackTrace();
			log.error(ex.getMessage(), ex);	
		}			
	}


	/**
	 * @return
	 */
	public ArrayList getReserveStatus() {
		return reserveStatus;
	}

}
