package com.iztek.dd.rapor.iikb;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

import com.iztek.dd.ProjectController;
import com.iztek.dd.domain.Bina;
import com.iztek.dd.rapor.CompileReport;
import com.iztek.dd.rapor.ExportReport;
import com.iztek.dd.rapor.FillReport;
import com.iztek.dd.rapor.ReportInterface;

public class IIKBReport implements ReportInterface {
	static DecimalFormat twoDigits = null;
	double qYil = 0;
	double qPrime = 0;
	
	private ProjectController controller = null;
	
	public IIKBReport(ProjectController controller){
		this.controller = controller;
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		twoDigits = new DecimalFormat("##.##",symbols);
	}
	
	private String determineBinaTipi(Bina bina) {
		String binaTipi = "";		
		double toplamYillikIsitmaEnerjisIhtiyaci = bina.hesaplaToplamYillikIsitmaEnerjisiIhtiyaci()/1000 * 0.278 * 0.001;
		if(bina.getOdaYuksekligi()<=2.6) qYil = (toplamYillikIsitmaEnerjisIhtiyaci / bina.getBinaKullanimAlani()); 
		if(bina.getOdaYuksekligi()>2.6) qYil = (toplamYillikIsitmaEnerjisIhtiyaci / bina.getBrutHacim());
		
		qPrime = bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci();
		if(qYil <=0.80*qPrime) {
			binaTipi = "ATipiBina";
		}else if(qYil <=0.90*qPrime){
			binaTipi = "BTipiBina";
		}else if(qYil <=0.99*qPrime) {
			binaTipi = "CTipiBina";
		}
		return binaTipi;
	}
	
	public void getReport(String outputPath){
		String xmlFileName = "rpt/IIKB";
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
				parameters.put("AdaParsel", bina.getProje().getAdaParsel());
			    parameters.put("BinaTanim", bina.getProje().getBinaTanim());
			    parameters.put("CaddeBina", bina.getProje().getCaddeBinaNumarasi());
			    parameters.put("SemtIlceIl", bina.getProje().getSemtÝlceÝl());
			    parameters.put("Yakit", bina.getProje().getYakitTuru());
			    parameters.put("ToplamAlan",""+twoDigits.format(bina.hesaplaToplamAlan()));
			    parameters.put("BrutHacim",""+twoDigits.format(bina.getBrutHacim()));
			    parameters.put("AlanHacimOran",""+twoDigits.format(bina.hesaplaToplamAlanBrutHacimOrani()));
			    parameters.put("KullanilabilirAlan",""+twoDigits.format(bina.getBinaKullanimAlani()));
			    determineBinaTipi(bina);
			    parameters.put("StandartIhtiyac",""+twoDigits.format(qPrime));
			    parameters.put("YillikIhtiyac",""+twoDigits.format(qYil));
			    parameters.put("Adi",bina.getProje().getProjeMuhendisiAdiSoyadi());
			    parameters.put("Soyadi","");
			    parameters.put("Unvani",bina.getProje().getProjeMuhendisiUnvani());
			    parameters.put(determineBinaTipi(bina), "X");
				flag = FillReport.fillReport(xmlFileName, parameters, new JREmptyDataSource());
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