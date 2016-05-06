/*
 * Created on 22.Ara.2004
 *
 */
package com.iztek.dd.domain.test;

import com.iztek.dd.domain.Bolge1;
import com.iztek.dd.domain.Bolge2;
import com.iztek.dd.domain.Bolge3;
import com.iztek.dd.domain.Bolge4;
import com.iztek.dd.domain.Proje;

import junit.framework.TestCase;

/**
 * @author Selim HENDRICKSON
 *
 */
public class ProjeTest extends TestCase {
	Proje proje = null;

	public static void main(String[] args) {
		junit.textui.TestRunner.run(ProjeTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		proje = new Proje();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		proje = null;
	}

	public void testGetAyaBolgeyeGoreDisSicaklik() {
		proje.setBolge(Bolge1.getInstance());
		assertEquals("Aya ve bölgeye göre dýþ sýcaklýklar yanlýþ okundu!",15.7,proje.getAyaBolgeyeGoreDisSicaklik("4"),0.1);
		proje.setBolge(Bolge2.getInstance());
		assertEquals("Aya ve bölgeye göre dýþ sýcaklýklar yanlýþ okundu!",21.9,proje.getAyaBolgeyeGoreDisSicaklik("6"),0.1);
		proje.setBolge(Bolge3.getInstance());
		assertEquals("Aya ve bölgeye göre dýþ sýcaklýklar yanlýþ okundu!",11.3,proje.getAyaBolgeyeGoreDisSicaklik("10"),0.1);
		proje.setBolge(Bolge4.getInstance());
		assertEquals("Aya ve bölgeye göre dýþ sýcaklýklar yanlýþ okundu!",-1.3,proje.getAyaBolgeyeGoreDisSicaklik("3"),0.1);
	}

}
