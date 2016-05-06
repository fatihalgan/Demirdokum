/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;


import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;



/**
 * @author Selim HENDRICKSON
 *
 */
public class DuvarCLTDs {
	private HashMap cltds = new HashMap();
	private static DuvarCLTDs instance = null;

	private DuvarCLTDs(){
	    cltds = PersistenceManagerInt.INSTANCE.loadDuvarCLTDs();
	}
	
	public static DuvarCLTDs getInstance(){
		if(instance == null) instance = new DuvarCLTDs();
		return instance;
	}
	
	public void addCLTD(String yon,DuvarCLTD cltd){
		cltds.put(yon,cltd);
	}
	

	public DuvarCLTD getDuvarCLDT(String yon) {
	    return (DuvarCLTD)cltds.get(yon);
	}
}
