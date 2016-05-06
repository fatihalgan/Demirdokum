package com.iztek.dd.rapor.zetacizelgesi;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import com.iztek.dd.ProjectController;
import com.iztek.dd.domain.Bina;
import com.iztek.dd.rapor.CompileReport;
import com.iztek.dd.rapor.ExportReport;
import com.iztek.dd.rapor.FillReport;
import com.iztek.dd.rapor.ReportInterface;

public class ZetaCizelgesiReport implements ReportInterface {
	private ProjectController controller = null;
	
	public ZetaCizelgesiReport(ProjectController controller){
		this.controller = controller;
	}
		
	public void getReport(String outputPath){
		String xmlFileName = "rpt/ZetaCizelgesi";
		boolean flag = true;
		String type = "pdf";

		try {
			File jasperFile = new File(xmlFileName + ".jasper");
			if (!jasperFile.exists()) {
				System.out.println("Compiling, please wait...");	
				flag = CompileReport.compileReport(xmlFileName);
			}
			if (flag) {
				System.out.println("Filling, please wait...");
				Bina bina = controller.ts825controller.bina;				
				Map parameters = new HashMap(); 
				parameters.put("ProjeAdi", controller.proje.getProjeAdi());
				parameters.put("Bayii", controller.proje.getProjeMuhendisiAdiSoyadi());
				flag = FillReport.fillReport(xmlFileName, parameters, new ZetaCizelgesiDS(controller));
				if (flag) {
					System.out.println("Exporting, please wait...");
					flag = ExportReport.exportReport(xmlFileName, type, outputPath);
					if (!flag) {
						throw new Exception("An error occured while exporting xml file as "+type);
					}
				} else {
					throw new Exception("An error occured while filling xml file with data.");
				}
				System.out.println("Reporting process is completed successfully.");
			} else {
				throw new Exception("An error occured while compiling xml file.");
			}
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}