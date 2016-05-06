/*
 * Created on 18.Ara.2004
 *
 */
package com.iztek.dd.domain;

import java.text.DecimalFormat;
import java.util.Iterator;

import com.iztek.dd.domain.IsiGecirgenligi.IsiGecirgenligi;

/**
 * @author Selim HENDRICKSON
 *
 */
public class DisaAcikDuvar extends BinaDuvari implements Yogusabilen{
    DecimalFormat twoDigits = new DecimalFormat("0.000");
    
    public DisaAcikDuvar(String identifier,IsiGecirgenligi tip) {
        super(identifier,tip);
    }
    
    public double hesaplaYogusma() {
        return 0;
    }

	public void hesaplaOrtakYuzeylerinSicakliklari() {
		Iterator it = getBilesenler().iterator();
		double iceYakinTaraftakiSicaklik = hesaplaIcYuzeySicakligi();
		while(it.hasNext()){
			Bilesen bilesen = (Bilesen)it.next();
			bilesen.hesaplaOrtakYüzeylerinSýcakligi(iceYakinTaraftakiSicaklik,hesaplaIsiAkisi());
			bilesen.hesaplaDoymusSuBuhariBasinci();
			iceYakinTaraftakiSicaklik = bilesen.getDisaYakinTaraftakiSicaklik();
		}
	}    
	
    public String toString(){
        return "Dýþ havaya açýk duvar";
    }
	
   	public String getYogusmaCizelgesi(){
   	    String html = "";
    	hesaplaOrtakYuzeylerinSicakliklari();
//        Iterator it = getBilesenler().iterator();
//        while(it.hasNext()){
//            System.out.println(((Bilesen)it.next()).hesaplaDoymusSuBuhariBasinci());
//        }        
        
        html += "<html><head></head><body><table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">";
        html += "  <tr height=\"15\"><td colspan=\"2\">Sütun no</td><td width=\"26%\">1</td><td width=\"8%\">2</td><td width=\"8%\">3</td>"+
        		"<td width=\"9%\">4</td><td width=\"9%\">5</td><td width=\"11%\">6</td><td width=\"9%\">7</td><td width=\"10%\">8</td></tr>";
        html += "  <tr height=\"15\"><td width=\"4%\">Sýra no</td><td width=\"6%\">&nbsp;</td><td>Tabaka</td><td>Tabaka Kalýnlýðý</td>"+
        		"<td>Su buharý difüzyon direnç katsayýsý</td><td>Difüzyon dengi hava tabakasý kalýnlýðý</td><td>Isýl iletkenlik hesap deðeri</td>"+
        		"<td>Yüzeysel ýsýl iletim direnci, malzemenin ýsýl direnci</td><td>Sýcaklýk</td><td>Doymuþ su buharý basýncý</td></tr>";
        html += "  <tr height=\"15\"><td width=\"4%\" align=CENTER> - </td><td width=\"6%\" align=CENTER>&nbsp;</td><td align=CENTER> - </td><td align=CENTER> m </td>"+
				"<td align=CENTER> - </td><td align=CENTER> m </td><td align=CENTER>W/(m.K)</td>"+
				"<td align=CENTER>m2.K/W</td><td align=CENTER>\u00B0C</td><td align=CENTER>PA</td></tr>";
        
        html += "<tr height=\"15\"><td rowspan=\"2\">&nbsp;</td><td rowspan=\"2\">1/\u03b1i</td><td rowspan=\"2\">" +
           		"Ýç yüzeysel ýsýl iletim katsayýsý</td><td rowspan=\"2\">-</td><td rowspan=\"2\">-</td><td rowspan=\"2\">-</td>" +
           		"<td rowspan=\"2\">-</td><td rowspan=\"2\">"+twoDigits.format(getIsiGecirgenligi().getIC_YUZEYSEL_ISIL_ILETIM_DIRENCI())+"</td>";
        html += "<td>"+twoDigits.format(getYOGUSMA_IC_SICAKLIK())+"</td><td>"+twoDigits.format(getIC_DOYMUS_SU_BUHARI_BASINCI())+"</td></tr>";
        html += "<tr height=\"15\"><td rowspan=\"2\">"+twoDigits.format(hesaplaIcYuzeySicakligi())+"</td><td rowspan=\"2\">"+twoDigits.format(hesaplaIcYuzeySuBuhariBasinci())+"</td></tr>";

        Iterator it2 = getBilesenler().iterator();
        int index = 1;
        while(it2.hasNext()){
            Bilesen bilesen = (Bilesen)it2.next();
            html += "<tr height=\"15\"><td rowspan=\"2\">"+index+"</td><td rowspan=\"2\">&nbsp;</td>" +
            		"<td rowspan=\"2\">"+bilesen.getMalzemeCinsi()+"</td><td rowspan=\"2\">"+twoDigits.format(bilesen.getKalinlik())+"</td>" +
            		"<td rowspan=\"2\">"+twoDigits.format(bilesen.getSuBuhariDifuzyonDirenciKatsayisi())+"</td><td rowspan=\"2\">"+twoDigits.format(bilesen.hesaplaDifuzyonDengiHavaTabakasiKalinligi())+"</td><td rowspan=\"2\">"+twoDigits.format(bilesen.getIsiIletimKatsayisi())+"</td>" +
            		"<td rowspan=\"2\">"+twoDigits.format(bilesen.getKalinlik()/bilesen.getIsiIletimKatsayisi())+"</td></tr>";
            html += "  <tr height=\"15\"><td rowspan=\"2\">"+twoDigits.format(bilesen.getDisaYakinTaraftakiSicaklik())+"</td><td rowspan=\"2\">"+twoDigits.format(bilesen.getDoymusSuBuhariBasinci())+"</td></tr>";
            index++;
        }
        html += "<tr height=\"15\"><td rowspan=\"2\">&nbsp;</td><td rowspan=\"2\">1/\u03b1d</td><td rowspan=\"2\">" +
        		"Dýþ yüzeysel ýsýl iletim katsayýsý</td><td rowspan=\"2\">-</td><td rowspan=\"2\">-</td>" +
        		"<td rowspan=\"2\">-</td><td rowspan=\"2\">-</td><td rowspan=\"2\">"+twoDigits.format(getIsiGecirgenligi().getDIS_YUZEYSEL_ISIL_ILETIM_DIRENCI())+"</td></tr>";
        html += "<tr height=\"15\"><td>"+twoDigits.format(getSinirlamaSartlariDisSicaklik())+"</td><td>"+twoDigits.format(getDisDoymusSuBuhariBasinci())+"</td></tr>";
   	    return html;
    }
}
