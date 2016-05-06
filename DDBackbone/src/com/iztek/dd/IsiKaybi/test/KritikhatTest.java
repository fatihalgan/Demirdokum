/*
 * Created on 09.Oca.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKaybi.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import com.iztek.dd.IsiKaybi.domain.BasincKaybiCizelgeRow;
import com.iztek.dd.IsiKaybi.domain.BasincKaybiCizelgesi;
import com.iztek.dd.IsiKaybi.domain.BoruParcasi;
import com.iztek.dd.IsiKaybi.domain.SurtunmeDirenciYaratan;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class KritikhatTest extends TestCase {

	BasincKaybiCizelgesi cizelge = null;
	Collection boruParcalari = new ArrayList();
	
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(KritikhatTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		cizelge = BasincKaybiCizelgesi.getInstance();
		BoruParcasi boruParcasi = new BoruParcasi(3.125d, 523);
		boruParcasi.addSurtunmeDirenciYaratan(new SurtunmeDirenciYaratan("Deve Boynu 90 Derece"));
		boruParcasi.addSurtunmeDirenciYaratan(new SurtunmeDirenciYaratan("T Ayr�lma"));
		boruParcasi.addSurtunmeDirenciYaratan(new SurtunmeDirenciYaratan("Dirsek"));
		boruParcasi.addSurtunmeDirenciYaratan(new SurtunmeDirenciYaratan("Radyat�r Ventili(D�z)"));
		boruParcalari.add(boruParcasi);
		boruParcasi = new BoruParcasi(5.60, 959);
		boruParcasi.addSurtunmeDirenciYaratan(new SurtunmeDirenciYaratan("T Birle�me"));
		boruParcasi.addSurtunmeDirenciYaratan(new SurtunmeDirenciYaratan("T Ayr�lma"));
		boruParcalari.add(boruParcasi);
		boruParcasi = new BoruParcasi(5.60, 1395);
		boruParcasi.addSurtunmeDirenciYaratan(new SurtunmeDirenciYaratan("T Birle�me"));
		boruParcasi.addSurtunmeDirenciYaratan(new SurtunmeDirenciYaratan("T Ayr�lma"));
		boruParcalari.add(boruParcasi);
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Constructor for KritikhatTest.
	 * @param arg0
	 */
	public KritikhatTest(String arg0) {
		super(arg0);
	}
	
	public void testBasincKaybiCizelgesi() {
		BasincKaybiCizelgesi araCizelge = cizelge.findRowsByBaslangicBasincKaybi(29.421);
		Iterator it = boruParcalari.iterator();
		double zToplami = 0;
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
			System.out.println("Ara S�rt�nme Kayb� De�eri: " + araSurtunmeKaybiDegeri);
			surtunmeKaybiToplami += araSurtunmeKaybiDegeri;
			double araOzelDirencDegeri = boruParcasi.getOzelDirenc();
			System.out.println("Ara �zel Diren� De�eri: " + araOzelDirencDegeri);
			zToplami += araOzelDirencDegeri;
		}
		System.out.println("S�rt�nme Kayb� Toplam� = " + surtunmeKaybiToplami);
		System.out.println("Z �zel Diren� Toplam� = " + zToplami);
		System.out.println("Toplam Bas�n� Kayb� = " + (surtunmeKaybiToplami + zToplami));
		System.out.println("Pompa Bas�nc� = " + ((surtunmeKaybiToplami + zToplami) + 4000));
	}
}
