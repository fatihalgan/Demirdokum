/*
 * Created on 06.Þub.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Iterator;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class DuvarYapiElemani extends TemelYapiElemani {    
	private String ITEM_NAME = "Duvar/Döþeme/Tavan";
	private String ICON_URN = "/com/iztek/dd/GUI/images/Duvar.jpg";
	private String[] MENU_CHOICES = {"Pencere","Kapý","Kolon","Kiriþ"};

	private boolean icDuvar = false;
	private boolean disDuvar = true;
	private boolean doseme = false;
	private double lambda = 0;
	
	public String getIconURN() {
		return ICON_URN;
	}

	public String getItemName() {
		return ITEM_NAME;
	}

	public String[] getMenuChoices() {
		if(disDuvar==true)return MENU_CHOICES;
		String[] temp = {};
		return temp;
	}
    
    public boolean isDisDuvar() {
        return disDuvar;
    }

    public void setDisDuvar(boolean disDuvar) {
        this.disDuvar = disDuvar;
    }
    
    public boolean isIcDuvar() {
        return icDuvar;
    }
        
    public void setIcDuvar(boolean icDuvar) {
        this.icDuvar = icDuvar;
    }
    
    public boolean isDoseme() {
        return doseme;
    }
    
    public void setDoseme(boolean doseme) {
        this.doseme = doseme;
    }        
    
    public double getLambda() {
        return lambda;
    }
    
    public void setLambda(double lambda) {
        this.lambda = lambda;
    }
   
    public KapiYapiElemani createKapi() {
        KapiYapiElemani kapi = new KapiYapiElemani(this);
        addYapiElemani(kapi);
        return kapi;
    }

    public KolonYapiElemani createKolon() {
        KolonYapiElemani kolon = new KolonYapiElemani(this);
        addYapiElemani(kolon);
        return kolon;
    }

    public KirisYapiElemani createKiris() {
        KirisYapiElemani kiris = new KirisYapiElemani(this);
        addYapiElemani(kiris);
        return kiris;
    }

    public PencereYapiElemani createPencere() {
        PencereYapiElemani pencere = new PencereYapiElemani(this);
        addYapiElemani(pencere);
        return pencere;
    }

    public TreeItemInt cloneSelf() {
        DuvarYapiElemani copyOfSelf = new DuvarYapiElemani();
        copyOfSelf.setYapiElemaniKodu(getYapiElemaniKodu());
        copyOfSelf.setYon(getYon());
        copyOfSelf.setUzunluk(getUzunluk());
        copyOfSelf.setKalinlik(getKalinlik());
        copyOfSelf.setYukseklik(getYukseklik());
        copyOfSelf.setIsiGecirgenlikKatsayisi(getIsiGecirgenlikKatsayisi());
        copyOfSelf.setIcSicaklik(getIcSicaklik());
        copyOfSelf.setDisSicaklik(getDisSicaklik());
        copyOfSelf.setDisDuvar(false);
        if(isDisDuvar()) copyOfSelf.setDisDuvar(true);
        if(isIcDuvar()) copyOfSelf.setIcDuvar(true);
        if(isDoseme()) copyOfSelf.setDoseme(true);
        Iterator it = ((ArrayList)getYapiElemanlari()).iterator();
        while(it.hasNext()){
        	BasitYapiElemani nextEleman = (BasitYapiElemani)it.next();
        	copyOfSelf.addYapiElemani((BasitYapiElemani)nextEleman.cloneSelf());
        }
        return copyOfSelf;
	}


    public void addChild(TreeItemInt child) {
        addYapiElemani((BasitYapiElemani) child);
    }


    public void removeChild(TreeItemInt child) {
        removeYapiElemani((BasitYapiElemani)child);
    }


    public void setParent(TreeItemInt parent) {
        setMahal((Mahal)parent);
    }


    public TreeItemInt getParent() {
        return getMahal();
    }

    public void loadSelf(TreeItemInt copiedObject) {
        DuvarYapiElemani copiedDuvar = (DuvarYapiElemani) copiedObject;
        setYapiElemaniKodu(copiedDuvar.getYapiElemaniKodu());
        setYon(copiedDuvar.getYon());
        setUzunluk(copiedDuvar.getUzunluk());
        setKalinlik(copiedDuvar.getKalinlik());
        setYukseklik(copiedDuvar.getYukseklik());
        setIsiGecirgenlikKatsayisi(copiedDuvar.getIsiGecirgenlikKatsayisi());
        setIcSicaklik(copiedDuvar.getIcSicaklik());
        setDisSicaklik(copiedDuvar.getDisSicaklik());
        setDisDuvar(false);
        setIcDuvar(false);
        setDoseme(false);
        if(copiedDuvar.isDisDuvar()) setDisDuvar(true);
        if(copiedDuvar.isIcDuvar()) setIcDuvar(true);
        if(copiedDuvar.isDoseme()) setDoseme(true);
        Iterator it = copiedDuvar.getYapiElemanlari().iterator();
        getYapiElemanlari().clear();
        while(it.hasNext()){
        	addYapiElemani((BasitYapiElemani)it.next());
        }
    }

    public double hesaplaToplamBasitAlaniForCommonBasit(String yapiElemaniKodu) {
        double toplamBasitAlani = 0;
        Iterator it = getYapiElemanlari().iterator();
        while(it.hasNext()){
            BasitYapiElemani basit = (BasitYapiElemani) it.next();
            if(basit.getYapiElemaniKodu()==yapiElemaniKodu) toplamBasitAlani += basit.hesaplaAlan(); 
        }
        return toplamBasitAlani;
    }

    public double hesaplaAlan(){
        double alan = 0;
        if(!doseme)return getUzunluk() * getYukseklik();
        return getAlan();
    }
}
