/*
 * Created on 11.�ub.2005
 *
 */
package com.iztek.dd.domain.test;

import java.util.Iterator;

import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.DisaAcikDuvar;
import com.iztek.dd.domain.IsiGecirgenligi.DisaAcik;

import junit.framework.TestCase;

/**
 * @author Selim HENDRICKSON
 *
 */
public class YogusmaTest extends TestCase {
    private DisaAcikDuvar duvar = null;    
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(YogusmaTest.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        duvar = new DisaAcikDuvar("1",new DisaAcik());
        duvar.setDisHavaSicakligi(-10);
        duvar.addBilesen(new Bilesen(0.02,0.87));
        duvar.addBilesen(new Bilesen(0.085,0.45));
        duvar.addBilesen(new Bilesen(0.035,0.04));
        duvar.addBilesen(new Bilesen(0.135,0.45));
        duvar.addBilesen(new Bilesen(0.03,1.4));
    }
    
    public void testHesaplaOrtakYuzeylerinSicakliklari() {
        System.out.println("Ortak y�zey s�cakl�klar�");
        duvar.hesaplaOrtakYuzeylerinSicakliklari();
        Iterator it = duvar.getBilesenler().iterator();
        while(it.hasNext()){
            System.out.println(((Bilesen)it.next()).getDisaYakinTaraftakiSicaklik());
        }
    }
    
    public void testHesaplaDoymusSuBuhariBasinclari(){
        System.out.println("\nDoymu� su buhar� bas�n�lar�");
        duvar.hesaplaOrtakYuzeylerinSicakliklari();
        Iterator it = duvar.getBilesenler().iterator();
        while(it.hasNext()){
            System.out.println(((Bilesen)it.next()).hesaplaDoymusSuBuhariBasinci());
        }        
    }

    public void testHesaplaIsiGecirgenlikKatsayisi(){
        assertEquals("Hatal� hesapland�!",0.634,duvar.getIsiGecirgenlikKatsayisi(),0.1);
    }

    public void testHesaplaIsiAkisi() {
        assertEquals("Hatal� hesapland�!",19.02,duvar.hesaplaIsiAkisi(),0.1);
    }
    
    public void testHesaplaIcYuzeySicakligi() {
        assertEquals("Hatal� hesapland�!",17.53,duvar.hesaplaIcYuzeySicakligi(),0.1);
    }

    public void testHesaplaDisYuzeySicakligi() {
        assertEquals("Hatal� hesapland�!",-9.25,duvar.hesaplaDisYuzeySicakligi(),0.1);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        duvar = null;
    }
}
