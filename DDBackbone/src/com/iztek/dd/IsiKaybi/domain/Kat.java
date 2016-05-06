/*
 * Created on 27.Ara.2004
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;
import com.iztek.dd.utilities.Il;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Kat implements TreeItemInt{
    private int katYuksekligi = 0;
    private Collection mahaller = new ArrayList();
    double toplamIsiIhtiyaci = 0;
    private int mahalSayisi = 0;
    
    private Bina bina = null;

	private static final String ITEM_NAME = "Kat";
	private static final String ICON_URN = "/com/iztek/dd/GUI/images/Kat.gif";
	private static final String[] MENU_CHOICES = {"Mahal"};

	//********************************************************************************************************
	// Business Methods **************************************************************************************
	//********************************************************************************************************
    
    public double hesaplaToplamIsiIhtiyaci() throws RuntimeException{ 
    	toplamIsiIhtiyaci = 0;
    	Iterator it = mahaller.iterator();
    	while(it.hasNext()){
    		Bina selectedBina = getBina();
    		Il binaninIli = selectedBina.getProje().getIl();
    		if(binaninIli!=null){
    			toplamIsiIhtiyaci += ((Mahal)it.next()).hesaplaToplamIsiIhtiyaci(selectedBina.getBinaDurumKatsayisi(),binaninIli.getIsiKaybiDisSicaklik(),selectedBina.getSizdirganlikKatsayisi());	
    		}else throw new RuntimeException("Binanýn ilini seçmediniz!");    		    		
    	} 
    	return toplamIsiIhtiyaci;
    }
    
	//********************************************************************************************************
	// Accessor & Mutator Methods*****************************************************************************
	//********************************************************************************************************

    public double readKatYuksekligiZammi(){
    	if(katYuksekligi==4) return 0.05;
    	if(katYuksekligi==5) return 0.1;
    	if(katYuksekligi==6) return 0.1;
    	if(katYuksekligi==7) return 0.15;
    	if(katYuksekligi==8) return 0.15;
    	if(katYuksekligi==9) return 0.15;
    	if(katYuksekligi==10) return 0.15;    	
        return 0;
    }

    public List getMahaller(){
        return (ArrayList)mahaller;
    }

    public void initializeMahaller(ArrayList mahaller){
        if(mahaller.isEmpty()){
            this.mahaller.addAll(this.mahaller);
        }
    }
    
    public void addMahal(Mahal mahal){
        mahaller.add(mahal);
    }
    
    public void removeMahal(Mahal mahal){
        mahaller.remove(mahal);
    }
        
    
    public void setKatYuksekligi(int katYuksekligi) {
        this.katYuksekligi = katYuksekligi;
    }
    
    public Bina getBina() {
        return bina;
    }
    
    public void setBina(Bina bina) {
        this.bina = bina;
    }
    
    /***************************************/
    /** GRASP METHODS
    /**************************************/     
    
    public Mahal createMahal(){
        String mahalKodu = "";
        mahalSayisi++;
        Mahal yeniMahal = new Mahal(bina.getOdaDurumKatsayisi());
        yeniMahal.setKat(this);
        //yeniMahal.setMahalId(i);
//        if(katYuksekligi==0) mahalKodu += "Z";
//        else mahalKodu += katYuksekligi;                
        if(mahaller.size()<10) mahalKodu += "0";
        mahalKodu += mahalSayisi;
        yeniMahal.setMahalkodu(mahalKodu);
        addMahal(yeniMahal);
        return yeniMahal;
    }
        
    public int getKatYuksekligi() {
        return getBina().getIndexOfSubItem(this);
    }

	public void updateMahaller() {
		Iterator it = mahaller.iterator();
		while(it.hasNext()){
			Mahal nextMahal = (Mahal) it.next();
			String mahalKodu = nextMahal.getMahalkodu();
			mahalKodu = mahalKodu.substring(1);
			int katYuksekligi = getKatYuksekligi();
			if(katYuksekligi==1) mahalKodu = "Z" + mahalKodu;
			else mahalKodu = "" + (katYuksekligi-1) + mahalKodu;
			nextMahal.setMahalkodu(mahalKodu);
		}
	}

	public TreeItemInt cloneSelf(){
		Kat copyOfSelf = new Kat();
		Iterator it = getMahaller().iterator();
		while(it.hasNext()){
			copyOfSelf.addMahal((Mahal)((TreeItemInt)it.next()).cloneSelf());
		}
		return copyOfSelf;
	}

	//********************************************************************************************************
	// GUI Methods********************************************************************************************
	//********************************************************************************************************

	public String getIconURN() {
		return ICON_URN;
	}

	public String getItemName() {
		return ITEM_NAME;
	}

	public String[] getMenuChoices() {
		return MENU_CHOICES;
	}

	public Object getSubItem(int index) {
		return ((ArrayList)mahaller).get(index);
	}

	public int getSubItemCount() {
		return mahaller.size();
	}

	public boolean isLeaf() {
		return (mahaller.size()==0);
	}

	public int getIndexOfSubItem(Object child) {
		int index = 0;
		Iterator it = mahaller.iterator();
		while(it.hasNext()){		
			TreeItemInt item = (TreeItemInt)it.next();
			if(item==child) return index;
			index++;
		}		
		return -1;
	}

	public String toString(){
	    int katYuksekligi = getBina().getIndexOfSubItem(this);
		if(katYuksekligi==0) return "Zemin Kat";
		return ""+katYuksekligi+". kat";
	}

    public void addChild(TreeItemInt child) {
        addMahal((Mahal)child);
    }

    public void removeChild(TreeItemInt child) {
        removeMahal((Mahal)child);
    }

    public void setParent(TreeItemInt parent) {
        setBina((Bina)parent);
    }

    public TreeItemInt getParent() {
        return getBina();
    }

    public void loadSelf(TreeItemInt copiedObject) {
    	Kat copiedKat = (Kat) copiedObject;
    	getMahaller().clear();
    	mahalSayisi = 0;
    	Iterator it = copiedKat.getMahaller().iterator();
    	while(it.hasNext()){
    		Mahal mahal = (Mahal)it.next();
    		//mahal.setKat(this);
    		createMahal().loadSelf(mahal);
    	}
    }

    public double hesaplaToplamDuvarAlaniForCommonDuvar(String yapiElemaniKodu) {
        double toplamDuvarAlani = 0;
        Iterator it = getMahaller().iterator();
        while(it.hasNext()){
            Mahal mahal = (Mahal) it.next();
            toplamDuvarAlani += mahal.hesaplaToplamDuvarAlaniForCommonDuvar(yapiElemaniKodu);
        }
        return toplamDuvarAlani;
    }

    public double hesaplaToplamBasitAlaniForCommonBasit(String yapiElemaniKodu) {
        double toplamBasitAlani = 0;
        Iterator it = getMahaller().iterator();
        while(it.hasNext()){
            Mahal mahal = (Mahal) it.next();
            toplamBasitAlani += mahal.hesaplaToplamBasitAlaniForCommonBasit(yapiElemaniKodu);
        }
        return toplamBasitAlani;
    }
}

