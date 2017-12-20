package com.nicahost.common.config.bean;
import java.io.Serializable;
import java.util.HashMap;

import org.apache.commons.validator.GenericValidator;
/**
 * Mapa de par�metros de inicio.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 02-12-2004
 *
 */
public class InitParameterMapBean extends HashMap implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = 7500767192951330796L;
	/** Separador de las secciones de los par�metros. */
	private static final String SEPARATOR = "."; //$NON-NLS-1$
	/**
	 * Constructor por defecto.
	 */
	public InitParameterMapBean() {
		super();
	}
	/**
	 * Agrega o reasigna un par�metro al mapa.
	 * @param name el nombre del par�metro.
	 * @param value el valor del par�metro.
	 */
	public void addParameter(String name, String value) {
		this.put(name, value);
	}
	/**
	 * Agrega o reasigna un par�metro al mapa.
	 * @param name el nombre del par�metro.
	 * @param country pa�s para el que el par�metro aplica.
	 * @param application aplicaci�n para la que el par�metro aplica.
	 * @param value el valor del par�metro.
	 * @throws java.lang.NullPointerException
	 */
	public void addParameter(String name, String country, String application, String value) {
		String paramName = null;
		if (!GenericValidator.isBlankOrNull(country)) {
			if (!GenericValidator.isBlankOrNull(application)) {
				// pa�s y aplicaci�n.
				paramName = name.concat(SEPARATOR).concat(country).concat(SEPARATOR).concat(application);
			}
			else {
				// s�lo con pa�s.
				paramName = name.concat(SEPARATOR).concat(country);
			}
		}
		else {
			if (!GenericValidator.isBlankOrNull(application)) {
				// s�lo con aplicaci�n.
				paramName = name.concat(SEPARATOR).concat(application);
			}
			else {
				// toma s�lo el nombre del par�metro. 
				paramName = name;
			}
		}
		this.addParameter(paramName, value);
	}
	/**
	 * Obtiene el valor de un par�metro del mapa.
	 * @param name nombre del par�metro.
	 * @return valor del par�metro solicitado.
	 */
	public String getValue(String name) {
		String value = null;
		if (this.containsKey(name)) {
			value = (String) this.get(name);
		}
		return value;
	}
	/**
	 * Obtiene el valor de un par�metro. Este m�todo solo se debe utilizar para par�metros que
	 * pueden variar dependiendo del pa�s del usuario o aplicaci�n que lo invoque. 
	 * @param name nombre del par�metro.
	 * @param country pa�s para el que el par�metro aplica.
	 * @param application aplicaci�n para la que el par�metro aplica.
	 * @return valor del par�metro solicitado.
	 * @see InitParameterMapBean#getValue(String)
	 * @throws java.lang.NullPointerException
	 */
	public String getValue(String name, String country, String application) {
		boolean found = false;
		String paramName = null;
		if (null != name && !GenericValidator.isBlankOrNull(country)) {
			if (!GenericValidator.isBlankOrNull(application)) {
				// busca con pa�s y aplicaci�n.
				paramName = name.concat(SEPARATOR).concat(country).concat(SEPARATOR).concat(application);
				found = this.containsKey(paramName);
			}
			if (!found) {
				// busca solo con pa�s.
				paramName = name.concat(SEPARATOR).concat(country);
				found = this.containsKey(paramName);
			}
		}
		if (!found) {
			if (!GenericValidator.isBlankOrNull(application)) {
				// busca s�lo con aplicaci�n.
				paramName = name.concat(SEPARATOR).concat(application);
				found = this.containsKey(paramName);
			}
			if (!found) {
				// toma s�lo el nombre del par�metro. 
				paramName = name;
			}
		}
		return this.getValue(paramName);
	}
}