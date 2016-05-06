/*
 * Created on 17.Þub.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKazanci.domain;

import java.util.HashMap;

/**
 * @author Tekin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DoylumBazsizCihazCLF {
	
	private static DoylumBazsizCihazCLF insBean = null;
	
	private DoylumBazsizCihazCLF(){
	}
	
	public HashMap getToplSaat() {
		return toplSaat;
	}
	private HashMap toplSaat = new HashMap();
	
	public static DoylumBazsizCihazCLF getInstance(){
		if(insBean == null) {
			DoylumBazsizCihazCLF.insBean = new DoylumBazsizCihazCLF();
		}
		return insBean;
	}
	
}
