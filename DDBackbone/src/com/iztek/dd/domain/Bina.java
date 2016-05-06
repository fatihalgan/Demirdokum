/*
 * Created on 15.Ara.2004
 *
 */
package com.iztek.dd.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.iztek.dd.domain.Havalandirma.DogalHavalandirma;
import com.iztek.dd.domain.Havalandirma.HavalandirmaInt;
import com.iztek.dd.domain.Havalandirma.MekanikHavalandirma;
import com.iztek.dd.domain.IsiGecirgenligi.DisaAcik;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Bina {
	private double icSicaklik = 19;
	private double brutHacim = 0;
	private double binaKullanimAlani = 0;
	private double golgelenmeFaktoru = 0;
	private double enerjiKullanimKatsayisi = 0;
	private double aylikSure = 86400 * 30;
	private double odaYuksekligi = 0;
	private double enDusukDisSicaklik = 0;

	private Proje proje = new Proje();
	private HavalandirmaInt havalandirma;
	private Collection yapiElemanlari = new ArrayList();
	private ArrayList gunesEnerjisiKazanclari = new ArrayList();
	
	public Bina() {
		super();
		
		GunesEnerjisiKazanci kazanc = new GunesEnerjisiKazanci();
		kazanc.setYon("GUNEY");
		gunesEnerjisiKazanclari.add(kazanc);
		
		kazanc = new GunesEnerjisiKazanci();
		kazanc.setYon("KUZEY");
		gunesEnerjisiKazanclari.add(kazanc);
		
		kazanc = new GunesEnerjisiKazanci();
		kazanc.setYon("BATI");
		gunesEnerjisiKazanclari.add(kazanc);
		
		kazanc = new GunesEnerjisiKazanci();
		kazanc.setYon("DOGU");
		gunesEnerjisiKazanclari.add(kazanc);
	}

	//********************************************************************************************************
	// Business Methods **************************************************************************************
	//********************************************************************************************************
	
	public double hesaplaOzgulIletimselIsiKaybi(){
		double ozgunIletimselIsiKaybi = 0; 
		Iterator it = getYapiElemanlari().iterator();
		while(it.hasNext()){
			double debugTemp = ((IsiKaybeden)it.next()).hesaplaOzgulIletimselIsiKaybi();
			ozgunIletimselIsiKaybi += debugTemp; 
		}
		return ozgunIletimselIsiKaybi;
	}
	
	public double hesaplaToplamOzgulIsiKaybi(){
	    double debug = hesaplaOzgulIletimselIsiKaybi() + hesaplaHavalandirmaOzgulIsiKaybi(); 
		return debug;
	}

	public double hesaplaAyaBolgeyeGoreSicaklikFarki(String ay){
	    double debug = getIcSicaklik() - getProje().getAyaBolgeyeGoreDisSicaklik(ay);	    
		return debug > 0 ? debug : 0;
	}

	public double hesaplaAylikIsiKaybi(String ay){
	    double aylikIsiKaybi = hesaplaToplamOzgulIsiKaybi() * hesaplaAyaBolgeyeGoreSicaklikFarki(ay);	    
		return aylikIsiKaybi > 0 ? aylikIsiKaybi : 0;
	}
	
	public double hesaplaIcIsiKazanci(){
	    double debug = getBinaKullanimAlani() * getEnerjiKullanimKatsayisi(); 
		return debug;
	}	

	public double hesaplaGunesEnerjisiKazanci(){
		double toplamGunesEnerjisiKazanci = 0;
		Iterator it = gunesEnerjisiKazanclari.iterator();
		while(it.hasNext()){
			double temp = ((GunesEnerjisiKazanci)it.next()).hesaplaGunesEnerjisiKazanci(getGolgelenmeFaktoru());
			toplamGunesEnerjisiKazanci += temp; 
		}
		return toplamGunesEnerjisiKazanci;
	}
	
	public double hesaplaAylikGunesEnerjisiKazanci(String ay){
	    double aylikGunesEnerjisiKazanci = 0;
	    Iterator it = gunesEnerjisiKazanclari.iterator();
	    while(it.hasNext()){
	        aylikGunesEnerjisiKazanci += ((GunesEnerjisiKazanci)it.next()).hesaplaAylikGunesEnerjisi(ay,getGolgelenmeFaktoru());
	    }
	    return aylikGunesEnerjisiKazanci;
	}
	
	public double hesaplaToplamAylikIsiKazanci(String ay){
	    double toplamAylikIsiKazanci = hesaplaIcIsiKazanci() + hesaplaAylikGunesEnerjisiKazanci(ay); 
	    return toplamAylikIsiKazanci;
	}
	
	public double hesaplaKazancKullanimOrani(String ay){
	    double kazancKullanimOrani = hesaplaToplamAylikIsiKazanci(ay) / hesaplaAylikIsiKaybi(ay);
	    return kazancKullanimOrani >= 2.5 ? 0 : kazancKullanimOrani ; 
	}
	
	public double hesaplaAylikKazancKullanimFaktoru(String ay){
	    double aylikKazancKullanimFaktoru = 1-Math.pow(Math.E,(-1/hesaplaKazancKullanimOrani(ay))); 
	    return aylikKazancKullanimFaktoru > 0 ? aylikKazancKullanimFaktoru : 0;
	}
	
	public double hesaplaAylikIsitmaEnerjisiIhtiyaci(String ay){
	    double aylikIsitmaEnerjisiIhtiyaci = (hesaplaAylikIsiKaybi(ay) - hesaplaAylikKazancKullanimFaktoru(ay) * hesaplaToplamAylikIsiKazanci(ay)) * getAylikSure();
	    return aylikIsitmaEnerjisiIhtiyaci > 0 ? aylikIsitmaEnerjisiIhtiyaci : 0; 
	}

	public double hesaplaToplamYillikIsitmaEnerjisiIhtiyaci(){
	    double toplamYillikIsitmaEnerjisiIhtiyaci = 0;
	    for(int i = 1 ; i < 13 ; i++){
	        toplamYillikIsitmaEnerjisiIhtiyaci += hesaplaAylikIsitmaEnerjisiIhtiyaci(""+i);
	    }
	    
	    return toplamYillikIsitmaEnerjisiIhtiyaci;///1000 * 0.278 * 0.001; //kJ çevrimi
	}
	
	public double hesaplaToplamAlan(){
	    double toplamAlan = 0;
	    Iterator it = yapiElemanlari.iterator();
	    while(it.hasNext()){
	        toplamAlan += ((IsiKaybeden) it.next()).getAlan();
	    }
	    return toplamAlan;
	}
	
	public double hesaplaStandartYillikIsitmaEnerjisiIhtiyaci(){
	    double standartYillikIsitmaEnerjisiIhtiyaci = 0;
	    double oran = hesaplaToplamAlanBrutHacimOrani();
	    
	    if(oran < 1.05 && oran > 0.2){
	        standartYillikIsitmaEnerjisiIhtiyaci = getProje().getBolge().hesaplaStandartIhtiyac(oran,getOdaYuksekligi());
	    }
	    else{
	        if(getProje().getBolge()!=null)
	        standartYillikIsitmaEnerjisiIhtiyaci = getProje().getBolge().readStandartIhtiyac(oran,getOdaYuksekligi());
	    }
	    
	    return standartYillikIsitmaEnerjisiIhtiyaci;
	}
	
	public double hesaplaToplamAlanBrutHacimOrani() {
		double oran = hesaplaToplamAlan()/getBrutHacim();
		return oran;
	}

	public boolean kontrolStandartaUygunluk(){
		double toplamYillikIsitmaEnerjisiIhtiyaci = hesaplaToplamYillikIsitmaEnerjisiIhtiyaci() * 0.278 * 0.001;
		if(getOdaYuksekligi()<=2.6) return (toplamYillikIsitmaEnerjisiIhtiyaci / getBinaKullanimAlani()) < hesaplaStandartYillikIsitmaEnerjisiIhtiyaci() ? true : false; 
		if(getOdaYuksekligi()>2.6) return (toplamYillikIsitmaEnerjisiIhtiyaci / getBrutHacim()) < hesaplaStandartYillikIsitmaEnerjisiIhtiyaci() ? true : false;
		return false;
	}
	

	
	//********************************************************************************************************
	// Accessor & Mutator Methods ****************************************************************************
	//********************************************************************************************************
	
	public Proje getProje() {
		return proje;
	}

	public void setProje(Proje proje) {
		this.proje = proje;
	}
	
	public double getEnerjiKullanimKatsayisi() {
		return enerjiKullanimKatsayisi;
	}

	public void setEnerjiKullanimKatsayisi(double enerjiKullanimKatsayisi) {
		if(enerjiKullanimKatsayisi==5 || enerjiKullanimKatsayisi ==10)
			this.enerjiKullanimKatsayisi = enerjiKullanimKatsayisi;
		else throw new RuntimeException("Enerji Kullaným Katsayýsý Geçersiz!");
	}	
	
	public double getBinaKullanimAlani() {
		return 0.32 * getBrutHacim();
	}

	public void setBinaKullanimAlani(double binaKullanimAlani) {
		this.binaKullanimAlani = binaKullanimAlani;
	}

	public double getBrutHacim() {
		return brutHacim;
	}

	public void setBrutHacim(double brutHacim) {
		this.brutHacim = brutHacim;
	}

	public double getIcSicaklik() {
		return icSicaklik;
	}

	public void setIcSicaklik(double icSicaklik) {
		this.icSicaklik = icSicaklik;
	}

	public HavalandirmaInt getHavalandirma() {
		return havalandirma;
	}

	public void setHavalandirma(HavalandirmaInt havalandirma) {
		this.havalandirma = havalandirma;
	}
		
	public Collection getYapiElemanlari() {
		return yapiElemanlari;
	}

	public void setYapiElemanlari(Collection yapiElemanlari) {
		this.yapiElemanlari = yapiElemanlari;
	}
	
	public void addYapiElemani(IsiKaybeden yapiElemani){
		getYapiElemanlari().add(yapiElemani);
	}
	
	public void deleteYapiElemani(String identifier){
		Iterator it = yapiElemanlari.iterator();
		while(it.hasNext()){
			BilesikYapiElemani nextYapiElemani = (BilesikYapiElemani) it.next();
			if(nextYapiElemani.getIdentifier().equals(identifier)) yapiElemanlari.remove(nextYapiElemani);
			break;
		}				
	}
	
	public double getGolgelenmeFaktoru() {
		return golgelenmeFaktoru;
	}

	public void setGolgelenmeFaktoru(double golgelenmeFaktoru) {
		this.golgelenmeFaktoru = golgelenmeFaktoru;
	}
	
	public void addGunesEnerjisiKazanci(GunesEnerjisiKazanci kazanc){
		getGunesEnerjisiKazanclari().add(kazanc);
	}
	
	public ArrayList getGunesEnerjisiKazanclari() {
		return gunesEnerjisiKazanclari;
	}	
	
    public double getAylikSure() {
        return aylikSure;
    }

    public void setAylikSure(double aylikSure) {
        this.aylikSure = aylikSure;
    }
    
	public double getOdaYuksekligi() {
		return odaYuksekligi;
	}

	public void setOdaYuksekligi(double odaYuksekligi) {
		this.odaYuksekligi = odaYuksekligi;
	}

	public double getEnDusukDisSicaklik() {
		return enDusukDisSicaklik;
	}

	public void setEnDusukDisSicaklik(double enDusukDisSicaklik) {
		this.enDusukDisSicaklik = enDusukDisSicaklik;
	}
	
	//********************************************************************************************************
	// GRASP Methods *****************************************************************************************
	//********************************************************************************************************

	public void createDogalHavalandýrma(){
		setHavalandirma(new DogalHavalandirma());
	}
	
	public void createMekanikHavalandýrma(){
		setHavalandirma(new MekanikHavalandirma());
	}

	public void createDisDuvar(String identifier) {
		BilesikYapiElemani disDuvar = new DisaAcikDuvar(identifier,new DisaAcik());
		yapiElemanlari.add(disDuvar);
	}

	public Object getYapiElemani(String identifier) {
		Iterator it = yapiElemanlari.iterator();
		while(it.hasNext()){
			IsiKaybeden nextYapiElemani = (IsiKaybeden) it.next();
			if(nextYapiElemani.getIdentifier().equals(identifier)) return nextYapiElemani;
		}
		return null;
	}
	
	public double hesaplaHavalandirmaOzgulIsiKaybi(){
		if(havalandirma!=null){
		    havalandirma.setBrutHacim(getBrutHacim());
		    return havalandirma.hesaplaHavalandirmaOzgulIsiKaybi();			
		}
		return 0;
	}

    public void setPencereAlani(String yon, String yoneGorePencereAlani) {
        double pencereAlani = Double.parseDouble(yoneGorePencereAlani);
        GunesEnerjisiKazanci kazanc = getYoneGoreGunesEnerjisiKazanci(yon);
        kazanc.setPencereAlani(pencereAlani);
    }
	
    public GunesEnerjisiKazanci getYoneGoreGunesEnerjisiKazanci(String yon){
        GunesEnerjisiKazanci kazanc = null;
        Iterator it = gunesEnerjisiKazanclari.iterator();
        while(it.hasNext()){
            kazanc = (GunesEnerjisiKazanci)it.next();
            if(kazanc.getYon().equals(yon)) return kazanc;
        }
        return null;
    }
    
    public double getToplamPencereAlani(){
        double toplamPencereAlani = 0;
        GunesEnerjisiKazanci kazanc = null;
        Iterator it = gunesEnerjisiKazanclari.iterator();
        while(it.hasNext()){
            kazanc = (GunesEnerjisiKazanci)it.next();
            toplamPencereAlani += kazanc.getPencereAlani();
        }
        return toplamPencereAlani;        
    }
    
    public Pencere createPencere(){
        Pencere pencere = new Pencere();
        addYapiElemani(pencere);
        return pencere;
    }
}
