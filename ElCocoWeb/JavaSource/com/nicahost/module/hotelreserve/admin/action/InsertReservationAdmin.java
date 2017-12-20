package com.nicahost.module.hotelreserve.admin.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;
import com.nicahost.module.hotelreserve.dto.Reserve01DTO;

/**
 * @version 	1.0
 * @author
 */
public class InsertReservationAdmin extends BaseAction {

	public ActionForward executeAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

		ActionForward forward = null;

		String block = request.getParameter("bloquear");
		String update = request.getParameter("actualizar");
		String[] idDate = request.getParameterValues("dayroom");
		String[] checkedDate = request.getParameterValues("checked");

		Collection col = new ArrayList();
		Collection col1 = new ArrayList();
		int idRoomini = 0;
		int idRoomL = 0;

		long checkindateL = 0;
		long checkoutdateL = 0;
		long aDay = 60 * 60 * 24 * 1000;
		
		if (idDate != null) {
			for (int i = 0; i < idDate.length; i++) {
				int j = idDate[i].indexOf(",");
				String no = idDate[i].substring(0, j);
				String iniDate = idDate[i].substring(j + 1);

				try {
					Reserve01DTO dto = new Reserve01DTO();
					idRoomL = Integer.parseInt(no);

					if (idRoomL != idRoomini && idRoomini == 0) {
						dto.setIniRange(true);
					}
					if (i == idDate.length - 1) {
						dto.setFinRange(true);
					}

					checkoutdateL = Long.parseLong(iniDate);
					checkindateL = Long.parseLong(iniDate);

					dto.setRoomid(idRoomL);
					dto.setCheckindate(checkindateL);
					dto.setCheckoutdate(checkoutdateL);
					col.add(dto);
					idRoomini = idRoomL;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		if (checkedDate != null) {
			for (int i = 0; i < checkedDate.length; i++) {
				int j = checkedDate[i].indexOf(",");
				String no = checkedDate[i].substring(0, j);
				String iniDate = checkedDate[i].substring(j + 1);

				try {
					Reserve01DTO dto = new Reserve01DTO();
					idRoomL = Integer.parseInt(no);

					if (idRoomL != idRoomini && idRoomini == 0) {
						dto.setIniRange(true);
					}
					if (i == checkedDate.length - 1) {
						dto.setFinRange(true);
					}

					checkoutdateL = Long.parseLong(iniDate);
					checkindateL = Long.parseLong(iniDate);

					dto.setRoomid(idRoomL);
					dto.setCheckindate(checkindateL);
					dto.setCheckoutdate(checkoutdateL);
					col1.add(dto);
					idRoomini = idRoomL;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		HotelAdminService service = new HotelAdminService();
		if (block != null) {
			service.insertResAdmin(col);
		} else if (update != null) {
			service.deleteResAdmin(col1);
		}
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		return forward;

	}
}
