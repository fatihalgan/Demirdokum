/*
 * Created on 27.Ara.2004
 *
 */
package com.iztek.dd.IsiKaybi.test;

import junit.framework.TestCase;

import com.iztek.dd.IsiKaybi.domain.DuvarYapiElemani;
import com.iztek.dd.IsiKaybi.domain.Malzeme;
import com.iztek.dd.IsiKaybi.domain.TemelYapiElemani;

/**
 * @author Selim HENDRICKSON
 *
 */
public class BilesikYapiElemaniTest extends TestCase {
    TemelYapiElemani yapiElemani = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(BilesikYapiElemaniTest.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        yapiElemani = new DuvarYapiElemani();
        yapiElemani.setUzunluk(5);
        yapiElemani.setYukseklik(2);
        yapiElemani.setIcSicaklik(20);
        yapiElemani.setDisSicaklik(0);
        yapiElemani.setIcYuzeyselIsiTasinimKatsayisi(7);
        yapiElemani.setDisYuzeyselIsiTasinimKatsayisi(20);
        yapiElemani.addBilesen(new Malzeme(0.02,0.870));
        yapiElemani.addBilesen(new Malzeme(0.19,0.450));
        yapiElemani.addBilesen(new Malzeme(0.06,0.04));
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testHesaplaIsiGecirgenlikKatsayisi() {
        assertEquals("Isý geçirgenlik katsayýsý hatalý hesaplandý!",0.467,yapiElemani.hesaplaIsiGecirgenlikKatsayisi(),0.01);
    }

    public void testHesaplaIsiFarki() {
        assertEquals("Isý farký hatalý hesaplandý!",20,yapiElemani.hesaplaIsiFarki(),0.1);
    }

    public void testHesaplaIsiKaybi() {
        yapiElemani.hesaplaIsiGecirgenlikKatsayisi();
        assertEquals("Isý kaybý hatalý hesaplandý!",93.4,yapiElemani.hesaplaIsiKaybi(),0.2);
    }

}
