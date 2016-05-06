/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import javax.swing.table.AbstractTableModel;

/**
 * @author Selim HENDRICKSON
 *
 */
public class AlfaDegerleriTableModel extends AbstractTableModel {
    String[] columnNames = {"Açýklama","Alfa iç","Alfa dýþ"};
    public int getRowCount() {
        return AlfaDegerleriCatalog.getInstance().getAlfaDegerleri().size();        
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        AlfaDegeri alfaDegeri = AlfaDegerleriCatalog.getInstance().getAlfaDegeri(rowIndex);
        if(columnIndex==0) return alfaDegeri.getAciklama(); 
        if(columnIndex==1) return new Double(alfaDegeri.getAlphaIc());
        if(columnIndex==2) return new Double(alfaDegeri.getAlphaDis());
        return null;
    }
    public String getColumnName(int column) {
        return columnNames[column];
    }
    public void removeAlfaDegeri(int index) {
        AlfaDegeri alfaDegeri = AlfaDegerleriCatalog.getInstance().getAlfaDegeri(index);
        AlfaDegerleriCatalog.getInstance().removeAlfaDegeri(alfaDegeri);
        fireTableStructureChanged();
    }
    public AlfaDegeri getAlfaDegeri(int rowIndex) {
        AlfaDegeri alfaDegeri = AlfaDegerleriCatalog.getInstance().getAlfaDegeri(rowIndex);
        return alfaDegeri;
   }
    public void addAlfaDegeri(AlfaDegeri alfaDegeri){
        AlfaDegerleriCatalog.getInstance().addAlfaDegeri(alfaDegeri);
    }
}

