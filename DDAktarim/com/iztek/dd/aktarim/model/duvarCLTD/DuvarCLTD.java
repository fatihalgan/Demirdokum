/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.aktarim.model.duvarCLTD;

import java.util.ArrayList;


/**
 * @author Selim HENDRICKSON
 *
 */
public class DuvarCLTD {
	
	private String yon = "";
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
	private ArrayList gunesZamanlari = new ArrayList();
	
	/**
	 * @param gunesZamanlari The gunesZamanlari to set.
	 */
	public void setGunesZamanlari(ArrayList gunesZamanlari) {
		this.gunesZamanlari = gunesZamanlari;
	}
	/**
	 * @return Returns the gunesZamanlari.
	 */
	public ArrayList getGunesZamanlari() {
		return gunesZamanlari;
	}
	
	public void addGunesZamani(double value){
		gunesZamanlari.add(new Double(value));
	}
	
	public int getCLDTForSaat(int saat) {
		Double val = (Double)gunesZamanlari.get(saat -1);
		return val.intValue();
	}
	
	
}
