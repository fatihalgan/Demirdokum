/*
 * Created on Mar 14, 2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKaybi.domain.Isitici;
import com.iztek.dd.IsiKaybi.domain.IsiticiCatalog;
import com.iztek.dd.IsiKaybi.domain.KaskatModeli;
/**
 * @author Selim HENDRICKSON
 *
 */
public class KaskatSecimDialog extends JDialog {
    private Isitici isitici = null;
    private KombiSecDialog parent = null;
    private KazanSecimiPanel kazanSecimiPanel = null;
    
	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton tamamButton = null;
	private JButton vazgecButton = null;
	private JPanel jPanel2 = null;  //  @jve:decl-index=0:visual-constraint="477,35"
	private JPanel jPanel3 = null;
	private JLabel jLabel = null;
	private JRadioButton hermetikRadioButton = null;
	private JRadioButton bacaliRadioButton = null;
	private JLabel jLabel1 = null;
	private JRadioButton boylerliRadioButton = null;
	private JRadioButton boylersizRadioButton = null;
	private JTextArea detayTextPane = null;
	/**
	 * This is the default constructor
	 * @param model
	 * @param isitici
	 * @param dialog
	 * @param originatingPanel
	 */
	public KaskatSecimDialog(Isitici isitici, KombiSecDialog dialog, KazanSecimiPanel originatingPanel) {
		super();
		this.isitici = isitici;
		initialize();
		this.parent = dialog;
		this.kazanSecimiPanel = originatingPanel; 
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Kaskat Sistem");
		this.setSize(559, 337);
		this.setContentPane(getJContentPane());
		updataKaskatTable();
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
			jPanel.add(getTamamButton(), null);
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
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BorderLayout());
			jPanel1.add(getJPanel2(), java.awt.BorderLayout.NORTH);
			jPanel1.add(getJPanel3(), java.awt.BorderLayout.CENTER);
		}
		return jPanel1;
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
					kazanSecimiPanel.setKazanModeliTextFieldText("Kaskat Sistem");
					parent.dispose();
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
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kaskat Sistem Detaylarý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
			jPanel2.setSize(332, 82);
			jPanel2.setPreferredSize(new java.awt.Dimension(168,80));
			jLabel.setText("Hermetik/Bacalý");
			jLabel.setPreferredSize(new java.awt.Dimension(15,16));
			jLabel.setBounds(3, 21, 106, 21);
			jLabel1.setBounds(3, 52, 106, 21);
			jLabel1.setText("Boyler");
			jPanel2.add(jLabel, null);
			ButtonGroup group1 = new ButtonGroup();
			ButtonGroup group2 = new ButtonGroup();
			group1.add(getHermetikRadioButton());
			group1.add(getBacaliRadioButton());
			jPanel2.add(getHermetikRadioButton(), null);
			jPanel2.add(getBacaliRadioButton(), null);
			jPanel2.add(jLabel1, null);
			group2.add(getBoylerliRadioButton());
			group2.add(getBoylersizRadioButton());
			jPanel2.add(getBoylerliRadioButton(), null);
			jPanel2.add(getBoylersizRadioButton(), null);
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
			jPanel3.add(getDetayTextPane(), java.awt.BorderLayout.CENTER);
		}
		return jPanel3;
	}
	/**
	 * This method initializes hermetikRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getHermetikRadioButton() {
		if (hermetikRadioButton == null) {
			hermetikRadioButton = new JRadioButton();
			hermetikRadioButton.setPreferredSize(new java.awt.Dimension(15,21));
			hermetikRadioButton.setBounds(112, 21, 106, 21);
			hermetikRadioButton.setText("Hermetik");
			hermetikRadioButton.setSelected(true);
			hermetikRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					updataKaskatTable();
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
			bacaliRadioButton.setPreferredSize(new java.awt.Dimension(15,21));
			bacaliRadioButton.setBounds(221, 21, 106, 21);
			bacaliRadioButton.setText("Bacalý");
			bacaliRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    updataKaskatTable();
				}
			});
		}
		return bacaliRadioButton;
	}
	/**
	 * This method initializes boylerliRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getBoylerliRadioButton() {
		if (boylerliRadioButton == null) {
			boylerliRadioButton = new JRadioButton();
			boylerliRadioButton.setBounds(112, 52, 106, 21);
			boylerliRadioButton.setSelected(true);
			boylerliRadioButton.setText("Var");
			boylerliRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    updataKaskatTable();
				}
			});
		}
		return boylerliRadioButton;
	}
	/**
	 * This method initializes boylersizRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getBoylersizRadioButton() {
		if (boylersizRadioButton == null) {
			boylersizRadioButton = new JRadioButton();
			boylersizRadioButton.setBounds(221, 52, 106, 21);
			boylersizRadioButton.setText("Yok");
			boylersizRadioButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    updataKaskatTable();
				}
			});
		}
		return boylersizRadioButton;
	}
	protected void updataKaskatTable() {
	    KaskatModeli master = null;
	    KaskatModeli slaveBig = null;
	    KaskatModeli slaveSmall = null;
	    KaskatModeli slaveBoylerli = null;
	    boolean hermetik = hermetikRadioButton.isSelected();
	    boolean boylerli = boylerliRadioButton.isSelected();
	    double guc = isitici.hesaplaKazanKapasiteIhtiyaci();
	    int kaskatModelAdedi = 0;
	    while(guc>0){
	        guc-=30.24;
	        kaskatModelAdedi++; //Toplam cihaz sayýsý
	    }	    	    
	    
	    if(kaskatModelAdedi==1){
	        SwingUtils.errorMessage("Kaskat sistem bu güç ihtiyacý için uygun deðildir.");
	        return;
	    }else{
	        master = IsiticiCatalog.getInstance().getKaskatModeli(30.24,hermetik,false);
	        slaveBig = IsiticiCatalog.getInstance().getKaskatModeli(30.24,hermetik,false);
	        slaveSmall = IsiticiCatalog.getInstance().getKaskatModeli(23.26,hermetik,false);
	        slaveBoylerli = IsiticiCatalog.getInstance().getKaskatModeli(30.24,hermetik,true);	        
	    }
	    detayTextPane.setText("Konum\tAdet\tModel\t\tGüç\tBoylerli");
	    detayTextPane.append("\nMaster\t1\t"+master.getTip()+"\t"+master.getGuc()+"\tHayýr");
	    kaskatModelAdedi--;
	    if(boylerli!=true){
	        if(kaskatModelAdedi>1)detayTextPane.append("\nSlave\t"+(kaskatModelAdedi-1)+"\t"+slaveBig.getTip()+"\t"+slaveBig.getGuc()+"\tHayýr");
	        detayTextPane.append("\nSlave\t1\t"+slaveSmall.getTip()+"\t"+slaveSmall.getGuc()+"\tHayýr");
	    }else{
	        if(kaskatModelAdedi>1){
	            detayTextPane.append("\nSlave\t"+1+"\t"+slaveBoylerli.getTip()+"\t"+slaveBoylerli.getGuc()+"\tEvet");
	            kaskatModelAdedi--;
	            if(kaskatModelAdedi>1){
		            detayTextPane.append("\nSlave\t"+(kaskatModelAdedi-1)+"\t"+slaveBig.getTip()+"\t"+slaveBig.getGuc()+"\tHayýr");	                
	            }
	            detayTextPane.append("\nSlave\t1\t"+slaveSmall.getTip()+"\t"+slaveSmall.getGuc()+"\tHayýr");
	        }else{
	            detayTextPane.append("\nSlave\t1\t"+slaveBoylerli.getTip()+"\t"+slaveBoylerli.getGuc()+"\tEvet");
	        }
	    }
    }
	/**
	 * This method initializes detayTextPane	
	 * 	
	 * @return javax.swing.JTextArea	
	 */    
	private JTextArea getDetayTextPane() {
		if (detayTextPane == null) {
			detayTextPane = new JTextArea();
			detayTextPane.setEditable(false);
		}
		return detayTextPane;
	}
 }  //  @jve:decl-index=0:visual-constraint="10,10"
