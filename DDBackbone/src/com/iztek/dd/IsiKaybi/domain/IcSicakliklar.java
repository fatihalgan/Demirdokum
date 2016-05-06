/*
 * Created on 08.Oca.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author db2admin
 *
 */
public class IcSicakliklar {

	private ArrayList icSicakliklar = new ArrayList();
	private static IcSicakliklar instance = null;
	/**
	 * 
	 */
	private IcSicakliklar() {
		icSicakliklar = PersistenceManagerInt.INSTANCE.loadIcSicakliklar();
	}
	
	public static IcSicakliklar getInstance(){
		if(instance == null) instance = new IcSicakliklar();
		return instance;
	}
	
	public void addIcSicaklik(IcSicaklik is) {
		icSicakliklar.add(is);
	}
	
	public Collection getIcSicakliklar() {
		return icSicakliklar;
	}

}
