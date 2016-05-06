/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.aktarim.model.duvarCLTD;

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
public class DuvarCLTDs {
	private HashMap cltds = new HashMap();
	private static DuvarCLTDs instance = null;

	private DuvarCLTDs(){		
	}
	
	public static DuvarCLTDs getInstance(){
		if(instance == null) instance = new DuvarCLTDs();
		return instance;
	}
	
	public void addCLTD(String yon,DuvarCLTD cltd){
		cltds.put(yon,cltd);
	}
	
	public void serializeSelfToXML(){
		XStream xStream = new XStream();
		xStream.alias("DuvarCLTDs",HashMap.class);
		
		String xml = xStream.toXML(cltds);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("output/DuvarCLTD.xml");
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
	
		
	public DuvarCLTD getDuvarCLDT(String yon) {
		Collection col = cltds.keySet();
		Iterator it = col.iterator();
		while(it.hasNext()) {
			DuvarCLTD duvarCLDT = (DuvarCLTD)it.next();
			if(duvarCLDT.getYon().equals(yon)) return duvarCLDT;
		}
		return null;
	}
}
