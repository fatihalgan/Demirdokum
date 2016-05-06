/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

import java.util.ArrayList;

/**
 * @author Selim HENDRICKSON
 *
 */
public class CatiCLTD {

	private String catiTipi = "";
	private double agirlik = 0;
	private double isiGecirgenlikKatsayisi = 0;
	private ArrayList gunesZamanlari = new ArrayList();
	
	
	/**
	 * @return Returns the gunesZamanlari.
	 */
	public ArrayList getGunesZamanlari() {
		return gunesZamanlari;
	}
	/**
	 * @param gunesZamanlari The gunesZamanlari to set.
	 */
	public void setGunesZamanlari(ArrayList gunesZamanlari) {
		this.gunesZamanlari = gunesZamanlari;
	}
	public double getAgirlik() {
		return agirlik;
	}
	public void setAgirlik(double agirlik) {
		this.agirlik = agirlik;
	}
	public String getCatiTipi() {
		return catiTipi;
	}
	public void setCatiTipi(String catiTipi) {
		this.catiTipi = catiTipi;
	}
	public double getIsiGecirgenlikKatsayisi() {
		return isiGecirgenlikKatsayisi;
	}
	public void setIsiGecirgenlikKatsayisi(double isiGecirgenlikKatsayisi) {
		this.isiGecirgenlikKatsayisi = isiGecirgenlikKatsayisi;
	}
	
	public void addGunesZamani(double gunesZamani){
		gunesZamanlari.add(new Double(gunesZamani));
	}
	
	public int getCLDTForSaat(int saat) {
		Double val = (Double)gunesZamanlari.get(saat -1);
		return val.intValue();
	}

	public String toString(){
	    return "<HTML>"+catiTipi+" U="+getIsiGecirgenlikKatsayisi()+" W/m<SUP>2</SUP>\u00B0C</HTML>";
	}
}
