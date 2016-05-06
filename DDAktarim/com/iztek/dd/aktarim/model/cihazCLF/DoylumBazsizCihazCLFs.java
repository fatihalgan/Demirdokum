/*
 * Created on 17.Þub.2005
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
public class DoylumBazsizCihazCLFs {
	
	private static DoylumBazsizCihazCLF doylumBazsizCihazCLF = DoylumBazsizCihazCLF.getInstance();
	
	public void serializeSelfToXML(HashMap dataInHash){
		XStream xStream = new XStream();
		xStream.alias("DoylumBazsizCihazCLFs",HashMap.class);	//HashMap neye yerleþek
		xStream.alias("gecenZaman",ArrayList.class);
		
		String xml = xStream.toXML(dataInHash);	//HashMap dosyasý 
		System.out.println(xml);					//buraya konulacak
		try {
			FileOutputStream fos = new FileOutputStream("output/doylumBazsizCihazCLFs.xml");
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
	
	public void loadDataFromXLS(DoylumBazsizCihazCLF instance,int sheetNo) {
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("input/ddveri.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(sheetNo-1);			
			ArrayList gecZaman;
			Integer hashKey;
			for(int rowCount = 2 ; rowCount < 11 ; rowCount++){//row kadar dön
				HSSFRow row = sheet.getRow(rowCount);
				gecZaman = new ArrayList();
				
				for(int cellCount = 1 ; cellCount < 25 ; cellCount++){//col kadar dön
					HSSFCell cell = row.getCell((short) cellCount);
					gecZaman.add(new Double(Double.parseDouble(cell.getStringCellValue())));
				}
				instance.getToplSaat().put((new Integer((int)row.getCell((short) 0).getNumericCellValue())),gecZaman);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadDataFromXLS() {
		try {
			int sheetNo=15;
			DoylumBazsizCihazCLF instance = doylumBazsizCihazCLF;
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("input/ddveri.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(sheetNo-1);			
			ArrayList gecZaman;
			Integer hashKey;
			for(int rowCount = 2 ; rowCount < 11 ; rowCount++){//row kadar dön
				HSSFRow row = sheet.getRow(rowCount);
				gecZaman = new ArrayList();
				
				for(int cellCount = 1 ; cellCount < 25 ; cellCount++){//col kadar dön
					HSSFCell cell = row.getCell((short) cellCount);
					gecZaman.add(new Double(Double.parseDouble(cell.getStringCellValue())));
				}
				instance.getToplSaat().put((new Integer((int)row.getCell((short) 0).getNumericCellValue())),gecZaman);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double getDatum(int calistirildigiToplamSaat,int gecenZaman){
		ArrayList gecenZamanList=(ArrayList)(doylumBazsizCihazCLF.getToplSaat().get(new Integer(calistirildigiToplamSaat)));
		return ((Double)(gecenZamanList.get(gecenZaman-1))).doubleValue();
		
	}
	
	
	
	public static void main(String[] args) {
		DoylumBazsizCihazCLFs test = new DoylumBazsizCihazCLFs();
		test.loadDataFromXLS(doylumBazsizCihazCLF,15);
		test.serializeSelfToXML(doylumBazsizCihazCLF.getToplSaat());
		double tryDouble = test.getDatum(2,1);
	}
	
}
