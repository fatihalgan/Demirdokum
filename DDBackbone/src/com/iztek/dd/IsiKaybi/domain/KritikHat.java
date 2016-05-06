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
public class KritikHat {

	private Collection boruParcalari = new ArrayList();
	
	/**
	 * 
	 */
	public KritikHat() {
		super();
	}
	
	public void addBoruParcasi(BoruParcasi bp) {
		boruParcalari.add(bp);
	}
	
	public void removeBoruParcasi(BoruParcasi bp) {
		boruParcalari.remove(bp);
	}
	
	public double getSurtunmeKaybiToplami() {
		BasincKaybiCizelgesi cizelge = BasincKaybiCizelgesi.getInstance();
		BasincKaybiCizelgesi araCizelge = cizelge.findRowsByBaslangicBasincKaybi(29.421);
		Iterator it = boruParcalari.iterator();
		double surtunmeKaybiToplami = 0;
		while(it.hasNext()) {
			BoruParcasi boruParcasi = (BoruParcasi)it.next();
			BasincKaybiCizelgeRow row = araCizelge.findRowByNearestIsiYuku(boruParcasi.getIsiYuku());
			BasincKaybiCizelgesi araCizelge2 = cizelge.findRowsByBoruCapi(row.getBoruCapi());
			row = araCizelge2.findRowByNearestIsiYuku(boruParcasi.getIsiYuku());
			boruParcasi.setCap(row.getBoruCapi());
			boruParcasi.setMetreBasiBasincKaybi(row.getBasincKaybi());
			boruParcasi.setSuHizi(row.getSuHizi());
			double araSurtunmeKaybiDegeri = boruParcasi.getSurtunmeKaybi(); 
			surtunmeKaybiToplami += araSurtunmeKaybiDegeri;
		}
		return surtunmeKaybiToplami;
	}
	
	public double getOzelDirencToplami() {
		BasincKaybiCizelgesi cizelge = BasincKaybiCizelgesi.getInstance();
		BasincKaybiCizelgesi araCizelge = cizelge.findRowsByBaslangicBasincKaybi(29.421);
		Iterator it = boruParcalari.iterator();
		double zToplami = 0;
		while(it.hasNext()) {
			BoruParcasi boruParcasi = (BoruParcasi)it.next();
			BasincKaybiCizelgeRow row = araCizelge.findRowByNearestIsiYuku(boruParcasi.getIsiYuku());
			BasincKaybiCizelgesi araCizelge2 = cizelge.findRowsByBoruCapi(row.getBoruCapi());
			row = araCizelge2.findRowByNearestIsiYuku(boruParcasi.getIsiYuku());
			boruParcasi.setCap(row.getBoruCapi());
			boruParcasi.setMetreBasiBasincKaybi(row.getBasincKaybi());
			boruParcasi.setSuHizi(row.getSuHizi());
			double araOzelDirencDegeri = boruParcasi.getOzelDirenc();
			zToplami += araOzelDirencDegeri;
		}
		return zToplami;
	}

	public ArrayList getBoruParcalari(){
	    return (ArrayList)boruParcalari;
	}
}
