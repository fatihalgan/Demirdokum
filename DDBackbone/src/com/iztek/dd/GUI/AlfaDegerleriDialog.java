/*
 * Created on 08.Mar.2005
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
import com.iztek.dd.IsiKaybi.domain.AlfaDegeri;
import com.iztek.dd.IsiKaybi.domain.AlfaDegerleriCatalog;
import com.iztek.dd.IsiKaybi.domain.AlfaDegerleriTableModel;
/**
 * @author Selim HENDRICKSON
 *
 */
public class AlfaDegerleriDialog extends JDialog {

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton ekleButton = null;
	private JButton duzeltButton = null;
	private JButton silButton = null;
	private JButton tamamButton = null;
	private JTable alfaDegerleriTable = null;
	private JScrollPane jScrollPane = null;
	/**
	 * This is the default constructor
	 */
	public AlfaDegerleriDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Alfa Degeri Tanýmlarý");
		this.setSize(375, 323);
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
			jPanel.add(getEkleButton(), null);
			jPanel.add(getDuzeltButton(), null);
			jPanel.add(getSilButton(), null);
			jPanel.add(getTamamButton(), null);
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
			jPanel1.setLayout(new BorderLayout());
			jPanel1.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
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
					SwingUtils.centerAndShowComponent(new AlfaDegeriDetayDialog(alfaDegerleriTable.getModel()));					
				}
			});
		}
		return ekleButton;
	}
	/**
	 * This method initializes duzeltButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getDuzeltButton() {
		if (duzeltButton == null) {
			duzeltButton = new JButton();
			duzeltButton.setText("Düzelt");
			duzeltButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    int rowIndex = alfaDegerleriTable.getSelectedRow();
				    AlfaDegeri alfaDegeri = ((AlfaDegerleriTableModel)alfaDegerleriTable.getModel()).getAlfaDegeri(rowIndex);
					SwingUtils.centerAndShowComponent(new AlfaDegeriDetayDialog(alfaDegeri,alfaDegerleriTable.getModel()));					
				}
			});
		}
		return duzeltButton;
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
					int index = alfaDegerleriTable.getSelectedRow();
					((AlfaDegerleriTableModel)alfaDegerleriTable.getModel()).removeAlfaDegeri(index);
					alfaDegerleriTable.getColumnModel().getColumn(0).setWidth(250);
					alfaDegerleriTable.getColumnModel().getColumn(0).setPreferredWidth(250);
				}
			});
		}
		return silButton;
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
				    AlfaDegerleriCatalog.getInstance().serializeSelf();
					dispose();
				}
			});
		}
		return tamamButton;
	}
	/**
	 * This method initializes alfaDegerleriTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getAlfaDegerleriTable() {
		if (alfaDegerleriTable == null) {
		    AlfaDegerleriTableModel model = new AlfaDegerleriTableModel();
			alfaDegerleriTable = new JTable(model);
			alfaDegerleriTable.getColumnModel().getColumn(0).setWidth(250);
			alfaDegerleriTable.getColumnModel().getColumn(0).setPreferredWidth(250);
			alfaDegerleriTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return alfaDegerleriTable;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getAlfaDegerleriTable());
		}
		return jScrollPane;
	}
        }  //  @jve:decl-index=0:visual-constraint="10,10"
