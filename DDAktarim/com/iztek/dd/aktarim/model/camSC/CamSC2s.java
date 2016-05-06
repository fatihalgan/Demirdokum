package com.iztek.dd.aktarim.model.camSC;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;

/**
 * @author Yasin
 */
public class CamSC2s {
	private HashMap camSC2sHash = new HashMap();
	
	public HashMap getCltds() {
		return camSC2sHash;
	}
	
	private static CamSC2s instance = null;
		
	public static CamSC2s getInstance() {
		if(instance==null) instance = new CamSC2s();
		return instance;
	}
	
	public void addSC2s(String camTipi,ArrayList camSC2List){
		camSC2sHash.put(camTipi,camSC2List);
	}
	
	public void serializeSelfToXml(){
		XStream xStream = new XStream();
		xStream.alias("CatiCLTDs",HashMap.class);
		
		String xml = xStream.toXML(camSC2sHash);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("output/CamSC2.xml");
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
		
	public HashMap deserializeFromXml(){
		XStream xstream = new XStream();
		xstream.alias("CamCS2",HashMap.class);
		xstream.alias("jaluziRengi",ArrayList.class);
		HashMap hash = null;
		
		try{
			FileInputStream fis = new FileInputStream("output/CamSC2.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			hash = (HashMap)xstream.fromXML(br);
			br.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return hash;
	}
	
	public CamSC2 getCamCS2(String camTipi) {
		CamSC2 camSC2 = (CamSC2)camSC2sHash.get(camTipi);
	 	return camSC2;
	}
}
