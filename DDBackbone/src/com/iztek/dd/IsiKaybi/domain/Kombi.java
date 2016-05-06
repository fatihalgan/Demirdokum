/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Kombi extends Isitici {
    private boolean hermetik = false;    
    
    public boolean isHermetik() {
        return hermetik;
    }
    public void setHermetik(boolean hermetik) {
        this.hermetik = hermetik;
    }
}
