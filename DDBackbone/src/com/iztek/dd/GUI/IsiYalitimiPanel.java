/*
 * Created on 01.Ara.2004
 *
 */
package com.iztek.dd.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKaybi.domain.Bina;
import com.iztek.dd.IsiKaybi.domain.IsiYalitimiTableModel;
import com.iztek.dd.IsiKaybi.domain.StandartYalitimBileseni;
/**
 * @author Selim HENDRICKSON
 *
 */
public class IsiYalitimiPanel extends JPanel {
	EkBilesenGirisiDialog ekBilesenGirisiDialog = new EkBilesenGirisiDialog(this);
	Bina bina = null;
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1582910638361525999L;
	
	private javax.swing.JScrollPane jScrollPane = null;
	private javax.swing.JTable standartBilesenlerTable = null;
	private javax.swing.JScrollPane jScrollPane1 = null;
	private javax.swing.JTable ekBilesenlerTable = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JButton ekleButton = null;
	private javax.swing.JButton duzeltButton = null;
	private javax.swing.JButton silButton = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JPanel jPanel = null;
	/**
	 * This is the default constructor
	 */
	public IsiYalitimiPanel() {
		super();		
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		jLabel5 = new JLabel();
		jLabel4 = new JLabel();
		jLabel3 = new JLabel();
		jLabel2 = new JLabel();
		this.setLayout(new GridBagLayout());
		this.setSize(622, 387);
		jLabel2.setText("Yönetmelik");
		jLabel3.setText("Hesap");
		jLabel4.setText("Yönetmelik");
		jLabel4.setBounds(197, 15, 77, 16);
		jLabel5.setText("Hesap");
		jLabel5.setBounds(288, 15, 85, 16);
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.gridy = 0;
		gridBagConstraints2.ipadx = 9;
		gridBagConstraints2.insets = new java.awt.Insets(29,44,4,19);
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.gridy = 1;
		gridBagConstraints3.gridwidth = 3;
		gridBagConstraints3.weightx = 1.0;
		gridBagConstraints3.weighty = 1.0;
		gridBagConstraints3.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints3.ipadx = 70;
		gridBagConstraints3.insets = new java.awt.Insets(4,45,6,54);
		gridBagConstraints4.gridx = 1;
		gridBagConstraints4.gridy = 0;
		gridBagConstraints4.ipadx = 14;
		gridBagConstraints4.insets = new java.awt.Insets(29,19,4,7);
		gridBagConstraints5.gridx = 2;
		gridBagConstraints5.gridy = 0;
		gridBagConstraints5.ipadx = 49;
		gridBagConstraints5.insets = new java.awt.Insets(29,7,4,247);
		gridBagConstraints6.gridx = 0;
		gridBagConstraints6.gridy = 2;
		gridBagConstraints6.gridwidth = 3;
		gridBagConstraints6.ipadx = 607;
		gridBagConstraints6.ipady = 201;
		gridBagConstraints6.insets = new java.awt.Insets(7,6,19,8);
		this.add(getJLabel1(), gridBagConstraints2);
		this.add(getJScrollPane(), gridBagConstraints3);
		this.add(jLabel2, gridBagConstraints4);
		this.add(jLabel3, gridBagConstraints5);
		this.add(getJPanel(), gridBagConstraints6);
	}
	/**
	 * This method initializes standartBilesenlerTable
	 * 
	 * @return javax.swing.JTable
	 */
	private javax.swing.JTable getStandartBilesenlerTable() {
		if(standartBilesenlerTable == null) {
			Object tempTableValues[][] = new Object[5][6];
			Object columnNames[] = {"Yapý Bileþeni", "1/\u039B (m2K/W)", "1/\u039B (m2K/W)", "U (W/m2 K)", "A (m2)","UxA (W/K)"};
			DefaultTableModel tableModel = new DefaultTableModel(tempTableValues, columnNames);
			standartBilesenlerTable = new javax.swing.JTable();
			standartBilesenlerTable.setModel(tableModel);
			standartBilesenlerTable.setEnabled(false);
			standartBilesenlerTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		}
		return standartBilesenlerTable;
	}
	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if(jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getStandartBilesenlerTable());
			jScrollPane.setPreferredSize(new java.awt.Dimension(453,100));
		}
		return jScrollPane;
	}
	/**
	 * This method initializes ekBilesenlerTable
	 * 
	 * @return javax.swing.JTable
	 */
	private javax.swing.JTable getEkBilesenlerTable() {
		if(ekBilesenlerTable == null) {
			ekBilesenlerTable = new javax.swing.JTable();
			ekBilesenlerTable.setEnabled(true);			
		}
		return ekBilesenlerTable;
	}
	/**
	 * This method initializes jScrollPane1
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new javax.swing.JScrollPane();
			jScrollPane1.setViewportView(getEkBilesenlerTable());
			jScrollPane1.setBounds(41, 38, 525, 100);
			jScrollPane1.setPreferredSize(new java.awt.Dimension(453,100));
		}
		return jScrollPane1;
	}
	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setText("Ek Bileþenler");
			jLabel.setBounds(42, 15, 119, 16);
		}
		return jLabel;
	}
	/**
	 * This method initializes jLabel1
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new javax.swing.JLabel();
			jLabel1.setText("Standart bileþenler");
		}
		return jLabel1;
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
			ekleButton.setBounds(179, 155, 72, 29);
			ekleButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    ekBilesenGirisiDialog.setBilesen(new StandartYalitimBileseni());
					SwingUtils.centerAndShowComponent(ekBilesenGirisiDialog);
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
	private javax.swing.JButton getDuzeltButton() {
		if(duzeltButton == null) {
			duzeltButton = new javax.swing.JButton();
			duzeltButton.setText("Düzelt");
			duzeltButton.setBounds(267, 155, 72, 29);
			duzeltButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    ekBilesenGirisiDialog.setBilesen((StandartYalitimBileseni)((ArrayList)((IsiYalitimiTableModel)ekBilesenlerTable.getModel()).getIsiYalitimBilesenleri()).get(ekBilesenlerTable.getSelectedRow()));
					SwingUtils.centerAndShowComponent(ekBilesenGirisiDialog);
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
	private javax.swing.JButton getSilButton() {
		if(silButton == null) {
			silButton = new javax.swing.JButton();
			silButton.setText("Sil");
			silButton.setBounds(357, 155, 72, 29);
			silButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    ((IsiYalitimiTableModel)ekBilesenlerTable.getModel()).deleteBilesen(ekBilesenlerTable.getSelectedRow());
				}
			});
		}
		return silButton;
	}

	public void setStandartBilesenlerTableModel(DefaultTableModel model){
	    getStandartBilesenlerTable().setModel(model);
	    standartBilesenlerTable.getColumnModel().getColumn(0).setPreferredWidth(150);
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
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel.add(getJLabel(), null);
			jPanel.add(getDuzeltButton(), null);
			jPanel.add(getSilButton(), null);
			jPanel.add(jLabel4, null);
			jPanel.add(jLabel5, null);
			jPanel.add(getJScrollPane1(), null);
			jPanel.add(getEkleButton(), null);
		}
		return jPanel;
	}

	public void addYalitimBileseniToTable(StandartYalitimBileseni bilesen) {
	    if(!((IsiYalitimiTableModel)ekBilesenlerTable.getModel()).getIsiYalitimBilesenleri().contains(bilesen)){
	        ((IsiYalitimiTableModel)ekBilesenlerTable.getModel()).addBilesen(bilesen);
	    }	    
	    ekBilesenlerTable.getColumnModel().getColumn(0).setPreferredWidth(150);
	}
 
	
    public Bina getBina() {
        return bina;
    }
    public void setBina(Bina bina) {
        this.bina = bina;
    }
    public void setIsiYalitimiBilesenleriTableModel(IsiYalitimiTableModel tableModel) {
        getEkBilesenlerTable().setModel(tableModel);
        ekBilesenlerTable.getColumnModel().getColumn(0).setPreferredWidth(150);
    }
}  //  @jve:visual-info  decl-index=0 visual-constraint="38,10"
