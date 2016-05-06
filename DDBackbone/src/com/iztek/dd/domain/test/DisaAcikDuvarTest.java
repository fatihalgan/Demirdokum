/*
 * Created on 16.Ara.2004
 *
 */
package com.iztek.dd.domain.test;

import java.util.Iterator;

import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.DisaAcikDuvar;
import com.iztek.dd.domain.IsiGecirgenligi.DisaAcik;

import junit.framework.TestCase;

/**
 * @author Selim
 *
 */
public class DisaAcikDuvarTest extends TestCase {
	DisaAcikDuvar duvar = new DisaAcikDuvar("1. duvar",new DisaAcik());
	Bilesen bilesen1 = new Bilesen(0.02,0.870);
	Bilesen bilesen2 = new Bilesen(0.19,0.450);
	Bilesen bilesen3 = new Bilesen(0.04,0.031);
	Bilesen bilesen4 = new Bilesen(0.03,1.4);

	/**
	 * Constructor for DisaAcikDuvarTest.
	 * @param name
	 */
	public DisaAcikDuvarTest(String name) {
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
		junit.textui.TestRunner.run(DisaAcikDuvarTest.class);
	}

	public void testHesaplaIsiGecirgenlikKatsayisi() {
		double sonuc = duvar.getIsiGecirgenlikKatsayisiCarpiHesapKatsayisi();
		assertEquals("Duvarýn ýsý geçirgenlik katsayýsý 0.001'den büyük bir hatayla hesaplandý!",0.518,sonuc,0.001);
	}

	public void testAddBilesen() {
		Bilesen bilesen5 = new Bilesen(1,0.2);
		duvar.addBilesen(bilesen1);
		assertTrue("Bilesen5 bulunamadý!",duvar.getBilesenler().contains(bilesen1));
		Bilesen bilesen6 = new Bilesen(0.3,0.4);
		duvar.addBilesen(bilesen2);
		assertTrue("Bilesen6 bulunamadý!",duvar.getBilesenler().contains(bilesen2));
	}

	public void testHesaplaBilesenlerinIsýGecirgenlikKatsayisi() {
		double sonuc = duvar.hesaplaBilesenlerinIsýGecirgenlikDirenci();
		assertEquals("Bilesenlerin ýsý geçirgenlik katsayýsý 0.001'den büyük bir hatayla hesaplandý!",1.756,sonuc,0.001);
	}

	public void testHesaplaOrtakYüzeylerinSicakliklari(){
		double[] kontrolDegerleri = {18.182,13.14,-2.26,-2.51};
		double[] suBuhariBasinclari = {2087.84,1512.71,507.04,496.49};
		Bilesen bilesen = null;
		duvar.setDisHavaSicakligi(-3);
		
		duvar.hesaplaOrtakYuzeylerinSicakliklari();
		Iterator it = duvar.getBilesenler().iterator();
		int index = 0;
		while(it.hasNext()){
			bilesen = (Bilesen) it.next();
			assertEquals("YapiElemani "+(index+1)+"'e ait ortak yüzey sýcaklýðý yanlýþ hesaplandý!",(double)kontrolDegerleri[index],bilesen.getDisaYakinTaraftakiSicaklik(),0.1);
			assertEquals("YapiElemani "+(index+1)+"'e ait ortak su buharý basýncý yanlýþ hesaplandý!",(double)suBuhariBasinclari[index],bilesen.getDoymusSuBuhariBasinci(),1);
			index++;
		}
	}	
	
	public String toString(){
	    return "Dýþ havaya açýk duvar";
	}
}
