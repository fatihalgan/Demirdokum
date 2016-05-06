/*
 * Created on 14.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class KaskatSistem {
    private double largeSizeNumber = 0;
    private double smallSizeNumber = 0;
    private boolean hermetik = false;
    private boolean boylerli = false;
            
    public boolean isBoylerli() {
        return boylerli;
    }
    public void setBoylerli(boolean boylerli) {
        this.boylerli = boylerli;
    }
    public boolean isHermetik() {
        return hermetik;
    }
    public void setHermetik(boolean hermetik) {
        this.hermetik = hermetik;
    }
    public double getLargeSizeNumber() {
        return largeSizeNumber;
    }
    public void setLargeSizeNumber(double largeSizeNumber) {
        this.largeSizeNumber = largeSizeNumber;
    }
    public double getSmallSizeNumber() {
        return smallSizeNumber;
    }
    public void setSmallSizeNumber(double smallSizeNumber) {
        this.smallSizeNumber = smallSizeNumber;
    }
}
