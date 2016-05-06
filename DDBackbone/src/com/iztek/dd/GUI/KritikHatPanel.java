/*
 * Created on 01.Ara.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.table.TableModel;

import com.iztek.dd.GUI.util.SwingUtils;

/**
 * @author db2admin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class KritikHatPanel extends JPanel {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -476086380032291612L;
	
	private javax.swing.JTable kritikHatTable = null;
	private javax.swing.JScrollPane jScrollPane = null;
	private javax.swing.JPanel jPanel = null;
	private javax.swing.JButton ekleButton = null;
	private javax.swing.JButton silButton = null;
	/**
	 * This is the default constructor
	 */
	public KritikHatPanel() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new java.awt.BorderLayout());
		this.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
		this.add(getJPanel(), java.awt.BorderLayout.SOUTH);
		this.setSize(383, 304);
	}
	/**
	 * This method initializes kritikHatTable
	 * 
	 * @return javax.swing.JTable
	 */
	private javax.swing.JTable getKritikHatTable() {
		if(kritikHatTable == null) {
			kritikHatTable = new javax.swing.JTable();
		}
		return kritikHatTable;
	}
	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if(jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getKritikHatTable());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel() {
		if(jPanel == null) {
			jPanel = new javax.swing.JPanel();
			jPanel.add(getEkleButton(), null);
			jPanel.add(getSilButton(), null);
			jPanel.setPreferredSize(new java.awt.Dimension(10,50));
		}
		return jPanel;
	}
	/**
	 * This method initializes ekleButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getEkleButton() {
		if(ekleButton == null) {
			ekleButton = new javax.swing.JButton();
			ekleButton.setText("Ekle");
		}
		return ekleButton;
	}
	/**
	 * This method initializes silButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getSilButton() {
		if(silButton == null) {
			silButton = new javax.swing.JButton();
			silButton.setText("Sil");
		}
		return silButton;
	}
	
	public void setKritikHatTableModel(TableModel model){
	    getKritikHatTable().setModel(model);
	}
	
	public void addEkleButtonListener(ActionListener listener){
	    getEkleButton().addActionListener(listener);
	}
	public void addDuzeltButtonListener(ActionListener listener){
//	    getDuzeltButton().addActionListener(listener);
	}
	public void addSilButtonListener(ActionListener listener){
	    getSilButton().addActionListener(listener);
	}
	
	public ParcaBilgileriDialog showParcaBilgileriDialog(){
	    ParcaBilgileriDialog parcaEkle = new ParcaBilgileriDialog();
		//parcaEkle.getContentPane().add(new ParcaBilgileriDialog());
		parcaEkle.setSize(600,470);
		SwingUtils.centerAndShowComponent(parcaEkle);
		parcaEkle.setVisible(true);
		return parcaEkle;
	}
    /**
     * @return
     */
    public TableModel getKritikHatTableModel() {
        return getKritikHatTable().getModel();
    }
	/**
	 * @return
	 */
	public int getKritikHatTableSelectedIndex() {
		return getKritikHatTable().getSelectedRow();
	}
}  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"
