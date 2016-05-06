/*
 * Created on 09.Þub.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKazanci.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.iztek.dd.domain.Proje;

/**
 * @author db2admin
 *
 */
public class IsiKazanan {

	private boolean mustakil = true;
	private float icOzgulNem;
	private float disOzgulNem;
	private float icSicaklik = 25.5f;
	private float disSicaklik;
	private float toplamDisDuvarBoyu;
	private float sicaklikFarki;
	private int ay = 0;
	private int saat = 0;
	private Collection isiKazandiranlar = new ArrayList();
	private int toplamIletimYoluylaIsiKazanci;
	private boolean altCLTD;
	private String mobilyaTipi;
	private boolean davlumbazVar;
	private boolean catiRengiKoyu;
	private boolean havaSirkulasyonuVar;
	private Proje proje;
	private float pencereIsiTransferKatsayisi = 0;
	private float disDuvarIsiTransferKatsayisi = 0;
	private String klimaModeli = "";
	
	/**
	 * @return Returns the proje.
	 */
	public Proje getProje() {
		return proje;
	}
/**
	 * @return Returns the davlumbazVar.
	 */
	public boolean isDavlumbazVar() {
		return davlumbazVar;
	}
	/**
	 * @param davlumbazVar The davlumbazVar to set.
	 */
	public void setDavlumbazVar(boolean davlumbazVar) {
		this.davlumbazVar = davlumbazVar;
	}
	/**
	 * @return Returns the mobilyaTipi.
	 */
	public String getMobilyaTipi() {
		return mobilyaTipi;
	}
	/**
	 * @param mobilyaTipi The mobilyaTipi to set.
	 */
	public void setMobilyaTipi(String mobilyaTipi) {
		this.mobilyaTipi = mobilyaTipi;
	}
	/**
	 * @return Returns the altCLTD.
	 */
	public boolean isAltCLTD() {
		return altCLTD;
	}
	/**
	 * @param altCLTD The altCLTD to set.
	 */
	public void setAltCLTD(boolean altCLTD) {
		this.altCLTD = altCLTD;
	}
	/**
	 * 
	 */
	public IsiKazanan() {
		super();
		addIsiKazandiran(new Aydinlatma());
		addIsiKazandiran(new Cihaz());
		addIsiKazandiran(new Insan());
		addIsiKazandiran(new Enfiltrasyon());
	}
	/**
	 * @return Returns the ay.
	 */
	public int getAy() {
		return ay;
	}
	/**
	 * @param ay The ay to set.
	 */
	public void setAy(int ay) {
		this.ay = ay;
	}
	/**
	 * @return Returns the disOzgulNem.
	 */
	public float getDisOzgulNem() {
		return disOzgulNem;
	}
	/**
	 * @param disOzgulNem The disOzgulNem to set.
	 */
	public void setDisOzgulNem(float disOzgulNem) {
		this.disOzgulNem = disOzgulNem;
	}
	/**
	 * @return Returns the disSicaklik.
	 */
	public float getDisSicaklik() {
		return disSicaklik;
	}
	/**
	 * @param disSicaklik The disSicaklik to set.
	 */
	public void setDisSicaklik(float disSicaklik) {
		this.disSicaklik = disSicaklik;
	}
	/**
	 * @return Returns the icOzgulNem.
	 */
	public float getIcOzgulNem() {
		return icOzgulNem;
	}
	/**
	 * @param icOzgulNem The icOzgulNem to set.
	 */
	public void setIcOzgulNem(float icOzgulNem) {
		this.icOzgulNem = icOzgulNem;
	}
	/**
	 * @return Returns the icSicaklik.
	 */
	public float getIcSicaklik() {
		return icSicaklik;
	}
	/**
	 * @param icSicaklik The icSicaklik to set.
	 */
	public void setIcSicaklik(float icSicaklik) {
		this.icSicaklik = icSicaklik;
	}
	/**
	 * @return Returns the mustakil.
	 */
	public boolean isMustakil() {
		return mustakil;
	}
	/**
	 * @param mustakil The mustakil to set.
	 */
	public void setMustakil(boolean mustakil) {
		this.mustakil = mustakil;
	}
	
	/**
	 * @return Returns the saat.
	 */
	public int getSaat() {
		return saat;
	}
	/**
	 * @param saat The saat to set.
	 */
	public void setSaat(int saat) {
		this.saat = saat;
	}
	/**
	 * @return Returns the toplamDisDuvarBoyu.
	 */
	public float getToplamDisDuvarBoyu() {
		return toplamDisDuvarBoyu;
	}
	/**
	 * @param toplamDisDuvarBoyu The toplamDisDuvarBoyu to set.
	 */
	public void setToplamDisDuvarBoyu(float toplamDisDuvarBoyu) {
		this.toplamDisDuvarBoyu = toplamDisDuvarBoyu;
	}
	
	
    public float getDisDuvarIsiTransferKatsayisi() {
        return disDuvarIsiTransferKatsayisi;
    }
    public void setDisDuvarIsiTransferKatsayisi(
            float disDuvarIsiTransferKatsayisi) {
        this.disDuvarIsiTransferKatsayisi = disDuvarIsiTransferKatsayisi;
    }
    public float getPencereIsiTransferKatsayisi() {
        return pencereIsiTransferKatsayisi;
    }
    public void setPencereIsiTransferKatsayisi(float pencereIsiTransferKatsayisi) {
        this.pencereIsiTransferKatsayisi = pencereIsiTransferKatsayisi;
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Pencere) ((Pencere)next).setIsiTransferiKatsayisi(pencereIsiTransferKatsayisi);        
        }		
    }
	
    
    public float getSicaklikFarki() {
        return sicaklikFarki;
    }
    public void setSicaklikFarki(float sicaklikFarki) {
        this.sicaklikFarki = sicaklikFarki;
    }
    
    public String getKlimaModeli() {
        return klimaModeli;
    }
    public void setKlimaModeli(String klimaModeli) {
        this.klimaModeli = klimaModeli;
    }
    public void addIsiKazandiran(IsiKazandiran isiKazandiran) {
		isiKazandiranlar.add(isiKazandiran);
	}
	
		
	public int hesaplaToplamIletimYoluylaIsiKazanci() {
		int toplamIsiKazanci = 0;
		Iterator it = isiKazandiranlar.iterator();
		while(it.hasNext()) {
			IsiKazandiran isiKazandiran = (IsiKazandiran)it.next();
			toplamIsiKazanci = toplamIsiKazanci + isiKazandiran.hesaplaIletimYoluylaToplamIsiKazanci(this);
		}
		return toplamIsiKazanci;
	}
	public int hesaplaToplamRadyasyonYoluylaIsiKazanci(){
		int toplamIsiKazanci = 0;
		Iterator it = isiKazandiranlar.iterator();
		while(it.hasNext()) {
			IsiKazandiran isiKazandiran = (IsiKazandiran)it.next();
			if(isiKazandiran instanceof Pencere)toplamIsiKazanci = toplamIsiKazanci + ((Pencere)isiKazandiran).hesaplaRadyasyonYoluylaGelenIsiKazanci(this);
		}
		return toplamIsiKazanci;	    
	}
	public int hesaplaAydinlatmaIsiKazanci(){
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Aydinlatma) return ((Aydinlatma)next).hesaplaToplamIsiKazanci(this);        
        }		   
        return 0;
	}
	public double hesaplaDuzeltmeFaktoru() {
		return 1 - (0.0116 * hesaplaBirimBoyBasinaIsilIletkenlik()); 
	}
	
	private double hesaplatoplamUA() {
		double toplamUA = 0;
		Iterator it = isiKazandiranlar.iterator();
		while(it.hasNext()) {
			IsiKazandiran isiKazandiran = (IsiKazandiran)it.next();
			if(isiKazandiran instanceof YapiElemani)
				toplamUA = toplamUA + (((YapiElemani)isiKazandiran).getIsiTransferiKatsayisi() * ((YapiElemani)isiKazandiran).getAlan());  
		}
		return toplamUA;
	}
	
	private double hesaplaBirimBoyBasinaIsilIletkenlik() {
		return (1/toplamDisDuvarBoyu) * hesaplatoplamUA();
	}
	
	public double getOrtalamaDisOrtamSicakligi() {
	    float ortalamaSicaklik = disSicaklik - (sicaklikFarki/2);
		return ortalamaSicaklik;
	}
    
	public void removeIsiKazandiran(String removedIdentifier) {
        ArrayList yeniList = new ArrayList();
        Iterator it = isiKazandiranlar.iterator();        
        while(it.hasNext()){
            IsiKazandiran eleman = (IsiKazandiran) it.next();
            if(eleman instanceof DisDuvar || eleman instanceof Pencere){
                if(!((YapiElemani)eleman).getIdentifier().equals(removedIdentifier)){
                    yeniList.add(eleman);
                }
            }
        }
        isiKazandiranlar = yeniList;
    }
    
    public IsiKazandiran getIsiKazandiran(String selectedDisDuvarIdentifier) {
        Iterator it = isiKazandiranlar.iterator();        
        while(it.hasNext()){
            IsiKazandiran eleman = (IsiKazandiran) it.next();
            if(eleman instanceof DisDuvar || eleman instanceof Pencere){
                if(((YapiElemani)eleman).getIdentifier().equals(selectedDisDuvarIdentifier)){
                    return eleman;
                }
            }
        }
        return null;
    }
    public Cati getCati() {
        Iterator it = isiKazandiranlar.iterator();        
        while(it.hasNext()){
            IsiKazandiran eleman = (IsiKazandiran) it.next();
            if(eleman instanceof Cati) return (Cati) eleman;                                                          
        }
        return null;        
    }
    public IcDuvar getIcDuvar() {
        Iterator it = isiKazandiranlar.iterator();        
        while(it.hasNext()){
            IsiKazandiran eleman = (IsiKazandiran) it.next();
            if(eleman instanceof IcDuvar) return (IcDuvar) eleman;                                                          
        }
        return null;        
    }

    public void deleteCati() {
        isiKazandiranlar.remove(getCati());
    }
    public void deleteIcDuvar() {
        isiKazandiranlar.remove(getIcDuvar());
    }
    public void setPencerelerGolgelemeli(boolean b) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Pencere) ((Pencere)next).setGolgelemeYapilmis(b);
        }
    }
    public void setCamTipi(String command) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Pencere) ((Pencere)next).setCamTipi(command);        
        }		
    }
    public void setPencereKalinliklari(float f) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Pencere) ((Pencere)next).setKalinlik(f);        
        }		
    }
    public void setPencereGolgelemeTipi(String command) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Pencere) ((Pencere)next).setGolgelemeTipi(command);        
        }		
    }
    public void setAydinlatmaTip(String string) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Aydinlatma) ((Aydinlatma)next).setTip(string);        
        }		        
    }
    public void setAydinlatmaSuresi(String actionCommand) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Aydinlatma) ((Aydinlatma)next).setAydinlatmaSuresi(Integer.parseInt(actionCommand));        
        }		        
    }
    public void setAydinlatmaGecenSure(String actionCommand) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Aydinlatma) ((Aydinlatma)next).setIsikYandiktanSonraGecenSure(Integer.parseInt(actionCommand));        
        }		        
    }
    public void setAydinlatmaEkipmanGucu(double guc) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Aydinlatma) ((Aydinlatma)next).setGuc(guc);        
        }		        
    }
    public void setInsanAktivite(Aktivite aktivite) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Insan){
                ((Insan)next).setAktiviteTuru(aktivite.getTip());        
                ((Insan)next).setLHG(aktivite.getGizliIsi());
                ((Insan)next).setSHG(aktivite.getDuyulurIsi());
            }
        }		                
    }
    public void setHacimdeKalmaSuresi(String string) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Insan) ((Insan)next).setHacimdeToplamKalmaSuresi(Integer.parseInt(string));        
        }		                
    }
    public void setHacimdeGecenSure(String string) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Insan) ((Insan)next).setHacimeGirdiktenSonraGecenZaman(Integer.parseInt(string));        
        }		                
    }
    public void setInsanSayisi(int i) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Insan) ((Insan)next).setInsanSayisi(i);        
        }		                
    }
    public int hesaplaInsanardanIsiKAzanci() {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Insan) return ((Insan)next).hesaplaToplamIsiKazanci(this);        
        }	
        return 0;
    }
    public void setCihazDavlumbazli(boolean selected) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Cihaz) ((Cihaz)next).setDavlumbazli(selected);        
        }	       
    }    
    public void setCihazCalismaSuresi(String selectedValue) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Cihaz) ((Cihaz)next).setCalistigiToplamSaat(Integer.parseInt(selectedValue));        
        }	               
    }
    public void setCihazIsletmeSuresi(String selectedValue) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Cihaz) ((Cihaz)next).setIsletmeyeAlindiktanSonraGecenSaat(Integer.parseInt(selectedValue));        
        }	                       
    }
    public void setCihazToplamGucu(double d) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Cihaz) ((Cihaz)next).setGuc(d);        
        }	                               
    }
    public int hesaplaCihazlardanGelenToplamYuk() {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Cihaz) return ((Cihaz)next).hesaplaToplamIsiKazanci(this);        
        }	                               
        return 0;
    }
    public void setEnfiltrasyonHavaDebisi(double d) {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Enfiltrasyon) ((Enfiltrasyon)next).setHavaDebisi(d);        
        }	                               
    }
    public double hesaplaEnfiltrasyonYuku() {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Enfiltrasyon) return ((Enfiltrasyon)next).hesaplaToplamIsiKazanci(this);        
        }	                               
        return 0;
    }
    public double hesaplaToplamIsiKazanci() {
        double toplamKazanc = 0;
        toplamKazanc += hesaplaToplamIletimYoluylaIsiKazanci();
        toplamKazanc += hesaplaToplamRadyasyonYoluylaIsiKazanci();
        toplamKazanc += hesaplaAydinlatmaIsiKazanci();
        toplamKazanc += hesaplaCihazlardanGelenToplamYuk();
        toplamKazanc += hesaplaEnfiltrasyonYuku();
        toplamKazanc += hesaplaInsanardanIsiKAzanci();
        return toplamKazanc;
    }    
    public Collection getIsiKazandiranlar() {
        return isiKazandiranlar;
    }

    public Aydinlatma getAydinlatma(){
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Aydinlatma) return ((Aydinlatma)next);        
        }	
        return null;
    }
    public Cihaz getCihaz() {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Cihaz) return ((Cihaz)next);        
        }	                               
        return null;
    }
    public Insan getInsan() {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Insan) return ((Insan)next);        
        }		                
        return null;
    }
    public Enfiltrasyon getEnfiltrasyon() {
        Iterator it = isiKazandiranlar.iterator();
        while(it.hasNext()){
            Object next = it.next();
            if(next instanceof Enfiltrasyon) return ((Enfiltrasyon)next);        
        }	                               
        return null;
    }
}

