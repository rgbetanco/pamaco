package com.nicahost.module.authentication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.nicahost.common.dao.DBBaseDAO;
import com.nicahost.common.util.UniqueIdentifierGenerator;
import com.nicahost.common.util.UtilCrypto;
import com.nicahost.module.authentication.bean.UserBean;
import com.nicahost.module.authentication.exception.InvalidLoginException;

/**
 * 
 * @author henry
 * Version 1.0 Sep 12, 2006
 *
 * playaelcoco.com.ni
 */

public class AuthenticationDAO extends DBBaseDAO {
	static Logger log = Logger.getLogger(AuthenticationDAO.class);
	
	public boolean authenticate(String _userid, String _password) throws SQLException, InvalidLoginException {
		boolean res = false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		StringBuffer sql = new StringBuffer(ConstantsDAO.AUTHENTICATE);
		
		try {

			conn = getPooledConnection(ConstantsDAO.DBASEKEY);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, _userid);
			rs = ps.executeQuery();

			if (rs.next()) {
				String pwdencrypted = UtilCrypto.encrypt(_password);
				if (pwdencrypted.equals(rs.getString(2)))
					res = true;
			}
			
			if (!res) 
				throw new InvalidLoginException();
				
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
	}
	
	/**
	 * 
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	public UserBean getProfile(String userid) throws SQLException {
		UserBean res = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
			
		try {
			StringBuffer sql = new StringBuffer(ConstantsDAO.PROFILE_SELECT);
			sql.append(ConstantsDAO.PROFILE_FILTERED_BY_USERID);
			
			conn = getPooledConnection(ConstantsDAO.DBASEKEY);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			HashMap uBeanTemp = new HashMap();
			UserBean userBean;
			String uid, name, pass, status, email, groupid, permid, permission, opid;
			
			 while (rs.next()) {
				uid = rs.getString(1);
				name = rs.getString(2);
				pass = rs.getString(3);
				status = rs.getString(4);
				email = rs.getString(5);
				groupid = rs.getString(6);
				permid = rs.getString(7);
				permission = rs.getString(8);
				opid = rs.getString(9);
				if (!uBeanTemp.containsKey(uid)) {
					userBean = new UserBean();
					userBean.setEmail(email);
					userBean.setGroupId(groupid);
					userBean.setName(name);
					userBean.setPassword(pass);
					userBean.setStatus(status);
					userBean.setUserId(uid);
			 		
					uBeanTemp.put(uid,userBean);
				} else {
					userBean = (UserBean) uBeanTemp.get(uid);			 		
				}			 	
				//poblo los permisos
				userBean.addPermission(permid, permission,opid);
			}
			
			res = (UserBean) uBeanTemp.get(userid);
			
				
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;		
		
	}


	public String generateTempPwd(String _userid) throws SQLException, InvalidLoginException {
		String _password = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		try {

			conn = getPooledConnection(ConstantsDAO.DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.USER_UPDATE_PASSWORD);
			
			_password = UniqueIdentifierGenerator.generateCode().substring(0,8);
			String pwdencrypted = UtilCrypto.encrypt(_password);
			
			ps.setString(1, ConstantsDAO.STATUS_NEWPASSWORD);
			ps.setString(2,pwdencrypted);
			ps.setString(3,_userid);

			int rec = ps.executeUpdate();
			
			if (rec <= 0 ) {
				throw new InvalidLoginException();
			}
				
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return _password;
	}


	public boolean changePwd(String _userId, String _oldPassword, String _newPassword) throws SQLException, InvalidLoginException {
		boolean res = false;
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		String pwdencrypted = UtilCrypto.encrypt(_newPassword);
		String oldpwdencrypted = UtilCrypto.encrypt(_oldPassword);

		if (!oldpwdencrypted.equals(this.getProfile(_userId).getPassword())) {
			throw new InvalidLoginException();							
		}
						
				
		try {
			
			conn = getPooledConnection(ConstantsDAO.DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.USER_UPDATE_PASSWORD);
									
			ps.setString(1, ConstantsDAO.STATUS_ENABLED);
			ps.setString(2,pwdencrypted);
			ps.setString(3,_userId);

			ps.executeUpdate();
				
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
	}	



	/**
	 * Este metodo es para actulizar la contrasenha por un administrador, entonces no es necesario
	 * pedir la contrasenha anterior. HJ
	 * 
	 */
	public boolean updatePwd(String _userId, String _newPassword) throws SQLException {
		boolean res = false;
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int result = -1;
				
		try {
			String pwdencrypted = UtilCrypto.encrypt(_newPassword);	
			conn = getPooledConnection(ConstantsDAO.DBASEKEY);
			ps = conn.prepareStatement(ConstantsDAO.USER_UPDATE_PASSWORD);
									
			ps.setString(1, ConstantsDAO.STATUS_ENABLED);
			ps.setString(2,pwdencrypted);
			ps.setString(3,_userId);

			result = ps.executeUpdate();
			
			res = result > 0 ? true:false;
				
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
	}	
	
}
