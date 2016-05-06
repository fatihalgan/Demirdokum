/*
 * Created on 07.Oca.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author Burak AYDIN
 *
 */
public class CogunluklaKullanilanYapiElemanlari {
    private boolean dirty = false;
	private ArrayList yapiElemanlari = new ArrayList();
	private static CogunluklaKullanilanYapiElemanlari instance = null;
	
	/**
	 * 
	 */
	private CogunluklaKullanilanYapiElemanlari() {
		yapiElemanlari = PersistenceManagerInt.INSTANCE.loadCogunluklaKullanilanYapiElemanlari();
	}
	
	public static CogunluklaKullanilanYapiElemanlari getInstance(){
		if(instance == null) instance = new CogunluklaKullanilanYapiElemanlari();
		return instance;
	}
	
	public void addYapiElemani(YapiElemani ye) {
		yapiElemanlari.add(ye);
		dirty=true;
	}
	public void removeYapiElemani(int index){
	    yapiElemanlari.remove(index);
	    dirty=true;
	}
	public Collection getYapiElemanlari() {
		return yapiElemanlari;
	}
	public void serializeSelfToXML(){
	    PersistenceManagerInt.INSTANCE.serializeCogunluklaKullanilanYapiElemanlari(yapiElemanlari);
	    dirty=false;
	}
}
