/*
 * Created on 15.Ara.2004
 *
 */
package com.iztek.dd.domain;

import com.iztek.dd.domain.IsiGecirgenligi.IsiGecirgenligi;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Tavan extends BilesikYapiElemani implements Yogusabilen{
    public Tavan(IsiGecirgenligi tip) {
        super();
        this.tip = tip;
    }
    
	public double hesaplaYogusma() {
        return 0;
    }

	public void hesaplaOrtakYuzeylerinSicakliklari() {
	
	}

	public String toString(){
	    return "" + tip + " tavan";
	}

	public String getYogusmaCizelgesi() {
		return null;
	}
}
