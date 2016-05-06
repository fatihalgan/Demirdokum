package com.iztek.dd.aktarim.model.aydinlatmaCLF;

import java.util.HashMap;

public class AydinlatmaCLF12Test {
	public static void main(String[] a) {
		Object object = AydinlatmaCLF12s.getInstance().readSelfFromXml();
		HashMap hm = (HashMap) object;
		AydinlatmaCLF12 ad = (AydinlatmaCLF12) hm.get("B");
		System.out.println("b22: "
				+ ad.getCLF12ForSaat(22));
	}
}