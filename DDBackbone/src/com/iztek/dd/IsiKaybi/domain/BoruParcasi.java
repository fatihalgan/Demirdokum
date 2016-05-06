/*
 * Created on 09.Oca.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Fatih ALGAN
 *
 */
public class BoruParcasi {

	private double uzunluk;
	private double isiYuku;
	private double cap;
	private double suHizi;
	private double metreBasiBasincKaybi;
		
	
	private Collection surtunmeDirenciYaratanlar = new ArrayList();
	/**
	 * 
	 */
	public BoruParcasi(double uzunluk, double isiYuku) {
		super();
		this.uzunluk = uzunluk;
		this.isiYuku = isiYuku;
	}

	/**
	 * @return Returns the isiYuku.
	 */
	public double getIsiYuku() {
		return isiYuku;
	}
	/**
	 * @param isiYuku The isiYuku to set.
	 */
	public void setIsiYuku(double isiYuku) {
		this.isiYuku = isiYuku;
	}
	/**
	 * @return Returns the uzunluk.
	 */
	public double getUzunluk() {
		return uzunluk;
	}
	/**
	 * @param uzunluk The uzunluk to set.
	 */
	public void setUzunluk(double uzunluk) {
		this.uzunluk = uzunluk;
	}
	
	
	/**
	 * @return Returns the surtunmeDirenciYaratan.
	 */
	public Collection getSurtunmeDirenciYaratanlar() {
		return surtunmeDirenciYaratanlar;
	}
	/**
	 * @param surtunmeDirenciYaratan The surtunmeDirenciYaratan to set.
	 */
	public void addSurtunmeDirenciYaratan(SurtunmeDirenciYaratan sdy) {
		this.getSurtunmeDirenciYaratanlar().add(sdy);
	}
	/**
	 * @return Returns the cap.
	 */
	public double getCap() {
		return cap;
	}
	/**
	 * @param cap The cap to set.
	 */
	public void setCap(double cap) {
		this.cap = cap;
	}
	/**
	 * @return Returns the metreBasiBasincKaybi.
	 */
	public double getMetreBasiBasincKaybi() {
		surtunmeKaybiHesapla(this);
		return metreBasiBasincKaybi;
	}
	/**
	 * @param metreBasiBasincKaybi The metreBasiBasincKaybi to set.
	 */
	public void setMetreBasiBasincKaybi(double metreBasiBasincKaybi) {
		this.metreBasiBasincKaybi = metreBasiBasincKaybi;
	}
	/**
	 * @return Returns the suHizi.
	 */
	public double getSuHizi() {
		return suHizi;
	}
	/**
	 * @param suHizi The suHizi to set.
	 */
	public void setSuHizi(double suHizi) {
		this.suHizi = suHizi;
	}
	
	public double getSurtunmeKaybi() {
		return getMetreBasiBasincKaybi() * getUzunluk();
	}
	
	public double getZetaDirenci() {
		double zetaDirenci = 0;
		Iterator it = getSurtunmeDirenciYaratanlar().iterator();
		while(it.hasNext()) {
			SurtunmeDirenciYaratan sdy = (SurtunmeDirenciYaratan)it.next();
			zetaDirenci += sdy.getZetaDirenci(getCap());
		}
		return zetaDirenci;
	}
	
	public double getOzelDirenc() {
		double ozelDirenc = OzelDirencler.getInstance().getOzelDirenc(getSuHizi(), getZetaDirenci());
		if(ozelDirenc == 0) {
			ozelDirenc = OzelDirencler.getInstance().getOzelDirenc(getSuHizi(), Math.ceil(getZetaDirenci()));
		}
		return ozelDirenc;
	}

	/* - */
	/**
	 * @param string
	 * @param koseliRadyatorVentiliAdeti
	 */
	public void addSurtunmeDirenciYaratanlar(String tip, int adet) {
		for (int i=0; i<adet; i++){
			SurtunmeDirenciYaratan surtunmeDirenciYaratan = new SurtunmeDirenciYaratan(tip);
			addSurtunmeDirenciYaratan(surtunmeDirenciYaratan);
		}
	}
	
	public static void surtunmeKaybiHesapla(BoruParcasi bp) {
		BasincKaybiCizelgesi cizelge = BasincKaybiCizelgesi.getInstance();
		BasincKaybiCizelgesi araCizelge = cizelge.findRowsByBaslangicBasincKaybi(29.421);
		BasincKaybiCizelgeRow row = araCizelge.findRowByNearestIsiYuku(bp.getIsiYuku());
		BasincKaybiCizelgesi araCizelge2 = cizelge.findRowsByBoruCapi(row.getBoruCapi());
		row = araCizelge2.findRowByNearestIsiYuku(bp.getIsiYuku());
		bp.setCap(row.getBoruCapi());
		bp.setMetreBasiBasincKaybi(row.getBasincKaybi());
		bp.setSuHizi(row.getSuHizi());
	}

	public int getSurtunmeDirenciYaratanAdet(String tip){
	    int adet = 0;
	    Iterator it = getSurtunmeDirenciYaratanlar().iterator();
	    while(it.hasNext()){
	        if(((SurtunmeDirenciYaratan)it.next()).getTip().equals(tip)) adet++;
	    }
	    return adet;
	}
}
