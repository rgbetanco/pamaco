
package com.nicahost.module.hotelreserve.admin.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.framework.common.view.OptionView;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;
import com.nicahost.module.hotelreserve.bean.PlanRateBean;

/**
 * 
 * @author Henry
 * version 1.1 Sep 15, 2006
 * 
 * playaelcoco.com.ni
 */
public class ShowRoomInsert extends AdminBaseAction {

	/* (non-Javadoc)
	 * @see com.nicahost.module.hotelreserve.admin.action.AdminBaseAction#adminExecuteAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.nicahost.framework.common.form.HeaderForm, com.nicahost.framework.common.form.FooterForm)
	 */
	public ActionForward adminExecuteAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

			ActionForward forward = null;
			HotelAdminService service = HotelAdminService.getInstance();
			Collection planRates = service.getPlanRates();
			ArrayList planRatesView = new ArrayList();
			for (Iterator iter = planRates.iterator(); iter.hasNext();) {
				PlanRateBean element = (PlanRateBean) iter.next();
				OptionView view = new OptionView(element.getName(), element.getPlanNo());
				planRatesView.add(view);
			}
			
			sort(planRatesView,"label");
			request.setAttribute("planRates",planRatesView);
		
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
			return forward;	
	}

}
