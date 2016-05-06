/*
 * Created on 09.Oca.2005
 *
 */
package com.iztek.dd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;

import com.iztek.dd.GUI.IcSicaklikSecimiDialog;
import com.iztek.dd.GUI.IsitilmayanBolgeSicakligiSecimiDialog;
import com.iztek.dd.GUI.ProjectGUI;
import com.iztek.dd.GUI.ddtree.BinaTreeModel;
import com.iztek.dd.GUI.ddtree.MyRenderer;
import com.iztek.dd.GUI.ddtree.item.TreeItemInt;
import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKaybi.IsitilmayanBolgeSicakliklari;
import com.iztek.dd.IsiKaybi.domain.Bina;
import com.iztek.dd.IsiKaybi.domain.DuvarYapiElemani;
import com.iztek.dd.IsiKaybi.domain.KapiYapiElemani;
import com.iztek.dd.IsiKaybi.domain.Kat;
import com.iztek.dd.IsiKaybi.domain.KirisYapiElemani;
import com.iztek.dd.IsiKaybi.domain.KolonYapiElemani;
import com.iztek.dd.IsiKaybi.domain.Mahal;
import com.iztek.dd.IsiKaybi.domain.PencereYapiElemani;
import com.iztek.dd.IsiKaybi.domain.Radyator;
import com.iztek.dd.utilities.EventBroker;

/**
 * @author Selim HENDRICKSON
 *
 */
public class DDTreeController {
    BinaTreeModel treeModel = null;
    ProjectGUI gui = null;
    Bina bina = null;
    IcSicaklikSecimiDialog icSicaklikSecimiDialog = null;
    IsitilmayanBolgeSicakligiSecimiDialog isitilmayanBolgeSicakligiSecimiDialog = null;
    TreeItemInt copiedObject = null;
    
    
    public DDTreeController(ProjectGUI gui,Bina bina){        
        this.gui = gui;
        this.bina = bina;
        addDDTreePanelTreeSelectionListener();
        setDdTreePanelBinaTreeModel();
        setDdTreePanelBinaTreeRenderer();
        setDdTreePanelBinaTreeMouseListener();
    }


    /********************************************************************************************************
     * INIT METHODS
     ********************************************************************************************************/

	public void addDDTreePanelTreeSelectionListener(){
	    gui.addDDTreePanelTreeSelectionListener(ddTreePanelTreeSelectionListener);
	}

	public void setDdTreePanelBinaTreeModel(){
	    gui.setDdTreePanelBinaTreeModel((TreeModel)getCustomBinaTreeModel());
	  }

    public void setDdTreePanelBinaTreeRenderer(){
        gui.setDdTreePanelBinaTreeRenderer(new MyRenderer());
    }

    public void setDdTreePanelBinaTreeMouseListener(){
        gui.setDdTreePanelBinaTreemouseListener(popupListener);
    }

    /********************************************************************************************************
     * LISTENERS
     ********************************************************************************************************/
    
	TreeSelectionListener ddTreePanelTreeSelectionListener = new TreeSelectionListener(){
        public void valueChanged(TreeSelectionEvent arg0) {			
			TreeItemInt treeItem = (TreeItemInt)getDDTreeLastSelectedPathComponent();
 			if (treeItem == null) {
				return;
			} else {
				String panelIdentifier = treeItem.getItemName();
				showDdTreeCardLayoutPanelSelectedPanel(panelIdentifier);
				return;
			}	
        }

	};
	
	ActionListener treeItemActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem) e.getSource();
			TreeItemInt parentItem = (TreeItemInt)getDDTreeLastSelectedPathComponent();
			int choice = Integer.parseInt(e.getActionCommand());
			switch (choice) {
			case 1:
			    String type = parentItem.getItemName();
			    if(type=="Kat"){
			        Kat kat = (Kat) parentItem ;
			        kat.getBina().removeKat(kat);
			    }
			    if(type=="Mahal"){
			        Mahal mahal = (Mahal) parentItem;
			        mahal.getKat().removeMahal(mahal);
			    }
			    if(type=="Duvar/Döþeme/Tavan"){
			        DuvarYapiElemani duvar = (DuvarYapiElemani) parentItem;
			        duvar.getMahal().removeYapiElemani(duvar);
			    }
			    if(type=="Pencere"){
			        PencereYapiElemani pencere = (PencereYapiElemani) parentItem;
			        pencere.getOwningDuvar().removeYapiElemani(pencere);
			    }
			    if(type=="Kapý"){
			        KapiYapiElemani kapi = (KapiYapiElemani) parentItem;
			        kapi.getOwningDuvar().removeYapiElemani(kapi);
			    }
			    if(type=="Kolon"){
			        KolonYapiElemani kolon = (KolonYapiElemani) parentItem;
			        DuvarYapiElemani duvar = (DuvarYapiElemani)kolon.getParent(); 
			        duvar.removeChild(kolon);
			    }
			    if(type=="Kiriþ"){
			        KirisYapiElemani kiris = (KirisYapiElemani) parentItem;
			        kiris.getOwningDuvar().removeYapiElemani(kiris);
			    }
				break;
			case 2:
				copiedObject = parentItem.cloneSelf();				
				break;
			case 3:				
				if(copiedObject!=null){
					if(((TreeItemInt)copiedObject).getItemName()==parentItem.getItemName()){
						parentItem.loadSelf(copiedObject);
						copiedObject = null;
					}				
					else SwingUtils.errorMessage(((TreeItemInt)copiedObject).getItemName()+" tipinde bir elemaný "+parentItem.getItemName()+" tipinde bir elemana kopyalayamazsýnýz!");					
				}
				else SwingUtils.infoMessage("Lütfen önce yapýþtýrmak istediðiniz katý kopyalayýnýz.");
				break;
			default:
				buildBina(parentItem,source.getText());
				break;
			}
			treeModel.fireTreeStructureChanged();
        	gui.expandAll();
		}
	};

	public void treeUpdate(){
		treeModel.fireTreeStructureChanged();
    	gui.expandAll();
	}
	
	MouseAdapter popupListener = new MouseAdapter(){
    	public void mousePressed(MouseEvent e) {
    		maybeShowPopup(e);
    	}

    	public void mouseReleased(MouseEvent e) {
    		maybeShowPopup(e);
    	}

    	private void maybeShowPopup(MouseEvent e) {
    		if (e.isPopupTrigger()) {
    		    if(getDDTreeLastSelectedPathComponent()!=null) preparePopup().show(e.getComponent(), e.getX(), e.getY());
    		}
    	}
	    
	};

	ActionListener isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener = new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
            String command = arg0.getActionCommand();
            if(command=="KucukU") isitilmayanBolgeSicakligiSecimiDialog.setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+bina.getDisSicaklik()).getUKucuk());
        }
	};
	
    /********************************************************************************************************
     * PANEL LISTENERS
     ********************************************************************************************************/

//	// Duvar listeners
//	
//	KeyListener duvarTreeItemPanelIsaretTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    TemelYapiElemani selectedDuvar = (TemelYapiElemani)selectedItem.getDomainObject();
//    	    DuvarTreeItemPanel selectedPanel = (DuvarTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedDuvar.setYapiElemaniAdi(selectedPanel.getIsaretTextFieldText());
//        }
//	};
//
//	KeyListener duvarTreeItemPanelUzunlukTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    TemelYapiElemani selectedDuvar = (TemelYapiElemani)selectedItem.getDomainObject();
//    	    DuvarTreeItemPanel selectedPanel = (DuvarTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedDuvar.setUzunluk(selectedPanel.getUzunlukTextFieldText());
//        }
//	};
//
//	KeyListener duvarTreeItemPanelKalinlikTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    TemelYapiElemani selectedDuvar = (TemelYapiElemani)selectedItem.getDomainObject();
//    	    DuvarTreeItemPanel selectedPanel = (DuvarTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedDuvar.setKalinlik(selectedPanel.getKalinlikTextFieldText());
//        }
//	}; 
//
//	KeyListener duvarTreeItemPanelYukseklikGenislikTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    TemelYapiElemani selectedDuvar = (TemelYapiElemani)selectedItem.getDomainObject();
//    	    DuvarTreeItemPanel selectedPanel = (DuvarTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedDuvar.setYukseklik(selectedPanel.getYukseklikGenislikTextFieldText());
//        }
//	}; 
//
//	KeyListener duvarTreeItemPanelKDegeriTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    TemelYapiElemani selectedDuvar = (TemelYapiElemani)selectedItem.getDomainObject();
//    	    DuvarTreeItemPanel selectedPanel = (DuvarTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedDuvar.setIsiGecirgenlikKatsayisi(selectedPanel.getKDegeriTextFieldText());
//        }
//	}; 
//
//	KeyListener duvarTreeItemPanelIcOrtamSicakligiTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    TemelYapiElemani selectedDuvar = (TemelYapiElemani)selectedItem.getDomainObject();
//    	    DuvarTreeItemPanel selectedPanel = (DuvarTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedDuvar.setIcSicaklik(selectedPanel.getýcOrtamSicakligiTextFieldText());
//        }
//	}; 
//
//	KeyListener duvarTreeItemPanelDisOrtamSicakligiTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    TemelYapiElemani selectedDuvar = (TemelYapiElemani)selectedItem.getDomainObject();
//    	    DuvarTreeItemPanel selectedPanel = (DuvarTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedDuvar.setDisSicaklik(selectedPanel.getDisOrtamSicakligiTextFieldText());
//        }
//	};

//	ActionListener duvarRadioButtonActionListener = new ActionListener(){
//        public void actionPerformed(ActionEvent arg0) {
//            String actionCommand = arg0.getActionCommand();
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    TemelYapiElemani selectedDuvar = (TemelYapiElemani)selectedItem.getDomainObject();
//    	    DuvarTreeItemPanel selectedPanel = (DuvarTreeItemPanel)selectedItem.getItemPanel();        	    
//            if(actionCommand.equals("Dýs")){
//            	selectedPanel.setIsaretTextFieldEnabled(false);
//                selectedPanel.setButtonsEnabled(false);
//                selectedPanel.setComboBoxEnabled(true);
//                double disSicaklik = 0;
//                Il il = bina.getProje().getIl();
//                if(il!=null) disSicaklik = il.getIsiKaybiDisSicaklik();
//                selectedDuvar.setDisSicaklik(disSicaklik);
//                selectedPanel.setDisOrtamSicakligiTextFieldText(""+disSicaklik);
//                YapiElemani eleman = bina.getProje().getCogunluklaKullanilanDisDuvar();
//                if(eleman!=null){
//                    selectedPanel.setKDegeriTextFieldText(eleman.getIsiGecirgenlikKatsayisi());
//                    selectedPanel.setIsaretTextFieldText(eleman.getYapiElemaniKodu());
//                    selectedPanel.setKDegeriTextFieldEnabled(false);
//                    selectedDuvar.setIsiGecirgenlikKatsayisi(eleman.getIsiGecirgenlikKatsayisi());
//                }
//                else{
//                    selectedPanel.setKDegeriTextFieldText(0);
//                    selectedPanel.setIsaretTextFieldText("");                                        
//                }
//            }
//            if(actionCommand.equals("Ic")){
//            	selectedPanel.setIsaretTextFieldEnabled(false);
//                selectedPanel.setButtonsEnabled(true);
//                selectedPanel.setComboBoxEnabled(true);
//                YapiElemani eleman = bina.getProje().getCogunluklaKullanilanIcDuvar();
//                selectedPanel.setDisOrtamSicakligiTextFieldText("");
//                if(eleman!=null){
//                    selectedPanel.setKDegeriTextFieldText(eleman.getIsiGecirgenlikKatsayisi());
//                    selectedPanel.setIsaretTextFieldText(eleman.getYapiElemaniKodu());
//                    selectedPanel.setKDegeriTextFieldEnabled(false);
//                    selectedDuvar.setIsiGecirgenlikKatsayisi(eleman.getIsiGecirgenlikKatsayisi());
//                }
//                else{
//                    selectedPanel.setKDegeriTextFieldText(0);
//                    selectedPanel.setIsaretTextFieldText("");                                        
//                }
//            }
//            if(actionCommand.equals("Doseme")){
//            	selectedPanel.setIsaretTextFieldEnabled(true);
//                selectedPanel.setButtonsEnabled(true);
//                selectedPanel.setKDegeriTextFieldEnabled(true);
//                selectedPanel.setComboBoxEnabled(false);
//            }
//        }
//	};
//	
//	ActionListener duvarComboBoxActionListener = new ActionListener(){
//	    public void actionPerformed(ActionEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    TemelYapiElemani selectedDuvar = (TemelYapiElemani)selectedItem.getDomainObject();
//
//	        JComboBox cb = (JComboBox)arg0.getSource();
//	        String yon = (String)cb.getSelectedItem();
//	        if(yon.equals("Kuzey")) selectedDuvar.setYon("K");
//	        if(yon.equals("Güney")) selectedDuvar.setYon("G");   
//	        if(yon.equals("Doðu")) selectedDuvar.setYon("D");
//	        if(yon.equals("Batý")) selectedDuvar.setYon("B");
//	        if(yon.equals("Kuzeydoðu")) selectedDuvar.setYon("KD");
//	        if(yon.equals("Kuzeybatý")) selectedDuvar.setYon("KB");
//	        if(yon.equals("Güneydoðu")) selectedDuvar.setYon("GD");
//	        if(yon.equals("Güneybatý")) selectedDuvar.setYon("GB");
//	    }  
//	};
//
//	
//	//Kapý listeners
//	
//	KeyListener kapiTreeItemPanelIsaretTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedKapi = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    KapiTreeItemPanel selectedPanel = (KapiTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKapi.setYapiElemaniAdi(selectedPanel.getIsaretTextFieldText());
//        }
//	};
//
//	KeyListener kapiTreeItemPanelUzunlukTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedKapi = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    KapiTreeItemPanel selectedPanel = (KapiTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKapi.setUzunluk(selectedPanel.getUzunlukTextFieldText());
//        }
//	};
//
//	KeyListener kapiTreeItemPanelLUzunluguTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedKapi = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    KapiTreeItemPanel selectedPanel = (KapiTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKapi.setAcilanKisminUzunlugu(selectedPanel.getLUzunluguTextFieldText());
//        }
//	}; 
//
//	KeyListener kapiTreeItemPanelYukseklikGenislikTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedKapi = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    KapiTreeItemPanel selectedPanel = (KapiTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKapi.setYukseklik(selectedPanel.getYukseklikGenislikTextFieldText());
//        }
//	}; 
//
//	KeyListener kapiTreeItemPanelKDegeriTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedKapi = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    KapiTreeItemPanel selectedPanel = (KapiTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKapi.setIsiGecirgenlikKatsayisi(selectedPanel.getKDegeriTextFieldText());
//        }
//	}; 
//	
//	ActionListener kapiRadioButtonActionListener = new ActionListener(){
//        public void actionPerformed(ActionEvent arg0) {
//            String actionCommand = arg0.getActionCommand();
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedKapi = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    KapiTreeItemPanel selectedPanel = (KapiTreeItemPanel)selectedItem.getItemPanel();        	    
//            if(actionCommand.equals("Dýs")){
////                selectedPanel.setButtonsEnabled(false);
//                double disSicaklik = 0;
//                Il il = bina.getProje().getIl();
//                if(il!=null) disSicaklik = il.getIsiKaybiDisSicaklik();
//                selectedKapi.setDisSicaklik(disSicaklik);
////                selectedPanel.setDisOrtamSicakligiTextFieldText(""+disSicaklik);
//                YapiElemani eleman = bina.getProje().getCogunluklaKullanilanDisKapi();
//                if(eleman!=null){
//                    selectedPanel.setKDegeriTextFieldText(eleman.getIsiGecirgenlikKatsayisi());
//                    selectedPanel.setIsaretTextFieldText(eleman.getYapiElemaniKodu());
////                    selectedPanel.setKDegeriTextFieldEnabled(false);
//                    selectedKapi.setIsiGecirgenlikKatsayisi(eleman.getIsiGecirgenlikKatsayisi());
//                }
//                else{
//                    selectedPanel.setKDegeriTextFieldText(0);
//                    selectedPanel.setIsaretTextFieldText("");                                        
//                }
//            }
//            if(actionCommand.equals("Ic")){
////                selectedPanel.setButtonsEnabled(true);
//                YapiElemani eleman = bina.getProje().getCogunluklaKullanilanIcKapi();
////                selectedPanel.setDisOrtamSicakligiTextFieldText("");
//                if(eleman!=null){
//                    selectedPanel.setKDegeriTextFieldText(eleman.getIsiGecirgenlikKatsayisi());
//                    selectedPanel.setIsaretTextFieldText(eleman.getYapiElemaniKodu());
////                    selectedPanel.setKDegeriTextFieldEnabled(false);
//                    selectedKapi.setIsiGecirgenlikKatsayisi(eleman.getIsiGecirgenlikKatsayisi());
//                }
//                else{
//                    selectedPanel.setKDegeriTextFieldText(0);
//                    selectedPanel.setIsaretTextFieldText("");                                        
//                }
//            }
//            if(actionCommand.equals("Doseme")){
////                selectedPanel.setButtonsEnabled(true);
////                selectedPanel.setKDegeriTextFieldEnabled(true);
//                System.out.println("Döþeme");
//            }
//        }
//	};
//	
//	//Kiris listeners
//	
//	KeyListener kirisTreeItemPanelIsaretTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    BasitYapiElemani selectedKiris = (BasitYapiElemani)selectedItem.getDomainObject();
//    	    KirisTreeItemPanel selectedPanel = (KirisTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKiris.setYapiElemaniAdi(selectedPanel.getIsaretTextFieldText());
//        }
//	};
//
//	KeyListener kirisTreeItemPanelUzunlukTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    BasitYapiElemani selectedKiris = (BasitYapiElemani)selectedItem.getDomainObject();
//    	    KirisTreeItemPanel selectedPanel = (KirisTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKiris.setUzunluk(selectedPanel.getUzunlukTextFieldText());
//        }
//	};
//
//	KeyListener kirisTreeItemPanelYukseklikGenislikTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    BasitYapiElemani selectedKiris = (BasitYapiElemani)selectedItem.getDomainObject();
//    	    KirisTreeItemPanel selectedPanel = (KirisTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKiris.setYukseklik(selectedPanel.getYukseklikGenislikTextFieldText());
//        }
//	}; 
//
//	KeyListener kirisTreeItemPanelKDegeriTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    BasitYapiElemani selectedKiris = (BasitYapiElemani)selectedItem.getDomainObject();
//    	    KirisTreeItemPanel selectedPanel = (KirisTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKiris.setIsiGecirgenlikKatsayisi(selectedPanel.getKDegeriTextFieldText());
//        }
//	}; 
//	
//	//Kolon listeners
//	
//	KeyListener kolonTreeItemPanelIsaretTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    BasitYapiElemani selectedKolon = (BasitYapiElemani)selectedItem.getDomainObject();
//    	    KolonTreeItemPanel selectedPanel = (KolonTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKolon.setYapiElemaniAdi(selectedPanel.getIsaretTextFieldText());
//        }
//	};
//
//	KeyListener kolonTreeItemPanelUzunlukTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    BasitYapiElemani selectedKolon = (BasitYapiElemani)selectedItem.getDomainObject();
//    	    KolonTreeItemPanel selectedPanel = (KolonTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKolon.setUzunluk(selectedPanel.getUzunlukTextFieldText());
//        }
//	};
//
//	KeyListener kolonTreeItemPanelYukseklikGenislikTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    BasitYapiElemani selectedKolon = (BasitYapiElemani)selectedItem.getDomainObject();
//    	    KolonTreeItemPanel selectedPanel = (KolonTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKolon.setYukseklik(selectedPanel.getYukseklikGenislikTextFieldText());
//        }
//	}; 
//
//	KeyListener kolonTreeItemPanelKDegeriTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    BasitYapiElemani selectedKolon = (BasitYapiElemani)selectedItem.getDomainObject();
//    	    KolonTreeItemPanel selectedPanel = (KolonTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedKolon.setIsiGecirgenlikKatsayisi(selectedPanel.getKDegeriTextFieldText());
//        }
//	}; 
//
//	//Pencere listeners
//	
//	KeyListener pencereTreeItemPanelIsaretTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedPencere = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    PencereTreeItemPanel selectedPanel = (PencereTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedPencere.setYapiElemaniAdi(selectedPanel.getIsaretTextFieldText());
//        }
//	};
//
//	KeyListener pencereTreeItemPanelUzunlukTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedPencere = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    PencereTreeItemPanel selectedPanel = (PencereTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedPencere.setUzunluk(selectedPanel.getUzunlukTextFieldText());
//        }
//	};
//
//	KeyListener pencereTreeItemPanelLUzunluguTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedPencere = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    PencereTreeItemPanel selectedPanel = (PencereTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedPencere.setAcilanKisminUzunlugu(selectedPanel.getLUzunluguTextFieldText());
//        }
//	}; 
//
//	KeyListener pencereTreeItemPanelYukseklikGenislikTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedPencere = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    PencereTreeItemPanel selectedPanel = (PencereTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedPencere.setYukseklik(selectedPanel.getYukseklikGenislikTextFieldText());
//        }
//	}; 
//
//	KeyListener pencereTreeItemPanelKDegeriTextFieldKeylistener = new KeyAdapter(){
//        public void keyReleased(KeyEvent arg0) {
//    	    DefaultMutableTreeNode selectedNode = gui.getDDTreeLastSelectedPathComponent();
//    	    TreeItemInt selectedItem = (TreeItemInt)selectedNode.getUserObject();
//    	    SizintiliYapiElemani selectedPencere = (SizintiliYapiElemani)selectedItem.getDomainObject();
//    	    PencereTreeItemPanel selectedPanel = (PencereTreeItemPanel)selectedItem.getItemPanel();
//    	    selectedPencere.setIsiGecirgenlikKatsayisi(selectedPanel.getKDegeriTextFieldText());
//        }
//	}; 
//
//    /********************************************************************************************************
//     * UTILITY METHODS
//     ********************************************************************************************************/
//
    private Object getDDTreeLastSelectedPathComponent(){
        return gui.getDDTreeLastSelectedPathComponent();
    }

    public void showDdTreeCardLayoutPanelSelectedPanel(String identifier){
        gui.showDdTreeCardLayoutPanelSelectedPanel(identifier);
        EventBroker.getInstance().fireTreeItemSelectedEvent((TreeItemInt)getDDTreeLastSelectedPathComponent());
    }

	private JPopupMenu preparePopup() {
		TreeItemInt selectedNode = (TreeItemInt)getDDTreeLastSelectedPathComponent();
		String[] menuOptions = selectedNode.getMenuChoices();
		JPopupMenu customMenu = new JPopupMenu();
		for(int i=0;i<menuOptions.length;i++){
			JMenuItem menuItem = new JMenuItem(menuOptions[i]);
			menuItem.setActionCommand("0");
			menuItem.addActionListener(treeItemActionListener); 
			customMenu.add(menuItem);	
		}		
		if(selectedNode!=treeModel.getRoot()){
			customMenu.addSeparator();
			JMenuItem menuItem = new JMenuItem("Sil");
			menuItem.setActionCommand("1");
			menuItem.addActionListener(treeItemActionListener);
			customMenu.add(menuItem);
			JMenuItem menuItem2 = new JMenuItem("Kopyala");
			menuItem2.setActionCommand("2");
			menuItem2.addActionListener(treeItemActionListener);
			customMenu.add(menuItem2);
			JMenuItem menuItem3 = new JMenuItem("Yapýþtýr");
			menuItem3.setActionCommand("3");
			menuItem3.addActionListener(treeItemActionListener);
			customMenu.add(menuItem3);			
		}
		return customMenu;
	}

    protected void buildBina(TreeItemInt parentItem,String type) {
        if(type=="Kat"){
            int katYuksekligi = ((TreeItemInt)treeModel.getRoot()).getSubItemCount();
            bina.createKat(katYuksekligi);            
        }
        if(type=="Mahal"){
			Radyator commonRadyator = bina.getProje().getEnCokKullanilanRadyatorModeli();			
        	Mahal yeniMahal = ((Kat)parentItem).createMahal();
        	if(commonRadyator!=null) yeniMahal.setRadyatorModeli(commonRadyator.getModel());
        	else SwingUtils.errorMessage("Çok kullanýlan radyatör modelini seçmediniz!");
        }
        if(type=="Duvar/Döþeme/Tavan"){
        	DuvarYapiElemani duvar = ((Mahal)parentItem).createDuvar();
        	DuvarYapiElemani commonDuvar = (DuvarYapiElemani)bina.getProje().getCogunluklaKullanilanDisDuvar();
        	if(commonDuvar!=null)duvar.copyToSelf(commonDuvar);        	
        	else SwingUtils.errorMessage("Çok kullanýlan dýþ duvar tipini seçmediniz!");
        }
        if(type=="Kolon"){
            KolonYapiElemani kolon = ((DuvarYapiElemani)parentItem).createKolon();
        }
        if(type=="Kiriþ"){
            KirisYapiElemani kiris = ((DuvarYapiElemani)parentItem).createKiris();        
        }
        if(type=="Pencere"){
            PencereYapiElemani pencere = ((DuvarYapiElemani)parentItem).createPencere();
            PencereYapiElemani commonPencere = (PencereYapiElemani)bina.getProje().getCogunluklaKullanilanPencere();
            if(commonPencere!=null) pencere.copyToSelf(commonPencere);
            else SwingUtils.errorMessage("Çok kullanýlan pencere tipini seçmediniz!");
        }
        if(type=="Kapý"){
            KapiYapiElemani kapi = ((DuvarYapiElemani)parentItem).createKapi();
            KapiYapiElemani commonKapi = null; 
            if(((DuvarYapiElemani)parentItem).isIcDuvar())commonKapi = (KapiYapiElemani)bina.getProje().getCogunluklaKullanilanIcKapi();
            if(((DuvarYapiElemani)parentItem).isDisDuvar())commonKapi = (KapiYapiElemani)bina.getProje().getCogunluklaKullanilanDisKapi();
            if(commonKapi!=null)kapi.copyToSelf(commonKapi);
            else SwingUtils.errorMessage("Çok kullanýlan kapý tipini seçmediniz!");
        }
    }

//    protected void addMahalTreeItemPanelListeners(TreeItemPanel panel) {
//        MahalTreeItemPanel identifiedPanel = (MahalTreeItemPanel) panel;
//        identifiedPanel.addMahalKoduTextFieldFocusListener(mahalKoduTextFieldFocusListener);
//        identifiedPanel.addMahalKoduTextFieldKeyListener(mahalKoduTextFieldKeyListener);
//        identifiedPanel.addMahalAdiTextFieldFocusListener(mahalAdiTextFieldFocusListener);
//        identifiedPanel.addMahalAdiTextFieldKeyListener(mahalAdiTextFieldKeyListener);
//        identifiedPanel.addMahalIcSicakligiTextFieldFocusListener(mahalIcSicakligiTextFieldFocusListener);
//        identifiedPanel.addMahalIcSicakligiTextFieldKeyListener(mahalIcSicakligiTextFieldKeyListener);
//        identifiedPanel.addRadyatorGrupSayisiTextFieldFocusListener(radyatorGrupSayisiTextFieldFocusListener);
//        identifiedPanel.addRadyatorGrupSayisiTextFieldKeyListener(radyatorGrupSayisiTextFieldKeyListener);
//        identifiedPanel.addPencereAltiYuksekligiTextFieldFocusListener(pencereAltiYuksekligiTextFieldFocusListener);
//        identifiedPanel.addPencereAltiYuksekligiTextFieldKeyListener(pencereAltiYuksekligiTextFieldKeyListener);
//        identifiedPanel.addRadyatorModeliTextFieldFocusListener(radyatorModeliTextFieldFocusListener);
//        identifiedPanel.addRadyatorModeliTextFieldKeyListener(radyatorModeliTextFieldKeyListener);
//        identifiedPanel.addYonComboBoxActionListener(mahalComboBoxActionListener);
//        identifiedPanel.addMahalIcSicakligiSecButtonListener(getIcSicaklikModeliSecButtonListener());
//    }
//
//    protected void addDuvarTreeItemPanelListeners(TreeItemPanel panel){
//        DuvarTreeItemPanel identifiedPanel = (DuvarTreeItemPanel) panel;
//        identifiedPanel.addDuvarTreeItemPanelIsaretTextFieldKeylistener(duvarTreeItemPanelIsaretTextFieldKeylistener);
//        identifiedPanel.addDuvarTreeItemPanelUzunlukTextFieldKeylistener(duvarTreeItemPanelUzunlukTextFieldKeylistener);
//        identifiedPanel.addDuvarTreeItemPanelKalinlikTextFieldKeylistener(duvarTreeItemPanelKalinlikTextFieldKeylistener);
//        identifiedPanel.addDuvarTreeItemPanelYukseklikGenislikTextFieldKeylistener(duvarTreeItemPanelYukseklikGenislikTextFieldKeylistener);
//        identifiedPanel.addDuvarTreeItemPanelKDegeriTextFieldKeylistener(duvarTreeItemPanelKDegeriTextFieldKeylistener);
//        identifiedPanel.addDuvarTreeItemPanelIcOrtamSicakligiTextFieldKeylistener(duvarTreeItemPanelIcOrtamSicakligiTextFieldKeylistener);
//        identifiedPanel.addDuvarTreeItemPanelDisOrtamSicakligiTextFieldKeylistener(duvarTreeItemPanelDisOrtamSicakligiTextFieldKeylistener);
//        identifiedPanel.setDuvarTreeItemPanelDisDuvarRadioButtonActionCommand("Dýs");
//        identifiedPanel.addDuvarTreeItemPanelýcDuvarRadioButtonActionCommand("Ic");
//        identifiedPanel.addDuvarTreeItemPanelDosemeRadioButtonActionCommand("Doseme");
//        identifiedPanel.addDuvarTreeItemPanelDisDuvarRadioButtonActionListener(duvarRadioButtonActionListener);
//        identifiedPanel.addDuvarTreeItemPanelIcDuvarRadioButtonActionListener(duvarRadioButtonActionListener);
//        identifiedPanel.addDuvarTreeItemPanelDosemeRadioButtonActionListener(duvarRadioButtonActionListener);
//        identifiedPanel.addDuvarTreeItemPanelYonComboBoxActionListener(duvarComboBoxActionListener);
//        identifiedPanel.addDuvarDisSicakligiSecButtonListener(getIcSicaklikModeliSecButtonListener());
//        identifiedPanel.isitilmayanBolgeSicakligiSecButtonListener(getIsitilmayanBolgeSicakligiSecButtonListener());
//    }
//    
//    private void addKapiTreeItemPanelListeners(TreeItemPanel panel) {
//        KapiTreeItemPanel identifiedPanel = (KapiTreeItemPanel) panel;
//        identifiedPanel.addKapiTreeItemPanelIsaretTextFieldKeylistener(kapiTreeItemPanelIsaretTextFieldKeylistener);
//        identifiedPanel.addKapiTreeItemPanelUzunlukTextFieldKeylistener(kapiTreeItemPanelUzunlukTextFieldKeylistener);        
//        identifiedPanel.addKapiTreeItemPanelYukseklikGenislikTextFieldKeylistener(kapiTreeItemPanelYukseklikGenislikTextFieldKeylistener);
//        identifiedPanel.addKapiTreeItemPanelKDegeriTextFieldKeylistener(kapiTreeItemPanelKDegeriTextFieldKeylistener);
//        identifiedPanel.addKapiTreeItemPanelLUzunluguTextFieldKeylistener(kapiTreeItemPanelLUzunluguTextFieldKeylistener);
//    }
//
//    private void addKirisTreeItemPanelListeners(TreeItemPanel panel) {
//        KirisTreeItemPanel identifiedPanel = (KirisTreeItemPanel) panel;
//        identifiedPanel.addKirisTreeItemPanelIsaretTextFieldKeylistener(kirisTreeItemPanelIsaretTextFieldKeylistener);
//        identifiedPanel.addKirisTreeItemPanelUzunlukTextFieldKeylistener(kirisTreeItemPanelUzunlukTextFieldKeylistener);        
//        identifiedPanel.addKirisTreeItemPanelYukseklikGenislikTextFieldKeylistener(kirisTreeItemPanelYukseklikGenislikTextFieldKeylistener);
//        identifiedPanel.addKirisTreeItemPanelKDegeriTextFieldKeylistener(kirisTreeItemPanelKDegeriTextFieldKeylistener);
//    }
//    
//    private void addKolonTreeItemPanelListeners(TreeItemPanel panel) {
//        KolonTreeItemPanel identifiedPanel = (KolonTreeItemPanel) panel;
//        identifiedPanel.addKolonTreeItemPanelIsaretTextFieldKeylistener(kolonTreeItemPanelIsaretTextFieldKeylistener);
//        identifiedPanel.addKolonTreeItemPanelUzunlukTextFieldKeylistener(kolonTreeItemPanelUzunlukTextFieldKeylistener);        
//        identifiedPanel.addKolonTreeItemPanelYukseklikGenislikTextFieldKeylistener(kolonTreeItemPanelYukseklikGenislikTextFieldKeylistener);
//        identifiedPanel.addKolonTreeItemPanelKDegeriTextFieldKeylistener(kolonTreeItemPanelKDegeriTextFieldKeylistener);
//    }
//
//    private void addPencereTreeItemPanelListeners(TreeItemPanel panel) {
//        PencereTreeItemPanel identifiedPanel = (PencereTreeItemPanel) panel;
//        identifiedPanel.addPencereTreeItemPanelIsaretTextFieldKeylistener(pencereTreeItemPanelIsaretTextFieldKeylistener);
//        identifiedPanel.addPencereTreeItemPanelUzunlukTextFieldKeylistener(pencereTreeItemPanelUzunlukTextFieldKeylistener);        
//        identifiedPanel.addPencereTreeItemPanelYukseklikGenislikTextFieldKeylistener(pencereTreeItemPanelYukseklikGenislikTextFieldKeylistener);
//        identifiedPanel.addPencereTreeItemPanelKDegeriTextFieldKeylistener(pencereTreeItemPanelKDegeriTextFieldKeylistener);
//        identifiedPanel.addPencereTreeItemPanelLUzunluguTextFieldKeylistener(pencereTreeItemPanelLUzunluguTextFieldKeylistener);
//    }
    
    public TreeModel getCustomBinaTreeModel(){        
		treeModel = new BinaTreeModel(bina);
		
		return treeModel;
    }
    
//	private ActionListener getIcSicaklikModeliSecButtonListener() {
//		return new ActionListener(){			
//			public void actionPerformed(ActionEvent e) {
//				icSicaklikSecimiDialog = gui.showIcSicaklikSecimiDialog();
//				icSicaklikSecimiDialog.setIcSicaklikModelleriTableModel(new IcSicaklikSecimTableModel(IcSicakliklar.getInstance().getIcSicakliklar()));
//				addIcSicaklikSecimiDialogListeners();
//			}	
//		};
//	}

//    protected void addIcSicaklikSecimiDialogListeners() {
//        ActionListener secListener = new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int index = icSicaklikSecimiDialog.getIcSicaklikModelleriTableSelectedIndex();
//                if (index < 0)
//                    return;
//                IcSicaklikSecimTableModel model = (IcSicaklikSecimTableModel)icSicaklikSecimiDialog.getIcSicaklikModelleriTableModel();
//                List list = model.getIcSicaklikler();
//                if (index < list.size()){
//                    IcSicaklik icSicaklik = (IcSicaklik)list.get(index);
//                    TreeItemInt selectedItem = (TreeItemInt)getDDTreeLastSelectedPathComponent().getUserObject();
//                    TreeItemPanel selectedItemPanel = selectedItem.getItemPanel();
//                    if(selectedItem.getDomainObject() instanceof Mahal){
//                    	Mahal selectedDomainObject = (Mahal) selectedItem.getDomainObject();
//                    	MahalTreeItemPanel selectedMahalTreeItemPanel = (MahalTreeItemPanel) selectedItemPanel;
//                        selectedMahalTreeItemPanel.setIcSicaklikTextFieldText(icSicaklik.getSicaklik());
//                        selectedDomainObject.setIcSicaklik(icSicaklik.getSicaklik());
//                        selectedMahalTreeItemPanel.setMahalAdiTextFieldText(icSicaklik.getMahal());
//                        selectedDomainObject.setMahalAdi(icSicaklik.getMahal());
//                        icSicaklikSecimiDialog.setVisible(false);                    	
//                    }
//                    if(selectedItem.getDomainObject() instanceof TemelYapiElemani){
//                    	TemelYapiElemani selectedDomainObject = (TemelYapiElemani) selectedItem.getDomainObject();
//                    	DuvarTreeItemPanel selectedDuvarTreeItemPanel = (DuvarTreeItemPanel) selectedItemPanel;
//                        selectedDuvarTreeItemPanel.setDisSicaklikTextFieldText(icSicaklik.getSicaklik());
//                        selectedDomainObject.setDisSicaklik(icSicaklik.getSicaklik());
//                        icSicaklikSecimiDialog.setVisible(false);                    	
//                    }
//                }
//            }
//        };
//        icSicaklikSecimiDialog.addSecButtonListener(secListener);
//        
//        ActionListener icSicaklikTipListener = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//                JRadioButton button = (JRadioButton)e.getSource();
//                String actionCommand = button.getActionCommand();
//                String tip = actionCommand;
//	                Collection icSicaklikler = IcSicakliklar.getInstance().getIcSicakliklar();
//	                Collection filtered = null;
//	                if ( tip.equals("Hepsi"))
//	                    filtered = icSicaklikler;
//	                else
//	                    filtered = IcSicaklik.filterByTip(icSicaklikler, tip);
//	                
//	    			IcSicaklikSecimTableModel model = new IcSicaklikSecimTableModel(filtered);
//	    			icSicaklikSecimiDialog.setIcSicaklikModelleriTableModel(model);
//            }
//        };
//        icSicaklikSecimiDialog.addIcSicaklikTipListener(icSicaklikTipListener);
//    }
//
}
