/*
 * Created on 09.Oca.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BoruYaricapinaGoreZPolicy implements ZetaDirenciPolicy {

	private HashMap yaricaplar = null;
	
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKaybi.domain.ZDirenciPolicy#getZValue()
	 */
	public double getZetaValue(double boruCapi) {
		Double returnValue = ((Double)yaricaplar.get(new Double(boruCapi)));
		if(returnValue == null) {
			Collection keys = yaricaplar.keySet();
			List list = new ArrayList(keys);
			Collections.sort(list);
			Iterator it = list.iterator();
			while(it.hasNext()) {
				Double cap = (Double)it.next();
				if(cap.doubleValue() > boruCapi) boruCapi = cap.doubleValue();
				break;
			}
			returnValue = ((Double)yaricaplar.get(new Double(boruCapi)));
		} 
		return returnValue.doubleValue();
	}

}
