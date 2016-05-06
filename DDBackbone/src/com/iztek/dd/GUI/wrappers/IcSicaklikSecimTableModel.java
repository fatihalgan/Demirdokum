package com.iztek.dd.GUI.wrappers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.iztek.dd.IsiKaybi.domain.IcSicaklik;

/**
 * @author Burak AYDIN
 *
 */
public class IcSicaklikSecimTableModel extends AbstractTableModel  {

   
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6918310601814739149L;

	private static final String[] COLUMN_HEADERS = {"Isýtýlacak hacmin adý","Sýcaklýk (\u00b0C)"};

	private List icSicakliklar;
	
	private DecimalFormat threeDigit = new DecimalFormat("0.000");

	private IcSicaklikSecimTableModel(List IcSicaklikilar) {
		setIcSicaklikilar(IcSicaklikilar);
	}
	
	public IcSicaklikSecimTableModel() {
		setIcSicaklikilar(new ArrayList());
	}

	public IcSicaklikSecimTableModel(Collection IcSicaklikilarCol) {
		setIcSicaklikilar(IcSicaklikilarCol);
	}

	public int getColumnCount() {
		return IcSicaklikSecimTableModel.COLUMN_HEADERS.length;
	}

	public int getRowCount() {
		return icSicakliklar.size();
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Class getColumnClass(int columnIndex) {

		return String.class;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		IcSicaklik icSicaklik = (IcSicaklik) getIcSicaklikler().get(rowIndex);
		Object val;
		switch (columnIndex) {
			case 0 :
			    val = icSicaklik.getMahal();
			    break;
			case 1 :
				val = ""+icSicaklik.getSicaklik();
				break;
			case 2 :
				val = ""+icSicaklik.getTip();
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
	 * @return
	 */
	public List getIcSicaklikler() {
		return icSicakliklar;
	}

	/**
	 * @param list
	 */
	public void setIcSicaklikilar(Collection IcSicaklikilarCol) {
	    if (IcSicaklikilarCol == null)
	        icSicakliklar = new ArrayList();
		else if (IcSicaklikilarCol instanceof List) 
			icSicakliklar = (List)IcSicaklikilarCol ;
		else
			icSicakliklar = new ArrayList(IcSicaklikilarCol);
		fireTableDataChanged();
	}
}
