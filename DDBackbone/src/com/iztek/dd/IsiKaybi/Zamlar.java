/*
 * Created on 27.Ara.2004
 *
 */
package com.iztek.dd.IsiKaybi;

import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Zamlar {
    private static HashMap yonlereGoreZamlar = new HashMap();
    private static HashMap isletmeTipiDyeGoreZamlar = new HashMap();
    private static Zamlar instance = null;
    
    private Zamlar(){
        yonlereGoreZamlar = PersistenceManagerInt.INSTANCE.loadYonZamlar();
        isletmeTipiDyeGoreZamlar = PersistenceManagerInt.INSTANCE.loadIsletmeTipiZamlar();
    }
    
    public static Zamlar getInstance(){
        if(instance == null) instance = new Zamlar();
        return instance;
    }

    public double getYoneGoreZam(String yon) {
        return ((Double)yonlereGoreZamlar.get(yon)).doubleValue();
    }

    public double getIsletmeZamOrani(int isletmeTipi, double d) {
        int dTipi = 0;
        if(d >= 0.12 && d<=0.34) dTipi = 1;
        if(d >= 0.35 && d<=0.80) dTipi = 2;
        if(d >= 0.81 && d<=1.73) dTipi = 3;
        if(d >= 1.74) dTipi = 4;
        return ((Double)isletmeTipiDyeGoreZamlar.get(""+isletmeTipi+dTipi)).doubleValue();        
    }
}
