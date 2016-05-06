/*
 * Created on 03.Þub.2005
 *
 */
package com.iztek.dd.aktarim;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.iztek.dd.aktarim.model.duvarCLTD.DuvarCLTD;
import com.iztek.dd.aktarim.model.duvarCLTD.DuvarCLTDs;

/**
 * @author Selim HENDRICKSON
 *
 */
public class DuvarDriver {

	public static void main(String[] args) {
		DuvarCLTDs instance = DuvarCLTDs.getInstance();
		loadDataFromXLS(instance);
		instance.serializeSelfToXML();
	}

	private static void loadDataFromXLS(DuvarCLTDs instance) {
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("input/ddveri.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(2);
			String yon = "";
			for(int rowCount = 2 ; rowCount<10 ; rowCount++){
				HSSFRow row = sheet.getRow(rowCount);
				DuvarCLTD cltd = new DuvarCLTD();
				for(int cellCount = 0; cellCount < 25 ; cellCount++){
					HSSFCell cell = row.getCell((short)cellCount);
					if(cellCount==0) yon = cell.getStringCellValue();
					else cltd.addGunesZamani(cell.getNumericCellValue());
				}
				instance.addCLTD(yon,cltd);
			}
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
}
