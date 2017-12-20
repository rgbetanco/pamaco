/*
 * Created on Oct 4, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.service;

/**
 * @author Ronald
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ResStatistics {
	private static final String reporteDef = "C:\\Reportes\\Statistics2.jasper";
	private Map Parameter = new HashMap();

	public ResStatistics(String dateIni, String dateFin, String clients, String roomDescription, Collection dtoReservations) {
		try {
			Parameter.put("dateIni", dateIni);
			Parameter.put("dateFin", dateFin);
			Parameter.put("clients", clients);
			Parameter.put("rooms", roomDescription);
			JasperPrint view = JasperFillManager.fillReport(reporteDef, 
							Parameter, new JRBeanCollectionDataSource(dtoReservations));
			
			//JRHtmlExporter export = new JRHtmlExporter();
			//export.setParameter(JRExporterParameter.JASPER_PRINT, view); 
			//export.setParameter(JRExporterParameter.OUTPUT_FILE,new File("c:/Statistics.html"));
			//C:\\projects\\playaelcoco.com\\ElCocoWeb\\WebContent\\jsp\\hotelreserve\\admin\\Statistics2.html
			//C:\\Documents and Settings\\Ronald\\My Documents\\IBM\\wsappdev51\\pamaco3\\ElCocoWeb\\WebContent\\jsp\\hotelreserve\\admin\\Statistics.html"
			JasperExportManager.exportReportToHtmlFile(view, "C:\\Documents and Settings\\Ronald\\My Documents\\IBM\\wsappdev51\\pamaco4\\ElCocoWeb\\WebContent\\jsp\\hotelreserve\\admin\\Statistics2.html");
			//export.exportReport();
			//JasperExportManager.exportReportToPdf(view);
		} catch (Exception ex) {
			ex.printStackTrace();
			//JOptionPane.showMessageDialog(null, "Error al exportar el archivo, probablemente el archivo esta ciendo accesado!!!");
		}
	}
}
