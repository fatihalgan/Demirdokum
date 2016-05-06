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
public class IcDuvar extends YapiElemani {
	
	private int sicaklikFarki;

	/**
	 * @return Returns the sicaklikFarki.
	 */
	public int getSicaklikFarki() {
		return sicaklikFarki;
	}
	/**
	 * @param f The sicaklikFarki to set.
	 */
	public void setSicaklikFarki(int f) {
		this.sicaklikFarki = f;
	}
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaToplamIsiKazanci(IsiKazanan isiKazanan) {
		return hesaplaIletimdenGelenIsiKazanci(isiKazanan);
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaIletimdenGelenIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaIletimdenGelenIsiKazanci(IsiKazanan isiKazanan) {
		return (int)(getAlan() * getIsiTransferiKatsayisi()) * getSicaklikFarki();
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaCLTD()
	 */
	public int hesaplaCLTD(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaRadyasyondanGelenIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaRadyasyondanGelenIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaRadyasyondanYalouylaGelenIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaRadyasyonYoluylaGelenIsiKazanci(IsiKazanan isiKazanan) {
		return 0;
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

	

}
