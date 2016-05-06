/*
 * Created on 09.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

import com.iztek.dd.IsiKaybi.CamSC2;
import com.iztek.dd.IsiKaybi.CamSC2s;


/**
 * @author db2admin
 *
 */
public class Pencere extends YoneBagliIsiKazandiran {

	private boolean golgelemeYapilmis;
	private String camTipi;
	private float kalinlik = 3;
	private String golgelemeTipi = "";
	public Pencere(String identifier) {
		super();
		this.identifier = identifier;
	}
	/**
	 * @return Returns the camTipi.
	 */
	public String getCamTipi() {
		return camTipi;
	}
	/**
	 * @param camTipi The camTipi to set.
	 */
	public void setCamTipi(String camTipi) {
		this.camTipi = camTipi;
	}
	/**
	 * @return Returns the golgelemeYapilmis.
	 */
	public boolean isGolgelemeYapilmis() {
		return golgelemeYapilmis;
	}
	/**
	 * @param golgelemeYapilmis The golgelemeYapilmis to set.
	 */
	public void setGolgelemeYapilmis(boolean golgelemeYapilmis) {
		this.golgelemeYapilmis = golgelemeYapilmis;
	}
	/**
	 * @return Returns the kalinlik.
	 */
	public float getKalinlik() {
		return kalinlik;
	}
	/**
	 * @param kalinlik The kalinlik to set.
	 */
	public void setKalinlik(float kalinlik) {
		this.kalinlik = kalinlik;
	}
	
	
    public String getGolgelemeTipi() {
        return golgelemeTipi;
    }
    public void setGolgelemeTipi(String golgelemeTipi) {
        this.golgelemeTipi = golgelemeTipi;
    }
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaCLTD(int)
	 */
	public int hesaplaCLTD(IsiKazanan isiKazanan) {
		//Check Tablo.4 saate göre CLTD deðer döndür
		return CamCLTD.getInstance().getCLTDForSaat(isiKazanan.getSaat());
	}
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaRadyasyondanYalouylaGelenIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaRadyasyonYoluylaGelenIsiKazanci(IsiKazanan isiKazanan) {
	    double duzeltmeFaktoru = isiKazanan.hesaplaDuzeltmeFaktoru();
	    double sc = hesaplaSC();
	    double shgf = hesaplaSHGF(isiKazanan);
	    double clf = hesaplaCLF(isiKazanan);
		return (new Double(duzeltmeFaktoru*getAlan()*sc*clf*shgf)).intValue();
	}
	
	private double hesaplaSC() {
	    double value = 0;
		if(!golgelemeYapilmis) {
			//Table 5'e git. Cam Tipi ve Kalýnlýða göre SC(Gölgeleme Faktörü bul)
		    CamSC camSC = CamSCs.getInstance().getCamSC(getCamTipi(),getKalinlik());
		    if(camSC!=null)value = camSC.getGolgFak22();
		} else {
			//Tablo 6'ya git. Jaluzi rengi, Dikey Perde Tipi, Cam Tipi Cam Kalýnlýðýna göre SC bul.
		    CamSC2 sc2 = CamSC2s.getInstance().getCamCS2(getCamTipi()+getKalinlik());
		    value = sc2.getSCvalue(getGolgelemeTipi());
		}
		return value;
	}
	
	private double hesaplaSHGF(IsiKazanan isiKazanan) {
		String yon = getYon();
		return DuvarSHGFs.getInstance().getDuvarSHGF(isiKazanan.getAy()).getSHGFForYon(getYon());
	}
	
	private double hesaplaCLF(IsiKazanan isiKazanan) {
		double clfVal = 0;
		if(!golgelemeYapilmis) {
			//Tablo 8'e git. Yöne ve saate göre CLF bulunur.
			CamCLF clf = CamCLFs.getInstance().getCamCLF(getYon());
			clfVal = clf.getCLFForSaat(isiKazanan.getSaat());
		} else {
			//Tablo 9'a git. Yöne ve saate göre CLF bulunur.
			CamCLF clf = CamCLFs2.getInstance().getCamCLF(getYon());
			clfVal = clf.getCLFForSaat(isiKazanan.getSaat());
		}
		return clfVal;
	}
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getDuyulurToplamIsiKazanci()
	 */
	public double getDuyulurToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getGizliToplamIsiKazanci()
	 */
	public int getGizliToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#hesaplaToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaToplamIsiKazanci(IsiKazanan isiKazanan) {
		return hesaplaRadyasyonYoluylaGelenIsiKazanci(isiKazanan) + hesaplaIletimYoluylaToplamIsiKazanci(isiKazanan);
	}
	
}
