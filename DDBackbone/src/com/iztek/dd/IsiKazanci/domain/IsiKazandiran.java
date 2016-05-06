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
public interface IsiKazandiran {
	
	public double getDuyulurToplamIsiKazanci(IsiKazanan isiKazanan);
	
	public int getGizliToplamIsiKazanci(IsiKazanan isiKazanan);
	
	public int hesaplaIletimYoluylaToplamIsiKazanci(IsiKazanan isiKazanan);
	
	public int hesaplaToplamIsiKazanci(IsiKazanan isiKazanan);
}
