/*
 * Created on 06.Þub.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class PencereYapiElemani extends SizintiliYapiElemani{

	private String ITEM_NAME = "Pencere";
	private String ICON_URN = "/com/iztek/dd/GUI/images/window_small.jpg";
	private String[] MENU_CHOICES = {};

	DuvarYapiElemani owningDuvar = null;
	
	public PencereYapiElemani(DuvarYapiElemani duvar){
	    super();
	    this.owningDuvar = duvar;
	}

    public PencereYapiElemani() {
        super();
    }

    public String getIconURN() {
		return ICON_URN;
	}

	public String getItemName() {
		return ITEM_NAME;
	}

	public String[] getMenuChoices() {
		return MENU_CHOICES;
	}

    public void copyToSelf(PencereYapiElemani commonPencere) {
        setYapiElemaniKodu(commonPencere.getYapiElemaniKodu());
        setYapiElemaniAdi(commonPencere.getYapiElemaniAdi());
        setIsiGecirgenlikKatsayisi(commonPencere.getIsiGecirgenlikKatsayisi());
    }

    public DuvarYapiElemani getOwningDuvar() {
        return owningDuvar;
    }

    public void addChild(TreeItemInt child) {        
    }

    public void removeChild(TreeItemInt child) {
    }

    public void setParent(TreeItemInt parent) {
        setOwningDuvar((DuvarYapiElemani)parent);
    }

    public TreeItemInt getParent() {
        return getOwningDuvar();
    }

    public TreeItemInt cloneSelf() {
        PencereYapiElemani copyOfSelf = new PencereYapiElemani();
        copyOfSelf.setYapiElemaniKodu(getYapiElemaniKodu());
        copyOfSelf.setUzunluk(getUzunluk());
        copyOfSelf.setYukseklik(getYukseklik());
        copyOfSelf.setAcilanKisminUzunlugu(getAcilanKisminUzunlugu());
        copyOfSelf.setIsiGecirgenlikKatsayisi(getIsiGecirgenlikKatsayisi());
        return copyOfSelf;
    }

    public void loadSelf(TreeItemInt copiedObject) {
        PencereYapiElemani copiedPencere = (PencereYapiElemani) copiedObject;
        setYapiElemaniKodu(copiedPencere.getYapiElemaniKodu());
        setUzunluk(copiedPencere.getUzunluk());
        setYukseklik(copiedPencere.getYukseklik());
        setAcilanKisminUzunlugu(copiedPencere.getAcilanKisminUzunlugu());
        setIsiGecirgenlikKatsayisi(copiedPencere.getIsiGecirgenlikKatsayisi());
    }    
}
