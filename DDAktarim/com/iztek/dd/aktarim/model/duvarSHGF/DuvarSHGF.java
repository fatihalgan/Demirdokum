package com.iztek.dd.aktarim.model.duvarSHGF;

import java.util.ArrayList;

public class DuvarSHGF {
	private ArrayList duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri = new ArrayList();

	/**
	 * @return Returns the duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri.
	 */
	public ArrayList getDuseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri() {
		return duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri;
	}

	/**
	 * @param duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri
	 *            The duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri to set.
	 */
	public void setDuseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri(
			ArrayList duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri) {
		this.duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri = duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri;
	}

	public void addDuseyVeYatayDuvarlarIcinMaxIsiKazancFaktoru(
			int duseyVeYatayDuvarlarIcinMaxIsiKazancFaktoru) {
		duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri.add(new Integer(
				duseyVeYatayDuvarlarIcinMaxIsiKazancFaktoru));
	}

	public int getSHGFForYon(String yon) {
		Integer i = (Integer) duseyVeYatayDuvarlarIcinMaxIsiKazancFaktorleri
				.get(getIntValueForYonler(yon));
		return i.intValue();
	}

	private int getIntValueForYonler(String yon) {
		int r = 0;
		if (yon.equalsIgnoreCase("k"))
			r = 0;
		else if (yon.equalsIgnoreCase("kkd"))
			r = 1;
		else if (yon.equalsIgnoreCase("kd"))
			r = 2;
		else if (yon.equalsIgnoreCase("dkd"))
			r = 3;
		else if (yon.equalsIgnoreCase("d"))
			r = 4;
		else if (yon.equalsIgnoreCase("dgd"))
			r = 5;
		else if (yon.equalsIgnoreCase("gd"))
			r = 6;
		else if (yon.equalsIgnoreCase("ggd"))
			r = 7;
		else if (yon.equalsIgnoreCase("g"))
			r = 8;
		else if (yon.equalsIgnoreCase("ggb"))
			r = 9;
		else if (yon.equalsIgnoreCase("gb"))
			r = 10;
		else if (yon.equalsIgnoreCase("bgb"))
			r = 11;
		else if (yon.equalsIgnoreCase("b"))
			r = 12;
		else if (yon.equalsIgnoreCase("bkb"))
			r = 13;
		else if (yon.equalsIgnoreCase("kb"))
			r = 14;
		else if (yon.equalsIgnoreCase("kkb"))
			r = 15;
		else if (yon.equalsIgnoreCase("yatay"))
			r = 16;
		return r;
	}

}