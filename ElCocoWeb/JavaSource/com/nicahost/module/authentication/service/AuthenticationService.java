
package com.nicahost.module.authentication.service;

import com.nicahost.module.authentication.bean.UserBean;
import com.nicahost.module.authentication.dao.AuthenticationDAO;
import com.nicahost.module.authentication.dao.ConstantsDAO;
import com.nicahost.module.authentication.exception.ChangePasswordException;
import com.nicahost.module.authentication.exception.NoPermissionException;
import com.nicahost.module.authentication.exception.UserDisabledException;
import com.nicahost.module.hotelreserve.admin.service.AdminMailService;

/**
 * @author henry
 * Version 1.0 Sep 12, 2006
 *
 * playaelcoco.com.ni
 */
public class AuthenticationService {

	private static AuthenticationService service = null;
	private static AuthenticationDAO authDAO = new AuthenticationDAO();

	public static AuthenticationService getInstance() {
		if (service == null) {
			service = new AuthenticationService();
		}
		return service;
	}
	
	private AuthenticationService() {/* emtpy constructor */}
	

	/**
	 * 
	 * @param userid
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public UserBean authenticate(String userid, String password)
		throws Exception {
		UserBean bean = new UserBean();

		if (authDAO.authenticate(userid, password)) {
			bean = authDAO.getProfile(userid);
		}
		
		if (null == bean) {
			throw new NoPermissionException();
		}

		if (bean.getStatus().equals(ConstantsDAO.STATUS_NEWPASSWORD)) {
			throw new ChangePasswordException();
		}

		if (bean.getStatus().equals(ConstantsDAO.STATUS_DISABLED)) {
			throw new UserDisabledException();
		}

		return bean;
	}

	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public boolean resetPassword(String userId) throws Exception {
		boolean res = false;

		String newpass = authDAO.generateTempPwd(userId);
		UserBean uBean = authDAO.getProfile(userId);
		if (uBean != null) {
			AdminMailService mailService =
				AdminMailService.getInstance();
			mailService.sendMessageNewPassword(uBean.getEmail(), newpass);
		}

		return res;
	}

	/**
	 * 
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	public boolean changePassword(
		String userId,
		String oldPassword,
		String newPassword)
		throws Exception {
		boolean res = false;
		
		res = authDAO.changePwd(userId, oldPassword, newPassword);

		return res;
	}
	
	public boolean updatePassword(String userId, String password) throws Exception {
		return authDAO.updatePwd(userId, password);
	}
	

}
