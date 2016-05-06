/*
 * Created on 01.Þub.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author Selim HENDRICKSON
 *
 */
public class IsiYalitimi {
    private HashMap standartBilesenler = new HashMap();
    private Collection ekIsiYalitimBilesenleri = new ArrayList();
    
    public void addStandartBilesen(String bilesenIdentifier, BilesenIsiYalitimi bilesen){
        standartBilesenler.put(bilesenIdentifier, bilesen);
    }
    
    public void updateStandartBilesenAlan(String bilesenIdentifier, double newAlan){
        ((BilesenIsiYalitimi)standartBilesenler.get(bilesenIdentifier)).setAlan(newAlan);
    }
    
    public Collection getEkIsiYalitimBilesenleri() {
        return ekIsiYalitimBilesenleri;
    }
    public void setEkIsiYalitimBilesenleri(Collection ekIsiYalitimBilesenleri) {
        this.ekIsiYalitimBilesenleri = ekIsiYalitimBilesenleri;
    }
}
