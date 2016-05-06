/*
 * Created on 07.Oca.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
/**
 * @author Burak
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YapiElemaniSecimiDialog extends JDialog {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 5139825023325295418L;

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton secButton = null;
	private JButton vazgecButton = null;
	private JScrollPane jScrollPane = null;
	private JTable yapiBilesenleriTable = null;
	/**
	 * This is the default constructor
	 */
	public YapiElemaniSecimiDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(427, 274);
		this.setContentPane(getJContentPane());
		this.setTitle("Çoðunlukla kullanýlan yapý bileþeni seçimi");
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new BoxLayout(jContentPane, BoxLayout.Y_AXIS));
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJPanel1(), null);
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
			jPanel.setLayout(new BorderLayout());
			jPanel.setPreferredSize(new java.awt.Dimension(300,300));
			jPanel.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
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
			jPanel1.setLayout(null);
			jPanel1.setPreferredSize(new java.awt.Dimension(60,90));
			jPanel1.add(getSecButton(), null);
			jPanel1.add(getVazgecButton(), null);
		}
		return jPanel1;
	}
	/**
	 * This method initializes secButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getSecButton() {
		if (secButton == null) {
			secButton = new JButton();
			secButton.setBounds(12, 8, 72, 30);
			secButton.setText("Seç");
		}
		return secButton;
	}
	/**
	 * This method initializes vazgecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getVazgecButton() {
		if (vazgecButton == null) {
			vazgecButton = new JButton();
			vazgecButton.setBounds(92, 9, 86, 30);
			vazgecButton.setText("Vazgeç");
		}
		return vazgecButton;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getYapiBilesenleriTable());
			jScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jScrollPane.setPreferredSize(new java.awt.Dimension(300,300));
		}
		return jScrollPane;
	}
	/**
	 * This method initializes yapiBilesenleriTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getYapiBilesenleriTable() {
		if (yapiBilesenleriTable == null) {
			yapiBilesenleriTable = new JTable();
			yapiBilesenleriTable.setPreferredSize(new java.awt.Dimension(300,300));
			yapiBilesenleriTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return yapiBilesenleriTable;
	}
	/**
	 * @param tableModel
	 */
	public void setYapiBilesenleriTable(TableModel tableModel) {
		getYapiBilesenleriTable().setModel(tableModel);
	}
    /**
     * @param secListener
     */
    public void addSecListener(ActionListener secListener) {
        getSecButton().addActionListener(secListener);
    }
    /**
     * @param vazgecListener
     */
    public void addVazgecListener(ActionListener vazgecListener) {
        getVazgecButton().addActionListener(vazgecListener);
    }
    /**
     * @return
     */
    public TableModel getYapiBileþenleriTableModel() {
        return getYapiBilesenleriTable().getModel();
    }
    /**
     * @return
     */
    public int getYapiBileþenleriTableSelectedIndex() {
        return getYapiBilesenleriTable().getSelectedRow();
    }
    /**
     * 
     */
    public void setSecActionCommand(String command) {
        getSecButton().setActionCommand(command);
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"

