/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *
 */
public class CamCLTD {
	
	private ArrayList gunesZamanlari = new ArrayList();
	private static CamCLTD instance = null;
	
	private CamCLTD(){
		gunesZamanlari.add(new Double(1));
		gunesZamanlari.add(new Double(0));
		gunesZamanlari.add(new Double(-1));
		gunesZamanlari.add(new Double(-1));
		gunesZamanlari.add(new Double(-1));
		gunesZamanlari.add(new Double(-1));
		gunesZamanlari.add(new Double(-1));
		gunesZamanlari.add(new Double(0));
		gunesZamanlari.add(new Double(1));
		gunesZamanlari.add(new Double(2));
		gunesZamanlari.add(new Double(4));
		gunesZamanlari.add(new Double(5));
		gunesZamanlari.add(new Double(7));
		gunesZamanlari.add(new Double(7));
		gunesZamanlari.add(new Double(8));
		gunesZamanlari.add(new Double(8));
		gunesZamanlari.add(new Double(7));
		gunesZamanlari.add(new Double(7));
		gunesZamanlari.add(new Double(6));
		gunesZamanlari.add(new Double(4));
		gunesZamanlari.add(new Double(4));
		gunesZamanlari.add(new Double(2));
		gunesZamanlari.add(new Double(2));
		gunesZamanlari.add(new Double(1));
	}
	
	public static CamCLTD getInstance(){
		if(instance == null) instance = new CamCLTD();
		return instance;
	}
	
	public void serializeSelfToXML(){
		XStream xStream = new XStream();
		xStream.alias("CamCLTDs",ArrayList.class);
		
		String xml = xStream.toXML(gunesZamanlari);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("output/CamCLTD.xml");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(xml.getBytes());
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getCLTDForSaat(int saat) {
		Double val = (Double)gunesZamanlari.get(saat - 1);
		if(val != null)return val.intValue();
		return 0;
	}
	
	public static void main(String[] args) {
		CamCLTD instance = new CamCLTD();
		instance.serializeSelfToXML();
	}
}
