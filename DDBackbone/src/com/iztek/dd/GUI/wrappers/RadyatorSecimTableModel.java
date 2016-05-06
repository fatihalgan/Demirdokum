package com.iztek.dd.GUI.wrappers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.iztek.dd.IsiKaybi.domain.Radyator;

/**
 * @author Burak AYDIN
 *
 */
public class RadyatorSecimTableModel extends AbstractTableModel  {

   
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6918310601814739149L;

	private static final String[] COLUMN_HEADERS = {"Radyatör modeli", "Toplam yükseklik", "Birim güç", "Birim", "n"};

	private List radyatorlari;
	
	private DecimalFormat threeDigit = new DecimalFormat("0.000");

	private RadyatorSecimTableModel(List Radyatorilar) {
		setRadyatorilar(Radyatorilar);
	}
	
	public RadyatorSecimTableModel() {
		setRadyatorilar(new ArrayList());
	}

	public RadyatorSecimTableModel(Collection RadyatorilarCol) {
		setRadyatorilar(RadyatorilarCol);
	}

	public int getColumnCount() {
		return RadyatorSecimTableModel.COLUMN_HEADERS.length;
	}

	public int getRowCount() {
		return radyatorlari.size();
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Class getColumnClass(int columnIndex) {

		return String.class;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		Radyator radyator = (Radyator) getRadyatorler().get(rowIndex);
		Object val;
		switch (columnIndex) {
			case 0 :
			    val = radyator.getModel();
			    break;
			case 1 :
				val = ""+radyator.getYukseklik();
				break;
			case 2 :
				val = ""+radyator.getGuc();
				break;
			case 3 :
				val = radyator.getTip().equals(Radyator.PANEL) ? "Watt/m" : "Watt/dilim";
				break;
			case 4 :
				val = threeDigit.format(radyator.getGenlesmeKatsayisi());
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
	public List getRadyatorler() {
		return radyatorlari;
	}

	/**
	 * @param list
	 */
	public void setRadyatorilar(Collection RadyatorilarCol) {
	    if (RadyatorilarCol == null)
	        radyatorlari = new ArrayList();
		else if (RadyatorilarCol instanceof List) 
			radyatorlari = (List)RadyatorilarCol ;
		else
			radyatorlari = new ArrayList(RadyatorilarCol);
		fireTableDataChanged();
	}
}
