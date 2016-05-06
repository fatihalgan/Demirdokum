package com.iztek.dd.IsiKaybi;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.iztek.dd.persistence.PersistenceManagerInt;
import com.thoughtworks.xstream.XStream;


/*
 * Created on 13.Þub.2005
 *
 */

/**
 * @author Selim HENDRICKSON
 *
 */
public class GenlesmeDepoCatalog {
	private ArrayList depolar = new ArrayList();
	private static GenlesmeDepoCatalog instance = null;
	
	private GenlesmeDepoCatalog(){
		depolar = PersistenceManagerInt.INSTANCE.loadGenlesmeDepolari();
	}
	
	public static GenlesmeDepoCatalog getInstance(){
		if(instance==null){
			instance = new GenlesmeDepoCatalog();
		}
		return instance;
	}
	
	public static void persistSelf(){
		XStream xStream = new XStream();
		xStream.alias("GenlesmeDepolari",ArrayList.class);
		
		String xml = xStream.toXML(getInstance());
		System.out.println(xml);
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(new File("KapaliGenlesmeDepolari.xml"))));
			out.write(xml);
			out.flush();
			out.close();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	public static void main(String[] args) {
		persistSelf();		
	}

	public Collection getDepolarFilteredBySize(double size){
		ArrayList filteredDepolar = new ArrayList();
		Iterator it = depolar.iterator();
		while(it.hasNext()){
			GenlesmeDeposu depo = (GenlesmeDeposu) it.next();
			if(depo.getHacim()>=size) filteredDepolar.add(depo);
		}
		return filteredDepolar;
	}
}
