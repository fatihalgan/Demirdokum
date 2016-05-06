/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * @author Selim HENDRICKSON
 *
 */
public class KombilerTableModel extends AbstractTableModel {
    String[] headers = {"Model","Tip","Güç (KW)"};
    private double isiticiGucu = 0;
    private double yakitTipi = 1.0;
    private boolean hermetik = false;
    private String isiticiTipi = "Kombi";
    
    public KombilerTableModel(double kombiGucu, boolean hermetik){
        this.isiticiGucu = kombiGucu;
        this.hermetik = hermetik;
    }
    
    public int getRowCount() {
        if(isiticiTipi.equals("Kombi")){
            int debug = IsiticiCatalog.getInstance().getKombiler(isiticiGucu,hermetik).size(); 
            return debug;
        }
        if(isiticiTipi.equals("Kat")){
            int debug = IsiticiCatalog.getInstance().getKatKaloriferleri(isiticiGucu,yakitTipi).size();
            return debug;
        }
        return 0;
    }
    public int getColumnCount() {
        return headers.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList isiticilar = null;
        IsiticiModeliInt isitici = null;
        if(isiticiTipi.equals("Kombi")){
            isiticilar = (ArrayList)IsiticiCatalog.getInstance().getKombiler(isiticiGucu,hermetik);
            isitici = (KombiModeli)isiticilar.get(rowIndex);
        }
        if(isiticiTipi.equals("Kat")){
            isiticilar = (ArrayList)IsiticiCatalog.getInstance().getKatKaloriferleri(isiticiGucu,yakitTipi);
            isitici = (KatKaloriferiModeli)isiticilar.get(rowIndex);
        }                 
        if(columnIndex==1) return isitici.getTip();
        if(columnIndex==0) return isitici.getModelAdi();
        if(columnIndex==2) return ""+isitici.getGuc();
        return null;
    }
    public String getColumnName(int column) {
        return headers[column];
    }    
    public boolean isHermetik() {
        return hermetik;
    }
    public void setHermetik(boolean hermetik) {
        this.hermetik = hermetik;
    }
    public double getIsiticiGucu() {
        return isiticiGucu;
    }
    public void setIsiticiGucu(double kombiGucu) {
        this.isiticiGucu = kombiGucu;
    }
    public String getIsiticiTipi() {
        return isiticiTipi;
    }
    public void setIsiticiTipi(String isiticiTipi) {
        this.isiticiTipi = isiticiTipi;
    }
    public double getYakitTipi() {
        return yakitTipi;
    }
    public void setYakitTipi(double yakitTipi) {
        this.yakitTipi = yakitTipi;
    }

    public IsiticiModeliInt getIsitici(int rowIndex) {
        ArrayList isiticilar = null;
        IsiticiModeliInt isitici = null;
        if(isiticiTipi.equals("Kombi")){
            isiticilar = (ArrayList)IsiticiCatalog.getInstance().getKombiler(isiticiGucu,hermetik);
            isitici = (KombiModeli)isiticilar.get(rowIndex);
        }
        if(isiticiTipi.equals("Kat")){
            isiticilar = (ArrayList)IsiticiCatalog.getInstance().getKatKaloriferleri(isiticiGucu,yakitTipi);
            isitici = (KatKaloriferiModeli)isiticilar.get(rowIndex);
        }                 
        return isitici;
    }
}
