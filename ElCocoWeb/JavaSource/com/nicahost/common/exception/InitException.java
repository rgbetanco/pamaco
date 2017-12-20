/*
 * Created on Sep 9, 2004
 * Excepci�n para los procesos de inicializaci�n de clases
 */
package com.nicahost.common.exception;

/**
 * Excepci�n para los procesos de inicializaci�n de clases
 * @author hjiron
 * @version 1.0
 * Fecha: 09-09-2004
 */
public class InitException extends SbeException {	

	/**
	 * Constructor por defecto
	 */
	public InitException() {
		super();
	}

	/**
	 * Construye un excepci�n a partir de otra.
	 * @param exception excepci�n previa.
	 */
	public InitException(Exception exception) {
//		super(exception);
	}

	/**
	 * Construye una excepci�n con el mensaje de error
	 * @param msg Mensaje de error
	 */	
	public InitException(String msg) {
		super(msg);
	}
}
