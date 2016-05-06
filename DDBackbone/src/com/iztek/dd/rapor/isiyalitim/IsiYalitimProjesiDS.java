package com.iztek.dd.rapor.isiyalitim;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import com.iztek.dd.ProjectController;
import com.iztek.dd.IsiKaybi.domain.Bina;
import com.iztek.dd.IsiKaybi.domain.DuvarYapiElemani;
import com.iztek.dd.IsiKaybi.domain.KapiYapiElemani;
import com.iztek.dd.IsiKaybi.domain.PencereYapiElemani;

public class IsiYalitimProjesiDS implements JRDataSource {
	private int index = -1;
	private List data = new ArrayList();
	Bina bina = null;
	DecimalFormat twoDigits = new DecimalFormat("0.00");

	public IsiYalitimProjesiDS(ProjectController controller) {
	    bina = controller.isiKaybiController.bina;
	    double toplamAlan = 0;
	    double toplamUA = 0;
	    
        DuvarYapiElemani standartDuvar = (DuvarYapiElemani)bina.getProje().getCogunluklaKullanilanDisDuvar();
        String standartLambda = "";
        if(standartDuvar!=null){
            String yapiElemaniKOdu = "Dýþ duvarlar";
            if(bina.getProje().getBolge()!=null){
                standartLambda = twoDigits.format(bina.getProje().getBolge().getStandartLambda());   
            }            
            String lambda = twoDigits.format(standartDuvar.getLambda());
            double u = standartDuvar.getIsiGecirgenlikKatsayisi();            
            double duvarAlani = bina.hesaplaToplamDuvarAlaniForCommonDuvar(bina.getProje().getCogunluklaKullanilanDisDuvar().getYapiElemaniKodu());
            toplamAlan += duvarAlani;
            toplamUA += duvarAlani*u;
            IsiYalitimProjesiBean bean = new IsiYalitimProjesiBean(yapiElemaniKOdu,standartLambda,lambda,""+u,twoDigits.format(duvarAlani),twoDigits.format(duvarAlani*u));
            data.add(bean);
        }
        
        PencereYapiElemani standartPencere = (PencereYapiElemani)bina.getProje().getCogunluklaKullanilanPencere();

        if(standartPencere!=null){    
            String yapiElemaniKodu = "Pencereler";
            double u = standartPencere.getIsiGecirgenlikKatsayisi();
            double pencereAlani = bina.hesaplaToplamBasitAlaniForCommonBasit(bina.getProje().getCogunluklaKullanilanPencere().getYapiElemaniKodu());
            toplamAlan += pencereAlani;
            toplamUA += pencereAlani*u;
            IsiYalitimProjesiBean bean = new IsiYalitimProjesiBean(yapiElemaniKodu,"","",twoDigits.format(u),twoDigits.format(pencereAlani),twoDigits.format(u*pencereAlani));
            data.add(bean);
        }
        
        KapiYapiElemani standartKapi = (KapiYapiElemani)bina.getProje().getCogunluklaKullanilanDisKapi();

        if(standartKapi!=null){
            String yapiElemaniKodu = "Dýþ kapýlar";
            double u = standartKapi.getIsiGecirgenlikKatsayisi();
            double kapiAlani = bina.hesaplaToplamBasitAlaniForCommonBasit(bina.getProje().getCogunluklaKullanilanDisKapi().getYapiElemaniKodu());
            toplamAlan += kapiAlani;
            toplamUA += kapiAlani*u;
            IsiYalitimProjesiBean bean = new IsiYalitimProjesiBean(yapiElemaniKodu,"","",twoDigits.format(u),twoDigits.format(kapiAlani),twoDigits.format(u*kapiAlani));
            data.add(bean);
        }      
        IsiYalitimProjesiBean emptyBean = new IsiYalitimProjesiBean("","","","","","");
        data.add(emptyBean);
        IsiYalitimProjesiBean bean = new IsiYalitimProjesiBean("Toplam","","","",twoDigits.format(toplamAlan),twoDigits.format(toplamUA));
        data.add(bean);
        
        double ratio = toplamUA/toplamAlan;
        if(ratio<=1.5){
            IsiYalitimProjesiBean ratioBean = new IsiYalitimProjesiBean("UHesap <= UYonetmelik "+ratio+"<1.5 uygundur","","","","","");
        }
        if(ratio>1.5){
            IsiYalitimProjesiBean ratioBean = new IsiYalitimProjesiBean("UHesap <= UYonetmelik "+ratio+"<1.5 uygun deðildir","","","","","");
        }
	}

	public boolean next() throws JRException {
		index++;
		return (index < data.size());
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;
		IsiYalitimProjesiBean bean = (IsiYalitimProjesiBean)data.get(index);
		String fieldName = field.getName();

		if ("YapiBileseni".equals(fieldName)) {
			value = bean.getYapiBileseni();
		}else if ("YonetmelikIGD".equals(fieldName)) {
			value = bean.getYonetmelikIGD();
		}else if ("IGD".equals(fieldName)) {
			value = bean.getIGD();
		}else if ("IGK".equals(fieldName)) {
			value = bean.getIGK();
		}else if ("Alan".equals(fieldName)) {
			value = bean.getAlan();
		}else if ("OzgulIsiKaybi".equals(fieldName)) {
			value = bean.getOzgulIsiKaybi();
		}
		return value;
	}
}