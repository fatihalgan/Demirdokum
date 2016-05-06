package com.iztek.dd.GUI.wrappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.iztek.dd.IsiKaybi.domain.BoruParcasi;

/**
 * @author Burak AYDIN
 *
 */
public class KritikHatTableModel extends AbstractTableModel  {
    
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6448766540876677841L;

	private static final String[] COLUMN_HEADERS = {"No", "Q", "L", "d", "W","R","LR","Zeta","Z"};

	private List boruParcalari;	

	private KritikHatTableModel(List boruParcalari) {
	    setBoruParcalari(boruParcalari);
	}

	public KritikHatTableModel(Collection boruParcalari) {
	    setBoruParcalari(boruParcalari);
	}

	public int getColumnCount() {
		return KritikHatTableModel.COLUMN_HEADERS.length;
	}

	public int getRowCount() {
		return boruParcalari.size();
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Class getColumnClass(int columnIndex) {

		return String.class;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		BoruParcasi boruParcasi = (BoruParcasi)boruParcalari.get(rowIndex);
		Object val;
		switch (columnIndex) {
			case 0 :
			    val = ""+(rowIndex+1);
			    break;
			case 1 :
				val = Double.toString(boruParcasi.getIsiYuku());
				break;
			case 2 :
				val = Double.toString(boruParcasi.getUzunluk());
				break;
			case 3:
				val = Double.toString(boruParcasi.getCap());
				break;
			case 4:
				val = Double.toString(boruParcasi.getSuHizi());
				break;
			case 5:
				val = Double.toString(boruParcasi.getMetreBasiBasincKaybi());
				break;
			case 6:
				val = Double.toString(boruParcasi.getSurtunmeKaybi());
				break;
			case 7:
				val = Double.toString(boruParcasi.getZetaDirenci());
				break;
			case 8:
				val = Double.toString(boruParcasi.getOzelDirenc());
				break;
			default :
				val = "INDEX HATASI";
				break;
		}
		return val;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	public String getColumnName(int columnIndex) {
		return COLUMN_HEADERS[columnIndex];
	}

	/**
	 * @param list
	 */
	public void setBoruParcalari(Collection boruParcalari) {
	    if (boruParcalari == null)
	        boruParcalari = new ArrayList();
		else if (boruParcalari instanceof List) 
		    this.boruParcalari = (List)boruParcalari ;
		else
			this.boruParcalari = new ArrayList(boruParcalari);
		fireTableDataChanged();
	}
    /**
     * @return Returns the boruParcalari.
     */
    public List getBoruParcalari() {
        return boruParcalari;
    }
    
    /**
     * @param arg0
     * @return
     */
    public void add(Object arg0) {
        boruParcalari.add(arg0);
        fireTableDataChanged();
    }
    
	/**
	 * @param index
	 * @return
	 */
	public Object remove(int index) {
		Object removedParca = boruParcalari.remove(index);
		fireTableDataChanged();
		return removedParca;
	}
}
