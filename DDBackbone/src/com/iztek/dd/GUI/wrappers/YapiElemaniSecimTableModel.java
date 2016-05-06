package com.iztek.dd.GUI.wrappers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.iztek.dd.IsiKaybi.domain.YapiElemani;

/**
 * @author Burak AYDIN
 *
 */
public class YapiElemaniSecimTableModel extends AbstractTableModel  {

    
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -1131917106173512426L;

	private String[] columnHeaders = {"Kod", "Açýklama", "U (W/m2 K)"};

	private List yapiElemanlari;
	
	private DecimalFormat twoDigit = new DecimalFormat("0.00");

	private YapiElemaniSecimTableModel(List YapiElemanilar) {
		setYapiElemanilar(YapiElemanilar);
	}
	
	public YapiElemaniSecimTableModel() {
		setYapiElemanilar(new ArrayList());
	}

	public YapiElemaniSecimTableModel(Collection YapiElemanilarCol) {
		setYapiElemanilar(YapiElemanilarCol);
	}

	public int getColumnCount() {
		return columnHeaders.length;
	}

	public int getRowCount() {
		return yapiElemanlari.size();
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Class getColumnClass(int columnIndex) {

		return String.class;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		YapiElemani yapiElemani = (YapiElemani) getYapiElemanilar().get(rowIndex);
		Object val;
		switch (columnIndex) {
			case 0 :
			    val = yapiElemani.getYapiElemaniKodu();
			    break;
			case 1 :
				val = yapiElemani.getYapiElemaniAdi();
				break;
			case 2 :
				val = ""+twoDigit.format(yapiElemani.getIsiGecirgenlikKatsayisi());
				break;
			case 3 :
				val = ""+twoDigit.format(yapiElemani.getLambda());
				break;
			case 4 :
				val = yapiElemani.getTurByKod();
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
		return columnHeaders[columnIndex];
	}

	public List getYapiElemanilar() {
		return yapiElemanlari;
	}

	public void setYapiElemanilar(Collection YapiElemanilarCol) {
	    if (YapiElemanilarCol == null)
	        yapiElemanlari = new ArrayList();
		else if (YapiElemanilarCol instanceof List) 
			yapiElemanlari = (List)YapiElemanilarCol ;
		else
			yapiElemanlari = new ArrayList(YapiElemanilarCol);
		fireTableDataChanged();
	}
	
	public String[] getColumnHeaders() {
		return columnHeaders;
	}
	
	public void setColumnHeaders(String[] column_headers) {
		columnHeaders = column_headers;
	}
}
