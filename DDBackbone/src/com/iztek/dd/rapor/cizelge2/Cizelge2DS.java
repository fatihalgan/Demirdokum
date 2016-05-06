package com.iztek.dd.rapor.cizelge2;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iztek.dd.ProjectController;
import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.BilesikYapiElemani;
import com.iztek.dd.domain.IsiKaybeden;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class Cizelge2DS implements JRDataSource {
	private int innerIndex = -1;
	private int outerIndex = 0;
	private List outerData = new ArrayList();
	private List innerData = new ArrayList();
	private double toplamDBoluLambda = 0.0;
	private double iletimselOzgulIsiKaybi = 0.0;
	private double havalandirmaOzgulIsiKaybi = 0.0;	
	
	int tempIndex = 0;
	DecimalFormat format = null;
	
	public Cizelge2DS(ProjectController controller) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		format = new DecimalFormat("##.##",symbols);
		Iterator it = ((ArrayList)controller.ts825controller.bina.getYapiElemanlari()).iterator();
		iletimselOzgulIsiKaybi = controller.ts825controller.bina.hesaplaOzgulIletimselIsiKaybi();
		havalandirmaOzgulIsiKaybi = controller.ts825controller.bina.hesaplaHavalandirmaOzgulIsiKaybi();
		
		while(it.hasNext()){
			IsiKaybeden domainObject = (IsiKaybeden) it.next();
			List innerList = new ArrayList(); 
			if(domainObject instanceof BilesikYapiElemani){			    
				Iterator it2 = ((BilesikYapiElemani)domainObject).getBilesenler().iterator();
				BilesenBean bilesenBeanI = new BilesenBean("1/\u03B1 i",0,0,((BilesikYapiElemani)domainObject).getIsiGecirgenligi().getIC_YUZEYSEL_ISIL_ILETIM_DIRENCI());
				innerList.add(bilesenBeanI);
				while(it2.hasNext()){
					Bilesen bilesen = (Bilesen)it2.next();
					BilesenBean bilesenBean = new BilesenBean(bilesen.getMalzemeCinsi(),bilesen.getKalinlik(),bilesen.getIsiIletimKatsayisi(),bilesen.hesaplaIsiGecirgenlikDirenci());
					innerList.add(bilesenBean);
				}
				BilesenBean bilesenBeanD = new BilesenBean("1/\u03B1 d",0,0,((BilesikYapiElemani)domainObject).getIsiGecirgenligi().getDIS_YUZEYSEL_ISIL_ILETIM_DIRENCI());
				innerList.add(bilesenBeanD);
			}else{
			    BilesenBean pencereBean = new BilesenBean("", 0, 0, 0);
			    innerList.add(pencereBean);
			}
			YapiElemaniBean yapiElemani = new YapiElemaniBean(domainObject.toString(),innerList,domainObject.getIsiGecirgenlikKatsayisi(),domainObject.getAlan(),(domainObject.getAlan()*domainObject.getIsiGecirgenlikKatsayisi()));
			outerData.add(yapiElemani);
		}
		
	}

	public boolean next() throws JRException {
	    innerIndex++;
	    if(innerIndex !=0 && innerIndex == innerData.size()) {
		    innerIndex = 0;
		    outerIndex++;
		    toplamDBoluLambda = 0.0;
		}
		return (outerIndex < outerData.size());
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;
		YapiElemaniBean yapiElemani = (YapiElemaniBean)outerData.get(outerIndex);
		innerData = yapiElemani.getBilesenler();
		
		BilesenBean bilesenBean = (BilesenBean)innerData.get(innerIndex);
		String fieldName = field.getName();

		if("YapiElemani".equals(fieldName)) {
			value = yapiElemani.getYapiElemaniAdi()+outerIndex;
		}else if ("YapiElemaniAdi".equals(fieldName) && tempIndex == outerIndex) {
			value = yapiElemani.getYapiElemaniAdi();
			tempIndex++;
		}else if ("BilesenAdi".equals(fieldName)) {
			value = bilesenBean.getBilesenAdi();
		}else if ("Kalinlik".equals(fieldName)) {
			value = bilesenBean.getKalinlik()+"";
		}else if ("Iletkenlik".equals(fieldName)) {
			value = bilesenBean.getIletkenlik()+"";
		}else if ("dBoluLambda".equals(fieldName)) {
			value = format.format(bilesenBean.getDBoluLambda())+"";
			toplamDBoluLambda += bilesenBean.getDBoluLambda();
		}else if("IsiIletkenlikKatsayisi".equals(fieldName)) {
			value = "";
		}else if("IsiKaybedenYuzey".equals(fieldName)) {
			value = "";
		}else if("IsiKaybi".equals(fieldName)) {
			value = "";
		}else if("ToplamIsiIletkenlikKatsayisi".equals(fieldName)) {
		    value = format.format(yapiElemani.getIsiIletkenlikKatsayisi());
		}else if("ToplamIsiKaybedenYuzey".equals(fieldName)) {
		    value = format.format(yapiElemani.getIsiKaybedenYuzey());
		}else if("ToplamIsiKaybi".equals(fieldName)) {
		    value = format.format(yapiElemani.getIsiKaybi());
		}else if("ToplamDBoluLambda".equals(fieldName)) {
		    value = format.format(toplamDBoluLambda)+"";
		}else if("IletimselOzgulIsiKaybi".equals(fieldName)) {
		    value = format.format(iletimselOzgulIsiKaybi);
		}else if("HavalandirmaOzgulIsiKaybi".equals(fieldName)) {
		    value = format.format(havalandirmaOzgulIsiKaybi);
		}else if("ToplamOzgulIsiKaybi".equals(fieldName)) {
		    value = format.format(iletimselOzgulIsiKaybi+havalandirmaOzgulIsiKaybi);
		}
		return value;
	}
}