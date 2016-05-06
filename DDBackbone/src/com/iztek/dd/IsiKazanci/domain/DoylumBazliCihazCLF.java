/*
 * Created on 17.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

import java.util.HashMap;

/**
 * @author Tekin
 *
 */
public class DoylumBazliCihazCLF {
	
	private static DoylumBazliCihazCLF insBean = null;
	
	private DoylumBazliCihazCLF(){
	}
	
	public HashMap getToplSaat() {
		return toplSaat;
	}
	private HashMap toplSaat = new HashMap();
	
	public static DoylumBazliCihazCLF getInstance(){
		if(insBean == null) {
			DoylumBazliCihazCLF.insBean = new DoylumBazliCihazCLF();
		}
		return insBean;
	}
	
}
