/*
 * Created on 06.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Malzeme {
    private String kod = "";
    private String malzemeAdi = "";
    private double lambda = 0;
    private double kalinlik = 0;
        
    public Malzeme(){
        super();
    }
    
    public Malzeme(double kalinlik, double lambda){
        this.kalinlik = kalinlik;
        this.lambda = lambda;
    }
    public String getKod() {
        return kod;
    }
    public void setKod(String kod) {
        this.kod = kod;
    }
    public double getLambda() {
        return lambda;
    }
    public void setLambda(double lambda) {
        this.lambda = lambda;
    }
    public String getMalzemeAdi() {
        return malzemeAdi;
    }
    public void setMalzemeAdi(String malzemeAdi) {
        this.malzemeAdi = malzemeAdi;
    }
    public double hesaplaIsiGecirgenlikKatsayisi() {
        return getKalinlik()/getLambda();
    }
    
    public double getKalinlik() {
        return kalinlik;
    }
    public void setKalinlik(double kalinlik) {
        this.kalinlik = kalinlik;
    }
    public Malzeme cloneSelf() {
        Malzeme malzeme = new Malzeme();
        malzeme.setKalinlik(getKalinlik());
        malzeme.setKod(getKod());
        malzeme.setLambda(getLambda());
        malzeme.setMalzemeAdi(getMalzemeAdi());
        return malzeme;
    }
}
