/*
 * Created on 07.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKaybi.domain.CogunluklaKullanilanYapiElemanlari;
import com.iztek.dd.IsiKaybi.domain.DuvarYapiElemani;
import com.iztek.dd.IsiKaybi.domain.UDegerleriTableModel;
import com.iztek.dd.IsiKaybi.domain.YapiElemani;
/**
 * @author Selim HENDRICKSON
 *
 */
public class UDegerleriDialog extends JDialog {

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton ekleButton = null;
	private JButton silButton = null;
	private JButton jButton2 = null;
	private JButton kapatButton = null;
	private JTable yapiElemanlariTable = null;
	private JScrollPane jScrollPane = null;
	/**
	 * This is the default constructor
	 */
	public UDegerleriDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("U Degeri Kayýtlarý");
		this.setSize(442, 330);
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
			jPanel1.add(getSilButton(), null);
			jPanel1.add(getJButton2(), null);
			jPanel1.add(getKapatButton(), null);
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
				    YapiElemani yapiElemani = new DuvarYapiElemani();
					UdegeriGirisiDialog dialog = new UdegeriGirisiDialog(yapiElemani,yapiElemanlariTable.getModel());
					SwingUtils.centerAndShowComponent(dialog);
				}
			});
		}
		return ekleButton;
	}
	/**
	 * This method initializes silButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getSilButton() {
		if (silButton == null) {
			silButton = new JButton();
			silButton.setText("Sil");
			silButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					int index = yapiElemanlariTable.getSelectedRow();
					((UDegerleriTableModel)yapiElemanlariTable.getModel()).deleteYapiElemani(index);
				}
			});
		}
		return silButton;
	}
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Düzelt");
			jButton2.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					int rowIndex = yapiElemanlariTable.getSelectedRow();
					YapiElemani yapiElemani = ((UDegerleriTableModel)yapiElemanlariTable.getModel()).getYapElemani(rowIndex);					
					SwingUtils.centerAndShowComponent(new UdegeriGirisiDialog(yapiElemani,yapiElemanlariTable.getModel()));
				}
			});
		}
		return jButton2;
	}
	/**
	 * This method initializes kapatButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getKapatButton() {
		if (kapatButton == null) {
			kapatButton = new JButton();
			kapatButton.setText("Kapat");
			kapatButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    CogunluklaKullanilanYapiElemanlari.getInstance().serializeSelfToXML();
					dispose();
				}
			});
		}
		return kapatButton;
	}
	/**
	 * This method initializes yapiElemanlariTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getYapiElemanlariTable() {
		if (yapiElemanlariTable == null) {
		    UDegerleriTableModel model = new UDegerleriTableModel();
			yapiElemanlariTable = new JTable(model);
			yapiElemanlariTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return yapiElemanlariTable;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getYapiElemanlariTable());
		}
		return jScrollPane;
	}
        }  //  @jve:decl-index=0:visual-constraint="10,10"
