/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.domain.test;

import com.iztek.dd.domain.Havalandirma.MekanikHavalandirma;

import junit.framework.TestCase;

/**
 * @author Selim HENDRICKSON
 *
 */
public class MekanikHavalandirmaTest extends TestCase {
	MekanikHavalandirma havalandirma = new MekanikHavalandirma();
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(MekanikHavalandirmaTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		//havalandirma.setHavaDegisimSayisi(1);
		havalandirma.setBrutHacim(200);
		havalandirma.setHavaGirisDebisi(5);
		havalandirma.setHavaC�k�sDebisi(10);
		havalandirma.setF(20);
		havalandirma.setE(0.1);
		havalandirma.setN50(4);
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testHesaplaHavalandirmaOzgulIsiKaybi() {
		assertEquals("Havaland�rma �zg�l �s� kayb� hatal� hesapland�!",3.62,havalandirma.hesaplaHavalandirmaOzgulIsiKaybi(),0.01);
	}

	public void testHesaplaSistemFanlariCalisirken() {
		assertEquals("Fanlar�n etkisi hatal� hesapland�!",10,havalandirma.hesaplaSistemFanlariCalisirken(),0.001);
	}

	public void testHesaplaRuzgarEtkisi() {
		assertEquals("R�zgar etkisi hatal� hesapland�!",0.98,havalandirma.hesaplaRuzgarEtkisi(),0.01);
	}

}
