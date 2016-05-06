/*
 * Created on 03.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.iztek.dd.GenelTanimlarBean;
import com.iztek.dd.persistence.PersistenceManagerInt;
/**
 * @author Selim HENDRICKSON
 *
 */
public class GenelTanimlarDialog extends JDialog {

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JLabel jLabel = null;
	private JTextField bayiAdiTextField = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JLabel jLabel1 = null;
	private JTextField muhendisAdiTextField = null;
	private JLabel jLabel2 = null;
	private JTextField bayiAdresiTextField = null;
	private JLabel jLabel3 = null;
	private JTextField bayiTelefonuTextField = null;
	/**
	 * This is the default constructor
	 */
	public GenelTanimlarDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Genel tanýmlar");
		this.setSize(356, 209);
		this.setContentPane(getJContentPane());
		this.addComponentListener(new java.awt.event.ComponentAdapter() { 
			public void componentShown(java.awt.event.ComponentEvent e) {    
				getBayiAdiTextField().setText(GenelTanimlarBean.getInstance().getBayiAdi());
				getMuhendisAdiTextField().setText(GenelTanimlarBean.getInstance().getMuhendisAdi());
				getBayiAdresiTextField().setText(GenelTanimlarBean.getInstance().getBayiAdresi());
				getBayiTelefonuTextField().setText(GenelTanimlarBean.getInstance().getBayiTel());				
			}
		});
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new BorderLayout());
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
			jLabel.setText("Bayi adý");
			jLabel.setBounds(32, 11, 107, 21);
			jLabel1.setBounds(32, 43, 107, 21);
			jLabel1.setText("Mühendis adý");
			jLabel2.setBounds(32, 75, 107, 21);
			jLabel2.setText("Bayi adresi");
			jLabel3.setBounds(32, 107, 107, 21);
			jLabel3.setText("Bayi telefonu");
			jPanel.add(jLabel, null);
			jPanel.add(getBayiAdiTextField(), null);
			jPanel.add(jLabel1, null);
			jPanel.add(getMuhendisAdiTextField(), null);
			jPanel.add(jLabel2, null);
			jPanel.add(getBayiAdresiTextField(), null);
			jPanel.add(jLabel3, null);
			jPanel.add(getBayiTelefonuTextField(), null);
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
			jPanel1.add(getJButton(), null);
			jPanel1.add(getJButton1(), null);
		}
		return jPanel1;
	}
	/**
	 * This method initializes bayiAdiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBayiAdiTextField() {
		if (bayiAdiTextField == null) {
			bayiAdiTextField = new JTextField();
			bayiAdiTextField.setBounds(171, 11, 143, 21);
		}
		return bayiAdiTextField;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Kaydet");
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					GenelTanimlarBean.getInstance().setBayiAdi(getBayiAdiTextField().getText());
					GenelTanimlarBean.getInstance().setMuhendisAdi(getMuhendisAdiTextField().getText());
					GenelTanimlarBean.getInstance().setBayiAdresi(getBayiAdresiTextField().getText());
					GenelTanimlarBean.getInstance().setBayiTel(getBayiTelefonuTextField().getText());
					PersistenceManagerInt.INSTANCE.saveGenelTanimlar(GenelTanimlarBean.getInstance());
					dispose();
				}
			});
		}
		return jButton;
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
	/**
	 * This method initializes muhendisAdiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getMuhendisAdiTextField() {
		if (muhendisAdiTextField == null) {
			muhendisAdiTextField = new JTextField();
			muhendisAdiTextField.setBounds(171, 43, 143, 21);
		}
		return muhendisAdiTextField;
	}
	/**
	 * This method initializes bayiAdresiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBayiAdresiTextField() {
		if (bayiAdresiTextField == null) {
			bayiAdresiTextField = new JTextField();
			bayiAdresiTextField.setBounds(171, 75, 143, 21);
		}
		return bayiAdresiTextField;
	}
	/**
	 * This method initializes bayiTelefonuTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBayiTelefonuTextField() {
		if (bayiTelefonuTextField == null) {
			bayiTelefonuTextField = new JTextField();
			bayiTelefonuTextField.setBounds(171, 107, 143, 21);
		}
		return bayiTelefonuTextField;
	}
        }  //  @jve:decl-index=0:visual-constraint="10,10"
