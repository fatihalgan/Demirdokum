/*
 * Created on 27.Ara.2004
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public abstract class SizintiliYapiElemani extends BasitYapiElemani implements TreeItemInt{
    private double sizdirganlikKatsayisi = 0;
    private double acilanKisminUzunlugu = 0;

    public double hesaplaSizintiHavaDebisi(double sizdirganlikKatsayisi){
        return sizdirganlikKatsayisi * getAcilanKisminUzunlugu();
    }

    public double getAcilanKisminUzunlugu() {
        return acilanKisminUzunlugu;
    }
    
    public void setAcilanKisminUzunlugu(double acilanKisminUzunlugu) {
        this.acilanKisminUzunlugu = acilanKisminUzunlugu;
    }
    
    public double getSizdirganlikKatsayisi() {
        return sizdirganlikKatsayisi;
    }
    
    public void setSizdirganlikKatsayisi(double sizdirganlikKatsayisi) {
        this.sizdirganlikKatsayisi = sizdirganlikKatsayisi;
    }

	//********************************************************************************************************
	// GUI Methods********************************************************************************************
	//********************************************************************************************************
	
	public String getIconURN() {
		return null;
	}

	public String getItemName() {
		return null;
	}

	public String[] getMenuChoices() {
		return null;
	}

	public Object getSubItem(int index) {
		return null;
	}

	public int getSubItemCount() {
		return 0;
	}

	public boolean isLeaf() {
		return true;
	}

	public int getIndexOfSubItem(Object child) {
		return -1;
	}
	
}
