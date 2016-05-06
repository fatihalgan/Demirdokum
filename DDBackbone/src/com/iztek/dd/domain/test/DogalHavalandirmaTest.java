/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.domain.test;

import com.iztek.dd.domain.Havalandirma.DogalHavalandirma;

import junit.framework.TestCase;

/**
 * @author Selim HENDRICKSON
 *
 */
public class DogalHavalandirmaTest extends TestCase {
	DogalHavalandirma havalandirma = new DogalHavalandirma();
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(DogalHavalandirmaTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		havalandirma.setBrutHacim(200);
		havalandirma.setHavaDegisimSayisi(1);
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testHesaplaHavalandirmaOzgulIsiKaybi() {
		assertEquals("Hesaplanan havalandýrma özgül ýsý kaybý 0.001'den büyük bir hatayla yanlýþ hesaplandý!",52.8,havalandirma.hesaplaHavalandirmaOzgulIsiKaybi(),0.001);
	}

	public void testGetHavalandirilanHacim() {
		assertEquals("Hesaplanan havalandýrýlan hacim 0.001'den büyük bir hatayla yanlýþ hesaplandý!",160,havalandirma.getHavalandirilanHacim(),0.001);
	}

}
