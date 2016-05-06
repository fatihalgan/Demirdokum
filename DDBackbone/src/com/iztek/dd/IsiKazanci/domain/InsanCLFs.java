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
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InsanCLFs {
    private HashMap clfs = new HashMap();
    private static InsanCLFs instance = null;
    
    private InsanCLFs(){
        clfs = PersistenceManagerInt.INSTANCE.loadInsanCLFs();
    }
    
    public static InsanCLFs getInstance(){
        if(instance==null) instance = new InsanCLFs();
        return instance;
    }
	
	public void serializeSelfToXML(HashMap dataInHash){
		XStream xStream = new XStream();
		xStream.alias("InsanCLFs",HashMap.class);	//HashMap neye yerleþek
		xStream.alias("gecenZaman",ArrayList.class);
		
		String xml = xStream.toXML(dataInHash);	//HashMap dosyasý 
		System.out.println(xml);					//buraya konulacak
		try {
			FileOutputStream fos = new FileOutputStream("output/insanCLFs.xml");
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
		
	public double getCLFValue(String hacimdeKalmaSuresi, String hacimdeGecenSure){
	    ArrayList clfRow = (ArrayList) clfs.get(hacimdeKalmaSuresi);
	    return ((Double)clfRow.get(Integer.parseInt(hacimdeGecenSure))).doubleValue();
	}
}
