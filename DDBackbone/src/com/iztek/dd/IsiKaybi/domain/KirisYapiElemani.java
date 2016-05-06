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
public class KirisYapiElemani extends BasitYapiElemani{

	private String ITEM_NAME = "Kiriþ";
	private String ICON_URN = "/com/iztek/dd/GUI/images/kiris.gif";
	private String[] MENU_CHOICES = {};
	
	private DuvarYapiElemani owningDuvar = null;

	public KirisYapiElemani(){
		super();
		setYapiElemaniKodu("Ki");
	}

	public KirisYapiElemani(DuvarYapiElemani duvar){
	    super();
	    this.owningDuvar = duvar;
	    setYapiElemaniKodu("Ki");
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

    public DuvarYapiElemani getOwningDuvar() {
        return owningDuvar;
    }

    public void loadSelf(TreeItemInt copiedObject) {
        KirisYapiElemani copiedKiris = (KirisYapiElemani) copiedObject;
        setAlan(copiedKiris.getAlan());
        setYapiElemaniKodu(copiedKiris.getYapiElemaniKodu());
        setUzunluk(copiedKiris.getUzunluk());
        setYukseklik(copiedKiris.getYukseklik());
        setKalinlik(copiedKiris.getKalinlik());
        setIsiGecirgenlikKatsayisi(copiedKiris.getIsiGecirgenlikKatsayisi());        
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
        KirisYapiElemani copyOfSelf = new KirisYapiElemani();
        copyOfSelf.setAlan(getAlan());
        copyOfSelf.setYapiElemaniKodu(getYapiElemaniKodu());
        copyOfSelf.setUzunluk(getUzunluk());
        copyOfSelf.setYukseklik(getYukseklik());
        copyOfSelf.setKalinlik(getKalinlik());
        copyOfSelf.setIsiGecirgenlikKatsayisi(getIsiGecirgenlikKatsayisi());
        return copyOfSelf;
    }
}
