package com.nicahost.module.hotelreserve.admin.service;

import com.nicahost.common.helper.MailSender;
import com.nicahost.module.hotelreserve.config.bean.HotelReserveInitMailBean;

/**
 * @author henry
 * version 1.0 Jul 6, 2006
 *
 */
public class AdminMailService {
	private static AdminMailService instance = null;
	
	private AdminMailService() {
	}
	
	public static AdminMailService getInstance() {
		if (instance==null) {
			instance = new AdminMailService();
		}
		
		return instance;
	}

	

	public void sendMessageNewPassword(String toEmail, String newpass) {
		MailSender mail = new MailSender();
		String from = HotelReserveInitMailBean.getInstance().getFrom();
		mail.setFrom(from);
		mail.setTo(toEmail);
		mail.setSubject("Su cambio de contraseña");
		mail.setMessage("Su contraseña ha sido cambiada. \n\n\n" +
			" Su nueva contraseña es: "+ newpass +"\n\n" +
			"Ingrese nuevamente a http://localhost:9080/app/showsignin.do");	
		mail.sendMessage(false);		
	}	

	
}
