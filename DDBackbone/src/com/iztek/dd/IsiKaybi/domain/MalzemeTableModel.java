/*
 * Created on 06.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * @author Selim HENDRICKSON
 *
 */
public class MalzemeTableModel extends AbstractTableModel {
    private String[] columnNames = {"Kod","Malzeme adý","\u03BB (W/m K)"};
    private ArrayList malzemeler = null;

    public MalzemeTableModel(){
        super();
        malzemeler = MalzemeCatalog.getInstance().getMalzemeler();
    }

    //TableModel methods
    
    public int getRowCount() {
        return malzemeler.size();
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        Malzeme malzeme = (Malzeme)malzemeler.get(rowIndex);
        if(columnIndex==0) return malzeme.getKod();
        if(columnIndex==1) return malzeme.getMalzemeAdi();
        if(columnIndex==2) return ""+malzeme.getLambda();
        return null;
    }
    public String getColumnName(int col){
        return columnNames[col];
    }    
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    //Accessors & Mutators
    
    public ArrayList getMalzemeler() {
        return malzemeler;
    }    
    public void setMalzemeler(ArrayList malzemeler) {
        this.malzemeler = malzemeler;
    }

    //Business methods
    
    public void removeRow(int rowIndex) {
        if(rowIndex!=-1){
            malzemeler.remove(rowIndex);
            fireTableRowsDeleted(0,malzemeler.size());  
            MalzemeCatalog.getInstance().setDirty(true);
        }
    }
    public void addRow(Malzeme malzeme){
        malzemeler.add(malzeme);
        fireTableStructureChanged();
        MalzemeCatalog.getInstance().setDirty(true);
    }
}
