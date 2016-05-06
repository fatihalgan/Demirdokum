/*
 * Created on 29.Ara.2004
 *
 */
package com.iztek.dd.utilities;

import java.awt.geom.Rectangle2D;

import com.iztek.dd.domain.Bolge;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Il {
	private Bolge bolge = null;
	private String ad = null;
	private Rectangle2D rectangle = null;
	private double isiKaybiDisSicaklik = 0;
	
	public Il(Bolge bolge, String ad, Rectangle2D rectangle, double isiKaybiDisSicaklik){
		this.bolge = bolge;
		this.ad = ad;
		this.rectangle = rectangle;
		this.isiKaybiDisSicaklik = isiKaybiDisSicaklik;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public Bolge getBolge() {
		return bolge;
	}
	
	public void setBolge(Bolge bolge) {
		this.bolge = bolge;
	}
	
	public Rectangle2D getRectangle() {
		return rectangle;
	}
	
	public void setRectangle(Rectangle2D rectangle) {
		this.rectangle = rectangle;
	}
	
	public String toString(){
	    return ad;
	}

	
    public double getIsiKaybiDisSicaklik() {
        return isiKaybiDisSicaklik;
    }
    public void setIsiKaybiDisSicaklik(double isiKaybiDisSicaklik) {
        this.isiKaybiDisSicaklik = isiKaybiDisSicaklik;
    }
}
