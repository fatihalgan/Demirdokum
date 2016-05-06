/*
 * Created on 15.Ara.2004
 *
 */
package com.iztek.dd.domain;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.iztek.dd.domain.IsiGecirgenligi.IsiGecirgenligi;

/**
 * @author Selim HENDRICKSON
 *
 */
public abstract class BilesikYapiElemani implements IsiKaybeden{
	private final double YOGUSMA_IC_SICAKLIK = 20;
	private final double IC_SU_BUHARI_KISMI_BASINCI = 1170;
	private final double IC_BAGIL_NEM = 0.50;
	private final double DIS_BAGIL_NEM = 0.80;
	private final double IC_DOYMUS_SU_BUHARI_BASINCI = 2340;
	private final double YOGUSMA_SURESI = 1440;
	private final double BUHARLASMA_HAVA_SICAKLIGI = 12;
	private final double BUHARLASMA_BAGIL_NEM = 70;
	private final double BUHARLASMA_DOYMUS_SU_BUHARI_BASINCI = 1403;
	private final double BUHARLASMA_SU_BUHARI_KISMI_BASINCI = 982;
	private final double BUHARLASMA_SURESI = 2160;
	private double sinirlamaSartlariDisSicaklik = -3;
	
	private String identifier = "";
	private double alan = 0;
	private double disHavaSicakligi = 0;
	
	Collection bilesenler = new ArrayList();
	
	protected IsiGecirgenligi tip = null;
	
	//********************************************************************************************************
	// Business Methods **************************************************************************************
	//********************************************************************************************************

	public double hesaplaBilesenlerinIsýGecirgenlikDirenci() {
		double isiGecirgenlikDirenci = 0;
		 
		Collection bilesenler = getBilesenler();
		Iterator it = bilesenler.iterator();
		
		while(it.hasNext()){
			isiGecirgenlikDirenci += ((Bilesen)it.next()).hesaplaIsiGecirgenlikDirenci();	
		}
		
		return isiGecirgenlikDirenci;
	}

	public double hesaplaOzgulIletimselIsiKaybi() {
		return getIsiGecirgenlikKatsayisiCarpiHesapKatsayisi() * getAlan();
	}
	
	public double hesaplaBilesenlerinDifuzyonDengiHavaTabakasiKalinligi(){
		double difuzyonDengiHavaTabakasiKalinligi = 0;
		 
		Collection bilesenler = getBilesenler();
		Iterator it = bilesenler.iterator();
		
		while(it.hasNext()){
			difuzyonDengiHavaTabakasiKalinligi += ((Bilesen)it.next()).hesaplaDifuzyonDengiHavaTabakasiKalinligi();	
		}
		
		return difuzyonDengiHavaTabakasiKalinligi;
	}
	
	public double getIsiGecirgenlikKatsayisiCarpiHesapKatsayisi() {
		double isiGecirgenlikDirenci = hesaplaIsiGecirgenlikDirenci();		
		return tip.getHESAP_KATSAYISI()* getIsiGecirgenlikKatsayisi();
	}

	public double hesaplaIsiGecirgenlikDirenci() {
		double isiGecirgenlikKatsayisi = 0;
		
		isiGecirgenlikKatsayisi = hesaplaBilesenlerinIsýGecirgenlikDirenci();
		isiGecirgenlikKatsayisi += tip.getDIS_YUZEYSEL_ISIL_ILETIM_DIRENCI() + tip.getIC_YUZEYSEL_ISIL_ILETIM_DIRENCI();
		return isiGecirgenlikKatsayisi;
	}

	public double getIsiGecirgenlikKatsayisi() {
	    double isiGecirgenlikKatsayisi = (1/hesaplaIsiGecirgenlikDirenci());
		return isiGecirgenlikKatsayisi;
	}

	public double hesaplaIsiAkisi() {
		double isiAkisi = getIsiGecirgenlikKatsayisi() * (getYOGUSMA_IC_SICAKLIK() - getSinirlamaSartlariDisSicaklik());
		return isiAkisi;
	}

	public double hesaplaIcYuzeySicakligi() {
		return getYOGUSMA_IC_SICAKLIK() - (tip.getIC_YUZEYSEL_ISIL_ILETIM_DIRENCI() * hesaplaIsiAkisi());
	}

	public double hesaplaDisYuzeySicakligi() {
		return getDisHavaSicakligi() + (tip.getDIS_YUZEYSEL_ISIL_ILETIM_DIRENCI() * hesaplaIsiAkisi()); 
	}
	
	public double hesaplaIcYuzeySuBuhariBasinci(){
		double a = 0;
		double b = 0;
		double n = 0;
		if(hesaplaIcYuzeySicakligi() >= 0 && hesaplaIcYuzeySicakligi() <= 30){
			a = 288.68;
			b = 1.098;
			n = 8.02;
		}else{
			a = 4.689;
			b = 1.486;
			n = 12.30;			
		}
		
		return a * Math.pow( b + (hesaplaIcYuzeySicakligi()/100),n);
	}
	
	public Bilesen findYogusma(){
		Point2D.Double startPointForFirstLine = new Point2D.Double(0,hesaplaIcYuzeySuBuhariBasinci());
		Point2D.Double endPointForFirstLine = null;
		Point2D.Double startPointForSecondLine = new Point2D.Double(0,getIC_SU_BUHARI_KISMI_BASINCI());
		Point2D.Double endPointForSecondLine = new Point2D.Double(hesaplaBilesenlerinDifuzyonDengiHavaTabakasiKalinligi(),getDisSuBuhariKismiBasinci());
		Line2D.Double line2 = new Line2D.Double(startPointForSecondLine,endPointForSecondLine);
		Line2D.Double line1 = new Line2D.Double(startPointForFirstLine,endPointForFirstLine);
		
		Iterator it = getBilesenler().iterator();
		Bilesen bilesen = null;
		while(it.hasNext()){
			bilesen = (Bilesen)it.next();
			endPointForFirstLine = new Point2D.Double(bilesen.hesaplaDifuzyonDengiHavaTabakasiKalinligi(),bilesen.getDoymusSuBuhariBasinci());
			if(line1.intersectsLine(line2)){
				return bilesen;
			}
			startPointForFirstLine = (Point2D.Double) line1.getP2();
		}
		
		return null;
	}

	public double hesaplaYogusanSuKutlesi(Bilesen bilesen){
		return getYOGUSMA_SURESI() * (hesaplaDifuzyonAkisYogunluguFarki(bilesen));
	}
	
	public double hesaplaDifuzyonAkisYogunluguFarki(Bilesen bilesen){
		double difuzyonAkisYogunluguFarki = 0;
		Bilesen hesaplananBilesen = null;
		int index = ((ArrayList) getBilesenler()).indexOf(bilesen);
		for(int i=0;index<getBilesenler().size();i++){
			if(i==index) i++;
			hesaplananBilesen = (Bilesen)((ArrayList) getBilesenler()).get(i);
			double difuzyonAkisYogunlugu = hesaplaDifuzyonAkisYogunlugu(hesaplananBilesen);
			if(i<index) difuzyonAkisYogunluguFarki += difuzyonAkisYogunlugu;
			else difuzyonAkisYogunluguFarki -= difuzyonAkisYogunlugu;
		}
		return difuzyonAkisYogunluguFarki;
	}
	
	public double hesaplaDifuzyonAkisYogunlugu(Bilesen bilesen){
		double difuzyonAkisYogunlugu = 0;
		difuzyonAkisYogunlugu = (getIC_SU_BUHARI_KISMI_BASINCI() - bilesen.hesaplaDoymusSuBuhariBasinci()) / bilesen.hesaplaSuBuhariDifuzyonDirenci();
		return difuzyonAkisYogunlugu;
	}
	
	private double hesaplaBuharlasmaSuyuKutlesi(Bilesen bilesen){
		double toplamBuharlasmaAkisYogunlugu = 0;
		double hesaplananBuharlasmaAkisYogunlugu = 0;
		Bilesen hesaplananBilesen = null;
		int index = ((ArrayList) getBilesenler()).indexOf(bilesen);
		for(int i=0;index<getBilesenler().size();i++){
			if(i==index) i++;
			hesaplananBilesen = (Bilesen)((ArrayList) getBilesenler()).get(i);
			hesaplananBuharlasmaAkisYogunlugu = (getBUHARLASMA_DOYMUS_SU_BUHARI_BASINCI() - getBUHARLASMA_SU_BUHARI_KISMI_BASINCI())/bilesen.hesaplaSuBuhariDifuzyonDirenci();
			toplamBuharlasmaAkisYogunlugu += hesaplananBuharlasmaAkisYogunlugu;
		}
		return getBUHARLASMA_SURESI() * toplamBuharlasmaAkisYogunlugu;
	}
	
	public boolean kontrolYogusanSuKutlesi(){
		Bilesen bilesen = findYogusma();
		return(hesaplaBuharlasmaSuyuKutlesi(bilesen)>hesaplaYogusanSuKutlesi(bilesen));
	}

	//********************************************************************************************************
	// Accessor & Mutator Methods*****************************************************************************
	//********************************************************************************************************

	public Collection getBilesenler() {
		return bilesenler;
	}

	public void addBilesen(Bilesen bilesen){
		getBilesenler().add(bilesen);
	}

	public double getAlan() {
		return alan;
	}

	public void setAlan(double alan) {
		this.alan = alan;
	}

	public double getDisHavaSicakligi() {
		return disHavaSicakligi;
	}

	public void setDisHavaSicakligi(double disHavaSicakligi) {
		if(disHavaSicakligi == -3 || disHavaSicakligi == -10 )	this.disHavaSicakligi = disHavaSicakligi;
		else throw new RuntimeException("Dýþ hava sýcaklýðý standarta uygun deðil!");
	}

	public double getYOGUSMA_IC_SICAKLIK() {
		return YOGUSMA_IC_SICAKLIK;
	}
	
	public double getIC_SU_BUHARI_KISMI_BASINCI() {
		return IC_SU_BUHARI_KISMI_BASINCI;
	}
	
	public double getDisSuBuhariKismiBasinci(){
		double disHavaSicakligi = getSinirlamaSartlariDisSicaklik();
		return disHavaSicakligi == -3 ? 380 : 208;
	}
	
	public double getDIS_BAGIL_NEM() {
		return DIS_BAGIL_NEM;
	}
	
	public double getIC_BAGIL_NEM() {
		return IC_BAGIL_NEM;
	}

	public double getIC_DOYMUS_SU_BUHARI_BASINCI() {
		return IC_DOYMUS_SU_BUHARI_BASINCI;
	}

	public double getDisDoymusSuBuhariBasinci(){
		double disHavaSicakligi = getSinirlamaSartlariDisSicaklik();
		return disHavaSicakligi == -3 ? 476 : 260;
	}
	
	public double getYOGUSMA_SURESI() {
		return YOGUSMA_SURESI;
	}
	
	public double getBUHARLASMA_SURESI() {
		return BUHARLASMA_SURESI;
	}
		
	public double getBUHARLASMA_BAGIL_NEM() {
		return BUHARLASMA_BAGIL_NEM;
	}
	
	public double getBUHARLASMA_DOYMUS_SU_BUHARI_BASINCI() {
		return BUHARLASMA_DOYMUS_SU_BUHARI_BASINCI;
	}
	
	public double getBUHARLASMA_HAVA_SICAKLIGI() {
		return BUHARLASMA_HAVA_SICAKLIGI;
	}
	
	public double getBUHARLASMA_SU_BUHARI_KISMI_BASINCI() {
		return BUHARLASMA_SU_BUHARI_KISMI_BASINCI;
	}	
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
		
	public void setBilesenler(Collection bilesenler) {
		this.bilesenler = bilesenler;
	}

	
    public double getSinirlamaSartlariDisSicaklik() {
        return sinirlamaSartlariDisSicaklik;
    }
    public void setSinirlamaSartlariDisSicaklik(
            double sinirlamaSartlariDisSicaklik) {
        this.sinirlamaSartlariDisSicaklik = sinirlamaSartlariDisSicaklik;
    }
	public IsiGecirgenligi getIsiGecirgenligi(){
	    return tip;
	}
}
