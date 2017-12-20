
package com.nicahost.module.hotelreserve.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.NavigationItem;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.dto.ReserveDTO;
import com.nicahost.module.hotelreserve.form.ReserveForm;
import com.nicahost.module.hotelreserve.service.HotelReserveMailService;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * 
 * @author henry
 * Version 1.0 Oct 4, 2006
 *
 * playaelcoco.com.ni
 */
public class PlaceOrderAction extends BaseAction {

	/* (non-Javadoc)
	 * @see com.nicahost.framework.common.action.BaseAction#executeAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.nicahost.framework.common.form.HeaderForm, com.nicahost.framework.common.form.FooterForm)
	 */
	public ActionForward executeAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

		ActionForward forward = null;
		
		//Vector de navegacion	
		Vector navigationItems = new Vector();
		navigationItems.addElement(new NavigationItem("label.nav5", null));
		headerForm.setNavigationItems(navigationItems);	

//		Invocacion de servicio		
		HotelReserveService hotelService = HotelReserveService.getInstance();
		HotelReserveMailService mailService = HotelReserveMailService.getInstance();
		
		ReserveForm reserveForm = (ReserveForm) form;
		ReserveDTO reserveDTO = new ReserveDTO();
		
		BeanUtils.copyProperties(reserveDTO,reserveForm);
		
		String code = hotelService.processReservation2(reserveDTO);
		
		if (code != null && !code.trim().equals("-1")) {
			StringBuffer fullName = new StringBuffer();
			fullName.append(reserveDTO.getFirstName()).append(" ").append(reserveDTO.getLastName());
			String userEmail = reserveDTO.getEmail1();			
			mailService.sendConfirmationNoticeToUser(userEmail,fullName.toString(),code,getLocale(request));
			
			saveMessage(request,"text.common.confirmation", code);
		} else {
			saveError(request,"text.common.confirmation.denied", code);
		}
		
		// el request
		request.setAttribute("code",code);
	
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
