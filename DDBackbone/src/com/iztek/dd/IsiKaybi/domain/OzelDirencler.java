/*
 * Created on 09.Oca.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Iterator;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OzelDirencler {

	private ArrayList ozelDirencler = new ArrayList();
	private static OzelDirencler instance = null;
	
	private OzelDirencler() {
		ozelDirencler = PersistenceManagerInt.INSTANCE.loadOzelDirencler();
	}
	
	public static OzelDirencler getInstance(){
		if(instance == null) instance = new OzelDirencler();
		return instance;
	}
	
	/**
	 * @return Returns the yapiElemanlari.
	 */
	public double getOzelDirenc(double hiz, double zetaDirenci) {
		Iterator it = ozelDirencler.iterator();
		while(it.hasNext()) {
			OzelDirenc direnc = (OzelDirenc)it.next();
			if(direnc.getHiz() == hiz && direnc.getZetaDirenci() == zetaDirenci) return direnc.getOzelDirenc();
		}
		return 0;
	}
}
