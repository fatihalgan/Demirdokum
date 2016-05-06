/*
 * Created on 10.�ub.2005
 *
 */
package com.iztek.dd.aktarim;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *
 */
public class BolgeyeGoreStandartBilesenDirencleri {
	private ArrayList bolgeler = new ArrayList();
	
	ArrayList birinciBolge = new ArrayList();
	ArrayList ikinciBolge = new ArrayList();
	ArrayList ucuncuBolge = new ArrayList();
	ArrayList dorduncuBolge = new ArrayList();

	private BolgeyeGoreStandartBilesenDirencleri(){		
		birinciBolge.add(new StandartBilesenDirenci("D�� duvarlar",0.4));
		birinciBolge.add(new StandartBilesenDirenci("Merdiven duvarlar�",0.21));
		birinciBolge.add(new StandartBilesenDirenci("�zeri �at�l� duvarlar",1.03));
		birinciBolge.add(new StandartBilesenDirenci("Is�t�lmayan bodrum ve bina d��emeleri",0.55));
		birinciBolge.add(new StandartBilesenDirenci("Zemine oturan d��emeler",0.55));
		birinciBolge.add(new StandartBilesenDirenci("A��k ge�it �zeri d��emeler",1.2));
		birinciBolge.add(new StandartBilesenDirenci("D�z �at� ve teras d��emeleri",1.28));

		ikinciBolge.add(new StandartBilesenDirenci("D�� duvarlar",0.6));
		ikinciBolge.add(new StandartBilesenDirenci("Merdiven duvarlar�",0.34));
		ikinciBolge.add(new StandartBilesenDirenci("�zeri �at�l� duvarlar",1.28));
		ikinciBolge.add(new StandartBilesenDirenci("Is�t�lmayan bodrum ve bina d��emeleri",0.79));
		ikinciBolge.add(new StandartBilesenDirenci("Zemine oturan d��emeler",0.79));
		ikinciBolge.add(new StandartBilesenDirenci("A��k ge�it �zeri d��emeler",1.71));
		ikinciBolge.add(new StandartBilesenDirenci("D�z �at� ve teras d��emeleri",2.06));

		ucuncuBolge.add(new StandartBilesenDirenci("D�� duvarlar",0.8));
		ucuncuBolge.add(new StandartBilesenDirenci("Merdiven duvarlar�",0.42));
		ucuncuBolge.add(new StandartBilesenDirenci("�zeri �at�l� duvarlar",2.06));
		ucuncuBolge.add(new StandartBilesenDirenci("Is�t�lmayan bodrum ve bina d��emeleri",1.28));
		ucuncuBolge.add(new StandartBilesenDirenci("Zemine oturan d��emeler",1.28));
		ucuncuBolge.add(new StandartBilesenDirenci("A��k ge�it �zeri d��emeler",2.14));
		ucuncuBolge.add(new StandartBilesenDirenci("D�z �at� ve teras d��emeleri",2.57));

		dorduncuBolge.add(new StandartBilesenDirenci("D�� duvarlar",0.8));
		dorduncuBolge.add(new StandartBilesenDirenci("Merdiven duvarlar�",0.42));
		dorduncuBolge.add(new StandartBilesenDirenci("�zeri �at�l� duvarlar",2.06));
		dorduncuBolge.add(new StandartBilesenDirenci("Is�t�lmayan bodrum ve bina d��emeleri",1.28));
		dorduncuBolge.add(new StandartBilesenDirenci("Zemine oturan d��emeler",1.28));
		dorduncuBolge.add(new StandartBilesenDirenci("A��k ge�it �zeri d��emeler",2.14));
		dorduncuBolge.add(new StandartBilesenDirenci("D�z �at� ve teras d��emeleri",2.57));

		bolgeler.add(birinciBolge);
		bolgeler.add(ikinciBolge);
		bolgeler.add(ucuncuBolge);
		bolgeler.add(dorduncuBolge);
	}
	
	public static void main(String[] args) {
		BolgeyeGoreStandartBilesenDirencleri direncler = new BolgeyeGoreStandartBilesenDirencleri();
		direncler.persistSelf();
	}

	private void persistSelf() {
		XStream xStream = new XStream();
		xStream.alias("ArrayList",ArrayList.class);
		String xml = xStream.toXML(bolgeler);
		try {
			FileOutputStream fos = new FileOutputStream("output/BolgeyeGoreGecirgenlikDirencleri.xml");
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

}

