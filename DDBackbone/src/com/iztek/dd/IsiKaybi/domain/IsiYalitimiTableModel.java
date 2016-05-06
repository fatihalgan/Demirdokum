/*
 * Created on 27.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.table.AbstractTableModel;

/**
 * @author Selim HENDRICKSON
 *
 */
public class IsiYalitimiTableModel extends AbstractTableModel {
    Object columnNames[] = {"Yapý Bileþeni", "1/\u039B (m2K/W)", "1/\u039B (m2K/W)", "U (W/m2 K)", "A (m2)","UxA (W/K)"};
    Collection isiYalitimBilesenleri = null;
    DecimalFormat twoDigits = new DecimalFormat("0.00");
    
    public IsiYalitimiTableModel(Collection isiYalitimBilesenleri){
        this.isiYalitimBilesenleri = isiYalitimBilesenleri;
        DecimalFormatSymbols symbols = twoDigits.getDecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        twoDigits.setDecimalFormatSymbols(symbols);
    }
    
    public int getRowCount() {
        return isiYalitimBilesenleri.size();
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        StandartYalitimBileseni bilesen = (StandartYalitimBileseni) ((ArrayList)isiYalitimBilesenleri).get(rowIndex);
        switch (columnIndex) {
        case 0:
            return bilesen.getAd();
        case 1:
            return twoDigits.format(bilesen.getYonetmelikLambda());
        case 2:
            return twoDigits.format(bilesen.getLambda());
        case 3:
            return twoDigits.format(bilesen.getU()); 
        case 4:
            return twoDigits.format(bilesen.getA());
        case 5:
            return twoDigits.format(bilesen.getUxA());           
        default:
            break;
        }
        return null;
    }
    public String getColumnName(int column) {
        return (String)columnNames[column];
    }
    public void addBilesen(StandartYalitimBileseni bilesen){
        isiYalitimBilesenleri.add(bilesen);
        fireTableStructureChanged();
    }
    public Collection getIsiYalitimBilesenleri(){
        return isiYalitimBilesenleri;
    }

    public void deleteBilesen(int selectedRow) {
        isiYalitimBilesenleri.remove(((ArrayList)isiYalitimBilesenleri).get(selectedRow));
        fireTableStructureChanged();
    }
}
