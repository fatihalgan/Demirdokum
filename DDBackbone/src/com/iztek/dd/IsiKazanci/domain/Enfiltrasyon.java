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
public class Enfiltrasyon implements IsiKazandiran {

	private double havaDebisi;
	
	
	/**
	 * 
	 */
	public Enfiltrasyon() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#hesaplaToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return (int)(getDuyulurToplamIsiKazanci(isiKazanan) + getGizliToplamIsiKazanci(isiKazanan));
	}
	
	/**
	 * @return Returns the havaDebisi.
	 */
	public double getHavaDebisi() {
		return havaDebisi;
	}
	/**
	 * @param d The havaDebisi to set.
	 */
	public void setHavaDebisi(double d) {
		this.havaDebisi = d;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getDuyulurToplamIsiKazanci()
	 */
	public double getDuyulurToplamIsiKazanci(IsiKazanan isiKazanan) {
		return (1.232 * (isiKazanan.getDisSicaklik() - isiKazanan.getIcSicaklik())) * getHavaDebisi();
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getGizliToplamIsiKazanci()
	 */
	public int getGizliToplamIsiKazanci(IsiKazanan isiKazanan) {
		return (int)((3.012 * (isiKazanan.getDisOzgulNem() - isiKazanan.getIcOzgulNem())) * getHavaDebisi());
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#hesaplaIletimYoluylaToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaIletimYoluylaToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}
}
