/*
 * Created on 29.Ara.2004
 *
 */
package com.iztek.dd;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.iztek.dd.GUI.ProjectGUI;
import com.iztek.dd.domain.Proje;
import com.iztek.dd.utilities.BolgeBroker;
import com.iztek.dd.utilities.Il;
import com.iztek.dd.utilities.IllerBean;

/**
 * @author Selim HENDRICKSON
 *
 */
public class ProjectController {
	public ProjectGUI gui = null;
	public Proje proje = null;
	public TS825Controller ts825controller = null;
	public IsiKaybiController isiKaybiController = null;
	public IsiKazanciController isiKazanciController = null;
		
	public ProjectController(ProjectGUI gui, Proje proje){
		this.gui = gui;
		this.proje = proje;
		ts825controller = new TS825Controller(gui,proje);
		isiKaybiController = new IsiKaybiController(gui,proje);
		isiKazanciController = new IsiKazanciController(gui,proje);
		
		addProjeAdiTextFieldFocusListener();
		addMuhendisUnvanTextFieldFocusListener();
		addMuhendisAdTextFieldFocusListener();
		addMuhendisSicilTextFieldFocusListener();
		addAdaParselTextFieldFocusListener();
		addBinaTanimTextFieldFocusListener();
		addCaddeTextFieldFocusListener();
		addIlIlceTextFieldFocusListener();
		addYakitTextFieldFocusListener();
		setIllerListModel();
		addHaritaLabelMouseListener();
		addIllerListeSelectionListener();
		
		
		//Save & Load
		addProjePanelComponentShownListener();
		addBolgePanelComponentShownListener();
	}

    private void setIllerListModel() {
        IllerBean illerBean = IllerBean.getInstance();
        DefaultListModel illerListModel = new DefaultListModel();
        Iterator it = illerBean.getIller().iterator();
        while(it.hasNext()){
            illerListModel.addElement(it.next());
        }
        gui.setIllerListModel(illerListModel);
    }

    public void addProjeAdiTextFieldFocusListener(){
		gui.addProjeAdiTextFieldFocusListener(new java.awt.event.FocusAdapter() { 
	    	public void focusLost(java.awt.event.FocusEvent e) {    
	    		proje.setProjeAdi(gui.getProjeAdiTextFieldText());
	    	}
	    });
	}
	
	public void addMuhendisUnvanTextFieldFocusListener(){
		gui.addMuhendisUnvanTextFieldFocusListener(new java.awt.event.FocusAdapter() { 
	    	public void focusLost(java.awt.event.FocusEvent e) {    
	    		proje.setProjeMuhendisiUnvani(gui.getMuhendisUnvanTextFieldText());
	    	}
	    });
	}

	public void addMuhendisAdTextFieldFocusListener(){
		gui.addMuhendisAdTextFieldFocusListener(new java.awt.event.FocusAdapter() { 
	    	public void focusLost(java.awt.event.FocusEvent e) {    
	    		proje.setProjeMuhendisiAdiSoyadi(gui.getMuhendisAdTextFieldText());
	    	}
	    });
	}
	
	public void addMuhendisSicilTextFieldFocusListener(){
		gui.addMuhendisSicilTextFieldFocusListener(new java.awt.event.FocusAdapter() { 
	    	public void focusLost(java.awt.event.FocusEvent e) {    
	    		proje.setProjeMuhendisiSicilNo(gui.getMuhendisSicilTextFieldText());
	    	}
	    });
	}

	public void addAdaParselTextFieldFocusListener(){
		gui.addAdaParselTextFieldFocusListener(new java.awt.event.FocusAdapter() { 
	    	public void focusLost(java.awt.event.FocusEvent e) {    
	    		proje.setAdaParsel(gui.getAdaParselTextFieldText());
	    	}
	    });
	}
	
	public void addBinaTanimTextFieldFocusListener(){
		gui.addBinaTanimTextFieldFocusListener(new java.awt.event.FocusAdapter() { 
	    	public void focusLost(java.awt.event.FocusEvent e) {    
	    		proje.setBinaTanim(gui.getBinaTanimTextFieldText());
	    	}
	    });
	}
	
	public void addCaddeTextFieldFocusListener(){
		gui.addCaddeTextFieldFocusListener(new java.awt.event.FocusAdapter() { 
	    	public void focusLost(java.awt.event.FocusEvent e) {    
	    		proje.setCaddeBinaNumarasi(gui.getCaddeTextFieldText());
	    	}
	    });
	}
	
	public void addIlIlceTextFieldFocusListener(){
		gui.addIlIlceTextFieldFocusListener(new java.awt.event.FocusAdapter() { 
	    	public void focusLost(java.awt.event.FocusEvent e) {    
	    		proje.setSemtÝlceÝl(gui.getIlIlceTextFieldText());
	    	}
	    });
	}
	
	public void addYakitTextFieldFocusListener(){
		gui.addYakitTextFieldFocusListener(new java.awt.event.FocusAdapter() { 
	    	public void focusLost(java.awt.event.FocusEvent e) {    
	    		proje.setYakitTuru(gui.getYakitTextFieldText());
	    	}
	    });
	}
	
	public void addHaritaLabelMouseListener(){
	    gui.addHaritaLabelMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e)
                {
                    Point2D konum = e.getPoint();
                    System.out.println(konum);
                    Il il = IllerBean.getInstance().getIl(konum);
                    if(il!=null){
                        gui.setIllerListSetSelected(il);
                        gui.setSecilenIlLabelText(il.getAd() + " - " + il.getBolge().getBolgeAdi() + ". Bölge - " + "TS 2164 dýþ sýcaklýk: " + il.getIsiKaybiDisSicaklik());
                        proje.setBolge(il.getBolge());
                        proje.setIl(il);
                        BolgeBroker.setActiveBolgeAdi(proje.getBolge().getBolgeAdi());					                        
                    }
                }

            });
	}
	
	public void addIllerListeSelectionListener(){
	    gui.addIllerListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent arg0) {
                Il il = (Il)((JList) arg0.getSource()).getSelectedValue();
                gui.setSecilenIlLabelText(il.getAd() + " - " + il.getBolge().getBolgeAdi() + ". Bölge - "  + "TS 2164 dýþ sýcaklýk: " + il.getIsiKaybiDisSicaklik());
                proje.setBolge(il.getBolge());
                proje.setIl(il);
                BolgeBroker.setActiveBolgeAdi(proje.getBolge().getBolgeAdi());
            }
	    });
	}
	
	public void setProje(Proje proje){
	    this.proje = proje;
	}

	//Save & Load
	
    private void addProjePanelComponentShownListener() {
        gui.addProjePanelComponentShownListener(new ComponentAdapter(){
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                gui.setProjeAdiTextFieldText(proje.getProjeAdi());
                gui.setMuhendisAdTextFieldText(proje.getProjeMuhendisiAdiSoyadi());
                gui.setMuhendisUnvanTextFieldText(proje.getProjeMuhendisiUnvani());
                gui.setMuhendisSicilTextFieldText(proje.getProjeMuhendisiSicilNo());
                gui.setAdaParselTextFieldText(proje.getAdaParsel());
                gui.setBinaTanimTextFieldText(proje.getBinaTanim());
                gui.setCaddeTextFieldText(proje.getCaddeBinaNumarasi());
                gui.setIlIlceTextFieldText(proje.getSemtÝlceÝl());
                gui.setYakitTextFieldText(proje.getYakitTuru());                
            }
        });
    }

    private void addBolgePanelComponentShownListener() {
        gui.addBolgePanelComponentShownListener(new ComponentAdapter(){
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                Il il = proje.getIl();
                if(il!=null){
                    Il listIl = IllerBean.getInstance().getIl(il.getAd());
                    gui.setIllerListSetSelected(listIl);
                    gui.setSecilenIlLabelText(il.getAd() + " - " + il.getBolge().getBolgeAdi() + ". Bölge - " + "TS 2164 dýþ sýcaklýk: " + il.getIsiKaybiDisSicaklik());                    
                }
            }
        });
    }

}
