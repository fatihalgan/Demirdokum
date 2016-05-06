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
public class KapiYapiElemani extends SizintiliYapiElemani{
	
	private String ITEM_NAME = "Kapý";
	private String ICON_URN = "/com/iztek/dd/GUI/images/door.gif";
	private String[] MENU_CHOICES = {};

	private DuvarYapiElemani owningDuvar = null;
	
	public KapiYapiElemani(DuvarYapiElemani duvar){
	    super();
	    this.owningDuvar = duvar;
	}
	
    public KapiYapiElemani() {
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

    public void copyToSelf(KapiYapiElemani commonKapi) {
        setYapiElemaniKodu(commonKapi.getYapiElemaniKodu());
        setYapiElemaniAdi(commonKapi.getYapiElemaniAdi());
        setIsiGecirgenlikKatsayisi(commonKapi.getIsiGecirgenlikKatsayisi());
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
        KapiYapiElemani copyOfSelf = new KapiYapiElemani();
        copyOfSelf.setYapiElemaniKodu(getYapiElemaniKodu());
        copyOfSelf.setUzunluk(getUzunluk());
        copyOfSelf.setYukseklik(getYukseklik());
        copyOfSelf.setKalinlik(getKalinlik());
        copyOfSelf.setIsiGecirgenlikKatsayisi(getIsiGecirgenlikKatsayisi());
        return copyOfSelf;
    }

    public void loadSelf(TreeItemInt copiedObject) {
        KapiYapiElemani copiedKapi = (KapiYapiElemani) copiedObject;
        setYapiElemaniKodu(copiedKapi.getYapiElemaniKodu());
        setUzunluk(copiedKapi.getUzunluk());
        setYukseklik(copiedKapi.getYukseklik());
        setKalinlik(copiedKapi.getKalinlik());
        setIsiGecirgenlikKatsayisi(copiedKapi.getIsiGecirgenlikKatsayisi());
    }
}
