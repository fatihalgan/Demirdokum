/*
 * Created on 27.Ara.2004
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Selim HENDRICKSON
 *
 */
public abstract class YapiElemani implements IsiKaybeden{
    private int id = 0;
    private String yapiElemaniKodu = "";
	private String yapiElemaniAdi;
	private double uzunluk = 0;
    private double yukseklik = 0;
    private double isiGecirgenlikKatsayisi = 0; //U
    private double lambda = 0;
	private double kalinlik = 0; //d
	private double icSicaklik = 0;
    private double disSicaklik = 0;
    private double alan = 0;
    private double isiFarki = 0;
    public double isiKaybi = 0;
    private double icYuzeyselIsiIletimKatsayisi = 0;
    private double disYuzeyselIsiIletimKatsayisi = 0;
    
//    private ArrayList malzemeler = new ArrayList();
    
    public static final String[] DIS_DUVAR_KODLAR = new String[]{"DD"};
    public static final String[] IC_DUVAR_KODLAR = new String[]{"ÝD"};
    public static final String[] PENCERE_KODLAR = new String[]{"TP", "ÇCP", "ÇP"};
    public static final String[] DIS_KAPI_KODLAR = new String[]{"DK"};
    public static final String[] IC_KAPI_KODLAR = new String[]{"ÝK"};

    //********************************************************************************************************
	// Business Methods **************************************************************************************
	//********************************************************************************************************
   
    public double hesaplaIsiFarki() {
    	isiFarki = getIcSicaklik() - getDisSicaklik();
        return isiFarki;
    }
    
    public double hesaplaAlan(){
        alan = getUzunluk() * getYukseklik();
        return alan;
    }
    
    public abstract double hesaplaIsiKaybi();

//    public double hesaplaIsiGecirgenlikKatsayisi(){
//		double isiGecirgenlikKatsayisi = 0;
//		
//		isiGecirgenlikKatsayisi = hesaplaMalzemelerinIsýGecirgenlikDirenci();
//		isiGecirgenlikKatsayisi += getIcYuzeyselIsiIletimKatsayisi() + getDisYuzeyselIsiIletimKatsayisi();
//		return isiGecirgenlikKatsayisi;    
//    }
    
	//********************************************************************************************************
	// Accessor & Mutator Methods*****************************************************************************
	//********************************************************************************************************

    
//	private double hesaplaMalzemelerinIsýGecirgenlikDirenci() {
//	    double isiGecirgenlikDirenci = 0;
//        Iterator it = malzemeler.iterator();
//        while(it.hasNext()){
//            isiGecirgenlikDirenci += ((Malzeme)it.next()).hesaplaIsiGecirgenlikDirenci();
//        }
//        return isiGecirgenlikDirenci;
//    }

    public String getYapiElemaniKodu() {
		return yapiElemaniKodu;
	}

	public void setYapiElemaniKodu(String yapiElemaniKodu) {
		this.yapiElemaniKodu = yapiElemaniKodu;
	}

	public String getYapiElemaniAdi() {
		return yapiElemaniAdi;
	}
	
	public void setYapiElemaniAdi(String yapiElemaniAdi) {
		this.yapiElemaniAdi = yapiElemaniAdi;
	}
	   
    public double getKalinlik() {
        return kalinlik;
    }

    public void setKalinlik(double kalinlik) {
        this.kalinlik = kalinlik;
    }

    public double getDisSicaklik() {
        return disSicaklik;
    }

    public void setDisSicaklik(double disSicaklik) {
        this.disSicaklik = disSicaklik;
    }

    public double getIcSicaklik() {
        return icSicaklik;
    }

    public void setIcSicaklik(double icSicaklik) {
        this.icSicaklik = icSicaklik;
    }
    
    public double getIsiGecirgenlikKatsayisi() {
        return isiGecirgenlikKatsayisi;
    }
    
    public void setIsiGecirgenlikKatsayisi(double isiGecirgenlikKatsayisi) {
        this.isiGecirgenlikKatsayisi = isiGecirgenlikKatsayisi;
    }
        
	public double getLambda() {
		return lambda;
	}
	
	public void setLambda(double lambda) {
		this.lambda = lambda;
	}
	
    public double getUzunluk() {
        return uzunluk;
    }
    
    public void setUzunluk(double uzunluk) {
        this.uzunluk = uzunluk;
    }
    
    public double getYukseklik() {
        return yukseklik;
    }
    
    public void setYukseklik(double yukseklik) {
        this.yukseklik = yukseklik;
    }
           
    public static Collection filterByKodlar(Collection yapiElemanlari, String[] kodlar){
    	ArrayList elemanlari = new ArrayList();
    	
    	for (Iterator iter = yapiElemanlari.iterator(); iter.hasNext();) {
			YapiElemani yapiElemani = (YapiElemani) iter.next();
			
			for (int i = 0; i < kodlar.length; i++) {
			    if ( yapiElemani.getYapiElemaniKodu().substring(0, 2).equals(kodlar[i]) ){
					elemanlari.add(yapiElemani);
					break;
			    }
            }
		}
    	
    	return elemanlari;
    }
        
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
 
	public double getAlan() {
		return alan;
	}

	public void setAlan(double alan) {
		this.alan = alan;
	}
	
	public double getIsiFarki() {
		return isiFarki;
	}

	public void setIsiFarki(double isiFarki) {
		this.isiFarki = isiFarki;
	}

	public double getIsiKaybi() {
		return isiKaybi;
	}

	public void setIsiKaybi(double isiKaybi) {
		this.isiKaybi = isiKaybi;
	}

	public String toString(){
		return getYapiElemaniKodu();
	}

	public String getTurByKod() {
	    if(!getYapiElemaniKodu().equals("")){
			if(getYapiElemaniKodu().substring(0, 2).equals("Dö")) return "Döþeme";
			if(getYapiElemaniKodu().substring(0, 2).equals("BK")) return "Bahçe kapýsý";
			if(getYapiElemaniKodu().substring(0, 2).equals("DD")) return "Dýþ duvar"; 
			if(getYapiElemaniKodu().substring(0, 2).equals("ÝD")) return "Ýç duvar";
			if(getYapiElemaniKodu().substring(0, 2).equals("TP")) return "Tek pencere";
			if(getYapiElemaniKodu().substring(0, 3).equals("ÇCP")) return "Çift camlý pencere";
			if(getYapiElemaniKodu().substring(0, 2).equals("ÇP")) return "Çift pencere";
			if(getYapiElemaniKodu().substring(0, 2).equals("DK")) return "Dýþ kapý";
			if(getYapiElemaniKodu().substring(0, 2).equals("ÝK")) return "Ýç kapý";
			if(getYapiElemaniKodu().substring(0, 2).equals("Ta")) return "Tavan";	        
	    }
		return "Bilinmiyor";
	}
	
    public double getDisYuzeyselIsiIletimKatsayisi() {
        return disYuzeyselIsiIletimKatsayisi;
    }
    public void setDisYuzeyselIsiIletimKatsayisi(
            double disYuzeyselIsiIletimKatsayisi) {
        this.disYuzeyselIsiIletimKatsayisi = disYuzeyselIsiIletimKatsayisi;
    }
    public double getIcYuzeyselIsiIletimKatsayisi() {
        return icYuzeyselIsiIletimKatsayisi;
    }
    public void setIcYuzeyselIsiIletimKatsayisi(
            double icYuzeyselIsiIletimKatsayisi) {
        this.icYuzeyselIsiIletimKatsayisi = icYuzeyselIsiIletimKatsayisi;
    }
//    public ArrayList getMalzemeler() {
//        return malzemeler;
//    }
//    public void addMalzeme(Malzeme malzeme){
//        malzemeler.add(malzeme);
//    }
}
