package com.iztek.dd.aktarim.model.duvarSHGF;

import java.util.HashMap;

public class DuvarSHGFTest {

	public static void main(String[] args) {
		Object object = DuvarSHGFs.getInstance().readSelfFromXml();
		HashMap hm = (HashMap) object;
		String[] aylar = { "Ocak", "Subat", "Mart", "Nisan", "Mayis",
				"Haziran", "Temmuz", "Agustos", "Eylul", "Ekim", "Kasim",
				"Aralik" };
		String[] yonler = { "k", "KKD", "KD", "DKD", "d", "DGD", "GD", "GGD",
				"G", "ggb", "Gb", "bGB", "b", "BKB", "KB", "KKB", "YAtaY" };
		DuvarSHGF ad = null;
		for (int i = 0; i < aylar.length; i++) {
			ad = (DuvarSHGF) hm.get(aylar[i]);
			for (int j = 0; j < yonler.length; j++) {
				System.out.print("\t" + ad.getSHGFForYon(yonler[j]));
			}
			System.out.println("\t<" + aylar[i]);
		}
		System.out
				.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int k = 0; k < yonler.length; k++) {
			System.out.print("\t" + yonler[k].toUpperCase());
		}

	}
}