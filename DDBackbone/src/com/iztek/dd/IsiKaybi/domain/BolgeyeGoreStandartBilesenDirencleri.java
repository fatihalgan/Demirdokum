/*
 * Created on 10.Þub.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.io.BufferedOutputStream;
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
public class BolgeyeGoreStandartBilesenDirencleri {
	private ArrayList bolgeler = new ArrayList();
	private static BolgeyeGoreStandartBilesenDirencleri instance = null;
	
	private BolgeyeGoreStandartBilesenDirencleri(){
		bolgeler = PersistenceManagerInt.INSTANCE.loadBolgeyeGoreStandartBilesenDirencleri();
	}
	
	public static BolgeyeGoreStandartBilesenDirencleri getInstance(){
		if(instance==null) instance = new BolgeyeGoreStandartBilesenDirencleri();
		return instance;
	}
	
	public ArrayList getBolgeyeGoreDirencler(String bolgeId){
		return (ArrayList)bolgeler.get(Integer.parseInt(bolgeId)-1);
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

