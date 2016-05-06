/*
 * Created on 10.Þub.2005
 *
 */
package com.iztek.dd.utilities;

/**
 * @author Selim HENDRICKSON
 *
 */
public class BolgeBroker {
	private static String activeBolgeAdi = "1";
		
	public static String getActiveBolgeAdi() {
		return activeBolgeAdi;
	}
	public static void setActiveBolgeAdi(String activeBolgeAdi) {
		BolgeBroker.activeBolgeAdi = activeBolgeAdi;
	}
	
}
