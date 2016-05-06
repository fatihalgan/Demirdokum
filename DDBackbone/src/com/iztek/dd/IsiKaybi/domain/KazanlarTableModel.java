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
public class KazanlarTableModel extends AbstractTableModel{
    String[] headers = {"Tip","Model","Güç (KW)"};
    private double kazanGucu = 0;
    private String yakitTipi = "1.0";
    
    public KazanlarTableModel(double kazanGucu, String yakitTipi ){
        this.kazanGucu = kazanGucu;
        this.yakitTipi = yakitTipi;         
    }
    public int getRowCount() {        
        return IsiticiCatalog.getInstance().getKazanlar(kazanGucu,yakitTipi).size();
    }
    public int getColumnCount() {
        return headers.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList kazanlar = IsiticiCatalog.getInstance().getKazanlar(kazanGucu,yakitTipi);
        KazanModeli kazan = (KazanModeli) kazanlar.get(rowIndex);
        if(columnIndex==0) return kazan.getTip();
        if(columnIndex==1) return kazan.getModelAdi();
        if(columnIndex==2) return new Double(kazan.getGuc());
        return null;
    }
    public String getColumnName(int column) {
        return headers[column];
    }
    
    public double getKazanGucu() {
        return kazanGucu;
    }
    public void setKazanGucu(double kazanGucu) {
        this.kazanGucu = kazanGucu;
    }
    public String getYakitTipi() {
        return yakitTipi;
    }
    public void setYakitTipi(String yakitTipi) {
        this.yakitTipi = yakitTipi;
    }
    public IsiticiModeliInt getIsitici(int rowIndex) {
        ArrayList isiticilar = null;
        IsiticiModeliInt isitici = null;
        
        isiticilar = (ArrayList)IsiticiCatalog.getInstance().getKazanlar(kazanGucu,yakitTipi);
        isitici = (KazanModeli)isiticilar.get(rowIndex);                         
        return isitici;
    }
}
