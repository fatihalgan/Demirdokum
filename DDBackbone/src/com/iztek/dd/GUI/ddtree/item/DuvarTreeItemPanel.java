/*
 * Created on 01.Ara.2004
 *
 */
package com.iztek.dd.GUI.ddtree.item;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.iztek.dd.GUI.IcSicaklikSecimiDialog;
import com.iztek.dd.GUI.IsitilmayanBolgeSicakligiSecimiDialog;
import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.GUI.wrappers.IcSicaklikSecimTableModel;
import com.iztek.dd.IsiKaybi.domain.DuvarYapiElemani;
import com.iztek.dd.IsiKaybi.domain.IcSicaklik;
import com.iztek.dd.IsiKaybi.domain.IcSicakliklar;
import com.iztek.dd.utilities.Il;
import com.iztek.dd.utilities.TreeItemSelectionEvent;
/**
 * @author Selim HENDRICKSON
 *
 */
public class DuvarTreeItemPanel extends TreeItemPanel {
    DuvarYapiElemani activeDuvar = null;
    private IcSicaklikSecimiDialog icSicaklikSecimiDialog = new IcSicaklikSecimiDialog(this);
    private IsitilmayanBolgeSicakligiSecimiDialog isitilmayanBolgeSicakligiSecimiDialog = new IsitilmayanBolgeSicakligiSecimiDialog(this);
    
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6992749245430847592L;
	
	private JLabel isaretLabel = null;
	private JTextField isaretTextField = null;
	private JLabel yonLabel = null;
	private JComboBox yonComboBox = null;
	private JLabel uzunlukLabel = null;
	private JTextField uzunlukTextField = null;
	private JLabel kalinlikLabel = null;
	private JTextField kalinlikTextField = null;
	private JLabel yukseklikGenislikLabel = null;
	private JTextField yukseklikGenislikTextField = null;
	private JLabel kDegeriLabel = null;
	private JTextField kDegeriTextField = null;
	private JLabel icOrtamSicakligiLabel = null;
	private JTextField icOrtamSicakligiTextField = null;
	private JLabel disOrtamSicakligiLabel = null;
	private JTextField disOrtamSicakligiTextField = null;
	private JPanel jPanel = null;
	private JRadioButton disDuvarRadioButton = null;
	private JRadioButton icDuvarRadioButton = null;
	private JRadioButton dosemeRadioButton = null;
	private JButton disSicaklikSecButton = null;
	private JButton isitilmayanBolgeSicakligiSecButton = null;
		
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	/**
	 * This method initializes 
	 * 
	 */
	public DuvarTreeItemPanel() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        jLabel5 = new JLabel();
        jLabel4 = new JLabel();
        jLabel3 = new JLabel();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        jLabel = new JLabel();
        disOrtamSicakligiLabel = new JLabel();
        icOrtamSicakligiLabel = new JLabel();
        kDegeriLabel = new JLabel();
        yukseklikGenislikLabel = new JLabel();
        kalinlikLabel = new JLabel();
        uzunlukLabel = new JLabel();
        yonLabel = new JLabel();
        isaretLabel = new JLabel();
        this.setLayout(null);
        this.setSize(407, 399);
        isaretLabel.setBounds(32, 91, 111, 24);
        isaretLabel.setText("Ýþaret");
        yonLabel.setBounds(32, 129, 111, 24);
        yonLabel.setText("Yön");
        uzunlukLabel.setBounds(32, 167, 111, 24);
        uzunlukLabel.setText("Uzunluk");
        kalinlikLabel.setBounds(32, 205, 111, 24);
        kalinlikLabel.setText("Kalýnlýk");
        yukseklikGenislikLabel.setBounds(32, 243, 111, 24);
        yukseklikGenislikLabel.setText("Yükseklik/Geniþlik");
        kDegeriLabel.setBounds(32, 281, 111, 24);
        kDegeriLabel.setText("U");
        icOrtamSicakligiLabel.setBounds(32, 319, 111, 24);
        icOrtamSicakligiLabel.setText("Ýç ortam sýcaklýðý");
        disOrtamSicakligiLabel.setBounds(32, 357, 111, 24);
        disOrtamSicakligiLabel.setText("Dýþ ortam sýcaklýðý");
        jLabel.setBounds(288, 167, 17, 24);
        jLabel.setText("m");
        jLabel1.setBounds(288, 205, 26, 24);
        jLabel1.setText("cm");
        jLabel2.setBounds(288, 243, 17, 24);
        jLabel2.setText("m");
        jLabel3.setBounds(288, 281, 47, 24);
        jLabel3.setText("<HTML>W/m<SUP>2</SUP> K</HTML>");
        jLabel4.setBounds(288, 319, 19, 24);
        jLabel4.setText("\u00B0C");
        jLabel5.setBounds(288, 356, 19, 24);
        jLabel5.setText("\u00B0C");
        this.add(isaretLabel, null);
        this.add(getIsaretTextField(), null);
        this.add(yonLabel, null);
        this.add(getYonComboBox(), null);
        this.add(uzunlukLabel, null);
        this.add(getUzunlukTextField(), null);
        this.add(kalinlikLabel, null);
        this.add(getKalinlikTextField(), null);
        this.add(yukseklikGenislikLabel, null);
        this.add(getYukseklikGenislikTextField(), null);
        this.add(kDegeriLabel, null);
        this.add(getKDegeriTextField(), null);
        this.add(icOrtamSicakligiLabel, null);
        this.add(getIcOrtamSicakligiTextField(), null);
        this.add(disOrtamSicakligiLabel, null);
        this.add(getDisOrtamSicakligiTextField(), null);
        this.add(getJPanel(), null);
        this.add(getDisSicaklikSecButton(), null);
        this.add(getIsitilmayanBolgeSicakligiSecButton(), null);
        this.add(jLabel, null);
        this.add(jLabel1, null);
        this.add(jLabel2, null);
        this.add(jLabel3, null);
        this.add(jLabel4, null);
        this.add(jLabel5, null);
			
	}
	/**
	 * This method initializes isaretTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIsaretTextField() {
		if (isaretTextField == null) {
			isaretTextField = new JTextField();
			isaretTextField.setLocation(169, 91);
			isaretTextField.setSize(106, 24);
			isaretTextField.setEditable(false);
			isaretTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					activeDuvar.setYapiElemaniKodu(isaretTextField.getText()+e.getKeyChar());
				}
			});
		}
		return isaretTextField;
	}
	/**
	 * This method initializes yonComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getYonComboBox() {
		if (yonComboBox == null) {
		    String[] yonStrings = {"Kuzey","Güney","Doðu","Batý","Kuzeydoðu","Kuzeybatý","Güneydoðu","Güneybatý"};
			yonComboBox = new JComboBox(yonStrings);			
			yonComboBox.setBounds(169, 129, 106, 24);
			yonComboBox.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
			        JComboBox cb = (JComboBox)e.getSource();
			        String yon = (String)cb.getSelectedItem();
			        if(yon.equals("Kuzey")) activeDuvar.setYon("K");
			        if(yon.equals("Güney")) activeDuvar.setYon("G");   
			        if(yon.equals("Doðu")) activeDuvar.setYon("D");
			        if(yon.equals("Batý")) activeDuvar.setYon("B");
			        if(yon.equals("Kuzeydoðu")) activeDuvar.setYon("KD");
			        if(yon.equals("Kuzeybatý")) activeDuvar.setYon("KB");
			        if(yon.equals("Güneydoðu")) activeDuvar.setYon("GD");
			        if(yon.equals("Güneybatý")) activeDuvar.setYon("GB");
				}
			});
		}
		return yonComboBox;
	}
	/**
	 * This method initializes uzunlukTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getUzunlukTextField() {
		if (uzunlukTextField == null) {
			uzunlukTextField = new JTextField();
			uzunlukTextField.setBounds(169, 167, 106, 24);
			uzunlukTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					uzunlukTextField.setText("");
				}
			});
			uzunlukTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getUzunlukTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
						if(!activeDuvar.isDoseme())activeDuvar.setUzunluk(Double.parseDouble(text));
						else activeDuvar.setAlan(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) uzunlukTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return uzunlukTextField;
	}
	/**
	 * This method initializes kalinlikTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getKalinlikTextField() {
		if (kalinlikTextField == null) {
			kalinlikTextField = new JTextField();
			kalinlikTextField.setBounds(169, 205, 106, 24);
			kalinlikTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					kalinlikTextField.setText("");
				}
			});
			kalinlikTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getKalinlikTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
						activeDuvar.setKalinlik(Double.parseDouble(text)/100);
					} catch (NumberFormatException e1) {
						if(text.length()>1) kalinlikTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return kalinlikTextField;
	}
	/**
	 * This method initializes yukseklikGenislikTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYukseklikGenislikTextField() {
		if (yukseklikGenislikTextField == null) {
			yukseklikGenislikTextField = new JTextField();
			yukseklikGenislikTextField.setBounds(169, 243, 106, 24);
			yukseklikGenislikTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					yukseklikGenislikTextField.setText("");
				}
			});
			yukseklikGenislikTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getYukseklikGenislikTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
						activeDuvar.setYukseklik(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) yukseklikGenislikTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return yukseklikGenislikTextField;
	}
	/**
	 * This method initializes kDegeriTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getKDegeriTextField() {
		if (kDegeriTextField == null) {
			kDegeriTextField = new JTextField();
			kDegeriTextField.setBounds(169, 281, 106, 24);
			kDegeriTextField.setEditable(false);
			kDegeriTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					kDegeriTextField.setText("");
				}
			});
			kDegeriTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getKDegeriTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
						activeDuvar.setIsiGecirgenlikKatsayisi(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) getKDegeriTextField().setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return kDegeriTextField;
	}
	/**
	 * This method initializes icOrtamSicakligiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIcOrtamSicakligiTextField() {
		if (icOrtamSicakligiTextField == null) {
			icOrtamSicakligiTextField = new JTextField();
			icOrtamSicakligiTextField.setBounds(169, 319, 106, 24);
			icOrtamSicakligiTextField.setEditable(false);
		}
		return icOrtamSicakligiTextField;
	}
	/**
	 * This method initializes disOrtamSicakligiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getDisOrtamSicakligiTextField() {
		if (disOrtamSicakligiTextField == null) {
			disOrtamSicakligiTextField = new JTextField();
			disOrtamSicakligiTextField.setBounds(169, 357, 106, 24);
			disOrtamSicakligiTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					disOrtamSicakligiTextField.setText("");
				}
			});
			disOrtamSicakligiTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getDisOrtamSicakligiTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
						activeDuvar.setDisSicaklik(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) disOrtamSicakligiTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return disOrtamSicakligiTextField;
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new FlowLayout());
			jPanel.setBounds(27, 14, 303, 63);
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duvar Tipi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));			
			jPanel.add(getDisDuvarRadioButton(), null);
			jPanel.add(getIcDuvarRadioButton(), null);
			jPanel.add(getDosemeRadioButton(), null);
			ButtonGroup group = new ButtonGroup();
			group.add(getDisDuvarRadioButton());
			group.add(getIcDuvarRadioButton());
			group.add(getDosemeRadioButton());
			getDisDuvarRadioButton().addActionListener(radioButtonListener);
			getIcDuvarRadioButton().addActionListener(radioButtonListener);
			getDosemeRadioButton().addActionListener(radioButtonListener);
		}
		return jPanel;
	}
	/**
	 * This method initializes disDuvarRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDisDuvarRadioButton() {
		if (disDuvarRadioButton == null) {
			disDuvarRadioButton = new JRadioButton();
			disDuvarRadioButton.setText("Dýþ Duvar");
			disDuvarRadioButton.setActionCommand("Dis");
			disDuvarRadioButton.setSelected(true);
		}
		return disDuvarRadioButton;
	}
	/**
	 * This method initializes icDuvarRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getIcDuvarRadioButton() {
		if (icDuvarRadioButton == null) {
			icDuvarRadioButton = new JRadioButton();
			icDuvarRadioButton.setText("Ýç Duvar");
			icDuvarRadioButton.setActionCommand("Ic");
		}
		return icDuvarRadioButton;
	}
	/**
	 * This method initializes dosemeRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDosemeRadioButton() {
		if (dosemeRadioButton == null) {
			dosemeRadioButton = new JRadioButton();
			dosemeRadioButton.setText("Döþeme/Tavan");
			dosemeRadioButton.setActionCommand("DT");
		}
		return dosemeRadioButton;
	}

	public String getIsaretTextFieldText() {
        return getIsaretTextField().getText();
    }

	public double getUzunlukTextFieldText(){
        return Double.parseDouble(getUzunlukTextField().getText());
    }
    public double getKalinlikTextFieldText() {
        return Double.parseDouble(getKalinlikTextField().getText());
    }

    public double getYukseklikGenislikTextFieldText() {
        return Double.parseDouble(getYukseklikGenislikTextField().getText());
    }

    public double getKDegeriTextFieldText() {
        return Double.parseDouble(getKDegeriTextField().getText());
    }

    public double getýcOrtamSicakligiTextFieldText() {
        return Double.parseDouble(getIcOrtamSicakligiTextField().getText());
    }

    public double getDisOrtamSicakligiTextFieldText() {
        return Double.parseDouble(getDisOrtamSicakligiTextField().getText());
    }

    public void addDuvarTreeItemPanelIsaretTextFieldKeylistener(KeyListener duvarTreeItemPanelIsaretTextFieldKeylistener) {
        getIsaretTextField().addKeyListener(duvarTreeItemPanelIsaretTextFieldKeylistener);
    }

    public void addDuvarTreeItemPanelUzunlukTextFieldKeylistener(KeyListener duvarTreeItemPanelUzunlukTextFieldKeylistener) {
        getUzunlukTextField().addKeyListener(duvarTreeItemPanelUzunlukTextFieldKeylistener);
    }

    public void addDuvarTreeItemPanelKalinlikTextFieldKeylistener(KeyListener duvarTreeItemPanelKalinlikTextFieldKeylistener) {
        getKalinlikTextField().addKeyListener(duvarTreeItemPanelKalinlikTextFieldKeylistener);
    }

    public void addDuvarTreeItemPanelYukseklikGenislikTextFieldKeylistener(KeyListener duvarTreeItemPanelYukseklikGenislikTextFieldKeylistener) {
        getYukseklikGenislikTextField().addKeyListener(duvarTreeItemPanelYukseklikGenislikTextFieldKeylistener);
    }

    public void addDuvarTreeItemPanelKDegeriTextFieldKeylistener(KeyListener duvarTreeItemPanelKDegeriTextFieldKeylistener) {
        getKDegeriTextField().addKeyListener(duvarTreeItemPanelKDegeriTextFieldKeylistener);
    }

    public void addDuvarTreeItemPanelIcOrtamSicakligiTextFieldKeylistener(KeyListener duvarTreeItemPanelIcOrtamSicakligiTextFieldKeylistener) {
        getIcOrtamSicakligiTextField().addKeyListener(duvarTreeItemPanelIcOrtamSicakligiTextFieldKeylistener);
    }

    public void addDuvarTreeItemPanelDisOrtamSicakligiTextFieldKeylistener(KeyListener duvarTreeItemPanelDisOrtamSicakligiTextFieldKeylistener) {
        getDisOrtamSicakligiTextField().addKeyListener(duvarTreeItemPanelDisOrtamSicakligiTextFieldKeylistener);
    }

    public void setDuvarTreeItemPanelDisDuvarRadioButtonActionCommand(String string) {
        getDisDuvarRadioButton().setActionCommand(string);
    }

    public void addDuvarTreeItemPanelýcDuvarRadioButtonActionCommand(String string) {
        getIcDuvarRadioButton().setActionCommand(string);
    }

    public void addDuvarTreeItemPanelDosemeRadioButtonActionCommand(String string) {
        getDosemeRadioButton().setActionCommand(string);
    }

    public void addDuvarTreeItemPanelDisDuvarRadioButtonActionListener(ActionListener duvarRadioButtonActionListener) {
        getDisDuvarRadioButton().addActionListener(duvarRadioButtonActionListener);
    }

    public void addDuvarTreeItemPanelIcDuvarRadioButtonActionListener(ActionListener duvarRadioButtonActionListener) {
        getIcDuvarRadioButton().addActionListener(duvarRadioButtonActionListener);
    }

    public void addDuvarTreeItemPanelDosemeRadioButtonActionListener(ActionListener duvarRadioButtonActionListener) {
        getDosemeRadioButton().addActionListener(duvarRadioButtonActionListener);
    }

    public void setDisOrtamSicakligiTextFieldText(String string) {
        getDisOrtamSicakligiTextField().setText(string);
    }
    
	/**
	 * This method initializes disSicaklikSecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getDisSicaklikSecButton() {
		if (disSicaklikSecButton == null) {
			disSicaklikSecButton = new JButton();
			disSicaklikSecButton.setBounds(313, 357, 41, 24);
			disSicaklikSecButton.setText("+");
			disSicaklikSecButton.setToolTipText("Isýtýlan");
			disSicaklikSecButton.setEnabled(false);
			disSicaklikSecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					icSicaklikSecimiDialog.setIcSicaklikModelleriTableModel(new IcSicaklikSecimTableModel(IcSicakliklar.getInstance().getIcSicakliklar()));
					SwingUtils.centerAndShowComponent(icSicaklikSecimiDialog);
				}
			});
		}
		return disSicaklikSecButton;
	}
	/**
	 * This method initializes isitilmayanBolgeSicakligiSecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getIsitilmayanBolgeSicakligiSecButton() {
		if (isitilmayanBolgeSicakligiSecButton == null) {
			isitilmayanBolgeSicakligiSecButton = new JButton();
			isitilmayanBolgeSicakligiSecButton.setText("-");
			isitilmayanBolgeSicakligiSecButton.setSize(41, 24);
			isitilmayanBolgeSicakligiSecButton.setLocation(354, 357);
			isitilmayanBolgeSicakligiSecButton.setToolTipText("Isýtýlmayan");
			isitilmayanBolgeSicakligiSecButton.setEnabled(false);
			isitilmayanBolgeSicakligiSecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
		            Il il = getActiveDuvar().getMahal().getKat().getBina().getProje().getIl();
		            double disSicaklik = 0;
		            if(il!=null)disSicaklik = il.getIsiKaybiDisSicaklik();
		            else SwingUtils.errorMessage("Proje ili belirtilmemiþ");
				    isitilmayanBolgeSicakligiSecimiDialog.setSecilenSicaklikDegeriTextFieldText(0);
					SwingUtils.centerAndShowComponent(isitilmayanBolgeSicakligiSecimiDialog);				
				}
			});
		}
		return isitilmayanBolgeSicakligiSecButton;
	}

	public void addDuvarTreeItemPanelYonComboBoxActionListener(ActionListener duvarComboBoxActionListener) {
	    getYonComboBox().addActionListener(duvarComboBoxActionListener);
    }

	public void setIcSicaklikTextFieldText(String string) {
	    getIcOrtamSicakligiTextField().setText(string);
    }

	public void setKDegeriTextFieldText(double isiGecirgenlikKatsayisi) {
	    getKDegeriTextField().setText(twoDigits.format(isiGecirgenlikKatsayisi));
    }

	public void setIsaretTextFieldText(String yapiElemaniAdi) {
	    getIsaretTextField().setText(yapiElemaniAdi);
    }
	
    public void setButtonsEnabled(boolean state) {
        getDisSicaklikSecButton().setEnabled(state);
        getIsitilmayanBolgeSicakligiSecButton().setEnabled(state);
    }

    public void setKDegeriTextFieldEnabled(boolean b) {
    	getKDegeriTextField().setEditable(b);
	}

    public void setComboBoxEnabled(boolean b) {
		getYonComboBox().setEnabled(b);
	}
	
	public void setIsaretTextFieldEnabled(boolean b) {
		getIsaretTextField().setEditable(b);
	}
	public void setDisSicaklikTextFieldText(int sicaklik) {
		getDisOrtamSicakligiTextField().setText(""+sicaklik);
	}

	public void addDuvarDisSicakligiSecButtonListener(ActionListener icSicaklikModeliSecButtonListener) {
		getDisSicaklikSecButton().addActionListener(icSicaklikModeliSecButtonListener);
	}

	public void isitilmayanBolgeSicakligiSecButtonListener(ActionListener isitilmayanBolgeSicakligiSecButtonListener) {
	    getIsitilmayanBolgeSicakligiSecButton().addActionListener(isitilmayanBolgeSicakligiSecButtonListener);
    }

	public void updateSelf(TreeItemSelectionEvent e) {
	    TreeItemInt item = e.getSelectedItem();
	    if(item instanceof DuvarYapiElemani){
	        activeDuvar = (DuvarYapiElemani) item;
	        if(activeDuvar.isDisDuvar()) disDuvarRadioButton.setSelected(true);
	        if(activeDuvar.isIcDuvar()) icDuvarRadioButton.setSelected(true);
	        if(activeDuvar.isDoseme()) dosemeRadioButton.setSelected(true);
	        isaretTextField.setText(activeDuvar.getYapiElemaniKodu());
	        if(!activeDuvar.isDoseme())uzunlukTextField.setText(""+activeDuvar.getUzunluk());
	        else uzunlukTextField.setText(""+activeDuvar.getAlan());
	        double debug = activeDuvar.getKalinlik()*100;
	        kalinlikTextField.setText(twoDigits.format(debug));
	        yukseklikGenislikTextField.setText(""+activeDuvar.getYukseklik());
	        kDegeriTextField.setText(""+activeDuvar.getIsiGecirgenlikKatsayisi());
	        icOrtamSicakligiTextField.setText(""+activeDuvar.getIcSicaklik());
			String yon = activeDuvar.getYon();
	        if(yon.equals("K")) yonComboBox.setSelectedItem("Kuzey");
	        if(yon.equals("G")) yonComboBox.setSelectedItem("Güney");   
	        if(yon.equals("D")) yonComboBox.setSelectedItem("Doðu");
	        if(yon.equals("B")) yonComboBox.setSelectedItem("Batý");
	        if(yon.equals("KD")) yonComboBox.setSelectedItem("Kuzeydoðu");
	        if(yon.equals("KB")) yonComboBox.setSelectedItem("Kuzeybatý");
	        if(yon.equals("GD")) yonComboBox.setSelectedItem("Güneydoðu");
	        if(yon.equals("GB")) yonComboBox.setSelectedItem("Güneybatý");
	        getIcOrtamSicakligiTextField().setText(""+activeDuvar.getMahal().getIcSicaklik());
	        Il il = activeDuvar.getMahal().getKat().getBina().getProje().getIl();
	        if(activeDuvar.isDoseme()){
	            getDisOrtamSicakligiTextField().setText(""+activeDuvar.getDisSicaklik());
                setIsaretTextFieldEnabled(true);
                setButtonsEnabled(true);
                setComboBoxEnabled(false);
                setKDegeriTextFieldEnabled(true);
	            yukseklikGenislikLabel.setVisible(false);
	            yukseklikGenislikTextField.setVisible(false);
	            jLabel2.setVisible(false);
	            uzunlukLabel.setText("Alan");
	            jLabel.setText("<HTML>m<SUP>2</SUP></HTML>");   
	        }
	        if(activeDuvar.isIcDuvar()){
	            getDisOrtamSicakligiTextField().setText(""+activeDuvar.getDisSicaklik());
                setIsaretTextFieldEnabled(false);
                setButtonsEnabled(true);
                setComboBoxEnabled(true);
                setKDegeriTextFieldEnabled(false);
	            yukseklikGenislikLabel.setVisible(true);
	            yukseklikGenislikTextField.setVisible(true);
	            jLabel2.setVisible(true);
	            uzunlukLabel.setText("Uzunluk");
	            jLabel.setText("m");
	        }
	        if(activeDuvar.isDisDuvar()){
		        if(il!=null)getDisOrtamSicakligiTextField().setText(""+il.getIsiKaybiDisSicaklik());
                setIsaretTextFieldEnabled(false);
                setButtonsEnabled(false);
                setComboBoxEnabled(true);
                setKDegeriTextFieldEnabled(false);
	            yukseklikGenislikLabel.setVisible(true);
	            yukseklikGenislikTextField.setVisible(true);
	            jLabel2.setVisible(true);
	            uzunlukLabel.setText("Uzunluk");
	            jLabel.setText("m");
	        }
	    }
	}

	ActionListener radioButtonListener = new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
            String actionCommand = arg0.getActionCommand();
            getIcOrtamSicakligiTextField().setText(""+activeDuvar.getMahal().getIcSicaklik());
            if(actionCommand=="Dis"){
                setIsaretTextFieldEnabled(false);
                setButtonsEnabled(false);
                setComboBoxEnabled(true);
                setKDegeriTextFieldEnabled(false);
                yukseklikGenislikLabel.setVisible(true);
                yukseklikGenislikTextField.setVisible(true);
                jLabel2.setVisible(true);
                uzunlukLabel.setText("Uzunluk");
                jLabel.setText("m");
                double disSicaklik = activeDuvar.getMahal().getKat().getBina().getProje().getIl().getIsiKaybiDisSicaklik();
                disOrtamSicakligiTextField.setText(""+disSicaklik);
                activeDuvar.setDisSicaklik(disSicaklik);
                DuvarYapiElemani commonDisDuvar = (DuvarYapiElemani)activeDuvar.getMahal().getKat().getBina().getProje().getCogunluklaKullanilanDisDuvar();
                if(commonDisDuvar!=null){
                    isaretTextField.setText(commonDisDuvar.getYapiElemaniKodu());
                    activeDuvar.setYapiElemaniKodu(commonDisDuvar.getYapiElemaniKodu());
                    kDegeriTextField.setText(""+commonDisDuvar.getIsiGecirgenlikKatsayisi());
                    activeDuvar.setIsiGecirgenlikKatsayisi(commonDisDuvar.getIsiGecirgenlikKatsayisi());
                }
                activeDuvar.setDisDuvar(true);
                activeDuvar.setIcDuvar(false);
                activeDuvar.setDoseme(false);
            }
            if(actionCommand=="Ic"){
                setIsaretTextFieldEnabled(false);
                setButtonsEnabled(true);
                setComboBoxEnabled(true);
                setKDegeriTextFieldEnabled(false);
                disOrtamSicakligiTextField.setText("");
                yukseklikGenislikLabel.setVisible(true);
                yukseklikGenislikTextField.setVisible(true);
                jLabel2.setVisible(true);
                uzunlukLabel.setText("Uzunluk");
                jLabel.setText("m");
                activeDuvar.setDisSicaklik(0);
                DuvarYapiElemani commonIcDuvar = (DuvarYapiElemani)activeDuvar.getMahal().getKat().getBina().getProje().getCogunluklaKullanilanIcDuvar();
                if(commonIcDuvar!=null){
                    isaretTextField.setText(commonIcDuvar.getYapiElemaniKodu());
                    activeDuvar.setYapiElemaniKodu(commonIcDuvar.getYapiElemaniKodu());
                    kDegeriTextField.setText(""+commonIcDuvar.getIsiGecirgenlikKatsayisi());
                    activeDuvar.setIsiGecirgenlikKatsayisi(commonIcDuvar.getIsiGecirgenlikKatsayisi());
                }
                activeDuvar.setDisDuvar(false);
                activeDuvar.setIcDuvar(true);
                activeDuvar.setDoseme(false);
            }
            if(actionCommand=="DT"){
                setIsaretTextFieldEnabled(true);
                setButtonsEnabled(true);
                setComboBoxEnabled(false);
                setKDegeriTextFieldEnabled(true);
                disOrtamSicakligiTextField.setText("");   
                activeDuvar.setDisSicaklik(0);
                isaretTextField.setText("");
                activeDuvar.setYapiElemaniKodu("");
                kDegeriTextField.setText("");      
                activeDuvar.setIsiGecirgenlikKatsayisi(0);
                yukseklikGenislikLabel.setVisible(false);
                yukseklikGenislikTextField.setVisible(false);
                jLabel2.setVisible(false);
                uzunlukLabel.setText("Alan");
                jLabel.setText("<HTML>m<SUP>2</SUP></HTML>");
                activeDuvar.setDisDuvar(false);
                activeDuvar.setIcDuvar(false);
                activeDuvar.setDoseme(true);               
            }
        }        
	};
	
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
    public void setSicaklik(IcSicaklik sicaklik){
        getDisOrtamSicakligiTextField().setText(""+sicaklik.getSicaklik());
        activeDuvar.setDisSicaklik(sicaklik.getSicaklik());
    }
    
    public DuvarYapiElemani getActiveDuvar() {
        return activeDuvar;
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"