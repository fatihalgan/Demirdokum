/*
 * Created on 25.Ara.2004
 *
 */
package com.iztek.dd.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Bolge2 extends Bolge{
    private static Bolge instance = null;
    
	private Bolge2(String bolgeAdi) {
		setBolgeAdi(bolgeAdi);      

		setAnBirinciHesapKatsayisi(68.59);
	    setAnIkincihesapKatsayisi(32.3);
	    setAnKucukStandartYillikIsitmaEnerjisiIhtiyaci(48);
	    setAnBuyukStandartYillikIsitmaEnerjisiIhtiyaci(104);
	    setVbBirinciHesapKatsayisi(21.95);
	    setVbIkincihesapKatsayisi(10.34);
	    setVbKucukStandartYillikIsitmaEnerjisiIhtiyaci(14.7);
	    setVbBuyukStandartYillikIsitmaEnerjisiIhtiyaci(33);
	    setStandartLambda(0.60);
	}
	
    public static Bolge getInstance(){        
        if(instance == null) instance = new Bolge2("2");
        return instance;        
    }

}
