package com.iztek.dd.rapor;

import com.iztek.dd.ProjectController;
import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.rapor.borucapicizelgesi.BoruCapiCizelgesiReport;
import com.iztek.dd.rapor.cizelge2.Cizelge2Report;
import com.iztek.dd.rapor.iikb.IIKBReport;
import com.iztek.dd.rapor.isikaybicizelgesi.IsiKaybiCizelgesiReport;
import com.iztek.dd.rapor.isiyalitim.IsiYalitimProjesiReport;
import com.iztek.dd.rapor.radyatordonanimsecimi.RadyatorDonanimSecimiReport;
import com.iztek.dd.rapor.yiei.YIEIReport;
import com.iztek.dd.rapor.zetacizelgesi.ZetaCizelgesiReport;


public class ReportManager{	
	public static void getReport(ProjectController controller,String path, String reportType) {
		ReportInterface reportInt = null;		
	    if(reportType.equals("IKC")) {
	    	reportInt = new IsiKaybiCizelgesiReport(controller);
	    }else if(reportType.equals("IIKB")) {
	    	reportInt = new IIKBReport(controller);
	    }else if(reportType.equals("YIEI")) {
	    	reportInt = new YIEIReport(controller);
	    }else if(reportType.equals("C2")) {
	    	reportInt = new Cizelge2Report(controller);
	    }else if(reportType.equals("RS")) {
	    	reportInt = new RadyatorDonanimSecimiReport(controller);
	    }else if(reportType.equals("IY")) {
	    	reportInt = new IsiYalitimProjesiReport(controller);
	    }else if(reportType.equals("Zeta")) {
	    	reportInt = new ZetaCizelgesiReport(controller);
	    }else if(reportType.equals("BC")) {
	    	reportInt = new BoruCapiCizelgesiReport(controller);
	    }
	    try{
	    	reportInt.getReport(path);	
	    }
	    catch(Exception e){
	    	SwingUtils.errorMessage(e.getMessage());
	    }
	}	
}
