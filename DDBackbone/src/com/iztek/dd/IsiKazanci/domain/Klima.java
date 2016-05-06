/*
 * Created on 23.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

import java.io.Serializable;


/**
 * @author Selim HENDRICKSON
 *
 */
public class Klima implements Serializable{
    private String model = "";
    private int seri = 0;
    private double guc = 0;
    private String resimPath = "";
    
    public Klima(String model, int seri, double guc, String resimPath){
        this.model = model;
        this.seri = seri;
        this.guc = guc;
        this.resimPath = resimPath;
    }

    public double getGuc() {
        return guc;
    }
    public void setGuc(double guc) {
        this.guc = guc;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getResimPath() {
        return resimPath;
    }
    public void setResimPath(String resimPath) {
        this.resimPath = resimPath;
    }
    public int getSeri() {
        return seri;
    }
    public void setSeri(int seri) {
        this.seri = seri;
    }

    public String[] getTableRow() {
        String[] row = {getModel(),""+getGuc()};
        return row;
    }
}
