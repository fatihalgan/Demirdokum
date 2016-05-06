/*
 * Created on 07.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKaybi.domain.CogunluklaKullanilanYapiElemanlari;
import com.iztek.dd.IsiKaybi.domain.DuvarYapiElemani;
import com.iztek.dd.IsiKaybi.domain.KapiYapiElemani;
import com.iztek.dd.IsiKaybi.domain.Malzeme;
import com.iztek.dd.IsiKaybi.domain.PencereYapiElemani;
import com.iztek.dd.IsiKaybi.domain.SecilenMalzemelerTablemodel;
import com.iztek.dd.IsiKaybi.domain.TemelYapiElemani;
import com.iztek.dd.IsiKaybi.domain.UDegerleriTableModel;
import com.iztek.dd.IsiKaybi.domain.YapiElemani;
/**
 * @author Selim HENDRICKSON
 *
 */
public class UdegeriGirisiDialog extends JDialog {
    private YapiElemani yapiElemani = null;
	private javax.swing.JPanel jContentPane = null;	
	DecimalFormat twoDigits = new DecimalFormat("0,00");
	private UDegerleriTableModel model = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton kaydetButton = null;
	private JButton vazgecButton = null;
	private JLabel jLabel = null;
	private JTextField kodTextField = null;
	private JLabel jLabel1 = null;
	private JTextField aciklamaTextField = null;
	private JLabel jLabel2 = null;
	private JTextField uDegeriTextField = null;
	private JComboBox turlerComboBox = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JPanel jPanel2 = null;
	private JLabel jLabel3 = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel4 = null;
	private JButton ekleButton = null;
	private JButton cikarButton = null;
	private JPanel jPanel5 = null;
	private JLabel jLabel4 = null;
	private JTextField icLambdaTextField = null;
	private JLabel jLabel5 = null;
	private JTextField disLambdaTextField = null;
	private JLabel jLabel6 = null;
	private JTable malzemelerTable = null;
	private JScrollPane jScrollPane = null;
	private JLabel jLabel7 = null;
	/**
	 * This is the default constructor
	 * @param yapiElemani
	 * @param model
	 */
	public UdegeriGirisiDialog(YapiElemani yapiElemani, TableModel model) {
		super();		
		this.yapiElemani = yapiElemani;
		this.model = (UDegerleriTableModel) model;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("U deðeri giriþi");
		this.setSize(491, 520);
		this.setContentPane(getJContentPane());
		kodTextField.setText(yapiElemani.getYapiElemaniKodu());
		aciklamaTextField.setText(yapiElemani.getYapiElemaniAdi());
		uDegeriTextField.setText(""+yapiElemani.getIsiGecirgenlikKatsayisi());
		turlerComboBox.setSelectedItem(yapiElemani.getTurByKod());
		if(!(yapiElemani instanceof TemelYapiElemani)) jRadioButton1.setEnabled(false);
		else jRadioButton1.setEnabled(true);
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getJPanel1(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.add(getKaydetButton(), null);
			jPanel.add(getVazgecButton(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jLabel7 = new JLabel();
			jLabel3 = new JLabel();
			jLabel2 = new JLabel();
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jLabel.setBounds(21, 14, 78, 26);
			jLabel.setText("Kod");
			jLabel1.setBounds(21, 54, 78, 26);
			jLabel1.setText("Açýklama");
			jLabel2.setBounds(21, 134, 78, 26);
			jLabel2.setText("U Deðeri");
			jLabel3.setBounds(279, 14, 125, 26);
			jLabel3.setText("Tür");
			jLabel7.setBounds(277, 134, 48, 26);
			jLabel7.setText("<HTML>W/m<SUP>2</SUP> K</HTML>");
			jPanel1.add(jLabel, null);
			jPanel1.add(getKodTextField(), null);
			jPanel1.add(jLabel1, null);
			jPanel1.add(getAciklamaTextField(), null);
			jPanel1.add(jLabel2, null);
			jPanel1.add(getUDegeriTextField(), null);
			jPanel1.add(getTurlerComboBox(), null);
			ButtonGroup group = new ButtonGroup();
			group.add(getJRadioButton());
			group.add(getJRadioButton1());
			jPanel1.add(getJRadioButton(), null);
			jPanel1.add(getJRadioButton1(), null);
			jPanel1.add(getJPanel2(), null);
			jPanel1.add(jLabel3, null);
			jPanel1.add(jLabel7, null);
		}
		return jPanel1;
	}
	/**
	 * This method initializes kaydetButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getKaydetButton() {
		if (kaydetButton == null) {
			kaydetButton = new JButton();
			kaydetButton.setText("Kaydet");
			kaydetButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					yapiElemani.setYapiElemaniAdi(aciklamaTextField.getText());
					yapiElemani.setIsiGecirgenlikKatsayisi(Double.parseDouble(uDegeriTextField.getText().replace(',','.')));
					yapiElemani.setYapiElemaniKodu(kodTextField.getText());
					CogunluklaKullanilanYapiElemanlari.getInstance().addYapiElemani(yapiElemani);
					model.fireTableStructureChanged();
					dispose();
				}
			});
		}
		return kaydetButton;
	}
	/**
	 * This method initializes vazgecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getVazgecButton() {
		if (vazgecButton == null) {
			vazgecButton = new JButton();
			vazgecButton.setText("Vazgeç");
			vazgecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					dispose();
				}
			});
		}
		return vazgecButton;
	}
	/**
	 * This method initializes kodTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getKodTextField() {
		if (kodTextField == null) {
			kodTextField = new JTextField();
			kodTextField.setBounds(108, 14, 160, 26);
			kodTextField.setEditable(true);
			kodTextField.setEnabled(true);
			kodTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = uDegeriTextField.getText();
					text+=e.getKeyChar();
					((TemelYapiElemani)yapiElemani).setYapiElemaniKodu(text);					    
				}
			});
		}
		return kodTextField;
	}
	/**
	 * This method initializes aciklamaTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getAciklamaTextField() {
		if (aciklamaTextField == null) {
			aciklamaTextField = new JTextField();
			aciklamaTextField.setBounds(108, 54, 160, 26);
			aciklamaTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = uDegeriTextField.getText();
					text += e.getKeyChar();									
					((TemelYapiElemani)yapiElemani).setYapiElemaniAdi(text);					    
				}
			});
		}
		return aciklamaTextField;
	}
	/**
	 * This method initializes uDegeriTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getUDegeriTextField() {
		if (uDegeriTextField == null) {
			uDegeriTextField = new JTextField();
			uDegeriTextField.setBounds(108, 134, 160, 26);
			uDegeriTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					uDegeriTextField.setText("");
				}
			});
			uDegeriTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = uDegeriTextField.getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
					    ((TemelYapiElemani)yapiElemani).setIsiGecirgenlikKatsayisi(Double.parseDouble(text));					    
					} catch (NumberFormatException e1) {
						if(text.length()>1) uDegeriTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return uDegeriTextField;
	}
	/**
	 * This method initializes turlerC			turlerComboBox.setSize(125, 26);
omboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getTurlerComboBox() {
		if (turlerComboBox == null) {
		    String[] values = {"Dýþ duvar","Ýç duvar","Pencere","Dýþ kapý","Ýç kapý"};
			turlerComboBox = new JComboBox(values);
			turlerComboBox.setLocation(279, 54);
			turlerComboBox.setSize(125, 26);
			turlerComboBox.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
					if(turlerComboBox.getSelectedItem().equals("Dýþ duvar")){
					    kodTextField.setText("DD");
					    jRadioButton1.setEnabled(true);
					    ArrayList malzemeler = null;
					    if(yapiElemani instanceof TemelYapiElemani){
					        malzemeler = (ArrayList)((TemelYapiElemani)yapiElemani).getBilesenler();					        
					    }					    
					    yapiElemani = new DuvarYapiElemani();
					    yapiElemani.setYapiElemaniKodu("DD");
					    yapiElemani.setYapiElemaniAdi(aciklamaTextField.getText());
					    yapiElemani.setIsiGecirgenlikKatsayisi(Double.parseDouble(uDegeriTextField.getText()));
					    if(malzemeler!=null)((TemelYapiElemani)yapiElemani).setBilesenler(malzemeler);
					    ((SecilenMalzemelerTablemodel)getMalzemelerTable().getModel()).setYapiElemani((TemelYapiElemani)yapiElemani);
					}
					if(turlerComboBox.getSelectedItem().equals("Ýç duvar")){
					    kodTextField.setText("ÝD");
					    jRadioButton1.setEnabled(true);
					    ArrayList malzemeler = null;
					    if(yapiElemani instanceof TemelYapiElemani){
					        malzemeler = (ArrayList)((TemelYapiElemani)yapiElemani).getBilesenler();					        
					    }					    
					    yapiElemani = new DuvarYapiElemani();					    
					    yapiElemani.setYapiElemaniKodu("ÝD");
					    yapiElemani.setYapiElemaniAdi(aciklamaTextField.getText());
					    yapiElemani.setIsiGecirgenlikKatsayisi(Double.parseDouble(uDegeriTextField.getText()));
					    if(malzemeler!=null)((TemelYapiElemani)yapiElemani).setBilesenler(malzemeler);
					    ((SecilenMalzemelerTablemodel)getMalzemelerTable().getModel()).setYapiElemani((TemelYapiElemani)yapiElemani);
					}
					if(turlerComboBox.getSelectedItem().equals("Pencere")){
					    kodTextField.setText("PE");
					    jRadioButton.setSelected(true);
					    jRadioButton1.setEnabled(false);
						uDegeriTextField.setEnabled(true);
						icLambdaTextField.setEnabled(false);
						disLambdaTextField.setEnabled(false);
						malzemelerTable.setEnabled(false);
						ekleButton.setEnabled(false);
						cikarButton.setEnabled(false);
						jPanel2.setEnabled(false);
						yapiElemani = new PencereYapiElemani();
					    yapiElemani.setYapiElemaniKodu("PE");
					    yapiElemani.setYapiElemaniAdi(aciklamaTextField.getText());
					    yapiElemani.setIsiGecirgenlikKatsayisi(Double.parseDouble(uDegeriTextField.getText()));
					}
					if(turlerComboBox.getSelectedItem().equals("Dýþ kapý")){
					    kodTextField.setText("DK");
					    jRadioButton.setSelected(true);
					    jRadioButton1.setEnabled(false);
						uDegeriTextField.setEnabled(true);
						icLambdaTextField.setEnabled(false);
						disLambdaTextField.setEnabled(false);
						malzemelerTable.setEnabled(false);
						ekleButton.setEnabled(false);
						cikarButton.setEnabled(false);
						jPanel2.setEnabled(false);
						yapiElemani = new KapiYapiElemani();
					    yapiElemani.setYapiElemaniKodu("DK");
					    yapiElemani.setYapiElemaniAdi(aciklamaTextField.getText());
					    yapiElemani.setIsiGecirgenlikKatsayisi(Double.parseDouble(uDegeriTextField.getText()));
					}
					if(turlerComboBox.getSelectedItem().equals("Ýç kapý")){
					    kodTextField.setText("ÝK");
					    jRadioButton.setSelected(true);
					    jRadioButton1.setEnabled(false);
						uDegeriTextField.setEnabled(true);
						icLambdaTextField.setEnabled(false);
						disLambdaTextField.setEnabled(false);
						malzemelerTable.setEnabled(false);
						ekleButton.setEnabled(false);
						cikarButton.setEnabled(false);
						jPanel2.setEnabled(false);
						yapiElemani = new KapiYapiElemani();
					    yapiElemani.setYapiElemaniKodu("ÝK");
					    yapiElemani.setYapiElemaniAdi(aciklamaTextField.getText());
					    yapiElemani.setIsiGecirgenlikKatsayisi(Double.parseDouble(uDegeriTextField.getText()));
					}
				}
			});
		}
		return turlerComboBox;
	}
	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setBounds(22, 94, 78, 26);
			jRadioButton.setText("Elle giriþ");
			jRadioButton.setSelected(true);
			jRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					uDegeriTextField.setEnabled(true);
					icLambdaTextField.setEnabled(false);
					disLambdaTextField.setEnabled(false);
					malzemelerTable.setEnabled(false);
					ekleButton.setEnabled(false);
					cikarButton.setEnabled(false);
					jPanel2.setEnabled(false);
				}
			});
		}
		return jRadioButton;
	}
	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setBounds(108, 94, 160, 26);
			jRadioButton1.setText("Hesaplama");
			jRadioButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					uDegeriTextField.setEnabled(false);
					icLambdaTextField.setEnabled(true);
					disLambdaTextField.setEnabled(true);
					malzemelerTable.setEnabled(true);
					ekleButton.setEnabled(true);
					cikarButton.setEnabled(true);
					jPanel2.setEnabled(true);
				}
			});
		}
		return jRadioButton1;
	}
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new BorderLayout());
			jPanel2.setBounds(20, 174, 440, 265);
			jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Yapý elemaný bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel2.setEnabled(false);
			jPanel2.add(getJPanel3(), java.awt.BorderLayout.CENTER);
			jPanel2.add(getJPanel4(), java.awt.BorderLayout.SOUTH);
			jPanel2.add(getJPanel5(), java.awt.BorderLayout.NORTH);
		}
		return jPanel2;
	}
	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new BorderLayout());
			jPanel3.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
		}
		return jPanel3;
	}
	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.add(getEkleButton(), null);
			jPanel4.add(getCikarButton(), null);
		}
		return jPanel4;
	}
	/**
	 * This method initializes ekleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getEkleButton() {
		if (ekleButton == null) {
			ekleButton = new JButton();
			ekleButton.setText("Ekle");
			ekleButton.setEnabled(false);
			ekleButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					SwingUtils.centerAndShowComponent(new MalzemeSecimiDialog(yapiElemani,malzemelerTable,uDegeriTextField));
				}
			});
		}
		return ekleButton;
	}
	/**
	 * This method initializes cikarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getCikarButton() {
		if (cikarButton == null) {
			cikarButton = new JButton();
			cikarButton.setText("Çýkar");
			cikarButton.setEnabled(false);
			cikarButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    int rowIndex = malzemelerTable.getSelectedRow();
				    Malzeme malzeme = ((SecilenMalzemelerTablemodel)malzemelerTable.getModel()).getMalzeme(rowIndex); 
					((TemelYapiElemani)yapiElemani).removeBilesen(malzeme);
					((SecilenMalzemelerTablemodel)malzemelerTable.getModel()).fireTableStructureChanged();
				}
			});
		}
		return cikarButton;
	}
	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jLabel6 = new JLabel();
			jLabel5 = new JLabel();
			jLabel4 = new JLabel();
			jPanel5 = new JPanel();
			jLabel4.setText("\u03BB iç");
			jLabel5.setText("\u03BB dýþ");
			jLabel6.setText("");
			jLabel6.setPreferredSize(new java.awt.Dimension(50,0));
			jPanel5.add(jLabel4, null);
			jPanel5.add(getIcLambdaTextField(), null);
			jPanel5.add(jLabel6, null);
			jPanel5.add(jLabel5, null);
			jPanel5.add(getDisLambdaTextField(), null);
		}
		return jPanel5;
	}
	/**
	 * This method initializes icLambdaTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIcLambdaTextField() {
		if (icLambdaTextField == null) {
			icLambdaTextField = new JTextField();
			icLambdaTextField.setPreferredSize(new java.awt.Dimension(100,20));
			icLambdaTextField.setEnabled(false);
			icLambdaTextField.setPreferredSize(new java.awt.Dimension(100,20));
			icLambdaTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					icLambdaTextField.setText("");
				}
			});
			icLambdaTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {
					String text = icLambdaTextField.getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
					    ((TemelYapiElemani)yapiElemani).setIcYuzeyselIsiTasinimKatsayisi(Double.parseDouble(text));
					    uDegeriTextField.setText(twoDigits.format(((TemelYapiElemani)yapiElemani).hesaplaIsiGecirgenlikKatsayisi()));
					} catch (NumberFormatException e1) {
						if(text.length()>1) icLambdaTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return icLambdaTextField;
	}
	/**
	 * This method initializes disLambdaTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getDisLambdaTextField() {
		if (disLambdaTextField == null) {
			disLambdaTextField = new JTextField();
			disLambdaTextField.setPreferredSize(new java.awt.Dimension(100,20));
			disLambdaTextField.setEnabled(false);
			disLambdaTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					disLambdaTextField.setText("");
				}
			});
			disLambdaTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = disLambdaTextField.getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					else text+= 's';
					try {
					    ((TemelYapiElemani)yapiElemani).setDisYuzeyselIsiTasinimKatsayisi(Double.parseDouble(text));
					    uDegeriTextField.setText(twoDigits.format(((TemelYapiElemani)yapiElemani).hesaplaIsiGecirgenlikKatsayisi()));
					} catch (NumberFormatException e1) {
						if(text.length()>1) disLambdaTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return disLambdaTextField;
	}
	/**
	 * This method initializes malzemelerTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getMalzemelerTable() {
		if (malzemelerTable == null) {
		    if(yapiElemani instanceof TemelYapiElemani){
		        SecilenMalzemelerTablemodel model = new SecilenMalzemelerTablemodel(yapiElemani);
				malzemelerTable = new JTable(model);
				malzemelerTable.setEnabled(false);
		    }
		}
		return malzemelerTable;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getMalzemelerTable());
		}
		return jScrollPane;
	}
  }  //  @jve:decl-index=0:visual-constraint="10,10"
