/*
 * Created on 10.Þub.2005
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
		birinciBolge.add(new StandartBilesenDirenci("Dýþ duvarlar",0.4));
		birinciBolge.add(new StandartBilesenDirenci("Merdiven duvarlarý",0.21));
		birinciBolge.add(new StandartBilesenDirenci("Üzeri çatýlý duvarlar",1.03));
		birinciBolge.add(new StandartBilesenDirenci("Isýtýlmayan bodrum ve bina döþemeleri",0.55));
		birinciBolge.add(new StandartBilesenDirenci("Zemine oturan döþemeler",0.55));
		birinciBolge.add(new StandartBilesenDirenci("Açýk geçit üzeri döþemeler",1.2));
		birinciBolge.add(new StandartBilesenDirenci("Düz çatý ve teras döþemeleri",1.28));

		ikinciBolge.add(new StandartBilesenDirenci("Dýþ duvarlar",0.6));
		ikinciBolge.add(new StandartBilesenDirenci("Merdiven duvarlarý",0.34));
		ikinciBolge.add(new StandartBilesenDirenci("Üzeri çatýlý duvarlar",1.28));
		ikinciBolge.add(new StandartBilesenDirenci("Isýtýlmayan bodrum ve bina döþemeleri",0.79));
		ikinciBolge.add(new StandartBilesenDirenci("Zemine oturan döþemeler",0.79));
		ikinciBolge.add(new StandartBilesenDirenci("Açýk geçit üzeri döþemeler",1.71));
		ikinciBolge.add(new StandartBilesenDirenci("Düz çatý ve teras döþemeleri",2.06));

		ucuncuBolge.add(new StandartBilesenDirenci("Dýþ duvarlar",0.8));
		ucuncuBolge.add(new StandartBilesenDirenci("Merdiven duvarlarý",0.42));
		ucuncuBolge.add(new StandartBilesenDirenci("Üzeri çatýlý duvarlar",2.06));
		ucuncuBolge.add(new StandartBilesenDirenci("Isýtýlmayan bodrum ve bina döþemeleri",1.28));
		ucuncuBolge.add(new StandartBilesenDirenci("Zemine oturan döþemeler",1.28));
		ucuncuBolge.add(new StandartBilesenDirenci("Açýk geçit üzeri döþemeler",2.14));
		ucuncuBolge.add(new StandartBilesenDirenci("Düz çatý ve teras döþemeleri",2.57));

		dorduncuBolge.add(new StandartBilesenDirenci("Dýþ duvarlar",0.8));
		dorduncuBolge.add(new StandartBilesenDirenci("Merdiven duvarlarý",0.42));
		dorduncuBolge.add(new StandartBilesenDirenci("Üzeri çatýlý duvarlar",2.06));
		dorduncuBolge.add(new StandartBilesenDirenci("Isýtýlmayan bodrum ve bina döþemeleri",1.28));
		dorduncuBolge.add(new StandartBilesenDirenci("Zemine oturan döþemeler",1.28));
		dorduncuBolge.add(new StandartBilesenDirenci("Açýk geçit üzeri döþemeler",2.14));
		dorduncuBolge.add(new StandartBilesenDirenci("Düz çatý ve teras döþemeleri",2.57));

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

