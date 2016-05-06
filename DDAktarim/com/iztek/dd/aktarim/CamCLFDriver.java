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

import com.iztek.dd.aktarim.model.CamCLF.CamCLF;
import com.iztek.dd.aktarim.model.CamCLF.CamCLFs;

/**
 * @author Selim HENDRICKSON
 *
 */
public class CamCLFDriver {

	public static void main(String[] args) {
		CamCLFs instance = CamCLFs.getInstance();
		loadDataFromXLS(instance);
		instance.serializeSelfToXML();
	}

	private static void loadDataFromXLS(CamCLFs instance) {
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("input/ddveri.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(7);
			String yon = "";
			for(int rowCount = 1 ; rowCount < 18 ; rowCount++){
				HSSFRow row = sheet.getRow(rowCount);
				CamCLF clf = new CamCLF();
				for(int cellCount = 0 ; cellCount < 24 ; cellCount++){
					HSSFCell cell = row.getCell((short) cellCount);
					if(cellCount == 0) yon = cell.getStringCellValue();
					else clf.addCLF(cell.getNumericCellValue());
				}
				instance.addYoneGoreCLF(yon,clf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
