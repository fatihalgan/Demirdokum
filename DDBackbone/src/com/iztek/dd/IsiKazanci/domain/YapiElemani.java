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
public abstract class YapiElemani implements IsiKazandiran {

	private float isiTransferiKatsayisi;
	private float alan;
    protected String identifier = "";
	
	/**
	 * 
	 */
	public YapiElemani() {
		super();
	}
	
	/**
	 * @return Returns the alan.
	 */
	public float getAlan() {
		return alan;
	}
	/**
	 * @param alan The alan to set.
	 */
	public void setAlan(float alan) {
		this.alan = alan;
	}
	/**
	 * @return Returns the isiTransferiKatsayisi.
	 */
	public float getIsiTransferiKatsayisi() {	    
		return isiTransferiKatsayisi;
	}
	/**
	 * @param isiTransferiKatsayisi The isiTransferiKatsayisi to set.
	 */
	public void setIsiTransferiKatsayisi(float isiTransferiKatsayisi) {
		this.isiTransferiKatsayisi = isiTransferiKatsayisi;
	}
	
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaCLTD(int)
	 */
	public abstract int hesaplaCLTD(IsiKazanan isiKazanan);
	
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#hesaplaIletimYoluylaToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaIletimYoluylaToplamIsiKazanci(IsiKazanan isiKazanan) {
		double duzeltmeFaktoru = isiKazanan.hesaplaDuzeltmeFaktoru();
		int cltd = hesaplaCLTD(isiKazanan);
		float UA = getAlan() * getIsiTransferiKatsayisi();
		return (int)(duzeltmeFaktoru * cltd * UA);
	}
	
	public abstract int hesaplaRadyasyonYoluylaGelenIsiKazanci(IsiKazanan isiKazanan);

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
