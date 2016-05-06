/*
 * Created on 17.Þub.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKazanci.domain;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.iztek.dd.persistence.PersistenceManagerInt;
import com.thoughtworks.xstream.XStream;

/**
 * @author Tekin
 *
 */
public class DoylumBazsizCihazCLFs {
	private HashMap clfs = null;
	private static DoylumBazsizCihazCLFs instance = null;
	
	private DoylumBazsizCihazCLFs(){
	    clfs = PersistenceManagerInt.INSTANCE.loadDavlumbazsizCihazCLFs();	    
	}
	
	public void serializeSelfToXML(HashMap dataInHash){
		XStream xStream = new XStream();
		xStream.alias("DoylumBazsizCihazCLFs",HashMap.class);	//HashMap neye yerleþek
		xStream.alias("gecenZaman",ArrayList.class);
		
		String xml = xStream.toXML(dataInHash);	//HashMap dosyasý 
		System.out.println(xml);					//buraya konulacak
		try {
			FileOutputStream fos = new FileOutputStream("output/doylumBazsizCihazCLFs.xml");
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
		
    public static DoylumBazsizCihazCLFs getInstance() {
        if(instance==null) instance = new DoylumBazsizCihazCLFs();
        return instance;
    }
    
    public double getCLFValue(int calistigiToplamSaat, int isletmeyeAlindiktanSonraGecenSaat) {
        ArrayList clfRow = (ArrayList) clfs.get(""+calistigiToplamSaat);
        return ((Double)clfRow.get(isletmeyeAlindiktanSonraGecenSaat)).doubleValue();
    }	
	
}
