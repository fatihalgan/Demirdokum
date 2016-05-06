/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.aktarim.model.CamCLF;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *
 */
public class CamCLFs {
	private HashMap yoneGoreCLFs = new HashMap();
	private static CamCLFs instance = null;
	
	private CamCLFs(){		
	}
	
	public static CamCLFs getInstance(){
		if(instance == null) instance = new CamCLFs();
		return instance;
	}
	
	public void addYoneGoreCLF(String yon, CamCLF clf){
		yoneGoreCLFs.put(yon, clf);
	}

	public void serializeSelfToXML(){
		XStream xStream = new XStream();
		xStream.alias("CamCLFs",HashMap.class);
		
		String xml = xStream.toXML(yoneGoreCLFs);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("output/CamCLF.xml");
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
	
	public CamCLF getCamCLF(String yon) {
		CamCLF clf = (CamCLF)yoneGoreCLFs.get(yon.trim());
		return clf;
	}
}
