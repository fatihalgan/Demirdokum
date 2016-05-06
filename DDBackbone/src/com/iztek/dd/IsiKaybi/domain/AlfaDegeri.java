/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class AlfaDegeri {
    private String aciklama = "";
    private double alphaIc = 0;
    private double alphaDis = 0;    
       
    public AlfaDegeri(String aciklama, double alphaIc, double alphaDis){
        this.aciklama = aciklama;
        this.alphaIc = alphaIc;
        this.alphaDis = alphaDis;
    }
    /**
     * 
     */
    public AlfaDegeri() {
        
    }
    public String getAciklama() {
        return aciklama;
    }
    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    public double getAlphaDis() {
        return alphaDis;
    }
    public void setAlphaDis(double alphaDis) {
        this.alphaDis = alphaDis;
    }
    public double getAlphaIc() {
        return alphaIc;
    }
    public void setAlphaIc(double alphaIc) {
        this.alphaIc = alphaIc;
    }
}
