/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.domain.Havalandirma;

/**
 * @author Selim HENDRICKSON
 *
 */
public class DogalHavalandirma extends HavalandirmaImpl{
	private static final double ROC = 0.33;

	public double getROC() {
		return ROC;
	}

	private double havaDegisimSayisi = 0;

	public double getHavaDegisimSayisi() {
		return havaDegisimSayisi;
	}

	public void setHavaDegisimSayisi(double havaDegisimSayisi) {
		this.havaDegisimSayisi = havaDegisimSayisi;
	}
	
	public double hesaplaHavalandirmaOzgulIsiKaybi() {		
		return getROC() * getHavaDegisimSayisi() * getHavalandirilanHacim(); 
	}
}
