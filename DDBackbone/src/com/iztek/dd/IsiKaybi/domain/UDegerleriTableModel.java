/*
 * Created on 07.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * @author Selim HENDRICKSON
 *
 */
public class UDegerleriTableModel extends AbstractTableModel {  
    private String[] columnNames = {"Kod","Açýklama","U","Tür"};
    
    public int getRowCount() {
        return CogunluklaKullanilanYapiElemanlari.getInstance().getYapiElemanlari().size();
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList yapiElemanlari = (ArrayList)CogunluklaKullanilanYapiElemanlari.getInstance().getYapiElemanlari();
        YapiElemani yapiElemani = (YapiElemani)yapiElemanlari.get(rowIndex);
        if(columnIndex==0) return yapiElemani.getYapiElemaniKodu();
        if(columnIndex==1) return yapiElemani.getYapiElemaniAdi();
        if(columnIndex==2) return new Double(yapiElemani.getIsiGecirgenlikKatsayisi());
        if(columnIndex==3) return yapiElemani.getTurByKod();
        return null;
    }
    public String getColumnName(int column) {
        return columnNames[column];
    }
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    public void deleteYapiElemani(int index) {
        CogunluklaKullanilanYapiElemanlari.getInstance().removeYapiElemani(index);
        fireTableStructureChanged();
    }
    public YapiElemani getYapElemani(int index){
        return (YapiElemani)((ArrayList)CogunluklaKullanilanYapiElemanlari.getInstance().getYapiElemanlari()).get(index);
    }
}
