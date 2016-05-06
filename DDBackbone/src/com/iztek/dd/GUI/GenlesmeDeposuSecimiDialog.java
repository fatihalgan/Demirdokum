/*
 * Created on 14.Þub.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionListener;

import javax.swing.JDialog;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
/**
 * @author Selim HENDRICKSON
 *
 */
public class GenlesmeDeposuSecimiDialog extends JDialog {

	private javax.swing.JPanel jContentPane = null;

	private JTable genlesmeDepolariTable = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel = null;
	private JButton tamamButton = null;
	private JButton jButton1 = null;
	/**
	 * This is the default constructor
	 */
	public GenlesmeDeposuSecimiDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(337, 293);
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
	 * This method initializes genlesmeDepolariTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getGenlesmeDepolariTable() {
		if (genlesmeDepolariTable == null) {
			genlesmeDepolariTable = new JTable();
			genlesmeDepolariTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);			
		}
		return genlesmeDepolariTable;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getGenlesmeDepolariTable());
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
			jPanel.add(getTamamButton(), null);
			jPanel.add(getJButton1(), null);
		}
		return jPanel;
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
					dispose();
				}
			});
		}
		return tamamButton;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Vazgeç");
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					dispose();
				}
			});
		}
		return jButton1;
	}
	public void addDepoSecimDialogTamamButtonActionListener(ActionListener listener) {
		getTamamButton().addActionListener(listener);
	}
	public String getSelectedDepoModeli() {
		return (String)genlesmeDepolariTable.getModel().getValueAt(genlesmeDepolariTable.getSelectedRow(),0);
	}
	public void setTableModel(TableModel genlesmeDepolariTableModel) {
		getGenlesmeDepolariTable().setModel(genlesmeDepolariTableModel);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
