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
public class BinaDuvari extends BilesikYapiElemani{
	public BinaDuvari(String identifier,IsiGecirgenligi tip) {
        super();
        setIdentifier(identifier);
        this.tip = tip; 
    }

	public String toString(){
	    return "" + tip + " duvar";
	}
}
