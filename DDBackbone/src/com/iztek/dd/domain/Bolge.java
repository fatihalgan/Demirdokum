/*
 * Created on 25.Ara.2004
 *
 */
package com.iztek.dd.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public abstract class Bolge {
    private String bolgeAdi = null;
    private double anBirinciHesapKatsayisi;
    private double anIkincihesapKatsayisi;
    private double anKucukStandartYillikIsitmaEnerjisiIhtiyaci;
    private double anBuyukStandartYillikIsitmaEnerjisiIhtiyaci;
    private double vbBirinciHesapKatsayisi;
    private double vbIkincihesapKatsayisi;
    private double vbKucukStandartYillikIsitmaEnerjisiIhtiyaci;
    private double vbBuyukStandartYillikIsitmaEnerjisiIhtiyaci;
    private double standartLambda;
      
	public String getBolgeAdi() {
		return bolgeAdi;
	}

	public void setBolgeAdi(String bolgeAdi) {
		this.bolgeAdi = bolgeAdi;
	}

	public double getAyaGoreDisSicaklik(String ay){
        return DisSicakliklar.getInstance().getAyBolgeBazindaDisSicaklik(ay,bolgeAdi);
    }
	/**
	 * @return Returns the anBirinciHesapKatsayisi.
	 */
	public double getAnBirinciHesapKatsayisi() {
		return anBirinciHesapKatsayisi;
	}
	/**
	 * @param anBirinciHesapKatsayisi The anBirinciHesapKatsayisi to set.
	 */
	public void setAnBirinciHesapKatsayisi(double anBirinciHesapKatsayisi) {
		this.anBirinciHesapKatsayisi = anBirinciHesapKatsayisi;
	}
	/**
	 * @return Returns the anBuyukStandartYillikIsitmaEnerjisiIhtiyaci.
	 */
	public double getAnBuyukStandartYillikIsitmaEnerjisiIhtiyaci() {
		return anBuyukStandartYillikIsitmaEnerjisiIhtiyaci;
	}
	/**
	 * @param anBuyukStandartYillikIsitmaEnerjisiIhtiyaci The anBuyukStandartYillikIsitmaEnerjisiIhtiyaci to set.
	 */
	public void setAnBuyukStandartYillikIsitmaEnerjisiIhtiyaci(
			double anBuyukStandartYillikIsitmaEnerjisiIhtiyaci) {
		this.anBuyukStandartYillikIsitmaEnerjisiIhtiyaci = anBuyukStandartYillikIsitmaEnerjisiIhtiyaci;
	}
	/**
	 * @return Returns the anIkincihesapKatsayisi.
	 */
	public double getAnIkincihesapKatsayisi() {
		return anIkincihesapKatsayisi;
	}
	/**
	 * @param anIkincihesapKatsayisi The anIkincihesapKatsayisi to set.
	 */
	public void setAnIkincihesapKatsayisi(double anIkincihesapKatsayisi) {
		this.anIkincihesapKatsayisi = anIkincihesapKatsayisi;
	}
	/**
	 * @return Returns the anKucukStandartYillikIsitmaEnerjisiIhtiyaci.
	 */
	public double getAnKucukStandartYillikIsitmaEnerjisiIhtiyaci() {
		return anKucukStandartYillikIsitmaEnerjisiIhtiyaci;
	}
	/**
	 * @param anKucukStandartYillikIsitmaEnerjisiIhtiyaci The anKucukStandartYillikIsitmaEnerjisiIhtiyaci to set.
	 */
	public void setAnKucukStandartYillikIsitmaEnerjisiIhtiyaci(
			double anKucukStandartYillikIsitmaEnerjisiIhtiyaci) {
		this.anKucukStandartYillikIsitmaEnerjisiIhtiyaci = anKucukStandartYillikIsitmaEnerjisiIhtiyaci;
	}
	/**
	 * @return Returns the vbBirinciHesapKatsayisi.
	 */
	public double getVbBirinciHesapKatsayisi() {
		return vbBirinciHesapKatsayisi;
	}
	/**
	 * @param vbBirinciHesapKatsayisi The vbBirinciHesapKatsayisi to set.
	 */
	public void setVbBirinciHesapKatsayisi(double vbBirinciHesapKatsayisi) {
		this.vbBirinciHesapKatsayisi = vbBirinciHesapKatsayisi;
	}
	/**
	 * @return Returns the vbBuyukStandartYillikIsitmaEnerjisiIhtiyaci.
	 */
	public double getVbBuyukStandartYillikIsitmaEnerjisiIhtiyaci() {
		return vbBuyukStandartYillikIsitmaEnerjisiIhtiyaci;
	}
	/**
	 * @param vbBuyukStandartYillikIsitmaEnerjisiIhtiyaci The vbBuyukStandartYillikIsitmaEnerjisiIhtiyaci to set.
	 */
	public void setVbBuyukStandartYillikIsitmaEnerjisiIhtiyaci(
			double vbBuyukStandartYillikIsitmaEnerjisiIhtiyaci) {
		this.vbBuyukStandartYillikIsitmaEnerjisiIhtiyaci = vbBuyukStandartYillikIsitmaEnerjisiIhtiyaci;
	}
	/**
	 * @return Returns the vbIkincihesapKatsayisi.
	 */
	public double getVbIkincihesapKatsayisi() {
		return vbIkincihesapKatsayisi;
	}
	/**
	 * @param vbIkincihesapKatsayisi The vbIkincihesapKatsayisi to set.
	 */
	public void setVbIkincihesapKatsayisi(double vbIkincihesapKatsayisi) {
		this.vbIkincihesapKatsayisi = vbIkincihesapKatsayisi;
	}
	/**
	 * @return Returns the vbKucukStandartYillikIsitmaEnerjisiIhtiyaci.
	 */
	public double getVbKucukStandartYillikIsitmaEnerjisiIhtiyaci() {
		return vbKucukStandartYillikIsitmaEnerjisiIhtiyaci;
	}
	/**
	 * @param vbKucukStandartYillikIsitmaEnerjisiIhtiyaci The vbKucukStandartYillikIsitmaEnerjisiIhtiyaci to set.
	 */
	public void setVbKucukStandartYillikIsitmaEnerjisiIhtiyaci(
			double vbKucukStandartYillikIsitmaEnerjisiIhtiyaci) {
		this.vbKucukStandartYillikIsitmaEnerjisiIhtiyaci = vbKucukStandartYillikIsitmaEnerjisiIhtiyaci;
	}

	/**
	 * @return
	 */
	public double hesaplaStandartIhtiyac(double oran,double odaYuksekligi) {		
		if(odaYuksekligi<=2.6) return getAnBirinciHesapKatsayisi() * oran + getAnIkincihesapKatsayisi();
		return getVbBirinciHesapKatsayisi() * oran + getVbIkincihesapKatsayisi();
	}

	/**
	 * @param oran
	 * @return
	 */
	public double readStandartIhtiyac(double oran,double odaYuksekligi) {		
		if(odaYuksekligi<=2.6){
			if(oran<=0.2) return getAnKucukStandartYillikIsitmaEnerjisiIhtiyaci();
			if(oran>=1.05) return getAnBuyukStandartYillikIsitmaEnerjisiIhtiyaci();
		}else{
			if(oran<=0.2) return getVbKucukStandartYillikIsitmaEnerjisiIhtiyaci();
			if(oran>=1.05) return getVbBuyukStandartYillikIsitmaEnerjisiIhtiyaci();			
		}
		return 0;
	}

	
    public double getStandartLambda() {
        return standartLambda;
    }
    
    public void setStandartLambda(double standartLambda) {
        this.standartLambda = standartLambda;
    }
}
