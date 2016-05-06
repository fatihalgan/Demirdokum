/*
 * Created on 17.Þub.2005
 *
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
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DoylumBazliCihazCLFs {
    
    private static HashMap clfs = null;    
    private static DoylumBazliCihazCLFs instance = null;
	
    private DoylumBazliCihazCLFs(){
        clfs = PersistenceManagerInt.INSTANCE.loadDavlumbazliCihazCLFs();
    }
    
    public static DoylumBazliCihazCLFs getInstance(){
        if(instance==null) instance = new DoylumBazliCihazCLFs();
        return instance;
    }
            
	public void serializeSelfToXML(HashMap dataInHash){
		XStream xStream = new XStream();
		xStream.alias("DoylumBazliCihazCLFs",HashMap.class);	//HashMap neye yerleþek
		xStream.alias("gecenZaman",ArrayList.class);
		
		String xml = xStream.toXML(dataInHash);	//HashMap dosyasý 
		System.out.println(xml);					//buraya konulacak
		try {
			FileOutputStream fos = new FileOutputStream("output/doylumBazliCihazCLFs.xml");
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

    public double getCLFValue(int calistigiToplamSaat, int isletmeyeAlindiktanSonraGecenSaat) {
        ArrayList clfRow = (ArrayList) clfs.get(""+calistigiToplamSaat);
        return ((Double)clfRow.get(isletmeyeAlindiktanSonraGecenSaat)).doubleValue();
    }		
	
	
}
