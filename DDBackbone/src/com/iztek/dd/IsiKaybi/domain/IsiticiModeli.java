/*
 * Created on 11.Þub.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class IsiticiModeli {
	private String tip = "";
	private String modelAdi = "";
	private double guc = 0;
	private String yakitTipi = "";
	
	public IsiticiModeli(String tip, String modelAdi, String yakitTipi, double guc){
		this.tip = tip;
		this.modelAdi = modelAdi;
		this.yakitTipi = yakitTipi;
		this.guc = guc;
	}
	public double getGuc() {
		return guc;
	}
	public void setGuc(double guc) {
		this.guc = guc;
	}
	public String getModelAdi() {
		return modelAdi;
	}
	public void setModelAdi(String modelAdi) {
		this.modelAdi = modelAdi;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getYakitTipi() {
		return yakitTipi;
	}
	public void setYakitTipi(String yakitTipi) {
		this.yakitTipi = yakitTipi;
	}
	public String[] getTableRow(){
	    String[] row = {getTip(),getModelAdi(),""+getGuc()};
	    return row;
	}

}
