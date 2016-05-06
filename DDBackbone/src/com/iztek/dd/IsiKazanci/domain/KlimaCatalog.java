/*
 * Created on 23.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iztek.dd.persistence.PersistenceManagerInt;
import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *
 */
public class KlimaCatalog {
    private ArrayList klimalar = new ArrayList();
    private static KlimaCatalog instance = null;
    
    private KlimaCatalog(){
        klimalar = PersistenceManagerInt.INSTANCE.loadKlimalar();
    }
    
    public void serializeSelfToXML(){
        XStream xStream = new XStream();
        xStream.alias("Klimalar",ArrayList.class);
        xStream.alias("Klima",Klima.class);
        String xml = xStream.toXML(klimalar);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("output/Klimalar.xml")));
            bos.write(xml.getBytes());   
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static KlimaCatalog getInstance() {
        if(instance==null) instance = new KlimaCatalog();
        return instance;
    }

    public ArrayList getKlimalar(double isiKazanciYuku, int i) {
        ArrayList filteredKazanlar = new ArrayList();
        Iterator it = klimalar.iterator();
        while(it.hasNext()){
            Klima klima = (Klima) it.next();
            if(klima.getGuc()>isiKazanciYuku&&klima.getSeri()==i) filteredKazanlar.add(klima);
        }
        return filteredKazanlar;
    }

    public Klima getKlima(String model){
        Iterator it = klimalar.iterator();
        while(it.hasNext()){
            Klima klima = ((Klima)it.next());
            if(klima.getModel().equals(model)) return klima;
        }
        return null;
    }
}
