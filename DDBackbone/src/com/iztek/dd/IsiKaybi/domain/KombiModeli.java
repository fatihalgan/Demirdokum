/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class KombiModeli implements IsiticiModeliInt {
    private boolean hermetik = false;
    private double guc = 0;
    private String modelAdi = "";
    private String tip = "";
    private String imageFile = "";
    
    public KombiModeli(double guc,String modelAdi, String tip,boolean hermetik ){
        setGuc(guc);
        setModelAdi(modelAdi);
        setTip(tip);
        setHermetik(hermetik);
    }
    
    public double getGuc() {
        return guc;
    }
    public void setGuc(double guc) {
        this.guc=guc;
    }
    public String getModelAdi() {
        return modelAdi;
    }
    public void setModelAdi(String modelAdi) {
        this.modelAdi = modelAdi;
    }
    public String getTip() {
        return tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }
    public boolean isHermetik() {
        return hermetik;
    }
    public void setHermetik(boolean hermetik) {
        this.hermetik = hermetik;
    }    
    public String getImageFile() {
        return imageFile;
    }
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
