package com.iztek.dd.IsiKazanci.domain;

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
		if (yon.equalsIgnoreCase("Kuzey"))
			r = 0;
		else if (yon.equalsIgnoreCase("Kuzeykuzeydo�u"))
			r = 1;
		else if (yon.equalsIgnoreCase("Kuzeydo�u"))
			r = 2;
		else if (yon.equalsIgnoreCase("Do�ukuzeydo�u"))
			r = 3;
		else if (yon.equalsIgnoreCase("Do�u"))
			r = 4;
		else if (yon.equalsIgnoreCase("Do�ug�neydo�u"))
			r = 5;
		else if (yon.equalsIgnoreCase("G�neydo�u"))
			r = 6;
		else if (yon.equalsIgnoreCase("G�neyg�neydo�u"))
			r = 7;
		else if (yon.equalsIgnoreCase("G�ney"))
			r = 8;
		else if (yon.equalsIgnoreCase("G�neyg�neybat�"))
			r = 9;
		else if (yon.equalsIgnoreCase("G�neybat�"))
			r = 10;
		else if (yon.equalsIgnoreCase("Bat�g�neybat�"))
			r = 11;
		else if (yon.equalsIgnoreCase("Bat�"))
			r = 12;
		else if (yon.equalsIgnoreCase("Bat�kuzeybat�"))
			r = 13;
		else if (yon.equalsIgnoreCase("Kuzeybat�"))
			r = 14;
		else if (yon.equalsIgnoreCase("Kuzeykuzeybat�"))
			r = 15;
		else if (yon.equalsIgnoreCase("Yatay"))
			r = 16;
		return r;
	}

}