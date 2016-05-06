/*
 * Created on 07.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * @author Selim HENDRICKSON
 *
 */
public class SecilenMalzemelerTablemodel extends AbstractTableModel {
    private TemelYapiElemani yapiElemani = null;
    String[] columnNames = {"Ad","U"};
    private DecimalFormat twoDigits = new DecimalFormat("0.00");
    
    public SecilenMalzemelerTablemodel(YapiElemani yapiElemani){
        this.yapiElemani = (TemelYapiElemani)yapiElemani;
    }
    public int getRowCount() {
        if(yapiElemani.getBilesenler()!=null) return yapiElemani.getBilesenler().size();
        return 0;
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList malzemeler = (ArrayList)yapiElemani.getBilesenler();
        Malzeme malzeme = (Malzeme)malzemeler.get(rowIndex);
        if(columnIndex==0){
            return malzeme.getMalzemeAdi();
        }
        if(columnIndex==1){
            return twoDigits.format(malzeme.hesaplaIsiGecirgenlikKatsayisi());
        }
        return null;
    }
    public String getColumnName(int column) {
        return columnNames[column];
    }
    public void fireTableStructureChanged() {
        super.fireTableStructureChanged();
    }
    public Malzeme getMalzeme(int index) {
        return (Malzeme)((ArrayList)yapiElemani.getBilesenler()).get(index);
    }

    public void setYapiElemani(TemelYapiElemani yapiElemani){
        this.yapiElemani = yapiElemani; 
    }
}
