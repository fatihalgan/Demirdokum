/*
 * Created on 03.Mar.2005
 *
 */
package com.iztek.dd;

import com.iztek.dd.persistence.PersistenceManagerInt;


/**
 * @author Selim HENDRICKSON
 *
 */
public class GenelTanimlarBean {
    private String bayiAdi = "";
    private String muhendisAdi = "";
    private String bayiAdresi = "";
    private String bayiTel = "";
    private static GenelTanimlarBean instance = null;
        
    private GenelTanimlarBean(){
        super();
    }
    
    public String getBayiAdi() {
        return bayiAdi;
    }
    public void setBayiAdi(String bayiAdi) {
        this.bayiAdi = bayiAdi;
    }
    public String getBayiAdresi() {
        return bayiAdresi;
    }
    public void setBayiAdresi(String bayiAdresi) {
        this.bayiAdresi = bayiAdresi;
    }
    public String getBayiTel() {
        return bayiTel;
    }
    public void setBayiTel(String bayiTel) {
        this.bayiTel = bayiTel;
    }
    public String getMuhendisAdi() {
        return muhendisAdi;
    }
    public void setMuhendisAdi(String muhendisAdi) {
        this.muhendisAdi = muhendisAdi;
    }
    
    public static GenelTanimlarBean getInstance(){
        if(instance==null){
            instance = PersistenceManagerInt.INSTANCE.loadGenelTanimlar();
            if(instance==null){
                instance = new GenelTanimlarBean();
            }
        }
        return instance;
    }
}
