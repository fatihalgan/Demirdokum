/*
 * Created on 27.Ara.2004
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;
import com.iztek.dd.IsiKaybi.Zamlar;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Mahal implements TreeItemInt{
    private int mahalId = 0;
    
    private String mahalAdi = "";
    private String mahalkodu = "";
    private int radyatorGrupSayisi = 0;
    private double icSicaklik = 0;
    private double odaDurumKatsayisi = 0;
    private double koseAciklikEtkiKatsayisi = 1;
    private double toplamSinirlayanAlan = 0;    
    private double pencereAltiYuksekligi = 0;
    private double artirimliIsiKaybi = 0;
    private double artirimsizIsiKaybi = 0;
    private double zamOrani = 0;
    private double sizintiIsiKaybi = 0;
    private double toplamIsiKaybi = 0;
    double yoneGoreZam = 0;
    double katYuksekligiZammi = 0;
    double isletmeZammi = 0;
    double toplamZamOrani = 0;
    
    private String radyatorModeli = null;
    private String yon = "K" ;
    private Collection yapiElemanlari = new ArrayList();
    
    private Kat kat = null;
    
	private static final String ITEM_NAME = "Mahal";
	private static final String ICON_URN = "/com/iztek/dd/GUI/images/Mahal.gif";
	private static final String[] MENU_CHOICES = {"Duvar/Döþeme/Tavan"};
    
    public Mahal(double odaDurumKatsayisi){
        this.odaDurumKatsayisi = odaDurumKatsayisi;
    }
    
	//********************************************************************************************************
	// Business Methods **************************************************************************************
	//********************************************************************************************************
    
    public double hesaplaArtirimsizIsiKaybi(){
        artirimsizIsiKaybi = 0;
        Iterator it = yapiElemanlari.iterator();
        while(it.hasNext()){
            YapiElemani yapiElemani = (YapiElemani)it.next();
            yapiElemani.setIcSicaklik(getIcSicaklik());
            artirimsizIsiKaybi += yapiElemani.hesaplaIsiKaybi();
        }
        return artirimsizIsiKaybi; 
    }
    
    public double hesaplaSizintiIsiKaybi(double binaDurumKatsayisi, double disSicaklik, double sizdirganlikKatsayisi){
        double sizintiHavaDebisi = 0;
        Iterator it = yapiElemanlari.iterator();
        while(it.hasNext()){
            TemelYapiElemani yapiElemani = (TemelYapiElemani)it.next();
            yapiElemani.setIcSicaklik(getIcSicaklik());
            sizintiHavaDebisi += yapiElemani.hesaplaToplamSizintiHavaDebisi(sizdirganlikKatsayisi);
        }
        sizintiIsiKaybi = (1/3.6) * sizintiHavaDebisi * getOdaDurumKatsayisi() * binaDurumKatsayisi * (getIcSicaklik() - disSicaklik) * getKoseAciklikEtkiKatsayisi(); 
        return sizintiIsiKaybi;         
    }
    
    public double hesaplaArtirimliIsiKaybi(){
        artirimliIsiKaybi = 0;
        artirimsizIsiKaybi = hesaplaArtirimsizIsiKaybi();
        zamOrani = hesaplaZamOrani();
        artirimliIsiKaybi =  artirimsizIsiKaybi * zamOrani; 
        return artirimliIsiKaybi;
    }
    
    public double hesaplaZamOrani(){
        toplamZamOrani = 0;
        yoneGoreZam = Zamlar.getInstance().getYoneGoreZam(getYon());
        katYuksekligiZammi = getKat().readKatYuksekligiZammi();    
        isletmeZammi = hesaplaIsletmeZammi();
        
        toplamZamOrani = 1 + (yoneGoreZam + katYuksekligiZammi +isletmeZammi) / 100;
        
        return toplamZamOrani;
    }
    
    public double readYonZammi(){
        return 0;
    }
    
    public double hesaplaIsletmeZammi(){
        Bina bina = getKat().getBina();
        int isletmeTipi = bina.getIsletmeTipi();
        double disSicaklik = bina.getDisSicaklik();
        double D = hesaplaArtirimsizIsiKaybi() / (toplamSinirlayanAlan * (getIcSicaklik() - disSicaklik));
        if(!Double.isNaN(D)){
        	return Zamlar.getInstance().getIsletmeZamOrani(isletmeTipi,D);
        }
        else{
//            throw new RuntimeException("Binanýn artýrýmsýz ýsý kaybý sýfýr olarak hesaplandý!");
            return 0;
        }
    }
    
    public double hesaplaToplamIsiIhtiyaci(double binaDurumKatsayisi, double disSicaklik, double sizdirganlikKatsayisi){    	
    	hesaplaArtirimliIsiKaybi();
    	hesaplaSizintiIsiKaybi(binaDurumKatsayisi, disSicaklik, sizdirganlikKatsayisi);
    	toplamIsiKaybi = artirimliIsiKaybi + sizintiIsiKaybi;
    	return toplamIsiKaybi;
    }
    
	//********************************************************************************************************
	// Accessor & Mutator Methods*****************************************************************************
	//********************************************************************************************************

    public void initializeYapiElemanlari(ArrayList yapiElemanlari){
        if(yapiElemanlari.isEmpty()==true){
            yapiElemanlari.addAll(yapiElemanlari);
        }
    }
    
    public Collection getYapiElemanlari(){
        return (ArrayList)yapiElemanlari;
    }
    
    public void addYapiElemani(TemelYapiElemani yapiElemani){
        yapiElemanlari.add(yapiElemani);
    }
    
    public void removeYapiElemani(TemelYapiElemani yapiElemani){
        yapiElemanlari.remove(yapiElemani);
    }
        
    public double getIcSicaklik() {
        return icSicaklik;
    }
    
    public void setIcSicaklik(double isSicaklik) {
        this.icSicaklik = isSicaklik;
    }
        
    public double getKoseAciklikEtkiKatsayisi() {
        return koseAciklikEtkiKatsayisi;
    }
    
    public void setKoseAciklikEtkiKatsayisi(double koseAciklikEtkiKatsayisi){
        if(koseAciklikEtkiKatsayisi != 1 && koseAciklikEtkiKatsayisi!=1.2 ) throw new RuntimeException("Köþe açýklýk etki katsayýsý geçersiz!");
        this.koseAciklikEtkiKatsayisi = koseAciklikEtkiKatsayisi;
    }
    
    public double getOdaDurumKatsayisi() {
        return odaDurumKatsayisi;
    }
    
    public void setOdaDurumKatsayisi(double odaDurumKatsayisi) {
        this.odaDurumKatsayisi = odaDurumKatsayisi;
    }
    
    public String getYon() {
        return yon;
    }
    
    public void setYon(String yon) {
        this.yon = yon;
    }
    
    public Kat getKat() {
        return kat;
    }
    
    public void setKat(Kat kat) {
        this.kat = kat;
    }
        
    public double getToplamSinirlayanAlan() {
        return toplamSinirlayanAlan;
    }
    
    public void setToplamSinirlayanAlan(double toplamSinirlayanAlan) {
        this.toplamSinirlayanAlan = toplamSinirlayanAlan;
    }    
    
    public int getMahalId() {
        return mahalId;
    }
    
    public void setMahalId(int mahalId) {
        this.mahalId = mahalId;
    }
        
    public String getMahalAdi() {
        return mahalAdi;
    }
    public void setMahalAdi(String mahalAdi) {
        this.mahalAdi = mahalAdi;
    }
        
    public double getPencereAltiYuksekligi() {
        return pencereAltiYuksekligi;
    }
    
    public void setPencereAltiYuksekligi(double pencereAltiYuksekligi) {
        this.pencereAltiYuksekligi = pencereAltiYuksekligi;
    }
        
    public String getRadyatorModeli() {
        return radyatorModeli;
    }
    
    public void setRadyatorModeli(String radyatorModeli) {
        this.radyatorModeli = radyatorModeli;
    }
        
    public int getRadyatorGrupSayisi() {
        return radyatorGrupSayisi;
    }
    
    public void setRadyatorGrupSayisi(int radyatorGrupSayisi) {
        this.radyatorGrupSayisi = radyatorGrupSayisi;
    }

    public DuvarYapiElemani createDuvar() {
        DuvarYapiElemani duvar = new DuvarYapiElemani();
        duvar.setMahal(this);
        addYapiElemani(duvar);
        return duvar;
    }
    
	public double getZamOrani() {
		return zamOrani;
	}
	
	public void setZamOrani(double zamOrani) {
		this.zamOrani = zamOrani;
	}
	
	public double getArtirimliIsiKaybi() {
		return artirimliIsiKaybi;
	}
	
	public double getArtirimsizIsiKaybi() {
		return artirimsizIsiKaybi;
	}
	
	public double getSizintiIsiKaybi() {
		return sizintiIsiKaybi;
	}
	
	public double getToplamIsiKaybi() {
		return toplamIsiKaybi;
	}
	
	public double getIsletmeZammi() {
		return isletmeZammi;
	}
	
	public double getKatYuksekligiZammi() {
		return katYuksekligiZammi;
	}
	
	public double getToplamZamOrani() {
		return toplamZamOrani;
	}
	
	public double getYoneGoreZam() {
		return yoneGoreZam;
	}
	
    public String getMahalkodu() {
    	if(getKat()!=null){
            if(getKat().getKatYuksekligi()==0) return "Z"+mahalkodu;
            return ""+getKat().getKatYuksekligi()+mahalkodu;    		
    	}
    	return mahalkodu;
    }

    public void setMahalkodu(String mahalkodu) {
        this.mahalkodu = mahalkodu;
    }

	//********************************************************************************************************
	// GUI Methods********************************************************************************************
	//********************************************************************************************************

	public String getIconURN() {
		return ICON_URN;
	}

	public String getItemName() {
		return ITEM_NAME;
	}

	public String[] getMenuChoices() {
		return MENU_CHOICES;
	}

	public Object getSubItem(int index) {
		return ((ArrayList)yapiElemanlari).get(index);
	}

	public int getSubItemCount() {
		return yapiElemanlari.size();
	}

	public boolean isLeaf() {
		return (yapiElemanlari.size()==0);
	}

	public int getIndexOfSubItem(Object child) {
		int index = 0;
		Iterator it = yapiElemanlari.iterator();
		while(it.hasNext()){		
			TreeItemInt item = (TreeItemInt)it.next();
			if(item==child) return index;
			index++;
		}		
		return -1;
	}

	public String toString(){
		if(mahalAdi!="") return getMahalAdi();		
		return getMahalkodu();
	}

    public TreeItemInt cloneSelf() {
    	Mahal  copyOfSelf = new Mahal(getOdaDurumKatsayisi());
    	//copyOfSelf.setMahalkodu(getMahalkodu());
    	copyOfSelf.setMahalAdi(getMahalAdi());
    	copyOfSelf.setYon(getYon());
    	copyOfSelf.setIcSicaklik(getIcSicaklik());
    	copyOfSelf.setPencereAltiYuksekligi(getPencereAltiYuksekligi());
    	copyOfSelf.setRadyatorModeli(getRadyatorModeli());
    	Iterator it = getYapiElemanlari().iterator();
    	while(it.hasNext()){
    		copyOfSelf.addYapiElemani((TemelYapiElemani)((TreeItemInt)it.next()).cloneSelf());
    	}
        return copyOfSelf;
    }

    public void addChild(TreeItemInt child) {
        addYapiElemani((DuvarYapiElemani)child);
    }

    public void removeChild(TreeItemInt child) {
        removeYapiElemani((TemelYapiElemani)child);
    }

    public void setParent(TreeItemInt parent) {
        setKat((Kat)parent);
    }

    public TreeItemInt getParent() {
        return getKat();
    }

    public void loadSelf(TreeItemInt copiedObject) {
        Mahal copiedMahal = (Mahal) copiedObject;
        //setMahalkodu(copiedMahal.getMahalkodu());
        setMahalAdi(copiedMahal.getMahalAdi());
        setYon(copiedMahal.getYon());
        setIcSicaklik(copiedMahal.getIcSicaklik());
        setPencereAltiYuksekligi(copiedMahal.getPencereAltiYuksekligi());
        setRadyatorModeli(copiedMahal.getRadyatorModeli());
        getYapiElemanlari().clear();
        Iterator it = copiedMahal.getYapiElemanlari().iterator();
        while(it.hasNext()){
        	TemelYapiElemani duvar = (TemelYapiElemani)it.next();
        	duvar.setMahal(this);
        	addYapiElemani(duvar);
        }
    }

    public double hesaplaToplamDuvarAlaniForCommonDuvar(String yapiElemaniKodu) {
        double toplamDuvarAlani = 0;
        Iterator it = getYapiElemanlari().iterator();
        while(it.hasNext()){
            DuvarYapiElemani duvar = (DuvarYapiElemani) it.next();
            if(duvar.getYapiElemaniKodu() == yapiElemaniKodu)
            toplamDuvarAlani += duvar.hesaplaAlan();
        }
        return toplamDuvarAlani;
    }

    public double hesaplaToplamBasitAlaniForCommonBasit(String yapiElemaniKodu) {
        double toplamBasitAlani = 0;
        Iterator it = getYapiElemanlari().iterator();
        while(it.hasNext()){
            DuvarYapiElemani duvar = (DuvarYapiElemani) it.next();
            toplamBasitAlani += duvar.hesaplaToplamBasitAlaniForCommonBasit(yapiElemaniKodu);
        }
        return toplamBasitAlani;
    }
}
