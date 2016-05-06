/*
 * Created on 27.Ara.2004
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;
import com.iztek.dd.domain.Proje;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Bina implements TreeItemInt{
    Proje proje = null;
    private Isitici isitici = new Isitici();
	private int isletmeTipi = 1;
	private double disSicaklik = 0;
	private double binaDurumKatsayisi = 1;
	private double odaDurumKatsayisi = 0.7;
	private double sizdirganlikKatsayisi = 3.0;
	private double toplamIsiIhtiyaci = 0;
	private KritikHat kritikHat = new KritikHat();
	private IsiYalitimi isiYalitimi = new IsiYalitimi();
	
    private Collection katlar = new ArrayList();    
    	 
	private static final String ITEM_NAME = "Bina";
	private static final String ICON_URN = "/com/iztek/dd/GUI/images/building_clipped.gif";
	private static final String[] MENU_CHOICES = {"Kat"};

	//********************************************************************************************************
	// Business Methods **************************************************************************************
	//********************************************************************************************************

    public double hesaplaToplamIsiIhtiyaci(){
    	toplamIsiIhtiyaci = 0;
    	Iterator it = katlar.iterator();
    	while(it.hasNext()){
    		toplamIsiIhtiyaci += ((Kat)it.next()).hesaplaToplamIsiIhtiyaci();
    	} 
    	return toplamIsiIhtiyaci;
    }

	//********************************************************************************************************
	// Accessor & Mutator Methods*****************************************************************************
	//********************************************************************************************************

    public List getKatlar(){
        return Collections.unmodifiableList((List)katlar);
    }

    public void initializeKatlar(ArrayList katlar){
        if(katlar.isEmpty()){
            this.katlar.addAll(this.katlar);
        }
    }
    
    public void addKat(Kat kat){
        katlar.add(kat);
    }
    
    public void removeKat(Kat kat){
        katlar.remove(kat);
    }
    
	public double getBinaDurumKatsayisi() {
		return binaDurumKatsayisi;
	}

	public void setBinaDurumKatsayisi(double binaDurumKatsayisi) {
		this.binaDurumKatsayisi = binaDurumKatsayisi;
	}
	
	public double getDisSicaklik() {
		return disSicaklik;
	}
	
	public void setDisSicaklik(double disSicaklik) {
		this.disSicaklik = disSicaklik;
	}
	
	public int getIsletmeTipi() {
		return isletmeTipi;
	}
	
	public void setIsletmeTipi(int isletmeTipi) {
		this.isletmeTipi = isletmeTipi;
	}	
	
    public Proje getProje() {
        return proje;
    }
    
    public void setProje(Proje proje) {
        this.proje = proje;
    }
        
    public double getOdaDurumKatsayisi() {
        return odaDurumKatsayisi;
    }
    
    public void setOdaDurumKatsayisi(double odaDurumKatsayisi) {
        this.odaDurumKatsayisi = odaDurumKatsayisi;
    }
        
    public double getSizdirganlikKatsayisi() {
        return sizdirganlikKatsayisi;
    }
    
    public void setSizdirganlikKatsayisi(double sizdirganlikKatsayisi) {
        this.sizdirganlikKatsayisi = sizdirganlikKatsayisi;
    }

    public Kat createKat(int katYuksekligi) {
        Kat yeniKat = new Kat();
        yeniKat.setBina(this);
        yeniKat.setKatYuksekligi(katYuksekligi);
        addKat(yeniKat);
        return yeniKat;
    }

    public Kat getKat(int katId) {
        Iterator it = katlar.iterator();
        while(it.hasNext()){
            Kat kat = (Kat)it.next();
            if(kat.getKatYuksekligi()==katId) return kat;
        }
        return null;
    }
    
	public Isitici getIsitici() {
		return isitici;
	}

	public void setIsitici(Isitici kazan) {
		this.isitici = kazan;
	}
		
	public KritikHat getKritikHat() {
		return kritikHat;
	}
	
	public void setKritikHat(KritikHat kritikHat) {
		this.kritikHat = kritikHat;
	}
	
    public Collection getEkIsiYalitimBilesenleri() {
        return isiYalitimi.getEkIsiYalitimBilesenleri();
    }
    
    public void setEkIsiYalitimBilesenleri(Collection ekIsiYalitimBilesenleri) {
        isiYalitimi.setEkIsiYalitimBilesenleri(ekIsiYalitimBilesenleri);
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
		return ((ArrayList)katlar).get(index);
	}

	public int getSubItemCount() {
		return katlar.size();
	}

	public boolean isLeaf() {
		return (katlar.size()==0);
	}

	public int getIndexOfSubItem(Object child) {
		int index = 0;
		Iterator it = katlar.iterator();
		while(it.hasNext()){		
			TreeItemInt item = (TreeItemInt)it.next();
			if(item==child) return index;
			index++;
		}		
		return -1;
	}
	
	public String toString(){
		String projeAdi = getProje().getProjeAdi();
		return projeAdi;
	}

    public TreeItemInt cloneSelf() {
        return null;
    }

    public void addChild(TreeItemInt child) {
        addKat((Kat)child);
    }

    public void removeChild(TreeItemInt child) {
        removeKat((Kat)child);
    }

    public void setParent(TreeItemInt parent) {        
    }

    public TreeItemInt getParent() {
        return null;
    }

    public void loadSelf(TreeItemInt copiedObject) {        
    }

    public double hesaplaToplamDuvarAlaniForCommonDuvar(String yapiElemaniKodu) {
        double toplamDuvarAlani = 0;
        Iterator it = getKatlar().iterator();
        while(it.hasNext()){
            Kat kat = (Kat) it.next();
            toplamDuvarAlani += kat.hesaplaToplamDuvarAlaniForCommonDuvar(yapiElemaniKodu);
        }
        return toplamDuvarAlani;
    }

    public double hesaplaToplamBasitAlaniForCommonBasit(String yapiElemaniKodu) {
        double toplamBasitAlani = 0;
        Iterator it = getKatlar().iterator();
        while(it.hasNext()){
            Kat kat = (Kat) it.next();
            toplamBasitAlani += kat.hesaplaToplamBasitAlaniForCommonBasit(yapiElemaniKodu);
        }
        return toplamBasitAlani;
    }
}
