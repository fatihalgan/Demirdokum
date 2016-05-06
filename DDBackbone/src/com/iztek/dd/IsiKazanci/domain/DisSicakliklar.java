
package com.iztek.dd.IsiKazanci.domain;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;
import com.thoughtworks.xstream.XStream;


public class DisSicakliklar {
	private static DisSicakliklar instance = null;
	private HashMap degerler = new HashMap();

	private DisSicakliklar(){
	    degerler = PersistenceManagerInt.INSTANCE.loadDisSicaklikDegerleri();
	}
	
	public HashMap getDegerler() {
		return degerler;
	}
	
	public void addDeger(String sehir, DisSicaklikDegerleri disSýcaklikdegerleri){
		degerler.put(sehir,disSýcaklikdegerleri);
	}

	public static DisSicakliklar getInstance(){
		if(instance==null) instance = new DisSicakliklar();
		return instance;
	}
	
	public void serializeSelfToXml(){
		XStream xStream = new XStream();
		xStream.alias("DisSicakliklar",HashMap.class);
		
		String xml = xStream.toXML(degerler);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("output/DisSicakliklar.xml");
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
	
	
	public Object getDataFromXml(){
		XStream xStream = new XStream();
		xStream.alias("DisSicakliklar",HashMap.class);
		Object object = null;
		
		try {
			FileInputStream fis = new FileInputStream("output/DisSicakliklar.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			object = xStream.fromXML(br);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public DisSicaklikDegerleri getDisSicaklikDegerleri(String sehir) {
		return (DisSicaklikDegerleri)degerler.get(sehir);
	}
}
