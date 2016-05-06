/*
 * Created on 20.Ara.2004
 *
 */
package com.iztek.dd.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Pencere implements IsiKaybeden{
    private String identifier = "Pencere";
	private double isiGecirgenlikKatsayisi = 0;
	private double alan = 0;
	private final double HESAP_KATSAYISI = 1;  //Sadece anlaþýlabilir kalma amacý ile burada...
	
	public Pencere(){
		super();
	}
	
	public Pencere(double isiGecirgenlikKatsayisi, double toplamPencereAlani){
		super();
		this.isiGecirgenlikKatsayisi = isiGecirgenlikKatsayisi;
		this.alan = toplamPencereAlani;
	}
	
	public double hesaplaOzgulIletimselIsiKaybi() {
		return getIsiGecirgenlikKatsayisiCarpiHesapKatsayisi() * getAlan();
	}


	public double hesaplaIsiGecirgenlikDirenci() {
		return 0;
	}

	public double getAlan() {
		return alan;
	}

	public void setAlan(double toplamPencereAlani) {
		this.alan = toplamPencereAlani;
	}

	public void setIsiGecirgenlikKatsayisi(double isiGecirgenlikKatsayisi) {
		this.isiGecirgenlikKatsayisi = isiGecirgenlikKatsayisi;
	}

	public double getIsiGecirgenlikKatsayisiCarpiHesapKatsayisi() {
		return isiGecirgenlikKatsayisi * getHESAP_KATSAYISI();
	}

	public double getHESAP_KATSAYISI() {
		return HESAP_KATSAYISI;
	}
	
	public String getIdentifier(){
	    return identifier;
	}
	
	public String toString(){
	    return "Pencere";
	}
	
	public double getIsiGecirgenlikKatsayisi(){
	    return isiGecirgenlikKatsayisi;
	}
}
