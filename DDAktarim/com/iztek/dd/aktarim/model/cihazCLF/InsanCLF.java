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
public class InsanCLF {
	
	private static InsanCLF insBean = null;
	
	private InsanCLF(){
	}
	
	public HashMap getHacimTopKalSur() {
		return hacimTopKalSur;
	}
	private HashMap hacimTopKalSur = new HashMap();
	
	public static InsanCLF getInstance(){
		if(insBean == null) {
			InsanCLF.insBean = new InsanCLF();
		}
		return insBean;
	}
	
}
