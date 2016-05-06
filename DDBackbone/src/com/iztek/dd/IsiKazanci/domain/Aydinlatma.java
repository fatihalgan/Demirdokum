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
public class Aydinlatma implements IsiKazandiran {

    private String tip ="A";
	private double guc;
	private int aydinlatmaSuresi;
	private int isikYandiktanSonraGecenSure;
	
		/**
	 * @return Returns the isikYandiktanSonraGecenSure.
	 */
	public int getIsikYandiktanSonraGecenSure() {
		return isikYandiktanSonraGecenSure;
	}
	/**
	 * @param isikYandiktanSonraGecenSure The isikYandiktanSonraGecenSure to set.
	 */
	public void setIsikYandiktanSonraGecenSure(int isikYandiktanSonraGecenSure) {
		this.isikYandiktanSonraGecenSure = isikYandiktanSonraGecenSure;
	}
/**
	 * @return Returns the guc.
	 */
	public double getGuc() {
		return guc;
	}
	/**
	 * @param guc The guc to set.
	 */
	public void setGuc(double guc) {
		this.guc = guc;
	}
	/**
	 * 
	 */
	public Aydinlatma() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getDuyulurToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public double getDuyulurToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getGizliToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int getGizliToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
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
		return (int)(isiKazanan.hesaplaDuzeltmeFaktoru() * guc * hesaplaCLF(isiKazanan));		
	}
	
	private double hesaplaCLF(IsiKazanan isiKazanan) {
	    double clf = 0;
		//Aydýnlanma süresi 8 saat ise Tablo.10'a bak. 
		if(getAydinlatmaSuresi()==8){
		    clf = AydinlatmaCLF8s.getInstance().getAydinlatmaCLF8(getTip()).getCLF8ForSaat(getIsikYandiktanSonraGecenSure());
		}
		//Aydýnlanma süresi 12 saat ise Tablo.11'e bak
		else{
		    clf = AydinlatmaCLF12s.getInstance().getAydinlatmaCLF12(getTip()).getCLF12ForSaat(isiKazanan.getSaat());
		}
		//Mobilya Tipi ve ýþýklar yandýktan sonra geçen süreye göre CLF döner.
		return clf;
	}
			
    public int getAydinlatmaSuresi() {
        return aydinlatmaSuresi;
    }
    public void setAydinlatmaSuresi(int aydinlatmaSuresi) {
        this.aydinlatmaSuresi = aydinlatmaSuresi;
    }
    public String getTip() {
        return tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }
}
