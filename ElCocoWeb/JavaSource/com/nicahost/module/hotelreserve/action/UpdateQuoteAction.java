
package com.nicahost.module.hotelreserve.action;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.NavigationItem;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.bean.RoomReserveBean;
import com.nicahost.module.hotelreserve.form.ReserveForm;

/**
 * 
 * @author Henry
 * version 1.1 Sep 16, 2006
 * 
 * playaelcoco.com.ni
 */
public class UpdateQuoteAction extends BaseAction {

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
			//inicializacion de objetos session

			//Vector de navegacion			
			Vector navigationItems = new Vector();
			navigationItems.addElement(new NavigationItem("label.nav1", "/hotelreserve/reserve.do"));
			navigationItems.addElement(new NavigationItem("label.nav2", null));
			headerForm.setNavigationItems(navigationItems);		

			//Recuperacion de datos del request					
			String roomId = request.getParameter("roomId");
			String guests = request.getParameter("g");
			String rooms = request.getParameter("r");
			String max = request.getParameter("max");
			String[] maxRooms = new String[0];

			//Invocacion de servicio
			if (!GenericValidator.isBlankOrNull(roomId) && !GenericValidator.isBlankOrNull(guests)) {
				if (GenericValidator.isInt(roomId) && GenericValidator.isInt(guests)) {
					Collection checkedRooms = ((ReserveForm) form).getSelectedRooms();
					for (Iterator iter = checkedRooms.iterator();iter.hasNext();						) {
						RoomReserveBean element = (RoomReserveBean) iter.next();
						if (element.getRoomId().equals(roomId)) {
							element.setGuests(Integer.parseInt(guests));
							if (!GenericValidator.isBlankOrNull(rooms)) {
								element.setRooms(Integer.parseInt(rooms));
								maxRooms = new String[Integer.parseInt(max)];
								for (int i = 1; i <= Integer.parseInt(max); i++) {
									maxRooms[i-1] = Integer.toString(i);
								}
							}
							break;
						}
					}					
					
					((ReserveForm) form).setSelectedRooms(checkedRooms);		
				}
			}
			
			request.setAttribute("maxRooms",maxRooms);
						
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
