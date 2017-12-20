/*
 * Created on Aug 16, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		System.out.println("DATE="+cal.get(Calendar.DATE));
		System.out.println("DAY_OF_MONTH="+cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_WEEK="+cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_WEEK_IN_MONTH="+cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));		
		System.out.println("DAY_OF_YEAR="+cal.get(Calendar.DAY_OF_YEAR));
		//System.out.println("DECEMBER="+cal.get(Calendar.DECEMBER));
		System.out.println("DST_OFFSET="+cal.get(Calendar.DST_OFFSET));
		System.out.println("ERA="+cal.get(Calendar.ERA));
		//System.out.println("FIELD_COUNT="+cal.get(Calendar.FIELD_COUNT));
		System.out.println("HOUR="+cal.get(Calendar.HOUR));
		System.out.println("HOUR_OF_DAY="+cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("MILLISECOND="+cal.get(Calendar.MILLISECOND));
		System.out.println("MINUTE="+cal.get(Calendar.MINUTE));		
		System.out.println("MONTH="+cal.get(Calendar.MONTH));
		System.out.println("SECOND="+cal.get(Calendar.SECOND));
		System.out.println("UNDECIMBER="+cal.get(Calendar.UNDECIMBER));
		System.out.println("WEEK_OF_MONTH="+cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("WEEK_OF_YEAR="+cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("YEAR="+cal.get(Calendar.YEAR));
		System.out.println("ZONE_OFFSET="+cal.get(Calendar.ZONE_OFFSET));
		
	}
}
