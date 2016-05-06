/*
 * Created on 26.Ara.2004
 *
 */
package com.iztek.dd.persistence;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import com.iztek.dd.GenelTanimlarBean;
import com.iztek.dd.IsiKaybi.domain.AlfaDegeri;
import com.iztek.dd.IsiKazanci.domain.CamSCs;
import com.iztek.dd.IsiKazanci.domain.Ekipman;
import com.iztek.dd.IsiKazanci.domain.Klima;
import com.iztek.dd.domain.Bolge;
import com.iztek.dd.security.KeyUtility;
import com.iztek.dd.utilities.Malzeme;
import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *  
 */
public class XMLPersistenceManager implements PersistenceManagerInt {
        
	private File gunesIsinimSiddetiXmlFile = new File("xml/GunesIsinimSiddeti.xml");

	private File cogunluklaKullanilanYapielemanlariXmlFile = new File("xml/cogunluklakullanilanyapielemanlari.xml");

	private File radyatorlerXmlFile = new File("xml/radyatorler.ddx");

	private File icsicakliklarXmlFile = new File("xml/icsicakliklar.xml");

	private File zDirencleriXmlFile = new File("xml/zetadirencleri.xml");

	private File ozelDirenclerXmlFile = new File("xml/ozeldirencler.xml");

	private File boruCapiHesabiCizelgesiXmlFile = new File("xml/borucapihesabicizelgesi.xml");

	private File isitilmayanBolgeSicakliklariXmlFile = new File("xml/IsitilmayanBolgeSicakliklari.xml");
	
	private File genlesmeDepolariXmlFile = new File("xml/genlesme.ddx");
	
	private File insanlardanIsiKazanciXmlFile = new File("xml/InsanlardanIsiKazanci.xml");

	private File clfXMLFile = new File("xml/CLFs.xml");
	
	private File camCLFsXmlFile = new File("xml/CamCLF.xml");
	
	private File camCLFs2XmlFile = new File("xml/CamCLF2.xml");
	
	private File camCLTDXmlFile = new File("xml/CamCLTD.xml");
	
	private File catiCLTDXmlFile = new File("xml/CatiCLTD.xml");
	
	private File duvarCLTDXmlFile = new File("xml/DuvarCLTD.xml");
	
	private File camSCXmlFile = new File("xml/CamSC.xml");
	
	private File aydinlatmaCLF8XmlFile = new File("xml/AydinlatmaCLF8.xml");
	
	private File aydinlatmaCLF12sXmlFile = new File("xml/AydinlatmaCLF12.xml");
	
	private File bolgeyeGoreIsiGecirgenlikDirencleri = new File("xml/BolgeyeGoreGecirgenlikDirencleri.xml");
	
	private File cihazCLFXmlFile = new File("xml/CihazCLF.xml");
	
	private File disSicaklikDegerleriXmlFile = new File("xml/DisSicakliklar.xml");
	
	private File camSC2sXmlFile = new File("xml/CamSC2.xml");
	
	private File duvarSHGFsXmlFile = new File("xml/DuvarSHGF.xml");
	
	private File aktivitelerXmlFile = new File("xml/Aktiviteler.xml");
	
	private File davlumbazliCihazXMLFile = new File("xml/doylumBazliCihazCLFs.xml");
	
	private File davlumbazsizCihazXMLFile = new File("xml/doylumBazsizCihazCLFs.xml");
	
	private File insanCLFsXMLFile = new File("xml/insanCLFs.xml");
	
	private File isiticilarXMLFile = new File("xml/isitici.ddx");
	
	private File klimalarXMLFile = new File("xml/klimalar.ddx");
	
	private File ekipmanlarXMLFile = new File("xml/Ekipmanlar.xml");
	
	private File malzemelerXMLFile = new File("xml/malzemeler_modified.xml");
	
	private File isiKaybiMalzemelerXMLFile = new File("xml/isiKaybiMalzemeler.xml");
	
	private File alfaDegerleriXMLFile = new File("xml/alfaDegerleri.xml");
	
	public XMLPersistenceManager() {
		super();
	}

	public HashMap loadGunesIsinimSiddetleri() {
		XStream xstream = new XStream();
		xstream.alias("GunesIsinimSiddetleri", HashMap.class);
		HashMap isinimSiddetleri = null;
		try {
			isinimSiddetleri = (HashMap) xstream.fromXML(new FileReader(
					gunesIsinimSiddetiXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return isinimSiddetleri;
	}
		
	public HashMap loadCamCLFs() {
		XStream xstream = new XStream();
		xstream.alias("CamCLFs", HashMap.class);
		HashMap camCLFs = null;
		try {
			camCLFs = (HashMap)xstream.fromXML(new FileReader(camCLFsXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return camCLFs;
	}
	
	public HashMap loadCatiCLTDs() {
		XStream xstream = new XStream();
		xstream.alias("CatiCLTDs", HashMap.class);
		HashMap catiCLTDs = null;
		try {
			catiCLTDs = (HashMap)xstream.fromXML(new FileReader(catiCLTDXmlFile));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return catiCLTDs;
	}
	
	public HashMap loadDuvarCLTDs() {
		XStream xstream = new XStream();
		xstream.alias("DuvarCLTDs", HashMap.class);
		HashMap duvarCLTDs = null;
		try {
			duvarCLTDs = (HashMap)xstream.fromXML(new FileReader(duvarCLTDXmlFile));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return duvarCLTDs;
	}
	
	public HashMap loadCamCLFs2() {
		XStream xstream = new XStream();
		xstream.alias("CamCLFs2", HashMap.class);
		HashMap camCLFs = null;
		try {
			camCLFs = (HashMap)xstream.fromXML(new FileReader(camCLFs2XmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return camCLFs;
	}
	
	public ArrayList loadCamCLTDs() {
		XStream xstream = new XStream();
		xstream.alias("CamCLTDs", ArrayList.class);
		ArrayList camCLTD = null;
		try {
			camCLTD = (ArrayList)xstream.fromXML(new FileReader(camCLTDXmlFile));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return camCLTD;
	}

	public CamSCs loadCamSCs() {
		XStream xstream = new XStream();
		xstream.alias("CamSCs", HashMap.class);
		xstream.alias("camSCList",ArrayList.class);
		CamSCs camSCs = null;
		try {
			camSCs = (CamSCs)xstream.fromXML(new FileReader(camSCXmlFile));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return camSCs;
	}

	public void storeGunesIsinimSiddetleri(HashMap obj) {
		XStream xstream = new XStream();
		xstream.alias("GunesIsinimSiddetleri", HashMap.class);
		String xml = xstream.toXML(obj);
		try {
			if (!gunesIsinimSiddetiXmlFile.exists())
				gunesIsinimSiddetiXmlFile.createNewFile();
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(gunesIsinimSiddetiXmlFile)));
			out.write(xml);
			out.flush();
			out.close();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public HashMap loadDisSicakliklar() {
		HashMap disSicakliklar = new HashMap();

		HashMap ay = new HashMap();
		ay.put("1", new Double(8.0));
		ay.put("2", new Double(3.3));
		ay.put("3", new Double(1.3));
		ay.put("4", new Double(-5.2));
		disSicakliklar.put("1", ay);

		ay = new HashMap();
		ay.put("1", new Double(9.3));
		ay.put("2", new Double(4.5));
		ay.put("3", new Double(2.0));
		ay.put("4", new Double(-4.1));
		disSicakliklar.put("2", ay);

		ay = new HashMap();
		ay.put("1", new Double(11.5));
		ay.put("2", new Double(7.2));
		ay.put("3", new Double(5.0));
		ay.put("4", new Double(-1.3));
		disSicakliklar.put("3", ay);

		ay = new HashMap();
		ay.put("1", new Double(15.7));
		ay.put("2", new Double(12.6));
		ay.put("3", new Double(9.8));
		ay.put("4", new Double(5.1));
		disSicakliklar.put("4", ay);

		ay = new HashMap();
		ay.put("1", new Double(20.6));
		ay.put("2", new Double(17.8));
		ay.put("3", new Double(14.1));
		ay.put("4", new Double(10.1));
		disSicakliklar.put("5", ay);

		ay = new HashMap();
		ay.put("1", new Double(25.4));
		ay.put("2", new Double(21.9));
		ay.put("3", new Double(18.1));
		ay.put("4", new Double(13.5));
		disSicakliklar.put("6", ay);

		ay = new HashMap();
		ay.put("1", new Double(28.0));
		ay.put("2", new Double(24.4));
		ay.put("3", new Double(21.1));
		ay.put("4", new Double(17.2));
		disSicakliklar.put("7", ay);

		ay = new HashMap();
		ay.put("1", new Double(27.2));
		ay.put("2", new Double(23.8));
		ay.put("3", new Double(20.6));
		ay.put("4", new Double(17.2));
		disSicakliklar.put("8", ay);

		ay = new HashMap();
		ay.put("1", new Double(23.3));
		ay.put("2", new Double(19.6));
		ay.put("3", new Double(16.5));
		ay.put("4", new Double(13.2));
		disSicakliklar.put("9", ay);

		ay = new HashMap();
		ay.put("1", new Double(18.1));
		ay.put("2", new Double(14.1));
		ay.put("3", new Double(11.3));
		ay.put("4", new Double(6.9));
		disSicakliklar.put("10", ay);

		ay = new HashMap();
		ay.put("1", new Double(13.3));
		ay.put("2", new Double(9.1));
		ay.put("3", new Double(6.5));
		ay.put("4", new Double(1.3));
		disSicakliklar.put("11", ay);

		ay = new HashMap();
		ay.put("1", new Double(9.4));
		ay.put("2", new Double(4.9));
		ay.put("3", new Double(2.6));
		ay.put("4", new Double(-3.0));
		disSicakliklar.put("12", ay);

		return disSicakliklar;
	}

	public Bolge loadBolge(String bolgeAdi) {
		return null;
	}

	public HashMap loadYonZamlar() {
		HashMap yonlereGoreZamlar = new HashMap();

		yonlereGoreZamlar.put("G", new Double(-5));
		yonlereGoreZamlar.put("GB", new Double(-5));
		yonlereGoreZamlar.put("B", new Double(0));
		yonlereGoreZamlar.put("KB", new Double(5));
		yonlereGoreZamlar.put("K", new Double(5));
		yonlereGoreZamlar.put("KD", new Double(5));
		yonlereGoreZamlar.put("D", new Double(0));
		yonlereGoreZamlar.put("GD", new Double(-5));
		return yonlereGoreZamlar;
	}

	public HashMap loadIsletmeTipiZamlar() {
		HashMap isletmeTipiZamlar = new HashMap();

		isletmeTipiZamlar.put("11", new Double(7));
		isletmeTipiZamlar.put("12", new Double(7));
		isletmeTipiZamlar.put("13", new Double(7));
		isletmeTipiZamlar.put("14", new Double(7));

		isletmeTipiZamlar.put("21", new Double(20));
		isletmeTipiZamlar.put("22", new Double(15));
		isletmeTipiZamlar.put("23", new Double(15));
		isletmeTipiZamlar.put("24", new Double(15));

		isletmeTipiZamlar.put("31", new Double(30));
		isletmeTipiZamlar.put("32", new Double(25));
		isletmeTipiZamlar.put("33", new Double(20));
		isletmeTipiZamlar.put("34", new Double(15));

		return isletmeTipiZamlar;
	}

	public ArrayList getIsletmeDurumlari() {
		ArrayList returnVal = new ArrayList();
		returnVal.add("1");
		returnVal.add("2");
		returnVal.add("3");
		return returnVal;
	}

	public Malzeme loadMalzemeler() {
		ArrayList obj = null;
		Malzeme rootMalzeme = null;
		XStream xstream = new XStream();
		xstream.alias("entry", Malzeme.class);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(malzemelerXMLFile)));
			rootMalzeme = (Malzeme) xstream.fromXML(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return rootMalzeme;
	}
	
	public void saveMalzemeler(Malzeme rootMalzeme){
		XStream xstream = new XStream();
		xstream.alias("entry", Malzeme.class);
		String xml = xstream.toXML(rootMalzeme);
		try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(malzemelerXMLFile));
            bos.write(xml.getBytes());
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) {        
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private static Malzeme createTreeModel(ArrayList obj) {
		try {
			StringTokenizer tokenizer = null;
			Malzeme rootMalzeme = new Malzeme("0", "0", "0", "0", "0", "0");
			Iterator it = obj.iterator();
			while (it.hasNext()) {
				String token = "";
				Malzeme malzeme = (Malzeme) it.next();
				tokenizer = new StringTokenizer(malzeme.getId(), ".");
				Malzeme temp = rootMalzeme;
				Malzeme temp2 = null;
				while (tokenizer.hasMoreTokens()) {
					if (token.equals(""))
						token = tokenizer.nextToken();
					else
						token += "." + tokenizer.nextToken();
					temp2 = temp.getChild(token);
					if (temp2 == null)
						temp.addChild(malzeme);
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
		XStream xstream = new XStream();
		xstream.alias("yapiElemanlari", ArrayList.class);
		ArrayList yapiElemanlari = null;
		try {
			yapiElemanlari = (ArrayList) xstream.fromXML(new FileReader(
					cogunluklaKullanilanYapielemanlariXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return yapiElemanlari;

	}

	public ArrayList loadRadyatorler() {
		XStream xstream = new XStream();
		xstream.alias("radyatorler", ArrayList.class);
		ArrayList radyatorler = null;
		radyatorler = (ArrayList) getSecretFile(radyatorlerXmlFile);
		return radyatorler;
	}

	public ArrayList loadIcSicakliklar() {
		XStream xstream = new XStream();
		xstream.alias("icSicakliklar", ArrayList.class);
		ArrayList icSicakliklar = null;
		try {
			icSicakliklar = (ArrayList) xstream.fromXML(new FileReader(
					icsicakliklarXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return icSicakliklar;
	}
	
	public static void main(String[] args) {
		XMLPersistenceManager man = new XMLPersistenceManager();
		ArrayList ozelDirencler = man.loadOzelDirencler();
		//HashMap DuvrCLTDs = man.loadDuvarCLTDs();
		HashMap insanlardanisi=man.loadInsanlardanIsiKazanci();
		//System.out.println(insanlardanisi.toString());
		HashMap clfs=man.loadCLFs();
		com.iztek.dd.IsiKazanci.domain.CLF cl=((com.iztek.dd.IsiKazanci.domain.CLF)(clfs.values().toArray()[0]));
		System.out.println(cl.getGecenZamanDegeri(6)+" "+cl.getHacimdeToplamkalmaSuresi()+" "+cl.getGecenZamanDegeri(24));
		//HashMap CamSCs = man.loadCamSCs();

	}

	public ArrayList loadBasincKaybiCizelgesi() {
		XStream xstream = new XStream();
		xstream.alias("basincKaybiRows", ArrayList.class);
		ArrayList basincKaybiCizelgeRows = null;
		try {
			basincKaybiCizelgeRows = (ArrayList) xstream
					.fromXML(new FileReader(boruCapiHesabiCizelgesiXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return basincKaybiCizelgeRows;
	}

	public HashMap loadZetaDirencleri() {
		XStream xstream = new XStream();
		xstream.alias("zetaDirencleri", HashMap.class);
		HashMap zetaDirencleri = null;
		try {
			zetaDirencleri = (HashMap) xstream.fromXML(new FileReader(
					zDirencleriXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return zetaDirencleri;
	}

	public ArrayList loadOzelDirencler() {
		XStream xstream = new XStream();
		xstream.alias("ozelDirencler", ArrayList.class);
		ArrayList ozelDirencler = null;
		try {
			ozelDirencler = (ArrayList) xstream.fromXML(new FileReader(
					ozelDirenclerXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ozelDirencler;
	}

	public HashMap loadIsitilmayanBolgeSicakliklari() {
		XStream xstream = new XStream();
		xstream.alias("IsitilmayanBolgeSicakliklari", HashMap.class);
		HashMap isitilmayanBolgeSicakliklari = null;
		try {
			isitilmayanBolgeSicakliklari = (HashMap) xstream
					.fromXML(new FileReader(isitilmayanBolgeSicakliklariXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return isitilmayanBolgeSicakliklari;
	}

	public HashMap loadInsanlardanIsiKazanci() {
		XStream xstream = new XStream();
		xstream.alias("Insanlar", HashMap.class);
		HashMap insanlar = null;
		try {
			insanlar = (HashMap) xstream.fromXML(new FileReader(
					insanlardanIsiKazanciXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return insanlar;
	}
		
	public HashMap loadCLFs() {
		XStream xstream = new XStream();
		xstream.alias("CLFs", HashMap.class);
		HashMap clfs = null;
		try {
			clfs = (HashMap) xstream.fromXML(new FileReader(
					clfXMLFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return clfs;
	}
	
	public HashMap loadAydinlatmaCLF8s() {
		XStream xstream = new XStream();
		xstream.alias("AydinlatmaCLF8s", HashMap.class);
		HashMap aydinlatmaCLF8s = null;
		try {
			aydinlatmaCLF8s = (HashMap)xstream.fromXML(new FileReader(aydinlatmaCLF8XmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aydinlatmaCLF8s;
	}
	
	public ArrayList loadBolgeyeGoreStandartBilesenDirencleri() {
		XStream xStream = new XStream();		
		xStream.alias("ArrayList",ArrayList.class);
		ArrayList bolgeler = null;
		try {
			bolgeler = (ArrayList)xStream.fromXML(new FileReader(bolgeyeGoreIsiGecirgenlikDirencleri));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bolgeler;
	}

	public ArrayList loadGenlesmeDepolari() {
		XStream xstream = new XStream();
		xstream.alias("GenlesmeDepolari", ArrayList.class);
		ArrayList genlesmeDepolari = null;	
		genlesmeDepolari = getSecretFile(genlesmeDepolariXmlFile);
		return genlesmeDepolari;		
	}
    
	public HashMap loadDisSicaklikDegerleri() {
		XStream xstream = new XStream();
		xstream.alias("DisSicakliklar", HashMap.class);
		HashMap disSicakliklar = null;
		try {
		    disSicakliklar = (HashMap)xstream.fromXML(new FileReader(disSicaklikDegerleriXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return disSicakliklar;
    }

    public HashMap loadCamSC2s() {
		XStream xstream = new XStream();
		xstream.alias("CamSC2s", HashMap.class);
		HashMap camSC2s = null;
		try {
		    camSC2s = (HashMap)xstream.fromXML(new FileReader(camSC2sXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return camSC2s;
    }

    public HashMap loadDuvarSHGFs() {
		XStream xstream = new XStream();
		xstream.alias("DuvarSHGFs", HashMap.class);
		HashMap duvarSHGFs = null;
		try {
		    duvarSHGFs = (HashMap)xstream.fromXML(new FileReader(duvarSHGFsXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return duvarSHGFs;
    }

    public HashMap loadAydinlatmaCLF12s() {
		XStream xstream = new XStream();
		xstream.alias("AydinlatmaCLF12s", HashMap.class);
		HashMap aydinlatmaCLF12s = null;
		try {
		    aydinlatmaCLF12s = (HashMap)xstream.fromXML(new FileReader(aydinlatmaCLF12sXmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aydinlatmaCLF12s;
    }

    public ArrayList loadAktiviteler() {
        XStream xStream = new XStream();
        xStream.alias("Aktiviteler",ArrayList.class);
        ArrayList aktiviteler = null;
       	try {
       	    aktiviteler = (ArrayList)xStream.fromXML(new FileReader(aktivitelerXmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return aktiviteler;
    }

    public HashMap loadDavlumbazliCihazCLFs() {
        XStream xStream = new XStream();
        HashMap clfs = null;
        xStream.alias("DoylumBazliCihazCLFs",HashMap.class);
        xStream.alias("gecenZaman",ArrayList.class);
        try {
            clfs = (HashMap)xStream.fromXML(new FileReader(davlumbazliCihazXMLFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return clfs;
    }
    
    public HashMap loadDavlumbazsizCihazCLFs() {
        XStream xStream = new XStream();
        HashMap clfs = null;
        xStream.alias("DoylumBazsizCihazCLFs",HashMap.class);
        xStream.alias("gecenZaman",ArrayList.class);
        try {
            clfs = (HashMap)xStream.fromXML(new FileReader(davlumbazsizCihazXMLFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return clfs;
    }

    public HashMap loadInsanCLFs() {
        XStream xStream = new XStream();
        HashMap clfs = null;
        xStream.alias("InsanCLFs",HashMap.class);
        xStream.alias("gecenZaman",ArrayList.class);
        try {
            clfs = (HashMap)xStream.fromXML(new FileReader(insanCLFsXMLFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return clfs;
    }

    public ArrayList loadKlimalar() {
        ArrayList klimalar = null;
        XStream xStream = new XStream();
        xStream.alias("Klimalar",ArrayList.class);
        xStream.alias("Klima",Klima.class);        
        klimalar = (ArrayList)getSecretFile(klimalarXMLFile);
        return klimalar;
    }

    public ArrayList loadEkipmanlar() {
        ArrayList ekipmanlar = null;
        XStream xStream = new XStream();
        xStream.alias("Ekipmanlar",ArrayList.class);
        xStream.alias("Ekipman",Ekipman.class);        
		try {
			ekipmanlar = (ArrayList)xStream.fromXML(new FileReader(ekipmanlarXMLFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        return ekipmanlar;
    }

    public void saveGenelTanimlar(GenelTanimlarBean bean){
        XStream xStream = new XStream();
        String xml = xStream.toXML(bean);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("xml/Bayi.xml")));
            bos.write(xml.getBytes());
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) { 
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public GenelTanimlarBean loadGenelTanimlar(){
        XStream xStream = new XStream();
        GenelTanimlarBean bean = null;
        try {
            bean = (GenelTanimlarBean)xStream.fromXML(new FileReader(new File("xml/Bayi.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
    
    public ArrayList loadIsiKaybiMalzemeler() {
        ArrayList malzemeler = null;
        XStream xStream = new XStream();
        xStream.alias("Malzemeler",ArrayList.class);
        xStream.alias("Malzeme",com.iztek.dd.IsiKaybi.domain.Malzeme.class);        
		try {
			malzemeler = (ArrayList)xStream.fromXML(new FileReader(isiKaybiMalzemelerXMLFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        return malzemeler;    
    }
    
    public void serializeIsiKaybiMalzemelerToXML(ArrayList malzemeler) {
        XStream xStream = new XStream();
        String xml = xStream.toXML(malzemeler);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(isiKaybiMalzemelerXMLFile));
            bos.write(xml.getBytes());
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) { 
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeCogunluklaKullanilanYapiElemanlari(ArrayList yapiElemanlari) {
        XStream xStream = new XStream();
        xStream.alias("yapiElemanlari", ArrayList.class);
        String xml = xStream.toXML(yapiElemanlari);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(cogunluklaKullanilanYapielemanlariXmlFile));
            bos.write(xml.getBytes());
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) { 
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    public ArrayList loadAlphaDegerleri() {
        ArrayList alfaDegerleri = null;
        XStream xStream = new XStream();
        xStream.alias("AlfaDegerleri",ArrayList.class);
        xStream.alias("AlfaDegeri",AlfaDegeri.class);
		try {
			alfaDegerleri = (ArrayList)xStream.fromXML(new FileReader(alfaDegerleriXMLFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        return alfaDegerleri;    
    }
    
    public void serializeAlfaDegerleri(ArrayList alfaDegerleri) {
        XStream xStream = new XStream();
        xStream.alias("AlfaDegerleri",ArrayList.class);
        xStream.alias("AlfaDegeri",AlfaDegeri.class);
        String xml = xStream.toXML(alfaDegerleri);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(alfaDegerleriXMLFile));
            bos.write(xml.getBytes());
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) { 
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    public ArrayList loadIsiticilar() {
        ArrayList isiticilar = null;
        XStream xStream = new XStream();
        xStream.alias("Isiticilar",ArrayList.class);
        isiticilar = (ArrayList) getSecretFile(isiticilarXMLFile);
        return isiticilar;
    }
    
    private static SecretKey getKey(){
        SecretKey key = null;
        try {
            key = (SecretKey) KeyUtility.reconstituteKey("cDcsNAfqxDE=");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }
    
    private static ArrayList getSecretFile(File sealedFile){
        ArrayList decrypted = null;
        
        try {
            Cipher dcipher = Cipher.getInstance("DES");
            dcipher.init(Cipher.DECRYPT_MODE, getKey());
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sealedFile));
            SealedObject so = (SealedObject)ois.readObject();
            decrypted = (ArrayList) so.getObject(dcipher);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return decrypted;
    }
}
