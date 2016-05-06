/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.iztek.dd.GenelTanimlarBean;
import com.iztek.dd.IsiKazanci.domain.CamSCs;
import com.iztek.dd.domain.Bolge;
import com.iztek.dd.utilities.Malzeme;

/**
 * @author Selim HENDRICKSON
 *
 */
public interface PersistenceManagerInt {
	public static final PersistenceManagerInt INSTANCE = (PersistenceManagerInt) PluginFactory.getPlugin(PersistenceManagerInt.class);
	
	public HashMap loadGunesIsinimSiddetleri();
	public HashMap loadCamCLFs();
	public HashMap loadCatiCLTDs();
	public HashMap loadDuvarCLTDs();
	public HashMap loadCamCLFs2();
	public ArrayList loadCamCLTDs();
	
	public HashMap loadDisSicakliklar();
	public Bolge loadBolge(String bolgeAdi);
    public HashMap loadYonZamlar();
    public HashMap loadIsletmeTipiZamlar(); 
    public Malzeme loadMalzemeler();
    public ArrayList loadCogunluklaKullanilanYapiElemanlari();
    public ArrayList loadRadyatorler();
    public ArrayList loadIcSicakliklar();
    public ArrayList loadBasincKaybiCizelgesi();
    public HashMap loadZetaDirencleri();
    public ArrayList loadOzelDirencler();
    public HashMap loadIsitilmayanBolgeSicakliklari();
	public ArrayList loadBolgeyeGoreStandartBilesenDirencleri();
	public ArrayList loadGenlesmeDepolari();
    public HashMap loadDisSicaklikDegerleri();
    public CamSCs loadCamSCs();
    public HashMap loadCamSC2s();
    public HashMap loadDuvarSHGFs();
    public HashMap loadAydinlatmaCLF12s();
    public HashMap loadAydinlatmaCLF8s();
    public ArrayList loadAktiviteler();
    public HashMap loadDavlumbazliCihazCLFs();
    public HashMap loadDavlumbazsizCihazCLFs();
    public HashMap loadInsanCLFs();
    public ArrayList loadIsiticilar();
    public ArrayList loadKlimalar();
    public ArrayList loadEkipmanlar();
    public GenelTanimlarBean loadGenelTanimlar();
    public void saveGenelTanimlar(GenelTanimlarBean bean);
    public ArrayList loadIsiKaybiMalzemeler();
    public void serializeIsiKaybiMalzemelerToXML(ArrayList malzemeler);
    public void serializeCogunluklaKullanilanYapiElemanlari(ArrayList yapiElemanlari);
    public ArrayList loadAlphaDegerleri();
    public void serializeAlfaDegerleri(ArrayList alfaDegerleri);
}
