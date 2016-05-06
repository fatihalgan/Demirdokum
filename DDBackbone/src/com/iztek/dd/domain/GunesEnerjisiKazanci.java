/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.domain;

import com.iztek.dd.domain.IsinimSiddeti.GunesIsinimSiddeti;

/**
 * @author Selim HENDRICKSON
 *
 */
public class GunesEnerjisiKazanci {
    private static final double HESAP_KATSAYISI = 0.8;
	
    private String yon = null;
	
	private double gunesEnerjisiGecirmeFaktoru = 0;
	private double gunesIsinimiSiddeti = 0;
	private double pencereAlani = 0;

	/**
	 * @return Returns the gunesEnerjisiGecirmeFaktoru.
	 */
	public double getGunesEnerjisiGecirmeFaktoru() {
		return gunesEnerjisiGecirmeFaktoru;
	}
	/**
	 * @param gunesEnerjisiGecirmeFaktoru The gunesEnerjisiGecirmeFaktoru to set.
	 */
	public void setGunesEnerjisiGecirmeFaktoru(
			double gunesEnerjisiGecirmeFaktoru) {
		this.gunesEnerjisiGecirmeFaktoru = gunesEnerjisiGecirmeFaktoru;
	}
	/**
	 * @return Returns the gunesIsinimiSiddeti.
	 */
	public double readGunesIsinimiSiddeti(String ay,String yon) {
		double gunesIsinimSiddeti = GunesIsinimSiddeti.getInstance().getAyYonBazindaIsinimSiddeti(ay,yon);
		return gunesIsinimSiddeti;
	}
	/**
	 * @return Returns the pencereAlani.
	 */
	public double getPencereAlani() {
		return pencereAlani;
	}
	/**
	 * @param pencereAlani The pencereAlani to set.
	 */
	public void setPencereAlani(double pencereAlani) {
		this.pencereAlani = pencereAlani;
	}
	/**
	 * @return Returns the yon.
	 */
	public String getYon() {
		return yon;
	}
	/**
	 * @param yon The yon to set.
	 */
	public void setYon(String yon) {
		this.yon = yon;
	}
	
	public double hesaplaAylikGunesEnerjisi(String ay,double golgelemeFaktoru){
	    return golgelemeFaktoru * HESAP_KATSAYISI * getGunesEnerjisiGecirmeFaktoru() * readGunesIsinimiSiddeti(ay,getYon()) * getPencereAlani();
	}
	
	public double hesaplaGunesEnerjisiKazanci(double golgelemeFaktoru){
		double gunesEnerjisiKazanci = 0;
		
		for(int i=1;i<13;i++){
			gunesEnerjisiKazanci += hesaplaAylikGunesEnerjisi(""+i,golgelemeFaktoru); 
		}
		
		return gunesEnerjisiKazanci;
	}
}
