/*
 * Created on 11.Þub.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Isitici {
	private double isiticiKapasitesi = 0;
	private double dolasimIsiKaybi = 0.05;
	private double pompaDebisi = 0;
	private double pompaEmniyetDegeri = 4000;
	private double binaStatikYuksekligi = 0;
	private double suHacmi = 0;
	private double depoHacmi = 0;
	private boolean isPanel = true ;
	private IsiticiModeliInt  secilenIsitici = null;
	private String isiticiTuru = "Kazan"; 
	
	
	public double getDolasimIsiKaybi() {
		return dolasimIsiKaybi;
	}
	public void setDolasimIsiKaybi(double dolasimIsiKaybi) {
		this.dolasimIsiKaybi = dolasimIsiKaybi;
	}
	public double getIsiticiKapasitesi() {
		return isiticiKapasitesi;
	}
	public void setIsiticiKapasitesi(double kazanKapasitesi) {
		this.isiticiKapasitesi = kazanKapasitesi;
	}
	public IsiticiModeliInt getSecilenIsitici() {
		return secilenIsitici;
	}
	public void setSecilenIsitici(IsiticiModeliInt secilenIsitici) {
		this.secilenIsitici = secilenIsitici;
	}	
	public boolean isPanel() {
		return isPanel;
	}
	public void setPanel(boolean isPanel) {
		this.isPanel = isPanel;
	}	
	public String getIsiticiTuru() {
		return isiticiTuru;
	}
	public void setIsiticiTuru(String isiticiTuru) {
		this.isiticiTuru = isiticiTuru;
	}	
	public double hesaplaKazanKapasiteIhtiyaci() {
	    double debug = getIsiticiKapasitesi()*(1+dolasimIsiKaybi)/1000;
		return debug;
	}
	public double hesaplaPompaDebisi(){
		if(isiticiKapasitesi!=0)return (3.6*hesaplaKazanKapasiteIhtiyaci()*1000)/(4.186*1000*20);
		return 0;
	}
	public double getPompaEmniyetDegeri() {
		return pompaEmniyetDegeri;
	}
	public void setPompaEmniyetDegeri(double pompaEmniyetDegeri) {
		this.pompaEmniyetDegeri = pompaEmniyetDegeri;
	}
	public void setStatikYukseklik(double d) {
		binaStatikYuksekligi = d;
	}
	public double getStatikYukseklik(){
		return binaStatikYuksekligi;
	}
	public double hesaplaSuHacmi(){
		return getRadyatorOzgulSuHacmi()*hesaplaKazanKapasiteIhtiyaci();
	}
	public double getRadyatorOzgulSuHacmi(){
		if(isPanel) return 8.33;
		return 12;
	}
	public double hesaplaDepoHacmi() {
		if(hesaplaSuHacmi()!=0){
			double pst = (binaStatikYuksekligi/10)+1;
			return (hesaplaSuHacmi()*0.0286)/(1-(pst/(pst+1)));
		}
		return 0;
	}
}
