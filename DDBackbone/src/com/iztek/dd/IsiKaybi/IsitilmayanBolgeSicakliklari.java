/*
 * Created on 01.Þub.2005
 *
 */
package com.iztek.dd.IsiKaybi;

import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class IsitilmayanBolgeSicakliklari {
    private HashMap isitilmayanBolgeSicakliklari = new HashMap();
    private static IsitilmayanBolgeSicakliklari instance = null;
    
    public IsitilmayanBolgeSicakliklari(){
        isitilmayanBolgeSicakliklari = PersistenceManagerInt.INSTANCE.loadIsitilmayanBolgeSicakliklari();
    }
    
    public static IsitilmayanBolgeSicakliklari getInstance(){
        if(instance == null) instance = new IsitilmayanBolgeSicakliklari();
        return instance;
    }

    public IleGoreIsitilmayanBolgeSicakliklari getIleGoreIsitilmayanBolgeSicakliklari(String ilDisSicakligi){
        IleGoreIsitilmayanBolgeSicakliklari ileGoreIsitilmayanBolgeSicakliklari = (IleGoreIsitilmayanBolgeSicakliklari) isitilmayanBolgeSicakliklari.get(ilDisSicakligi);
        return ileGoreIsitilmayanBolgeSicakliklari;
    }
}
