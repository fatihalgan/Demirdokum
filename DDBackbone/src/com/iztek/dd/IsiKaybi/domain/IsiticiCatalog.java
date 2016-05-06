/*
 * Created on 11.Þub.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Iterator;

import com.iztek.dd.persistence.PersistenceManagerInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class IsiticiCatalog {
	ArrayList isiticilar = new ArrayList();
	private static IsiticiCatalog instance = null;
	
	private IsiticiCatalog(){
	    isiticilar = PersistenceManagerInt.INSTANCE.loadIsiticilar();
	}
	
	public static IsiticiCatalog getInstance(){
	    if(instance==null) instance = new IsiticiCatalog();
	    return instance;
	}
		
    public ArrayList getKazanlar(double kazanGucu, String yakitTipi){
        ArrayList filteredKazanlar = new ArrayList();
        Iterator it = isiticilar.iterator();
        while(it.hasNext()){
            IsiticiModeliInt isitici = (IsiticiModeliInt) it.next(); 
            if(isitici instanceof KazanModeli){
                KazanModeli kazan = (KazanModeli) isitici;
                if(kazan.getGuc()>kazanGucu&&kazan.getYakitTipi().equals(yakitTipi)) filteredKazanlar.add(kazan);
                
            }
        }
        
        return filteredKazanlar;
    }

    public ArrayList getKombiler(double kombiGucu, boolean hermetik) {
        ArrayList filteredKombiler = new ArrayList();
        Iterator it = isiticilar.iterator();
        while(it.hasNext()){
            IsiticiModeliInt isitici = (IsiticiModeliInt) it.next();
            if(isitici instanceof KombiModeli){
                KombiModeli kombi = (KombiModeli) isitici;
                if(kombi.getGuc()>kombiGucu&&kombi.isHermetik()==hermetik) filteredKombiler.add(kombi);
            }            
        }        
        return filteredKombiler;
    }

    public ArrayList getKatKaloriferleri(double isiticiGucu, double yakitTipi) {
        ArrayList filteredKatKaloriferleri = new ArrayList();
        Iterator it = isiticilar.iterator();
        while(it.hasNext()){
            IsiticiModeliInt isitici = (IsiticiModeliInt) it.next();
            if(isitici instanceof KatKaloriferiModeli){
                KatKaloriferiModeli katKaloriferi = (KatKaloriferiModeli) isitici;
                double guc = katKaloriferi.getGuc();
                if(guc>isiticiGucu){
                    if(katKaloriferi.getYakitTipi()==yakitTipi){
                        filteredKatKaloriferleri.add(katKaloriferi);
                    }
                }
            }            
        }        
        return filteredKatKaloriferleri;
    }

    public KaskatModeli getKaskatModeli(double isiticiGucu, boolean hermetik, boolean boylerli){
        KaskatModeli model = null;
        Iterator it = isiticilar.iterator();
        while(it.hasNext()){
            IsiticiModeliInt isitici = (IsiticiModeliInt) it.next();
            if(isitici instanceof KaskatModeli){
                KaskatModeli nextModel = (KaskatModeli) isitici;
                if(nextModel.isHermetik()==hermetik){
                    if(nextModel.isBoylerli()==boylerli){
                        if(nextModel.getGuc()==isiticiGucu) return nextModel;
                    }
                }
            }
        }    
        return null;
    }
}
