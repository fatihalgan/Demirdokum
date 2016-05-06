package com.iztek.dd.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
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
/**
 * @author Burak AYDIN
 *
 */
public class RadyatorModeliSecimiDialog extends JDialog {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 4611914139496412798L;

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton secButton = null;
	private JButton vazgecButton = null;
	private JScrollPane jScrollPane = null;
	private JTable radyatorModelleriTable = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private JRadioButton hepsiRadioButton = null;
	private JRadioButton dokmeDilimliKolonRadioButton = null;
	private JRadioButton dokmeDilimliPerkolonRadioButton = null;
	private JRadioButton dokmeDilimliRidomRadioButton = null;
	private JRadioButton panelRadioButton = null;
	private JPanel jPanel4 = null;
	private JLabel radyatorIconLabel = null;
	/**
	 * This is the default constructor
	 */
	public RadyatorModeliSecimiDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setPreferredSize(new java.awt.Dimension(491,237));
		this.setMinimumSize(new java.awt.Dimension(491,237));
		this.setSize(600, 270);
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
			jContentPane.add(getJPanel2(), null);
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
			jPanel.setPreferredSize(new java.awt.Dimension(200,200));
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
			jPanel1.setPreferredSize(new java.awt.Dimension(30,40));
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
			secButton.setBounds(5, 5, 72, 30);
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
			vazgecButton.setBounds(85, 5, 86, 30);
			vazgecButton.setText("Vazgeç");
			vazgecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					setVisible(false);
				}
			});
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
			jScrollPane.setViewportView(getRadyatorModelleriTable());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes radyatorModelleriTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getRadyatorModelleriTable() {
		if (radyatorModelleriTable == null) {
			radyatorModelleriTable = new JTable();
			radyatorModelleriTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return radyatorModelleriTable;
	}
	/**
	 * @param tableModel
	 */
	public void setYapiBilesenleriTable(TableModel tableModel) {
		getRadyatorModelleriTable().setModel(tableModel);
	}
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.X_AXIS));
			jPanel2.setPreferredSize(new java.awt.Dimension(200,100));
			jPanel2.add(getJPanel(), null);
			jPanel2.add(getJPanel3(), null);
			jPanel2.add(getJPanel4(), null);
		}
		return jPanel2;
	}
	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Radyatör türü", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel3.setPreferredSize(new java.awt.Dimension(150,100));
			jPanel3.add(getHepsiRadioButton(), null);
			jPanel3.add(getDokmeDilimliKolonRadioButton(), null);
			jPanel3.add(getDokmeDilimliPerkolonRadioButton(), null);
			jPanel3.add(getDokmeDilimliRidomRadioButton(), null);
			jPanel3.add(getPanelRadioButton(), null);
		}
		return jPanel3;
	}
	/**
	 * This method initializes hepsiRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getHepsiRadioButton() {
		if (hepsiRadioButton == null) {
			hepsiRadioButton = new JRadioButton();
			hepsiRadioButton.setText("Hepsi");
			hepsiRadioButton.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
					if ( getHepsiRadioButton().isSelected() )
					    getRadyatorIconLabel().setIcon(new ImageIcon());
				}
			});
		}
		return hepsiRadioButton;
	}
	/**
	 * This method initializes dokmeDilimliKolonRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDokmeDilimliKolonRadioButton() {
		if (dokmeDilimliKolonRadioButton == null) {
			dokmeDilimliKolonRadioButton = new JRadioButton();
			dokmeDilimliKolonRadioButton.setText("Dökme dilim");
			dokmeDilimliKolonRadioButton.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
				    getRadyatorIconLabel().setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/radyator/dokme_dilimli_kolonlu.jpg")));
				}
			});
		}
		return dokmeDilimliKolonRadioButton;
	}
	/**
	 * This method initializes dokmeDilimliPerkolonRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDokmeDilimliPerkolonRadioButton() {
		if (dokmeDilimliPerkolonRadioButton == null) {
			dokmeDilimliPerkolonRadioButton = new JRadioButton();
			dokmeDilimliPerkolonRadioButton.setText("Dökme dilim perkolon");
			dokmeDilimliPerkolonRadioButton.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
				    getRadyatorIconLabel().setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/radyator/dokme_dilimli_perkolon.jpg")));
				}
			});
		}
		return dokmeDilimliPerkolonRadioButton;
	}
	/**
	 * This method initializes dokmeDilimliRidomRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDokmeDilimliRidomRadioButton() {
		if (dokmeDilimliRidomRadioButton == null) {
			dokmeDilimliRidomRadioButton = new JRadioButton();
			dokmeDilimliRidomRadioButton.setText("Dökme dilim ridem");
			dokmeDilimliRidomRadioButton.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
				    getRadyatorIconLabel().setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/radyator/dokme_dilimli_ridem.jpg")));
				}
			});
		}
		return dokmeDilimliRidomRadioButton;
	}
	/**
	 * This method initializes panelRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getPanelRadioButton() {
		if (panelRadioButton == null) {
			panelRadioButton = new JRadioButton();
			panelRadioButton.setText("Panel");
			panelRadioButton.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
				    getRadyatorIconLabel().setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/radyator/panel_radyator.jpg")));
				}
			});
		}
		return panelRadioButton;
	}
    /**
     * @param secListener
     */
    public void addSecButtonListener(ActionListener secListener) {
        getSecButton().addActionListener(secListener);
    }
    /**
     * @param model
     */
    public void setRadyatorModelleriTableModel(TableModel model) {
        getRadyatorModelleriTable().setModel(model);
    }
    /**
     * @param radyatorTipListener
     */
    public void addRadyatorTipListener(ItemListener radyatorTipListener) {
        ButtonGroup group = new ButtonGroup();
        group.add(getHepsiRadioButton());
        group.add(getDokmeDilimliKolonRadioButton());
        group.add(getDokmeDilimliPerkolonRadioButton());
        group.add(getDokmeDilimliRidomRadioButton());
        group.add(getPanelRadioButton());
        
        getHepsiRadioButton().addItemListener(radyatorTipListener);
        getDokmeDilimliKolonRadioButton().addItemListener(radyatorTipListener);
        getDokmeDilimliPerkolonRadioButton().addItemListener(radyatorTipListener);
        getDokmeDilimliRidomRadioButton().addItemListener(radyatorTipListener);
        getPanelRadioButton().addItemListener(radyatorTipListener);
        
        group.setSelected(getHepsiRadioButton().getModel(), true);
    }
    /**
     * @return
     */
    public int getRadyatorModelleriTableSelectedIndex() {
        return getRadyatorModelleriTable().getSelectedRow();
    }
    /**
     * @return
     */
    public TableModel getRadyatorModelleriTableModel() {
        return getRadyatorModelleriTable().getModel();
    }
	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setLayout(new BorderLayout());
			jPanel4.setPreferredSize(new java.awt.Dimension(100,100));
			jPanel4.add(getRadyatorIconLabel(), java.awt.BorderLayout.CENTER);
		}
		return jPanel4;
	}
	
	private JLabel getRadyatorIconLabel(){
	    if (radyatorIconLabel == null){
	        radyatorIconLabel = new JLabel();
	        radyatorIconLabel.setText("");
	        radyatorIconLabel.setPreferredSize(new java.awt.Dimension(95,95));
	    }
	    return radyatorIconLabel;
	}
 }  //  @jve:decl-index=0:visual-constraint="10,10"

