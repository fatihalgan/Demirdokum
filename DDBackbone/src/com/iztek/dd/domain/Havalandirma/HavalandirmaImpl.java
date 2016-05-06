/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.domain.Havalandirma;

/**
 * @author Selim HENDRICKSON
 *
 */
public abstract class HavalandirmaImpl implements HavalandirmaInt{
	private static final double HESAP_KATSAYISI = 0.8;
	
	private double brutHacim = 0;
		
	public double getHavalandirilanHacim() {
		return getBrutHacim() * getHESAP_KATSAYISI();
	}
	public double getBrutHacim() {
		return brutHacim;
	}
	public void setBrutHacim(double brutHacim) {
		this.brutHacim = brutHacim;
	}
	public static double getHESAP_KATSAYISI() {
		return HESAP_KATSAYISI;
	}

}
