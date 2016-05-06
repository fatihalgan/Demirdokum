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
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BasincKaybiCizelgesi {

	private Collection basincKaybiRows = new ArrayList();
	private static BasincKaybiCizelgesi instance = null; 
	/**
	 * 
	 */
	private BasincKaybiCizelgesi() {
		basincKaybiRows = PersistenceManagerInt.INSTANCE.loadBasincKaybiCizelgesi();
	}
	
	private BasincKaybiCizelgesi(Collection rows) {
		basincKaybiRows = rows;
	}
	
	public static BasincKaybiCizelgesi getInstance(){
		if(instance == null) instance = new BasincKaybiCizelgesi();
		return instance;
	}
	
	
	
	public void addBasincKaybiRow(BasincKaybiCizelgeRow row) {
		getBasincKaybiRows().add(row);
	}

	/**
	 * @return Returns the basincKaybiRows.
	 */
	public Collection getBasincKaybiRows() {
		return basincKaybiRows;
	}
	/**
	 * @param basincKaybiRows The basincKaybiRows to set.
	 */
	public void setBasincKaybiRows(Collection basincKaybiRows) {
		this.basincKaybiRows = basincKaybiRows;
	}
	
	public BasincKaybiCizelgesi findRowsByBaslangicBasincKaybi(double value) {
		Iterator it = getBasincKaybiRows().iterator();
		ArrayList returnValue = new ArrayList();
		while(it.hasNext()) {
			BasincKaybiCizelgeRow row = (BasincKaybiCizelgeRow)it.next();
			if(row.getBasincKaybi() == value) returnValue.add(row);
		}
		return new BasincKaybiCizelgesi(returnValue);
	}
	
	private void sort(Comparator comparator) {
		Collections.sort((List)getBasincKaybiRows(), comparator);
	}
	
	public BasincKaybiCizelgeRow findRowByNearestIsiYuku(double isiYuku) {
		sort(new BasincKaybiCizelgeComparator());
		Iterator it = getBasincKaybiRows().iterator();
		while(it.hasNext()) {
			BasincKaybiCizelgeRow row = (BasincKaybiCizelgeRow)it.next();
			if(row.getIsiYuku() > isiYuku) return row;
		}
		return null;
	}
	
	public BasincKaybiCizelgesi findRowsByBoruCapi(double value) {
		Iterator it = getBasincKaybiRows().iterator();
		ArrayList returnValue = new ArrayList();
		while(it.hasNext()) {
			BasincKaybiCizelgeRow row = (BasincKaybiCizelgeRow)it.next();
			if(row.getBoruCapi() == value) returnValue.add(row);
		}
		return new BasincKaybiCizelgesi(returnValue);
	}
}
