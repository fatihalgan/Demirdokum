/*
 * Created on 10.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.iztek.dd.persistence.PersistenceManagerInt;



/**
 * @author Tekin Biçer
 *
 */
public class CamSCs {
	
	private HashMap camSCsHash = new HashMap();
	private static CamSCs instance = null;
	
	/**
	 * @return Returns the camSCs.
	 */
	private HashMap getCamSCsHash() {
		return camSCsHash;
	}
	
	private CamSCs(){
		super();
		instance = PersistenceManagerInt.INSTANCE.loadCamSCs();
	}
	
	public static CamSCs getInstance(){
		if(instance==null) new CamSCs();
		return instance;
	}
	
	
	
	public void addSCs(String camTipi,ArrayList camSCList){
		camSCsHash.put(camTipi,camSCList);
	}
	
	public CamSC getCamSC(String camTipi, double camKalinligi) {
		ArrayList camSCList = (ArrayList)camSCsHash.get(camTipi);
		if(camSCList!=null){
			Iterator it = camSCList.iterator();
			while (it.hasNext()) {
				CamSC element = (CamSC) it.next();
				if(element.getCamKalinligi()==camKalinligi)
					return element;
			}		  
		}
		return null;		  
	}
}
