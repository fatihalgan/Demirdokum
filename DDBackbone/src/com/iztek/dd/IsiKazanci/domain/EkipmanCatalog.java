/*
 * Created on 03.Mar.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.iztek.dd.persistence.PersistenceManagerInt;
import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *
 */
public class EkipmanCatalog {
    private ArrayList ekipmanlar = new ArrayList();
    private static EkipmanCatalog instance = null;
    
    private EkipmanCatalog(){
        ekipmanlar = PersistenceManagerInt.INSTANCE.loadEkipmanlar();
    }

    public void serializeSelfToXML(){
        XStream xStream = new XStream();
        xStream.alias("Ekipmanlar",ArrayList.class);
        xStream.alias("Ekipman",Ekipman.class);
        String xml = xStream.toXML(ekipmanlar);
        System.out.println(xml);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("xml/Ekipmanlar.xml")));
            bos.write(xml.getBytes());
            bos.flush();
            bos.close();            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new EkipmanCatalog().serializeSelfToXML();
    }
    
    public static EkipmanCatalog getInstance(){
        if(instance == null) instance = new EkipmanCatalog();
        return instance;
    }

    public ArrayList getEkipmanlar(){
        return ekipmanlar;
    }
}
