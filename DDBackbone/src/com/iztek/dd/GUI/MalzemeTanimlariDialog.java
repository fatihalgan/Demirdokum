/*
 * Created on 06.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKaybi.domain.Malzeme;
import com.iztek.dd.IsiKaybi.domain.MalzemeCatalog;
import com.iztek.dd.IsiKaybi.domain.MalzemeTableModel;
/**
 * @author Selim HENDRICKSON
 *
 */
public class MalzemeTanimlariDialog extends JDialog {

	private javax.swing.JPanel jContentPane = null;

	private JTable malzemeTanimlariTable = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel = null;
	private JButton ekleButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton kapatButton = null;
	/**
	 * This is the default constructor
	 */
	public MalzemeTanimlariDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Isý kaybý - Malzemeler");
		this.setSize(454, 352);
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
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getJPanel(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	/**
	 * This method initializes malzemeTanimlariTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getMalzemeTanimlariTable() {
		if (malzemeTanimlariTable == null) {
			malzemeTanimlariTable = new JTable();
			malzemeTanimlariTable.setModel(new MalzemeTableModel());
			malzemeTanimlariTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			malzemeTanimlariTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		}
		return malzemeTanimlariTable;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getMalzemeTanimlariTable());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.add(getEkleButton(), null);
			jPanel.add(getJButton2(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getKapatButton(), null);
		}
		return jPanel;
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
				    Malzeme newMalzeme = new Malzeme();
					SwingUtils.centerAndShowComponent(new MalzemeDetayDialog(newMalzeme,getMalzemeTanimlariTable().getModel(),true));
				}
			});
		}
		return ekleButton;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Çýkar");
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    MalzemeTableModel model = (MalzemeTableModel)malzemeTanimlariTable.getModel();
				    int rowIndex = malzemeTanimlariTable.getSelectedRow();
				    model.removeRow(rowIndex);
				}
			});
		}
		return jButton1;
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
				    MalzemeTableModel model = (MalzemeTableModel)malzemeTanimlariTable.getModel();
				    int rowIndex = malzemeTanimlariTable.getSelectedRow();
				    Malzeme malzeme = (Malzeme)model.getMalzemeler().get(rowIndex);
				    SwingUtils.centerAndShowComponent(new MalzemeDetayDialog(malzeme,model,false));
				    MalzemeCatalog.getInstance().setDirty(true);
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
				    MalzemeCatalog.getInstance().setMalzemeler(((MalzemeTableModel)malzemeTanimlariTable.getModel()).getMalzemeler());
				    MalzemeCatalog.getInstance().serializeSelfToXML();
					dispose();
				}
			});
		}
		return kapatButton;
	}
     }  //  @jve:decl-index=0:visual-constraint="10,10"
