/*
 * Created on 11.Þub.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import com.iztek.dd.IsiKaybi.domain.Isitici;
import com.iztek.dd.IsiKaybi.domain.KazanlarTableModel;
/**
 * @author Selim HENDRICKSON
 *
 */
public class KazanSecDialog extends JDialog {
	private Isitici isitici = null;
	private KazanlarTableModel model = null;
	
	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JTable kazanlarTable = null;
	private JScrollPane jScrollPane = null;
	private JRadioButton firstOptionRadioButton = null;
	private JRadioButton secondOptionRadioButton = null;
	private JRadioButton thirdOptionRadioButton = null;
	private JButton tamamButton = null;
	private JButton vazgecButton = null;
	private JLabel imageLabel = null;
	
//	private Icon atmosferik = new ImageIcon(getClass().getResource("com/iztek/dd/GUI/images/isitici/atmosferik_brulorlu_kazan.jpg"));
	/**
	 * This is the default constructor
	 */
	public KazanSecDialog(TableModel model) {
		super();		
		this.model = (KazanlarTableModel)model;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Isýtýcý seçimi");
		this.setSize(532, 395);
		this.setContentPane(getJContentPane());
		this.addComponentListener(new java.awt.event.ComponentAdapter() { 
			public void componentShown(java.awt.event.ComponentEvent e) {    
				updateTableModel();
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
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getTamamButton(), null);
			jContentPane.add(getVazgecButton(), null);
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
			imageLabel = new JLabel();
			jPanel.setLayout(null);
			jPanel.setBounds(24, 24, 473, 276);
			imageLabel.setBounds(312, 18, 146, 174);
			imageLabel.setText("");
			jPanel.add(getJScrollPane(), null);
			ButtonGroup group = new ButtonGroup();
			group.add(getFirstOptionRadioButton());
			group.add(getSecondOptionRadioButton());
			group.add(getThirdOptionRadioButton());
			jPanel.add(getFirstOptionRadioButton(), null);
			jPanel.add(getSecondOptionRadioButton(), null);
			jPanel.add(getThirdOptionRadioButton(), null);
			jPanel.add(imageLabel, null);
		}
		return jPanel;
	}
	/**
	 * This method initializes kazanlarTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getKazanlarTable() {
		if (kazanlarTable == null) {		    
			kazanlarTable = new JTable(model);
			kazanlarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			kazanlarTable.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    int index = kazanlarTable.getSelectedRow();
                    String selectedKazanModeli = (String)((KazanlarTableModel)kazanlarTable.getModel()).getValueAt(index,0);
                    if(selectedKazanModeli.charAt(0)=='A')imageLabel.setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/kazan/atmosferik_brulorlu_kazan_resized.jpg")));
                    if(selectedKazanModeli.charAt(0)=='C')imageLabel.setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/kazan/celik_kazan_resized.jpg")));
                    if(selectedKazanModeli.charAt(0)=='M')imageLabel.setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/kazan/dokum_kazan_resized.jpg")));
                }
			});
		}
		return kazanlarTable;
	}
    /**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(11, 12, 285, 197);
			jScrollPane.setViewportView(getKazanlarTable());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes firstOptionRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getFirstOptionRadioButton() {
		if (firstOptionRadioButton == null) {
			firstOptionRadioButton = new JRadioButton();
			firstOptionRadioButton.setBounds(34, 231, 112, 21);
			firstOptionRadioButton.setText("Doðalgaz, LPG");
			firstOptionRadioButton.setSelected(true);
			firstOptionRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    updateTableModel();			    
				}
			});
		}
		return firstOptionRadioButton;
	}
	/**
	 * This method initializes secondOptionRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getSecondOptionRadioButton() {
		if (secondOptionRadioButton == null) {
			secondOptionRadioButton = new JRadioButton();
			secondOptionRadioButton.setBounds(194, 231, 112, 21);
			secondOptionRadioButton.setText("Motorin");
			secondOptionRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    updateTableModel();				
				}
			});
		}
		return secondOptionRadioButton;
	}
	/**
	 * This method initializes thirdOptionRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getThirdOptionRadioButton() {
		if (thirdOptionRadioButton == null) {
			thirdOptionRadioButton = new JRadioButton();
			thirdOptionRadioButton.setBounds(326, 231, 112, 21);
			thirdOptionRadioButton.setText("Fuel-oil");
			thirdOptionRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    updateTableModel();
				}
			});
		}
		return thirdOptionRadioButton;
	}
	/**
	 * This method initializes tamamButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTamamButton() {
		if (tamamButton == null) {
			tamamButton = new JButton();
			tamamButton.setBounds(145, 317, 100, 31);
			tamamButton.setText("Tamam");
			tamamButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isitici.setSecilenIsitici(model.getIsitici(kazanlarTable.getSelectedRow()));
				}
			});
		}
		return tamamButton;
	}
	/**
	 * This method initializes vazgecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getVazgecButton() {
		if (vazgecButton == null) {
			vazgecButton = new JButton();
			vazgecButton.setBounds(277, 317, 100, 31);
			vazgecButton.setText("Vazgeç");
			vazgecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					dispose();
				}
			});
		}
		return vazgecButton;
	}

	public void setKazanlarTableModel(TableModel model){
		getKazanlarTable().setModel(model);
	}
	
	private void updateTableModel() {
        model.setKazanGucu(isitici.hesaplaKazanKapasiteIhtiyaci());
	    if(getFirstOptionRadioButton().isSelected()){
	        model.setYakitTipi("1.0");
	        model.fireTableStructureChanged();
	    }
	    if(getSecondOptionRadioButton().isSelected()){
	        model.setYakitTipi("3.0");
	        model.fireTableStructureChanged();
	    }
	    if(getThirdOptionRadioButton().isSelected()){
	        model.setYakitTipi("2.0");
	        model.fireTableStructureChanged();
	    }        
    }
    public void setIsitici(Isitici kazan2) {
        this.isitici = kazan2;
    }
    public void addTamamButtonListener(ActionListener listener) {
        getTamamButton().addActionListener(listener);
    }
    public String getSelectedKazanModel() {
        return (String)getKazanlarTable().getModel().getValueAt(getKazanlarTable().getSelectedRow(),0);
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
