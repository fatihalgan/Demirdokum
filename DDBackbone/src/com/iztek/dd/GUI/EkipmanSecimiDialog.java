/*
 * Created on 03.Mar.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.iztek.dd.IsiKazanci.domain.Ekipman;
import com.iztek.dd.IsiKazanci.domain.EkipmanCatalog;
/**
 * @author Selim HENDRICKSON
 *
 */
public class EkipmanSecimiDialog extends JDialog {

	private javax.swing.JPanel jContentPane = null;

	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;
	private JList cihazlarList = null;
	private JList secilenlerList = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JTextField toplamGucTextField = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JButton tamamButton = null;
	private JButton jButton3 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	/**
	 * This is the default constructor
	 */
	public EkipmanSecimiDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Lütfen mahal içindeki cihazlarý seçiniz");
		this.setSize(555, 347);
		this.setContentPane(getJContentPane());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jLabel3 = new JLabel();
			jLabel2 = new JLabel();
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			jLabel.setBounds(106, 218, 127, 25);
			jLabel.setText("Toplam anma gücü (P)");
			jLabel1.setBounds(370, 218, 34, 25);
			jLabel1.setText("Watt");
			jLabel2.setBounds(22, 8, 203, 25);
			jLabel2.setText("Cihazlar");
			jLabel3.setBounds(319, 8, 203, 25);
			jLabel3.setText("Seçilenler");
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJScrollPane1(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getToplamGucTextField(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getTamamButton(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(22, 36, 203, 143);
			jScrollPane.setViewportView(getCihazlarList());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(319, 36, 203, 143);
			jScrollPane1.setViewportView(getSecilenlerList());
		}
		return jScrollPane1;
	}
	/**
	 * This method initializes cihazlarList	
	 * 	
	 * @return javax.swing.JList	
	 */    
	private JList getCihazlarList() {
		if (cihazlarList == null) {
		    DefaultListModel model = new DefaultListModel();
		    ArrayList ekipmanlar = ((ArrayList)EkipmanCatalog.getInstance().getEkipmanlar());
		    Iterator it = ekipmanlar.iterator();
		    while(it.hasNext()){
		        model.addElement(it.next());
		    }
			cihazlarList = new JList(model);
		}
		return cihazlarList;
	}
	/**
	 * This method initializes secilenlerList	
	 * 	
	 * @return javax.swing.JList	
	 */    
	private JList getSecilenlerList() {
		if (secilenlerList == null) {
			secilenlerList = new JList(new DefaultListModel());
		}
		return secilenlerList;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(247, 56, 50, 26);
			jButton.setText(">>");
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((DefaultListModel)secilenlerList.getModel()).addElement(cihazlarList.getSelectedValue());
					((DefaultListModel)cihazlarList.getModel()).remove(cihazlarList.getSelectedIndex());
					toplamGucTextField.setText(""+hesaplaToplamGuc());
				}
			});
		}
		return jButton;
	}
	protected double hesaplaToplamGuc() {
	    double toplamGuc = 0;
        int size = ((DefaultListModel)secilenlerList.getModel()).getSize();
        for(int index=0; index<size; index++){
            toplamGuc += ((Ekipman)((DefaultListModel)secilenlerList.getModel()).getElementAt(index)).getAnmaGucu();            
        }
        return toplamGuc;
    }
    /**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(248, 95, 50, 26);
			jButton1.setText("<<");
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((DefaultListModel)cihazlarList.getModel()).addElement(secilenlerList.getSelectedValue());
					((DefaultListModel)secilenlerList.getModel()).remove(secilenlerList.getSelectedIndex());
					toplamGucTextField.setText(""+hesaplaToplamGuc());
				}
			});
		}
		return jButton1;
	}
	/**
	 * This method initializes toplamGucTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getToplamGucTextField() {
		if (toplamGucTextField == null) {
			toplamGucTextField = new JTextField();
			toplamGucTextField.setBounds(250, 218, 112, 25);
			toplamGucTextField.setEditable(false);
		}
		return toplamGucTextField;
	}
	/**
	 * This method initializes tamamButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTamamButton() {
		if (tamamButton == null) {
			tamamButton = new JButton();
			tamamButton.setBounds(175, 272, 82, 26);
			tamamButton.setText("Tamam");
		}
		return tamamButton;
	}
	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(287, 272, 82, 26);
			jButton3.setText("Vazgeç");
			jButton3.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    dispose();
				}
			});
		}
		return jButton3;
	}
    public String getToplamGucTextFieldText() {
        return getToplamGucTextField().getText();
    }
    public void addTamamButtonActionListener(ActionListener listener) {
        getTamamButton().addActionListener(listener);
    }
         }  //  @jve:decl-index=0:visual-constraint="10,10"
