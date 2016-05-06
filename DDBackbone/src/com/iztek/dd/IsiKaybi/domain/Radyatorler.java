/*
 * Created on 08.Oca.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Radyatorler {

	private ArrayList radyatorler = new ArrayList();
	private static Radyatorler instance = null;
	/**
	 * 
	 */
	private Radyatorler() {
		radyatorler = PersistenceManagerInt.INSTANCE.loadRadyatorler();
	}
	
	public static Radyatorler getInstance(){
		if(instance == null) instance = new Radyatorler();
		return instance;
	}
	
	public void addRadyator(Radyator radyator) {
		radyatorler.add(radyator);
	}
	
	public Collection getRadyatorler() {
		return radyatorler;
	}

}
