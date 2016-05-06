package com.iztek.dd.IsiKazanci.domain;

import java.util.ArrayList;

public class AydinlatmaCLF12 {
	private ArrayList isiklarYandiktanSonraGecenZamanlar = new ArrayList();

	/**
	 * @return Returns the isiklarYandiktanSonraGecenZaman.
	 */
	public ArrayList getIsiklarYandiktanSonraGecenZamanlar() {
		return isiklarYandiktanSonraGecenZamanlar;
	}

	/**
	 * @param isiklarYandiktanSonraGecenZaman
	 *            The isiklarYandiktanSonraGecenZaman to set.
	 */
	public void setIsiklarYandiktanSonraGecenZamanlar(
			ArrayList isiklarYandiktanSonraGecenZamanlar) {
		this.isiklarYandiktanSonraGecenZamanlar = isiklarYandiktanSonraGecenZamanlar;
	}

	public void addIsiklarYandiktanSonraGecenZaman(
			double isiklarYandiktanSonraGecenZaman) {
		isiklarYandiktanSonraGecenZamanlar.add(new Double(
				isiklarYandiktanSonraGecenZaman));
	}

	public double getCLF12ForSaat(int saat) {
		Double d = (Double) isiklarYandiktanSonraGecenZamanlar.get(saat);
		return d.doubleValue();
	}

}