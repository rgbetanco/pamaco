
package com.nicahost.module.hotelreserve.admin.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.nicahost.common.util.BeanPropertyComparator;
import com.nicahost.common.util.vlh.ValueListHandler;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.action.PermissionActionMapping;
import com.nicahost.framework.common.exception.BaseException;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.authentication.bean.PermInfoBean;
import com.nicahost.module.authentication.bean.UserBean;
import com.nicahost.module.authentication.common.Constants;
import com.nicahost.module.authentication.exception.NoPermissionException;

/**
 * 
 * @author henry
 * Version 1.0 Sep 12, 2006
 *
 * playaelcoco.com.ni
 */
public abstract class AdminBaseAction extends BaseAction {
	protected UserBean profileBean = null;
	protected HashMap qLnk = null;
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

		HttpSession session = request.getSession(false);

		profileBean = (UserBean) session.getAttribute(Constants.USERPROFILE);
		if (profileBean == null) { //significa que la session expiro
			ActionMessages messages = new ActionMessages();
			ActionMessage newActionMessage =
				new ActionMessage("error.sessiontimedout");
			messages.add("GLOBAL_ERROR", newActionMessage);
			saveErrors(request, messages);
			forward = mapping.findForward("SessionTimedOut");
			return forward;
		}

		PermissionActionMapping pam = (PermissionActionMapping) mapping;
		boolean hasPermission = false;
		if (pam.getPermId() == null) {
			hasPermission = true;
		} else {
			for (Iterator iter = profileBean.getPermissions().iterator();
				iter.hasNext();
				) {
				PermInfoBean element = (PermInfoBean) iter.next();
				if (element.getPermId().equals(pam.getPermId()) && element.getOptionId().equals(pam.getOptionId())) {
					hasPermission = true;
					break;
				}
			}
		}

		if (!hasPermission)
			throw new NoPermissionException();

		forward =
			this.adminExecuteAction(
				mapping,
				form,
				request,
				response,
				headerForm,
				footerForm);
		/*			
					HotelAdminService service = HotelAdminService.getInstance();
					String authorization = request.getHeader("Authorization");
					
				if (authorization == null) {
					askForPassword(response);
				} else {
					
					String userInfo = authorization.substring(6).trim();
					user = null;
					String password = null;
					BASE64Decoder decoder = new BASE64Decoder();
		
					String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
					int index = nameAndPassword.indexOf(":");
					user = nameAndPassword.substring(0, index);
					password = nameAndPassword.substring(index + 1);
		
					if (service.getAccessibility(user, password)) {
						forward = this.adminExecuteAction(mapping,form,request, response, headerForm, footerForm);
					} else {
						askForPassword(response);
					}
				}
		*/
		return forward;
	}

	protected void prepareValueListHandlerForView(
		ValueListHandler resultList,
		HttpServletRequest request)
		throws Exception {
		prepareValueListHandlerForView(resultList, request, 10);
	}

	protected void prepareValueListHandlerForView(
		ValueListHandler resultList,
		HttpServletRequest request,
		int hitsPerPage)
		throws Exception {
		int pageIndex = 1;
		int indx = 0;
		int maxPagesToShow = 10;
		


		String page = request.getParameter("page");
		String orderedBy = request.getParameter("ob");
		
		qLnk = new HashMap();
		qLnk.put("page",page);
		qLnk.put("ob",orderedBy);

		int totalHits = resultList.getSize();
		int totalPages = totalHits / hitsPerPage;

		totalPages =
			totalPages * hitsPerPage < totalHits ? totalPages + 1 : totalPages;

		request.setAttribute("resultList", resultList);
		request.setAttribute("totalHits", Integer.toString(totalHits));
		request.setAttribute("totalPages", Integer.toString(totalPages));
		request.setAttribute("ob", orderedBy);

		try {
			if (page != null) {
				indx = Integer.valueOf(page).intValue();
			}

			indx = resultList.getSize() < indx ? pageIndex : indx;
			pageIndex = pageIndex > indx ? pageIndex : indx;

		} catch (Exception ex) {
			throw new BaseException("It's not a valid index");
		}

		int currentPage = pageIndex;

		pageIndex = (pageIndex * hitsPerPage) - hitsPerPage;

		resultList.setIndex(pageIndex);

		String hasPrevious = new Boolean(resultList.hasPrevious()).toString();

		//sorting
		if (!GenericValidator.isBlankOrNull(orderedBy)) {
			sort((List) resultList.getList(), orderedBy);
		} else {
			sort((List) resultList.getList(), null);
		}

		List result = resultList.getNextElements(hitsPerPage);

		String hasNext = new Boolean(resultList.hasNext()).toString();

		int loopNumber = (currentPage / maxPagesToShow) + 1;
		int maxLastPage = loopNumber * maxPagesToShow;

		int minLastPage =
			currentPage <= maxPagesToShow ? (currentPage - maxPagesToShow) : 0;
		minLastPage = minLastPage <= 0 ? 1 : minLastPage;

		maxLastPage = maxLastPage < (totalPages) ? maxLastPage : totalPages;
		//maxLastPage = maxLastPage <= maxPagesToShow ? 1 : maxLastPage;

		request.setAttribute("maxLastPage", Integer.toString(maxLastPage));
		request.setAttribute("minLastPage", Integer.toString(minLastPage));

		request.setAttribute("resultHandler", result);
		request.setAttribute("currentPage", Integer.toString(currentPage));
		request.setAttribute("hasNext", hasNext);
		request.setAttribute("hasPrevious", hasPrevious);

		return;
	}

	protected void sort(List collection, String sortIndex) {
		BeanPropertyComparator bpc;
		if (sortIndex != null) {
			bpc = new BeanPropertyComparator(sortIndex);
			Collections.sort(collection, bpc);
		} else {
			Collections.sort(collection);
		}

	}

	private void askForPassword(HttpServletResponse response) {
		response.setStatus(response.SC_UNAUTHORIZED);
		response.setHeader(
			"WWW-Authenticate",
			"BASIC realm=\"Priviledged-few\"");
	}

	public abstract ActionForward adminExecuteAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception;

}