/*
 * Created on 27.Ara.2004
 *
 */
package com.iztek.dd.IsiKaybi.test;

import junit.framework.TestCase;

import com.iztek.dd.IsiKaybi.domain.BasitYapiElemani;
import com.iztek.dd.IsiKaybi.domain.DuvarYapiElemani;
import com.iztek.dd.IsiKaybi.domain.KirisYapiElemani;
import com.iztek.dd.IsiKaybi.domain.Mahal;
import com.iztek.dd.IsiKaybi.domain.PencereYapiElemani;
import com.iztek.dd.IsiKaybi.domain.SizintiliYapiElemani;
import com.iztek.dd.IsiKaybi.domain.TemelYapiElemani;

/**
 * @author Selim HENDRICKSON
 *
 */
public class MahalTest extends TestCase {
    Mahal mahal = null;
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(MahalTest.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        mahal = new Mahal(0.9);
        mahal.setIcSicaklik(20);
                     
        TemelYapiElemani disDuvar = new DuvarYapiElemani();
        disDuvar.setUzunluk(3.80);
        disDuvar.setYukseklik(2.80);
        disDuvar.setIsiGecirgenlikKatsayisi(0.467);
        disDuvar.setDisSicaklik(0);
        mahal.addYapiElemani(disDuvar);
        
        SizintiliYapiElemani pencere = new PencereYapiElemani((DuvarYapiElemani)disDuvar);
        pencere.setUzunluk(1.80);
        pencere.setYukseklik(1.30);
        pencere.setIsiGecirgenlikKatsayisi(2.20);
        pencere.setDisSicaklik(0);
        pencere.setSizdirganlikKatsayisi(2);
        pencere.setAcilanKisminUzunlugu(9.22);
        disDuvar.addYapiElemani(pencere);
        
        BasitYapiElemani kiris = new KirisYapiElemani();
        kiris.setUzunluk(3.60);
        kiris.setYukseklik(0.50);
        kiris.setIsiGecirgenlikKatsayisi(0.66);
        kiris.setDisSicaklik(0);
        disDuvar.addYapiElemani(kiris);

        TemelYapiElemani icDuvar = new DuvarYapiElemani();
        icDuvar.setUzunluk(1.90);
        icDuvar.setYukseklik(2.80);
        icDuvar.setIsiGecirgenlikKatsayisi(1.86);
        icDuvar.setDisSicaklik(26);
        mahal.addYapiElemani(icDuvar);
        
        TemelYapiElemani doseme = new DuvarYapiElemani();
        doseme.setUzunluk(3.60);
        doseme.setYukseklik(3.50);
        doseme.setIsiGecirgenlikKatsayisi(0.49);
        doseme.setDisSicaklik(7);
        mahal.addYapiElemani(doseme);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        mahal = null;
    }

    public void testHesaplaArtirimsizIsiKaybi() {
        assertEquals("Artýrýmsýz ýsý kaybý hatalý hesaplandý!",208.322,mahal.hesaplaArtirimsizIsiKaybi(),0.01);
    }
    
//    public void testSizintiIsiKaybi(){
//        mahal.setKoseAciklikEtkiKatsayisi(1);
//        assertEquals("Sýzýntý ýsý kaybý hatalý hesaplandý!",55.32,mahal.hesaplaSizintiIsiKaybi(0.6,0),0.1);
//    }

}
