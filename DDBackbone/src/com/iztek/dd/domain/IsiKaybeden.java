/*
 * Created on 15.Ara.2004
 *
 */
package com.iztek.dd.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public interface IsiKaybeden {
	public double hesaplaIsiGecirgenlikDirenci(); // 1/U
	public double getIsiGecirgenlikKatsayisiCarpiHesapKatsayisi(); // KATSAYI * U
	public double hesaplaOzgulIletimselIsiKaybi();  // KATSAYI * U * A
	public double getAlan();
	public double getIsiGecirgenlikKatsayisi();
	public String getIdentifier();
}
