/*
 * Created on 10.Þub.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.aktarim.model.aydinlatmaCLF;

import java.util.HashMap;

/**
 * @author TeKiN
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class IztekTest {

	public static void main(String[] args) {
		Object o = AydinlatmaCLF12s.getInstance().readSelfFromXml();
		System.out.println("object: "+o.getClass());
		
		HashMap hm = (HashMap)o;
		AydinlatmaCLF12 a = (AydinlatmaCLF12)hm.get("A");
		System.out.println("deger: "+a.getCLF12ForSaat(15));
	}
}
