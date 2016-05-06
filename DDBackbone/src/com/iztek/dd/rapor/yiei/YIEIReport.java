package com.iztek.dd.rapor.yiei;

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

public class YIEIReport implements ReportInterface {
	static DecimalFormat twoDigits = null;
	
	private ProjectController controller = null;
	
	public YIEIReport(ProjectController controller){
		this.controller = controller;
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		twoDigits = new DecimalFormat("##.##",symbols);
	}
	
	private Map getParameters(Bina bina) {
		Map parameters = new HashMap(); 
		parameters.put("OzgulIsiKaybi",""+twoDigits.format(bina.hesaplaToplamOzgulIsiKaybi()));
		
		parameters.put("OcakSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("1")));
		parameters.put("SubatSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("2")));
		parameters.put("MartSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("3")));
		parameters.put("NisanSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("4")));
		parameters.put("MayisSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("5")));
		parameters.put("HaziranSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("6")));
		parameters.put("TemmuzSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("7")));
		parameters.put("AgustosSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("8")));
		parameters.put("EylulSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("9")));
		parameters.put("EkimSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("10")));
		parameters.put("KasimSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("11")));
		parameters.put("AralikSicaklikFarki",""+twoDigits.format(bina.hesaplaAyaBolgeyeGoreSicaklikFarki("12")));
		
		parameters.put("OcakIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("1")));
		parameters.put("SubatIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("2")));
		parameters.put("MartIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("3")));
		parameters.put("NisanIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("4")));
		parameters.put("MayisIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("5")));
		parameters.put("HaziranIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("6")));
		parameters.put("TemmuzIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("7")));
		parameters.put("AgustosIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("8")));
		parameters.put("EylulIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("9")));
		parameters.put("EkimIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("10")));
		parameters.put("KasimIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("11")));
		parameters.put("AralikIsiKaybi",""+twoDigits.format(bina.hesaplaAylikIsiKaybi("12")));
		
		parameters.put("IcIsiKazanci",""+twoDigits.format(bina.hesaplaIcIsiKazanci()));
		
		parameters.put("OcakGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("1")));
		parameters.put("SubatGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("2")));
		parameters.put("MartGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("3")));
		parameters.put("NisanGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("4")));
		parameters.put("MayisGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("5")));
		parameters.put("HaziranGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("6")));
		parameters.put("TemmuzGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("7")));
		parameters.put("AgustosGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("8")));
		parameters.put("EylulGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("9")));
		parameters.put("EkimGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("10")));
		parameters.put("KasimGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("11")));
		parameters.put("AralikGunesKazanci",""+twoDigits.format(bina.hesaplaAylikGunesEnerjisiKazanci("12")));
		
		parameters.put("OcakToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("1")));
		parameters.put("SubatToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("2")));
		parameters.put("MartToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("3")));
		parameters.put("NisanToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("4")));
		parameters.put("MayisToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("5")));
		parameters.put("HaziranToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("6")));
		parameters.put("TemmuzToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("7")));
		parameters.put("AgustosToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("8")));
		parameters.put("EylulToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("9")));
		parameters.put("EkimToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("10")));
		parameters.put("KasimToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("11")));
		parameters.put("AralikToplam",""+twoDigits.format(bina.hesaplaToplamAylikIsiKazanci("12")));
		
		parameters.put("OcakKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("1")));
		parameters.put("SubatKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("2")));
		parameters.put("MartKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("3")));
		parameters.put("NisanKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("4")));
		parameters.put("MayisKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("5")));
		parameters.put("HaziranKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("6")));
		parameters.put("TemmuzKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("7")));
		parameters.put("AgustosKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("8")));
		parameters.put("EylulKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("9")));
		parameters.put("EkimKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("10")));
		parameters.put("KasimKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("11")));
		parameters.put("AralikKKO",""+twoDigits.format(bina.hesaplaKazancKullanimOrani("12")));
		
		parameters.put("OcakKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("1")));
		parameters.put("SubatKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("2")));
		parameters.put("MartKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("3")));
		parameters.put("NisanKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("4")));
		parameters.put("MayisKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("5")));
		parameters.put("HaziranKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("6")));
		parameters.put("TemmuzKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("7")));
		parameters.put("AgustosKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("8")));
		parameters.put("EylulKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("9")));
		parameters.put("EkimKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("10")));
		parameters.put("KasimKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("11")));
		parameters.put("AralikKazancFaktoru",""+twoDigits.format(bina.hesaplaAylikKazancKullanimFaktoru("12")));
		
		parameters.put("OcakIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("1")/1000));
		parameters.put("SubatIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("2")/1000));
		parameters.put("MartIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("3")/1000));
		parameters.put("NisanIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("4")/1000));
		parameters.put("MayisIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("5")/1000));
		parameters.put("HaziranIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("6")/1000));
		parameters.put("TemmuzIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("7")/1000));
		parameters.put("AgustosIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("8")/1000));
		parameters.put("EylulIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("9")/1000));
		parameters.put("EkimIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("10")/1000));
		parameters.put("KasimIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("11")/1000));
		parameters.put("AralikIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaAylikIsitmaEnerjisiIhtiyaci("12")/1000));
		
		parameters.put("ToplamIsitmaIhtiyaci",""+twoDigits.format(bina.hesaplaToplamYillikIsitmaEnerjisiIhtiyaci()/1000));
		parameters.put("ToplamIsiKaybiWatt",""+twoDigits.format(bina.hesaplaToplamYillikIsitmaEnerjisiIhtiyaci()/1000*0.278/1000));
		parameters.put("ToplamIsiIhtiyaciBoluToplamAlan",""+twoDigits.format(bina.hesaplaToplamYillikIsitmaEnerjisiIhtiyaci()/1000*0.278/1000/bina.hesaplaToplamAlan()));
		parameters.put("KullanimAlani",""+twoDigits.format(bina.hesaplaToplamAlan()));
		parameters.put("ToplamGucBoluBrutHacim",""+twoDigits.format(bina.hesaplaToplamYillikIsitmaEnerjisiIhtiyaci()/bina.getBrutHacim()));
		parameters.put("ToplamAlanBoluBrutHacim",""+twoDigits.format(bina.hesaplaToplamAlanBrutHacimOrani()));
		parameters.put("BolgeNo",""+bina.getProje().getBolge().getBolgeAdi()+".");
		parameters.put("StandartGucFormulu","64.29 A/V + 51.66");
		parameters.put("StandartGuc",twoDigits.format(bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci()));
		
		double qYil = 0;
		double toplamYillikIsitmaEnerjisIhtiyaci = bina.hesaplaToplamYillikIsitmaEnerjisiIhtiyaci()/1000 * 0.278 * 0.001;
		if(bina.getOdaYuksekligi()<=2.6) qYil = (toplamYillikIsitmaEnerjisIhtiyaci / bina.getBinaKullanimAlani()); 
		if(bina.getOdaYuksekligi()>2.6) qYil = (toplamYillikIsitmaEnerjisIhtiyaci / bina.getBrutHacim());

		if(qYil<bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci()){
		    String debug = ""+twoDigits.format(qYil)+" < "+twoDigits.format(bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci());
		    parameters.put("HesapFormulu",debug);
		    parameters.put("Sonuc","uygundur.");
		    parameters.put("BuyukKucukIsareti","<");
		}
		if(qYil>bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci()){
		    String debug = ""+twoDigits.format(toplamYillikIsitmaEnerjisIhtiyaci)+" > "+twoDigits.format(bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci());
		    parameters.put("HesapFormulu",debug);
		    parameters.put("Sonuc","uygun degildir.");
		    parameters.put("BuyukKucukIsareti",">");
		}
		
		return parameters;
	}
	
	public void getReport(String outputPath){
		String xmlFileName = "rpt/YIEI";
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

				flag = FillReport.fillReport(xmlFileName, getParameters(bina), new JREmptyDataSource());
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