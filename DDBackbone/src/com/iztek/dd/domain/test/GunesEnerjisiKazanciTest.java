/*
 * Created on 22.Ara.2004
 *
 */
package com.iztek.dd.domain.test;

import com.iztek.dd.domain.GunesEnerjisiKazanci;

import junit.framework.TestCase;

/**
 * @author Selim HENDRICKSON
 *
 */
public class GunesEnerjisiKazanciTest extends TestCase {
	GunesEnerjisiKazanci kazanc = null;
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(GunesEnerjisiKazanciTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		kazanc = new GunesEnerjisiKazanci();
		kazanc.setGunesEnerjisiGecirmeFaktoru(0.6);
		kazanc.setPencereAlani(10);
		kazanc.setYon("GUNEY");
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		kazanc = null;
	}

	public void testReadGunesIsinimiSiddeti() {
		assertEquals("Okunan g�ne� ���n�m �iddet hatal�!",92,kazanc.readGunesIsinimiSiddeti(""+5,"GUNEY"),1);		
		assertEquals("Okunan g�ne� ���n�m �iddet hatal�!",57,kazanc.readGunesIsinimiSiddeti(""+9,"KUZEY"),1);
		assertEquals("Okunan g�ne� ���n�m �iddet hatal�!",122,kazanc.readGunesIsinimiSiddeti(""+6,"BATI/DOGU"),1);
	}
	
	public void testHesaplaAylikGunesEnerjisi(){
	    assertEquals("Hesaplanan ayl�k g�ne� enerjisi hatal�!",259.2,kazanc.hesaplaAylikGunesEnerjisi("1",0.6),0.1);
	}

	public void testHesaplaGunesEnerjisiKazanci() {
		assertEquals("Hesaplanan g�ne� enerjisi kazanc� hatal�!",3632.4,kazanc.hesaplaGunesEnerjisiKazanci(0.6),0.01);
	}

}
