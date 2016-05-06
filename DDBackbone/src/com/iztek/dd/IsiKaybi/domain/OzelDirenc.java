/*
 * Created on 09.Oca.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OzelDirenc {

	private double zetaDirenci;
	private double hiz;
	private double ozelDirenc;
	/**
	 * 
	 */
	public OzelDirenc() {
		super();
	}
	
	public OzelDirenc(double zetaDirenci, double hiz, double ozelDirenc) {
		super();
		this.zetaDirenci = zetaDirenci;
		this.hiz = hiz;
		this.ozelDirenc = ozelDirenc;
	}

	/**
	 * @return Returns the hiz.
	 */
	public double getHiz() {
		return hiz;
	}
	/**
	 * @param hiz The hiz to set.
	 */
	public void setHiz(double hiz) {
		this.hiz = hiz;
	}
	/**
	 * @return Returns the ozelDirenc.
	 */
	public double getOzelDirenc() {
		return ozelDirenc;
	}
	/**
	 * @param ozelDirenc The ozelDirenc to set.
	 */
	public void setOzelDirenc(double ozelDirenc) {
		this.ozelDirenc = ozelDirenc;
	}
	/**
	 * @return Returns the zetaDirenci.
	 */
	public double getZetaDirenci() {
		return zetaDirenci;
	}
	/**
	 * @param zetaDirenci The zetaDirenci to set.
	 */
	public void setZetaDirenci(double zetaDirenci) {
		this.zetaDirenci = zetaDirenci;
	}
}
