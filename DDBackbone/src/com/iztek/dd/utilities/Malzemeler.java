package com.iztek.dd.utilities;

/*
 * Created on 21.Ara.2004
 *
 */

import com.iztek.dd.persistence.PersistenceManagerInt;
 

/**
 * @author Selim HENDRICKSON
 *
 */
public class Malzemeler {
	private static Malzeme rootMalzeme = null;
	private static Malzemeler instance = null;
	
	private Malzemeler(){
		rootMalzeme = PersistenceManagerInt.INSTANCE.loadMalzemeler();
	}
	
	public static Malzemeler getInstance(){
		if(instance == null) instance = new Malzemeler();
		return instance;
	}

	public Malzeme getRootMalzeme(){
		return rootMalzeme;
	}
}
