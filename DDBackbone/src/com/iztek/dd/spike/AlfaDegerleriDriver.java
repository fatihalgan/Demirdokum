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
        
        alfaDegerleri.add(new AlfaDegeri("Arakat - D��eme -(�s� a�a��dan yukar�ya)",7,7));
        alfaDegerleri.add(new AlfaDegeri("Arakat - D��eme -(�s� yukar�dan a�a��ya)",5,5));
        alfaDegerleri.add(new AlfaDegeri("Dolgu zemin - D��eme -(�s� i�ten d��a)",7,7));
        alfaDegerleri.add(new AlfaDegeri("D�� y�zey - D��eme -(�s� i�ten d��a)",5,20));
        alfaDegerleri.add(new AlfaDegeri("D�� y�zey - D�� duvar -(�s� i�ten d��a)",7,20));
        alfaDegerleri.add(new AlfaDegeri("D�� y�zey - Tavan -(�s� i�ten d��a)",7,20));
        alfaDegerleri.add(new AlfaDegeri("�� y�zey - i� duvar",7,7));
        
        PersistenceManagerInt.INSTANCE.serializeAlfaDegerleri(alfaDegerleri);
    }
}
