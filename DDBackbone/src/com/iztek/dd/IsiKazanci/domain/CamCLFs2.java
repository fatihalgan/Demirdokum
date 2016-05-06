/*
 * Created on 09.�ub.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKazanci.domain;

import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;


/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CamCLFs2 {

	private HashMap yoneGoreCLFs = new HashMap();
	private static CamCLFs2 instance = null;
	
	private CamCLFs2(){		
	    yoneGoreCLFs = PersistenceManagerInt.INSTANCE.loadCamCLFs2();
	}
	
	public static CamCLFs2 getInstance(){
		if(instance == null) instance = new CamCLFs2();
		return instance;
	}
	
	public void addYoneGoreCLF(String yon, CamCLF clf){
		yoneGoreCLFs.put(yon, clf);
	}

	public CamCLF getCamCLF(String yon) {
		CamCLF clf = (CamCLF)yoneGoreCLFs.get(getStringValueForYonler(yon.trim()));
		return clf;
	}

	private String getStringValueForYonler(String yon) {
		String value = "";
		if (yon.equalsIgnoreCase("Kuzey"))
			value = "K";
		else if (yon.equalsIgnoreCase("Kuzeykuzeydo�u"))
			value = "KKD";
		else if (yon.equalsIgnoreCase("Kuzeydo�u"))
			value = "KD";
		else if (yon.equalsIgnoreCase("Do�ukuzeydo�u"))
			value = "DKD";
		else if (yon.equalsIgnoreCase("Do�u"))
			value = "D";
		else if (yon.equalsIgnoreCase("Do�ug�neydo�u"))
			value = "DGD";
		else if (yon.equalsIgnoreCase("G�neydo�u"))
			value = "GD";
		else if (yon.equalsIgnoreCase("G�neyg�neydo�u"))
			value = "GGD";
		else if (yon.equalsIgnoreCase("G�ney"))
			value = "G";
		else if (yon.equalsIgnoreCase("G�neyg�neybat�"))
			value = "GGB";
		else if (yon.equalsIgnoreCase("G�neybat�"))
			value = "GB";
		else if (yon.equalsIgnoreCase("Bat�g�neybat�"))
			value = "BGB";
		else if (yon.equalsIgnoreCase("Bat�"))
			value = "B";
		else if (yon.equalsIgnoreCase("Bat�kuzeybat�"))
			value = "BKB";
		else if (yon.equalsIgnoreCase("Kuzeybat�"))
			value = "KB";
		else if (yon.equalsIgnoreCase("Kuzeykuzeybat�"))
			value = "KKB";
		else if (yon.equalsIgnoreCase("Yatay"))
			value = "Y";
		return value;
	}

}
