/*
 * Created on Oct 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.daemon;

/**
 * @author Ronald
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.nicahost.common.config.init.IDaemonTask;
import com.nicahost.module.hotelreserve.admin.dao.HotelAdminDAO;

public class SendReservationToHistory extends IDaemonTask {
	
	public void run(){
		HotelAdminDAO dao = new HotelAdminDAO();
		Collection col = dao.copyResOnHoldToHist();
		for (Iterator colIter = col.iterator(); colIter.hasNext();) {
			Integer element = (Integer) colIter.next();
			dao.copyResToHist1(Integer.parseInt(element.toString()));
		}
	}
	public void init(Map m){
		
	}

}
