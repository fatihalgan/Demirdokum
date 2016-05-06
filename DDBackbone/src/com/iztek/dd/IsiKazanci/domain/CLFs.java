/*
 * Created on 03.Þub.2005
 *
 */
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


public class CLFs {
	private HashMap clfs = new HashMap();
	/**
	 * @return Returns the cltds.
	 */

	private static CLFs instance = null;
	
	private CLFs(){
	}
	
	public void addCLF(String number,CLF clf){
		clfs.put(number,clf);
	}

	public static CLFs getInstance(){
		if(instance==null) instance = new CLFs();
		return instance;
	}
	
	public void serializeSelfToXml(){
		XStream xStream = new XStream();
		xStream.alias("CLFs",HashMap.class);
		
		String xml = xStream.toXML(this.clfs);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("xml/CLFs.xml");
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
	
	public HashMap loadCLFs() {
		XStream xstream = new XStream();
		xstream.alias("CLFs", HashMap.class);
		HashMap clfs = null;
		try {
			clfs = (HashMap)xstream.fromXML(new FileReader(
					"xml/CLFs.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return clfs;
	}
	
	public CLF getCLF(int hacimdeToplamKalma) {
		Collection col = clfs.keySet();
		Iterator it = col.iterator();
		while(it.hasNext()) {
			CLF clf = (CLF)it.next();
			if(clf.getHacimdeToplamkalmaSuresi()==hacimdeToplamKalma)
					return clf;
		}
		return null;
	}
	
}
