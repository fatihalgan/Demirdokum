/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.aktarim.model.catiCLTD;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;



/**
 * @author Selim HENDRICKSON
 *
 */
public class CatiCLTDs {
	private HashMap cltds = new HashMap();
	/**
	 * @return Returns the cltds.
	 */
	public HashMap getCltds() {
		return cltds;
	}
	private static CatiCLTDs instance = null;
	
	private CatiCLTDs(){
	}
	
	public void addCLTD(String number,CatiCLTD cltd){
		cltds.put(number,cltd);
	}

	public static CatiCLTDs getInstance(){
		if(instance==null) instance = new CatiCLTDs();
		return instance;
	}
	
	public void serializeSelfToXml(){
		XStream xStream = new XStream();
		xStream.alias("CatiCLTDs",HashMap.class);
		
		String xml = xStream.toXML(cltds);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("output/CatiCLTD.xml");
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
	
	public CatiCLTD getCatiCLDT(String catiTipi) {
		Collection col = cltds.keySet();
		Iterator it = col.iterator();
		while(it.hasNext()) {
			CatiCLTD catiCLDT = (CatiCLTD)it.next();
			if(catiCLDT.getCatiTipi().equals(catiTipi)) return catiCLDT;
		}
		return null;
	}
}
