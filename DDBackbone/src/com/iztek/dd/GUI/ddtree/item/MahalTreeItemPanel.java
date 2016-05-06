/*
 * Created on 01.Ara.2004
 *
 */
package com.iztek.dd.GUI.ddtree.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.util.Collection;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.iztek.dd.GUI.IcSicaklikSecimiDialog;
import com.iztek.dd.GUI.RadyatorModeliSecimiDialog;
import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.GUI.wrappers.IcSicaklikSecimTableModel;
import com.iztek.dd.GUI.wrappers.RadyatorSecimTableModel;
import com.iztek.dd.IsiKaybi.domain.IcSicaklik;
import com.iztek.dd.IsiKaybi.domain.IcSicakliklar;
import com.iztek.dd.IsiKaybi.domain.Mahal;
import com.iztek.dd.IsiKaybi.domain.Radyator;
import com.iztek.dd.IsiKaybi.domain.Radyatorler;
import com.iztek.dd.utilities.TreeItemSelectionEvent;
import javax.swing.JButton;
/**
 * @author Selim HENDRICKSON
 *
 */
public class MahalTreeItemPanel extends TreeItemPanel {
	private Mahal activeMahal = null;
	private IcSicaklikSecimiDialog icSicaklikSecimiDialog = new IcSicaklikSecimiDialog(this);
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 4475065275605957375L;
	
	private javax.swing.JLabel mahalKoduLabel = null;
	private javax.swing.JTextField mahalKoduTextField = null;
	private javax.swing.JLabel mahalAdiLabel = null;
	private javax.swing.JTextField mahalAdiTextField = null;
	private javax.swing.JLabel mahalIcSicakligiLabel = null;
	private javax.swing.JTextField mahalIcSicakligiTextField = null;
	private javax.swing.JButton mahalIcSicakligiSecButton = null;
	private javax.swing.JLabel radyatorGrupSayisiLabel = null;
	private javax.swing.JTextField radyatorGrupSayisiTextField = null;
	private javax.swing.JLabel pencereAltiYuksekligiLabel = null;
	private javax.swing.JTextField pencereAltiYuksekligiTextField = null;
	private javax.swing.JLabel radyatorModeliLabel = null;
	private javax.swing.JTextField radyatorModeliTextField = null;
	private JLabel jLabel = null;
	private JComboBox yonComboBox = null;
	private JLabel birimLabel = null;
	private JButton radyatorModeliSecButton = null;
	private JLabel jLabel1 = null;
	/**
	 * This method initializes 
	 * 
	 */
	public MahalTreeItemPanel() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        jLabel1 = new JLabel();
        birimLabel = new JLabel();
        jLabel = new JLabel();
        this.setLayout(null);
        this.add(getMahalKoduLabel(), null);
        this.add(getMahalKoduTextField(), null);
        this.add(getMahalAdiLabel(), null);
        this.add(getMahalAdiTextField(), null);
        this.add(getMahalIcSicakligiLabel(), null);
        this.add(getMahalIcSicakligiTextField(), null);
        this.add(getMahalIcSicakligiSecButton(), null);
        this.add(getRadyatorGrupSayisiLabel(), null);
        this.add(getRadyatorGrupSayisiTextField(), null);
        this.add(getPencereAltiYuksekligiLabel(), null);
        this.add(getPencereAltiYuksekligiTextField(), null);
        this.add(getRadyatorModeliLabel(), null);
        this.add(getRadyatorModeliTextField(), null);
        this.setSize(346, 374);
        jLabel.setBounds(17, 142, 104, 24);
        jLabel.setText("Yön");
        birimLabel.setBounds(268, 261, 26, 24);
        birimLabel.setText("mm");
        jLabel1.setBounds(269, 182, 18, 24);
        jLabel1.setText("\u00B0C");
        this.add(jLabel, null);
        this.add(getYonComboBox(), null);
        this.add(birimLabel, null);
        this.add(getRadyatorModeliSecButton(), null);
        this.add(jLabel1, null);
			
	}
	public void setMahalKoduTextFieldText(String name){
		getMahalKoduTextField().setText(name);
	}
	/**
	 * This method initializes mahalKoduLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getMahalKoduLabel() {
		if(mahalKoduLabel == null) {
			mahalKoduLabel = new javax.swing.JLabel();
			mahalKoduLabel.setBounds(17, 66, 75, 24);
			mahalKoduLabel.setText("Mahal kodu");
		}
		return mahalKoduLabel;
	}
	/**
	 * This method initializes mahalKoduTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getMahalKoduTextField() {
		if(mahalKoduTextField == null) {
			mahalKoduTextField = new javax.swing.JTextField();
			mahalKoduTextField.setBounds(158, 66, 106, 24);
			mahalKoduTextField.setEditable(true);
			mahalKoduTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {  					
					activeMahal.setMahalkodu(getMahalKoduTextField().getText()+e.getKeyChar());
				}
			});
		}
		return mahalKoduTextField;
	}
	/**
	 * This method initializes mahalAdiLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getMahalAdiLabel() {
		if(mahalAdiLabel == null) {
			mahalAdiLabel = new javax.swing.JLabel();
			mahalAdiLabel.setBounds(17, 105, 75, 24);
			mahalAdiLabel.setText("Mahal adý");
		}
		return mahalAdiLabel;
	}
	/**
	 * This method initializes mahalAdiTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getMahalAdiTextField() {
		if(mahalAdiTextField == null) {
			mahalAdiTextField = new javax.swing.JTextField();
			mahalAdiTextField.setBounds(158, 105, 106, 24);
			mahalAdiTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					activeMahal.setMahalAdi(getMahalAdiTextFieldText()+e.getKeyChar());
				}
			});
		}
		return mahalAdiTextField;
	}
	/**
	 * This method initializes mahalIcSicakligiLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getMahalIcSicakligiLabel() {
		if(mahalIcSicakligiLabel == null) {
			mahalIcSicakligiLabel = new javax.swing.JLabel();
			mahalIcSicakligiLabel.setBounds(17, 182, 104, 24);
			mahalIcSicakligiLabel.setText("Mahal iç sýcaklýðý");
		}
		return mahalIcSicakligiLabel;
	}
	/**
	 * This method initializes mahalIcSicakligiTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getMahalIcSicakligiTextField() {
		if(mahalIcSicakligiTextField == null) {
			mahalIcSicakligiTextField = new javax.swing.JTextField();
			mahalIcSicakligiTextField.setBounds(158, 182, 106, 24);
			mahalIcSicakligiTextField.setText("");
			mahalIcSicakligiTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {
					String text = getMahalIcSicakligiTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
						activeMahal.setIcSicaklik(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) mahalIcSicakligiTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return mahalIcSicakligiTextField;
	}
	/**
	 * This method initializes mahalIcSicakligiSecButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getMahalIcSicakligiSecButton() {
		if(mahalIcSicakligiSecButton == null) {
			mahalIcSicakligiSecButton = new javax.swing.JButton();
			mahalIcSicakligiSecButton.setBounds(292, 182, 36, 24);
			mahalIcSicakligiSecButton.setText("...");
			mahalIcSicakligiSecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					icSicaklikSecimiDialog.setIcSicaklikModelleriTableModel(new IcSicaklikSecimTableModel(IcSicakliklar.getInstance().getIcSicakliklar()));
					SwingUtils.centerAndShowComponent(icSicaklikSecimiDialog);
				}	
			});
		}
		return mahalIcSicakligiSecButton;
	}
	/**
	 * This method initializes radyatorGrupSayisiLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getRadyatorGrupSayisiLabel() {
		if(radyatorGrupSayisiLabel == null) {
			radyatorGrupSayisiLabel = new javax.swing.JLabel();
			radyatorGrupSayisiLabel.setBounds(17, 221, 118, 24);
			radyatorGrupSayisiLabel.setText("Radyatör grup sayýsý");
		}
		return radyatorGrupSayisiLabel;
	}
	/**
	 * This method initializes radyatorGrupSayisiTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getRadyatorGrupSayisiTextField() {
		if(radyatorGrupSayisiTextField == null) {
			radyatorGrupSayisiTextField = new javax.swing.JTextField();
			radyatorGrupSayisiTextField.setBounds(158, 221, 106, 24);
			radyatorGrupSayisiTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getRadyatorGrupSayisiTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
						activeMahal.setRadyatorGrupSayisi(Integer.parseInt(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) radyatorGrupSayisiTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return radyatorGrupSayisiTextField;
	}
	/**
	 * This method initializes pencereAltiYuksekligiLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getPencereAltiYuksekligiLabel() {
		if(pencereAltiYuksekligiLabel == null) {
			pencereAltiYuksekligiLabel = new javax.swing.JLabel();
			pencereAltiYuksekligiLabel.setBounds(17, 260, 133, 26);
			pencereAltiYuksekligiLabel.setText("Pencere altý yüksekliði");
		}
		return pencereAltiYuksekligiLabel;
	}
	/**
	 * This method initializes pencereAltiYuksekligiTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getPencereAltiYuksekligiTextField() {
		if(pencereAltiYuksekligiTextField == null) {
			pencereAltiYuksekligiTextField = new javax.swing.JTextField();
			pencereAltiYuksekligiTextField.setBounds(158, 261, 106, 24);
			pencereAltiYuksekligiTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getPencereAltiYuksekligiTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
						activeMahal.setPencereAltiYuksekligi(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) pencereAltiYuksekligiTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
					if(activeMahal.getPencereAltiYuksekligi()>activeMahal.getKat().getBina().getProje().getEnCokKullanilanRadyatorModeli().getYukseklik()) SwingUtils.infoMessage("Girilen yükseklik seçilen radyatör modeli yüksekliðinden fazladýr!");
				}
			});
		}
		return pencereAltiYuksekligiTextField;
	}
	/**
	 * This method initializes radyatorModeliLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getRadyatorModeliLabel() {
		if(radyatorModeliLabel == null) {
			radyatorModeliLabel = new javax.swing.JLabel();
			radyatorModeliLabel.setBounds(17, 301, 133, 26);
			radyatorModeliLabel.setText("Radyatör modeli");
		}
		return radyatorModeliLabel;
	}
	/**
	 * This method initializes radyatorModeliTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getRadyatorModeliTextField() {
		if(radyatorModeliTextField == null) {
			radyatorModeliTextField = new javax.swing.JTextField();
			radyatorModeliTextField.setBounds(158, 302, 106, 24);
		}
		return radyatorModeliTextField;
	}

	public void addMahalKoduTextFieldFocusListener(FocusListener mahalKoduTextFieldFocusListener) {    
        getMahalKoduTextField().addFocusListener(mahalKoduTextFieldFocusListener);
    }

	public void addMahalKoduTextFieldKeyListener(KeyListener mahalKoduTextFieldKeyListener) {    
        getMahalKoduTextField().addKeyListener(mahalKoduTextFieldKeyListener);
    }

	public void addMahalAdiTextFieldFocusListener(FocusListener mahalAdiTextFieldFocusListener) {
	    getMahalAdiTextField().addFocusListener(mahalAdiTextFieldFocusListener);
    }

	public void addMahalAdiTextFieldKeyListener(KeyListener mahalAdiTextFieldKeyListener) {
	    getMahalAdiTextField().addKeyListener(mahalAdiTextFieldKeyListener);
    }

	public void addMahalIcSicakligiTextFieldFocusListener(FocusListener mahalIcSicakligiTextFieldFocusListener) {
	    getMahalIcSicakligiTextField().addFocusListener(mahalIcSicakligiTextFieldFocusListener);
    }

	public void addMahalIcSicakligiTextFieldKeyListener(KeyListener mahalIcSicakligiTextFieldKeyListener) {	    
        getMahalIcSicakligiTextField().addKeyListener(mahalIcSicakligiTextFieldKeyListener);
    }

	public void addRadyatorGrupSayisiTextFieldFocusListener(FocusListener radyatorGrupSayisiTextFieldFocusListener) {
	    getRadyatorGrupSayisiTextField().addFocusListener(radyatorGrupSayisiTextFieldFocusListener );
    }

	public void addRadyatorGrupSayisiTextFieldKeyListener(KeyListener radyatorGrupSayisiTextFieldKeyListener) {
	    getRadyatorGrupSayisiTextField().addKeyListener(radyatorGrupSayisiTextFieldKeyListener);
    }

	public void addPencereAltiYuksekligiTextFieldFocusListener(FocusListener pencereAltiYuksekligiTextFieldFocusListener) {
	    getPencereAltiYuksekligiTextField().addFocusListener(pencereAltiYuksekligiTextFieldFocusListener);        
    }

    public void addPencereAltiYuksekligiTextFieldKeyListener(KeyListener pencereAltiYuksekligiTextFieldKeyListener) {
        getPencereAltiYuksekligiTextField().addKeyListener(pencereAltiYuksekligiTextFieldKeyListener);
    }

    public void addRadyatorModeliTextFieldFocusListener(FocusListener radyatorModeliTextFieldFocusListener) {        // TODO Auto-generated method stub
        getRadyatorModeliTextField().addFocusListener(radyatorModeliTextFieldFocusListener);
    }

    public void addRadyatorModeliTextFieldKeyListener(KeyListener radyatorModeliTextFieldKeyListener) {
        getRadyatorModeliTextField().addKeyListener(radyatorModeliTextFieldKeyListener);
    }

    public double getMahalIcSicaklikTextFieldText() {        
        return Double.parseDouble(getMahalIcSicakligiTextField().getText());        
    }
    public String getMahalAdiTextFieldText() {
        return getMahalAdiTextField().getText();
    }

    public int getMahalIdTextFieldText() {
        return Integer.parseInt(getMahalKoduTextField().getText());
    }

    public double getPencereAltiYuksekligiTextFieldText() {
        return Double.parseDouble(getPencereAltiYuksekligiTextField().getText());
    }

    public String getRadyatorModeliTextFieldText() {
        return getRadyatorModeliTextField().getText();
    }

    public int getRadyatorGrupSayisiTextFieldText() {
        return Integer.parseInt(getRadyatorGrupSayisiTextField().getText());
    }
	
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getYonComboBox() {
		if (yonComboBox == null) {
		    String[] yonStrings = {"Kuzey","Güney","Doðu","Batý","Kuzeydoðu","Kuzeybatý","Güneydoðu","Güneybatý"};
			yonComboBox = new JComboBox(yonStrings);			
			yonComboBox.setBounds(158, 142, 106, 24);
			yonComboBox.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
			        JComboBox cb = (JComboBox)e.getSource();
			        String yon = (String)cb.getSelectedItem();
			        if(yon.equals("Kuzey")) activeMahal.setYon("K");
			        if(yon.equals("Güney")) activeMahal.setYon("G");   
			        if(yon.equals("Doðu")) activeMahal.setYon("D");
			        if(yon.equals("Batý")) activeMahal.setYon("B");
			        if(yon.equals("Kuzeydoðu")) activeMahal.setYon("KD");
			        if(yon.equals("Kuzeybatý")) activeMahal.setYon("KB");
			        if(yon.equals("Güneydoðu")) activeMahal.setYon("GD");
			        if(yon.equals("Güneybatý")) activeMahal.setYon("GB");
				}
			});
		}
		return yonComboBox;
	}
	public void addYonComboBoxActionListener(ActionListener mahalComboBoxActionListener) {
		getYonComboBox().addActionListener(mahalComboBoxActionListener);
	}
	/**
	 * @param icSicaklikModeliSecButtonListener
	 */
	public void addMahalIcSicakligiSecButtonListener(ActionListener icSicaklikModeliSecButtonListener) {
		getMahalIcSicakligiSecButton().addActionListener(icSicaklikModeliSecButtonListener);
	}
	/**
	 * @param sicaklik
	 */
	public void setIcSicaklikTextFieldText(int sicaklik) {
		getMahalIcSicakligiTextField().setText(""+sicaklik);
	}
	/**
	 * @param mahal
	 */
	public void setMahalAdiTextFieldText(String mahal) {
		getMahalAdiTextField().setText(mahal);
	}

	public void setRadyatorModeliTextFieldText(String radyatorModeli){
	    this.radyatorModeliTextField.setText(radyatorModeli);
	}
	
	public void updateSelf(TreeItemSelectionEvent e) {
		TreeItemInt item = e.getSelectedItem();
		if(item instanceof Mahal){
			activeMahal = (Mahal) item;
			getMahalKoduTextField().setText(activeMahal.getMahalkodu());
			getMahalAdiTextField().setText(activeMahal.getMahalAdi());
			getMahalIcSicakligiTextField().setText(""+activeMahal.getIcSicaklik());
			getRadyatorGrupSayisiTextField().setText(""+activeMahal.getRadyatorGrupSayisi());
			getPencereAltiYuksekligiTextField().setText(""+activeMahal.getPencereAltiYuksekligi());
			getRadyatorModeliTextField().setText(activeMahal.getRadyatorModeli());
			String yon = activeMahal.getYon();
	        if(yon.equals("K")) yonComboBox.setSelectedItem("Kuzey");
	        if(yon.equals("G")) yonComboBox.setSelectedItem("Güney");   
	        if(yon.equals("D")) yonComboBox.setSelectedItem("Doðu");
	        if(yon.equals("B")) yonComboBox.setSelectedItem("Batý");
	        if(yon.equals("KD")) yonComboBox.setSelectedItem("Kuzeydoðu");
	        if(yon.equals("KB")) yonComboBox.setSelectedItem("Kuzeybatý");
	        if(yon.equals("GD")) yonComboBox.setSelectedItem("Güneydoðu");
	        if(yon.equals("GB")) yonComboBox.setSelectedItem("Güneybatý");
		}
	}

	public void setSicaklik(IcSicaklik sicaklik){
		activeMahal.setIcSicaklik(sicaklik.getSicaklik());
		activeMahal.setMahalAdi(sicaklik.getMahal());
		getMahalIcSicakligiTextField().setText(""+sicaklik.getSicaklik());
		getMahalAdiTextField().setText(sicaklik.getMahal());
	}
	/**
	 * This method initializes radyatorModeliSecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getRadyatorModeliSecButton() {
		if (radyatorModeliSecButton == null) {
			radyatorModeliSecButton = new JButton();
			radyatorModeliSecButton.setBounds(273, 302, 36, 24);
			radyatorModeliSecButton.setText("...");
			radyatorModeliSecButton.addActionListener(new java.awt.event.ActionListener() {
				RadyatorModeliSecimiDialog dialog = new RadyatorModeliSecimiDialog();
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					SwingUtils.centerAndShowComponent(dialog);
			        
			        ActionListener secListener = new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			                int index = dialog.getRadyatorModelleriTableSelectedIndex();
			                if (index < 0)
			                    return;
			                RadyatorSecimTableModel model = (RadyatorSecimTableModel)dialog.getRadyatorModelleriTableModel();
			                List list = model.getRadyatorler();
			                if (index < list.size()){
			                    Radyator radyator = (Radyator)list.get(index);
			                    
			                    setRadyatorModeliTextFieldText(radyator.getModel());
			                    activeMahal.setRadyatorModeli(radyator.getModel());
			                    dialog.setVisible(false);
			                }
			            }
			        };
			        dialog.addSecButtonListener(secListener);

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
				    			dialog.setRadyatorModelleriTableModel(model);
			                }
			            }
			        };
			        dialog.addRadyatorTipListener(radyatorTipListener);
				}
			});
		}
		return radyatorModeliSecButton;
	}
 }  //  @jve:visual-info  decl-index=0 visual-constraint="38,8"

