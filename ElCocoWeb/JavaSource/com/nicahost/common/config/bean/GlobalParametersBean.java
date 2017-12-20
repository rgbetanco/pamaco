package com.nicahost.common.config.bean;

import java.io.Serializable;

import com.nicahost.common.config.init.IInitializer;
import com.nicahost.common.exception.InitException;

/**
 * Clase de par�metros globales. Singleton.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 02-12-2004
 *
 */
public class GlobalParametersBean implements IInitializer, Serializable {
	/** Mensaje de error cuando se recibe un objeto de inicializaci�n incorrecto. */
	private static final String INIT_OBJECT_ERROR = "Init object not an instance of "; //$NON-NLS-1$

	public static final String REALPAY_HOST = "RealPayHost";
	public static final String REALPAY_PORT = "RealPayPort";
	public static final String TEMPFILES = "TempFiles";
	public static final String REALPAY_CGI = "RealPayCGI";
	public static final String SMTP_IP ="SMTPServer";
	public static final String ENCRYPT_ALGORITHM = "EncryptAlgorithm";
	public static final String PASS_PHRASE = "Phrase";
	
	
	/** �nica instancia de la clase. */
	private static GlobalParametersBean instance = new GlobalParametersBean();
	/** Mapa de par�metros. */
	private InitParameterMapBean list;

	/**
	 * Constructor por defecto.
	 */
	private GlobalParametersBean() {
		this.list = null;
	}

	/* (no Javadoc)
	 * @see net.bac.sbe.web.common.config.init.IInitializer#init(java.lang.Object)
	 */
	public void init(Object o) throws InitException {
		if (o instanceof InitParameterMapBean) {
			this.list = (InitParameterMapBean) o;
		} else {
			InitException initException = new InitException(INIT_OBJECT_ERROR +
															InitParameterMapBean.class.getName());
//			LoggerService.logException(LoggerService.LAYER_DAO, LoggerService.LEVEL_ERROR,
//									   initException);
			throw initException;
		}
	}

	/**
	 * Obtiene la instancia de la clase.
	 * @return instancia de la clase.
	 */
	public static GlobalParametersBean getInstance() {
		return instance;
	}

	/**
	 * Asigna el valor de un par�metro.
	 * @param name nombre del par�metro.
	 * @param value valor del par�metro.
	 */
	public void setValue(String name, String value) {
		this.list.addParameter(name, value);
	}

	/**
	 * Asigna el valor de un par�metro.
	 * @param name nombre del par�metro.
	 * @param country pa�s para el que el par�metro aplica.
	 * @param application aplicaci�n para la que el par�metro aplica.
	 * @param value valor del par�metro.
	 */
/*	public void setValue(String name, String country, String application, String value) {
		this.map.addParameter(name, country, application, value);
	}
*/
	/**
	 * Obtiene el valor de un par�metro.
	 * @param name nombre del par�metro.
	 * @return valor del par�metro solicitado.
	 */
	public String getValue(String name) {
		return this.list.getValue(name);
	}

	/**
	 * Obtiene el valor de un par�metro. Este m�todo solo se debe utilizar para par�metros que
	 * pueden variar dependiendo del pa�s del usuario o aplicaci�n que lo invoque.
	 * @param name nombre del par�metro.
	 * @param country pa�s para el que el par�metro aplica.
	 * @param application aplicaci�n para la que el par�metro aplica.
	 * @return valor del par�metro solicitado.
	 * @see GlobalParametersBean#getValue(String)
	 */
/*	public String getValue(String name, String country, String application) {
		return this.map.getValue(name, country, application);
	}
*/	
	/**
	 * @return
	 */
	public InitParameterMapBean getList() {
		return list;
	}

}
