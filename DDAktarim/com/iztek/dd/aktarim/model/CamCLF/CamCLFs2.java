/*
 * Created on 09.Þub.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.aktarim.model.CamCLF;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;

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
	}
	
	public static CamCLFs2 getInstance(){
		if(instance == null) instance = new CamCLFs2();
		return instance;
	}
	
	public void addYoneGoreCLF(String yon, CamCLF clf){
		yoneGoreCLFs.put(yon, clf);
	}

	public void serializeSelfToXML(){
		XStream xStream = new XStream();
		xStream.alias("CamCLFs2",HashMap.class);
		
		String xml = xStream.toXML(yoneGoreCLFs);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("output/CamCLF2.xml");
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
