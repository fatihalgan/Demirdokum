/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.spike;

import java.util.ArrayList;

import com.iztek.dd.IsiKaybi.domain.AlfaDegeri;
import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class AlfaDegerleriDriver {
    public static void main(String[] args) {
        ArrayList alfaDegerleri = new ArrayList();
        
        alfaDegerleri.add(new AlfaDegeri("Arakat - Döþeme -(ýsý aþaðýdan yukarýya)",7,7));
        alfaDegerleri.add(new AlfaDegeri("Arakat - Döþeme -(ýsý yukarýdan aþaðýya)",5,5));
        alfaDegerleri.add(new AlfaDegeri("Dolgu zemin - Döþeme -(ýsý içten dýþa)",7,7));
        alfaDegerleri.add(new AlfaDegeri("Dýþ yüzey - Döþeme -(ýsý içten dýþa)",5,20));
        alfaDegerleri.add(new AlfaDegeri("Dýþ yüzey - Dýþ duvar -(ýsý içten dýþa)",7,20));
        alfaDegerleri.add(new AlfaDegeri("Dýþ yüzey - Tavan -(ýsý içten dýþa)",7,20));
        alfaDegerleri.add(new AlfaDegeri("Ýç yüzey - iç duvar",7,7));
        
        PersistenceManagerInt.INSTANCE.serializeAlfaDegerleri(alfaDegerleri);
    }
}
