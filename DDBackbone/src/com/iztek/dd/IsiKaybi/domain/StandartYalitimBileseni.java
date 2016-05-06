/*
 * Created on 10.Þub.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;



/**
 * @author Selim HENDRICKSON
 *
 */
public class StandartYalitimBileseni {
    private String ad = "";
    private double yonetmelikLambda = 0;
    private double lambda = 0;
    private double U = 0;
    private double A = 0;
    private double UxA = 0;       
    DecimalFormat twoDigits = new DecimalFormat("0.00");
    
    public StandartYalitimBileseni(){
        super();
        DecimalFormatSymbols symbols = twoDigits.getDecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        twoDigits.setDecimalFormatSymbols(symbols);
    }
    
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public double getA() {
        return A;
    }
    public void setA(double a) {
        A = a;
    }
    public double getLambda() {
        return lambda;
    }
    public void setLambda(double lambda) {
        this.lambda = lambda;
    }
    public double getU() {
        return U;
    }
    public void setU(double u) {
        U = u;
    }
    public double getUxA() {
        return UxA;
    }
    public void setUxA(double uxA) {
        UxA = uxA;
    }
    public double getYonetmelikLambda() {
        return yonetmelikLambda;
    }
    public void setYonetmelikLambda(double yonetmelikLambda) {
        this.yonetmelikLambda = yonetmelikLambda;
    }

    public Object[] getTableRow() {
        String[] row = {getAd(),""+getYonetmelikLambda(),""+getLambda(),""+getU(),twoDigits.format(getA()),twoDigits.format(getUxA())}; 
        return row;
    }
}
