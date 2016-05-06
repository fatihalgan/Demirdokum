/*
 * Created on 09.Oca.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ZDirencleri {

	private HashMap zDirencleri = null;
	private static ZDirencleri instance = null;
	/**
	 * 
	 */
	private ZDirencleri() {
		zDirencleri = PersistenceManagerInt.INSTANCE.loadZetaDirencleri();
	}
	
	public static ZDirencleri getInstance(){
		if(instance == null) instance = new ZDirencleri();
		return instance;
	}
	
	public ZetaDirenciPolicy getZDirenciPolicy(String key) {
		return (ZetaDirenciPolicy)zDirencleri.get(key);
	}
}
