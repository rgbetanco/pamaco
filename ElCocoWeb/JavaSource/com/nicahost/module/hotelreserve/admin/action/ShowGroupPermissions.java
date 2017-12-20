/*
 * Created on Sep 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.authentication.bean.PermInfoBean;
import com.nicahost.module.hotelreserve.admin.form.UserGroupForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;
import com.nicahost.module.hotelreserve.bean.UserGroupBean;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowGroupPermissions extends AdminBaseAction {

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
		String groupId = request.getParameter("groupId");
		UserGroupForm frm = (UserGroupForm) form;
		
		
		HotelAdminService service = HotelAdminService.getInstance();	
		Collection options = service.getOptionPermissions();
		UserGroupBean gBean = service.getGroupPermissions(groupId);		
		String[] selectedPerms = new String[gBean.getPermissions().size()];
		int i = 0;
		for (Iterator iter = gBean.getPermissions().iterator(); iter.hasNext();) {
			PermInfoBean element = (PermInfoBean) iter.next();
			selectedPerms[i++] = element.getPermId() + "_" + element.getOptionId();
		}
		
		frm.setSelectedPermissions(selectedPerms);
		frm.setGroupId(groupId);
		frm.setGroupName(gBean.getName());
		
		request.setAttribute("options",options);
		forward = mapping.findForward("Success");
		return forward;
	}

}
