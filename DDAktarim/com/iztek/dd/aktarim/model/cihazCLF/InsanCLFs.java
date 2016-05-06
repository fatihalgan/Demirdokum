/*
 * Created on 17.�ub.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.aktarim.model.cihazCLF;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.thoughtworks.xstream.XStream;

/**
 * @author Tekin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InsanCLFs {
	
	public static InsanCLF getInsanCLF() {
		return insanCLF;
	}
	
	private static InsanCLF insanCLF = InsanCLF.getInstance();
	
	public void serializeSelfToXML(HashMap dataInHash){
		XStream xStream = new XStream();
		xStream.alias("InsanCLFs",HashMap.class);	//HashMap neye yerle�ek
		xStream.alias("gecenZaman",ArrayList.class);
		
		String xml = xStream.toXML(dataInHash);	//HashMap dosyas� 
		System.out.println(xml);					//buraya konulacak
		try {
			FileOutputStream fos = new FileOutputStream("output/insanCLFs.xml");
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
	
	public void loadDataFromXLS(InsanCLF instance,int sheetNo) {
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("input/ddveri.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(sheetNo-1);			
			ArrayList gecZaman;
			Integer hashKey;
			for(int rowCount = 2 ; rowCount < 11 ; rowCount++){//row kadar d�n
				HSSFRow row = sheet.getRow(rowCount);
				gecZaman = new ArrayList();
				
				for(int cellCount = 1 ; cellCount < 25 ; cellCount++){//col kadar d�n
					HSSFCell cell = row.getCell((short) cellCount);
					gecZaman.add(new Double(Double.parseDouble(cell.getStringCellValue())));
				}
				instance.getHacimTopKalSur().put((new Integer((int)row.getCell((short) 0).getNumericCellValue())),gecZaman);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadDataFromXLS() {
		try {
			int sheetNo = 13;
			InsanCLF instance = insanCLF;
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("input/ddveri.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(sheetNo-1);			
			ArrayList gecZaman;
			Integer hashKey;
			for(int rowCount = 2 ; rowCount < 11 ; rowCount++){//row kadar d�n
				HSSFRow row = sheet.getRow(rowCount);
				gecZaman = new ArrayList();
				
				for(int cellCount = 1 ; cellCount < 25 ; cellCount++){//col kadar d�n
					HSSFCell cell = row.getCell((short) cellCount);
					gecZaman.add(new Double(Double.parseDouble(cell.getStringCellValue())));
				}
				instance.getHacimTopKalSur().put((new Integer((int)row.getCell((short) 0).getNumericCellValue())),gecZaman);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double getDatum(int hacimTopKalSur,int gecenZaman){
		ArrayList gecenZamanList=(ArrayList)(insanCLF.getHacimTopKalSur().get(new Integer(hacimTopKalSur)));
		return ((Double)(gecenZamanList.get(gecenZaman-1))).doubleValue();
		
	}
	
	
	public static void main(String[] args) {
		InsanCLFs test = new InsanCLFs();
		test.loadDataFromXLS(insanCLF,13);
		test.serializeSelfToXML(insanCLF.getHacimTopKalSur());
		double tryDouble = test.getDatum(2,1);
	}
	
}
