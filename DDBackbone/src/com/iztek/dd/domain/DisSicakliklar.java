/*
 * Created on 22.Ara.2004
 *
 */
package com.iztek.dd.domain;

import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;


/**
 * @author Selim HENDRICKSON
 *
 */
public class DisSicakliklar {
	private static HashMap aylar = null;
	private static DisSicakliklar instance = null;
	
	public DisSicakliklar(){
		aylar = PersistenceManagerInt.INSTANCE.loadDisSicakliklar();
	}

	public static DisSicakliklar getInstance(){
		if(instance==null) instance = new DisSicakliklar();
		return instance;
	}

	public double getAyBolgeBazindaDisSicaklik(String ay, String projeBolge) {
		HashMap bolgeler = (HashMap) aylar.get(ay);
		return ((Double)bolgeler.get(projeBolge)).doubleValue();
	}
}
