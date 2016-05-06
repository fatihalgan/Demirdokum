/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;


import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;



/**
 * @author Selim HENDRICKSON
 *
 */
public class CamCLFs {
	private HashMap yoneGoreCLFs = new HashMap();
	private static CamCLFs instance = null;
	
	private CamCLFs(){
	    yoneGoreCLFs = PersistenceManagerInt.INSTANCE.loadCamCLFs();
	}
	
	public static CamCLFs getInstance(){
		if(instance == null) instance = new CamCLFs();
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
		else if (yon.equalsIgnoreCase("Kuzeykuzeydoðu"))
			value = "KKD";
		else if (yon.equalsIgnoreCase("Kuzeydoðu"))
			value = "KD";
		else if (yon.equalsIgnoreCase("Doðukuzeydoðu"))
			value = "DKD";
		else if (yon.equalsIgnoreCase("Doðu"))
			value = "D";
		else if (yon.equalsIgnoreCase("Doðugüneydoðu"))
			value = "DGD";
		else if (yon.equalsIgnoreCase("Güneydoðu"))
			value = "GD";
		else if (yon.equalsIgnoreCase("Güneygüneydoðu"))
			value = "GGD";
		else if (yon.equalsIgnoreCase("Güney"))
			value = "G";
		else if (yon.equalsIgnoreCase("Güneygüneybatý"))
			value = "GGB";
		else if (yon.equalsIgnoreCase("Güneybatý"))
			value = "GB";
		else if (yon.equalsIgnoreCase("Batýgüneybatý"))
			value = "BGB";
		else if (yon.equalsIgnoreCase("Batý"))
			value = "B";
		else if (yon.equalsIgnoreCase("Batýkuzeybatý"))
			value = "BKB";
		else if (yon.equalsIgnoreCase("Kuzeybatý"))
			value = "KB";
		else if (yon.equalsIgnoreCase("Kuzeykuzeybatý"))
			value = "KKB";
		else if (yon.equalsIgnoreCase("Yatay"))
			value = "Y";
		return value;
	}

}
