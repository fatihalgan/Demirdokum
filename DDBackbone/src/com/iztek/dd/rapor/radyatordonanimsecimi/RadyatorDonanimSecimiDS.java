package com.iztek.dd.rapor.radyatordonanimsecimi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import com.iztek.dd.ProjectController;
import com.iztek.dd.IsiKaybi.domain.Bina;
import com.iztek.dd.IsiKaybi.domain.Kat;
import com.iztek.dd.IsiKaybi.domain.Mahal;
import com.iztek.dd.IsiKaybi.domain.Radyator;

public class RadyatorDonanimSecimiDS implements JRDataSource {
	private int index = -1;
	private List data = new ArrayList();

	public RadyatorDonanimSecimiDS(ProjectController controller) {
		Bina bina = controller.isiKaybiController.bina;
		bina.hesaplaToplamIsiIhtiyaci();
		Radyator radyator = bina.getProje().getEnCokKullanilanRadyatorModeli();
		if(radyator==null) throw new RuntimeException("Radyatör seçimi yapýlmamýþ!");
		Iterator it = bina.getKatlar().iterator();
		while(it.hasNext()){
			Kat kat = (Kat)it.next();
			RadyatorDonanimSecimiBean bean = null;
			bean = new RadyatorDonanimSecimiBean("","","","","","",kat.toString(),"","","","","","","","","","");;
			data.add(bean);
			List mahaller = kat.getMahaller(); 
			Iterator it2 = mahaller.iterator();
			while(it2.hasNext()){
				Mahal mahal = (Mahal) it2.next();
				double dilim = mahal.getToplamIsiKaybi() / radyator.getGuc();
				RadyatorDonanimSecimiBean mahalBean = new RadyatorDonanimSecimiBean(mahal.getMahalkodu(),mahal.getMahalAdi(),""+mahal.getIcSicaklik(),""+mahal.getToplamIsiKaybi(),""+radyator.getGuc(),""+(radyator.getGuc()*dilim),radyator.getModel(),""+dilim,"1","1","1","1","","","1","","");
				data.add(mahalBean);
			}
			bean = new RadyatorDonanimSecimiBean("","","","","","","","","","","","","","","","","");;
			data.add(bean);
		}
	}

	public boolean next() throws JRException {
		index++;
		return (index < data.size());
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;
		RadyatorDonanimSecimiBean bean = (RadyatorDonanimSecimiBean)data.get(index);
		String fieldName = field.getName();

		if ("OdaNo".equals(fieldName)) {
			value = bean.getOdaNo();
		}else if ("OdaAdi".equals(fieldName)) {
			value = bean.getOdaAdi();
		}else if ("OdaSicakligi".equals(fieldName)) {
			value = bean.getOdaSicakligi();
		}else if ("OdaIsiKaybi".equals(fieldName)) {
			value = bean.getOdaIsiKaybi();
		}else if ("RadyatorBirimVerim".equals(fieldName)) {
			value = bean.getRadyatorBirimVerim();
		}else if ("RadyatorVerimi".equals(fieldName)) {
			value = bean.getRadyatorVerimi();
		}else if ("RadyatorCinsi".equals(fieldName)) {
			value = bean.getRadyatorCinsi();
		}else if ("RadyatorMDilim".equals(fieldName)) {
			value = bean.getRadyatorMDilim();
		}else if ("DonanimGrup".equals(fieldName)) {
			value = bean.getDonanimGrup();
		}else if ("DonanimKonsol".equals(fieldName)) {
			value = bean.getDonanimKonsol();
		}else if ("DonanimKelepce".equals(fieldName)) {
			value = bean.getDonanimKelepce();
		}else if ("MuslukCapBirBoluIki".equals(fieldName)) {
			value = bean.getMuslukCapBirBoluIki();
		}else if ("MuslukCapUcBoluDort".equals(fieldName)) {
			value = bean.getMuslukCapUcBoluDort();
		}else if ("MuslukCapBir".equals(fieldName)) {
			value = bean.getMuslukCapBir();
		}else if ("RekorCapBirBoluIki".equals(fieldName)) {
			value = bean.getRekorCapBirBoluIki();
		}else if ("RekorCapUcBoluDort".equals(fieldName)) {
			value = bean.getRekorCapUcBoluDort();
		}else if ("RekorCapBir".equals(fieldName)) {
			value = bean.getRekorCapBir();
		}		
		return value;
	}
}