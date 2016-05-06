/*
 * Created on 15.Ara.2004
 *
 */
package com.iztek.dd.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Bilesen {
	private double kalinlik = 0;
	private double isiIletimKatsayisi = 0; 
	private double suBuhariDifuzyonDirenciKatsayisi = 0;
	private double disaYakinTaraftakiSicaklik = 0;
	private double doymusSuBuhariBasinci = 0;
	
	private double A1 = 288.68;
	private double B1 = 1.098;
	private double N1 = 8.02;
	
	private double A2 = 4.689;
	private double B2 = 1.486;
	private double N2 = 12.30;

	private String malzemeCinsi = null;
	
	public Bilesen(){
		super();
	}
	
	public Bilesen(double kalinlik, double isiIletimKatsayisi){
		super();
		this.kalinlik = kalinlik;
		this.isiIletimKatsayisi = isiIletimKatsayisi;
	}

	//********************************************************************************************************
	// Business Methods **************************************************************************************
	//********************************************************************************************************

	public double hesaplaIsiGecirgenlikDirenci(){
		double isiGecirgenlikDirenci = getKalinlik()/getIsiIletimKatsayisi(); 
		return isiGecirgenlikDirenci;
	}
	
	public double hesaplaDifuzyonDengiHavaTabakasiKalinligi(){
		return getKalinlik() * getSuBuhariDifuzyonDirenciKatsayisi();
	}

	public void hesaplaOrtakYüzeylerinSıcakligi(double iceYakinTaraftakiSicaklik,double isiAkisi){
		this.disaYakinTaraftakiSicaklik = iceYakinTaraftakiSicaklik - (hesaplaIsiGecirgenlikDirenci()*isiAkisi);
	}
	
	//Ortak yüzeylerin sıcaklığı hesaplanmamışsa bu metod hatalı çalışır.
	public double hesaplaDoymusSuBuhariBasinci(){
		double a = 0;
		double b = 0;
		double n = 0;
		if(getDisaYakinTaraftakiSicaklik() >= 0 && getDisaYakinTaraftakiSicaklik() <= 30){
			a = getA1();
			b = getB1();
			n = getN1();
		}else{
			a = getA2();
			b = getB2();
			n = getN2();			
		}
		
		doymusSuBuhariBasinci = a * Math.pow( b + (getDisaYakinTaraftakiSicaklik()/100),n);
		return doymusSuBuhariBasinci;
	}
	
	public double hesaplaSuBuhariDifuzyonDirenci(){
		return 1.5 * 1000000 * hesaplaDifuzyonDengiHavaTabakasiKalinligi();
	}

	//********************************************************************************************************
	// Accessor & Mutator Methods*****************************************************************************
	//********************************************************************************************************

	public double getIsiIletimKatsayisi() {
		return isiIletimKatsayisi;
	}

	public double getKalinlik() {
		return kalinlik;
	}

	public void setIsiIletimKatsayisi(double d) {
		isiIletimKatsayisi = d;
	}

	public void setKalinlik(double d) {
		kalinlik = d;
	}

	public double getSuBuhariDifuzyonDirenciKatsayisi() {
		return suBuhariDifuzyonDirenciKatsayisi;
	}

	public void setSuBuhariDifuzyonDirenciKatsayisi(double suBuhariDifuzyonDirenci) {
		this.suBuhariDifuzyonDirenciKatsayisi = suBuhariDifuzyonDirenci;
	}
	
	public double getDisaYakinTaraftakiSicaklik() {
		return disaYakinTaraftakiSicaklik;
	}

	public double getA2() {
		return A2;
	}

	public double getB1() {
		return B1;
	}

	public double getB2() {
		return B2;
	}

	public double getDoymusSuBuhariBasinci() {
		return doymusSuBuhariBasinci;
	}

	public double getN1() {
		return N1;
	}

	public double getN2() {
		return N2;
	}

	public double getA1() {
		return A1;
	}
		
	public String getMalzemeCinsi() {
		return malzemeCinsi;
	}
	
	public void setMalzemeCinsi(String malzemeCinsi) {
		this.malzemeCinsi = malzemeCinsi;
	}
	
	
}
