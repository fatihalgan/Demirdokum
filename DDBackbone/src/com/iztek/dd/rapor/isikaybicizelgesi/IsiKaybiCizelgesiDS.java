package com.iztek.dd.rapor.isikaybicizelgesi;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import com.iztek.dd.ProjectController;
import com.iztek.dd.IsiKaybi.domain.BasitYapiElemani;
import com.iztek.dd.IsiKaybi.domain.Bina;
import com.iztek.dd.IsiKaybi.domain.Kat;
import com.iztek.dd.IsiKaybi.domain.Mahal;
import com.iztek.dd.IsiKaybi.domain.TemelYapiElemani;

public class IsiKaybiCizelgesiDS implements JRDataSource {
	private int index = -1;
	private List data = new ArrayList();
	DecimalFormat twoDigits = null;
	IsiKaybiCizelgesiBean emptyBean = new IsiKaybiCizelgesiBean("","","","","","","","","","","","","","","","","");

	public IsiKaybiCizelgesiDS(ProjectController controller) {	
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		twoDigits = new DecimalFormat("##.##",symbols);
		Bina bina = controller.isiKaybiController.bina;
		bina.hesaplaToplamIsiIhtiyaci();
		Iterator katIterator = bina.getKatlar().iterator();
		while(katIterator.hasNext()){
			Kat kat = (Kat)katIterator.next();
			Iterator mahalIterator = kat.getMahaller().iterator();
				while(mahalIterator.hasNext()){
					Mahal mahal = (Mahal)mahalIterator.next();
					Iterator tyeIterator = mahal.getYapiElemanlari().iterator();
					IsiKaybiCizelgesiBean mahalBilgiBean = new IsiKaybiCizelgesiBean("","","","",""+mahal.getMahalId(),mahal.getMahalAdi(),"("+mahal.getIcSicaklik()+" C)","","","","","","","","","","");
					data.add(mahalBilgiBean);
					while(tyeIterator.hasNext()){
						TemelYapiElemani eleman = (TemelYapiElemani) tyeIterator.next();
						Iterator byeIterator = eleman.getYapiElemanlari().iterator();
						while(byeIterator.hasNext()){
							BasitYapiElemani bye = (BasitYapiElemani) byeIterator.next();
							IsiKaybiCizelgesiBean byeBean = new IsiKaybiCizelgesiBean(bye.getYapiElemaniAdi(),eleman.getYon(),""+twoDigits.format(bye.getKalinlik()),""+twoDigits.format(bye.getUzunluk()),""+twoDigits.format(bye.getYukseklik()),""+twoDigits.format(bye.getAlan()),"1","0",""+twoDigits.format(bye.getAlan()),""+twoDigits.format(bye.getIsiGecirgenlikKatsayisi()),""+twoDigits.format(bye.getIsiFarki()),""+twoDigits.format(bye.getIsiKaybi()),"","","","","");
							data.add(byeBean);
						}
						IsiKaybiCizelgesiBean elemanBean = new IsiKaybiCizelgesiBean(eleman.getYapiElemaniAdi(),eleman.getYon(),""+twoDigits.format(eleman.getKalinlik()),""+twoDigits.format(eleman.getUzunluk()),""+twoDigits.format(eleman.getYukseklik()),""+twoDigits.format(eleman.getAlan()),""+1,""+twoDigits.format(eleman.getCikarilanAlan()),""+twoDigits.format(eleman.getNetAlan()),""+twoDigits.format(eleman.getIsiGecirgenlikKatsayisi()),""+twoDigits.format(eleman.getIsiFarki()),""+twoDigits.format(eleman.getIsiKaybi()),"","","","","");
						data.add(elemanBean);
					}
//					data.add(emptyBean);
					IsiKaybiCizelgesiBean mahalBean = new IsiKaybiCizelgesiBean("","","","","","","","","","","",twoDigits.format(mahal.getArtirimsizIsiKaybi()),twoDigits.format(mahal.getIsletmeZammi()),twoDigits.format(mahal.getKatYuksekligiZammi()),twoDigits.format(mahal.getYoneGoreZam()),twoDigits.format(mahal.getToplamZamOrani()),""+Math.ceil(mahal.getArtirimliIsiKaybi()));					
					IsiKaybiCizelgesiBean sizintiBean = new IsiKaybiCizelgesiBean("","","","Qs=","1/3.6x("+bina.getSizdirganlikKatsayisi(),"x"+"9.9","x"+bina.getOdaDurumKatsayisi(),"x"+bina.getBinaDurumKatsayisi(),"x"+(mahal.getIcSicaklik()-bina.getProje().getIl().getIsiKaybiDisSicaklik()),"x1.00)","","","","","","",""+Math.ceil(mahal.getSizintiIsiKaybi()));					
					IsiKaybiCizelgesiBean finalBean = new IsiKaybiCizelgesiBean("","","","","","","","","","","","","","","","",""+Math.ceil(mahal.getToplamIsiKaybi()));
					data.add(mahalBean);
					data.add(sizintiBean);
					data.add(finalBean);
					data.add(emptyBean);
				}
		}		
	}

	public boolean next() throws JRException {
		index++;
		return (index < data.size());
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;
		IsiKaybiCizelgesiBean bean = (IsiKaybiCizelgesiBean)data.get(index);
		String fieldName = field.getName();

		if ("Isaret".equals(fieldName)) {
			value = bean.getIsaret();
		}else if ("Yon".equals(fieldName)) {
			value = bean.getYon();
		}else if ("Kalinlik".equals(fieldName)) {
			value = bean.getKalinlik();
		}else if ("Uzunluk".equals(fieldName)) {
			value = bean.getUzunluk();
		}else if ("YukseklikVeyaGenislik".equals(fieldName)) {
			value = bean.getYukseklikVeyagenislik();
		}else if ("ToplamAlan".equals(fieldName)) {
			value = bean.getToplamAlan();
		}else if ("Miktar".equals(fieldName)) {
			value = bean.getMiktar();
		}else if ("CikarilanAlan".equals(fieldName)) {
			value = bean.getCikarilanAlan();
		}else if ("HesabaGirenAlan".equals(fieldName)) {
			value = bean.getHesabaGirenAlan();
		}else if ("ToplamIGK".equals(fieldName)) {
			value = bean.getToplamIGK();
		}else if ("SicaklikFarki".equals(fieldName)) {
			value = bean.getSicaklikFarki();
		}else if ("ArttirimsizIsiKaybi".equals(fieldName)) {
			value = bean.getArttirimsizIsiKaybi();
		}else if ("Birlesik".equals(fieldName)) {
			value = bean.getBirlesik();
		}else if ("KatYuksekligi".equals(fieldName)) {
			value = bean.getKatYuksekligi();
		}else if ("ZamlarYon".equals(fieldName)) {
			value = bean.getZamlarYon();
		}else if ("ZamlarToplam".equals(fieldName)) {
			value = bean.getZamlarToplam();
		}else if ("ToplamIsiIhtiyaci".equals(fieldName)) {
			value = bean.getToplamIsiIhtiyaci();
		}
		
		return value;
	}
}