/*
 * Created on 24.Þub.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.iztek.dd.IsiKazanci.domain.Klima;
import com.iztek.dd.IsiKazanci.domain.KlimaCatalog;
/**
 * @author Selim HENDRICKSON
 *
 */
public class KlimaSecimiDialog extends JDialog {
    private double isiKazanciYuku = 0;
    
	private javax.swing.JPanel jContentPane = null;

	private JTable klimalarTable = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JPanel jPanel1 = null;
	ButtonGroup group = new ButtonGroup();
	
	private JRadioButton ddyRadioButton = null;
	private JRadioButton pacificRadioButton = null;
	private JPanel jPanel2 = null;
	private JRadioButton salonTipiRadioButton = null;
	private JRadioButton yerTavanRadioButton = null;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public KlimaSecimiDialog() {
		super();
		initialize();		
		group.add(getDdyRadioButton());
		group.add(getPacificRadioButton());
		group.add(getSalonTipiRadioButton());
		group.add(getYerTavanRadioButton());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Klima Modeli Seçimi");
		this.setSize(612, 486);
		this.setContentPane(getJContentPane());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jLabel = new JLabel();
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			jLabel.setText("");
			jLabel.setLocation(312, 12);
			jLabel.setSize(230, 197);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes klimalarTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getKlimalarTable() {
		if (klimalarTable == null) {
			klimalarTable = new JTable();
			klimalarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			klimalarTable.setModel(getTableModel());
			ListSelectionListener listener = new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent e) {
                    int index = klimalarTable.getSelectedRow();
                    if(index!=-1){
                        String selectedKlimaModeli = (String)((Vector)((DefaultTableModel)klimalarTable.getModel()).getDataVector().elementAt(index)).elementAt(0);
                        String resimPath = KlimaCatalog.getInstance().getKlima(selectedKlimaModeli).getResimPath();
                        jLabel.setIcon(new ImageIcon(getClass().getResource(resimPath)));                                           
                    }
                    else jLabel.setIcon(null);
                }
			};
			klimalarTable.getSelectionModel().addListSelectionListener(listener);
			klimalarTable.getColumnModel().getSelectionModel().addListSelectionListener(listener);
		}
		return klimalarTable;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getKlimalarTable());
			jScrollPane.setLocation(11, 12);
			jScrollPane.setSize(285, 197);
		}
		return jScrollPane;
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
			jPanel.setLayout(null);
			jPanel.setLocation(24, 24);
			jPanel.setSize(556, 369);
			jLabel.setText("");
			jLabel.setSize(285, 197);
			jLabel.setLocation(315, 12);
			jPanel.add(getJScrollPane(), null);
			jPanel.add(getJPanel1(), null);
			jPanel.add(getJPanel2(), null);
			jPanel.add(jLabel, null);
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
			jButton.setLocation(153, 405);
			jButton.setSize(100, 31);
			jButton.setText("Tamam");
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
			jButton1.setLocation(286, 405);
			jButton1.setSize(100, 31);
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
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(22, 223, 432, 60);
			jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duvar tipi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel1.add(getDdyRadioButton(), null);
			jPanel1.add(getPacificRadioButton(), null);
		}
		return jPanel1;
	}
	/**
	 * This method initializes ddyRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDdyRadioButton() {
		if (ddyRadioButton == null) {
			ddyRadioButton = new JRadioButton();
			ddyRadioButton.setBounds(62, 23, 116, 21);
			ddyRadioButton.setText("DDY Ultra serisi");
			ddyRadioButton.setSelected(true);
			ddyRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					updateTableModel();
					klimalarTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return ddyRadioButton;
	}
	/**
	 * This method initializes pacificRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getPacificRadioButton() {
		if (pacificRadioButton == null) {
			pacificRadioButton = new JRadioButton();
			pacificRadioButton.setBounds(240, 23, 129, 21);
			pacificRadioButton.setText("Pacific Line serisi");
			pacificRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    updateTableModel();
				    klimalarTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return pacificRadioButton;
	}
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBounds(22, 296, 432, 60);
			jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Split klimalar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel2.add(getSalonTipiRadioButton(), null);
			jPanel2.add(getYerTavanRadioButton(), null);
		}
		return jPanel2;
	}
	/**
	 * This method initializes salonTipiRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getSalonTipiRadioButton() {
		if (salonTipiRadioButton == null) {
			salonTipiRadioButton = new JRadioButton();
			salonTipiRadioButton.setSize(132, 21);
			salonTipiRadioButton.setLocation(62, 23);
			salonTipiRadioButton.setText("Salon tipi");
			salonTipiRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    updateTableModel();
				    klimalarTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return salonTipiRadioButton;
	}
	/**
	 * This method initializes yerTavanRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getYerTavanRadioButton() {
		if (yerTavanRadioButton == null) {
			yerTavanRadioButton = new JRadioButton();
			yerTavanRadioButton.setSize(132, 21);
			yerTavanRadioButton.setLocation(240, 23);
			yerTavanRadioButton.setText("Yer/Tavan tipi");
			yerTavanRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    updateTableModel();
				    klimalarTable.getSelectionModel().setSelectionInterval(0,0);
				}
			});
		}
		return yerTavanRadioButton;
	}
	
	private TableModel getTableModel() {
	    String[] headers = {"Model","Güç (kW)"};
	    DefaultTableModel model = new DefaultTableModel(headers,0);
	    if(getDdyRadioButton().isSelected()){
	        ArrayList data = (ArrayList)KlimaCatalog.getInstance().getKlimalar(isiKazanciYuku,1);
	        Iterator it = data.iterator();
	        while(it.hasNext()){
	            Klima klima = (Klima) it.next();
	            model.addRow(klima.getTableRow());
	        }
	    }
	    if(getPacificRadioButton().isSelected()){
	        ArrayList data = (ArrayList)KlimaCatalog.getInstance().getKlimalar(isiKazanciYuku,2);
	        Iterator it = data.iterator();
	        while(it.hasNext()){
	            Klima klima = (Klima) it.next();
	            model.addRow(klima.getTableRow());
	        }
	    }
	    if(getSalonTipiRadioButton().isSelected()){
	        ArrayList data = (ArrayList)KlimaCatalog.getInstance().getKlimalar(isiKazanciYuku,3);
	        Iterator it = data.iterator();
	        while(it.hasNext()){
	            Klima klima = (Klima) it.next();
	            model.addRow(klima.getTableRow());
	        }
	    }
	    if(getYerTavanRadioButton().isSelected()){
	        ArrayList data = (ArrayList)KlimaCatalog.getInstance().getKlimalar(isiKazanciYuku,4);
	        Iterator it = data.iterator();
	        while(it.hasNext()){
	            Klima klima = (Klima) it.next();
	            model.addRow(klima.getTableRow());
	        }
	    }
        return model;
    }

	public void updateTableModel(){
	    getKlimalarTable().setModel(getTableModel());
	}
	
	public void setIsiKazanci(double isiYuku){
	    this.isiKazanciYuku = isiYuku;
	}
    public int getKlimalarTableSelectedRow() {
        return getKlimalarTable().getSelectedRow();
    }
    public DefaultTableModel getKlimalarTableModel() {
        return (DefaultTableModel)getKlimalarTable().getModel();
    }
    public void addKlimaSecimiDialogTamamButtonActionListener(ActionListener listener) {
        getJButton().addActionListener(listener);
    }
   }  //  @jve:decl-index=0:visual-constraint="10,10"
