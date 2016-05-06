/*
 * Created on 14.Þub.2005
 *
 */
package com.iztek.dd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.iztek.dd.GUI.EkipmanSecimiDialog;
import com.iztek.dd.GUI.IsiKazanciPanel;
import com.iztek.dd.GUI.KlimaSecimiDialog;
import com.iztek.dd.GUI.ProjectGUI;
import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKazanci.domain.Aktivite;
import com.iztek.dd.IsiKazanci.domain.Cati;
import com.iztek.dd.IsiKazanci.domain.CatiCLTD;
import com.iztek.dd.IsiKazanci.domain.CatiCLTDs;
import com.iztek.dd.IsiKazanci.domain.DisDuvar;
import com.iztek.dd.IsiKazanci.domain.DisSicaklikDegerleri;
import com.iztek.dd.IsiKazanci.domain.DisSicakliklar;
import com.iztek.dd.IsiKazanci.domain.IcDuvar;
import com.iztek.dd.IsiKazanci.domain.IsiKazanan;
import com.iztek.dd.IsiKazanci.domain.IsiKazandiran;
import com.iztek.dd.IsiKazanci.domain.Pencere;
import com.iztek.dd.domain.Proje;
import com.iztek.dd.utilities.Il;

/**
 * @author Selim HENDRICKSON
 *
 */
public class IsiKazanciController {
    private ProjectGUI gui = null;
    public Proje proje = null;
    private IsiKazanciPanel ikPanel = null;
    public IsiKazanan mahal = new IsiKazanan();
    private KlimaSecimiDialog klimaSecimiDialog = new KlimaSecimiDialog();
    private EkipmanSecimiDialog ekipmanSecimiDialog = new EkipmanSecimiDialog();
    
    private int disDuvarCount = 0;
    private int pencereCount = 0;

    public IsiKazanciController(ProjectGUI gui,Proje proje){
    	this.gui = gui;
    	this.proje = proje;
    	ikPanel = gui.getIsiKazanciPanel1();    	
    	
    	addIKPanelComponentShownListener();
    	addMustakilMahalCheckBoxListener();
    	addHesapAyiComboBoxActionListener();
    	addHesapSaatiComboBoxActionListener();
    	addTasarimSartlariPanelComponentListener();
    	addDuvarEkleButtonActionListener();
    	addDuvarSilButtonActionListener();
    	addDuvarAlaniTextFieldKeyAdapter();
    	addDuvarListSelectionListener();
    	addDuvarYonuComboBoxListener();
    	addPencereEkleButtonActionListener();
    	addPencereSilButtonActionListener();
    	addPencereAlaniTextFieldKeyAdapter();
    	addPencereYonuComboBoxListener();
    	addPencereListSelectionListener();
    	addCatiAlaniTextFieldKeyAdapter();
    	addCatiUTextFieldKeyAdapter();
    	addCatiTipiComboBoxSelectionListener();
    	addDisDuvarIsiTransferKatsayisiTextFieldActionListener();
    	addPencereIsiTransferKatsayisiTextFieldActionListener();
    	addDisDuvarToplamBoyuTextFieldActionListener();
    	addMahalIciSicaklikFarkiCheckBoxListener();
    	addSicaklikFarkiTextFieldKeyListener();
    	addIcDuvarIsiTransferKatsayisiTextFieldKeyListener();
    	addIcDuvarAlaniTextFieldKeyListener();
    	addGolgelemeRadioButtonListener();
    	addCamTipiRadioButtonsListener();
    	addCamKalinligiComboBoxListener();
    	addGolgelemeTipiRadioButtonsListener();
    	addGolgelemeliCamTipiRadioButttonsListener();
    	addAynaTipiComboBoxListener();
    	addMobilyaTipiComboBoxActionListener();
    	addAydinlatmaSuresiRadioButtonListener();
    	addIsikSonrasiZamanComboBoxListener();
    	addAydinlatmaEkipmanlariToplamGucuTextFieldKeyListener();
    	addAktivitelerComboBoxListener();
    	addHacimdeKalmaSuresiComboBoxListener();
    	addHacimdeGecenSureComboBoxListener();
    	addInsanSayisiTextFieldKeyListener();
    	addIsinimKazanciPanelComponentShownListener();
    	addCihazlarýnToplamGuceTextFieldListener();
    	addCihazDavlumbazliCheckBoxListener();
    	addCihazToplamCalismaSuresiComboBoxListener();
    	addcihazToplamIsletmeSuresiComboBoxListener();
    	addCihazToplamGucuTextFieldKeyListener();
    	addHavaDebisiTextFieldKeyListener();
    	addIcOzgulNemTextFieldListener();
    	addIletimTasinimPanelComponentShownListener();
    	addInsanlardanPanelComponentShownListener();
    	addKlimaSecButtonActionListener();
    	addKlimaSecimiDialogTamamButtonActionListener();
    	addCihazSecButtonActionListener();
    	addEkipmanSecimiDialogTamamButtonActionListener();
    }

    ComponentListener ilDegerleriSetter = new ComponentListener(){
        public void componentShown(ComponentEvent e) {
            Il ilObject = proje.getIl();                
            if(ilObject!=null){
                String il = ilObject.getAd();
                DisSicaklikDegerleri deger = DisSicakliklar.getInstance().getDisSicaklikDegerleri(il);
                ikPanel.setDisSicaklikTextFieldTextFieldText(deger.getMaksimumDisSicaklik());
                ikPanel.setDisOzgulNemTextFieldText(deger.getDisOzgulNem());
                mahal.setDisSicaklik(deger.getMaksimumDisSicaklik());
                mahal.setDisOzgulNem((new Double(deger.getDisOzgulNem())).floatValue());
                mahal.setSicaklikFarki((new Double(deger.getGunlukSicaklikFarki())).floatValue());
            }              
        }

        public void componentResized(ComponentEvent e) {
        }

        public void componentMoved(ComponentEvent e) {
        }

        public void componentHidden(ComponentEvent e) {
        }
    };
    
    private void addIcOzgulNemTextFieldListener() {
        ikPanel.addIcOzgulNemTextFieldListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getIcOzgulNemTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
                    mahal.setIcOzgulNem(Float.parseFloat(text));
                } catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setIcOzgulNemTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
                updateEnfiltrasyonYukuTextFieldText();                
            }            
        });
    }    
    
    ActionListener golgelemeRadioButtonsListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            JRadioButton rb = (JRadioButton)e.getSource();            
            String command = e.getActionCommand();
            if(command.equals("GYT")) setPencerelerGolgelemeli(false);
            if(command.equals("GYC")) setPencerelerGolgelemeli(false);
            if(command.equals("GC")) setPencerelerGolgelemeli(true);
            ikPanel.setDirektGunesYukuTextFieldText(""+mahal.hesaplaToplamRadyasyonYoluylaIsiKazanci());
        }
    };
    
    ActionListener camTipiRadioButtonsListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {            
            String command = e.getActionCommand();
            mahal.setCamTipi(command);
            ikPanel.setDirektGunesYukuTextFieldText(""+mahal.hesaplaToplamRadyasyonYoluylaIsiKazanci());
        }
    };

    ActionListener golgelemeliCamTipiRadioButtonsListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {            
            String command = e.getActionCommand();
            if(command.equals("N3")){
                mahal.setCamTipi("Normal");
                mahal.setPencereKalinliklari(3);
            }
            if(command.equals("N6")){
                mahal.setCamTipi("Normal");
                mahal.setPencereKalinliklari(6);
            }
            if(command.equals("D6")){
                mahal.setCamTipi("Isý Absorblama");
                mahal.setPencereKalinliklari(6);
            }
            if(command.equals("A")){
                mahal.setCamTipi("Aynali");
            }
            ikPanel.setDirektGunesYukuTextFieldText(""+mahal.hesaplaToplamRadyasyonYoluylaIsiKazanci());
        }
    };

    ActionListener golgelemeTipiRadioButtonsListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {            
            String command = e.getActionCommand();
            mahal.setPencereGolgelemeTipi(command);        
            ikPanel.setDirektGunesYukuTextFieldText(""+mahal.hesaplaToplamRadyasyonYoluylaIsiKazanci());
        }
    };

    ActionListener aydinlatmaSuresiRadioButtonListener = new ActionListener(){
        public void actionPerformed(ActionEvent e){            
            mahal.setAydinlatmaSuresi(e.getActionCommand());
            ikPanel.setAydinlanmaToplamIsiKazanciTextFieldText(mahal.hesaplaAydinlatmaIsiKazanci());
        }
    };
    // Action Listeners

    private void addIKPanelComponentShownListener() {
        ikPanel.addIKPanelComponentShownListener(ilDegerleriSetter);
    }

    private void addIletimTasinimPanelComponentShownListener() {
        ikPanel.addIletimTasinimPanelComponentShownListener(new ComponentAdapter(){
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                ikPanel.setIletimYoluIleIsiKazanciTextFieldText(mahal.hesaplaToplamIletimYoluylaIsiKazanci());
                if(mahal.getCati()!=null) ikPanel.setCatiAlaniTextFieldText(""+mahal.getCati().getAlan());
            }
        });
    }

    protected void setPencerelerGolgelemeli(boolean b) {
        mahal.setPencerelerGolgelemeli(b);
    }

    private void addMustakilMahalCheckBoxListener() {
        ikPanel.addMustakilMahalCheckBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                mahal.setMustakil(!ikPanel.isMustakilCheckBoxChecked());
                if(!mahal.isMustakil()){
                    mahal.addIsiKazandiran(new Cati());
                }else mahal.deleteCati();
                ikPanel.setCatilAlaniTextFieldEnabled(!mahal.isMustakil());
                ikPanel.setCatiAlaniTextFieldText("");
                ikPanel.setCatiUTextFieldEnabled(!mahal.isMustakil());
                ikPanel.setCatiUTextFieldText("");
                ikPanel.setCatiTipiComboBoxEnabled(!mahal.isMustakil());
            }
        });
    }

    private void addHesapAyiComboBoxActionListener() {
        ikPanel.addHesapAyiComboBoxActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                mahal.setAy(ikPanel.getHesapAyiComboBoxSelectedIndex());
            } 
        });
    }

    private void addHesapSaatiComboBoxActionListener() {
        ikPanel.addHesapSaatiComboBoxActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                mahal.setSaat(ikPanel.getHesapSaatiComboBoxSelectedIndex());
            } 
        });
    }

    private void addTasarimSartlariPanelComponentListener(){
        ikPanel.addTasarimSartlariPanelComponentListener(ilDegerleriSetter);
    }
    
    private void addDuvarEkleButtonActionListener() {
        ikPanel.addDuvarEkleButtonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                createDisDuvar();
            }
        });

    }

    private void createDisDuvar(){
        disDuvarCount++;                
        mahal.addIsiKazandiran(new DisDuvar(""+disDuvarCount+". duvar",mahal));
        ikPanel.addDuvarToDisDuvarList(""+disDuvarCount+". duvar");
    }
    
    private void addDuvarSilButtonActionListener() {
        ikPanel.addDuvarSilButtonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String removedDuvarIdentifier = ikPanel.getSelectedDisDuvarIdentifier();
                mahal.removeIsiKazandiran(removedDuvarIdentifier);
                ikPanel.removeDuvarFromDisDuvarList();
                if(ikPanel.isDuvarListEmpty()){
                    ikPanel.setDuvarAlaniTextFieldText("");
                    ikPanel.setDuvarYonuComboBoxSelectedYon(null);
                }
            }
        });
    }

    private void addDuvarAlaniTextFieldKeyAdapter() {
        ikPanel.addDuvarAlaniTextFieldKeyAdapter(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
				String text = (String)ikPanel.getDuvarAlaniTextFieldText();
				if(e.getKeyChar()!='f')text += e.getKeyChar();
				else text+= 's';
				try {					
				    ((DisDuvar)mahal.getIsiKazandiran(ikPanel.getSelectedDisDuvarIdentifier())).setAlan(Float.parseFloat(text));
				} catch (NumberFormatException e1) {
					if(text.length()>1) ikPanel.setDuvarAlaniTextFieldText(text.substring(0,text.length()-1));
					e.consume();
				}
            }
        });
    }

    private void addDuvarListSelectionListener() {
        ikPanel.addDuvarListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
                DisDuvar duvar = ((DisDuvar)mahal.getIsiKazandiran(ikPanel.getSelectedDisDuvarIdentifier()));
                if(duvar!=null){
                    ikPanel.setDuvarAlaniTextFieldText(""+duvar.getAlan());
                    ikPanel.setDuvarYonuComboBoxSelectedYon(duvar.getYon());
                }                
            }
        });
    }

    private void addDuvarYonuComboBoxListener() {
        ikPanel.addDuvarYonuComboBoxListener(new ActionListener(){            
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                ((DisDuvar)mahal.getIsiKazandiran(ikPanel.getSelectedDisDuvarIdentifier())).setYon((String)cb.getSelectedItem());
            }
        });
    }

    private void addPencereEkleButtonActionListener() {
        ikPanel.addPencereEkleButtonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                pencereCount++;                
                mahal.addIsiKazandiran(new Pencere(""+pencereCount+". pencere"));
                ikPanel.addPencereToPencereList(""+pencereCount+". pencere");
            }
        });

    }
    
    private void addPencereSilButtonActionListener() {
        ikPanel.addPencereSilButtonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String removedPencereIdentifier = ikPanel.getSelectedPencereIdentifier();
                mahal.removeIsiKazandiran(removedPencereIdentifier);
                ikPanel.removePencereFromPencereList();
                if(ikPanel.isPencereListEmpty()){
                    ikPanel.setPencereAlaniTextFieldText("");
                    ikPanel.setPencereYonuComboBoxSelectedYon(null);
                }
            }
        });
    }

    private void addPencereAlaniTextFieldKeyAdapter() {
        ikPanel.addPencereAlaniTextFieldKeyAdapter(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
				String text = (String)ikPanel.getPencereAlaniTextFieldText();
				if(e.getKeyChar()!='f')text += e.getKeyChar();
				else text+= 's';
				try {					
				    ((Pencere)mahal.getIsiKazandiran(ikPanel.getSelectedPencereIdentifier())).setAlan(Float.parseFloat(text));
				} catch (NumberFormatException e1) {
					if(text.length()>1) ikPanel.setPencereAlaniTextFieldText(text.substring(0,text.length()-1));
					e.consume();
				}
            }
        });
    }

    private void addPencereListSelectionListener() {
        ikPanel.addPencereListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
                Pencere pencere = ((Pencere)mahal.getIsiKazandiran(ikPanel.getSelectedPencereIdentifier()));
                if(pencere!=null){
                    ikPanel.setPencereAlaniTextFieldText(""+pencere.getAlan());
                    ikPanel.setPencereYonuComboBoxSelectedYon(pencere.getYon());
                }                
            }
        });
    }

    private void addPencereYonuComboBoxListener() {
        ikPanel.addPencereYonuComboBoxListener(new ActionListener(){            
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                ((Pencere)mahal.getIsiKazandiran(ikPanel.getSelectedPencereIdentifier())).setYon((String)cb.getSelectedItem());
            }
        });
    }

    private void addCatiAlaniTextFieldKeyAdapter(){
        ikPanel.addCatiAlaniTextFieldKeyAdapter(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getCatiAlaniTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
    			    Cati cati = mahal.getCati();
    			    cati.setAlan(Float.parseFloat(text));
    			} catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setCatiAlaniTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
    			ikPanel.setIletimYoluIleIsiKazanciTextFieldText(mahal.hesaplaToplamIletimYoluylaIsiKazanci());
            }
        });    
        
    }
    
    private void addCatiUTextFieldKeyAdapter() {
        ikPanel.addCatiUTextFieldKeyAdapter(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getCatiUTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
    			    Cati cati = mahal.getCati();
    			    cati.setAlan(Float.parseFloat(text));
    			} catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setCatiUTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
            }            
        });
    }

    private void addCatiTipiComboBoxSelectionListener() {
        ikPanel.addCatiTipiComboBoxSelectionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                CatiCLTD cltd = (CatiCLTD)((JComboBox)e.getSource()).getSelectedItem();
                mahal.getCati().setCatiTipi(cltd.getCatiTipi());
                mahal.getCati().setIsiTransferiKatsayisi(new Double(cltd.getIsiGecirgenlikKatsayisi()).floatValue());
                ikPanel.setCatiUTextFieldText(""+cltd.getIsiGecirgenlikKatsayisi());
                ikPanel.setIletimYoluIleIsiKazanciTextFieldText(mahal.hesaplaToplamIletimYoluylaIsiKazanci());
            }
        });
    }

    private void addDisDuvarToplamBoyuTextFieldActionListener() {
        ikPanel.addDisDuvarToplamBoyuTextFieldActionListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getDisDuvarToplamBoyuTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
    			    mahal.setToplamDisDuvarBoyu(Float.parseFloat(text));    			    
    			} catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.DisDuvarToplamBoyuTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
    			ikPanel.setIletimYoluIleIsiKazanciTextFieldText(mahal.hesaplaToplamIletimYoluylaIsiKazanci());
            }                        
        });
    }

    private void addPencereIsiTransferKatsayisiTextFieldActionListener() {
        ikPanel.addPencereIsiTransferKatsayisiTextFieldActionListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getPencereIsiTransferKatsayisiTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
    			    mahal.setPencereIsiTransferKatsayisi(Float.parseFloat(text));
    			} catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setPencereIsiTransferKatsayisiTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
    			ikPanel.setIletimYoluIleIsiKazanciTextFieldText(mahal.hesaplaToplamIletimYoluylaIsiKazanci());
            }                        
        });        
    }

    private void addDisDuvarIsiTransferKatsayisiTextFieldActionListener() {
        ikPanel.addDisDuvarIsiTransferKatsayisiTextFieldActionListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getDisDuvarIsiTransferKatsayisiTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
    			    mahal.setDisDuvarIsiTransferKatsayisi(Float.parseFloat(text));    			    
    			} catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setDisDuvarIsiTransferKatsayisiTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
    			ikPanel.setIletimYoluIleIsiKazanciTextFieldText(mahal.hesaplaToplamIletimYoluylaIsiKazanci());
            }                        
        });        

    }

    private void addMahalIciSicaklikFarkiCheckBoxListener() {
        ikPanel.addMahalIciSicaklikFarkiCheckBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                if(cb.isSelected()){
                    mahal.addIsiKazandiran(new IcDuvar());
                }else mahal.deleteIcDuvar();
            } 
        });
    }

    private void addSicaklikFarkiTextFieldKeyListener() {
        ikPanel.addSicaklikFarkiTextFieldKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getSicaklikFarkiTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
    			    IcDuvar icDuvar = mahal.getIcDuvar();
    			    icDuvar.setSicaklikFarki((new Float(text)).intValue());    			    
    			} catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setSicaklikFarkiTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
            }                        
        });
    }

    private void addIcDuvarIsiTransferKatsayisiTextFieldKeyListener() {
        ikPanel.addIcDuvarIsiTransferKatsayisiTextFieldKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getIcDuvarIsiTransferKatsayisiTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
    			    IcDuvar icDuvar = mahal.getIcDuvar();
    			    icDuvar.setIsiTransferiKatsayisi((new Float(text)).intValue());    			    
    			} catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setIcDuvarIsiTransferKatsayisiTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
            }                                    
        });
    }

    private void addIcDuvarAlaniTextFieldKeyListener() {
        ikPanel.addIcDuvarAlaniTextFieldKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getIcDuvarAlaniTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
    			    IcDuvar icDuvar = mahal.getIcDuvar();
    			    icDuvar.setAlan((new Float(text)).intValue());    			    
    			} catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setIcDuvarAlaniTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
    			updateIletimYoluIleIsiKazanci();
            }                                                
        });
    }

    public void updateIletimYoluIleIsiKazanci(){
        ikPanel.setIletimYoluIleIsiKazanciTextFieldText(mahal.hesaplaToplamIletimYoluylaIsiKazanci());
    }

    private void addGolgelemeRadioButtonListener() {
        ikPanel.addGolgelemeRadioButtonListener(golgelemeRadioButtonsListener);
    }

    private void addCamTipiRadioButtonsListener() {
        ikPanel.addCamTipiRadioButtonsListener(camTipiRadioButtonsListener);
    }

    private void addCamKalinligiComboBoxListener() {
        ikPanel.addCamKalinligiComboBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JComboBox cm = (JComboBox)e.getSource();
                String selected = (String)cm.getSelectedItem();
                selected = selected.substring(0,selected.indexOf(" "));               
                mahal.setPencereKalinliklari((Float.parseFloat(selected)));
                ikPanel.setDirektGunesYukuTextFieldText(""+mahal.hesaplaToplamRadyasyonYoluylaIsiKazanci());
            }
        });
    }

    private void addGolgelemeTipiRadioButtonsListener() {
        ikPanel.addGolgelemeTipiRadioButtonsListener(golgelemeTipiRadioButtonsListener);
    }

    private void addGolgelemeliCamTipiRadioButttonsListener() {
        ikPanel.addGolgelemeliCamTipiRadioButttonsListener(golgelemeliCamTipiRadioButtonsListener);
    }

    private void addAynaTipiComboBoxListener() {
        ikPanel.addAynaTipiComboBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String selectedValue = (String)cb.getSelectedItem();
                if(selectedValue.equals("ST=0.20")){
                    mahal.setPencereKalinliklari(0.20f);
                }
                if(selectedValue.equals("ST=0.30")){
                    mahal.setPencereKalinliklari(0.30f);
                }
                if(selectedValue.equals("ST=0.40")){
                    mahal.setPencereKalinliklari(0.40f);
                }
                ikPanel.setDirektGunesYukuTextFieldText(""+mahal.hesaplaToplamRadyasyonYoluylaIsiKazanci());
            }
        });
    }

    private void addMobilyaTipiComboBoxActionListener() {
        ikPanel.addMobilyaTipiComboBoxActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {             
                JComboBox cb = (JComboBox) e.getSource();
                String selectedValue =(String)cb.getSelectedItem();
                if(selectedValue!=null){
                    mahal.setAydinlatmaTip(selectedValue);
                    mahal.setMobilyaTipi(selectedValue);
                    ikPanel.setAydinlanmaToplamIsiKazanciTextFieldText(mahal.hesaplaAydinlatmaIsiKazanci());
                }                
            }
        });
    }

    private void addAydinlatmaSuresiRadioButtonListener() {
        ikPanel.addAydinlatmaSuresiRadioButtonListener(aydinlatmaSuresiRadioButtonListener);
    }


    private void addIsikSonrasiZamanComboBoxListener() {
        ikPanel.addIsikSonrasiZamanComboBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                mahal.setAydinlatmaGecenSure((String)cb.getSelectedItem());
                ikPanel.setAydinlanmaToplamIsiKazanciTextFieldText(mahal.hesaplaAydinlatmaIsiKazanci());
            }
        });
    }
    
    private void addAydinlatmaEkipmanlariToplamGucuTextFieldKeyListener() {
        ikPanel.addAydinlatmaIsiKazanciTextFieldKeyListener(new KeyAdapter(){            
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getAydinlatmaEkipmanlariToplamGucuTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
                    mahal.setAydinlatmaEkipmanGucu(Double.parseDouble(text));
                } catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setAydinlatmaEkipmanlariToplamGucuTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
                ikPanel.setAydinlanmaToplamIsiKazanciTextFieldText(mahal.hesaplaAydinlatmaIsiKazanci());
            }
        });        
    }


    private void addAktivitelerComboBoxListener() {
        ikPanel.addAktivitelerComboBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                Aktivite aktivite = (Aktivite)cb.getSelectedItem();
                mahal.setInsanAktivite(aktivite);
                ikPanel.setInsanlardanIsiKazanciTextFieldText(mahal.hesaplaInsanardanIsiKAzanci());
                ikPanel.setToplamIsiKazanciTextFieldText(mahal.hesaplaToplamIsiKazanci());
            }
        });
    }

    private void addHacimdeKalmaSuresiComboBoxListener() {
        ikPanel.addHacimdeKalmaSuresiComboBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                mahal.setHacimdeKalmaSuresi((String)cb.getSelectedItem());
                ikPanel.setInsanlardanIsiKazanciTextFieldText(mahal.hesaplaInsanardanIsiKAzanci());
                ikPanel.setToplamIsiKazanciTextFieldText(mahal.hesaplaToplamIsiKazanci());
            }
        });
    }
    
    private void addHacimdeGecenSureComboBoxListener() {
        ikPanel.addHacimdeGecenSureComboBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                mahal.setHacimdeGecenSure((String)cb.getSelectedItem());
                ikPanel.setInsanlardanIsiKazanciTextFieldText(mahal.hesaplaInsanardanIsiKAzanci());
                ikPanel.setToplamIsiKazanciTextFieldText(mahal.hesaplaToplamIsiKazanci());
            }
        });
    }

    private void addInsanSayisiTextFieldKeyListener() {
        ikPanel.addInsanSayisiTextFieldKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
				String text = (String)ikPanel.getInsanSayisiTextFieldText();
				if(e.getKeyChar()!='f')text += e.getKeyChar();
				else text+= 's';
				try {					
				    mahal.setInsanSayisi(Integer.parseInt(text));
				} catch (NumberFormatException e1) {
					if(text.length()>1) ikPanel.setInsanSayisiTextFieldText(text.substring(0,text.length()-1));
					e.consume();
				}
				ikPanel.setInsanlardanIsiKazanciTextFieldText(mahal.hesaplaInsanardanIsiKAzanci());
				ikPanel.setToplamIsiKazanciTextFieldText(mahal.hesaplaToplamIsiKazanci());
            }
        });
    }

    private void addIsinimKazanciPanelComponentShownListener(){
        ikPanel.addIsinimKazanciPanelComponentShownListener(new ComponentAdapter(){
            public void componentShown(ComponentEvent arg0) {
                ikPanel.setCatiAlaniTextFieldText(mahal.getCati().getAlan());
            }
        });
    }
    
    private void addCihazlarýnToplamGuceTextFieldListener() {
        ikPanel.addCihazlarýnToplamGuceTextFieldListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
				String text = (String)ikPanel.getCihazlarinToplamGucuTextFieldText();
				if(e.getKeyChar()!='f')text += e.getKeyChar();
				else text+= 's';
				try {					
				} catch (NumberFormatException e1) {
					if(text.length()>1) ikPanel.setCihazlarinToplamGucuTextFieldText(text.substring(0,text.length()-1));
					e.consume();
				}
				ikPanel.setInsanlardanIsiKazanciTextFieldText(mahal.hesaplaInsanardanIsiKAzanci());
            }           
        });
    }
    private void addCihazDavlumbazliCheckBoxListener() {
        ikPanel.addCihazDavlumbazliCheckBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                JCheckBox cb = (JCheckBox) arg0.getSource();
                boolean selected = cb.isSelected();
                mahal.setCihazDavlumbazli(selected);
                updateCihazlarToplamGucuTextFieldText();
            }
        });
    }

    private void addCihazToplamCalismaSuresiComboBoxListener() {
        ikPanel.addCihazToplamCalismaSuresiComboBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                JComboBox cb = (JComboBox) arg0.getSource();
                String selectedValue = (String)cb.getSelectedItem();
                mahal.setCihazCalismaSuresi(selectedValue);
                updateCihazlarToplamGucuTextFieldText();
            }
        });
    }

    private void addcihazToplamIsletmeSuresiComboBoxListener() {
        ikPanel.addcihazToplamIsletmeSuresiComboBoxListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                JComboBox cb =(JComboBox) arg0.getSource();
                String selectedValue = (String)cb.getSelectedItem();
                mahal.setCihazIsletmeSuresi(selectedValue);
                updateCihazlarToplamGucuTextFieldText();
            }
        });
    }

    private void addCihazToplamGucuTextFieldKeyListener() {
        ikPanel.addCihazToplamGucuTextFieldKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getCihazToplamGucuTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
                    mahal.setCihazToplamGucu(Double.parseDouble(text));
                } catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.setCihazToplamGucuTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
                updateCihazlarToplamGucuTextFieldText();                
            }
        });
    }

    private void updateCihazlarToplamGucuTextFieldText(){
        String value = ""+mahal.hesaplaCihazlardanGelenToplamYuk();
        ikPanel.updateCihazlarToplamGucuTextFieldText(value);
    }

    private void addHavaDebisiTextFieldKeyListener() {
        ikPanel.addHavaDebisiTextFieldKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
    			String text = (String)ikPanel.getHavaDebisiTextFieldText();
    			if(e.getKeyChar()!='f')text += e.getKeyChar();
    			else text+= 's';
    			try {					
                    mahal.setEnfiltrasyonHavaDebisi(Double.parseDouble(text));
                } catch (NumberFormatException e1) {
    				if(text.length()>1) ikPanel.sethavaDebisiTextFieldText(text.substring(0,text.length()-1));
    				e.consume();
    			}
                updateEnfiltrasyonYukuTextFieldText();  
                ikPanel.setToplamIsiKazanciTextFieldText(mahal.hesaplaToplamIsiKazanci());
            }
        });
    }

    protected void updateEnfiltrasyonYukuTextFieldText() {
        ikPanel.setEnfiltrasyonYukuTextFieldText(""+mahal.hesaplaEnfiltrasyonYuku());
    }
    
    private void addInsanlardanPanelComponentShownListener() {
        ikPanel.addInsanlardanPanelComponentShownListener(new ComponentAdapter(){
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                ikPanel.setToplamIsiKazanciTextFieldText(mahal.hesaplaToplamIsiKazanci());
            }
        });
    }

    private void addKlimaSecButtonActionListener() {
        ikPanel.addKlimaSecButtonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
        		klimaSecimiDialog.setIsiKazanci(mahal.hesaplaToplamIsiKazanci()/1000);
        		klimaSecimiDialog.updateTableModel();
        		SwingUtils.centerAndShowComponent(klimaSecimiDialog);            
            }
        });
    }

    private void addKlimaSecimiDialogTamamButtonActionListener(){
        klimaSecimiDialog.addKlimaSecimiDialogTamamButtonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int index = klimaSecimiDialog.getKlimalarTableSelectedRow();
                String selectedKlimaModeli = (String)((Vector)((DefaultTableModel)klimaSecimiDialog.getKlimalarTableModel()).getDataVector().elementAt(index)).elementAt(0);
                ikPanel.setJTextFieldText(selectedKlimaModeli);
                mahal.setKlimaModeli(selectedKlimaModeli);
			    klimaSecimiDialog.dispose();
            }
        });
    }

    private void addCihazSecButtonActionListener() {
        ikPanel.addCihazSecButtonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SwingUtils.centerAndShowComponent(ekipmanSecimiDialog);                
            }
        });
    }

    private void addEkipmanSecimiDialogTamamButtonActionListener() {
        ekipmanSecimiDialog.addTamamButtonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String toplamGucString = ekipmanSecimiDialog.getToplamGucTextFieldText();
                ikPanel.setCihazlarinToplamGucuTextFieldText(toplamGucString);                
                mahal.setCihazToplamGucu(Double.parseDouble(toplamGucString));
                ikPanel.updateCihazlarToplamGucuTextFieldText(""+mahal.hesaplaCihazlardanGelenToplamYuk());
                ekipmanSecimiDialog.dispose();
            }
        });
    }

    //Save & Load
    
    public void loadIsiKazanci(){
        if(mahal.getCati()!=null){
            ikPanel.setMustakilMahalCheckBoxSelected(true);
            ikPanel.setCatilAlaniTextFieldEnabled(true);
            ikPanel.setCatiTipiComboBoxEnabled(true);
            ikPanel.setCatiUTextFieldEnabled(true);
            ikPanel.setCatiAlaniTextFieldText(mahal.getCati().getAlan());
            ikPanel.setCatiUTextFieldText(""+mahal.getCati().getIsiTransferiKatsayisi());
            if(mahal.getCati().getCatiTipi()!=null)ikPanel.setCatiTipiComboBoxSelectedItem(CatiCLTDs.getInstance().getCatiCLDT(mahal.getCati().getCatiTipi()));            
        }
        ikPanel.setHesapAyiComboBoxSelectedItem(mahal.getAy());
        ikPanel.setHesapSattiComboBoxSelectedItem(""+(mahal.getSaat()+1));
        ikPanel.setIcOzgulNemTextFieldText(""+mahal.getIcOzgulNem());
        Iterator it  = ((ArrayList)mahal.getIsiKazandiranlar()).iterator();
        while(it.hasNext()){
            IsiKazandiran isiKazandiran = (IsiKazandiran) it.next();
            if(isiKazandiran instanceof DisDuvar){
                String identifier = ((DisDuvar)isiKazandiran).getIdentifier();
                ikPanel.addDuvarToDisDuvarList(identifier);
            }
            if(isiKazandiran instanceof Pencere){
                String identifier = ((Pencere)isiKazandiran).getIdentifier();
                ikPanel.addPencereToPencereList(identifier);
            }
        }
        ikPanel.setDisDuvarIsiTransferKatsayisiTextFieldText(""+mahal.getDisDuvarIsiTransferKatsayisi());
        ikPanel.setPencereIsiTransferKatsayisiTextFieldText(""+mahal.getPencereIsiTransferKatsayisi());
        ikPanel.DisDuvarToplamBoyuTextFieldText(""+mahal.getToplamDisDuvarBoyu());
        if(mahal.getIcDuvar()!=null){
            ikPanel.setMahalIciSicaklikFarkiVarCheckBoxSelected(true);
            ikPanel.setSicaklikFarkiTextFieldEnabled(true);
            ikPanel.setSicaklikFarkiTextFieldText(""+mahal.getIcDuvar().getSicaklikFarki());
            ikPanel.setIcDuvarAlaniTextFieldEnabled(true);  
            ikPanel.setIcDuvarAlaniTextFieldText(""+mahal.getIcDuvar().getAlan());
            ikPanel.setIcDuvarIsiTransferKatsayisiTextField(true);
            ikPanel.setIcDuvarIsiTransferKatsayisiTextFieldText(""+mahal.getIcDuvar().getIsiTransferiKatsayisi());
        }
        if(mahal.getIsiKazandiran("1. pencere")!=null){
            Pencere pencere = ((Pencere)mahal.getIsiKazandiran("1. pencere"));
            boolean state = pencere.isGolgelemeYapilmis();
            ikPanel.setGolgelemeliCiftPencereRadioButtonSelected(state);
            ikPanel.setGolgelemesizTekPencereRadioButtonSelected(!state);
            ikPanel.enableWidgetsWithRespectToGolgeleme(state);
            
            if(pencere.getCamTipi()!=null){
                if(pencere.getCamTipi().equals("Normal"))ikPanel.setNormalCamTipiRadioButtonSelected(true);
                if(pencere.getCamTipi().equals("Isý Absorblama"))ikPanel.setIsiAbsorbsiyonluCamTipiRadioButtonSelected(true);
                if(pencere.getCamTipi().equals("Normal çift camlý pencere"))ikPanel.setNormalCiftCamRadioButtonSelected(true);
                if(pencere.getCamTipi().equals("Normal")&&pencere.getKalinlik()==3) ikPanel.setNormalCamKalinligi3RadioButtonSelected(true);
                if(pencere.getCamTipi().equals("Normal")&&pencere.getKalinlik()==6) ikPanel.setNormalCamKalinligi6RadioButtonSelected(true);
            }
            if(pencere.getGolgelemeTipi().equals("JK"))ikPanel.setKoyuJaluziRadioButtonSelected(true);
            if(pencere.getGolgelemeTipi().equals("JA"))ikPanel.setAcikJaluziRadioButtonSelected(true);
            if(pencere.getGolgelemeTipi().equals("PK"))ikPanel.setKoyuPerdeRadioButtonSelected(true);
            if(pencere.getGolgelemeTipi().equals("PA"))ikPanel.setAcikPerdeRadioButtonSelected(true);
            if(pencere.getGolgelemeTipi().equals("PI"))ikPanel.setIsikGecirgenPerdeRadioButtonSelected(true);
            ikPanel.setCamKalinligiComboBoxSelectedItem(""+(new Float(pencere.getKalinlik())).intValue()+" mm");            
        }
        ikPanel.setMobilyaTipiComboBoxSelectedValue(mahal.getMobilyaTipi());
        if(mahal.getAydinlatma().getAydinlatmaSuresi()==8)ikPanel.setAydinlatmaSuresi8RadioBoxSelected(true);
        if(mahal.getAydinlatma().getAydinlatmaSuresi()==12)ikPanel.setAydinlatmaSuresi12RadioBoxSelected(true);
        ikPanel.setAydinlanmaSonrasiGecenZamanComboBoxSelectedItem(""+mahal.getAydinlatma().getIsikYandiktanSonraGecenSure());
        ikPanel.setCihazlarinToplamGucuTextField(mahal.getCihaz().getGuc());
        ikPanel.setCihazDavlumbazliCheckBoxSelected(mahal.getCihaz().isDavlumbazli());
        ikPanel.setToplamCalismaSuresiComboBoxSelectedItem(mahal.getCihaz().getCalistigiToplamSaat());
        ikPanel.setToplamIsletmeSuresiComboBoxSelectedItem(mahal.getCihaz().getIsletmeyeAlindiktanSonraGecenSaat());
        ikPanel.setAydinlatnaElemanlarininToplamGucuTextField(mahal.getAydinlatma().getGuc());
        ikPanel.setAktivitelerComboBoxSelectedItem(mahal.getInsan().getAktiviteTuru());
        ikPanel.setHacimdeKalmaSuresiComboBoxSelectedItem(mahal.getInsan().getHacimdeToplamKalmaSuresi());
        ikPanel.setHacimeGirdiktenSonraGecenZaman(mahal.getInsan().getHacimeGirdiktenSonraGecenZaman());
        ikPanel.setHacimdekiInsanSayisi(mahal.getInsan().getInsanSayisi());
        ikPanel.sethavaDebisiTextFieldText(""+mahal.getEnfiltrasyon().getHavaDebisi());
        ikPanel.setEnfiltrasyonYukuTextFieldText(""+mahal.hesaplaEnfiltrasyonYuku());
        ikPanel.setSecilenKlimaTextField(mahal.getKlimaModeli());
    }
}
