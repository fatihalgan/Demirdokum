package com.iztek.dd.rapor.zetacizelgesi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import com.iztek.dd.ProjectController;
import com.iztek.dd.IsiKaybi.domain.BoruParcasi;
import com.iztek.dd.IsiKaybi.domain.KritikHat;

public class ZetaCizelgesiDS implements JRDataSource {
	private int index = -1;
	private List data = new ArrayList();

	public ZetaCizelgesiDS(ProjectController controller) {		
	    KritikHat kritikHat = controller.isiKaybiController.bina.getKritikHat();
	    ArrayList boruParcalari = (ArrayList)kritikHat.getBoruParcalari();
	    Iterator it = boruParcalari.iterator();
	    int parcaAdedi = 0;
	    int bilesenAdedi = 0;
	    while(it.hasNext()){
	        parcaAdedi++;
	        BoruParcasi parca = (BoruParcasi)it.next();
	        int radyatorVentiliKose = parca.getSurtunmeDirenciYaratanAdet("Radyatör Ventili(Köþe)");
	        int pantalonParcasi = parca.getSurtunmeDirenciYaratanAdet("Pantolon Parçasý");
	        int tGirisAyrilma = parca.getSurtunmeDirenciYaratanAdet("T Giriþ(Ayrýlma)");
	        int isiticiVeyaRadyator = parca.getSurtunmeDirenciYaratanAdet("Isitici veya Radyatör");
	        int kollektor = parca.getSurtunmeDirenciYaratanAdet("Kollektör Giriþ Veya Çýkýþý");
	        int tGecis = parca.getSurtunmeDirenciYaratanAdet("T Geçiþ(Ayrýlma)");
	        int ciftDirsek = parca.getSurtunmeDirenciYaratanAdet("Çift Dirsek(Dar)");
	        int deveBoynu = parca.getSurtunmeDirenciYaratanAdet("Deve Boynu 90 Derece");
	        int kolonVanasiDuz = parca.getSurtunmeDirenciYaratanAdet("Kolon Vanasý");
	        int sParcasi = parca.getSurtunmeDirenciYaratanAdet("S Parçasý");
	        int ciftDirsekGenis = parca.getSurtunmeDirenciYaratanAdet("Çift Dirsek(Geniþ)");
	        int tAyrilma = parca.getSurtunmeDirenciYaratanAdet("T Ayrýlma");
	        int dirsek = parca.getSurtunmeDirenciYaratanAdet("Dirsek");
	        int radyatorVentili = parca.getSurtunmeDirenciYaratanAdet("Radyatör Ventili(Düz)");
	        int siberVana = parca.getSurtunmeDirenciYaratanAdet("Þiber Vana");
	        int kolonVanasi = parca.getSurtunmeDirenciYaratanAdet("Kolon Vanasý(Eðik)");
	        int tBirlesme = parca.getSurtunmeDirenciYaratanAdet("T Birleþme");
	        int tKarsitAkim = parca.getSurtunmeDirenciYaratanAdet("T Karþýt Akým");
	        bilesenAdedi = radyatorVentiliKose + pantalonParcasi + tGirisAyrilma + isiticiVeyaRadyator + kollektor + tGecis + ciftDirsek;
	        bilesenAdedi += deveBoynu + kolonVanasiDuz + sParcasi + ciftDirsekGenis + tAyrilma + dirsek + radyatorVentili + siberVana;
	        bilesenAdedi += kolonVanasi + tBirlesme + tKarsitAkim;
	        String boruCapiInch = "";
	        double cap = parca.getCap();
	        if(cap==0.375) boruCapiInch = "3/8\"";
	        if(cap==0.5) boruCapiInch = "1/2\"";
	        if(cap==0.75) boruCapiInch = "3/4\"";
	        if(cap==1.0) boruCapiInch = "1/2\"";
	        if(cap==1.25) boruCapiInch = "1 1/4\"";
	        if(cap==1.5) boruCapiInch = "1 1/2\"";
	        if(cap==2.0) boruCapiInch = "2\"";	        
	        ZetaCizelgesiBean bean = new ZetaCizelgesiBean(""+parcaAdedi,boruCapiInch,""+isiticiVeyaRadyator,""+kollektor,""+pantalonParcasi,""+sParcasi,""+ciftDirsekGenis,""+ciftDirsek,""+tBirlesme,""+tAyrilma,""+tKarsitAkim,""+tGirisAyrilma,""+tGecis,""+deveBoynu,""+dirsek,""+siberVana,""+kolonVanasiDuz,""+kolonVanasi,""+radyatorVentili,""+radyatorVentiliKose,""+bilesenAdedi);
	        data.add(bean);
	        bilesenAdedi = 0;
	    }
	}

	public boolean next() throws JRException {
		index++;
		return (index < data.size());
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;
		ZetaCizelgesiBean bean = (ZetaCizelgesiBean)data.get(index);
		String fieldName = field.getName();

		if("No".equals(fieldName)) {
			value = bean.getNo();
		}else if ("BoruCapi".equals(fieldName)) {
			value = bean.getBoruCapi();
		}else if ("KazanVeyaRadyator".equals(fieldName)) {
			value = bean.getKazanVeyaRadyator();
		}else if ("KollektorGirisCikis".equals(fieldName)) {
			value = bean.getKollektorGirisCikis();
		}else if ("PantolonParcasi".equals(fieldName)) {
			value = bean.getPantolonParcasi();
		}else if ("SParcasi".equals(fieldName)) {
			value = bean.getSParcasi();
		}else if ("CiftDirsekGenis".equals(fieldName)) {
			value = bean.getCiftDirsekGenis();
		}else if ("CiftDirsekDar".equals(fieldName)) {
			value = bean.getCiftDirsekDar();
		}else if ("TBirlesme".equals(fieldName)) {
			value = bean.getTBirlesme();
		}else if ("TAyrilma".equals(fieldName)) {
			value = bean.getTAyrilma();
		}else if ("TKarsitAkim".equals(fieldName)) {
			value = bean.getTKarsitAkim();
		}else if ("TGirisAyrilma".equals(fieldName)) {
			value = bean.getTGirisAyrilma();
		}else if ("TGecisAyrilma".equals(fieldName)) {
			value = bean.getTGecisAyrilma();
		}else if ("DeveBoynu".equals(fieldName)) {
			value = bean.getDeveBoynu();
		}else if ("Dirsek".equals(fieldName)) {
			value = bean.getDirsek();
		}else if ("SiberVana".equals(fieldName)) {
			value = bean.getSiberVana();
		}else if ("KolonVanasiDuz".equals(fieldName)) {
			value = bean.getKolonVanasiDuz();
		}else if ("KolonVanasiEgik".equals(fieldName)) {
			value = bean.getKolonVanasiEgik();
		}else if ("RadyatorVentiliDuz".equals(fieldName)) {
			value = bean.getRadyatorVentiliDuz();
		}else if ("radyatorVentiliKose".equals(fieldName)) {
			value = bean.getRadyatorVentiliKose();
		}else if ("Toplam".equals(fieldName)) {
			value = bean.getToplam();
		}	
		return value;
	}
}