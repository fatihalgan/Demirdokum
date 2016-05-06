/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.domain.IsinimSiddeti;

import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;
 

/**
 * @author Selim HENDRICKSON
 *
 */
public class GunesIsinimSiddeti {
	private static HashMap aylar = null;
	private static GunesIsinimSiddeti instance = null;
	
	private GunesIsinimSiddeti(){
		aylar = PersistenceManagerInt.INSTANCE.loadGunesIsinimSiddetleri();
	}
	
	public static GunesIsinimSiddeti getInstance(){
		if(instance == null) instance = new GunesIsinimSiddeti();
		return instance;
	}
	
	public double getAyYonBazindaIsinimSiddeti(String ay,String yon){
		HashMap yonler = (HashMap) aylar.get(ay);
		return ((Double)yonler.get(yon)).doubleValue();
	}
}
