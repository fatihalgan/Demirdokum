/*
 * Created on 16.Ara.2004
 *
 */
package com.iztek.dd.domain.test;

import junit.framework.TestCase;

import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.BinaDuvari;
import com.iztek.dd.domain.IsiGecirgenligi.DIsitilmayan;

/**
 * @author Selim
 *
 */
public class IsitilmayanDuvarTest extends TestCase {
	BinaDuvari duvar = new BinaDuvari("1. duvar",new DIsitilmayan());
	Bilesen bilesen1 = new Bilesen(0.02,0.870);
	Bilesen bilesen2 = new Bilesen(0.19,0.450);
	Bilesen bilesen3 = new Bilesen(0.04,0.031);
	Bilesen bilesen4 = new Bilesen(0.03,1.4);

	/**
	 * Constructor for IsitilmayanDuvarTest.
	 * @param name
	 */
	public IsitilmayanDuvarTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		duvar.addBilesen(bilesen1);
		duvar.addBilesen(bilesen2);
		duvar.addBilesen(bilesen3);
		duvar.addBilesen(bilesen4);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		duvar.getBilesenler().clear();
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(IsitilmayanDuvarTest.class);
	}

	public void testHesaplaIsiGecirgenlikKatsayisi() {
		double sonuc = duvar.getIsiGecirgenlikKatsayisiCarpiHesapKatsayisi();
		assertEquals("Duvarýn ýsý geçirgenlik katsayýsý 0.001'den büyük bir hatayla hesaplandý!",0.248,sonuc,0.001);
	}

	public void testAddBilesen() {
		Bilesen bilesen3 = new Bilesen(1,0.2);
		duvar.addBilesen(bilesen1);
		assertTrue("Bilesen1 bulunamadý!",duvar.getBilesenler().contains(bilesen1));
		Bilesen bilesen4 = new Bilesen(0.3,0.4);
		duvar.addBilesen(bilesen2);
		assertTrue("Bilesen2 bulunamadý!",duvar.getBilesenler().contains(bilesen2));
	}

	public void testHesaplaBilesenlerinIsýGecirgenlikKatsayisi() {
		double sonuc = duvar.hesaplaBilesenlerinIsýGecirgenlikDirenci();
		assertEquals("Bilesenlerin ýsý geçirgenlik katsayýsý 0.001'den büyük bir hatayla hesaplandý!",1.756,sonuc,0.001);
	}
}
