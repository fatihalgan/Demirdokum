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

import com.iztek.dd.aktarim.model.catiCLTD.CatiCLTD;
import com.iztek.dd.aktarim.model.catiCLTD.CatiCLTDs;

/**
 * @author Selim HENDRICKSON
 *
 */
public class CatiDriver {

	public static void main(String[] args) {
		CatiCLTDs instance = CatiCLTDs.getInstance();
		loadDataFromXLS(instance);
		instance.serializeSelfToXml();
	}

	private static void loadDataFromXLS(CatiCLTDs instance) {
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("input/ddveri.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			for(int rowCount = 2 ; rowCount<12 ; rowCount++){
				HSSFRow row = sheet.getRow(rowCount);
				CatiCLTD cltd = new CatiCLTD();
				for(int cellCount = 1; cellCount < 28 ; cellCount++){					
					HSSFCell cell = row.getCell((short)cellCount);
					switch (cellCount) {
					case 1:
						cltd.setCatiTipi(cell.getStringCellValue());
						break;
					case 2:
						cltd.setAgirlik(cell.getNumericCellValue());
						break;
					case 3:
						cltd.setIsiGecirgenlikKatsayisi(cell.getNumericCellValue());
						break;
					default:
						cltd.addGunesZamani(cell.getNumericCellValue());
						break;
					}
				}
				instance.addCLTD(""+(rowCount-1),cltd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
