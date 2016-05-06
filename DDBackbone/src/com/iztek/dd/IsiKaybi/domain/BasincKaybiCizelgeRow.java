/*
 * Created on 09.Oca.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BasincKaybiCizelgeRow {

	private int ID;
	private double basincKaybi;
	private double isiYuku;
	private double suHizi;
	private double boruCapi;
	/**
	 * 
	 */
	public BasincKaybiCizelgeRow() {
		super();
	}
	
	public BasincKaybiCizelgeRow(double basincKaybi, double isiYuku, double suHizi, double boruCapi) {
		this.basincKaybi = basincKaybi;
		this.isiYuku = isiYuku;
		this.suHizi = suHizi;
		this.boruCapi = boruCapi;
	}
	
	/**
	 * @return Returns the iD.
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param id The iD to set.
	 */
	public void setID(int id) {
		ID = id;
	}

	/**
	 * @return Returns the basincKaybi.
	 */
	public double getBasincKaybi() {
		return basincKaybi;
	}
	
	/**
	 * @return Returns the boruCapi.
	 */
	public double getBoruCapi() {
		return boruCapi;
	}
	
	/**
	 * @return Returns the isiYuku.
	 */
	public double getIsiYuku() {
		return isiYuku;
	}
	
	/**
	 * @return Returns the suHizi.
	 */
	public double getSuHizi() {
		return suHizi;
	}
	
	

}
