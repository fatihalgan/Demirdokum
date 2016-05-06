/*
 * Created on 08.Oca.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKaybi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Radyator implements Serializable{

	private String model;
	private int yukseklik;
	private String tip;
	private double guc;
	private double hacim;
	private double genlesmeKatsayisi;
	/**
	 * 
	 */
	public Radyator() {
		super();
	}

	/**
	 * @return Returns the genlesmeKatsayisi.
	 */
	public double getGenlesmeKatsayisi() {
		return genlesmeKatsayisi;
	}
	/**
	 * @param genlesmeKatsayisi The genlesmeKatsayisi to set.
	 */
	public void setGenlesmeKatsayisi(double genlesmeKatsayisi) {
		this.genlesmeKatsayisi = genlesmeKatsayisi;
	}
	/**
	 * @return Returns the guc.
	 */
	public double getGuc() {
		return guc;
	}
	/**
	 * @param guc The guc to set.
	 */
	public void setGuc(double guc) {
		this.guc = guc;
	}
	/**
	 * @return Returns the hacim.
	 */
	public double getHacim() {
		return hacim;
	}
	/**
	 * @param hacim The hacim to set.
	 */
	public void setHacim(double hacim) {
		this.hacim = hacim;
	}
	/**
	 * @return Returns the model.
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model The model to set.
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return Returns the tip.
	 */
	public String getTip() {
		return tip;
	}
	/**
	 * @param tip The tip to set.
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}
	/**
	 * @return Returns the yukseklik.
	 */
	public int getYukseklik() {
		return yukseklik;
	}
	/**
	 * @param yukseklik The yukseklik to set.
	 */
	public void setYukseklik(int yukseklik) {
		this.yukseklik = yukseklik;
	}
	
    /* - */
    public static final String DOKME_DILIM_KOLON = "Dökme Dilim";
    public static final String DOKME_DILIM_PERKOLON = "Dökme Dilim Perkolon";
    public static final String DOKME_DILIM_RIDEM = "Dökme Dilim Ridem";
    public static final String DILIMLI_CELIK = "Dilimli Çelik";
    public static final String PANEL = "Panel";
    
    public static Collection filterByTip(Collection radyatorler, String tip){
    	ArrayList filtered = new ArrayList();
    	
    	for (Iterator iter = radyatorler.iterator(); iter.hasNext();) {
			Radyator radyator = (Radyator) iter.next();
		    if ( radyator.getTip().equalsIgnoreCase(tip) )
		        filtered.add(radyator);
		}
    	
    	return filtered;
    }
}
