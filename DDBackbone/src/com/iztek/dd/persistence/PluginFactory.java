/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Selim HENDRICKSON
 *
 */
public class PluginFactory {
	private static Properties props = new Properties();
	static File propertiesFile = new File("./props/run.properties");
	
	static{
		try{
			props.load(new FileInputStream(propertiesFile));
		}catch(Exception ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Object getPlugin(Class iFace){
		String implName = props.getProperty(iFace.getName());
		if(implName == null){
			throw new RuntimeException("Implementation not supplied for "+
										iFace.getName() + " in PluginFactory properties.");
		}
		try{
			return Class.forName(implName).newInstance();
		}catch (Exception e) {
			throw new RuntimeException("Factory unable to construct instance of "+
										iFace.getName());
		}
	}
}
