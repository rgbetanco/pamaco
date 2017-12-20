/*
 * Created on Sep 27, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;

/**
 * @author Ronald
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class showGenStatistic extends AdminBaseAction {
	
	private Collection list1 = new ArrayList();
	private Collection list2 = new ArrayList();
	
	public ActionForward adminExecuteAction(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response,
			HeaderForm headerForm,
			FooterForm footerForm)
			throws Exception {

			ActionForward forward = null;
			
			HotelAdminService service = new HotelAdminService();
			list1 = service.getList(0);
			list2 = service.getList(1);
			
			request.setAttribute("clientes", list1);
			request.setAttribute("habitacion", list2);
			
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
			return forward;

			}
}
