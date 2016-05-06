
package com.iztek.dd.aktarim.model.aydinlatmaCLF;

import java.util.ArrayList;

public class AydinlatmaCLF8 {
	private ArrayList isiklarYandiktanSonraGecenZamanlar = new ArrayList();

	public ArrayList getIsiklarYandiktanSonraGecenZamanlar() {
		return isiklarYandiktanSonraGecenZamanlar;
	}

	public void setIsiklarYandiktanSonraGecenZamanlar(ArrayList isiklarYandiktanSonraGecenZamanlar) {
		this.isiklarYandiktanSonraGecenZamanlar = isiklarYandiktanSonraGecenZamanlar;
	}

	public void addIsiklarGectiktenSonraGecenZaman(	double isiklarYandiktanSonraGecenZaman) {
		isiklarYandiktanSonraGecenZamanlar.add(new Double(isiklarYandiktanSonraGecenZaman));
	}

	public double getCLF8ForSaat(int saat) {
		Double val = (Double) isiklarYandiktanSonraGecenZamanlar.get(saat);
		return val.doubleValue();
	}
}