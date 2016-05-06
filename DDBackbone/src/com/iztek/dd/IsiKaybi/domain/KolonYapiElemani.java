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
public class KolonYapiElemani extends BasitYapiElemani {
	
	private String ITEM_NAME = "Kolon";
	private String ICON_URN = "/com/iztek/dd/GUI/images/column_resized.gif";
	private String[] MENU_CHOICES = {};
	private DuvarYapiElemani owningDuvar = null;

	public KolonYapiElemani(){
		super();
		setYapiElemaniKodu("Ko");	    
	}
	
	public KolonYapiElemani(DuvarYapiElemani duvar){
		super();
		setYapiElemaniKodu("Ko");
	    setParent(duvar);	    
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
    
    public void removeChild(){        
    }

    public TreeItemInt cloneSelf() {
        KolonYapiElemani copyOfSelf = new KolonYapiElemani();
        copyOfSelf.setAlan(getAlan());
        copyOfSelf.setYapiElemaniKodu(getYapiElemaniKodu());
        copyOfSelf.setUzunluk(getUzunluk());
        copyOfSelf.setYukseklik(getYukseklik());
        copyOfSelf.setKalinlik(getKalinlik());
        copyOfSelf.setIsiGecirgenlikKatsayisi(getIsiGecirgenlikKatsayisi());
        return copyOfSelf;
    }

    public void loadSelf(TreeItemInt copiedObject) {
        KolonYapiElemani copiedKolon = (KolonYapiElemani) copiedObject;
        setAlan(copiedKolon.getAlan());
        setYapiElemaniKodu(copiedKolon.getYapiElemaniKodu());
        setUzunluk(copiedKolon.getUzunluk());
        setYukseklik(copiedKolon.getYukseklik());
        setKalinlik(copiedKolon.getKalinlik());
        setIsiGecirgenlikKatsayisi(copiedKolon.getIsiGecirgenlikKatsayisi());
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
}
