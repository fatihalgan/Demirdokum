
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

public class AydinlatmaCLF8s {
	private static AydinlatmaCLF8s instance = null;
	private HashMap clf8s = new HashMap();

	private AydinlatmaCLF8s(){
	    clf8s = PersistenceManagerInt.INSTANCE.loadAydinlatmaCLF8s();
	}
	
	public HashMap getClf8s() {
		return clf8s;
	}
	
	public void addCLF8(String tip,AydinlatmaCLF8 cltd){
		clf8s.put(tip,cltd);
	}

	public static AydinlatmaCLF8s getInstance(){
		if(instance==null) instance = new AydinlatmaCLF8s();
		return instance;
	}
	
	public void serializeSelfToXml(){
		XStream xStream = new XStream();
		xStream.alias("AydinlatmaCLF8s",HashMap.class);
		
		String xml = xStream.toXML(clf8s);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("output/AydinlatmaCLF8.xml");
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
		xStream.alias("AydinlatmaCLF8s",HashMap.class);
		Object object = null;
		
		try {
			FileInputStream fis = new FileInputStream("output/AydinlatmaCLF8.xml");
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
	
	public AydinlatmaCLF8 getAydinlatmaCLF8(String tip) {
		return (AydinlatmaCLF8)clf8s.get(tip);
	}

}
