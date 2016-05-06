package com.iztek.dd.rapor;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

public class ExportReport {
	public static boolean exportReport(
		String xmlFileName,
		String type,
		String outputPath) {
		boolean flag = true;
		try {
			if (type.equals("pdf")) {
				JasperExportManager.exportReportToPdfFile(
					xmlFileName + ".jrprint",outputPath+"."+type);
			} 
		} catch (JRException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
}
