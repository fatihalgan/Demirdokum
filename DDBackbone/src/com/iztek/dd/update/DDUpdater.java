/*
 * Created on 31.Oca.2005
 *
 */
package com.iztek.dd.update;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import com.iztek.dd.zip.ZipUtility;

/**
 * @author Selim HENDRICKSON
 *
 */
public class DDUpdater {

	public static boolean updateXmlFiles(){
		String updateSiteAddress = "";
		
		HttpClient updateClient = new HttpClient();
		HttpMethod method = new GetMethod("http://localhost:8080/DDWeb/Updates.zip");		
		try {
			updateClient.executeMethod(method);
			File zippedFile = new File("/temp/Update.zip");
			FileOutputStream fos = new FileOutputStream(zippedFile);
		    InputStream in = method.getResponseBodyAsStream();
		    byte[] buffer = new byte[10000];
		    int len ;
		    while ((len = in.read(buffer)) > 0) {
		    	fos.write(buffer, 0, len);
		    }
		    in.close();
			fos.flush();
			fos.close();			
			ZipUtility.uncompressZipFile(zippedFile,"xml");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			method.releaseConnection();
		}		
		return true;
	}
	
}
