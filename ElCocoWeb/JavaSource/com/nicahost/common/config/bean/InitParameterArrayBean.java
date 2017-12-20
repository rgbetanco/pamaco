package com.nicahost.common.config.bean;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Vector de par�metros de inicializaci�n.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 02-12-2004
 */
public class InitParameterArrayBean extends ArrayList implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = -4306795561740500633L;
	/**
	 * Constructor por defecto.
	 */
	public InitParameterArrayBean() {
		super();
	}
	/**
	 * Agrega un par�metro al vector.
	 * @param name el nombre del par�metro.
	 * @param value el valor del par�metro.
	 */
	public void addParameter(String name, String value) {
		this.add(new InitParameterBean(name, value));
	}
	/**
	 * Obtiene un par�metro del vector.
	 * @param index posici�n del par�metro.
	 * @return <code>InitParameterBean</code> con el par�metro solicitado.
	 * @throws java.lang.IndexOutOfBoundsException
	 */
	public InitParameterBean getParameter(int index) {
		return (InitParameterBean) this.get(index);
	}
}
