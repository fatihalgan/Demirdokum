package com.iztek.dd.rapor;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public class CompileReport {
	public static boolean compileReport(String xmlFileName) {
		boolean flag = true;
		try {
			JasperCompileManager.compileReportToFile(xmlFileName + ".xml");
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
