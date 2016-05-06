/*
 * Created on 25.Ara.2004
 *
 */
package com.iztek.dd.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Bolge1 extends Bolge {
    private static Bolge instance = null;
    
	private Bolge1(String bolgeAdi) {
		setBolgeAdi(bolgeAdi);

		setAnBirinciHesapKatsayisi(46.92);
	    setAnIkincihesapKatsayisi(13.78);
	    setAnKucukStandartYillikIsitmaEnerjisiIhtiyaci(27);
	    setAnBuyukStandartYillikIsitmaEnerjisiIhtiyaci(66);
	    setVbBirinciHesapKatsayisi(14.92);
	    setVbIkincihesapKatsayisi(5.56);
	    setVbKucukStandartYillikIsitmaEnerjisiIhtiyaci(8.5);
	    setVbBuyukStandartYillikIsitmaEnerjisiIhtiyaci(21);
	    setStandartLambda(0.40);
	}
	
    public static Bolge getInstance(){        
        if(instance == null) instance = new Bolge1("1");
        return instance;        
    }
}
