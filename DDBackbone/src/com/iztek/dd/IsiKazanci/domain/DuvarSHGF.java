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
		else if (yon.equalsIgnoreCase("Kuzeykuzeydoðu"))
			r = 1;
		else if (yon.equalsIgnoreCase("Kuzeydoðu"))
			r = 2;
		else if (yon.equalsIgnoreCase("Doðukuzeydoðu"))
			r = 3;
		else if (yon.equalsIgnoreCase("Doðu"))
			r = 4;
		else if (yon.equalsIgnoreCase("Doðugüneydoðu"))
			r = 5;
		else if (yon.equalsIgnoreCase("Güneydoðu"))
			r = 6;
		else if (yon.equalsIgnoreCase("Güneygüneydoðu"))
			r = 7;
		else if (yon.equalsIgnoreCase("Güney"))
			r = 8;
		else if (yon.equalsIgnoreCase("Güneygüneybatý"))
			r = 9;
		else if (yon.equalsIgnoreCase("Güneybatý"))
			r = 10;
		else if (yon.equalsIgnoreCase("Batýgüneybatý"))
			r = 11;
		else if (yon.equalsIgnoreCase("Batý"))
			r = 12;
		else if (yon.equalsIgnoreCase("Batýkuzeybatý"))
			r = 13;
		else if (yon.equalsIgnoreCase("Kuzeybatý"))
			r = 14;
		else if (yon.equalsIgnoreCase("Kuzeykuzeybatý"))
			r = 15;
		else if (yon.equalsIgnoreCase("Yatay"))
			r = 16;
		return r;
	}

}