/*
 * Created on 25.Ara.2004
 *
 */
package com.iztek.dd.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Bolge4 extends Bolge{
    private static Bolge instance = null;
    
	private Bolge4(String bolgeAdi) {
		setBolgeAdi(bolgeAdi);        
		
		setAnBirinciHesapKatsayisi(82.81);
	    setAnIkincihesapKatsayisi(87.7);
	    setAnKucukStandartYillikIsitmaEnerjisiIhtiyaci(104);
	    setAnBuyukStandartYillikIsitmaEnerjisiIhtiyaci(175);
	    setVbBirinciHesapKatsayisi(26.5);
	    setVbIkincihesapKatsayisi(28.06);
	    setVbKucukStandartYillikIsitmaEnerjisiIhtiyaci(33.4);
	    setVbBuyukStandartYillikIsitmaEnerjisiIhtiyaci(56);
	    setStandartLambda(0.8);
	}
	
    public static Bolge getInstance(){        
        if(instance == null) instance = new Bolge4("4");
        return instance;        
    }
}
