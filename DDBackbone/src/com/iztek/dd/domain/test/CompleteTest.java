/*
 * Created on 05.Oca.2005
 *
 */
package com.iztek.dd.domain.test;

import java.util.Iterator;

import junit.framework.TestCase;

import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.Bina;
import com.iztek.dd.domain.Bolge2;
import com.iztek.dd.domain.DisaAcikDuvar;
import com.iztek.dd.domain.Pencere;
import com.iztek.dd.domain.Taban;
import com.iztek.dd.domain.Tavan;
import com.iztek.dd.domain.Havalandirma.DogalHavalandirma;
import com.iztek.dd.domain.IsiGecirgenligi.Catili;
import com.iztek.dd.domain.IsiGecirgenligi.DisaAcik;
import com.iztek.dd.domain.IsiGecirgenligi.TIsitilmayan;

/**
 * @author Selim HENDRICKSON
 *
 */
public class CompleteTest extends TestCase {
    Bina bina = new Bina();
        
    public static void main(String[] args) {
        junit.textui.TestRunner.run(CompleteTest.class);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        bina.getProje().setBolge(Bolge2.getInstance());
        bina.setOdaYuksekligi(3);
        bina.setEnerjiKullanimKatsayisi(5);
        bina.setGolgelenmeFaktoru(0.5);
        bina.createDogalHavalandýrma();
        ((DogalHavalandirma)bina.getHavalandirma()).setHavaDegisimSayisi(1);
        bina.setBrutHacim(8350);
        
//        GunesEnerjisiKazanci kazanc = new GunesEnerjisiKazanci();
//        kazanc.setYon("Dogu");
//        bina.addGunesEnerjisiKazanci(kazanc);
//        kazanc = new GunesEnerjisiKazanci();
//        kazanc.setYon("Bati");
//        bina.addGunesEnerjisiKazanci(kazanc);
//        kazanc = new GunesEnerjisiKazanci();
//        kazanc.setYon("Kuzey");
//        bina.addGunesEnerjisiKazanci(kazanc);
//        kazanc = new GunesEnerjisiKazanci();
//        kazanc.setYon("Guney");
//        bina.addGunesEnerjisiKazanci(kazanc);
        
        bina.getYoneGoreGunesEnerjisiKazanci("DOGU").setGunesEnerjisiGecirmeFaktoru(0.75);
        bina.getYoneGoreGunesEnerjisiKazanci("BATI").setGunesEnerjisiGecirmeFaktoru(0.75);
        bina.getYoneGoreGunesEnerjisiKazanci("KUZEY").setGunesEnerjisiGecirmeFaktoru(0.75);
        bina.getYoneGoreGunesEnerjisiKazanci("GUNEY").setGunesEnerjisiGecirmeFaktoru(0.75);
        
        bina.getYoneGoreGunesEnerjisiKazanci("DOGU").setPencereAlani(7.8);
        bina.getYoneGoreGunesEnerjisiKazanci("BATI").setPencereAlani(7.8);
        bina.getYoneGoreGunesEnerjisiKazanci("KUZEY").setPencereAlani(99.8);
        bina.getYoneGoreGunesEnerjisiKazanci("GUNEY").setPencereAlani(122.8);
        
        bina.setBrutHacim(8350);
        
        DisaAcikDuvar disDuvar1 = new DisaAcikDuvar("1.Dýþ Duvar",new DisaAcik());
        disDuvar1.addBilesen(new Bilesen(0.02,0.870));
        disDuvar1.addBilesen(new Bilesen(0.19,0.450));
        disDuvar1.addBilesen(new Bilesen(0.04,0.031));
        disDuvar1.addBilesen(new Bilesen(0.03,1.4));
        disDuvar1.setAlan(720.45);
        bina.addYapiElemani(disDuvar1);
        
        DisaAcikDuvar disDuvar2 = new DisaAcikDuvar("2.Dýþ Duvar",new DisaAcik());
        disDuvar2.addBilesen(new Bilesen(0.02,0.870));
        disDuvar2.addBilesen(new Bilesen(0.2,2.1));
        disDuvar2.addBilesen(new Bilesen(0.04,0.031));
        disDuvar2.addBilesen(new Bilesen(0.03,1.4));
        disDuvar2.setAlan(548);
        bina.addYapiElemani(disDuvar2);

        Tavan tavan = new Tavan(new Catili());
        tavan.addBilesen(new Bilesen(0.02,0.870));
        tavan.addBilesen(new Bilesen(0.12,2.1));
        tavan.addBilesen(new Bilesen(0.1,0.04));
        tavan.setAlan(500);
        bina.addYapiElemani(tavan);
        
        Taban taban = new Taban(new TIsitilmayan());
        taban.addBilesen(new Bilesen(0.03,1.4));
        taban.addBilesen(new Bilesen(0.03,0.028));
        taban.addBilesen(new Bilesen(0.12,2.1));
        taban.addBilesen(new Bilesen(0.02,0.870));
        taban.setAlan(500);
        bina.addYapiElemani(taban);

        Pencere pencere = new Pencere();
        pencere.setAlan(238.2);
        pencere.setIsiGecirgenlikKatsayisi(2.6);
        bina.addYapiElemani(pencere);
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testHesaplaIletimselOzgulIsiKaybi(){
        assertEquals("Iletimsel özgül ýsý kaybý hatalý hesaplandý", 1643.21,bina.hesaplaOzgulIletimselIsiKaybi(),5);
    }

    public void testHavalandirmaOzgulIsiKaybi(){
        assertEquals("Havalandýrma özgül ýsý kaybý hatalý hesaplandý", 2204.4,bina.hesaplaHavalandirmaOzgulIsiKaybi(),0.1);        
    }
    
    public void testHesaplaToplamYillikIsitmaEnerjisiIhtiyaci() {
        assertEquals("Toplam yýllýk ýsýtma enerjisi ihtiyacý hatalý hesaplandý",137166,bina.hesaplaToplamYillikIsitmaEnerjisiIhtiyaci(),1000);
    }

    public void testKontrolStandartaUygunluk() {
        assertTrue(bina.kontrolStandartaUygunluk());
    }

    public void testReport(){
        Iterator it = bina.getYapiElemanlari().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
