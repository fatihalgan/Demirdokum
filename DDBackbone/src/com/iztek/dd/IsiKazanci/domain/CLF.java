
package com.iztek.dd.IsiKazanci.domain;

import java.util.ArrayList;


public class CLF {
	private int hacimdeToplamkalmaSuresi;
	private ArrayList girdiktenSonraGecenZamanDegerleri=new ArrayList();
	
	
	/**
	 * @return Returns the girdiktenSonraGecenZamanlar.
	 */
	public ArrayList getGirdiktenSonraGecenZamanlar() {
		return girdiktenSonraGecenZamanDegerleri;
	}
	/**
	 * @param girdiktenSonraGecenZamanlar The girdiktenSonraGecenZamanlar to set.
	 */
	public void setGirdiktenSonraGecenZamanlar(
			ArrayList girdiktenSonraGecenZamanlar) {
		this.girdiktenSonraGecenZamanDegerleri = girdiktenSonraGecenZamanlar;
	}
	/**
	 * @return Returns the hacimdeToplamkalmaSuresi.
	 */
	public int getHacimdeToplamkalmaSuresi() {
		return hacimdeToplamkalmaSuresi;
	}
	/**
	 * @param hacimdeToplamkalmaSuresi The hacimdeToplamkalmaSuresi to set.
	 */
	public void setHacimdeToplamkalmaSuresi(int hacimdeToplamkalmaSuresi) {
		this.hacimdeToplamkalmaSuresi = hacimdeToplamkalmaSuresi;
	}
	
	public void addGecenZamanDegeri(double gecenZamanDegeri){
		girdiktenSonraGecenZamanDegerleri.add(new Double(gecenZamanDegeri));
	}
	
	public double getGecenZamanDegeri(int saat) {
		Double val = (Double)girdiktenSonraGecenZamanDegerleri.get(saat -1);
		return val.doubleValue();
	}
}
