
package com.nicahost.module.hotelreserve.common;

/**
 * 
 * @author henry
 * Version 1.0 Sep 22, 2006
 *
 * playaelcoco.com.ni
 */
public class Constants {

	public static final long ONE_DAY_MILLISECOND = 60*60*24*1000;
	public static final double IVA = 0.15;
	public static final String SHORT_DATE_FORMAT = "dd/MM/yyyy";
	
	//variables de estados para las reservaciones
	public static final String STATUS_AVAILABLE = "0";
	public static final String STATUS_APPROVED = "1";
	public static final String STATUS_PENDING = "2";
	public static final String STATUS_CHECKEDIN = "3";
	public static final String STATUS_BLOCKED_BY_ADMIN = "4";
	public static final String STATUS_DENIED_BY_CLIENT = "5";
	public static final String STATUS_DENIED_BY_ADMIN = "6";
	
	public static final String FILTERED_BY_STATUS = "FILTERED_BY_STATUS";
	public static final String FILTERED_BY_INIDATE = "FILTERED_BY_INIDATE";
	public static final String FILTERED_BY_ENDDATE = "FILTERED_BY_ENDDATE";
	
	private Constants() {/*private constructor*/}
	
	
}
