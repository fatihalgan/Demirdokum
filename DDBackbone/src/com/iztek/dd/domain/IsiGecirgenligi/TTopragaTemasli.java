/*
 * Created on 18.Ara.2004
 *
 */
package com.iztek.dd.domain.IsiGecirgenligi;


/**
 * @author Selim HENDRICKSON
 *
 */
public class TTopragaTemasli implements IsiGecirgenligi {
	private static final double IC_YUZEYSEL_ISIL_ILETIM_DIRENCI = 0.13;
	private static final double DIS_YUZEYSEL_ISIL_ILETIM_DIRENCI = 0.00;
	private static final double HESAP_KATSAYISI = 0.5;

    public double getDIS_YUZEYSEL_ISIL_ILETIM_DIRENCI() {
        return DIS_YUZEYSEL_ISIL_ILETIM_DIRENCI;
    }

    public double getIC_YUZEYSEL_ISIL_ILETIM_DIRENCI() {
        return IC_YUZEYSEL_ISIL_ILETIM_DIRENCI;
    }

    public double getHESAP_KATSAYISI() {
        return HESAP_KATSAYISI;
    }

    public String toString(){
        return "Topraga temas eden";
    }

}
