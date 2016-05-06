package com.iztek.dd.rapor.borucapicizelgesi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import com.iztek.dd.ProjectController;
import com.iztek.dd.IsiKaybi.domain.BoruParcasi;
import com.iztek.dd.IsiKaybi.domain.KritikHat;

public class BoruCapiCizelgesiDS implements JRDataSource {
	private int index = -1;
	private List data = new ArrayList();

	public BoruCapiCizelgesiDS(ProjectController controller) {		
	    int index=0;
	    double toplamLR = 0;
	    double toplamZ = 0;
	    KritikHat kritikHat = controller.isiKaybiController.bina.getKritikHat();
	    ArrayList boruParcalari = (ArrayList)kritikHat.getBoruParcalari();
	    Iterator it = boruParcalari.iterator();
	    int parcaAdedi = 0;
	    while(it.hasNext()){
	        BoruParcasi parca = (BoruParcasi)it.next();
	        index++;
	        BoruCapiCizelgesiBean bean = new BoruCapiCizelgesiBean(""+index,""+parca.getIsiYuku(),""+parca.getUzunluk(),""+parca.getCap(),""+parca.getSuHizi(),""+parca.getMetreBasiBasincKaybi()*parca.getUzunluk(),""+parca.getSurtunmeKaybi(),""+parca.getOzelDirenc(),""+parca.getZetaDirenci(),"");
	        toplamLR += parca.getMetreBasiBasincKaybi()*parca.getUzunluk();
	        toplamZ += parca.getZetaDirenci();
	        data.add(bean);
	    }
	    BoruCapiCizelgesiBean bean = new BoruCapiCizelgesiBean("","","","","","","","","","LR + Z = "+toplamLR+" + "+toplamZ+" = "+(toplamLR+toplamZ)+" + "+controller.isiKaybiController.bina.getIsitici().getPompaEmniyetDegeri()+" = "+(toplamLR+toplamZ+controller.isiKaybiController.bina.getIsitici().getPompaEmniyetDegeri()));
	    data.add(bean);
	}

	public boolean next() throws JRException {
		index++;
		return (index < data.size());
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;
		BoruCapiCizelgesiBean bean = (BoruCapiCizelgesiBean)data.get(index);
		String fieldName = field.getName();

		if ("BoruNo".equals(fieldName)) {
			value = bean.getBoruNo();
		}else if ("IsiMiktari".equals(fieldName)) {
			value = bean.getIsiMiktari();
		}else if ("Uzunluk".equals(fieldName)) {
			value = bean.getUzunluk();
		}else if ("Cap".equals(fieldName)) {
			value = bean.getCap();
		}else if ("SuHizi".equals(fieldName)) {
			value = bean.getSuHizi();
		}else if ("BasincKaybi".equals(fieldName)) {
			value = bean.getBasincKaybi();
		}else if ("SurtunmeKaybi".equals(fieldName)) {
			value = bean.getSurtunmeKaybi();
		}else if ("OzelDirenc".equals(fieldName)) {
			value = bean.getOzelDirenc();
		}else if ("OzelKayip".equals(fieldName)) {
			value = bean.getOzelKayip();
		}else if ("ToplamBasinc".equals(fieldName)) {
			value = bean.getToplamBasinc();
		}		
		return value;
	}
}