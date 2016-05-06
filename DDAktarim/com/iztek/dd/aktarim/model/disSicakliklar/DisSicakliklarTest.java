
package com.iztek.dd.aktarim.model.disSicakliklar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DisSicakliklarTest {

	public static void main(String[] args) {
		
		Object o = DisSicakliklar.getInstance().getDataFromXml();
		System.out.println("object: "+o.getClass());
		
		HashMap hm = (HashMap)o;
		DisSicaklikDegerleri a = (DisSicaklikDegerleri)hm.get("Antalya");
		System.out.println(a.getMaksimumDisSicaklik()+" "+a.getDisOzgulNem()+" "+a.getGunlukSicaklikFarki());
		
		Collection col = hm.values();
		Iterator it = col.iterator();
		
		Set set = hm.keySet();
		Iterator itt = set.iterator();
		int i = 0;
		while(it.hasNext()){
			DisSicaklikDegerleri dsd = (DisSicaklikDegerleri)it.next();
			System.out.println(itt.next().toString()+": "+dsd.getMaksimumDisSicaklik()+" "+dsd.getDisOzgulNem()+" "+dsd.getGunlukSicaklikFarki());
			i++;
		
		}
	}
}
