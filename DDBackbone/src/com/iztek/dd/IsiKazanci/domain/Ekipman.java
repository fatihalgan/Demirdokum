/*
 * Created on 03.Mar.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Ekipman {
    private String ekipmanAdi = "";
    private double anmaGucu = 0;
    
    public Ekipman(String ekipmanAdi, double anmaGucu){
        this.ekipmanAdi = ekipmanAdi;
        this.anmaGucu = anmaGucu;
    }
    
    public double getAnmaGucu() {
        return anmaGucu;
    }
    public void setAnmaGucu(double anmaGucu) {
        this.anmaGucu = anmaGucu;
    }
    public String getEkipmanAdi() {
        return ekipmanAdi;
    }
    public void setEkipmanAdi(String cihazAdi) {
        this.ekipmanAdi = cihazAdi;
    }
    
    public String toString(){
        return ekipmanAdi+" - "+anmaGucu;        
    }
}
