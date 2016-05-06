/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class AlfaDegerleriCatalog {
    private ArrayList alphaDegerleri = null;
    private static AlfaDegerleriCatalog instance = null;
    
    private AlfaDegerleriCatalog(){
        alphaDegerleri = PersistenceManagerInt.INSTANCE.loadAlphaDegerleri();
    }
    
    public static AlfaDegerleriCatalog getInstance(){
        if(instance==null) instance = new AlfaDegerleriCatalog();
        return instance;
    }
    
    public AlfaDegeri getAlfaDegeri(int index){
        return (AlfaDegeri)alphaDegerleri.get(index);
    }
    public ArrayList getAlfaDegerleri(){
        return alphaDegerleri;
    }
    
    public void addAlfaDegeri(AlfaDegeri alfaDegeri){        
        alphaDegerleri.add(alfaDegeri);        
    }
    
    public void removeAlfaDegeri(AlfaDegeri alfaDegeri){
        alphaDegerleri.remove(alfaDegeri);
    }
    public void serializeSelf(){
        PersistenceManagerInt.INSTANCE.serializeAlfaDegerleri(alphaDegerleri);
    }
}
