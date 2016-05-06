package com.iztek.dd.aktarim.model.aydinlatmaCLF;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;

public class AydinlatmaCLF12s {
	private HashMap clf12s = new HashMap();

	private static AydinlatmaCLF12s instance = null;

	/**
	 * @return Returns the clfs.
	 */
	public HashMap getClf12s() {
		return clf12s;
	}

	private AydinlatmaCLF12s() {
	}

	public void addCLF12(String tip, AydinlatmaCLF12 clf12) {
		clf12s.put(tip, clf12);
	}

	public static AydinlatmaCLF12s getInstance() {
		if (instance == null)
			instance = new AydinlatmaCLF12s();
		return instance;
	}

	public void serializeSelfToXml() {
		XStream xStream = new XStream();
		xStream.alias("AydinlatmaCLF12s", HashMap.class);

		String xml = xStream.toXML(clf12s);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream(
					"output/AydinlatmaCLF12.xml");
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

	public Object readSelfFromXml() {
		XStream xStream = new XStream();
		xStream.alias("AydinlatmaCLF12s", HashMap.class);
		Object object = null;

		FileInputStream fis;
		try {
			fis = new FileInputStream("output/AydinlatmaCLF12.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			object = xStream.fromXML(br);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}

	public AydinlatmaCLF12 getAydinlatmaCLF12(String tip) {
		return (AydinlatmaCLF12) clf12s.get(tip);
	}
}