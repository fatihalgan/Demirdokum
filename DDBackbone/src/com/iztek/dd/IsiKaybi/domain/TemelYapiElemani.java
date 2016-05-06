package com.iztek.dd.IsiKaybi.domain;

/*
 * Created on 27.Ara.2004
 *
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public abstract class TemelYapiElemani extends YapiElemani implements TreeItemInt{ 
    private String yon = "K";
	private double icYuzeyselIsiTasinimKatsayisi = 0; //alpha ic
	private double disYuzeyselIsiTasinimKatsayisi = 0; //alpha dis
	
    double toplamAlan = 0;
    double cikarilanAlan = 0;
    double netAlan = 0;

	private Collection bilesenler = new ArrayList();
	private Collection yapiElemanlari = new ArrayList();
	private Mahal mahal = null;
	
	//********************************************************************************************************
	// Business Methods **************************************************************************************
	//********************************************************************************************************

	public double hesaplaIsiGecirgenlikKatsayisi(){
	    double isiGecirgenlikDirenci = 0;
	    double bilesenlerinIsiGecirgenlikKatsayisi = hesaplaBilesenlerinIsiGecirgenlikKatsayisi();
	    isiGecirgenlikDirenci += bilesenlerinIsiGecirgenlikKatsayisi + 1/getIcYuzeyselIsiTasinimKatsayisi() + 1/getDisYuzeyselIsiTasinimKatsayisi();
	    setIsiGecirgenlikKatsayisi(1/isiGecirgenlikDirenci);
	    return 1/isiGecirgenlikDirenci;
	}
	
	public double hesaplaBilesenlerinIsiGecirgenlikKatsayisi(){
	    double bilesenlerinIsiGecirgenlikKatsayisi = 0;
	    Iterator it = bilesenler.iterator();
	    while(it.hasNext()){
	        Malzeme malzeme = (Malzeme) it.next();	        
	        bilesenlerinIsiGecirgenlikKatsayisi += malzeme.hesaplaIsiGecirgenlikKatsayisi();
	    }	    
	    return bilesenlerinIsiGecirgenlikKatsayisi; 
	}
	
    public double hesaplaIsiKaybi() {
    	isiKaybi = 0;
    	double toplamIsiKaybi = 0;
        isiKaybi = hesaplaNetAlan() * getIsiGecirgenlikKatsayisi() * hesaplaIsiFarki();
        toplamIsiKaybi += isiKaybi;
        Iterator it = yapiElemanlari.iterator();
        while(it.hasNext()){
            BasitYapiElemani yapiElemani = (BasitYapiElemani)it.next();
            yapiElemani.setIcSicaklik(getIcSicaklik());
            yapiElemani.setDisSicaklik(getDisSicaklik());
            toplamIsiKaybi += yapiElemani.hesaplaIsiKaybi();
        }
        return toplamIsiKaybi;
    }
    
    public double hesaplaNetAlan(){
        toplamAlan = hesaplaAlan();
        hesaplaCikarilanAlan();
        netAlan = toplamAlan - cikarilanAlan;
        return netAlan;
    }
    
	private void hesaplaCikarilanAlan() {
		cikarilanAlan = 0;
		Iterator it = yapiElemanlari.iterator();
        while(it.hasNext()){
            cikarilanAlan += ((BasitYapiElemani)it.next()).hesaplaAlan();
        }
	}

	public double hesaplaToplamSizintiHavaDebisi(double sizdirganlikKatsayisi){
        double sizintiHavaDebisi = 0;
        Iterator it = yapiElemanlari.iterator();
        while(it.hasNext()){
            BasitYapiElemani yapiElemani = (BasitYapiElemani)it.next();
            yapiElemani.setIcSicaklik(getIcSicaklik());
            sizintiHavaDebisi += yapiElemani.hesaplaSizintiHavaDebisi(sizdirganlikKatsayisi);
        }
        return sizintiHavaDebisi;
    }

	//********************************************************************************************************
	// Accessor & Mutator Methods*****************************************************************************
	//********************************************************************************************************

	public double getDisYuzeyselIsiTasinimKatsayisi() {
        return disYuzeyselIsiTasinimKatsayisi;
    }
    
    public void setDisYuzeyselIsiTasinimKatsayisi(
            double disYuzeyselIsiTasinimKatsayisi) {
        this.disYuzeyselIsiTasinimKatsayisi = disYuzeyselIsiTasinimKatsayisi;
    }
    
    public double getIcYuzeyselIsiTasinimKatsayisi() {
        return icYuzeyselIsiTasinimKatsayisi;
    }
    
    public void setIcYuzeyselIsiTasinimKatsayisi(
            double icYuzeyselIsiTasinimKatsayisi) {
        this.icYuzeyselIsiTasinimKatsayisi = icYuzeyselIsiTasinimKatsayisi;
    }
        
    public Collection getBilesenler() {
        return bilesenler;
    }
 
    public void setBilesenler(ArrayList bilesenler ){
        this.bilesenler = bilesenler;
    }
    
    public void initializeBilesenler(List bilesenler) {
        if(this.bilesenler.isEmpty()){
            this.bilesenler.addAll(bilesenler);
        }
    }
    
    public void addBilesen(Malzeme malzeme){
        bilesenler.add(malzeme);
    }
    
    public void removeBilesen(Malzeme malzeme){
        bilesenler.remove(malzeme);
    }
    
    public void initializeYapiElemanlari(ArrayList yapiElemanlari){
        if(yapiElemanlari.isEmpty()==true){
            yapiElemanlari.addAll(yapiElemanlari);
        }
    }
    
    public Collection getYapiElemanlari(){
        return (ArrayList)yapiElemanlari;
    }
    
    public void addYapiElemani(BasitYapiElemani yapiElemani){
        yapiElemanlari.add(yapiElemani);
    }

    public void removeYapiElemani(BasitYapiElemani yapiElemani){
        yapiElemanlari.remove(yapiElemani);
    }
    
    public String getYon() {
        return yon;
    }
    
    public void setYon(String yon) {
        this.yon = yon;
    }
    
	public double getCikarilanAlan() {
		return cikarilanAlan;
	}

	public void setCikarilanAlan(double cikarilanAlan) {
		this.cikarilanAlan = cikarilanAlan;
	}

	public double getNetAlan() {
		return netAlan;
	}

	public void setNetAlan(double netAlan) {
		this.netAlan = netAlan;
	}
	
    public Mahal getMahal() {
        return mahal;
    }
    
    public void setMahal(Mahal mahal) {
        this.mahal = mahal;
    }
	//********************************************************************************************************
	// GUI Methods********************************************************************************************
	//********************************************************************************************************

	public Object getSubItem(int index) {
		return ((ArrayList)yapiElemanlari).get(index);
	}

	public int getSubItemCount() {
		return yapiElemanlari.size();
	}

	public boolean isLeaf() {
		return (yapiElemanlari.size()==0);
	}

	public int getIndexOfSubItem(Object child) {
		int index = 0;
		Iterator it = yapiElemanlari.iterator();
		while(it.hasNext()){		
			TreeItemInt item = (TreeItemInt)it.next();
			if(item==child) return index;
			index++;
		}		
		return -1;
	}

	public void copyToSelf(DuvarYapiElemani commonDuvar) {
		setYapiElemaniKodu(commonDuvar.getYapiElemaniKodu());
		setYapiElemaniAdi(commonDuvar.getYapiElemaniAdi());
		setIsiGecirgenlikKatsayisi(commonDuvar.getIsiGecirgenlikKatsayisi());
	}

}
