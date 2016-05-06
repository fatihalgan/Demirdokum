package com.iztek.dd.aktarim.model.duvarSHGF;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;

public class DuvarSHGFs {
	private HashMap shgfs = new HashMap();

	private static DuvarSHGFs instance = null;

	/**
	 * @return Returns the clfs.
	 */
	public HashMap getShgfs() {
		return shgfs;
	}

	private DuvarSHGFs() {
	}

	public void addCLF12(String ay, DuvarSHGF shgf) {
		shgfs.put(ay, shgf);
	}

	public static DuvarSHGFs getInstance() {
		if (instance == null)
			instance = new DuvarSHGFs();
		return instance;
	}

	public void serializeSelfToXml() {
		XStream xStream = new XStream();
		xStream.alias("DuvarSHGFs", HashMap.class);

		String xml = xStream.toXML(shgfs);
		System.out.println(xml);
		try {
			FileOutputStream fos = new FileOutputStream("output/DuvarSHGF.xml");
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
		xStream.alias("DuvarSHGFs", HashMap.class);
		Object object = null;

		FileInputStream fis;
		try {
			fis = new FileInputStream("output/DuvarSHGF.xml");
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

	public DuvarSHGF getDuvarSHGF(String ay) {
		return (DuvarSHGF) shgfs.get(ay);
	}
}