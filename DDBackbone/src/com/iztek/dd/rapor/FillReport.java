package com.iztek.dd.rapor;

import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

public class FillReport {
	public static boolean fillReport(String xmlFileName, Map parameters, JRDataSource dataSource) {
		boolean flag = true;
		try {
			JasperFillManager.fillReportToFile(xmlFileName + ".jasper", parameters, dataSource);
		} catch (JRException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
}