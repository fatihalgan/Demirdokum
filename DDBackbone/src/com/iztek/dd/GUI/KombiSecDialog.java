/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

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

import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKaybi.domain.Isitici;
import com.iztek.dd.IsiKaybi.domain.IsiticiModeliInt;
import com.iztek.dd.IsiKaybi.domain.KombilerTableModel;
/**
 * @author Selim HENDRICKSON
 *
 */
public class KombiSecDialog extends JDialog {
    private Isitici isitici = null;
    private KombilerTableModel model = null;
    private KazanSecimiPanel originatingPanel = null;
    
	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel4 = null;
	private JPanel jPanel5 = null;
	private JTable kombilerTable = null;
	private JScrollPane jScrollPane = null;
	private JRadioButton hermetikRadioButton = null;
	private JRadioButton bacaliRadioButton = null;
	private JButton tamamButton = null;
	private JButton vazgecButton = null;
	private JLabel imageLabel = null;
	private JPanel jPanel6 = null;
	private JPanel jPanel7 = null;
	private JPanel jPanel8 = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JRadioButton jRadioButton3 = null;
	private JRadioButton jRadioButton4 = null;
	private JRadioButton jRadioButton5 = null;
	/**
	 * This is the default constructor
	 * @param model
	 */
	public KombiSecDialog(TableModel model) {
		super();
		this.model = (KombilerTableModel) model;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Kombi modelleri");
		this.setSize(497, 419);
		this.setContentPane(getJContentPane());
		this.addComponentListener(new java.awt.event.ComponentAdapter() { 
			public void componentShown(java.awt.event.ComponentEvent e) {
			    model.setIsiticiGucu(isitici.hesaplaKazanKapasiteIhtiyaci());
				model.fireTableStructureChanged();
				kombilerTable.getSelectionModel().setSelectionInterval(0,0);
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
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJPanel1(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}
    public void setKombilerTableModel(TableModel kombilerTableModel) {
        getKombilerTable().setModel(kombilerTableModel);
    }
    public void setIsitici(Isitici isitici) {
        this.isitici = isitici;
    }
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			imageLabel = new JLabel();
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			imageLabel.setText("");
			jPanel.setPreferredSize(new java.awt.Dimension(150,26));
			jPanel.add(imageLabel, java.awt.BorderLayout.CENTER);
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
			jPanel1.setLayout(new BorderLayout());
			jPanel1.add(getJPanel2(), java.awt.BorderLayout.SOUTH);
			jPanel1.add(getJPanel3(), java.awt.BorderLayout.CENTER);
			jPanel1.add(getJPanel(), java.awt.BorderLayout.EAST);
		}
		return jPanel1;
	}
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.add(getTamamButton(), null);
			jPanel2.add(getVazgecButton(), null);
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
			jPanel3.setLayout(new BorderLayout());
			jPanel3.add(getJPanel5(), java.awt.BorderLayout.CENTER);
			jPanel3.add(getJPanel6(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel3;
	}
	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setPreferredSize(new java.awt.Dimension(200,34));
			ButtonGroup group = new ButtonGroup();
			group.add(getHermetikRadioButton());
			group.add(getBacaliRadioButton());
			jPanel4.add(getHermetikRadioButton(), null);
			jPanel4.add(getBacaliRadioButton(), null);
		}
		return jPanel4;
	}
	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setLayout(new BorderLayout());
			jPanel5.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
		}
		return jPanel5;
	}
	/**
	 * This method initializes kombilerTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getKombilerTable() {
		if (kombilerTable == null) {
			kombilerTable = new JTable(model);
			kombilerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			kombilerTable.addMouseListener(new java.awt.event.MouseAdapter() { 
				public void mouseClicked(java.awt.event.MouseEvent e) {    
					int rowIndex = kombilerTable.getSelectedRow();
					IsiticiModeliInt isitici = model.getIsitici(rowIndex);
					imageLabel.setIcon(new ImageIcon(getClass().getResource(isitici.getImageFile())));
				}
			});
		}
		return kombilerTable;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getKombilerTable());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes hermetikRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getHermetikRadioButton() {
		if (hermetikRadioButton == null) {
			hermetikRadioButton = new JRadioButton();
			hermetikRadioButton.setText("Hermetik");
			hermetikRadioButton.setSelected(true);
			hermetikRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    model.setIsiticiGucu(isitici.hesaplaKazanKapasiteIhtiyaci());
					model.setHermetik(true);
					model.fireTableStructureChanged();
					kombilerTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return hermetikRadioButton;
	}
	/**
	 * This method initializes bacaliRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getBacaliRadioButton() {
		if (bacaliRadioButton == null) {
			bacaliRadioButton = new JRadioButton();
			bacaliRadioButton.setText("Bacalý");
			bacaliRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    model.setIsiticiGucu(isitici.hesaplaKazanKapasiteIhtiyaci());
					model.setHermetik(false);
					model.fireTableStructureChanged();
					kombilerTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return bacaliRadioButton;
	}
	/**
	 * This method initializes tamamButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTamamButton() {
		if (tamamButton == null) {
			tamamButton = new JButton();
			tamamButton.setText("Tamam");
			tamamButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    originatingPanel.setKazanModeliTextFieldText(getSelectedKombiModel());
				    isitici.setSecilenIsitici(model.getIsitici(kombilerTable.getSelectedRow()));
				    dispose();
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
			vazgecButton.setText("Vazgeç");
			vazgecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					dispose();
				}
			});
		}
		return vazgecButton;
	}
    public void addTamamButtonListener(ActionListener listener) {
        getTamamButton().addActionListener(listener);
    }
    public String getSelectedKombiModel() {
        int index = kombilerTable.getSelectedRow();
        IsiticiModeliInt isiticiModeli = model.getIsitici(index);
        return isiticiModeli.getModelAdi()+" "+isiticiModeli.getTip();
    }
    public KombilerTableModel getModel() {
        return model;
    }
    public void setKazanlarPanel(JPanel kazanSecimiPanel) {
        originatingPanel = (KazanSecimiPanel)kazanSecimiPanel;
    }
	/**
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setLayout(new BorderLayout());
			jPanel6.add(getJPanel4(), java.awt.BorderLayout.CENTER);
			jPanel6.add(getJPanel7(), java.awt.BorderLayout.NORTH);
			jPanel6.add(getJPanel8(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel6;
	}
	/**
	 * This method initializes jPanel7	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel7() {
		if (jPanel7 == null) {
			jPanel7 = new JPanel();
			ButtonGroup group = new ButtonGroup();
			group.add(getJRadioButton());
			group.add(getJRadioButton1());
			jPanel7.add(getJRadioButton(), null);
			jPanel7.add(getJRadioButton1(), null);
		}
		return jPanel7;
	}
	/**
	 * This method initializes jPanel8	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel8() {
		if (jPanel8 == null) {
			jPanel8 = new JPanel();
			jPanel8.add(getJRadioButton4(), null);
			jPanel8.add(getJRadioButton3(), null);
			jPanel8.add(getJRadioButton2(), null);
			jPanel8.add(getJRadioButton5(), null);
			jPanel8.setVisible(false);
			ButtonGroup group = new ButtonGroup();
			group.add(getJRadioButton2());
			group.add(getJRadioButton3());
			group.add(getJRadioButton4());
			group.add(getJRadioButton5());
		}
		return jPanel8;
	}
	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setText("Kombi");
			jRadioButton.setSelected(true);
			jRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    model.setIsiticiTipi("Kombi");
					getJPanel4().setVisible(true);
					getJPanel8().setVisible(false);
					model.fireTableStructureChanged();
					kombilerTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return jRadioButton;
	}
	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("Kat Kaloriferi");
			jRadioButton1.setSelected(false);
			jRadioButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    model.setIsiticiTipi("Kat");
				    getJPanel4().setVisible(false);
					getJPanel8().setVisible(true);
					model.fireTableStructureChanged();
					kombilerTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return jRadioButton1;
	}
	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setText("Katý");
			jRadioButton2.setSelected(false);
			jRadioButton2.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    model.setIsiticiGucu(isitici.hesaplaKazanKapasiteIhtiyaci());
					model.setYakitTipi(3.0);
					model.fireTableStructureChanged();
					kombilerTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return jRadioButton2;
	}
	/**
	 * This method initializes jRadioButton3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton3() {
		if (jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton();
			jRadioButton3.setText("Sývý");
			jRadioButton3.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    model.setIsiticiGucu(isitici.hesaplaKazanKapasiteIhtiyaci());
					model.setYakitTipi(2.0);
					model.fireTableStructureChanged();
					kombilerTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return jRadioButton3;
	}
	/**
	 * This method initializes jRadioButton4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton4() {
		if (jRadioButton4 == null) {
			jRadioButton4 = new JRadioButton();
			jRadioButton4.setText("Gaz");
			jRadioButton4.setSelected(true);
			jRadioButton4.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    model.setIsiticiGucu(isitici.hesaplaKazanKapasiteIhtiyaci());
					model.setYakitTipi(1.0);
					model.fireTableStructureChanged();
					kombilerTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return jRadioButton4;
	}
	/**
	 * This method initializes jRadioButton5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton5() {
		if (jRadioButton5 == null) {
			jRadioButton5 = new JRadioButton();
			jRadioButton5.setText("Kaskat");
			jRadioButton5.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    showKaskatDialog();				    
				}
			});
		}
		return jRadioButton5;
	}
    protected void showKaskatDialog() {
        SwingUtils.centerAndShowComponent(new KaskatSecimDialog(isitici,this,originatingPanel));
    }
                     }  //  @jve:decl-index=0:visual-constraint="10,10"
