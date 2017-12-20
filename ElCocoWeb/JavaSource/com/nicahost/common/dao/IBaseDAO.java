/*
 * Created on Sep 6, 2004
 * Interfece que define los m�todos b�sicos para un DAO
 */
package com.nicahost.common.dao;

import com.nicahost.common.exception.InitException;


/**
 * Interface que define los m�todos b�sicos para un DAO
 * @author hjiron
 * @version 1.0
 * Fecha: 16-09-2004
 */
public interface IBaseDAO {


	/**
	 * Permite inicializar un DAO con los par�metros necesarios
	 * @param properties Objeto con la configuraci�n necesaria para el DAO
	 * @throws InitException
	 */
	public void init(Object properties) throws InitException;


	/**
	 * Se encarga de liberar los recursos adquiridos por los DAOs
	 */
	public void destroy();
		
}