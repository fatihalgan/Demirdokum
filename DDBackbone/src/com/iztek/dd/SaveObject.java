/*
 * Created on 21.Þub.2005
 *
 */
package com.iztek.dd;

import com.iztek.dd.IsiKazanci.domain.IsiKazanan;
import com.iztek.dd.domain.Bina;
import com.iztek.dd.domain.Proje;

/**
 * @author Selim HENDRICKSON
 *
 */
public class SaveObject {
    Proje proje = null;
    Bina ts825Bina = null;
    com.iztek.dd.IsiKaybi.domain.Bina isiKaybiBina = null;
    IsiKazanan mahal = null;
        
    int binaDurumuKatsayilariArrayIndex1 = 0;
    int binaDurumuKatsayilariArrayIndex2 = 0;
    int binaDurumuKatsayilariArrayIndex3 = 0;
    int sizdirganlikKatsayilariArrayIndex1 = 0;
    int sizdirganlikKatsayilariArrayIndex2 = 0;
    
    
    public int getBinaDurumuKatsayilariArrayIndex1() {
        return binaDurumuKatsayilariArrayIndex1;
    }
    public void setBinaDurumuKatsayilariArrayIndex1(
            int binaDurumuKatsayilariArrayIndex1) {
        this.binaDurumuKatsayilariArrayIndex1 = binaDurumuKatsayilariArrayIndex1;
    }
    public int getBinaDurumuKatsayilariArrayIndex2() {
        return binaDurumuKatsayilariArrayIndex2;
    }
    public void setBinaDurumuKatsayilariArrayIndex2(
            int binaDurumuKatsayilariArrayIndex2) {
        this.binaDurumuKatsayilariArrayIndex2 = binaDurumuKatsayilariArrayIndex2;
    }
    public int getBinaDurumuKatsayilariArrayIndex3() {
        return binaDurumuKatsayilariArrayIndex3;
    }
    public void setBinaDurumuKatsayilariArrayIndex3(
            int binaDurumuKatsayilariArrayIndex3) {
        this.binaDurumuKatsayilariArrayIndex3 = binaDurumuKatsayilariArrayIndex3;
    }
    
    public int getSizdirganlikKatsayilariArrayIndex1() {
        return sizdirganlikKatsayilariArrayIndex1;
    }
    public void setSizdirganlikKatsayilariArrayIndex1(
            int sizdirganlikKatsayilariArrayIndex1) {
        this.sizdirganlikKatsayilariArrayIndex1 = sizdirganlikKatsayilariArrayIndex1;
    }
    public int getSizdirganlikKatsayilariArrayIndex2() {
        return sizdirganlikKatsayilariArrayIndex2;
    }
    public void setSizdirganlikKatsayilariArrayIndex2(
            int sizdirganlikKatsayilariArrayIndex2) {
        this.sizdirganlikKatsayilariArrayIndex2 = sizdirganlikKatsayilariArrayIndex2;
    }


    public com.iztek.dd.IsiKaybi.domain.Bina getIsiKaybiBina() {
        return isiKaybiBina;
    }
    public void setIsiKaybiBina(com.iztek.dd.IsiKaybi.domain.Bina isiKaybiBina) {
        this.isiKaybiBina = isiKaybiBina;
    }
    public IsiKazanan getMahal() {
        return mahal;
    }
    public void setMahal(IsiKazanan mahal) {
        this.mahal = mahal;
    }
    public Proje getProje() {
        return proje;
    }
    public void setProje(Proje proje) {
        this.proje = proje;
    }
    public Bina getTs825Bina() {
        return ts825Bina;
    }
    public void setTs825Bina(Bina ts825Bina) {
        this.ts825Bina = ts825Bina;
    }
}
