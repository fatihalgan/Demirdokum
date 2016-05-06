/*
 * Created on 08.Oca.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author db2admin
 *
 */
public class IcSicaklik {

	private String mahal;
	private String tip;
	private int sicaklik;
	/**
	 * 
	 */
	public IcSicaklik(String mahal, String tip, int sicaklik) {
		super();
		this.mahal = mahal;
		this.tip = tip;
		this.sicaklik = sicaklik;
	}

	/**
	 * @return Returns the mahal.
	 */
	public String getMahal() {
		return mahal;
	}
	
	/**
	 * @return Returns the sicaklik.
	 */
	public int getSicaklik() {
		return sicaklik;
	}
	
	/**
	 * @return Returns the tip.
	 */
	public String getTip() {
		return tip;
	}

    public static Collection filterByTip(Collection icSicakliklar, String tip){
    	ArrayList filtered = new ArrayList();
    	int debug = 0;
    	try{
        	for (Iterator iter = icSicakliklar.iterator(); iter.hasNext();) {
    			IcSicaklik icSicaklik = (IcSicaklik) iter.next();
    		    if ( icSicaklik.getTip().equalsIgnoreCase(tip) )
    		        filtered.add(icSicaklik);
    		}	
    	}catch(Throwable t){
    		System.out.println("Caught");
    	}
    	return filtered;
    }

}
