/*
 * Created on 09.Þub.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKazanci.domain;
/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Insan implements IsiKazandiran {

	private int insanSayisi;
	private String aktiviteTuru;
	private int hacimeGirdiktenSonraGecenZaman = 1;
	private int hacimdeToplamKalmaSuresi = 2;
	private double LHG = 0;
	private double SHG = 0;
	
	
    public double getLHG() {
        return LHG;
    }
    public void setLHG(double lhg) {
        LHG = lhg;
    }
    public double getSHG() {
        return SHG;
    }
    public void setSHG(double shg) {
        SHG = shg;
    }
	/**
	 * @return Returns the aktiviteTuru.
	 */
	public String getAktiviteTuru() {
		return aktiviteTuru;
	}
	/**
	 * @param aktiviteTuru The aktiviteTuru to set.
	 */
	public void setAktiviteTuru(String aktiviteTuru) {
		this.aktiviteTuru = aktiviteTuru;
	}
	/**
	 * @return Returns the hacimdeToplamKalmaSuresi.
	 */
	public int getHacimdeToplamKalmaSuresi() {
		return hacimdeToplamKalmaSuresi;
	}
	/**
	 * @param hacimdeToplamKalmaSuresi The hacimdeToplamKalmaSuresi to set.
	 */
	public void setHacimdeToplamKalmaSuresi(int hacimdeToplamKalmaSuresi) {
		this.hacimdeToplamKalmaSuresi = hacimdeToplamKalmaSuresi;
	}
	/**
	 * @return Returns the hacimeGirdiktenSonraGecenZaman.
	 */
	public int getHacimeGirdiktenSonraGecenZaman() {
		return hacimeGirdiktenSonraGecenZaman;
	}
	/**
	 * @param hacimeGirdiktenSonraGecenZaman The hacimeGirdiktenSonraGecenZaman to set.
	 */
	public void setHacimeGirdiktenSonraGecenZaman(
			int hacimeGirdiktenSonraGecenZaman) {
		this.hacimeGirdiktenSonraGecenZaman = hacimeGirdiktenSonraGecenZaman;
	}
	/**
	 * @return Returns the insanSayisi.
	 */
	public int getInsanSayisi() {
		return insanSayisi;
	}
	/**
	 * @param insanSayisi The insanSayisi to set.
	 */
	public void setInsanSayisi(int insanSayisi) {
		this.insanSayisi = insanSayisi;
	}
	/**
	 * 
	 */
	public Insan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getDuyulurToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public double getDuyulurToplamIsiKazanci(IsiKazanan isiKazanan) {
		return insanSayisi * getSHG() * isiKazanan.hesaplaDuzeltmeFaktoru() * hesaplaCLF();
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getGizliToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int getGizliToplamIsiKazanci(IsiKazanan isiKazanan) {
		return (int)(insanSayisi * getLHG());		
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#hesaplaIletimYoluylaToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaIletimYoluylaToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#hesaplaToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaToplamIsiKazanci(IsiKazanan isiKazanan) {
		return (int)(getGizliToplamIsiKazanci(isiKazanan) + getDuyulurToplamIsiKazanci(isiKazanan));
	}
		
	private double hesaplaCLF() {
		//Tablo 13'ten insanlarýn hacimde toplam kalma süresi ve hacme girdikten sonra geçen
		//zamana göre CLF döner
		double value = InsanCLFs.getInstance().getCLFValue(""+getHacimdeToplamKalmaSuresi(),""+(getHacimeGirdiktenSonraGecenZaman()-1));
		return value;
	}

}
