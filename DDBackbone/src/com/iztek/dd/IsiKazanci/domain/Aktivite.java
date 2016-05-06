/*
 * Created on 17.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Aktivite {
    private String tip = "";
    private double duyulurIsi = 0;
    private double gizliIsi = 0;

    public Aktivite(String tip, double duyulurIsi, double gizliIsi){
        super();
        this.tip = tip;
        this.duyulurIsi = duyulurIsi;
        this.gizliIsi = gizliIsi;
    }
    
    public double getDuyulurIsi() {
        return duyulurIsi;
    }
    
    public void setDuyulurIsi(double duyulurIsi) {
        this.duyulurIsi = duyulurIsi;
    }
    
    public double getGizliIsi() {
        return gizliIsi;
    }
    
    public void setGizliIsi(double gizliIsi) {
        this.gizliIsi = gizliIsi;
    }
    
    public String getTip() {
        return tip;
    }
    
    public void setTip(String tip) {
        this.tip = tip;
    }
    
    public String toString(){
        return tip;
    }
}
