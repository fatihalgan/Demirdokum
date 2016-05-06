/*
 * Created on 29.Ara.2004
 *
 */
package com.iztek.dd.spike;

import java.util.Map;

import com.iztek.dd.utilities.IllerBean;
import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *
 */
public class TestPersistingIllerBean {

	public static void main(String[] args) {
		XStream xstream = new XStream();
		Map illerMap = null;
		Map newMap = null;
		
		IllerBean iller = IllerBean.getInstance();
		String xml = xstream.toXML(illerMap);
		newMap = (Map) xstream.fromXML(xml);
		System.out.println(xml);
	}
}
