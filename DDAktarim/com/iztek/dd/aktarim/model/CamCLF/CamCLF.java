/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.aktarim.model.CamCLF;

import java.util.ArrayList;

/**
 * @author Selim HENDRICKSON
 *
 */
public class CamCLF {
	
	private ArrayList clfs = new ArrayList();
	
	public void addCLF(double value){
		clfs.add(new Double(value));
	}
	
	public int getCLFForSaat(int saat) {
		Double val = (Double)clfs.get(saat -1);
		return val.intValue();
	}
}
