/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.iztek.dd.IsiKazanci.domain.CamSCs;
import com.iztek.dd.domain.Bolge;
import com.iztek.dd.utilities.Malzeme;
import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *
 */
public abstract class MockPersistenceManager implements PersistenceManagerInt {

	
	public HashMap loadGunesIsinimSiddetleri() {
		HashMap isinimSiddetleri = new HashMap();
		
		HashMap ay = new HashMap();
		ay.put("GUNEY",new Double(72));
		ay.put("KUZEY",new Double(26));
		ay.put("BATI",new Double(43));
		ay.put("DOGU",new Double(43));
		isinimSiddetleri.put("1",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(84));
		ay.put("KUZEY",new Double(37));
		ay.put("BATI",new Double(57));
		ay.put("DOGU",new Double(57));
		isinimSiddetleri.put("2",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(95));
		ay.put("KUZEY",new Double(52));
		ay.put("BATI",new Double(77));
		ay.put("DOGU",new Double(77));
		isinimSiddetleri.put("3",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(83));
		ay.put("KUZEY",new Double(66));
		ay.put("BATI",new Double(90));
		ay.put("DOGU",new Double(90));
		isinimSiddetleri.put("4",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(92));
		ay.put("KUZEY",new Double(79));
		ay.put("BATI",new Double(114));
		ay.put("DOGU",new Double(114));
		isinimSiddetleri.put("5",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(95));
		ay.put("KUZEY",new Double(83));
		ay.put("BATI",new Double(122));
		ay.put("DOGU",new Double(122));
		isinimSiddetleri.put("6",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(93));
		ay.put("KUZEY",new Double(81));
		ay.put("BATI",new Double(118));
		ay.put("DOGU",new Double(118));
		isinimSiddetleri.put("7",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(93));
		ay.put("KUZEY",new Double(73));
		ay.put("BATI",new Double(106));
		ay.put("DOGU",new Double(106));
		isinimSiddetleri.put("8",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(89));
		ay.put("KUZEY",new Double(57));
		ay.put("BATI",new Double(81));
		ay.put("DOGU",new Double(81));
		isinimSiddetleri.put("9",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(82));
		ay.put("KUZEY",new Double(40));
		ay.put("BATI",new Double(59));
		ay.put("DOGU",new Double(59));
		isinimSiddetleri.put("10",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(67));
		ay.put("KUZEY",new Double(27));
		ay.put("BATI",new Double(41));
		ay.put("DOGU",new Double(41));
		isinimSiddetleri.put("11",ay);

		ay = new HashMap();
		ay.put("GUNEY",new Double(64));
		ay.put("KUZEY",new Double(22));
		ay.put("BATI",new Double(37));
		ay.put("DOGU",new Double(37));
		isinimSiddetleri.put("12",ay);

		return isinimSiddetleri;
	}

	public HashMap loadDisSicakliklar() {
		HashMap disSicakliklar = new HashMap();
		
		HashMap ay = new HashMap();
		ay.put("1",new Double(8.0));
		ay.put("2",new Double(3.3));
		ay.put("3",new Double(1.3));
		ay.put("4",new Double(-5.2));
		disSicakliklar.put("1",ay);

		ay = new HashMap();
		ay.put("1",new Double(9.3));
		ay.put("2",new Double(4.5));
		ay.put("3",new Double(2.0));
		ay.put("4",new Double(-4.1));
		disSicakliklar.put("2",ay);

		ay = new HashMap();
		ay.put("1",new Double(11.5));
		ay.put("2",new Double(7.2));
		ay.put("3",new Double(5.0));
		ay.put("4",new Double(-1.3));
		disSicakliklar.put("3",ay);

		ay = new HashMap();
		ay.put("1",new Double(15.7));
		ay.put("2",new Double(12.6));
		ay.put("3",new Double(9.8));
		ay.put("4",new Double(5.1));
		disSicakliklar.put("4",ay);

		ay = new HashMap();
		ay.put("1",new Double(20.6));
		ay.put("2",new Double(17.8));
		ay.put("3",new Double(14.1));
		ay.put("4",new Double(10.1));
		disSicakliklar.put("5",ay);

		ay = new HashMap();
		ay.put("1",new Double(25.4));
		ay.put("2",new Double(21.9));
		ay.put("3",new Double(18.1));
		ay.put("4",new Double(13.5));
		disSicakliklar.put("6",ay);

		ay = new HashMap();
		ay.put("1",new Double(28.0));
		ay.put("2",new Double(24.4));
		ay.put("3",new Double(21.1));
		ay.put("4",new Double(17.2));
		disSicakliklar.put("7",ay);

		ay = new HashMap();
		ay.put("1",new Double(27.2));
		ay.put("2",new Double(23.8));
		ay.put("3",new Double(20.6));
		ay.put("4",new Double(17.2));
		disSicakliklar.put("8",ay);

		ay = new HashMap();
		ay.put("1",new Double(23.3));
		ay.put("2",new Double(19.6));
		ay.put("3",new Double(16.5));
		ay.put("4",new Double(13.2));
		disSicakliklar.put("9",ay);

		ay = new HashMap();
		ay.put("1",new Double(18.1));
		ay.put("2",new Double(14.1));
		ay.put("3",new Double(11.3));
		ay.put("4",new Double(6.9));
		disSicakliklar.put("10",ay);

		ay = new HashMap();
		ay.put("1",new Double(13.3));
		ay.put("2",new Double(9.1));
		ay.put("3",new Double(6.5));
		ay.put("4",new Double(1.3));
		disSicakliklar.put("11",ay);

		ay = new HashMap();
		ay.put("1",new Double(9.4));
		ay.put("2",new Double(4.9));
		ay.put("3",new Double(2.6));
		ay.put("4",new Double(-3.0));
		disSicakliklar.put("12",ay);

		return disSicakliklar;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.utilities.PersistenceManagerInt#loadBolge(java.lang.String)
	 */
	public Bolge loadBolge(String bolgeAdi) {
		
		return null;
	}

    public HashMap loadYonZamlar() {
        HashMap yonlereGoreZamlar = new HashMap();
        
        yonlereGoreZamlar.put("G",new Double(-5));
        yonlereGoreZamlar.put("GB",new Double(-5));
        yonlereGoreZamlar.put("B",new Double(0));
        yonlereGoreZamlar.put("KB",new Double(5));
        yonlereGoreZamlar.put("K",new Double(5));
        yonlereGoreZamlar.put("KD",new Double(5));
        yonlereGoreZamlar.put("D",new Double(0));
        yonlereGoreZamlar.put("GD",new Double(-5));
        return yonlereGoreZamlar;
    }

    /* (non-Javadoc)
     * @see com.iztek.dd.persistence.PersistenceManagerInt#loadIsletmeTipiZamlar()
     */
    public HashMap loadIsletmeTipiZamlar() {
        HashMap isletmeTipiZamlar = new HashMap();
        
        isletmeTipiZamlar.put("11",new Double(7));
        isletmeTipiZamlar.put("12",new Double(7));
        isletmeTipiZamlar.put("13",new Double(7));
        isletmeTipiZamlar.put("14",new Double(7));
        
        isletmeTipiZamlar.put("21",new Double(20));
        isletmeTipiZamlar.put("22",new Double(15));
        isletmeTipiZamlar.put("23",new Double(15));
        isletmeTipiZamlar.put("24",new Double(15));
        
        isletmeTipiZamlar.put("31",new Double(30));
        isletmeTipiZamlar.put("32",new Double(25));
        isletmeTipiZamlar.put("33",new Double(20));
        isletmeTipiZamlar.put("34",new Double(15));
        
        return isletmeTipiZamlar;
    }
    
    
    public ArrayList getIsletmeDurumlari() {
    	ArrayList returnVal = new ArrayList();
    	returnVal.add("1");
    	returnVal.add("2");
    	returnVal.add("3");
    	return returnVal;
    }
    
    public Malzeme loadMalzemeler(){
    	File xmlFile = new File("malzemeler_modified.xml");
    	ArrayList obj = null;
    	Malzeme rootMalzeme = null;
    	XStream xstream = new XStream();
		xstream.alias("entry",Malzeme.class);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(xmlFile)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String xml = "";
		String temp = "";		
		try {
			xml = reader.readLine();
			while(temp!=null){
				xml+=temp;
				temp = reader.readLine();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
//		obj = (ArrayList)xstream.fromXML(xml);
		rootMalzeme = (Malzeme) xstream.fromXML(xml);
//		rootMalzeme = createTreeModel(obj);			

    	return rootMalzeme;
    }
    
	private static Malzeme createTreeModel(ArrayList obj) {
		try {
			StringTokenizer tokenizer = null;
			Malzeme rootMalzeme = new Malzeme("0","0","0","0","0","0");
			Iterator it = obj.iterator();
			while(it.hasNext()){
				String token = "";
				Malzeme malzeme = (Malzeme) it.next();
				tokenizer = new StringTokenizer(malzeme.getId(),".");
				Malzeme temp = rootMalzeme;
				Malzeme temp2 = null;
				while(tokenizer.hasMoreTokens()){
					if(token.equals("")) token = tokenizer.nextToken();
					else token += "."+tokenizer.nextToken();
					temp2 = temp.getChild(token);
					if(temp2 == null) temp.addChild(malzeme);
					temp = temp2;
				}
			}
			System.out.println("Done");
			return rootMalzeme;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}		
		return null;
	}

    public ArrayList loadCogunluklaKullanilanYapiElemanlari() {
        return null;
    }

    public ArrayList loadRadyatorler() {
        return null;
    }

	/* (non-Javadoc)
	 * @see com.iztek.dd.persistence.PersistenceManagerInt#loadIcSicakliklar()
	 */
	public ArrayList loadIcSicakliklar() {
		
		return null;
	}
	
	public ArrayList loadBasincKaybiCizelgesi() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.persistence.PersistenceManagerInt#loadZetaDirencleri()
	 */
	public HashMap loadZetaDirencleri() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.persistence.PersistenceManagerInt#loadOzelDirencler()
	 */
	public ArrayList loadOzelDirencler() {
		
		return null;
	}

    /* (non-Javadoc)
     * @see com.iztek.dd.persistence.PersistenceManagerInt#loadIsitilmayanBolgeSicakliklari()
     */
    public HashMap loadIsitilmayanBolgeSicakliklari() {
        
        return null;
    }

	/* (non-Javadoc)
	 * @see com.iztek.dd.persistence.PersistenceManagerInt#loadCamCLFs()
	 */
	public HashMap loadCamCLFs() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.persistence.PersistenceManagerInt#loadCatiCLTDs()
	 */
	public HashMap loadCatiCLTDs() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.persistence.PersistenceManagerInt#loadDuvarCLTDs()
	 */
	public HashMap loadDuvarCLTDs() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.persistence.PersistenceManagerInt#loadCamCLFs2()
	 */
	public HashMap loadCamCLFs2() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iztek.dd.persistence.PersistenceManagerInt#loadCamCLTDs()
	 */
	public ArrayList loadCamCLTDs() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList loadBolgeyeGoreStandartBilesenDirencleri() {
		return null;
	}

	public ArrayList loadGenlesmeDepolari() {
		return null;
	}

    public HashMap loadDisSicaklikDegerleri() {
        return null;
    }

    public CamSCs loadCamSCs() {
        return null;
    }

    public HashMap loadCamSC2s() {
        return null;
    }
}
