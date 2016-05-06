/*
 * Created on Mar 14, 2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class KaskatModeli implements IsiticiModeliInt{
    private double guc = 0;
    private String modelAdi = "";
    private String tip = "";
    private String imageFile = "";
    private boolean hermetik = false;
    private boolean boylerli = false;
    
    public KaskatModeli(double guc, String modelAdi, String tip, String imageFile,boolean hermetik, boolean boylerli){
        this.guc = guc;
        this.modelAdi = modelAdi;
        this.tip = tip;
        this.imageFile = imageFile;
        this.hermetik = hermetik;
        this.boylerli = boylerli;
    }
    
    public double getGuc() {
        return guc;
    }
    public void setGuc(double guc) {
        this.guc = guc;
    }
    public String getImageFile() {
        return imageFile;
    }
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
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
}
