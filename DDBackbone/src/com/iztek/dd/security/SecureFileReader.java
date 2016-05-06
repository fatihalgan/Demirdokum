/*
 * Created on 11.Mar.2005
 *
 */
package com.iztek.dd.security;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import com.iztek.dd.IsiKazanci.domain.Klima;
import com.thoughtworks.xstream.XStream;


/**
 * @author Selim HENDRICKSON
 *
 */
public class SecureFileReader {
    private static final String KEY = "";
    
    private static File isiticiXMLFile = new File("xml/IsiticiCatalog.xml");
    private static File genlesmeDepolariXMLFile = new File("xml/KapaliGenlesmeDepolari.xml");
    private static File radyatorlerXMLFile = new File("xml/radyatorler.xml");
    private static File klimalarXMLFile = new File("xml/Klimalar.xml");
    
    public static void main(String[] args) {
        SecretKey key = null;
       
        try {
            key = (SecretKey) KeyUtility.reconstituteKey("cDcsNAfqxDE=");;
            System.out.println(KeyUtility.getStringSecretKey(key));            
            Cipher ecipher = Cipher.getInstance("DES");
            ecipher.init(Cipher.ENCRYPT_MODE,key);
            
//            XStream xStream = new XStream();
//            xStream.alias("Isiticilar",ArrayList.class);
//            ArrayList temp = (ArrayList)xStream.fromXML(new FileReader(isiticiXMLFile));
//            /*TEMP*/
//            temp.add(new KaskatModeli(23.26,"","HKB 124 S (Hermetik)","",true,false));
//            temp.add(new KaskatModeli(30.24,"","HKB 130 S (Hermetik)","",true,false));
//            temp.add(new KaskatModeli(23.26,"","HKB 124 S (Bacalý)","",false,false));
//            temp.add(new KaskatModeli(30.24,"","HKB 124 S (Bacalý)","",false,false));
//            temp.add(new KaskatModeli(23.26,"","HKB 124 SS (Hermetik)","",true,true));
//            temp.add(new KaskatModeli(30.24,"","HKB 130 SS (Hermetik)","",true,true));
//            temp.add(new KaskatModeli(23.26,"","HKB 124 SS (Bacalý)","",false,true));
//            temp.add(new KaskatModeli(30.24,"","HKB 124 SS (Bacalý)","",false,true));
//            /*TEMP*/
//            SealedObject isiticiSO = new SealedObject(temp,ecipher);            
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("xml/isitici.ddx"));
//            oos.writeObject(isiticiSO);
//            oos.flush();

//            xStream = new XStream();
//            xStream.alias("GenlesmeDepolari",ArrayList.class);
//            temp = (ArrayList)xStream.fromXML(new FileReader(genlesmeDepolariXMLFile));
//            SealedObject genlesmeSO = new SealedObject(temp,ecipher);            
//            oos = new ObjectOutputStream(new FileOutputStream("xml/genlesme.ddx"));
//            oos.writeObject(genlesmeSO);
//            oos.flush();
//
//            xStream = new XStream();
//            xStream.alias("radyatorler",ArrayList.class);
//            temp = (ArrayList)xStream.fromXML(new FileReader(radyatorlerXMLFile));
//            SealedObject radyatorlerSO = new SealedObject(temp,ecipher);            
//            oos = new ObjectOutputStream(new FileOutputStream("xml/radyatorler.ddx"));
//            oos.writeObject(radyatorlerSO);
//            oos.flush();
//
            XStream xStream = new XStream();
            xStream.alias("Klimalar",ArrayList.class);
            xStream.alias("Klima",Klima.class); 
            ArrayList temp = (ArrayList)xStream.fromXML(new FileReader(klimalarXMLFile));
            SealedObject klimalarSO = new SealedObject(temp,ecipher);            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("xml/klimalar.ddx"));
            oos.writeObject(klimalarSO);
            oos.flush();

        } catch (NoSuchAlgorithmException e1) {        
            e1.printStackTrace();
        } catch (NoSuchPaddingException e1) {
            e1.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
