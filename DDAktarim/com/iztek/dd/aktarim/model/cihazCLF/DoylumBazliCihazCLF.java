/*
 * Created on 17.Þub.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.aktarim.model.cihazCLF;

import java.util.HashMap;

/**
 * @author Tekin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
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
