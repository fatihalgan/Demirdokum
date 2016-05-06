/*
 * Created on 02.Oca.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.tree.DefaultTreeModel;
/**
 * @author Selim HENDRICKSON
 *
 */
public class BilesenEkleDialog extends JDialog {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 7535197741426196469L;

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JScrollPane jScrollPane = null;
	private JTree jTree = null;
	private JButton ekleButton = null;
	private JButton vazgecButton = null;
	private Object[] newRow = null;
	/**
	 * This is the default constructor
	 */
	public BilesenEkleDialog() {
		super();
		initialize();		
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 600);
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
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
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
			jPanel.setLayout(null);
			jPanel.setPreferredSize(new java.awt.Dimension(600,50));
			jPanel.add(getEkleButton(), null);
			jPanel.add(getVazgecButton(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTree());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jTree	
	 * 	
	 * @return javax.swing.JTree	
	 */    
	private JTree getJTree() {
		if (jTree == null) {
			jTree = new JTree();
		}
		return jTree;
	}
	/**
	 * This method initializes ekleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getEkleButton() {
		if (ekleButton == null) {
			ekleButton = new JButton();
			ekleButton.setBounds(134, 11, 96, 26);
			ekleButton.setText("Ekle");
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
			vazgecButton.setBounds(363, 11, 96, 26);
			vazgecButton.setText("Vazgeç");
		}
		return vazgecButton;
	}
	public void addEkleButtonActionListener(ActionListener listener) {
		getEkleButton().addActionListener(listener);	
	}
	
	public Object getSelectedMalzeme() {
		return getJTree().getLastSelectedPathComponent();
	}
	
	public void setMalzemeTreeModel(DefaultTreeModel treeModel) {
		getJTree().setModel(treeModel);
	}
	public void addVazgecButtonActionListener(ActionListener listener) {
		getVazgecButton().addActionListener(listener);
	}
	
	public Object[] getNewRow() {
		return newRow;
	}
	
	
	public void setNewRow(Object[] newRow) {
		this.newRow = newRow;
	}
    public void addTreeMouseListener(MouseAdapter adapter) {
        getJTree().addMouseListener(adapter);
    }
  }
