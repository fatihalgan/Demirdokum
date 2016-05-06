/*
 * Created on 28.Ara.2004
 *
 */
package com.iztek.dd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;

import com.iztek.dd.GUI.GenlesmeDeposuSecimiDialog;
import com.iztek.dd.GUI.IsletmeTipiArttirimKatsayilariDialog;
import com.iztek.dd.GUI.KazanSecDialog;
import com.iztek.dd.GUI.KombiSecDialog;
import com.iztek.dd.GUI.ParcaBilgileriDialog;
import com.iztek.dd.GUI.ProjectGUI;
import com.iztek.dd.GUI.RadyatorModeliSecimiDialog;
import com.iztek.dd.GUI.YapiElemaniSecimiDialog;
import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.GUI.wrappers.KritikHatTableModel;
import com.iztek.dd.GUI.wrappers.ParcaBilgileriDialogStaticBinder;
import com.iztek.dd.GUI.wrappers.RadyatorSecimTableModel;
import com.iztek.dd.GUI.wrappers.YapiElemaniSecimTableModel;
import com.iztek.dd.IsiKaybi.GenlesmeDepoCatalog;
import com.iztek.dd.IsiKaybi.GenlesmeDeposu;
import com.iztek.dd.IsiKaybi.domain.Bina;
import com.iztek.dd.IsiKaybi.domain.BoruParcasi;
import com.iztek.dd.IsiKaybi.domain.CogunluklaKullanilanYapiElemanlari;
import com.iztek.dd.IsiKaybi.domain.DuvarYapiElemani;
import com.iztek.dd.IsiKaybi.domain.IsiYalitimiTableModel;
import com.iztek.dd.IsiKaybi.domain.IsiticiModeliInt;
import com.iztek.dd.IsiKaybi.domain.KapiYapiElemani;
import com.iztek.dd.IsiKaybi.domain.KazanlarTableModel;
import com.iztek.dd.IsiKaybi.domain.KombilerTableModel;
import com.iztek.dd.IsiKaybi.domain.PencereYapiElemani;
import com.iztek.dd.IsiKaybi.domain.Radyator;
import com.iztek.dd.IsiKaybi.domain.Radyatorler;
import com.iztek.dd.IsiKaybi.domain.StandartYalitimBileseni;
import com.iztek.dd.IsiKaybi.domain.YapiElemani;
import com.iztek.dd.domain.Proje;

/**
 * @author Selim HENDRICKSON
 *
 */
public class IsiKaybiController {
    public ProjectGUI gui = null;
    public Proje proje = null;
    public Bina bina = new Bina();
    DDTreeController treeController = null;        
    
    IsletmeTipiArttirimKatsayilariDialog isletmeTipiArttirimKatsayilariDialog = null;
    YapiElemaniSecimiDialog yapiElemaniSecimiDialog = null;
    RadyatorModeliSecimiDialog radyatorModeliSecimiDialog = null;
    KazanSecDialog kazanSecDialog = null;
    KombiSecDialog kombiSecDialog = null;
    ParcaBilgileriDialog parcaBilgileriDialog = null;
    GenlesmeDeposuSecimiDialog depoSecimDialog = null;
    
    double[][][] binaDurumKatsayilari = new double[2][3][2];    
    int binaDurumuKatsayilariArrayIndex1 = 0;
    int binaDurumuKatsayilariArrayIndex2 = 0;
    int binaDurumuKatsayilariArrayIndex3 = 0;    

    double[][] sizdirganlikKatsayilari = new double[3][3];  
    int sizdirganlikKatsayilariArrayIndex1 = 0;
    int sizdirganlikKatsayilariArrayIndex2 = 0;
    
    DefaultTreeModel treeModel = null;

    public IsiKaybiController(ProjectGUI gui,Proje proje){
        binaDurumKatsayilari[0][0][0] = 1;
        binaDurumKatsayilari[0][0][1] = 1.42;
        binaDurumKatsayilari[0][1][0] = 1.72;
        binaDurumKatsayilari[0][1][1] = 2.43;
        binaDurumKatsayilari[0][2][0] = 2.51;
        binaDurumKatsayilari[0][2][1] = 3.52;
        binaDurumKatsayilari[1][0][0] = 1.72;
        binaDurumKatsayilari[1][0][1] = 2.43;
        binaDurumKatsayilari[1][1][0] = 2.51;
        binaDurumKatsayilari[1][1][1] = 3.52;
        binaDurumKatsayilari[1][2][0] = 2.6;
        binaDurumKatsayilari[1][2][1] = 4.73;
        
        sizdirganlikKatsayilari[0][0] = 3;
        sizdirganlikKatsayilari[0][1] = 2.5;
        sizdirganlikKatsayilari[0][2] = 2;
        sizdirganlikKatsayilari[1][0] = 2;
        sizdirganlikKatsayilari[1][1] = 2;
        sizdirganlikKatsayilari[1][2] = 1.5;
        sizdirganlikKatsayilari[2][0] = 1.2;
        sizdirganlikKatsayilari[2][1] = 1.5;
        sizdirganlikKatsayilari[2][2] = 1.2;
        
        this.gui = gui;
        this.proje = proje;
        bina.setProje(proje);
        addAyrikNizamRadioButtonListener();
        addBitisikNizamRadioButtonListener();
        addCokSerbestBinaDurumuRadioButtonListener();
        addMahfuzBinaDurumuRadioButtonListener();
        addNormalBolgeDurumuRadioButtonListener();
        addRuzgarliBolgeDurumuRadioButtonListener();
        addSerbestBinaDurumuRadioButtonListener();
        addOdaDurumKatsayisi07RadioButtonListener();
        addOdaDurumKatsayisi09RadioButtonListener();
        setAyrikNizamRadioButtonActionCommand();
        setBitisikNizamRadioButtonActionCommand();
        setCokSerbestBinaDurumuRadioButtonActionCommand();
        setMahfuzBinaDurumuRadioButtonActionCommand();
        setNormalBolgeDurumuRadioButtonActionCommand();
        setOdaDurumKatsayisi07RadioButtonActionCommand();
        setOdaDurumKatsayisi09RadioButtonActionCommand();
        setRuzgarliBolgeDurumuRadioButtonActionCommand();
        setSerbestBinaDurumuRadioButtonActionCommand();
        
        setIsletme1RadioButtonActionCommand();
        setIsletme2RadioButtonActionCommand();
        setIsletme3RadioButtonActionCommand();
        addIsletme1RadioButtonActionListener();
        addIsletme2RadioButtonActionListener();
        addIsletme3RadioButtonActionListener();
        
        addMalzemeAhsapRadioButtonListener();
        addMalzemeMetalRadioButtonListener();
        addMalzemePlastikRadioButtonListener();
        addTipCiftAcilirliRadioButtonListener();
        addTipCiftCamliRadioButtonListener();
        addTipTekAcilirliRadioButtonListener();
        addCogunluklaKullanilanYapiElemaniSecButtonListener();
        addRadyatorModeliSecButtonListener();
        addKritikHatListeners();
        treeController = new DDTreeController(gui,bina);
        
		addIsiYalitimPanelComponentListener();
		addKazanPanelComponentListener();
		setKazanIsiticiTuruRadioButtonActionCommand();
		setKombiIsiticiTuruRadioButtonActionCommand();
		addKazanIsiticiTuruRadioButtonActionListener();
		addKombiIsiticiTuruRadioButtonActionListener();
		addKazanSecButtonActionListener();
		addGenlesmeDeposuDegistirButtonActionListener();
		
		addKazanSecDialogTamamButtonListener();
		setIsiYalitimiBilesenleriTableModel();
    }

    /**
     * Event Listeners
     * 
     */
    ActionListener binaKatsayisiRadioButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
			updateBinaKatsayisiTextField();
		}
	};
	
	ActionListener odaDurumKatsayisiRadioButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if(actionCommand.equals("07")) bina.setOdaDurumKatsayisi(0.7);
			if(actionCommand.equals("09")) bina.setOdaDurumKatsayisi(0.9);
			actionCommand = null;
		}
	};
		
	ActionListener sizdirganlikKatsayisiRadioButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	    updateSizdirganlikKatsayisiTextField();
		}
	};
	
	private ActionListener getCogunluklaKullanilanYapiElemaniSecButtonListener()
	{
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yapiElemaniSecimiDialog = gui.showYapiElemaniSecimiDialog();
				String actionCommand = e.getActionCommand();
				addYapiElemaniSecimiDialogListeners(actionCommand);

				Collection yapiElemanlari = CogunluklaKullanilanYapiElemanlari.getInstance().getYapiElemanlari();
				
				String[] kodlar = null;
				if(actionCommand.equals("Dis Duvar"))
					kodlar = YapiElemani.DIS_DUVAR_KODLAR;
				if(actionCommand.equals("Ic Duvar"))
				    kodlar = YapiElemani.IC_DUVAR_KODLAR;
				if(actionCommand.equals("Pencere"))
				    kodlar = YapiElemani.PENCERE_KODLAR;
				if(actionCommand.equals("Dis Kapi"))
				    kodlar = YapiElemani.DIS_KAPI_KODLAR;
				if(actionCommand.equals("Ic Kapi"))
				    kodlar = YapiElemani.IC_KAPI_KODLAR;
				
				Collection filteredCol = YapiElemani.filterByKodlar(yapiElemanlari, kodlar);
				TableModel tableModel = new YapiElemaniSecimTableModel(filteredCol);
				yapiElemaniSecimiDialog.setYapiBilesenleriTable(tableModel);
			}
		};
	}
	
    private void addYapiElemaniSecimiDialogListeners(String actionCommand) {
        ActionListener secListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = yapiElemaniSecimiDialog.getYapiBileþenleriTableSelectedIndex();
                if (index < 0)
                    return;
                YapiElemaniSecimTableModel model = (YapiElemaniSecimTableModel)yapiElemaniSecimiDialog.getYapiBileþenleriTableModel();
                List list = model.getYapiElemanilar();
                if (index < list.size()){
                    YapiElemani yapiElemani = (YapiElemani)list.get(index);
                    
                    String actionCommand = e.getActionCommand();
                    if(actionCommand.equals("Dis Duvar")){
                        gui.setDisDuvarTextFieldText(yapiElemani.getYapiElemaniKodu());
                        proje.setCogunluklaKullanilanDisDuvar(yapiElemani);
                    }
    				if(actionCommand.equals("Ic Duvar")){
    				    gui.setIcDuvarTextFieldText(yapiElemani.getYapiElemaniKodu());
    				    proje.setCogunluklaKullanilanIcDuvar(yapiElemani);
    				}
    				if(actionCommand.equals("Pencere")){
    				    gui.setPencereTextFieldText(yapiElemani.getYapiElemaniKodu());
    				    proje.setCogunluklaKullanilanPencere(yapiElemani);
    				}
    				if(actionCommand.equals("Dis Kapi")){
    				    gui.setDisKapiTextFieldText(yapiElemani.getYapiElemaniKodu());
    				    proje.setCogunluklaKullanilanDisKapi(yapiElemani);
    				}
    				if(actionCommand.equals("Ic Kapi")){
    				    gui.setIcKapiTextFieldText(yapiElemani.getYapiElemaniKodu());
    				    proje.setCogunluklaKullanilanIcKapi(yapiElemani);
    				}
                    
                    yapiElemaniSecimiDialog.setVisible(false);
                }
            }
        };
        yapiElemaniSecimiDialog.addSecListener(secListener);
        yapiElemaniSecimiDialog.setSecActionCommand(actionCommand);
        
        ActionListener vazgecListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                yapiElemaniSecimiDialog.setVisible(false);
            }
        };
        yapiElemaniSecimiDialog.addVazgecListener(vazgecListener);
    }

    ActionListener radyatorModeliSecButtonListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			radyatorModeliSecimiDialog = gui.showRadyatorModeliSecimiDialog();
			addRadyatorModeliSecimiDialogListeners();
		}
	};

    protected void addRadyatorModeliSecimiDialogListeners() {
        ActionListener secListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = radyatorModeliSecimiDialog.getRadyatorModelleriTableSelectedIndex();
                if (index < 0)
                    return;
                RadyatorSecimTableModel model = (RadyatorSecimTableModel)radyatorModeliSecimiDialog.getRadyatorModelleriTableModel();
                List list = model.getRadyatorler();
                if (index < list.size()){
                    Radyator radyator = (Radyator)list.get(index);
                    
                    gui.setRadyatorModeliTextFieldText(radyator.getModel());
                    proje.setEnCokKullanilanRadyatorModeli(radyator);
                    if(radyator.getTip().equals("Panel")) bina.getIsitici().setPanel(true);
                    else bina.getIsitici().setPanel(false);
                    
                    radyatorModeliSecimiDialog.setVisible(false);
                }
            }
        };
        radyatorModeliSecimiDialog.addSecButtonListener(secListener);
        
        ItemListener radyatorTipListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                JRadioButton button = (JRadioButton)e.getSource();
                Object[] ar = button.getSelectedObjects();
                if (ar != null) {
	                String tip = (String)ar[0];
	                Collection radyatorler = Radyatorler.getInstance().getRadyatorler();
	                Collection filtered = null;
	                if ( tip.equals("Hepsi"))
	                    filtered = radyatorler;
	                else
	                    filtered = Radyator.filterByTip(radyatorler, tip);
	                
	    			RadyatorSecimTableModel model = new RadyatorSecimTableModel(filtered);
	    			radyatorModeliSecimiDialog.setRadyatorModelleriTableModel(model);
                }
            }
        };
        radyatorModeliSecimiDialog.addRadyatorTipListener(radyatorTipListener);
    }
	
    private void addKritikHatListeners() {
        KritikHatTableModel model = new KritikHatTableModel(new ArrayList());
        gui.setKritikHatTableModel(model);
        
        ActionListener kritikHatEkleListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parcaBilgileriDialog = gui.showParcaBilgileriDialog();
                addParcaBilgileriDialogListeners();
            }

            private void addParcaBilgileriDialogListeners() {
                ActionListener parcaEkleListener = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {                        
                        ParcaBilgileriDialogStaticBinder binder = ParcaBilgileriDialogStaticBinder.getInstance(parcaBilgileriDialog);
                        BoruParcasi boruParcasi = new BoruParcasi(binder.getParcaninUzunlugu(), binder.getParcaninIsiYuku());
                        boruParcasi.setCap(binder.getParcaninCapi());
                        boruParcasi.addSurtunmeDirenciYaratanlar("Radyatör Ventili(Köþe)", binder.getKoseliRadyatorVentiliAdeti());
                        boruParcasi.addSurtunmeDirenciYaratanlar("Pantolon Parçasý", binder.getPantalonParcasiAdeti());
                   		boruParcasi.addSurtunmeDirenciYaratanlar("T Giriþ(Ayrýlma)", binder.getTGirisAdeti());
        				boruParcasi.addSurtunmeDirenciYaratanlar("Kazan veya Radyatör", binder.getKazanVeRadyatorAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("Kollektör Giriþ Veya Çýkýþý", binder.getKollektorGirisVeyaCikisAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("T Geçiþ(Ayrýlma)", binder.getTGecisAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("Çift Dirsek(Dar)", binder.getDarCiftDirsekAdeti());
    					boruParcasi.addSurtunmeDirenciYaratanlar("Deve Boynu 90 Derece", binder.getDeveBoynuAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("Kolon Vanasý", binder.getDuzKolonVanasiAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("S Parçasý", binder.getSParcasiAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("Çift Dirsek(Geniþ)", binder.getGenisCiftDirsekAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("T Ayrýlma", binder.getTAyrilmaAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("Dirsek", binder.getDirsekAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("Radyatör Ventili(Düz)", binder.getDuzRadyatorVentiliAdediAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("Þiber Vana", binder.getSiberVanaAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("Kolon Vanasý(Eðik)", binder.getEgikKolonVanasiAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("T Birleþme", binder.getTBirlesmeAdeti());
						boruParcasi.addSurtunmeDirenciYaratanlar("T Karþýt Akým", binder.getTKarsitAkimAdeti());
						boruParcasi.getZetaDirenci();
						boruParcasi.getMetreBasiBasincKaybi();
						boruParcasi.getOzelDirenc();
						
						
                        KritikHatTableModel model = (KritikHatTableModel)gui.getKritikHatTableModel();
                        model.add(boruParcasi);
                        bina.getKritikHat().addBoruParcasi(boruParcasi);
                        
                        parcaBilgileriDialog.dispose();
                    }
                };
                parcaBilgileriDialog.addEkleListener(parcaEkleListener);
            }
        };
        gui.addKritikHatEkleButtonListener(kritikHatEkleListener);        
        
        ActionListener kritikHatSilListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int index = gui.getKritikHatTableSelectedIndex();
                if (index < 0)
                    return;
                KritikHatTableModel model = (KritikHatTableModel)gui.getKritikHatTableModel();
                BoruParcasi removedParca = (BoruParcasi)model.remove(index);
                bina.getKritikHat().removeBoruParcasi(removedParca);
            }
        };
        gui.addKritikHatSilButtonListener(kritikHatSilListener);        
    }
    
	ActionListener isitmaSistemiComboBoxListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Isýtma Sistemi Seçildi");
		}
	};
	
	ActionListener isiticiTuruRadioButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if(actionCommand.equals("Kazan")){
				gui.setKazanSecimiPanelLabels("Kazan");
				bina.getIsitici().setIsiticiTuru("Kazan");
			}
			if(actionCommand.equals("Kombi")){
				gui.setKazanSecimiPanelLabels("Kombi");
				bina.getIsitici().setIsiticiTuru("Kombi");
			}
		}
	};

	

    /**
	 * Get Event Listeners
	 * 
	 */
	
	public ActionListener getBinaKatsayisiRadioButtonListener() {
		return binaKatsayisiRadioButtonListener;
	}
	
    public ActionListener getOdaDurumKatsayisiRadioButtonListener() {
		return odaDurumKatsayisiRadioButtonListener;
	}
		
	public ActionListener getSizdirganlikKatsayisiRadioButtonListener() {
		return sizdirganlikKatsayisiRadioButtonListener;
	}
	
	public ActionListener getIsiticiTuruRadioButtonListener() {
		return isiticiTuruRadioButtonListener;
	}
		
	public ActionListener getRadyatorModeliSecButtonListener() {
		return radyatorModeliSecButtonListener;
	}
	
	public ActionListener getIsitmaSistemiComboBoxListener() {
		return isitmaSistemiComboBoxListener;
	}
	
    private ActionListener getIsletmeTipiRadioButtonListener() {
        return new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {              
                String actionCommand = arg0.getActionCommand();
                if(actionCommand=="Isletme1") bina.setIsletmeTipi(1);
                if(actionCommand=="Isletme2") bina.setIsletmeTipi(2);
                if(actionCommand=="Isletme3") bina.setIsletmeTipi(3);
                actionCommand = null;
            }
        };
    }
    
    

	/**
	 * Add ActionListeners and Set ActionCommands
	 *
	 */
	
	public void addNormalBolgeDurumuRadioButtonListener() {
		gui.addNormalBolgeDurumuRadioButtonListener(getBinaKatsayisiRadioButtonListener());
	}
	
	public void setNormalBolgeDurumuRadioButtonActionCommand() {
    	gui.setNormalBolgeDurumuRadioButtonActionCommand("Normal");
    }
	
	public void addRuzgarliBolgeDurumuRadioButtonListener() {
		gui.addRuzgarliBolgeDurumuRadioButtonListener(getBinaKatsayisiRadioButtonListener());
	}
    
    public void setRuzgarliBolgeDurumuRadioButtonActionCommand() {
    	gui.setRuzgarliBolgeDurumuRadioButtonActionCommand("Ruzgarli");
    }
    
    public void addMahfuzBinaDurumuRadioButtonListener() {
		gui.addMahfuzBinaDurumuRadioButtonListener(getBinaKatsayisiRadioButtonListener());
	}
	
	public void setMahfuzBinaDurumuRadioButtonActionCommand() {
    	gui.setMahfuzBinaDurumuRadioButtonActionCommand("Mahfuz");
    }
	
	public void addSerbestBinaDurumuRadioButtonListener() {
		gui.addSerbestBinaDurumuRadioButtonListener(getBinaKatsayisiRadioButtonListener());
	}
	
	public void setSerbestBinaDurumuRadioButtonActionCommand() {
    	gui.setSerbestBinaDurumuRadioButtonActionCommand("Serbest");
    }
	
	public void addCokSerbestBinaDurumuRadioButtonListener() {
		gui.addCokSerbestBinaDurumuRadioButtonListener(getBinaKatsayisiRadioButtonListener());
	}
	
	public void setCokSerbestBinaDurumuRadioButtonActionCommand() {
    	gui.setCokSerbestBinaDurumuRadioButtonActionCommand("Çok Serbest");
    }
	
	public void addBitisikNizamRadioButtonListener() {
		gui.addBitisikNizamRadioButtonListener(getBinaKatsayisiRadioButtonListener());
	}
	
	public void setBitisikNizamRadioButtonActionCommand() {
    	gui.setBitisikNizamRadioButtonActionCommand("Bitisik");
    }
	
	public void addAyrikNizamRadioButtonListener() {
		gui.addAyrikNizamRadioButtonListener(getBinaKatsayisiRadioButtonListener());
	}
	
	public void setAyrikNizamRadioButtonActionCommand() {
    	gui.setAyrikNizamRadioButtonActionCommand("Bitisik");
    }
    
	public void addOdaDurumKatsayisi07RadioButtonListener() {
		gui.addOdaDurumKatsayisi07RadioButtonListener(getOdaDurumKatsayisiRadioButtonListener());
	}
	
	public void setOdaDurumKatsayisi07RadioButtonActionCommand() {
    	gui.setOdaDurumKatsayisi07RadioButtonActionCommand("07");
    }
	
	public void addOdaDurumKatsayisi09RadioButtonListener() {
		gui.addOdaDurumKatsayisi09RadioButtonListener(getOdaDurumKatsayisiRadioButtonListener());
	}
	
	public void setOdaDurumKatsayisi09RadioButtonActionCommand() {
    	gui.setOdaDurumKatsayisi09RadioButtonActionCommand("09");
    }
		
	public void addMalzemeAhsapRadioButtonListener() {
		gui.addMalzemeAhsapRadioButtonListener(getSizdirganlikKatsayisiRadioButtonListener());
	}
		
	public void addMalzemePlastikRadioButtonListener() {
		gui.addMalzemePlastikRadioButtonListener(getSizdirganlikKatsayisiRadioButtonListener());
	}
	
	public void addMalzemeMetalRadioButtonListener() {
		gui.addMalzemeMetalRadioButtonListener(getSizdirganlikKatsayisiRadioButtonListener());
	}
	
	public void addTipTekAcilirliRadioButtonListener() {
		gui.addTipTekAcilirliRadioButtonListener(getSizdirganlikKatsayisiRadioButtonListener());
	}
	
	public void addTipCiftCamliRadioButtonListener() {
		gui.addTipCiftCamliRadioButtonListener(getSizdirganlikKatsayisiRadioButtonListener());
	}
	
	public void addTipCiftAcilirliRadioButtonListener() {
		gui.addTipCiftAcilirliRadioButtonListener(getSizdirganlikKatsayisiRadioButtonListener());
	}
	
	public void addDisDuvarCogunluklaKullanilanYapiElemaniButtonListener() {
		gui.addDisDuvarCogunluklaKullanilanYapiElemaniButtonListener(getCogunluklaKullanilanYapiElemaniSecButtonListener());
	}
	
	public void setDisDuvarCogunluklaKullanilanYapiElemaniButtonActionCommand() {
		gui.setDisDuvarCogunluklaKullanilanYapiElemaniButtonActionCommand("Dis Duvar");
	}
	
	public void addIcDuvarCogunluklaKullanilanYapiElemaniButtonListener() {
		gui.addIcDuvarCogunluklaKullanilanYapiElemaniButtonListener(getCogunluklaKullanilanYapiElemaniSecButtonListener());
	}
	
	public void setIcDuvarCogunluklaKullanilanYapiElemaniButtonActionCommand() {
		gui.setIcDuvarCogunluklaKullanilanYapiElemaniButtonActionCommand("Ic Duvar");
	}
	
	public void addPencereCogunluklaKullanilanYapiElemaniButtonListener() {
		gui.addPencereCogunluklaKullanilanYapiElemaniButtonListener(getCogunluklaKullanilanYapiElemaniSecButtonListener());
	}
	
	public void setPencereCogunluklaKullanilanYapiElemaniButtonActionCommand() {
		gui.setPencereCogunluklaKullanilanYapiElemaniButtonActionCommand("Pencere");
	}
	
	public void addDisKapiCogunluklaKullanilanYapiElemaniButtonListener() {
		gui.addDisKapiCogunluklaKullanilanYapiElemaniButtonListener(getCogunluklaKullanilanYapiElemaniSecButtonListener());
	}
	
	public void setDisKapiCogunluklaKullanilanYapiElemaniButtonActionCommand() {
		gui.setDisKapiCogunluklaKullanilanYapiElemaniButtonActionCommand("Dis Kapi");
	}
	
	public void addIcKapiCogunluklaKullanilanYapiElemaniButtonListener() {
		gui.addIcKapiCogunluklaKullanilanYapiElemaniButtonListener(getCogunluklaKullanilanYapiElemaniSecButtonListener());
	}
	
	public void setIcKapiCogunluklaKullanilanYapiElemaniButtonActionCommand() {
		gui.setIcKapiCogunluklaKullanilanYapiElemaniButtonActionCommand("Ic Kapi");
	}
		
	public void addIsitmasistemiComboBoxActionListener() {
		gui.addIsitmasistemiComboBoxActionListener(getIsitmaSistemiComboBoxListener());
	}
	
	public void addKazanIsiticiTuruRadioButtonActionListener() {
		gui.addKazanIsiticiTuruRadioButtonactionListener(getIsiticiTuruRadioButtonListener());
	}
	
	public void setKazanIsiticiTuruRadioButtonActionCommand() {
		gui.setKazanIsiticiTuruRadioButtonActionCommand("Kazan");
	}
	
	public void addKombiIsiticiTuruRadioButtonActionListener() {
		gui.addKombiIsiticiTuruRadioButtonactionListener(getIsiticiTuruRadioButtonListener());
	}
	
	public void setKombiIsiticiTuruRadioButtonActionCommand() {
		gui.setKombiIsiticiTuruRadioButtonActionCommand("Kombi");
	}

	public void addIsletme1RadioButtonActionListener() {
		gui.addIsletme1RadioButtonactionListener(getIsletmeTipiRadioButtonListener());
	}
	
    public void setIsletme1RadioButtonActionCommand() {
		gui.setIsletme1RadioButtonActionCommand("Isletme1");
	}

	public void addIsletme2RadioButtonActionListener() {
		gui.addIsletme2RadioButtonactionListener(getIsletmeTipiRadioButtonListener());
	}
	
	private void addCogunluklaKullanilanYapiElemaniSecButtonListener() {
		gui.addCogunluklaKullanilanYapiElemaniSecButtonListener(getCogunluklaKullanilanYapiElemaniSecButtonListener());
	}

    private void addRadyatorModeliSecButtonListener() {
        gui.addRadyatorModeliSecButtonListener(getRadyatorModeliSecButtonListener());
    }

	public void setIsletme2RadioButtonActionCommand() {
		gui.setIsletme2RadioButtonActionCommand("Isletme2");
	}

	public void addIsletme3RadioButtonActionListener() {
		gui.addIsletme3RadioButtonactionListener(getIsletmeTipiRadioButtonListener());
	}
	
	public void setIsletme3RadioButtonActionCommand() {
		gui.setIsletme3RadioButtonActionCommand("Isletme3");
	}

	public boolean isNormalBolgeDurumuRadioButtonSelected(){
	    return gui.isNormalBolgeDurumuRadioButtonSelected();
	}
	
	public boolean isRuzgarliBolgeDurumuRadioButtonSelected(){
	    return gui.isRuzgarliBolgeDurumuRadioButtonSelected();
	}
 
	public boolean isMahfuzBinaDurumuRadioButtonSelected(){
	    return gui.isMahfuzBinaDurumuRadioButtonSelected();
	}
	
	public boolean isSerbestBinaDurumuRadioButtonSelected(){
	    return gui.isSerbestBinaDurumuRadioButtonSelected();
	}

	public boolean isCokSerbestBinaDurumuRadioButtonSelected(){
	    return gui.isCokSerbestBinaDurumuRadioButtonSelected();
	}

	public boolean isAyrikNizamRadioButtonSelected(){
	    return gui.isAyrikNizamRadioButtonSelected();
	}

	public boolean isBitisikNizamRadioButtonSelected(){
	    return gui.isBitisikNizamRadioButtonSelected();
	}

	public boolean isAhsapMalzemeRadioButtonSelected(){
	    return gui.AhsapMalzemeRadioButtonSelected();
	}
	
	public boolean isPlastikMalzemeRadioButtonSelected(){
	    return gui.PlastikMalzemeRadioButtonSelected();
	}

	public boolean isMetalMalzemeRadioButtonSelected(){
	    return gui.MetalMalzemeRadioButtonSelected();
	}

	public boolean isTekAcilirliTipRadioButtonSelected(){
	    return gui.isTekAcilirliTipRadioButtonSelected();
	}
	
	public boolean isCiftCamliTipRadioButtonSelected(){
	    return gui.isCiftCamliTipRadioButtonSelected();
	}

	public boolean isCiftAcilirliTipRadioButtonSelected(){
	    return gui.isCiftAcilirliTipRadioButtonSelected();
	}
	
	public void addKazanSecButtonActionListener(){
		gui.addKazanSecButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				kazanSecAction();
			}
		});
	}

    private void kazanSecAction() {
        if(bina.getIsitici().getIsiticiTuru().equals("Kazan")){
            getKazanSecDialog().setIsitici(bina.getIsitici());	
            SwingUtils.centerAndShowComponent(getKazanSecDialog());            
        }
        if(bina.getIsitici().getIsiticiTuru().equals("Kombi")){
            getKombiSecDialog().setIsitici(bina.getIsitici());	
            getKombiSecDialog().setKazanlarPanel(gui.getKazanSecimiPanel());
            SwingUtils.centerAndShowComponent(getKombiSecDialog());            
        }        
    }

    private TableModel getKombilerTableModel() {
        double kombiGucu = bina.getIsitici().hesaplaKazanKapasiteIhtiyaci()/bina.getKatlar().size();
        return new KombilerTableModel(kombiGucu,true);
    }

	protected TableModel getKazanlarTableModel() {
	    double kazanGucu = bina.getIsitici().hesaplaKazanKapasiteIhtiyaci();	
	    return new KazanlarTableModel(kazanGucu,"1.0");
    }


    public void addGenlesmeDeposuDegistirButtonActionListener(){
		gui.addGenlesmeDeposuDegistirButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				depoSecimDialog = new GenlesmeDeposuSecimiDialog();
				depoSecimDialog.setTableModel(getGenlesmeDepolariTableModel());
				addDepoSecimDialogTamamButtonActionListener();
				SwingUtils.centerAndShowComponent(depoSecimDialog);
			}
		});
	}
	
	public TableModel getGenlesmeDepolariTableModel(){
		double size = Double.parseDouble(gui.getGenlesmeDeposuHacmiTextFieldText().replace(',','.'));
		String[] headers = {"Model","Hacim"};
		DefaultTableModel tableModel = new DefaultTableModel(headers,0);
		ArrayList depolar = (ArrayList)GenlesmeDepoCatalog.getInstance().getDepolarFilteredBySize(size);		
		Iterator it = depolar.iterator();
		while(it.hasNext()){
			GenlesmeDeposu depo = (GenlesmeDeposu) it.next(); 
			String[] depoRow = {depo.getModel(),""+depo.getHacim()};
			tableModel.addRow(depoRow);
		}		
		return tableModel;
	}
	
	public void addDepoSecimDialogTamamButtonActionListener(){
		depoSecimDialog.addDepoSecimDialogTamamButtonActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String depoModeli = depoSecimDialog.getSelectedDepoModeli();
				gui.setSelectedDepoModeliTextFieldText(depoModeli);
			}
		});
	}
	
	/*********************/
	/** Business Commands*/
	/*********************/

	public void setBinaKatsayisiTextFieldText(double binaKatsayisi){
	    gui.setBinaKatsayisiTextFieldText(binaKatsayisi);
	}
	
	public void updateBinaKatsayisiTextField(){
	    if(isNormalBolgeDurumuRadioButtonSelected()) binaDurumuKatsayilariArrayIndex1 = 0; 
	    if(isRuzgarliBolgeDurumuRadioButtonSelected()) binaDurumuKatsayilariArrayIndex1 = 1;
	    if(isMahfuzBinaDurumuRadioButtonSelected()) binaDurumuKatsayilariArrayIndex2 = 0;
	    if(isSerbestBinaDurumuRadioButtonSelected()) binaDurumuKatsayilariArrayIndex2 = 1;
	    if(isCokSerbestBinaDurumuRadioButtonSelected()) binaDurumuKatsayilariArrayIndex2 = 2;
	    if(isBitisikNizamRadioButtonSelected()) binaDurumuKatsayilariArrayIndex3 = 0;
	    if(isAyrikNizamRadioButtonSelected()) binaDurumuKatsayilariArrayIndex3 = 1;
	    
	    double binaKatsayisi = binaDurumKatsayilari[binaDurumuKatsayilariArrayIndex1][binaDurumuKatsayilariArrayIndex2][binaDurumuKatsayilariArrayIndex3];
	    bina.setBinaDurumKatsayisi(binaKatsayisi);
	    setBinaKatsayisiTextFieldText(binaKatsayisi);
	}
	
	
	public void updateSizdirganlikKatsayisiTextField(){
	    if(isAhsapMalzemeRadioButtonSelected()) sizdirganlikKatsayilariArrayIndex1 = 0;
	    if(isPlastikMalzemeRadioButtonSelected()) sizdirganlikKatsayilariArrayIndex1 = 1;
	    if(isMetalMalzemeRadioButtonSelected()) sizdirganlikKatsayilariArrayIndex1 = 2;
	    if(isTekAcilirliTipRadioButtonSelected()) sizdirganlikKatsayilariArrayIndex2 = 0;
	    if(isCiftCamliTipRadioButtonSelected()) sizdirganlikKatsayilariArrayIndex2 = 1;
	    if(isCiftAcilirliTipRadioButtonSelected()) sizdirganlikKatsayilariArrayIndex2 = 2;
	    
	    double sizdirganlikKatsayisi = sizdirganlikKatsayilari[sizdirganlikKatsayilariArrayIndex1][sizdirganlikKatsayilariArrayIndex2];
	    bina.setSizdirganlikKatsayisi(sizdirganlikKatsayisi);
	    gui.setSizdirganlikKatsayisiTextFieldText(sizdirganlikKatsayisi);
	}

    private void addIsiYalitimPanelComponentListener(){
        gui.setJPanel7ComponentListener(new java.awt.event.ComponentAdapter() { 
        	public void componentShown(java.awt.event.ComponentEvent e) {    
        		updateStandartBilesenlerTable();
        	}
        });
    }

    protected void updateStandartBilesenlerTable() {
		Object columnNames[] = {"Yapý Bileþeni", "1/\u039B (m2K/W)", "1/\u039B (m2K/W)", "U (W/m2 K)", "A (m2)","UxA (W/K)"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
		
        DuvarYapiElemani standartDuvar = (DuvarYapiElemani)bina.getProje().getCogunluklaKullanilanDisDuvar();
        StandartYalitimBileseni duvar = new StandartYalitimBileseni();
        if(standartDuvar!=null){            
            duvar.setAd("Dýþ duvar ("+standartDuvar.getYapiElemaniKodu()+")");
            if(bina.getProje().getBolge()!=null){
                duvar.setYonetmelikLambda(bina.getProje().getBolge().getStandartLambda());   
            }            
            duvar.setLambda(standartDuvar.getLambda());
            duvar.setU(standartDuvar.getIsiGecirgenlikKatsayisi());
            double duvarAlani = bina.hesaplaToplamDuvarAlaniForCommonDuvar(bina.getProje().getCogunluklaKullanilanDisDuvar().getYapiElemaniKodu());
            duvar.setA(duvarAlani);
            duvar.setUxA(duvar.getU()*duvarAlani);
            tableModel.addRow(duvar.getTableRow());
        }
        PencereYapiElemani standartPencere = (PencereYapiElemani)bina.getProje().getCogunluklaKullanilanPencere();
        StandartYalitimBileseni pencere = new StandartYalitimBileseni();
        if(standartPencere!=null){            
            pencere.setAd("Pencere ("+standartPencere.getYapiElemaniKodu()+")");
            pencere.setU(standartPencere.getIsiGecirgenlikKatsayisi());
            double pencereAlani = bina.hesaplaToplamBasitAlaniForCommonBasit(bina.getProje().getCogunluklaKullanilanPencere().getYapiElemaniKodu());
            pencere.setA(pencereAlani);
            pencere.setUxA(pencere.getU()*pencereAlani);
            tableModel.addRow(pencere.getTableRow());
        }
        KapiYapiElemani standartKapi = (KapiYapiElemani)bina.getProje().getCogunluklaKullanilanDisKapi();
        StandartYalitimBileseni kapi = new StandartYalitimBileseni();
        if(standartKapi!=null){            
            kapi.setAd("Kapi ("+standartKapi.getYapiElemaniKodu()+")");
            kapi.setU(standartKapi.getIsiGecirgenlikKatsayisi());
            double kapiAlani = bina.hesaplaToplamBasitAlaniForCommonBasit(bina.getProje().getCogunluklaKullanilanDisKapi().getYapiElemaniKodu());
            kapi.setA(kapiAlani);
            kapi.setUxA(kapi.getU()*kapiAlani);
            tableModel.addRow(kapi.getTableRow());
        }        		
		gui.setStandartBilesenlerTableModel(tableModel);
    }

    private void addKazanPanelComponentListener(){
        gui.setJPanel2ComponentListener(new java.awt.event.ComponentAdapter() { 
        	public void componentShown(java.awt.event.ComponentEvent e) {    
        	    updateKazanPanel();
        	}
        });
    }

    protected void updateKazanPanel() {
        double toplamBinaIsiIhtiyaci = bina.hesaplaToplamIsiIhtiyaci();
        Radyator secilenModel = bina.getProje().getEnCokKullanilanRadyatorModeli();
        double toplamDilim = 0;
        if(secilenModel!=null){
        	toplamDilim = toplamBinaIsiIhtiyaci/secilenModel.getGuc();
        	bina.getIsitici().setIsiticiKapasitesi(toplamDilim*secilenModel.getGuc());
        }        
        gui.updateKazanPanel(bina.getIsitici(),bina.getKritikHat());
    }

    private void addKazanSecDialogTamamButtonListener() {
        getKazanSecDialog().addTamamButtonListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String model = getKazanSecDialog().getSelectedKazanModel();
                gui.setKazanModeliTextFieldText(model);
                getKazanSecDialog().dispose();
            }
        });
    }    

    private void setIsiYalitimiBilesenleriTableModel() {
	    IsiYalitimiTableModel tableModel = new IsiYalitimiTableModel(bina.getEkIsiYalitimBilesenleri());
        gui.setIsiYalitimiBilesenleriTableModel(tableModel);
    }

    // Save & Load
    
    
    public void loadBina(){
        if(binaDurumuKatsayilariArrayIndex1==0)gui.setNormalBolgeDurumuRadioButtonSelected(true);
        if(binaDurumuKatsayilariArrayIndex1==1)gui.setRuzgarliBolgeDurumuRadioButtonSelected(true);
        
        if(binaDurumuKatsayilariArrayIndex2==0)gui.setMahfuzBinaDurumuRadioButtonSelected(true);
        if(binaDurumuKatsayilariArrayIndex2==1)gui.setSerbestBinaDurumuRadioButtonSelected(true);
        if(binaDurumuKatsayilariArrayIndex2==2)gui.setCokSerbestBinaDurumuRadioButtonSelected(true);
        
        if(binaDurumuKatsayilariArrayIndex3==0) gui.setBitisikNizamRadioButtonSelected(true);
        if(binaDurumuKatsayilariArrayIndex3==1) gui.setAyrikNizamRadioButtonSelected(true);
        
        double odaDurumKatsayisi = bina.getOdaDurumKatsayisi();
        if(odaDurumKatsayisi==0.7) gui.setOdaDurumKatsayisi07RadioButtonActionSelected(true);
        if(odaDurumKatsayisi==0.9) gui.setOdaDurumKatsayisi09RadioButtonActionSelected(true);
        int isletmeTipi = bina.getIsletmeTipi();
        if(isletmeTipi==1) gui.setIsletme1RadioButtonSelected(true); 
        if(isletmeTipi==2) gui.setIsletme2RadioButtonSelected(true);
        if(isletmeTipi==3) gui.setIsletme3RadioButtonSelected(true);
        if(sizdirganlikKatsayilariArrayIndex1==0) gui.setMalzemeAhsapRadioButtonSelected(true);
        if(sizdirganlikKatsayilariArrayIndex1==1) gui.setMalzemePlastikRadioButtonSelected(true);
        if(sizdirganlikKatsayilariArrayIndex1==2) gui.setMalzemeMetalRadioButtonSelected(true);
        if(sizdirganlikKatsayilariArrayIndex1==0) gui.setTipTekAcilirliRadioButtonSelected(true);
        if(sizdirganlikKatsayilariArrayIndex1==1) gui.setTipCiftCamliRadioButtonSelected(true);
        if(sizdirganlikKatsayilariArrayIndex1==2) gui.setTipCiftAcilirliRadioButtonSelected(true);
        gui.setSizdirganlikKatsayisiTextFieldText(bina.getSizdirganlikKatsayisi());
        if(proje.getEnCokKullanilanRadyatorModeli()!=null)gui.setRadyatorModeliTextFieldText(proje.getEnCokKullanilanRadyatorModeli().getModel());
        if(proje.getCogunluklaKullanilanDisDuvar()!=null)gui.setDisDuvarTextFieldText(proje.getCogunluklaKullanilanDisDuvar().getYapiElemaniKodu());
        if(proje.getCogunluklaKullanilanIcDuvar()!=null)gui.setIcDuvarTextFieldText(proje.getCogunluklaKullanilanIcDuvar().getYapiElemaniKodu());
        if(proje.getCogunluklaKullanilanDisKapi()!=null)gui.setDisKapiTextFieldText(proje.getCogunluklaKullanilanDisKapi().getYapiElemaniKodu());
        if(proje.getCogunluklaKullanilanIcKapi()!=null)gui.setIcKapiTextFieldText(proje.getCogunluklaKullanilanIcKapi().getYapiElemaniKodu());
        if(proje.getCogunluklaKullanilanPencere()!=null)gui.setPencereTextFieldText(proje.getCogunluklaKullanilanPencere().getYapiElemaniKodu());
        String isiticiTuru = bina.getIsitici().getIsiticiTuru();
        if(isiticiTuru.equals("Kombi")) gui.setKombiIsiticiTuruRadioButtonSelected();
        if(isiticiTuru.equals("Kazan")) gui.setKazanIsiticiTuruRadioButtonSelected();
        treeController.bina = this.bina;
        treeController.setDdTreePanelBinaTreeModel();
        treeController.treeUpdate();
        Iterator it = bina.getKritikHat().getBoruParcalari().iterator();
        while(it.hasNext()){
            BoruParcasi parca = (BoruParcasi) it.next();
            KritikHatTableModel model = (KritikHatTableModel)gui.getKritikHatTableModel();
            model.add(parca);
        }
        if(bina.getIsitici()!=null){
            IsiticiModeliInt isitici = bina.getIsitici().getSecilenIsitici();
            if(isitici!=null)gui.setKazanModeliTextFieldText(isitici.getModelAdi()+" "+isitici.getTip());
            double dolasimIsiKaybi = bina.getIsitici().getDolasimIsiKaybi();
            if(dolasimIsiKaybi!=0.1)gui.setDolasimIsiKaybiSelectedItem(""+bina.getIsitici().getDolasimIsiKaybi());
            else gui.setDolasimIsiKaybiSelectedItem(""+bina.getIsitici().getDolasimIsiKaybi()+"0");
        }
        setIsiYalitimiBilesenleriTableModel();
    }
    
    public KazanSecDialog getKazanSecDialog() {
        if(kazanSecDialog==null) kazanSecDialog = new KazanSecDialog(getKazanlarTableModel());
        return kazanSecDialog;
    }
    
    public KombiSecDialog getKombiSecDialog(){
        if(kombiSecDialog==null) kombiSecDialog = new KombiSecDialog(getKombilerTableModel());
        return kombiSecDialog;        
    }
}
