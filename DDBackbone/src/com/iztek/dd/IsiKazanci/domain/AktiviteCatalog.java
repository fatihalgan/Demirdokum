/*
 * Created on 17.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.iztek.dd.persistence.PersistenceManagerInt;
import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *
 */
public class AktiviteCatalog {
    private ArrayList aktiviteler = new ArrayList();
    private static AktiviteCatalog instance = null;
    
    private AktiviteCatalog(){
        aktiviteler = PersistenceManagerInt.INSTANCE.loadAktiviteler();
//        aktiviteler.add(new Aktivite("Oturarak dinlenme",60,40));
//        aktiviteler.add(new Aktivite("Oturarak hafif çalýþma",65,55));
//        aktiviteler.add(new Aktivite("Oturarak yemek yeme",75,95));
//        aktiviteler.add(new Aktivite("Ayakta hafif çalýþma, yürümek",90,95));
//        aktiviteler.add(new Aktivite("Ayakta hafif çalýþma",100,130));
//        aktiviteler.add(new Aktivite("Yürüyerek hafif çalýþma",100,205));
//        aktiviteler.add(new Aktivite("Dans etmek",120,255));
//        aktiviteler.add(new Aktivite("Aðýr sanayi iþçiliði",165,300));
//        aktiviteler.add(new Aktivite("Aðýr jimnastik",185,340));
    }
    
    public void persistSelfToXML(){
        XStream xStream = new XStream();
        xStream.alias("Aktiviteler",ArrayList.class);
        String xml = xStream.toXML(aktiviteler);
		try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("xml/Aktiviteler.xml")));
            out.write(xml);
            System.out.println(xml);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static AktiviteCatalog getInstance(){
        if(instance==null) instance = new AktiviteCatalog();
        return instance;
    }
    
    public ArrayList getAktiviteler(){
        return aktiviteler;
    }
    public static void main(String[] args) {
        getInstance().persistSelfToXML();
    }

    public Aktivite getAktivite(String aktiviteTipi){
        Iterator it = aktiviteler.iterator();
        while(it.hasNext()){
            Aktivite aktivite = (Aktivite) it.next();
            if(aktivite.getTip().equals(aktiviteTipi)) return aktivite;
        }
        return null;
    }
}
