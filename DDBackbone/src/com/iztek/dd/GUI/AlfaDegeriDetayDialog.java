/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.TableModel;

import com.iztek.dd.IsiKaybi.domain.AlfaDegeri;
import com.iztek.dd.IsiKaybi.domain.AlfaDegerleriTableModel;
/**
 * @author Selim HENDRICKSON
 *
 */
public class AlfaDegeriDetayDialog extends JDialog {
    private AlfaDegeri alfaDegeri = null;
    private AlfaDegerleriTableModel model = null;
    private boolean update = false;
    
	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton ekleButton = null;
	private JButton vazgecButton = null;
	private JTextField aciklamaTextField = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField alfaIcTextField = null;
	private JLabel jLabel2 = null;
	private JTextField alfaDisTextField = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	/**
	 * This is the default constructor
	 * @param model
	 * @param alfaDegeri2
	 */
	public AlfaDegeriDetayDialog() {
		super();		
	}
	/**
     * @param alfaDegeri
     */
    public AlfaDegeriDetayDialog(AlfaDegeri alfaDegeri,TableModel model) {
        this();
        update = true;
        this.alfaDegeri = alfaDegeri;
        this.model = (AlfaDegerleriTableModel)model;
        initialize();
    }
    /**
     * @param model2
     */
    public AlfaDegeriDetayDialog(TableModel model) {
        this();
        update = false;
        alfaDegeri = new AlfaDegeri();
        this.model = (AlfaDegerleriTableModel)model;
        initialize();
    }
    /**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Alfa deðeri detaylarý");
		this.setSize(337, 200);
		this.setContentPane(getJContentPane());
		aciklamaTextField.setText(alfaDegeri.getAciklama());
		alfaIcTextField.setText(""+alfaDegeri.getAlphaIc());
		alfaDisTextField.setText(""+alfaDegeri.getAlphaDis());
		aciklamaTextField.setCaretPosition(0);
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
			jPanel.add(getVazgecButton(), null);
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
			jLabel4 = new JLabel();
			jLabel3 = new JLabel();
			jLabel2 = new JLabel();
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jLabel.setBounds(32, 16, 70, 21);
			jLabel.setText("Açýklama");
			jLabel1.setBounds(32, 53, 70, 21);
			jLabel1.setText("Alfa iç");
			jLabel2.setBounds(32, 90, 70, 21);
			jLabel2.setText("Alfa dýþ");
			jLabel3.setBounds(275, 90, 46, 21);
			jLabel3.setText("<HTML>W/m<SUP>2</SUP> K</HTML>");
			jLabel4.setBounds(275, 53, 46, 21);
			jLabel4.setText("<HTML>W/m<SUP>2</SUP> K</HTML>");
			jPanel1.add(getAciklamaTextField(), null);
			jPanel1.add(jLabel, null);
			jPanel1.add(jLabel1, null);
			jPanel1.add(getAlfaIcTextField(), null);
			jPanel1.add(jLabel2, null);
			jPanel1.add(getAlfaDisTextField(), null);
			jPanel1.add(jLabel3, null);
			jPanel1.add(jLabel4, null);
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
			ekleButton.setText("Tamam");
			ekleButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					alfaDegeri.setAciklama(aciklamaTextField.getText());
					alfaDegeri.setAlphaIc(Double.parseDouble(alfaIcTextField.getText()));
					alfaDegeri.setAlphaDis(Double.parseDouble(alfaDisTextField.getText()));
					if(update==false) model.addAlfaDegeri(alfaDegeri);
					model.fireTableStructureChanged();
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
	 * This method initializes aciklamaTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getAciklamaTextField() {
		if (aciklamaTextField == null) {
			aciklamaTextField = new JTextField();
			aciklamaTextField.setBounds(126, 16, 140, 21);
		}
		return aciklamaTextField;
	}
	/**
	 * This method initializes alfaIcTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getAlfaIcTextField() {
		if (alfaIcTextField == null) {
			alfaIcTextField = new JTextField();
			alfaIcTextField.setBounds(126, 53, 140, 21);
		}
		return alfaIcTextField;
	}
	/**
	 * This method initializes alfaDisTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getAlfaDisTextField() {
		if (alfaDisTextField == null) {
			alfaDisTextField = new JTextField();
			alfaDisTextField.setBounds(126, 90, 140, 21);
		}
		return alfaDisTextField;
	}
       }  //  @jve:decl-index=0:visual-constraint="10,10"
