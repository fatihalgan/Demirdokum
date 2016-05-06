
package com.iztek.dd.aktarim.model.camSC;

import java.util.ArrayList;

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
	
}



