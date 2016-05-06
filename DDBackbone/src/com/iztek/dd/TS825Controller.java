/*
 * Created on 23.Ara.2004
 *
 */
package com.iztek.dd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.iztek.dd.GUI.BilesenEkleDialog;
import com.iztek.dd.GUI.InfoDialog;
import com.iztek.dd.GUI.MekanikHavalandirmaDialog;
import com.iztek.dd.GUI.ProjectGUI;
import com.iztek.dd.GUI.YogusmaDialog;
import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.GUI.wrappers.BilesikYapiElemaniJTableWrapper;
import com.iztek.dd.IsiKaybi.domain.CatiliTavan;
import com.iztek.dd.IsiKaybi.domain.UzeriAcikTavan;
import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.BilesikYapiElemani;
import com.iztek.dd.domain.Bina;
import com.iztek.dd.domain.BinaDuvari;
import com.iztek.dd.domain.DisaAcikDuvar;
import com.iztek.dd.domain.IsiKaybeden;
import com.iztek.dd.domain.Pencere;
import com.iztek.dd.domain.Proje;
import com.iztek.dd.domain.Havalandirma.DogalHavalandirma;
import com.iztek.dd.domain.Havalandirma.MekanikHavalandirma;
import com.iztek.dd.domain.IsiGecirgenligi.AcikGecitUzeri;
import com.iztek.dd.domain.IsiGecirgenligi.Catili;
import com.iztek.dd.domain.IsiGecirgenligi.DIsitilmayan;
import com.iztek.dd.domain.IsiGecirgenligi.DTopragaTemasli;
import com.iztek.dd.domain.IsiGecirgenligi.TIsitilmayan;
import com.iztek.dd.domain.IsiGecirgenligi.TTopragaTemasli;
import com.iztek.dd.domain.IsiGecirgenligi.UzeriAcik;
import com.iztek.dd.utilities.Malzeme;
import com.iztek.dd.utilities.Malzemeler;

/**
 * @author Selim HENDRICKSON
 *
 */

public class TS825Controller {
	ProjectGUI gui = null;
	public Proje proje = null;
	public Bina bina = new Bina();
	MekanikHavalandirmaDialog mekanikHavalandirmaDialog = null;
	BilesenEkleDialog bilesenEkleDialog = null;
	private YogusmaDialog yogusmaDialog = null;
	private int disDuvarSayisi = 0;
	DecimalFormat twoDigits = null;
	boolean loaded = false;

	public TS825Controller(ProjectGUI gui, Proje proje) {
		this.gui = gui;
		this.proje = proje;
		bina.setProje(proje);
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		twoDigits = new DecimalFormat("##.##",symbols);

		setKonutRadioButtonActionCommand();
		setEnerjiRadioButtonActionCommand();
		addKonutRadioButtonActionListener();
		addEnerjiRadioButtonActionListener();
		setEsit26RadioButtonActionCommand();		
		addEsit26RadioButtonActionListener();
		setYuksek26RadioButtonActionCommand();	
		addYuksek26RadioButtonActionListener();
		setAyrikRadioButtonActionCommand();
		setMahfuzRadioButtonActionCommand();
		setBitisikRadioButtonActionCommand();
		addAyrikRadioButtonActionListener();
		addMahfuzRadioButtonActionListener();
		addBitisikRadioButtonActionListener();
		setMekanikRadioButtonActionCommand();
		addMekanikRadioButtonActionListener();
		setDogalRadioButtonActionCommand();
		addDogalRadioButtonActionListener();
		addHavalandirmaSecButtonActionListener();
		addDisDuvarEkleButtonActionListener();
		addDisDuvarBilesenEkleActionListener();
		addDisDuvarListListSelectionListener();
		addDisDuvarBilesenCikarButtonActionListener();
		addDisDuvarCikarButtonActionListener();
		addDisDuvarAlaniTextFieldKeyListener();
		addBrutHacimTextFieldKeyListener();
		
		addIsitilmayanDuvarBilesenEkleActionListener();
		addIsitilmayanDuvarBilesenCikarButtonActionListener();
		addIsitilmayanDuvarAlaniTextFieldKeyListener();
		
		addTopragaTemasliDuvarBilesenEkleActionListener();		
		addTopragaTemasliDuvarBilesenCikarButtonActionListener();
		addTopragaTemasliDuvarAlaniTextFieldKeyListener();
		
		addUzeriAcikTavanBilesenEkleActionListener();
		addUzeriAcikTavanBilesenCikarButtonActionListener();
		addUzeriAcikTavanAlaniTextFieldKeyListener();
		
		addCatiliTavanBilesenEkleActionListener();
		addCatiliTavanBilesenCikarButtonActionListener();
		addCatiliTavanAlaniTextFieldKeyListener();
		
		addTopragaTemasliTabanBilesenEkleActionListener();
		addTopragaTemasliTabanBilesenCikarButtonActionListener();
		addTopragaTemasliTabanAlaniTextFieldKeyListener();
		
		addIsitilmayanTabanBilesenEkleActionListener();
		addIsitilmayanTabanBilesenCikarButtonActionListener();
		addIsitilmayanTabanAlaniTextFieldKeyListener();
		
		addAcikGecitUzeriTabanBilesenEkleActionListener();
		addAcikGecitUzeriTabanBilesenCikarButtonActionListener();
		addAcikGecitUzeriTabanAlaniTextFieldKeyListener();
	
		addYoneGorePencereAlaniTextFieldKeyListener();
		
		addHavaDegisimKatsayisiTextFieldKeyListener();
		

		setDoguPencereRadioButtonActionCommand();
		setBatiPencereRadioButtonActionCommand();
		setGuneyPencereRadioButtonActionCommand();
		setKuzeyPencereRadioButtonActionCommand();
		
		addDoguPencereRadioButtonActionListener();
		addBatiPencereRadioButtonActionListener();
		addGuneyPencereRadioButtonActionListener();
		addKuzeyPencereRadioButtonActionListener();
		
		addPencereAlanTextFieldKeyListener();
		addPencereUTextFieldKeyListener();
		
		addGDikBatiBRadioButtonActionCommand();
		addGDikBatiBRadioButtonActionListener();
		addGDikBatiKRadioButtonActionCommand();
		addGDikBatiKRadioButtonActionListener();
		addGDikBatiORadioButtonActionCommand();
		addGDikBatiORadioButtonActionListener();
		
		addGDikDoguBRadioButtonActionCommand();
		addGDikDoguBRadioButtonActionListener();
		addGDikDoguKRadioButtonActionCommand();
		addGDikDoguKRadioButtonActionListener();
		addGDikDoguORadioButtonActionCommand();
		addGDikDoguORadioButtonActionListener();
		
		addGDikKuzeyBRadioButtonActionCommand();
		addGDikKuzeyBRadioButtonActionListener();
		addGDikKuzeyKRadioButtonActionCommand();
		addGDikKuzeyKRadioButtonActionListener();
		addGDikKuzeyORadioButtonActionCommand();
		addGDikKuzeyORadioButtonActionListener();
		
		addGDikGuneyBRadioButtonActionCommand();
		addGDikGuneyBRadioButtonActionListener();
		addGDikGuneyKRadioButtonActionCommand();
		addGDikGuneyKRadioButtonActionListener();
		addGDikGuneyORadioButtonActionCommand();
		addGDikGuneyORadioButtonActionListener();
		
		addIcOrtamSicakligiTextFieldKeyListener();
		addDisDuvarPanelYogusmaButtonListener();
		addUzeriAcikTavanYogusmaButtonActionListener();
		addCatiliTavanYogusmaButtonActionListener();
		
		//Save & Load		
		addBinaKonumBilgileriComponentShownListener();
		addOzgulIsiKaybiComponentShownListener();
		addYillikIsitmaIhtiyaciPanelComponentShownListener();

	}

    ActionListener ts825RadioButtonListener = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if(actionCommand=="Konut") bina.setEnerjiKullanimKatsayisi(5);
			if(actionCommand=="Enerji") bina.setEnerjiKullanimKatsayisi(10);
			if(actionCommand=="Esit26") bina.setOdaYuksekligi(2.6);
			if(actionCommand=="Yuksek26") bina.setOdaYuksekligi(3);
			if(actionCommand=="Ayrik"){
			    bina.setGolgelenmeFaktoru(0.8);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="Mahfuz"){
			    bina.setGolgelenmeFaktoru(0.6);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="Bitisik"){
			    bina.setGolgelenmeFaktoru(0.5);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="Mekanik"){
				addMekanikHavalandirmaToBina();
				setHavalandirmaSecButtonEnabled(true);
				gui.setHavaDegisimKatsayisiTextFieldEnabled(false);
			}
			if(actionCommand=="Dogal"){
				addDogalHavalandirmaToBina();
				updateInterface();
				setHavalandirmaSecButtonEnabled(false);
				gui.setHavaDegisimKatsayisiTextFieldEnabled(true);
			}
			    
			if(actionCommand=="Dogu") gui.setYoneGorePencereAlaniTextFieldText(""+bina.getYoneGoreGunesEnerjisiKazanci("DOGU").getPencereAlani());			 
			if(actionCommand=="Bati") gui.setYoneGorePencereAlaniTextFieldText(""+bina.getYoneGoreGunesEnerjisiKazanci("BATI").getPencereAlani());;
			if(actionCommand=="Guney")gui.setYoneGorePencereAlaniTextFieldText(""+bina.getYoneGoreGunesEnerjisiKazanci("GUNEY").getPencereAlani());;
			if(actionCommand=="Kuzey")gui.setYoneGorePencereAlaniTextFieldText(""+bina.getYoneGoreGunesEnerjisiKazanci("KUZEY").getPencereAlani());;

			if(actionCommand=="GDIKDOGUB"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("DOGU",0.85);
			    updateGunesEnerjisiKazanci();			 
			}
			if(actionCommand=="GDIKBATIB"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("BATI",0.85);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="GDIKKUZEYB"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("KUZEY",0.85);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="GDIKGUNEYB"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("GUNEY",0.85);
			    updateGunesEnerjisiKazanci();
			}

			if(actionCommand=="GDIKDOGUO"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("DOGU",0.75);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="GDIKBATIO"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("BATI",0.75);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="GDIKKUZEYO"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("KUZEY",0.75);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="GDIKGUNEYO"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("GUNEY",0.75);
			    updateGunesEnerjisiKazanci();
			}

			if(actionCommand=="GDIKDOGUK"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("DOGU",0.50);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="GDIKBATIK"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("BATI",0.50);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="GDIKKUZEYK"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("KUZEY",0.50);
			    updateGunesEnerjisiKazanci();
			}
			if(actionCommand=="GDIKGUNEYK"){
			    setYoneGoreGunesEnerjisiGecirmeFaktoru("GUNEY",0.50);
			    updateGunesEnerjisiKazanci();
			}

			actionCommand = null;
		}
	};
	
	public void setYoneGoreGunesEnerjisiGecirmeFaktoru(String yon,double faktor){
	    bina.getYoneGoreGunesEnerjisiKazanci(yon).setGunesEnerjisiGecirmeFaktoru(faktor);
	}
	
	ActionListener mekanikHavalandirmaRadioButtonListener = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if(actionCommand=="Buyuk") ((MekanikHavalandirma)bina.getHavalandirma()).setF(20); 
			if(actionCommand=="Esit") ((MekanikHavalandirma)bina.getHavalandirma()).setF(15);
			if(actionCommand=="Korumasiz"){
				if(mekanikHavalandirmaDialog.isEsit1RadioButtonSelected())
				((MekanikHavalandirma)bina.getHavalandirma()).setE(0.03);
				else ((MekanikHavalandirma)bina.getHavalandirma()).setE(0.10);
			}
			if(actionCommand=="Tam"){
				if(mekanikHavalandirmaDialog.isEsit1RadioButtonSelected())
					((MekanikHavalandirma)bina.getHavalandirma()).setE(0.01);
					else ((MekanikHavalandirma)bina.getHavalandirma()).setE(0.04);
			}
			if(actionCommand=="Yari"){
				if(mekanikHavalandirmaDialog.isEsit1RadioButtonSelected())
					((MekanikHavalandirma)bina.getHavalandirma()).setE(0.02);
					else ((MekanikHavalandirma)bina.getHavalandirma()).setE(0.07);
			}
			actionCommand = null;
		}
	};
	
    protected void addDogalHavalandirmaToBina() {
		bina.createDogalHavalandýrma();
	}

	protected void addMekanikHavalandirmaToBina() {
		bina.createMekanikHavalandýrma();
	}

	public ActionListener getTS825RadioButtonActionListener(){
		return ts825RadioButtonListener;
	}
	
	public ActionListener getMekanikHavalandirmaRadioButtonListener(){
		return mekanikHavalandirmaRadioButtonListener;
	}

	public void setKonutRadioButtonActionCommand(){
		gui.setKonutRadioButtonActionCommand("Konut");
	}
	
	public void addKonutRadioButtonActionListener(){
		gui.addKonutRadioButtonActionListener(getTS825RadioButtonActionListener());
	}
	
	public void setEnerjiRadioButtonActionCommand(){
		gui.setEnerjiRadioButtonActionCommand("Enerji");
	}
	
	public void addEnerjiRadioButtonActionListener(){
		gui.addEnerjiRadioButtonActionListener(getTS825RadioButtonActionListener());
	}	

	public void setEsit26RadioButtonActionCommand(){
		gui.setEsit26RadioButtonActionCommand("Esit26");
	}
	
	public void addEsit26RadioButtonActionListener(){
		gui.addEsit26RadioButtonActionListener(getTS825RadioButtonActionListener());
	}	

	public void setYuksek26RadioButtonActionCommand(){
		gui.setYuksek26RadioButtonActionCommand("Yuksek26");
	}
	
	public void addYuksek26RadioButtonActionListener(){
		gui.addYuksek26RadioButtonActionListener(getTS825RadioButtonActionListener());
	}	

	public void setAyrikRadioButtonActionCommand(){
		gui.setAyrikRadioButtonActionCommand("Ayrik");
	}
	
	public void addAyrikRadioButtonActionListener(){
		gui.addAyrikRadioButtonActionListener(getTS825RadioButtonActionListener());
	}	

	public void setMahfuzRadioButtonActionCommand(){
		gui.setMahfuzRadioButtonActionCommand("Mahfuz");
	}
	
	public void addMahfuzRadioButtonActionListener(){
		gui.addMahfuzRadioButtonActionListener(getTS825RadioButtonActionListener());
	}	

	public void setBitisikRadioButtonActionCommand(){
		gui.setBitisikRadioButtonActionCommand("Bitisik");
	}
	
	public void addBitisikRadioButtonActionListener(){
		gui.addBitisikRadioButtonActionListener(getTS825RadioButtonActionListener());
	}	

	public void setMekanikRadioButtonActionCommand(){
		gui.setMekanikRadioButtonActionCommand("Mekanik");
	}
	
	public void addMekanikRadioButtonActionListener(){
		gui.addMekanikRadioButtonActionListener(getTS825RadioButtonActionListener());
	}	

	public void setDogalRadioButtonActionCommand(){
		gui.setDogalRadioButtonActionCommand("Dogal");
	}
	
	public void addDogalRadioButtonActionListener(){
		gui.addDogalRadioButtonActionListener(getTS825RadioButtonActionListener());
	}	

	public void addHavalandirmaSecButtonActionListener(){
		gui.addHavalandirmaSecButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				mekanikHavalandirmaDialog = (MekanikHavalandirmaDialog) gui.showMekanikHavalandirmaDialog();
				loadMekanikHavalandirmaDetails();
				addMekanikHavalandirmaTamamButtonActionListener();
				addEsit1RadioButtonActionListener();
				addBuyuk1RadioButtonActionListener();
				setEsit1RadioButtonActionCommand();
				setBuyuk1RadioButtonActionCommand();
				setKorumasizRadioButtonActionCommand();
				setYariKorumaliRadioButtonActionCommand();
				setTamKorumaliRadioButtonActionCommand();
				addKorumasizRadioButtonActionListener();
				addYariKorumaliRadioButtonActionListener();
				addTamKorumaliRadioButtonActionListener();
			}			
		});
	}
	
	public void setHavalandirmaSecButtonEnabled(boolean state){
		gui.setHavalandirmaSecButtonEnabled(state);
	}

	public void setEsit1RadioButtonSelected(boolean state){
		mekanikHavalandirmaDialog.setEsit1RadioButtonSelected(state);
	}
	
	public boolean isEsit1RadioButtonSelected(){
		return mekanikHavalandirmaDialog.isEsit1RadioButtonSelected();
	}

	public void setBuyuk1KorumaliRadioButtonSelected(boolean state){
		mekanikHavalandirmaDialog.setBuyuk1KorumaliRadioButtonSelected(state);
	}
	
	public boolean isBuyuk1KorumaliRadioButtonSelected(){
		return mekanikHavalandirmaDialog.isBuyuk1KorumaliRadioButtonSelected();
	}

	public void setEsit1RadioButtonActionCommand(){
		mekanikHavalandirmaDialog.setEsit1RadioButtonActionCommand("Esit");
	}
	
	public void setBuyuk1RadioButtonActionCommand(){
		mekanikHavalandirmaDialog.setBuyuk1RadioButtonActionCommand("Buyuk");
	}
	
	public void addEsit1RadioButtonActionListener(){
		mekanikHavalandirmaDialog.addEsit1RadioButtonListener(getMekanikHavalandirmaRadioButtonListener());
	}
	
	public void addBuyuk1RadioButtonActionListener(){
		mekanikHavalandirmaDialog.addBuyuk1RadioButtonListener(getMekanikHavalandirmaRadioButtonListener());
	}
	
	public void setKorumasizRadioButtonActionCommand(){
		mekanikHavalandirmaDialog.setKorumasizRadioButtonActionCommand("Korumasiz");
	}
	
	public void setTamKorumaliRadioButtonActionCommand(){
		mekanikHavalandirmaDialog.setTamKorumaliRadioButtonActionCommand("Tam");
	}
	
	public void setYariKorumaliRadioButtonActionCommand(){
		mekanikHavalandirmaDialog.setYariKorumaliRadioButtonAction("Yari");
	}
	
	public void addKorumasizRadioButtonActionListener(){
		mekanikHavalandirmaDialog.addKorumasizRadioButtonActionListener(getMekanikHavalandirmaRadioButtonListener());
	}
	
	public void addTamKorumaliRadioButtonActionListener(){
		mekanikHavalandirmaDialog.addTamKorumaliRadioButtonActionListener(getMekanikHavalandirmaRadioButtonListener());
	}
	
	public void addYariKorumaliRadioButtonActionListener(){
		mekanikHavalandirmaDialog.addYariKorumaliRadioButtonActionListener(getMekanikHavalandirmaRadioButtonListener());
	}
	
	public void setKorumasizRadioButtonSelected(boolean state){
		mekanikHavalandirmaDialog.setKorumasizRadioButtonSelected(state);
	}
	
	public boolean isKorumasizRadioButtonSelected(){
		return mekanikHavalandirmaDialog.isKorumasizRadioButtonSelected();
	}

	public void setTamKorumaliRadioButtonSelected(boolean state){
		mekanikHavalandirmaDialog.setTamKorumaliRadioButtonSelected(state);
	}
	
	public boolean isTamKorumaliRadioButtonSelected(){
		return mekanikHavalandirmaDialog.isTamKorumaliRadioButtonSelected();
	}

	public void setYariKorumaliRadioButtonSelected(boolean state){
		mekanikHavalandirmaDialog.setYariKorumaliRadioButtonSelected(state);
	}
	
	public boolean isYariKorumaliRadioButtonSelected(){
		return mekanikHavalandirmaDialog.isYariKorumaliRadioButtonSelected();
	}

	public void setSurekliRadioButtonSelected(boolean state){
		mekanikHavalandirmaDialog.setSurekliRadioButtonSelected(state);
	}
	
	public boolean isSurekliRadioButtonSelected(){
		return mekanikHavalandirmaDialog.isSurekliRadioButtonSelected();
	}

	public void setSurekliRadioButtonActionCommand(){
		mekanikHavalandirmaDialog.setSurekliRadioButtonActionCommand("Surekli");
	}
	
	public void addSurekliRadioButtonActionListener(){
		mekanikHavalandirmaDialog.addSurekliRadioButtonActionListener(getMekanikHavalandirmaRadioButtonListener());
	}
	
	public void setAralikliRadioButtonSelected(boolean state){
		mekanikHavalandirmaDialog.setAralikliRadioButtonSelected(state);
	}
	
	public boolean isAralikliRadioButtonSelected(){
		return mekanikHavalandirmaDialog.isAralikliRadioButtonSelected();
	}

	public void setAralikliRadioButtonActionCommand(){
		mekanikHavalandirmaDialog.setAralikliRadioButtonActionCommand("Aralikli");
	}
	
	public void addAralikliRadioButtonActionListener(){
		mekanikHavalandirmaDialog.addAralikliRadioButtonActionListener(getMekanikHavalandirmaRadioButtonListener());
	}
	
	public void setFeedbackCheckBoxSelected(boolean state){
		mekanikHavalandirmaDialog.setFeedbackCheckBoxSelected(state);
	}
	
	public boolean isFeedbackRadioButtonSelected(){
		return mekanikHavalandirmaDialog.isFeedbackRadioButtonSelected();
	}	
	
	public void setHavaDegisimSayisiTextFieldText(String text){
		mekanikHavalandirmaDialog.setHavaDegisimSayisiTextFieldText(text);
	}
	
	public String getHavaDegisimSayisiTextFieldText(){
		return mekanikHavalandirmaDialog.getHavaDegisimSayisiTextFieldText();
	}

	public void setFansizHavaDegisimDebiTextFieldText(String text){
		mekanikHavalandirmaDialog.setFansizHavaDegisimDebiTextFieldText(text);
	}
	
	public String getFansizHavaDegisimDebiTextFieldText(){
		return mekanikHavalandirmaDialog.getFansizHavaDegisimDebiTextFieldText();
	}

	public void setFanCalismaOraniTextFieldText(String text){
		mekanikHavalandirmaDialog.setFanCalismaOraniTextFieldText(text);
	}
	
	public String getFanCalismaOraniTextFieldText(){
		return mekanikHavalandirmaDialog.getFanCalismaOraniTextFieldText();
	}

	public void setFeedbackVerimTextFieldText(String text){
		mekanikHavalandirmaDialog.setFeedbackVerimTextFieldText(text);
	}
	
	public String getFeedbackVerimTextFieldText(){
		return mekanikHavalandirmaDialog.getFeedbackVerimTextFieldText();
	}
	
	public void addMekanikHavalandirmaTamamButtonActionListener(){
		mekanikHavalandirmaDialog.addTamamButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				storeMekanikHavalandirmaDetails();
				mekanikHavalandirmaDialog.dispose();
				if(bina.getBrutHacim()>0) updateInterface();
			}
		});	
	}

	protected void storeMekanikHavalandirmaDetails() {
		MekanikHavalandirma havalandirma = (MekanikHavalandirma)bina.getHavalandirma();
		String temp = mekanikHavalandirmaDialog.getHavaGirisDebiTextFieldText();
		
		if(!temp.equals("") && temp!=null)havalandirma.setHavaGirisDebisi(Double.parseDouble(temp));
		temp = mekanikHavalandirmaDialog.getHavaCikisDebiTextFieldText();
		if(!temp.equals("") && temp!=null)havalandirma.setHavaCýkýsDebisi(Double.parseDouble(temp));
		temp = mekanikHavalandirmaDialog.getHavaDegisimSayisiTextFieldText();
		if(!temp.equals("") && temp!=null)havalandirma.setN50(Double.parseDouble(temp));
		
		havalandirma.setSurekliCalisiyor(mekanikHavalandirmaDialog.isSurekliRadioButtonSelected());
		havalandirma.setAralikliCalisiyor(mekanikHavalandirmaDialog.isAralikliRadioButtonSelected());
		havalandirma.setFeedbackVar(mekanikHavalandirmaDialog.isFeedbackRadioButtonSelected());
		
		temp = mekanikHavalandirmaDialog.getFanCalismaOraniTextFieldText();
		if(!temp.equals("") && temp!=null)havalandirma.setBeta(Double.parseDouble(temp));
		temp = mekanikHavalandirmaDialog.getFansizHavaDegisimDebiTextFieldText();
		if(!temp.equals("") && temp!=null)havalandirma.setFansizHavaDegisimDebisi(Double.parseDouble(temp));
		temp = mekanikHavalandirmaDialog.getFeedbackVerimTextFieldText();
		if(!temp.equals("") && temp!=null)havalandirma.setFeedbackVerim(Double.parseDouble(temp));
	}
	
	protected void loadMekanikHavalandirmaDetails() {
		MekanikHavalandirma havalandirma = (MekanikHavalandirma)bina.getHavalandirma();
		if(havalandirma.getBeta()!=0)mekanikHavalandirmaDialog.setFanCalismaOraniTextFieldText(""+havalandirma.getBeta());
		if(havalandirma.getFansizHavaDegisimDebisi()!=0) mekanikHavalandirmaDialog.setFansizHavaDegisimDebiTextFieldText(""+havalandirma.getFansizHavaDegisimDebisi());
		if(havalandirma.getFeedbackVerim()!=0) mekanikHavalandirmaDialog.setFeedbackVerimTextFieldText(""+havalandirma.getFeedbackVerim());
		mekanikHavalandirmaDialog.setSurekliRadioButtonSelected(havalandirma.isSurekliCalisiyor());
		mekanikHavalandirmaDialog.setAralikliRadioButtonSelected(havalandirma.isAralikliCalisiyor());
		mekanikHavalandirmaDialog.setFeedbackCheckBoxSelected(havalandirma.isFeedbackVar());
		if(havalandirma.getHavaGirisDebisi()!=0)mekanikHavalandirmaDialog.setHavaGirisDebiTextFieldText(""+havalandirma.getHavaGirisDebisi());
		if(havalandirma.getHavaCýkýsDebisi()!=0)mekanikHavalandirmaDialog.setHavaCikisDebiTextFieldText(""+havalandirma.getHavaCýkýsDebisi());
		if(havalandirma.getN50()!=0)mekanikHavalandirmaDialog.setHavaDegisimSayisiTextFieldText(""+havalandirma.getN50());
	}

	public void addDisDuvarEkleButtonActionListener(){
		gui.addDisDuvarEkleButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				disDuvarSayisi++;
				DefaultListModel listModel = gui.getDisDuvarlarListModel();
				String identifier = ""+disDuvarSayisi+". dýþ duvar";
				listModel.addElement(identifier);
				bina.createDisDuvar(identifier);
				setDisDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani(identifier));
				gui.setDisDuvarModelTableColumnWidths();
				gui.setDisDuvarSelectedElement(identifier);
			}
		});
	}

	protected void setDisDuvarTableModel(BilesikYapiElemani yapiElemani) {
		DefaultTableModel tableModel = BilesikYapiElemaniJTableWrapper.getTableModel(yapiElemani);
		gui.setDisDuvarModelTableModel(tableModel);
		gui.setDisDuvarModelTableColumnWidths();
		addDisDuvarModelTableModelListener();
	}
	
	public void addDisDuvarBilesenEkleActionListener(){
		gui.addDisDuvarBilesenEkleActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				showBilesenEkleDialog();
				bilesenEkleDialog.addEkleButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						Object[] newRow = createNewRowAndDispose(gui.getDisDuvarListSelectedValue());
						gui.getDisDuvarModelTableModel().addRow(newRow);						
					}
				});
				bilesenEkleDialog.addTreeMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(e.getClickCount()==2){
    						Object[] newRow = createNewRowAndDispose(gui.getDisDuvarListSelectedValue());
    						if(newRow!=null)gui.getDisDuvarModelTableModel().addRow(newRow);						                            
                        }
                    }
				});
				bilesenEkleDialog.addVazgecButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						bilesenEkleDialog.dispose();
					}
				});
			}
		});
	}

	protected DefaultTreeModel createMalzemeTree() {
		Malzeme rootMalzeme = Malzemeler.getInstance().getRootMalzeme();
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootMalzeme);
		parseChildren(rootNode);
		
		return new DefaultTreeModel(rootNode);
	}
	
	protected void parseChildren(DefaultMutableTreeNode rootNode){
		Malzeme rootMalzeme = (Malzeme) rootNode.getUserObject();
		Iterator it = rootMalzeme.getChildren().iterator();
		while(it.hasNext()){
			DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(it.next());
			rootNode.add(childNode);
			parseChildren(childNode);
		}
	}

	public void addDisDuvarListListSelectionListener(){
		gui.addDisDuvarListListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent arg0) {
				String identifier = gui.getDisDuvarListSelectedValue();
				BilesikYapiElemani selectedEleman = (BilesikYapiElemani)bina.getYapiElemani(identifier);
				if(selectedEleman!=null){
					setDisDuvarTableModel(selectedEleman);
					gui.setDisDuvarUTextFieldText(""+twoDigits.format(selectedEleman.getIsiGecirgenlikKatsayisi()));
					gui.setDisDuvarAlanTextFieldText(""+selectedEleman.getAlan());
					updateInterface();
				}
				else{
					gui.setDisDuvarModelTableModel(new DefaultTableModel());
					gui.setDisDuvarUTextFieldText("");
				}
				updateInterface();
			}
		});
	}

	public void addDisDuvarModelTableModelListener(){
		gui.addDisDuvarModelTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent arg0) {
				BilesikYapiElemani yapiElemani = (BilesikYapiElemani)bina.getYapiElemani(gui.getDisDuvarListSelectedValue());
				yapiElemani.getBilesenler().clear();
				yapiElemani.setBilesenler(BilesikYapiElemaniJTableWrapper.getBilesenler(gui.getDisDuvarModelTableModel()));
				setDisDuvarTableModel(yapiElemani);
				DecimalFormat twoDigits = new DecimalFormat("0.00");
				gui.setDisDuvarUTextFieldText(""+twoDigits.format(yapiElemani.getIsiGecirgenlikKatsayisi()));
				updateInterface();
			}
		});
	}

	public void addDisDuvarBilesenCikarButtonActionListener(){
		gui.addDisDuvarBilesenCikarButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				gui.removeDisDuvarModelTableSelectedRow();
			}
		});
	}
	
	public void addDisDuvarCikarButtonActionListener(){
		gui.addDisDuvarCikarButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String identifier = gui.getDisDuvarListSelectedValue();
				bina.deleteYapiElemani(identifier);
				gui.removeDuvarFromList(identifier);				
			}
		});
	}
	

	public void addDisDuvarAlaniTextFieldKeyListener(){
		gui.addDisDuvarAlaniTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				disDuvarAlaniAction();
			}
		});
	}
	
	private void disDuvarAlaniAction() {
		double alan = 0;
		String alanString = gui.getDisDuvarAlanTextFieldText();
		if(alanString!=null) alan = Double.parseDouble(alanString); 
		BilesikYapiElemani yapiElemani = ((BilesikYapiElemani)bina.getYapiElemani(gui.getDisDuvarListSelectedValue()));
		yapiElemani.setAlan(alan);
		updateInterface();
	}

	protected void setToplamAlanTextFieldText(double d) {
		gui.setToplamAlanTextFieldText(d);
		String brutHacimString = gui.getBrutHacimTextFieldText();
		double brutHacim = 0;
		if(!brutHacimString.equals("") && brutHacimString!=null){
		    brutHacim = Double.parseDouble(brutHacimString);
		    double oran = bina.hesaplaToplamAlanBrutHacimOrani();
		    gui.setAlanHacimOraniTextFieldText(""+twoDigits.format(oran));
		}		
	}
	
	public void addBrutHacimTextFieldKeyListener(){
		gui.addBrutHacimTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				brutHacimTextFieldAction();
			}
		});
	}

	private void brutHacimTextFieldAction() {
		String hacimText = gui.getBrutHacimTextFieldText();
		if(hacimText!=null && !hacimText.equals("")){
			bina.setBrutHacim(Double.parseDouble(hacimText));
			if(bina.hesaplaToplamAlan()!=0){
				double oran = bina.hesaplaToplamAlanBrutHacimOrani();
				gui.setAlanHacimOraniTextFieldText(""+twoDigits.format(oran));
			}
//			bina.getHavalandirma().setBrutHacim(Double.parseDouble(hacimText));
			if(bina.getHavalandirma()!=null) updateInterface();
			gui.setBinaKullanimAlaniTextFieldText(bina.getBinaKullanimAlani());
		}
	}

	public void addIcOrtamSicakligiTextFieldKeyListener(){
		gui.addIcOrtamSicakligiTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				icOrtamSicakligiTextFieldAction();
			}
		});
	}

	protected void icOrtamSicakligiTextFieldAction() {
		String icOrtamSicakligi = gui.getIcOrtamSicakligiTextFieldText();
		if(icOrtamSicakligi!=null && !icOrtamSicakligi.equals(""))	bina.setIcSicaklik(Double.parseDouble(icOrtamSicakligi));
		
	}

	private void showBilesenEkleDialog() {
		DefaultTreeModel treeModel = createMalzemeTree();				
		bilesenEkleDialog = (BilesenEkleDialog)gui.showBilesenEkleDialog(treeModel);
	}

	private Object[] createNewRowAndDispose(String identifier) {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) bilesenEkleDialog.getSelectedMalzeme();
		if(selectedNode!=null){
			Malzeme secilenMalzeme = (Malzeme) selectedNode.getUserObject();
			BilesikYapiElemani yapiElemani = (BilesikYapiElemani) bina.getYapiElemani(identifier);
			Bilesen yeniBilesen = new Bilesen(0,Double.parseDouble(secilenMalzeme.getIsilIletkenlik().replace(',','.')));
			yeniBilesen.setMalzemeCinsi(secilenMalzeme.getCesit());
			yeniBilesen.setSuBuhariDifuzyonDirenciKatsayisi(Double.parseDouble(secilenMalzeme.getDifuzyonFaktoru()));
			yapiElemani.addBilesen(yeniBilesen);
			Object[] newRow = {secilenMalzeme.getId(),secilenMalzeme.getCesit(),"",secilenMalzeme.getIsilIletkenlik(),secilenMalzeme.getDifuzyonFaktoru()};
			bilesenEkleDialog.dispose();
			return newRow;		    
		}
		return null;
	}

	public void addIsitilmayanDuvarBilesenEkleActionListener(){
		gui.addIsitilmayanDuvarBilesenEkleActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				showBilesenEkleDialog();
				bilesenEkleDialog.addEkleButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(bina.getYapiElemani("Isitilmayan")==null){
							bina.addYapiElemani(new BinaDuvari("Isitilmayan",new DIsitilmayan()));
							setIsitilmayanDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan"));
						}
						Object[] newRow = createNewRowAndDispose("Isitilmayan");
						setIsitilmayanDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan"));
						gui.setIsitilmayanDuvarUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan")).hesaplaIsiGecirgenlikDirenci()));
						updateInterface();
					}   
				});
				bilesenEkleDialog.addTreeMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(e.getClickCount()==2){
    						if(bina.getYapiElemani("Isitilmayan")==null){
    							bina.addYapiElemani(new BinaDuvari("Isitilmayan",new DIsitilmayan()));
    							setIsitilmayanDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan"));
    						}
    						Object[] newRow = createNewRowAndDispose("Isitilmayan");
    						if(newRow!=null){
    							setIsitilmayanDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan"));
    							gui.setIsitilmayanDuvarUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan")).hesaplaIsiGecirgenlikDirenci()));
    							updateInterface();
    						}
                        }
                    }
				});
				bilesenEkleDialog.addVazgecButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						bilesenEkleDialog.dispose();
					}
				});
			}
		});
	}
	
	public void addIsitilmayanDuvarModelTableModelListener(){
		gui.addIsitilmayanDuvarModelTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent arg0) {
				BilesikYapiElemani yapiElemani = (BilesikYapiElemani)bina.getYapiElemani("Isitilmayan");
				yapiElemani.getBilesenler().clear();
				yapiElemani.setBilesenler(BilesikYapiElemaniJTableWrapper.getBilesenler(gui.getIsitilmayanDuvarModelTableModel()));
				setIsitilmayanDuvarTableModel(yapiElemani);
				DecimalFormat twoDigits = new DecimalFormat("0.00");
				gui.setIsitilmayanDuvarUTextFieldText(""+twoDigits.format(yapiElemani.getIsiGecirgenlikKatsayisi()));
				updateInterface();
			}
		});
	}

	protected void setIsitilmayanDuvarTableModel(BilesikYapiElemani yapiElemani) {
		DefaultTableModel tableModel = BilesikYapiElemaniJTableWrapper.getTableModel(yapiElemani);
		gui.setIsitilmayanDuvarModelTableModel(tableModel);
		gui.setIsitilmayanDuvarModelTableColumnWidths();
		addIsitilmayanDuvarModelTableModelListener();
	}

	public void addIsitilmayanDuvarBilesenCikarButtonActionListener(){
		gui.addIsitilmayanDuvarBilesenCikarButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				gui.removeIsitilmayanDuvarModelTableSelectedRow();
			}
		});
	}
	
	public void addIsitilmayanDuvarAlaniTextFieldKeyListener(){
		gui.addIsitilmayanDuvarAlaniTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				isitilmayanDuvarAlaniAction();
			}
		});
	}

    protected void isitilmayanDuvarAlaniAction() {
		double alan = 0;
		String alanString = gui.getIsitilmayanDuvarAlanTextFieldText();
		if(alanString!=null) alan = Double.parseDouble(alanString); 
		BilesikYapiElemani yapiElemani = ((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan"));
		yapiElemani.setAlan(alan);
		updateInterface();
    }

    public void addTopragaTemasliDuvarBilesenEkleActionListener(){
		gui.addTopragaTemasliDuvarBilesenEkleActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				showBilesenEkleDialog();
				bilesenEkleDialog.addEkleButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(bina.getYapiElemani("DTopragaTemasli")==null){
							bina.addYapiElemani(new BinaDuvari("DTopragaTemasli",new DTopragaTemasli()));
							setTopragaTemasliDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli"));
						}
						Object[] newRow = createNewRowAndDispose("DTopragaTemasli");
						setTopragaTemasliDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli"));
						gui.setTopragaTemasliDuvarUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli")).hesaplaIsiGecirgenlikDirenci()));
						updateInterface();
					}
				});
				bilesenEkleDialog.addTreeMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(e.getClickCount()==2){
    						if(bina.getYapiElemani("DTopragaTemasli")==null){
    							bina.addYapiElemani(new BinaDuvari("DTopragaTemasli",new DTopragaTemasli()));
    							setTopragaTemasliDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli"));
    						}
    						Object[] newRow = createNewRowAndDispose("DTopragaTemasli");
    						if(newRow!=null){
    							setTopragaTemasliDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli"));
    							gui.setTopragaTemasliDuvarUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli")).hesaplaIsiGecirgenlikDirenci()));
    							updateInterface();
    						}
                        }
                    }
				});
				bilesenEkleDialog.addVazgecButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						bilesenEkleDialog.dispose();
					}
				});
			}
		});
	}
	
	public void addTopragaTemasliDuvarModelTableModelListener(){
		gui.addTopragaTemasliDuvarModelTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent arg0) {
				BilesikYapiElemani yapiElemani = (BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli");
				yapiElemani.getBilesenler().clear();
				yapiElemani.setBilesenler(BilesikYapiElemaniJTableWrapper.getBilesenler(gui.getTopragaTemasliDuvarModelTableModel()));
				setTopragaTemasliDuvarTableModel(yapiElemani);
				DecimalFormat twoDigits = new DecimalFormat("0.00");
				gui.setTopragaTemasliDuvarUTextFieldText(""+twoDigits.format(yapiElemani.getIsiGecirgenlikKatsayisi()));
				updateInterface();
			}
		});
	}

	protected void setTopragaTemasliDuvarTableModel(BilesikYapiElemani yapiElemani) {
		DefaultTableModel tableModel = BilesikYapiElemaniJTableWrapper.getTableModel(yapiElemani);
		gui.setTopragaTemasliDuvarModelTableModel(tableModel);
		gui.setTopragaTemasliDuvarModelTableColumnWidths();
		addTopragaTemasliDuvarModelTableModelListener();
	}
	
	public void addTopragaTemasliDuvarBilesenCikarButtonActionListener(){
		gui.addTopragaTemasliDuvarBilesenCikarButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				gui.removeTopragaTemasliDuvarModelTableSelectedRow();
			}
		});
	}

	public void addTopragaTemasliDuvarAlaniTextFieldKeyListener(){
		gui.addTopragaTemasliDuvarAlaniTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				topragaTemasliDuvarAlaniAction();
			}
		});
	}


    protected void topragaTemasliDuvarAlaniAction() {
		double alan = 0;
		String alanString = gui.getTopragaTemasliDuvarAlanTextFieldText();
		if(alanString!=null) alan = Double.parseDouble(alanString); 
		BilesikYapiElemani yapiElemani = ((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli"));
		yapiElemani.setAlan(alan);
		updateInterface();
    }

	public void addUzeriAcikTavanBilesenEkleActionListener(){
		gui.addUzeriAcikTavanBilesenEkleActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				showBilesenEkleDialog();
				bilesenEkleDialog.addEkleButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(bina.getYapiElemani("UzeriAcik")==null){
							bina.addYapiElemani(new UzeriAcikTavan("UzeriAcik",new UzeriAcik()));
							setUzeriAcikTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik"));
						}
						Object[] newRow = createNewRowAndDispose("UzeriAcik");
						setUzeriAcikTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik"));
						gui.setUzeriAcikTavanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik")).hesaplaIsiGecirgenlikDirenci()));
						updateInterface();
					}
				});
				bilesenEkleDialog.addTreeMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(e.getClickCount()==2){
    						if(bina.getYapiElemani("UzeriAcik")==null){
    							bina.addYapiElemani(new UzeriAcikTavan("UzeriAcik",new UzeriAcik()));
    							setUzeriAcikTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik"));
    						}
    						Object[] newRow = createNewRowAndDispose("UzeriAcik");
    						if(newRow!=null){
    							setUzeriAcikTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik"));
    							gui.setUzeriAcikTavanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik")).hesaplaIsiGecirgenlikDirenci()));
    							updateInterface();
    						}
                        }
                    }
				});
				bilesenEkleDialog.addVazgecButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						bilesenEkleDialog.dispose();
					}
				});
			}
		});
	}
	
	public void addUzeriAcikTavanModelTableModelListener(){
		gui.addUzeriAcikTavanModelTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent arg0) {
				BilesikYapiElemani yapiElemani = (BilesikYapiElemani)bina.getYapiElemani("UzeriAcik");
				yapiElemani.getBilesenler().clear();
				yapiElemani.setBilesenler(BilesikYapiElemaniJTableWrapper.getBilesenler(gui.getUzeriAcikTavanModelTableModel()));
				setUzeriAcikTavanTableModel(yapiElemani);
				DecimalFormat twoDigits = new DecimalFormat("0.00");
				gui.setUzeriAcikTavanUTextFieldText(""+twoDigits.format(yapiElemani.getIsiGecirgenlikKatsayisi()));
				updateInterface();
			}
		});
	}

	protected void setUzeriAcikTavanTableModel(BilesikYapiElemani yapiElemani) {
		DefaultTableModel tableModel = BilesikYapiElemaniJTableWrapper.getTableModel(yapiElemani);
		gui.setUzeriAcikTavanModelTableModel(tableModel);
		gui.setUzeriAcikTavanModelTableColumnWidths();
		addUzeriAcikTavanModelTableModelListener();
	}
	
	public void addUzeriAcikTavanBilesenCikarButtonActionListener(){
		gui.addUzeriAcikTavanBilesenCikarButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				gui.removeUzeriAcikTavanModelTableSelectedRow();
			}
		});
	}

	public void addUzeriAcikTavanAlaniTextFieldKeyListener(){
		gui.addUzeriAcikTavanAlaniTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				uzeriAcikTavanAlaniAction();
			}
		});
	}

    protected void uzeriAcikTavanAlaniAction() {
		double alan = 0;
		String alanString = gui.getUzeriAcikTavanAlanTextFieldText();
		if(alanString!=null) alan = Double.parseDouble(alanString); 
		BilesikYapiElemani yapiElemani = ((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik"));
		yapiElemani.setAlan(alan);
		updateInterface();
    }

	public void addCatiliTavanBilesenEkleActionListener(){
		gui.addCatiliTavanBilesenEkleActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				showBilesenEkleDialog();
				bilesenEkleDialog.addEkleButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(bina.getYapiElemani("Catili")==null){
							bina.addYapiElemani(new CatiliTavan("Catili",new Catili()));
							setCatiliTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("Catili"));
						}
						Object[] newRow = createNewRowAndDispose("Catili");
						setCatiliTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("Catili"));
						gui.setCatiliTavanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("Catili")).hesaplaIsiGecirgenlikDirenci()));
						updateInterface();
					}
				});
				bilesenEkleDialog.addTreeMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(e.getClickCount()==2){
    						if(bina.getYapiElemani("Catili")==null){
    							bina.addYapiElemani(new CatiliTavan("Catili",new Catili()));
    							setCatiliTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("Catili"));
    						}
    						Object[] newRow = createNewRowAndDispose("Catili");
    						if(newRow!=null){
    						    setCatiliTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("Catili"));
    							gui.setCatiliTavanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("Catili")).hesaplaIsiGecirgenlikDirenci()));
    							updateInterface();
    						}
                        }
                    }
				});
				bilesenEkleDialog.addVazgecButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						bilesenEkleDialog.dispose();
					}
				});
			}
		});
	}
	
	public void addCatiliTavanModelTableModelListener(){
		gui.addCatiliTavanModelTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent arg0) {
				BilesikYapiElemani yapiElemani = (BilesikYapiElemani)bina.getYapiElemani("Catili");
				yapiElemani.getBilesenler().clear();
				yapiElemani.setBilesenler(BilesikYapiElemaniJTableWrapper.getBilesenler(gui.getCatiliTavanModelTableModel()));
				setCatiliTavanTableModel(yapiElemani);
				DecimalFormat twoDigits = new DecimalFormat("0.00");
				gui.setCatiliTavanUTextFieldText(""+twoDigits.format(yapiElemani.getIsiGecirgenlikKatsayisi()));
				updateInterface();
			}
		});
	}

	protected void setCatiliTavanTableModel(BilesikYapiElemani yapiElemani) {
		DefaultTableModel tableModel = BilesikYapiElemaniJTableWrapper.getTableModel(yapiElemani);
		gui.setCatiliTavanModelTableModel(tableModel);
		gui.setCatiliTavanModelTableColumnWidths();
		addCatiliTavanModelTableModelListener();
	}
	
	public void addCatiliTavanBilesenCikarButtonActionListener(){
		gui.addCatiliTavanBilesenCikarButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				gui.removeCatiliTavanModelTableSelectedRow();
			}
		});
	}

	public void addCatiliTavanAlaniTextFieldKeyListener(){
		gui.addCatiliTavanAlaniTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				catiliTavanAlaniAction();
			}
		});
	}

    protected void catiliTavanAlaniAction() {
		double alan = 0;
		String alanString = gui.getCatiliTavanAlanTextFieldText();
		if(alanString!=null) alan = Double.parseDouble(alanString); 
		BilesikYapiElemani yapiElemani = ((BilesikYapiElemani)bina.getYapiElemani("Catili"));
		yapiElemani.setAlan(alan);
		updateInterface();
    }
      
	public void addTopragaTemasliTabanBilesenEkleActionListener(){
		gui.addTopragaTemasliTabanBilesenEkleActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				showBilesenEkleDialog();
				bilesenEkleDialog.addEkleButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(bina.getYapiElemani("TTopragaTemasli")==null){
							bina.addYapiElemani(new BinaDuvari("TTopragaTemasli",new TTopragaTemasli()));
							setTopragaTemasliTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli"));
						}
						Object[] newRow = createNewRowAndDispose("TTopragaTemasli");
						setTopragaTemasliTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli"));
						gui.setTopragaTemasliTabanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli")).hesaplaIsiGecirgenlikDirenci()));
						updateInterface();
					}
				});
				bilesenEkleDialog.addTreeMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(e.getClickCount()==2){
    						if(bina.getYapiElemani("TTopragaTemasli")==null){
    							bina.addYapiElemani(new BinaDuvari("TTopragaTemasli",new TTopragaTemasli()));
    							setTopragaTemasliTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli"));
    						}
    						Object[] newRow = createNewRowAndDispose("TTopragaTemasli");
    						if(newRow!=null){
    							setTopragaTemasliTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli"));
    							gui.setTopragaTemasliTabanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli")).hesaplaIsiGecirgenlikDirenci()));
    							updateInterface();
    						}
                        }
                    }
				});
				bilesenEkleDialog.addVazgecButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						bilesenEkleDialog.dispose();
					}
				});
			}
		});
	}
	
	public void addTopragaTemasliTabanModelTableModelListener(){
		gui.addTopragaTemasliTabanModelTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent arg0) {
				BilesikYapiElemani yapiElemani = (BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli");
				yapiElemani.getBilesenler().clear();
				yapiElemani.setBilesenler(BilesikYapiElemaniJTableWrapper.getBilesenler(gui.getTopragaTemasliTabanModelTableModel()));
				setTopragaTemasliTabanTableModel(yapiElemani);
				DecimalFormat twoDigits = new DecimalFormat("0.00");
				gui.setTopragaTemasliTabanUTextFieldText(""+twoDigits.format(yapiElemani.getIsiGecirgenlikKatsayisi()));
				updateInterface();
			}
		});
	}

	protected void setTopragaTemasliTabanTableModel(BilesikYapiElemani yapiElemani) {
		DefaultTableModel tableModel = BilesikYapiElemaniJTableWrapper.getTableModel(yapiElemani);
		gui.setTopragaTemasliTabanModelTableModel(tableModel);
		gui.setTopragaTemasliTabanModelTableColumnWidths();
		addTopragaTemasliTabanModelTableModelListener();
	}
	
	public void addTopragaTemasliTabanBilesenCikarButtonActionListener(){
		gui.addTopragaTemasliTabanBilesenCikarButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				gui.removeTopragaTemasliTabanModelTableSelectedRow();
			}
		});
	}
	
	public void addTopragaTemasliTabanAlaniTextFieldKeyListener(){
		gui.addTopragaTemasliTabanAlaniTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				topragaTemasliTabanAlaniAction();
			}
		});
	}

    protected void topragaTemasliTabanAlaniAction() {
		double alan = 0;
		String alanString = gui.getTopragaTemasliTabanAlanTextFieldText();
		if(alanString!=null) alan = Double.parseDouble(alanString); 
		BilesikYapiElemani yapiElemani = ((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli"));
		yapiElemani.setAlan(alan);
		updateInterface();
    }
              
	public void addIsitilmayanTabanBilesenEkleActionListener(){
		gui.addIsitilmayanTabanBilesenEkleActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				showBilesenEkleDialog();
				bilesenEkleDialog.addEkleButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(bina.getYapiElemani("TIsitilmayan")==null){
							bina.addYapiElemani(new BinaDuvari("TIsitilmayan",new TIsitilmayan()));
							setIsitilmayanTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan"));
						}
						Object[] newRow = createNewRowAndDispose("TIsitilmayan");
						setIsitilmayanTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan"));
						gui.setIsitilmayanTabanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan")).hesaplaIsiGecirgenlikDirenci()));
						updateInterface();
					}
				});
				bilesenEkleDialog.addTreeMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(e.getClickCount()==2){
    						if(bina.getYapiElemani("TIsitilmayan")==null){
    							bina.addYapiElemani(new BinaDuvari("TIsitilmayan",new TIsitilmayan()));
    							setIsitilmayanTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan"));
    						}
    						Object[] newRow = createNewRowAndDispose("TIsitilmayan");
    						if(newRow!=null){
    							setIsitilmayanTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan"));
    							gui.setIsitilmayanTabanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan")).hesaplaIsiGecirgenlikDirenci()));
    							updateInterface();
    						}
                        }
                    }
				});
				bilesenEkleDialog.addVazgecButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						bilesenEkleDialog.dispose();
					}
				});
			}
		});
	}
	
	public void addIsitilmayanTabanModelTableModelListener(){
		gui.addIsitilmayanTabanModelTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent arg0) {
				BilesikYapiElemani yapiElemani = (BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan");
				yapiElemani.getBilesenler().clear();
				yapiElemani.setBilesenler(BilesikYapiElemaniJTableWrapper.getBilesenler(gui.getIsitilmayanTabanModelTableModel()));
				setIsitilmayanTabanTableModel(yapiElemani);
				DecimalFormat twoDigits = new DecimalFormat("0.00");
				gui.setIsitilmayanTabanUTextFieldText(""+twoDigits.format(yapiElemani.getIsiGecirgenlikKatsayisi()));
				updateInterface();
			}
		});
	}

	protected void setIsitilmayanTabanTableModel(BilesikYapiElemani yapiElemani) {
		DefaultTableModel tableModel = BilesikYapiElemaniJTableWrapper.getTableModel(yapiElemani);
		gui.setIsitilmayanTabanModelTableModel(tableModel);
		gui.setIsitilmayanTabanModelTableColumnWidths();
		addIsitilmayanTabanModelTableModelListener();
	}
	
	public void addIsitilmayanTabanBilesenCikarButtonActionListener(){
		gui.addIsitilmayanTabanBilesenCikarButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				gui.removeIsitilmayanTabanModelTableSelectedRow();
			}
		});
	}
	
	public void addIsitilmayanTabanAlaniTextFieldKeyListener(){
		gui.addIsitilmayanTabanAlaniTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				isitilmayanTabanAlaniAction();
			}
		});
	}

    protected void isitilmayanTabanAlaniAction() {
		double alan = 0;
		String alanString = gui.getIsitilmayanTabanAlanTextFieldText();
		if(alanString!=null) alan = Double.parseDouble(alanString); 
		BilesikYapiElemani yapiElemani = ((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan"));
		yapiElemani.setAlan(alan);
		updateInterface();
    }
    
	public void addAcikGecitUzeriTabanBilesenEkleActionListener(){
		gui.addAcikGecitUzeriTabanBilesenEkleActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				showBilesenEkleDialog();
				bilesenEkleDialog.addEkleButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(bina.getYapiElemani("AcikGecitUzeri")==null){
							bina.addYapiElemani(new BinaDuvari("AcikGecitUzeri",new AcikGecitUzeri()));
							setAcikGecitUzeriTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri"));
						}
						Object[] newRow = createNewRowAndDispose("AcikGecitUzeri");
						setAcikGecitUzeriTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri"));
						gui.setAcikGecitUzeriTabanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri")).hesaplaIsiGecirgenlikDirenci()));
						updateInterface();
					}
				});
				bilesenEkleDialog.addTreeMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(e.getClickCount()==2){
    						if(bina.getYapiElemani("AcikGecitUzeri")==null){
    							bina.addYapiElemani(new BinaDuvari("AcikGecitUzeri",new AcikGecitUzeri()));
    							setAcikGecitUzeriTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri"));
    						}
    						Object[] newRow = createNewRowAndDispose("AcikGecitUzeri");
    						if(newRow!=null){
    						    setAcikGecitUzeriTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri"));
    							gui.setAcikGecitUzeriTabanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri")).hesaplaIsiGecirgenlikDirenci()));
    							updateInterface();
    						}
                        }
                    }
				});
				bilesenEkleDialog.addVazgecButtonActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						bilesenEkleDialog.dispose();
					}
				});
			}
		});
	}
	
	public void addAcikGecitUzeriTabanModelTableModelListener(){
		gui.addAcikGecitUzeriTabanModelTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent arg0) {
				BilesikYapiElemani yapiElemani = (BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri");
				yapiElemani.getBilesenler().clear();
				yapiElemani.setBilesenler(BilesikYapiElemaniJTableWrapper.getBilesenler(gui.getAcikGecitUzeriTabanModelTableModel()));
				setAcikGecitUzeriTabanTableModel(yapiElemani);
				DecimalFormat twoDigits = new DecimalFormat("0.00");
				gui.setAcikGecitUzeriTabanUTextFieldText(""+twoDigits.format(yapiElemani.getIsiGecirgenlikKatsayisi()));
				updateInterface();
			}
		});
	}

	protected void setAcikGecitUzeriTabanTableModel(BilesikYapiElemani yapiElemani) {
		DefaultTableModel tableModel = BilesikYapiElemaniJTableWrapper.getTableModel(yapiElemani);
		gui.setAcikGecitUzeriTabanModelTableModel(tableModel);
		gui.setAcikGecitUzeriTabanModelTableColumnWidths();
		addAcikGecitUzeriTabanModelTableModelListener();
	}
	
	public void addAcikGecitUzeriTabanBilesenCikarButtonActionListener(){
		gui.addAcikGecitUzeriTabanBilesenCikarButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				gui.removeAcikGecitUzeriTabanModelTableSelectedRow();
			}
		});
	}
	
	public void addAcikGecitUzeriTabanAlaniTextFieldKeyListener(){
		gui.addAcikGecitUzeriTabanAlaniTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				acikGecitUzeriTabanAlaniAction();
			}
		});
	}

    protected void acikGecitUzeriTabanAlaniAction() {
		double alan = 0;
		String alanString = gui.getAcikGecitUzeriTabanAlanTextFieldText();
		if(alanString!=null) alan = Double.parseDouble(alanString); 
		BilesikYapiElemani yapiElemani = ((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri"));
		yapiElemani.setAlan(alan);
		updateInterface();
    }
    
    private void updateInterface() {
        if(proje.getIl()!=null){
        	double qYil = 0;
            setToplamAlanTextFieldText(bina.hesaplaToplamAlan());
    		setIletimselOzgulIsiKaybiTextFieldText();
    		setToplamOzgulIsiKaybiTextFieldText();
    		gui.setHavalandirmaOzgulIsiKaybiTextFieldText(bina.hesaplaHavalandirmaOzgulIsiKaybi());
    		double Q = bina.hesaplaToplamYillikIsitmaEnerjisiIhtiyaci()/1000000*0.278;
    		if(bina.getOdaYuksekligi()<=2.6) qYil = (Q / bina.getBinaKullanimAlani()); 
    		if(bina.getOdaYuksekligi()>2.6) qYil = (Q / bina.getBrutHacim());
            gui.setQtextFieldText(""+twoDigits.format(qYil));
            double standartQ = bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci();
            gui.setStandartQTextFieldText(twoDigits.format(standartQ));
            if(qYil < standartQ){
            	gui.setStandartaUygunlukTextFieldColor(Color.BLACK);
            	gui.setStandartaUygunlukTextFieldText("Bina için yapýlmýþ ýsý yalýtým projesi standarta uygundur.");
            }
            else{
            	gui.setStandartaUygunlukTextFieldText("Bina için yapýlmýþ ýsý yalýtým projesi standarta uymuyor.");
            	gui.setStandartaUygunlukTextFieldColor(Color.RED);
            }            
        }
    }

    public void setDoguPencereRadioButtonActionCommand(){
        gui.setDoguPencereRadioButtonActionCommand("Dogu");
    }
    
    public void setBatiPencereRadioButtonActionCommand(){
        gui.setBatiPencereRadioButtonActionCommand("Bati");
    }

    public void setGuneyPencereRadioButtonActionCommand(){
        gui.setGuneyPencereRadioButtonActionCommand("Guney");
    }

    public void setKuzeyPencereRadioButtonActionCommand(){
        gui.setKuzeyPencereRadioButtonActionCommand("Kuzey");
    }
    
    public void addDoguPencereRadioButtonActionListener(){
        gui.addDoguPencereRadioButtonActionCommand(getTS825RadioButtonActionListener());
    }
    
    public void addBatiPencereRadioButtonActionListener(){
        gui.addBatiPencereRadioButtonActionCommand(getTS825RadioButtonActionListener());
    }

    public void addGuneyPencereRadioButtonActionListener(){
        gui.addGuneyPencereRadioButtonActionCommand(getTS825RadioButtonActionListener());
    }

    public void addKuzeyPencereRadioButtonActionListener(){
        gui.addKuzeyPencereRadioButtonActionCommand(getTS825RadioButtonActionListener());
    }

	public void addYoneGorePencereAlaniTextFieldKeyListener(){
		gui.addYoneGorePencereAlaniTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				yoneGorePencereAlaniAction();
			}
		});
	}

    protected void yoneGorePencereAlaniAction() {
        String pencereAlaniString = gui.getYoneGorePencereAlaniTextFieldText();
        String yon = "";
        if(gui.isDoguPencereRadioButtonSelected()) yon = "DOGU";
        if(gui.isBatiPencereRadioButtonSelected()) yon = "BATI";
        if(gui.isKuzeyPencereRadioButtonSelected()) yon = "KUZEY";
        if(gui.isGuneyPencereRadioButtonSelected()) yon = "GUNEY";                
        if(pencereAlaniString!=null && !pencereAlaniString.equals("") && !yon.equals("")){
            bina.setPencereAlani(yon,pencereAlaniString);
        }
        gui.setToplamPencereAlaniTextFieldText(""+twoDigits.format(bina.getToplamPencereAlani()));
        updateGunesEnerjisiKazanci();
    }
    
    protected void showHelpDialog() {
        InfoDialog help = new InfoDialog();
        help.setTitle("Tesisat Projelerinde Kullanýlan Ýç Hava Sýcaklýklarý Çizelgesi");
        help.setVisible(true);
    }
    
    public void addHavaDegisimKatsayisiTextFieldKeyListener(){
		gui.addHavaDegisimKatsayisiTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				havaDegisimKatsayisiAction();
			}
		});
	}

    protected void havaDegisimKatsayisiAction() {
        String havaDegisimSayisiString = gui.getHavaDegisimKatsayisiTextFieldText();
        if(havaDegisimSayisiString!=null && !havaDegisimSayisiString.equals(""))((DogalHavalandirma)bina.getHavalandirma()).setHavaDegisimSayisi(Double.parseDouble(havaDegisimSayisiString));
        if(gui.getBrutHacimTextFieldText()!=null && !gui.getBrutHacimTextFieldText().equals("")) updateInterface();
    }
    	
    public void addPencereAlanTextFieldKeyListener(){
		gui.addPencereAlanTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				pencereAlanAction();
			}
		});
	}

    protected void pencereAlanAction() {
        Pencere pencere = (Pencere)bina.getYapiElemani("Pencere");
        if(pencere==null) pencere = bina.createPencere();
        pencere.setAlan(Double.parseDouble(gui.getPencereAlanTextFieldText()));
        updateInterface();
    }

    public void addPencereUTextFieldKeyListener(){
		gui.addPencereUTextFieldKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				pencereUAction();
			}
		});
	}

    protected void pencereUAction() {
        Pencere pencere = (Pencere)bina.getYapiElemani("Pencere");
        if(pencere==null) pencere = bina.createPencere();
        pencere.setIsiGecirgenlikKatsayisi(Double.parseDouble(gui.getPencereUTextFieldText()));
        updateInterface();
    }

    public void setIletimselOzgulIsiKaybiTextFieldText(){
        gui.setIletimselOzgulIsiKaybiTextFieldText(""+twoDigits.format(bina.hesaplaOzgulIletimselIsiKaybi()));
    }
    
    private void setToplamOzgulIsiKaybiTextFieldText(){
        gui.setToplamOzgulIsiKaybiTextFieldText(""+twoDigits.format(bina.hesaplaToplamOzgulIsiKaybi()));
    }
    
    private void addGDikDoguBRadioButtonActionCommand(){
        gui.setGDikDoguBRadioButtonActionCommand("GDIKDOGUB");
    }
    
    private void addGDikBatiBRadioButtonActionCommand(){
        gui.setGDikBatiBRadioButtonActionCommand("GDIKBATIB");
    }

    private void addGDikKuzeyBRadioButtonActionCommand(){
        gui.setGDikKuzeyBRadioButtonActionCommand("GDIKKUZEYB");
    }

    private void addGDikGuneyBRadioButtonActionCommand(){
        gui.setGDikGuneyBRadioButtonActionCommand("GDIKGUNEYB");
    }
    
    private void addGDikDoguBRadioButtonActionListener(){
        gui.addGDikDoguBRadioButtonActionListener(getTS825RadioButtonActionListener());
    }
    
    private void addGDikBatiBRadioButtonActionListener(){
        gui.addGDikBatiBRadioButtonActionListener(getTS825RadioButtonActionListener());
    }

    private void addGDikKuzeyBRadioButtonActionListener(){
        gui.addGDikKuzeyBRadioButtonActionListener(getTS825RadioButtonActionListener());
    }

    private void addGDikGuneyBRadioButtonActionListener(){
        gui.addGDikGuneyBRadioButtonActionListener(getTS825RadioButtonActionListener());
    }
    
    private void addGDikDoguORadioButtonActionCommand(){
        gui.setGDikDoguORadioButtonActionCommand("GDIKDOGUO");
    }
    
    private void addGDikBatiORadioButtonActionCommand(){
        gui.setGDikBatiORadioButtonActionCommand("GDIKBATIO");
    }

    private void addGDikKuzeyORadioButtonActionCommand(){
        gui.setGDikKuzeyORadioButtonActionCommand("GDIKKUZEYO");
    }

    private void addGDikGuneyORadioButtonActionCommand(){
        gui.setGDikGuneyORadioButtonActionCommand("GDIKGUNEYO");
    }
    
    private void addGDikDoguORadioButtonActionListener(){
        gui.addGDikDoguORadioButtonActionListener(getTS825RadioButtonActionListener());
    }
    
    private void addGDikBatiORadioButtonActionListener(){
        gui.addGDikBatiORadioButtonActionListener(getTS825RadioButtonActionListener());
    }

    private void addGDikKuzeyORadioButtonActionListener(){
        gui.addGDikKuzeyORadioButtonActionListener(getTS825RadioButtonActionListener());
    }

    private void addGDikGuneyORadioButtonActionListener(){
        gui.addGDikGuneyORadioButtonActionListener(getTS825RadioButtonActionListener());
    }

    private void addGDikDoguKRadioButtonActionCommand(){
        gui.setGDikDoguKRadioButtonActionCommand("GDIKDOGUK");
    }
    
    private void addGDikBatiKRadioButtonActionCommand(){
        gui.setGDikBatiKRadioButtonActionCommand("GDIKBATIOK");
    }

    private void addGDikKuzeyKRadioButtonActionCommand(){
        gui.setGDikKuzeyKRadioButtonActionCommand("GDIKKUZEYK");
    }

    private void addGDikGuneyKRadioButtonActionCommand(){
        gui.setGDikGuneyKRadioButtonActionCommand("GDIKGUNEYK");
    }
    
    private void addGDikDoguKRadioButtonActionListener(){
        gui.addGDikDoguKRadioButtonActionListener(getTS825RadioButtonActionListener());
    }
    
    private void addGDikBatiKRadioButtonActionListener(){
        gui.addGDikBatiKRadioButtonActionListener(getTS825RadioButtonActionListener());
    }

    private void addGDikKuzeyKRadioButtonActionListener(){
        gui.addGDikKuzeyKRadioButtonActionListener(getTS825RadioButtonActionListener());
    }

    private void addGDikGuneyKRadioButtonActionListener(){
        gui.addGDikGuneyKRadioButtonActionListener(getTS825RadioButtonActionListener());
    }

    private void updateGunesEnerjisiKazanci(){
        gui.setToplamGunesEnerjisiTextFieldText(""+twoDigits.format(bina.hesaplaGunesEnerjisiKazanci()));
        updateInterface();
    }

    public void addDisDuvarPanelYogusmaButtonListener(){
        gui.addDisDuvarPanelYogusmaButtonListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
			    String identifier = gui.getDisDuvarListSelectedValue();
			    BilesikYapiElemani selectedEleman = (BilesikYapiElemani)bina.getYapiElemani(identifier);
				yogusmaDialog = new YogusmaDialog(selectedEleman);				
				SwingUtils.centerAndShowComponent(yogusmaDialog);
				yogusmaDialog.updateSelf();
			}
		});
    } 
    
    public void addUzeriAcikTavanYogusmaButtonActionListener(){
    	gui.addUzeriAcikTavanYogusmaButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BilesikYapiElemani selectedEleman = (BilesikYapiElemani)bina.getYapiElemani("UzeriAcik");
				yogusmaDialog = new YogusmaDialog(selectedEleman);				
				SwingUtils.centerAndShowComponent(yogusmaDialog);
				yogusmaDialog.updateSelf();				
			}
    	});
    }
    
    public void addCatiliTavanYogusmaButtonActionListener(){
    	gui.addCatiliTavanYogusmaButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BilesikYapiElemani selectedEleman = (BilesikYapiElemani)bina.getYapiElemani("Catili");
				yogusmaDialog = new YogusmaDialog(selectedEleman);				
				SwingUtils.centerAndShowComponent(yogusmaDialog);
				yogusmaDialog.updateSelf();				
			}
    	});
    }

    public void addAcikGecitUzeriYogusmaButtonActionListener(){
    	gui.addAcikGecitUzeriYogusmaButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BilesikYapiElemani selectedEleman = (BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri");
				yogusmaDialog = new YogusmaDialog(selectedEleman);				
				SwingUtils.centerAndShowComponent(yogusmaDialog);
				yogusmaDialog.updateSelf();								
			}
    	});
    }


    //Save & Load
    
    private void addBinaKonumBilgileriComponentShownListener() {
        gui.addBinaKonumBilgileriComponentShownListener(new ComponentAdapter(){
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);                
                if(bina.getEnerjiKullanimKatsayisi()==5) gui.setKonutRadioButtonSelected(true);
                if(bina.getEnerjiKullanimKatsayisi()==10) gui.setEnerjiRadioButtonSelected(true);
                if(bina.getOdaYuksekligi()==2.6) gui.setEsit26RadioButtonSelected(true);
                if(bina.getOdaYuksekligi()==3) gui.setYuksek26RadioButtonSelected(true);
                if(bina.getGolgelenmeFaktoru()==0.8) gui.setAyrikRadioButtonSelected(true);
                if(bina.getGolgelenmeFaktoru()==0.6) gui.setMahfuzRadioButtonSelected(true);
                if(bina.getGolgelenmeFaktoru()==0.5) gui.setBitisikRadioButtonSelected(true);
                if(bina.getHavalandirma() instanceof DogalHavalandirma) gui.setDogalRadioButtonSelected(true);
                if(bina.getHavalandirma() instanceof MekanikHavalandirma) gui.setMekanikRadioButtonSelected(true);
            }
        });
    }

	private void addOzgulIsiKaybiComponentShownListener() {
	    gui.addOzgulIsiKaybiComponentShownListener(new ComponentAdapter(){
            public void componentShown(ComponentEvent e) {                
                super.componentShown(e);
                if(!loaded){
                    loadBinaModeliOnLoad();   
                }
                loaded = true;
            }
	    });
    }

	private void loadBinaModeliOnLoad(){
        Iterator it = bina.getYapiElemanlari().iterator();
        while(it.hasNext()){
            IsiKaybeden yapiElemani = (IsiKaybeden) it.next();
            if(yapiElemani instanceof DisaAcikDuvar){
				disDuvarSayisi++;
				DefaultListModel listModel = gui.getDisDuvarlarListModel();
				String identifier = ""+disDuvarSayisi+". dýþ duvar";
				listModel.addElement(identifier);
				setDisDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani(identifier));
				gui.setDisDuvarModelTableColumnWidths();
				gui.setDisDuvarSelectedElement(identifier);
            }
            if(yapiElemani instanceof BinaDuvari){
            	if(((BinaDuvari)yapiElemani).getIsiGecirgenligi() instanceof DIsitilmayan){
            	    setIsitilmayanDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan"));
            	    gui.setIsitilmayanDuvarAlanTextFieldText(""+((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan")).getAlan());
            	    gui.setIsitilmayanDuvarUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("Isitilmayan")).getIsiGecirgenlikKatsayisi()));
            	}
          		if(((BinaDuvari)yapiElemani).getIsiGecirgenligi() instanceof DTopragaTemasli){
                	setTopragaTemasliDuvarTableModel((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli"));
                	gui.setTopragaTemasliDuvarAlanTextFieldText(""+((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli")).getAlan());
                	gui.setTopragaTemasliDuvarUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("DTopragaTemasli")).getIsiGecirgenlikKatsayisi()));					
            	}
                if(((BinaDuvari)yapiElemani).getIsiGecirgenligi() instanceof UzeriAcik){
    				setUzeriAcikTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik"));
    				gui.setUzeriAcikTavanAlanTextFieldText(""+((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik")).getAlan());
    				gui.setUzeriAcikTavanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("UzeriAcik")).getIsiGecirgenlikKatsayisi()));
                }
                if(((BinaDuvari)yapiElemani).getIsiGecirgenligi() instanceof Catili){
    				setCatiliTavanTableModel((BilesikYapiElemani)bina.getYapiElemani("Catili"));
    				gui.setCatiliTavanAlanTextFieldText(""+((BilesikYapiElemani)bina.getYapiElemani("Catili")).getAlan());
    				gui.setCatiliTavanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("Catili")).hesaplaIsiGecirgenlikDirenci()));
                }
                if(((BinaDuvari)yapiElemani).getIsiGecirgenligi() instanceof TTopragaTemasli){
    				setTopragaTemasliTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli"));
    				gui.setTopragaTemasliTabanAlanTextFieldText(""+((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli")).getAlan());
    				gui.setTopragaTemasliTabanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("TTopragaTemasli")).hesaplaIsiGecirgenlikDirenci()));
                }
                if(((BinaDuvari)yapiElemani).getIsiGecirgenligi() instanceof TIsitilmayan){
					setIsitilmayanTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan"));
					gui.setIsitilmayanTabanAlanTextFieldText(""+((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan")).getAlan());
					gui.setIsitilmayanTabanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("TIsitilmayan")).hesaplaIsiGecirgenlikDirenci()));
                }
                if(((BinaDuvari)yapiElemani).getIsiGecirgenligi() instanceof AcikGecitUzeri){
					setAcikGecitUzeriTabanTableModel((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri"));
					gui.setAcikGecitUzeriTabanAlanTextFieldText(""+((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri")).getAlan());
					gui.setAcikGecitUzeriTabanUTextFieldText(""+twoDigits.format(((BilesikYapiElemani)bina.getYapiElemani("AcikGecitUzeri")).hesaplaIsiGecirgenlikDirenci()));
                }
            }
            if(yapiElemani instanceof Pencere){
                Pencere pencere = (Pencere)yapiElemani;
                gui.setPencereAlaniTextFieldText(pencere.getAlan());
                gui.setPencereUDegeriTextFieldText(pencere.getIsiGecirgenlikKatsayisi());
            }
        }
	}

	private void addYillikIsitmaIhtiyaciPanelComponentShownListener() {
	    gui.addYillikIsitmaIhtiyaciPanelComponentShownListener(new ComponentAdapter(){
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
        	    gui.setToplamAlanTextFieldText(bina.hesaplaToplamAlan());
        	    gui.setBrutHacimTextFieldText(""+bina.getBrutHacim());
        	    gui.setAlanHacimOraniTextFieldText(twoDigits.format(bina.hesaplaToplamAlanBrutHacimOrani()));
        	    gui.setIcOrtamSicakligiTextFieldText(""+bina.getIcSicaklik());
        	    gui.setIletimselOzgulIsiKaybiTextFieldText(twoDigits.format(bina.hesaplaOzgulIletimselIsiKaybi()));
        	    if(bina.getHavalandirma()!=null){
        	        gui.setHavaDegisimKatsayisiTextFieldText(twoDigits.format(bina.getHavalandirma().getHavaDegisimSayisi()));
        	        gui.setHavalandirmaOzgulIsiKaybiTextFieldText(bina.hesaplaHavalandirmaOzgulIsiKaybi());
        	        gui.setToplamOzgulIsiKaybiTextFieldText(twoDigits.format(bina.hesaplaToplamOzgulIsiKaybi()));
        	    }	    
        	    
        	    double qYil = 0;
        		double Q = bina.hesaplaToplamYillikIsitmaEnerjisiIhtiyaci()/1000000*0.278;
        		if(bina.getOdaYuksekligi()<=2.6) qYil = (Q / bina.getBinaKullanimAlani()); 
        		if(bina.getOdaYuksekligi()>2.6) qYil = (Q / bina.getBrutHacim());
        	    gui.setQtextFieldText(twoDigits.format(qYil));
        	    gui.setStandartQTextFieldText(twoDigits.format(bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci()));
                if(qYil < bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci()){
                	gui.setStandartaUygunlukTextFieldColor(Color.BLACK);
                	gui.setStandartaUygunlukTextFieldText("Bina için yapýlmýþ ýsý yalýtým projesi standarta uygundur.");
                }
                else{
                	gui.setStandartaUygunlukTextFieldText("Bina için yapýlmýþ ýsý yalýtým projesi standarta uymuyor.");
                	gui.setStandartaUygunlukTextFieldColor(Color.RED);
                }
            	double doguDegeri = bina.getYoneGoreGunesEnerjisiKazanci("DOGU").getGunesEnerjisiGecirmeFaktoru();
            	double batiDegeri = bina.getYoneGoreGunesEnerjisiKazanci("BATI").getGunesEnerjisiGecirmeFaktoru();
            	double kuzeyDegeri = bina.getYoneGoreGunesEnerjisiKazanci("KUZEY").getGunesEnerjisiGecirmeFaktoru();
            	double guneyDegeri = bina.getYoneGoreGunesEnerjisiKazanci("GUNEY").getGunesEnerjisiGecirmeFaktoru();
            	if(doguDegeri==0.85) gui.setGDikDoguBRadioButtonSelected();
            	if(doguDegeri==0.75) gui.setGDikDoguORadioButtonSelected();
            	if(doguDegeri==0.50) gui.setGDikDoguKRadioButtonSelected();
                if(batiDegeri==0.85) gui.setGDikBatiBRadioButtonSelected();
                if(batiDegeri==0.75) gui.setGDikBatiORadioButtonSelected();
                if(batiDegeri==0.50) gui.setGDikBatiKRadioButtonSelected();
                if(kuzeyDegeri==0.85) gui.setGDikKuzeyBRadioButtonSelected();
                if(kuzeyDegeri==0.75) gui.setGDikKuzeyORadioButtonSelected();
                if(kuzeyDegeri==0.50) gui.setGDikKuzeyKRadioButtonSelected();
                if(guneyDegeri==0.85) gui.setGDikGuneyBRadioButtonSelected();
                if(guneyDegeri==0.75) gui.setGDikGuneyORadioButtonSelected();
                if(guneyDegeri==0.50) gui.setGDikGuneyKRadioButtonSelected();                

                gui.setToplamGunesEnerjisiTextFieldText(twoDigits.format(bina.hesaplaGunesEnerjisiKazanci()));
                gui.setBinaKullanimAlaniTextFieldText(bina.getBinaKullanimAlani());
                gui.setToplamPencereAlaniTextFieldText(twoDigits.format(bina.getToplamPencereAlani()));                
            }
	    });
    }

}
