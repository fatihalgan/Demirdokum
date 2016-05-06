/*
 * Created on 10.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class KatKaloriferiModeli implements IsiticiModeliInt {
	private String tip = "";
	private String modelAdi = "";
	private double guc = 0;
	private String imageFile = "";
	private double yakitTipi = 0;	
	
    public double getGuc() {
        return guc;
    }
    public void setGuc(double guc) {
        this.guc = guc;
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
    public String getImageFile() {
        return imageFile;
    }
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
    public double getYakitTipi() {
        return yakitTipi;
    }
    public void setYakitTipi(double yakitTipi) {
        this.yakitTipi = yakitTipi;
    }
}
