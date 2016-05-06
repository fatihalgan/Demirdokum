/*
 * Created on 28.Ara.2004
 *
 */
package com.iztek.dd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import com.iztek.dd.GUI.AlfaDegerleriDialog;
import com.iztek.dd.GUI.GenelTanimlarDialog;
import com.iztek.dd.GUI.HakkindaDialog;
import com.iztek.dd.GUI.MainGUI;
import com.iztek.dd.GUI.MalzemeTanimlariDialog;
import com.iztek.dd.GUI.ProjectGUI;
import com.iztek.dd.GUI.UDegerleriDialog;
import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKazanci.domain.IsiKazanan;
import com.iztek.dd.domain.Bina;
import com.iztek.dd.domain.Proje;
import com.iztek.dd.rapor.ReportManager;
import com.iztek.dd.update.DDUpdater;
import com.thoughtworks.xstream.XStream;

/**
 * @author Selim HENDRICKSON
 *
 */
public class MainController {
	MainGUI mainGUI = null;
	HashMap projects = new HashMap();
	ReportManager reportManager = null;
	private GenelTanimlarDialog genelTanimlarDialog = new GenelTanimlarDialog();
	
	public MainController(MainGUI mainGUI){
		this.mainGUI = mainGUI;	
		
		//File menu & Toolbar		
		addYeniActionListener();
		addSaveActionListener();
		addLoadActionListener();
		addSaveMenuItemActionListener();
		addLoadMenuItemActionListener();
		
		//Raporlar menu
		addRaporlarActionListener();
		setOzgulIsiKaybiMenuItemActionCommand();
		setIsiIhtiyaciKimlikBelgesiActionCommand();
		setIsiKaybiCizelgesiActionCommand();
		setCizelge2ActionCommand();
		setRadyatorSecimiActionCommand();
		addIsiYalitimMenuItemActionCommand();		
		addZetaDegerleriMenuItemActionCommand();
		addBoruCapiMenuItemActionCommand();
		
				
		//Tanýmlar menu
		addGenelTanimlarMenuItemActionListener();
		addMalzemeTanimlariMenuItemActionListener();
		addUDegeriTanimlariMenuItemActionListener();
		addAlfaDegeriTanimlarMenuItemActionListener();
		
		//Help menu
		addHakkindaMenuItemActionListener();
		addHelpActionListener();
		addGuncelleActionListener();
	}
	
    private void addLoadMenuItemActionListener() {
        mainGUI.addLoadMenuItemActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                loadProject();
            }
        });
    }

    private void addSaveMenuItemActionListener() {
        mainGUI.addSaveMenuItemActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                saveActiveProject();
            }
        });
    }

    private void addHelpActionListener() {
	    mainGUI.addHelpMenuItemActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec("hh.exe help/DDHelp.chm");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
	    });
    }

    public void addYeniActionListener(){
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				createNewProject();
			}
		};
		mainGUI.addYeniActionListener(listener);		
	}

	//Raporlar
	
    public void setOzgulIsiKaybiMenuItemActionCommand(){
	    mainGUI.setOzgulIsiKaybiMenuItemActionCommand("YIEI");
	}
	
	public void setIsiIhtiyaciKimlikBelgesiActionCommand(){
	    mainGUI.setIsiIhtiyaciKimlikBelgesiActionCommand("IIKB");
	}

	public void setIsiKaybiCizelgesiActionCommand(){
	    mainGUI.setIsiKaybiCizelgesiActionCommand("IKC");
	}

	public void setCizelge2ActionCommand(){
	    mainGUI.setCizelge2ActionCommand("C2");
	}

	public void setRadyatorSecimiActionCommand(){
	    mainGUI.setRadyatorSecimiActionCommand("RS");
	}

    private void addIsiYalitimMenuItemActionCommand() {
        mainGUI.addIsiYalitimMenuItemActionCommand("IY");
    }

    private void addZetaDegerleriMenuItemActionCommand() {
        mainGUI.addZetaDegerleriMenuItemActionCommand("Zeta");
    }

    private void addBoruCapiMenuItemActionCommand() {
        mainGUI.addBoruCapiMenuItemActionCommand("BC");
    }

	public void addRaporlarActionListener(){
	    ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String actionCommand = arg0.getActionCommand();
                String path = showFileChooser(true);
                if(path!=null){
                	ProjectController controller = getProjectController();
                	if(controller!=null) ReportManager.getReport(controller,path,actionCommand);
                	else SwingUtils.errorMessage("Lütfen raporlamak istediðiniz projeyi seçiniz!");
                }
            }
	    };
	    mainGUI.addRaporlarActionListener(listener);
	}
	
    protected String showFileChooser(boolean save) {
        return mainGUI.showFileChoser(save);
    }

    public void createNewProject(){
		ProjectGUI gui = new ProjectGUI();
		Proje proje = new Proje();
		ProjectController projectController = new ProjectController(gui,proje);		
		projects.put(gui,projectController);
		mainGUI.createNewProject(gui);		
	}
	
    private ProjectController getProjectController() {
        ProjectGUI activeProjectGUI = mainGUI.getActiveProjectGUI();
        ProjectController controller = (ProjectController)projects.get(activeProjectGUI);
        return controller;
    }

    private void addGuncelleActionListener(){
    	mainGUI.addGuncelleMenuItemActionListener(new ActionListener(){
    		boolean state = false;
			public void actionPerformed(ActionEvent e) {
				int choice = SwingUtils.customConfirmation("DemirDöküm sunucularýna baðlanýp güncelleme gerçekleþtirmek istermisiniz?","Güncelleme sihirbazý");
				if(choice==0) state = DDUpdater.updateXmlFiles();
				if(state) SwingUtils.infoMessage("Program baþarý ile güncellendi. Lütfen programý baþtan baþlatýnýz...");
				else SwingUtils.errorMessage("Güncelleme baþarýsýz oldu.");
			}
    	});
    }

    //Tanýmlar menu
    
	private void addGenelTanimlarMenuItemActionListener() {
	    mainGUI.addGenelTanimlarMenuItemActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SwingUtils.centerAndShowComponent(genelTanimlarDialog);
            }
	    });
    }

    private void addMalzemeTanimlariMenuItemActionListener() {
        mainGUI.addMalzemeTanimlariMenuItemActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                MalzemeTanimlariDialog dialog = new MalzemeTanimlariDialog();
                SwingUtils.centerAndShowComponent(dialog);
            }
        });
    }

    private void addUDegeriTanimlariMenuItemActionListener() {
        mainGUI.addUDegeriTanimlariMenuItemActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                UDegerleriDialog dialog = new UDegerleriDialog();
                SwingUtils.centerAndShowComponent(dialog);
            }
        });
    }

    //Save & Load
    
	public void addSaveActionListener(){
	    mainGUI.addSaveActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
    	        saveActiveProject();
            }
	    });
	}
	
	public void addLoadActionListener(){
	    mainGUI.addLoadActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
    	        loadProject();
            }
	    });	    
	}

	public void addHakkindaMenuItemActionListener(){
	    mainGUI.addHakkindaMenuItemActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SwingUtils.centerAndShowComponent(new HakkindaDialog());
            }
	    });
	}

    private void addAlfaDegeriTanimlarMenuItemActionListener() {
        mainGUI.addAlfaDegeriTanimlarMenuItemActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SwingUtils.centerAndShowComponent(new AlfaDegerleriDialog());
            }
        });
    }

	protected void saveActiveProject() {
	    ProjectGUI gui = mainGUI.getActiveProjectGUI();
	    ProjectController controller = (ProjectController)projects.get(gui);
	    if(controller!=null){
		    Proje proje = controller.proje;
		    XStream xstream = new XStream();
			Bina ts825Bina = controller.ts825controller.bina;
			com.iztek.dd.IsiKaybi.domain.Bina isiKaybiBina = controller.isiKaybiController.treeController.bina;
			IsiKazanan mahal = controller.isiKazanciController.mahal;

			SaveObject saveObject = new SaveObject();
			saveObject.setBinaDurumuKatsayilariArrayIndex1(controller.isiKaybiController.binaDurumuKatsayilariArrayIndex1);
			saveObject.setBinaDurumuKatsayilariArrayIndex2(controller.isiKaybiController.binaDurumuKatsayilariArrayIndex2);
			saveObject.setBinaDurumuKatsayilariArrayIndex3(controller.isiKaybiController.binaDurumuKatsayilariArrayIndex3);
			saveObject.setSizdirganlikKatsayilariArrayIndex1(controller.isiKaybiController.sizdirganlikKatsayilariArrayIndex1);
			saveObject.setSizdirganlikKatsayilariArrayIndex2(controller.isiKaybiController.sizdirganlikKatsayilariArrayIndex2);
			
			saveObject.setProje(proje);
			saveObject.setTs825Bina(ts825Bina);
			saveObject.setIsiKaybiBina(isiKaybiBina);
			saveObject.setMahal(mahal);
			
			String xmlSave = xstream.toXML(saveObject);
			String path = showFileChooser(true);
			try {
			    File saveFile = null;
			    if(path.indexOf(".dds")==-1)saveFile = new File(path+".dds");
			    else saveFile = new File(path);
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(saveFile)));
				out.write(xmlSave);
				out.flush();
				out.close();
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
				SwingUtils.errorMessage("Proje kaydedilemedi!");
			}
			SwingUtils.infoMessage("Proje baþarý ile kaydedildi!");
	    }		
    }

    protected void loadProject() {
		XStream xstream = new XStream();
		Proje proje = null;
		
		SaveObject saveObject = null;
		String path = showFileChooser(false);
		if(path!=null){
			try {
			    saveObject = (SaveObject)xstream.fromXML(new FileReader(new File(path)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			proje = saveObject.getProje();
			ProjectGUI gui = new ProjectGUI();		
			ProjectController projectController = new ProjectController(gui,proje);		
			projects.put(gui,projectController);
			mainGUI.createNewProject(gui);
			
			Bina bina = saveObject.getTs825Bina();
			projectController.ts825controller.bina = bina;
			bina.setProje(proje);
			
			com.iztek.dd.IsiKaybi.domain.Bina isiKaybiBina = saveObject.getIsiKaybiBina();
			projectController.isiKaybiController.bina = isiKaybiBina;
			isiKaybiBina.setProje(proje);
		    projectController.isiKaybiController.binaDurumuKatsayilariArrayIndex1=saveObject.getBinaDurumuKatsayilariArrayIndex1();
		    projectController.isiKaybiController.binaDurumuKatsayilariArrayIndex2=saveObject.getBinaDurumuKatsayilariArrayIndex2();
		    projectController.isiKaybiController.binaDurumuKatsayilariArrayIndex3=saveObject.getBinaDurumuKatsayilariArrayIndex3();
		    projectController.isiKaybiController.sizdirganlikKatsayilariArrayIndex1=saveObject.getSizdirganlikKatsayilariArrayIndex1();
		    projectController.isiKaybiController.sizdirganlikKatsayilariArrayIndex2=saveObject.getSizdirganlikKatsayilariArrayIndex2();				
			projectController.isiKaybiController.loadBina();
			
			IsiKazanan mahal = saveObject.getMahal();
			projectController.isiKazanciController.proje = proje;
			projectController.isiKazanciController.mahal = mahal;
			projectController.isiKazanciController.loadIsiKazanci();			    
		}
    }

}
