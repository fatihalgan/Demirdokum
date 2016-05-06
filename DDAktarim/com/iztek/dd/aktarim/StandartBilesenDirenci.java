/*
 * Created on 10.Þub.2005
 *
 */
package com.iztek.dd.aktarim;

/**
 * @author Selim HENDRICKSON
 *
 */
public class StandartBilesenDirenci {
	public String ad = "";
	public double direnc = 0;
	
	public StandartBilesenDirenci(String ad, double direnc){
		this.ad = ad;
		this.direnc = direnc;
	}	
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public double getDirenc() {
		return direnc;
	}
	public void setDirenc(double direnc) {
		this.direnc = direnc;
	}
	public String toString(){
		return ad;
	}
}
