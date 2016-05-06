/*
 * Created on 07.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.BorderLayout;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.iztek.dd.IsiKaybi.domain.Malzeme;
import com.iztek.dd.IsiKaybi.domain.MalzemeTableModel;
import com.iztek.dd.IsiKaybi.domain.SecilenMalzemelerTablemodel;
import com.iztek.dd.IsiKaybi.domain.TemelYapiElemani;
import com.iztek.dd.IsiKaybi.domain.YapiElemani;
/**
 * @author Selim HENDRICKSON
 *
 */
public class MalzemeSecimiDialog extends JDialog {
    private TemelYapiElemani yapiElemani = null;
    SecilenMalzemelerTablemodel model = null;
    JTable malzemelerTable2 = null;
    JTextField uDegeriTextField = null;
    DecimalFormat twoDigits = new DecimalFormat("#.##");
    
	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton ekleButton = null;
	private JButton vazgecButton = null;
	private JTable malzemelerTable = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel2 = null;
	private JLabel jLabel = null;
	private JTextField kalinlikTextField = null;
	/**
	 * This is the default constructor
	 * @param uDegeriTextField
	 */	
	public MalzemeSecimiDialog(YapiElemani yapiElemani, JTable malzemelerTable2, JTextField uDegeriTextField) {
		super();
		this.yapiElemani = (TemelYapiElemani)yapiElemani;
		initialize();
		this.malzemelerTable2 = malzemelerTable2;
		this.model = (SecilenMalzemelerTablemodel)malzemelerTable2.getModel();
		this.uDegeriTextField = uDegeriTextField;
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(412, 322);
		this.setContentPane(getJContentPane());
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
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			jPanel.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
			jPanel.add(getJPanel2(), java.awt.BorderLayout.SOUTH);
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
			jPanel1.add(getEkleButton(), null);
			jPanel1.add(getVazgecButton(), null);
		}
		return jPanel1;
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
			ekleButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					int rowIndex = malzemelerTable.getSelectedRow();
					Malzeme malzeme = ((Malzeme)((MalzemeTableModel)malzemelerTable.getModel()).getMalzemeler().get(rowIndex)).cloneSelf();
					malzeme.setKalinlik(Double.parseDouble(kalinlikTextField.getText()));
					yapiElemani.addBilesen(malzeme);										
					model.fireTableStructureChanged();
					malzemelerTable2.getColumnModel().getColumn(1).setPreferredWidth(10);
					malzemelerTable2.getColumnModel().getColumn(1).setWidth(10);				
					uDegeriTextField.setText(twoDigits.format(yapiElemani.hesaplaIsiGecirgenlikKatsayisi()));
					dispose();
				}
			});
		}
		return ekleButton;
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
	 * This method initializes malzemelerTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getMalzemelerTable() {
		if (malzemelerTable == null) {
		    MalzemeTableModel model = new MalzemeTableModel();
			malzemelerTable = new JTable(model);
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
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabel = new JLabel();
			jPanel2 = new JPanel();
			jLabel.setText("Kalýnlýk");
			jPanel2.add(jLabel, null);
			jPanel2.add(getKalinlikTextField(), null);
		}
		return jPanel2;
	}
	/**
	 * This method initializes kalinlikTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getKalinlikTextField() {
		if (kalinlikTextField == null) {
			kalinlikTextField = new JTextField();
			kalinlikTextField.setPreferredSize(new java.awt.Dimension(50,20));
		}
		return kalinlikTextField;
	}
        }  //  @jve:decl-index=0:visual-constraint="10,10"
