/*
 * Created on 25.Ara.2004
 *
 */
package com.iztek.dd.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Bolge3 extends Bolge{
    private static Bolge instance = null;
    
	private Bolge3(String bolgeAdi) {
		setBolgeAdi(bolgeAdi);      
		
		setAnBirinciHesapKatsayisi(67.29);
	    setAnIkincihesapKatsayisi(50.16);
	    setAnKucukStandartYillikIsitmaEnerjisiIhtiyaci(64);
	    setAnBuyukStandartYillikIsitmaEnerjisiIhtiyaci(121);
	    setVbBirinciHesapKatsayisi(21.74);
	    setVbIkincihesapKatsayisi(16.05);
	    setVbKucukStandartYillikIsitmaEnerjisiIhtiyaci(20.4);
	    setVbBuyukStandartYillikIsitmaEnerjisiIhtiyaci(39);
	    setStandartLambda(0.8);
	}
	
    public static Bolge getInstance(){        
        if(instance == null) instance = new Bolge3("3");
        return instance;        
    }

}
