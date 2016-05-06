/*
 * Created on 22.Ara.2004
 *
 */
package com.iztek.dd.domain;

import com.iztek.dd.IsiKaybi.domain.DuvarYapiElemani;
import com.iztek.dd.IsiKaybi.domain.KapiYapiElemani;
import com.iztek.dd.IsiKaybi.domain.Radyator;
import com.iztek.dd.IsiKaybi.domain.YapiElemani;
import com.iztek.dd.utilities.Il;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Proje {
	private String projeAdi = "Yeni Proje";
	private String projeMuhendisiAdiSoyadi = null;
	private String projeMuhendisiUnvani = null;
	private String projeMuhendisiSicilNo = null;
	private String adaParsel = null;
	private String binaTanim = null;
	private String caddeBinaNumarasi = null;
	private String semt›lce›l = null;
	private String yakitTuru = null;
	
	private DuvarYapiElemani cogunluklaKullanilanDisDuvar = null;
	private YapiElemani cogunluklaKullanilanIcDuvar = null;
	private YapiElemani cogunluklaKullanilanPencere = null;
	private KapiYapiElemani cogunluklaKullanilanDisKapi = null;
	private KapiYapiElemani cogunluklaKullanilanIcKapi = null;
	
	private Radyator enCokKullanilanRadyatorModeli = null;
	
    private Bolge bolge = null;
    private Il il = null;
	
	public Proje() {
		super();
	}

	//********************************************************************************************************
	// Business Methods **************************************************************************************
	//********************************************************************************************************

	public double getAyaBolgeyeGoreDisSicaklik(String ay){
	    if(il!=null) return bolge.getAyaGoreDisSicaklik(ay); 
//		else SwingUtils.errorMessage("Proje ili seÁili deil! DI˛ s˝cakl˝k 0 olarak kabul ediliyor.");
		return 0;
	}

	//********************************************************************************************************
	// Accessor & Mutator Methods*****************************************************************************
	//********************************************************************************************************

	public Bolge getBolge() {
		return bolge;
	}

	public void setBolge(Bolge projeBolge) {
		this.bolge = projeBolge;
	}
	
	public String getAdaParsel() {
		return adaParsel;
	}
	
	public void setAdaParsel(String adaParsel) {
		this.adaParsel = adaParsel;
	}
	
	public String getBinaTanim() {
		return binaTanim;
	}
	
	public void setBinaTanim(String binaTanim) {
		this.binaTanim = binaTanim;
	}
	
	public String getCaddeBinaNumarasi() {
		return caddeBinaNumarasi;
	}
	
	public void setCaddeBinaNumarasi(String caddeBinaNumarasi) {
		this.caddeBinaNumarasi = caddeBinaNumarasi;
	}
	
	public String getProjeAdi() {
		return projeAdi;
	}
	
	public void setProjeAdi(String projeAdi) {
		this.projeAdi = projeAdi;
	}
	
	public String getProjeMuhendisiAdiSoyadi() {
		return projeMuhendisiAdiSoyadi;
	}
	
	public void setProjeMuhendisiAdiSoyadi(String projeMuhendisiAdiSoyadi) {
		this.projeMuhendisiAdiSoyadi = projeMuhendisiAdiSoyadi;
	}
	
	public String getProjeMuhendisiSicilNo() {
		return projeMuhendisiSicilNo;
	}
	
	public void setProjeMuhendisiSicilNo(String projeMuhendisiSicilNo) {
		this.projeMuhendisiSicilNo = projeMuhendisiSicilNo;
	}
	
	public String getProjeMuhendisiUnvani() {
		return projeMuhendisiUnvani;
	}
	
	public void setProjeMuhendisiUnvani(String projeMuhendisiUnvani) {
		this.projeMuhendisiUnvani = projeMuhendisiUnvani;
	}
	
	public String getSemt›lce›l() {
		return semt›lce›l;
	}
	
	public void setSemt›lce›l(String semt›lce›l) {
		this.semt›lce›l = semt›lce›l;
	}
	
	public String getYakitTuru() {
		return yakitTuru;
	}
	
	public void setYakitTuru(String yakitTuru) {
		this.yakitTuru = yakitTuru;
	}
	
	
    public YapiElemani getCogunluklaKullanilanDisDuvar() {
        return cogunluklaKullanilanDisDuvar;
    }
    
    public void setCogunluklaKullanilanDisDuvar(
            YapiElemani cogunluklaKullanilanDisDuvar) {
        this.cogunluklaKullanilanDisDuvar = (DuvarYapiElemani)cogunluklaKullanilanDisDuvar;
    }
    
    public YapiElemani getCogunluklaKullanilanDisKapi() {
        return cogunluklaKullanilanDisKapi;
    }
    
    public void setCogunluklaKullanilanDisKapi(
            YapiElemani cogunluklaKullanilanDisKapi) {
        this.cogunluklaKullanilanDisKapi = (KapiYapiElemani) cogunluklaKullanilanDisKapi;
    }
    
    public YapiElemani getCogunluklaKullanilanIcDuvar() {
        return cogunluklaKullanilanIcDuvar;
    }
    
    public void setCogunluklaKullanilanIcDuvar(
            YapiElemani cogunluklaKullanilanIcDuvar) {
        this.cogunluklaKullanilanIcDuvar = cogunluklaKullanilanIcDuvar;
    }
    
    public YapiElemani getCogunluklaKullanilanIcKapi() {
        return cogunluklaKullanilanIcKapi;
    }
    
    public void setCogunluklaKullanilanIcKapi(
            YapiElemani cogunluklaKullanilanIcKapi) {
        this.cogunluklaKullanilanIcKapi = (KapiYapiElemani)cogunluklaKullanilanIcKapi;
    }
    
    public YapiElemani getCogunluklaKullanilanPencere() {
        return cogunluklaKullanilanPencere;
    }
    
    public void setCogunluklaKullanilanPencere(
            YapiElemani cogunluklaKullanilanPencere) {
        this.cogunluklaKullanilanPencere = cogunluklaKullanilanPencere;
    }
    /**
     * @return Returns the enCokKullanilanRadyatorModeli.
     */
    public Radyator getEnCokKullanilanRadyatorModeli() {
        return enCokKullanilanRadyatorModeli;
    }
    /**
     * @param enCokKullanilanRadyatorModeli The enCokKullanilanRadyatorModeli to set.
     */
    public void setEnCokKullanilanRadyatorModeli(
            Radyator enCokKullanilanRadyatorModeli) {
        this.enCokKullanilanRadyatorModeli = enCokKullanilanRadyatorModeli;
    }

    public Il getIl(){
        return il;
    }
    
    public void setIl(Il il) {
        this.il = il;
    }
}
