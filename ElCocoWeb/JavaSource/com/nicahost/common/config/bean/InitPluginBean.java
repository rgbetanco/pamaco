package com.nicahost.common.config.bean;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Informaci�n de inicializaci�n para el InitPlugin.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 01-12-2004
 *
 */
public class InitPluginBean implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = 1206345038491746490L;
	/** Mapa de par�metros de inicializaci�n. */
	private InitParameterMapBean initParameters;
	/** Lista de m�dulos de inicializaci�n. */
	private ArrayList modules;
	/**
	 * Constructor por defecto.
	 */
	public InitPluginBean() {
		this.initParameters = new InitParameterMapBean();
		this.modules = new ArrayList();
	}
	/**
	 * Obtiene los par�metros de inicializaci�n.
	 * @return par�metros de inicializaci�n.
	 */
	public InitParameterMapBean getInitParameters() {
		return this.initParameters;
	}
	/**
	 * Asigna los par�metros de inicializaci�n.
	 * @param value par�metros de inicializaci�n.
	 */
	public void setInitParameters(InitParameterMapBean value) {
		this.initParameters = value;
	}
	/**
	 * Agrega un m�dulo de inicializaci�n (<code>InitModuleBean</code>).
	 * @param bean m�dulo de inicializaci�n.
	 */
	public void addModule(InitModuleBean bean) {
		this.modules.add(bean);
	}
	/**
	 * Obtiene el <code>InitModuleBean</code> en la posici�n especificada.
	 * @param index la posici�n del m�dulo.
	 * @return el <code>InitModuleBean</code> solicitado.
	 * @throws java.lang.IndexOutOfBoundsException
	 */
	public InitModuleBean getModule(int index) {
		return (InitModuleBean) this.modules.get(index);
	}
	/**
	 * The ammount of modules in the collection.
	 * @return the ammount of modules in the collection.
	 */
	public int getModuleCount() {
		return this.modules.size();
	}
}
