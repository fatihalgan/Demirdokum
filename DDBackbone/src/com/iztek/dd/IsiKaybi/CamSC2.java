
package com.iztek.dd.IsiKaybi;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Yasin
 */
public class CamSC2 {
	
	private int camKalinligi;
	private ArrayList jaluziRengi = new ArrayList();
	private ArrayList dikeyPerde = new ArrayList();
		
	public int getCamKalinligi() {
		return camKalinligi;
	}
	
	public void setCamKalinligi(int camKalinligi) {
		this.camKalinligi = camKalinligi;
	}
	
	public ArrayList getDikeyPerde() {
		return dikeyPerde;
	}
	
	public void setDikeyPerde(ArrayList dikeyPerde) {
		this.dikeyPerde = dikeyPerde;
	}
	
	public ArrayList getJaluziRengi() {
		return jaluziRengi;
	}
	
	public void setJaluziRengi(ArrayList jaluziRengi) {
		this.jaluziRengi = jaluziRengi;
	}
	
	public void addJaluziRengi(String key, double value){
		jaluziRengi.add(new KeyValueBean(key,value));
	}
	
	public void addDikeyPerde(String key, double value){
		dikeyPerde.add(new KeyValueBean(key,value));
	}
	
	public double getSCvalue(String golgelemeTipi){
	    double value = 0;
	    if(golgelemeTipi=="JK"){
	        Iterator it = jaluziRengi.iterator();
	        while(it.hasNext()){
	            KeyValueBean bean = (KeyValueBean)it.next();
	            if(bean.getKey().equals("koyu")) return bean.getValue();
	        }
	    }
	    if(golgelemeTipi=="JA"){
	        Iterator it = jaluziRengi.iterator();
	        while(it.hasNext()){
	            KeyValueBean bean = (KeyValueBean)it.next();
	            if(bean.getKey().equals("açýk")) return bean.getValue();
	        }
	    }
	    if(golgelemeTipi=="PK"){
	        Iterator it = dikeyPerde.iterator();
	        while(it.hasNext()){
	            KeyValueBean bean = (KeyValueBean)it.next();
	            if(bean.getKey().equals("koyu")) return bean.getValue();
	        }
	    }
	    if(golgelemeTipi=="PA"){
	        Iterator it = dikeyPerde.iterator();
	        while(it.hasNext()){
	            KeyValueBean bean = (KeyValueBean)it.next();
	            if(bean.getKey().equals("açýk")) return bean.getValue();
	        }
	    }
	    if(golgelemeTipi=="PI"){
	        Iterator it = dikeyPerde.iterator();
	        while(it.hasNext()){
	            KeyValueBean bean = (KeyValueBean)it.next();
	            if(bean.getKey().equals("ýþýk geçirgen")) return bean.getValue();
	        }
	    }
	    return value;
	}
}



