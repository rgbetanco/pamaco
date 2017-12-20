package com.nicahost.common.exception;
import com.nicahost.common.util.UniqueIdentifierGenerator;
/**
 * Excepci�n padre para todas las excepciones de SBE
 * @author hjiron
 * @version 1.0
 * Fecha: 07-09-2004
 */
public class SbeException extends Exception {
	/** C�digo de excepci�n. */
	protected String exceptionCode = null;
	/** C�digo de la excepci�n ligada. */
	protected String linkExceptionCode = null;
	/** C�digo de error de la excepci�n. */
	protected static final String SBE_ERROR_CODE = "sbe";
	/**
	 * Constructor por defecto. 
	 */
	public SbeException() {
		super();
		this.setExceptionCode(UniqueIdentifierGenerator.generateCode());
	}
	/**
	 * Construye una excepci�n con el mensaje de error
	 * @param msg Mensaje de error
	 */
	public SbeException(String msg) {
		super(msg);
		this.setExceptionCode(UniqueIdentifierGenerator.generateCode());
	}
	/**
	 * Construye una excepci�n con el mensaje de error y la excepci�n asociada
	 * @param message mensaje de error.
	 * @param cause <code>Throwable</code> con la excepci�n origen
	 */
	public SbeException(String message, Throwable cause) {
//super(message, cause);
		this.fillInStackTrace();
		if (cause instanceof SbeException) {
			this.setLinkExceptionCode(((SbeException) cause).getExceptionCode());
		}
		setExceptionCode(UniqueIdentifierGenerator.generateCode());
	}
	/**
	 * Construye una excepci�n a partir de otra excepci�n y encadena sus c�digos
	 * de excepci�n
	 * @param exception excepci�n previa.
	 */
	public SbeException(Exception exception) {
//super(exception);
		this.fillInStackTrace();
		if (exception instanceof SbeException) {
			this.setLinkExceptionCode(((SbeException) exception).getExceptionCode());
		}
		setExceptionCode(UniqueIdentifierGenerator.generateCode());
	}
	/**
	 * Retorna el c�digo de excepci�n
	 * @return <code>String</code>
	 */
	public String getExceptionCode() {
		return this.exceptionCode;
	}
	/**
	 * Retorna la excepci�n ligada
	 * @return <code>String</code>
	 */
	public String getLinkExceptionCode() {
		return this.linkExceptionCode;
	}
	/**
	 * Asigna el c�digo de excepci�n
	 * @param value con el c�digo de excepci�n
	 */
	public void setExceptionCode(String value) {
		this.exceptionCode = value;
	}
	/**
	 * Asigna la excepci�n ligada
	 * @param value C�digo de excepci�n ligada
	 */
	public void setLinkExceptionCode(String value) {
		this.linkExceptionCode = value;
	}
	/**
	 * Retorna el c�digo de error espec�fico de la excepci�n
	 * @return String, el c�digo de error de la excepci�n
	 */
	public String getErrorCode(){
		return SBE_ERROR_CODE;
	}
}
