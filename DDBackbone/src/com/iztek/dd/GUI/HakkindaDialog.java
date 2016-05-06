/*
 * Created on 07.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 * @author Selim HENDRICKSON
 *
 */
public class HakkindaDialog extends JDialog {

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton jButton = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	/**
	 * This is the default constructor
	 */
	public HakkindaDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Hakk�nda...");
		this.setSize(521, 375);
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
			jPanel.add(getJButton(), null);
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
			jLabel2 = new JLabel();
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jLabel.setText("");
			jLabel.setBounds(2, 3, 256, 229);
			jLabel.setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/iyte_eng_logo.gif")));
			jLabel1.setBounds(258, 19, 255, 210);
			jLabel1.setText("<HTML>Bu yaz�l�m �zmir Y�ksek Teknoloji Enstit�s� (IYTE) - �ztek A.�. �al��anlar�nca geli�tirilmi� olup teknik dan��manl�k hizmeti IYTE Makina M�hendisli�i B�l�m� ��retim elemanlar� Prof. Dr. Zafer �lken, Do�. Dr. Bar�� �zerdem ve Ar. G�r. Bar�� Budak taraf�ndan verilmi�tir. Mart - 2005</HTML>");
			jLabel2.setBounds(110, 250, 304, 38);
			jLabel2.setText("\u00A9 Her hakk� sakl�d�r.");
			jPanel1.add(jLabel, null);
			jPanel1.add(jLabel1, null);
			jPanel1.add(jLabel2, null);
		}
		return jPanel1;
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
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					dispose();
				}
			});
		}
		return jButton;
	}
   }  //  @jve:decl-index=0:visual-constraint="10,10"
