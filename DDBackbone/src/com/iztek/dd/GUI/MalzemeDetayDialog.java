/*
 * Created on 06.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import com.iztek.dd.IsiKaybi.domain.Malzeme;
import com.iztek.dd.IsiKaybi.domain.MalzemeTableModel;
/**
 * @author Selim HENDRICKSON
 *
 */
public class MalzemeDetayDialog extends JDialog {
    Malzeme malzeme = null;
    MalzemeTableModel model = null;
    boolean create = false;
    
	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JLabel jLabel = null;
	private JButton tamamButton = null;
	private JButton vazgecButton = null;
	private JTextField malzemeKoduTextField = null;
	private JLabel jLabel1 = null;
	private JTextField malzemeAdiTextField = null;
	private JLabel jLabel2 = null;
	private JTextField lambdaTextField = null;
	private JLabel jLabel3 = null;
	/**
	 * This is the default constructor
	 * @param newMalzeme
	 * @param model
	 * @param create
	 */
	public MalzemeDetayDialog(Malzeme newMalzeme, TableModel model, boolean create) {
		super();
		malzeme = newMalzeme;
		this.model = (MalzemeTableModel)model;
		this.create = create; 
		initialize();
	}
    /**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Malzeme detaylarý");
		this.setSize(340, 200);
		this.setContentPane(getJContentPane());
		malzemeKoduTextField.setText(malzeme.getKod());
		malzemeAdiTextField.setText(malzeme.getMalzemeAdi());
		lambdaTextField.setText(""+malzeme.getLambda());
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
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getJPanel1(), java.awt.BorderLayout.SOUTH);
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
			jLabel3 = new JLabel();
			jLabel2 = new JLabel();
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jLabel.setText("Malzeme kodu");
			jLabel.setBounds(32, 19, 83, 23);
			jLabel1.setBounds(32, 61, 83, 23);
			jLabel1.setText("Malzeme adý");
			jLabel2.setBounds(32, 103, 83, 23);
			jLabel2.setText("\u03BB");
			jLabel3.setBounds(269, 103, 48, 23);
			jLabel3.setText("(W/m K)");
			jPanel.add(jLabel, null);
			jPanel.add(getMalzemeKoduTextField(), null);
			jPanel.add(jLabel1, null);
			jPanel.add(getMalzemeAdiTextField(), null);
			jPanel.add(jLabel2, null);
			jPanel.add(getLambdaTextField(), null);
			jPanel.add(jLabel3, null);
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
			jPanel1 = new JPanel();
			jPanel1.add(getTamamButton(), null);
			jPanel1.add(getVazgecButton(), null);
		}
		return jPanel1;
	}
	/**
	 * This method initializes tamamButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTamamButton() {
		if (tamamButton == null) {
			tamamButton = new JButton();
			tamamButton.setText("Tamam");
			tamamButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					malzeme.setKod(malzemeKoduTextField.getText());
					malzeme.setMalzemeAdi(malzemeAdiTextField.getText());
					malzeme.setLambda(Double.parseDouble(lambdaTextField.getText()));
					if(create) model.addRow(malzeme);
					else model.fireTableStructureChanged();
					create = false;
					dispose();
				}
			});
		}
		return tamamButton;
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
	 * This method initializes malzemeKoduTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getMalzemeKoduTextField() {
		if (malzemeKoduTextField == null) {
			malzemeKoduTextField = new JTextField();
			malzemeKoduTextField.setBounds(147, 19, 112, 23);
		}
		return malzemeKoduTextField;
	}
	/**
	 * This method initializes malzemeAdiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getMalzemeAdiTextField() {
		if (malzemeAdiTextField == null) {
			malzemeAdiTextField = new JTextField();
			malzemeAdiTextField.setBounds(147, 61, 112, 23);
		}
		return malzemeAdiTextField;
	}
	/**
	 * This method initializes lambdaTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getLambdaTextField() {
		if (lambdaTextField == null) {
			lambdaTextField = new JTextField();
			lambdaTextField.setBounds(147, 103, 112, 23);
		}
		return lambdaTextField;
	}
       }  //  @jve:decl-index=0:visual-constraint="10,10"
