/*
 * Created on 02.Oca.2005
 *
 */
package com.iztek.dd.GUI.wrappers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.BilesikYapiElemani;

/**
 * @author Selim HENDRICKSON
 *
 */
public class BilesikYapiElemaniJTableWrapper {
	
	public static DefaultTableModel getTableModel(BilesikYapiElemani yapiElemani){
        Object columnNames[] = {
                "", "Malzeme Cinsi", "Kalýnlýk d (m)", "Isý iletkenliði", "Su buharý difüzyon direnç faktörü"
            };
        Object[][]  values = new Object[yapiElemani.getBilesenler().size()][4];
        DecimalFormat twoDigit = new DecimalFormat("0.00");
		Iterator it = yapiElemani.getBilesenler().iterator();
		int index = 0;
		while(it.hasNext()){
			index++;
			Object[] degerler = new Object[5];
			Bilesen bilesen = (Bilesen) it.next();
			degerler[0] = ""+index;
			degerler[1] = bilesen.getMalzemeCinsi();
			degerler[2] = ""+bilesen.getKalinlik();
			degerler[3] = ""+bilesen.getIsiIletimKatsayisi();
			degerler[4] = ""+twoDigit.format(bilesen.getSuBuhariDifuzyonDirenciKatsayisi());
			values[index-1] = degerler;
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(values,columnNames);
		
		return tableModel;
	}

	public static Collection getBilesenler(DefaultTableModel tableModel) {
		ArrayList bilesenler = new ArrayList();
		Vector dataVector = tableModel.getDataVector();
		Iterator it = dataVector.iterator();
		while(it.hasNext()){
			double kalinlik = 0;
			double isilIletkenlik = 0;
			double difuzyonDirencFaktoru = 0;
			Vector dataRow = (Vector)it.next();		
			String cinsi = (String)dataRow.elementAt(1);
			String kalinlikString = (String)dataRow.elementAt(2);
			String isilIletkenlikString = (String)dataRow.elementAt(3);
			String difuzyonDirencFaktoruString = (String)dataRow.elementAt(4);
			if(kalinlikString!=null && !kalinlikString.equals("")) kalinlik = Double.parseDouble(kalinlikString.replace(',','.'));
			if(isilIletkenlikString!=null && !isilIletkenlikString.equals("")) isilIletkenlik = Double.parseDouble(isilIletkenlikString.replace(',','.'));
			if(difuzyonDirencFaktoruString!=null && !difuzyonDirencFaktoruString.equals("")) difuzyonDirencFaktoru = Double.parseDouble(difuzyonDirencFaktoruString.replace(',','.')); 
			Bilesen bilesen = new Bilesen(kalinlik,isilIletkenlik);
			bilesen.setMalzemeCinsi(cinsi);
			bilesen.setSuBuhariDifuzyonDirenciKatsayisi(difuzyonDirencFaktoru);
			bilesenler.add(bilesen);		
		}
		return bilesenler;
	}

}
