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
public class SurtunmeDirenciYaratan {

	private String tip;
	private ZetaDirenciPolicy policy;
	
	/**
	 * 
	 */
	public SurtunmeDirenciYaratan(String tip) {
		super();
		this.tip = tip;
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
	 * @return Returns the zDirenci.
	 */
	public double getZetaDirenci(double boruCapi) {
		double zetaValue = getPolicy().getZetaValue(boruCapi);
		return zetaValue;
	}
	
	private ZetaDirenciPolicy getPolicy() {
		return ZDirencleri.getInstance().getZDirenciPolicy(tip);
	}
}
