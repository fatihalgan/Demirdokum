/*
 * Created on 06.Oca.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.GUI;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;
/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class IsletmeTipiArttirimKatsayilariDialog extends JDialog {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -7241090553430200090L;
	
	private javax.swing.JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JButton jButton = null;
	private JTable jTable = null;
	/**
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog() throws HeadlessException {
		super();
		
		initialize();
	}

	/**
	 * @param arg0
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Frame arg0) throws HeadlessException {
		super(arg0);
		
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Frame arg0, boolean arg1)
			throws HeadlessException {
		super(arg0, arg1);
		
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Frame arg0, String arg1) throws HeadlessException {
		super(arg0, arg1);
		
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Frame arg0, String arg1, boolean arg2)
			throws HeadlessException {
		super(arg0, arg1, arg2);
		
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Frame arg0, String arg1, boolean arg2,
			GraphicsConfiguration arg3) {
		super(arg0, arg1, arg2, arg3);
		
		initialize();
	}

	/**
	 * @param arg0
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Dialog arg0) throws HeadlessException {
		super(arg0);
		
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Dialog arg0, boolean arg1)
			throws HeadlessException {
		super(arg0, arg1);
		
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Dialog arg0, String arg1)
			throws HeadlessException {
		super(arg0, arg1);
		
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Dialog arg0, String arg1, boolean arg2)
			throws HeadlessException {
		super(arg0, arg1, arg2);
		
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws java.awt.HeadlessException
	 */
	public IsletmeTipiArttirimKatsayilariDialog(Dialog arg0, String arg1, boolean arg2,
			GraphicsConfiguration arg3) throws HeadlessException {
		super(arg0, arg1, arg2, arg3);
		
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(459, 188);
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
			jContentPane.add(getJPanel(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getJButton(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getJTable(), java.awt.BorderLayout.CENTER);
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
			jLabel = new JLabel();
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			jLabel.setText("Ýþletme Durumunu Seçiniz");
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jPanel.add(jLabel, java.awt.BorderLayout.NORTH);
		}
		return jPanel;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Tamam");
		}
		return jButton;
	}
	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
		}
		return jTable;
	}
    }  //  @jve:decl-index=0:visual-constraint="80,66"
