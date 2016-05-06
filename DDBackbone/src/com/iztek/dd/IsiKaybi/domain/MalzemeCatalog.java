/*
 * Created on 06.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class MalzemeCatalog {
    private ArrayList malzemeler = null;
    private static MalzemeCatalog instance = null;
    private boolean dirty = false;
    
    private MalzemeCatalog(){
       malzemeler = PersistenceManagerInt.INSTANCE.loadIsiKaybiMalzemeler();
    }
    
    public static MalzemeCatalog getInstance(){
        if(instance==null) instance = new MalzemeCatalog();
        return instance;
    }
    
    public ArrayList getMalzemeler(){
        return malzemeler;
    }
    
    public void setMalzemeler(ArrayList malzemeler){
        this.malzemeler = malzemeler;
    }

    public void serializeSelfToXML(){
        if(dirty){
            PersistenceManagerInt.INSTANCE.serializeIsiKaybiMalzemelerToXML(malzemeler);
            dirty = false;            
        }
    }

//    public void addMalzeme(Malzeme malzeme) {
//        malzemeler.add(malzeme);
//    }

    
    public boolean isDirty() {
        return dirty;
    }
    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
}
