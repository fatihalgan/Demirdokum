/*
 * Created on 18.Ara.2004
 *
 */
package com.iztek.dd.domain;

import com.iztek.dd.domain.IsiGecirgenligi.IsiGecirgenligi;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Taban extends BilesikYapiElemani{
    public Taban(IsiGecirgenligi tip) {
        super();
        this.tip = tip;
    }
    
    public String toString(){
        return "" + tip + " taban/döþeme";
    }
}
