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
public abstract class BasitYapiElemani extends YapiElemani implements TreeItemInt{
    private int id = 0;    
    private DuvarYapiElemani owningDuvar = null;
    
    public double hesaplaIsiKaybi() {
    	isiKaybi = 0;
         isiKaybi = hesaplaAlan() * getIsiGecirgenlikKatsayisi() * hesaplaIsiFarki(); 
        return isiKaybi;
    }
    
    public double hesaplaSizintiHavaDebisi(double sizdirganlikKatsayisi){
        return 0;        
    }

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

    public DuvarYapiElemani getOwningDuvar() {
        return owningDuvar;
    }
    
    public void setOwningDuvar(DuvarYapiElemani owningDuvar) {
        this.owningDuvar = owningDuvar;
    }
    
//    public void addChild(TreeItemInt child) {
//    }
//
//    public void removeChild(TreeItemInt child) {        
//    }
//
//    public void setParent(TreeItemInt parent) {
//        setOwningDuvar((DuvarYapiElemani)parent);
//    }
//
//    public TreeItemInt getParent() {
//        return getOwningDuvar();
//    }

}
