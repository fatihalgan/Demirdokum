

package com.iztek.dd.IsiKazanci.domain;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;



public class Insanlar {
	private HashMap insanlar = new HashMap();
	/**
	 * @return Returns the insanlar.
	 */

	private static Insanlar instance = null;
	
	private Insanlar(){
	}

	public void addInsan(String aktiviteTuru,InsandanIsiKazanci insan){
		insanlar.put(aktiviteTuru,insan);
	}

	public static Insanlar getInstance(){
		if(instance==null) instance = new Insanlar();
		return instance;
	}
	
	public void serializeSelfToXml(HashMap h){
		XStream xStream = new XStream();
		xStream.alias("Insanlar",HashMap.class);
		
		//String xml = xStream.toXML(insanlar);
		String xml = xStream.toXML(h);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("xml/InsanlardanIsiKazanci.xml");
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
	
	public HashMap loadInsanlardanIsiKazanci() {
		XStream xstream = new XStream();
		xstream.alias("Insanlar", HashMap.class);
		HashMap insanlar = null;
		try {
			insanlar = (HashMap) xstream.fromXML(new FileReader(
					"xml/InsanlardanIsiKazanci.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return insanlar;	    
    }
	
	public InsandanIsiKazanci getInsan(String aktiviteTuru) {
		Collection col = insanlar.keySet();
		Iterator it = col.iterator();
		while(it.hasNext()) {
			InsandanIsiKazanci insan = (InsandanIsiKazanci)it.next();
			if(insan.getAktiviteTuru().equals(aktiviteTuru)) return insan;
		}
		return null;
	}
}
