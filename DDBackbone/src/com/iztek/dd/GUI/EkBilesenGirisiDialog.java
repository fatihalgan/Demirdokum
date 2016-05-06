/*
 * Created on 10.Þub.2005
 *
 */
package com.iztek.dd.GUI;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.iztek.dd.GUI.wrappers.YapiElemaniSecimTableModel;
import com.iztek.dd.IsiKaybi.domain.BolgeyeGoreStandartBilesenDirencleri;
import com.iztek.dd.IsiKaybi.domain.CogunluklaKullanilanYapiElemanlari;
import com.iztek.dd.IsiKaybi.domain.StandartBilesenDirenci;
import com.iztek.dd.IsiKaybi.domain.StandartYalitimBileseni;
import com.iztek.dd.IsiKaybi.domain.YapiElemani;
import com.iztek.dd.utilities.BolgeBroker;
/**
 * @author Selim HENDRICKSON
 *
 */
public class EkBilesenGirisiDialog extends JDialog {
	YapiElemaniSecimTableModel tableModel = new YapiElemaniSecimTableModel();
	IsiYalitimiPanel originatingPanel = null;
	private int bolgeKodu = 1;
	StandartYalitimBileseni bilesen;
	
	private javax.swing.JPanel jContentPane = null;

	private JTable cokKullanilanBilesenlerTable = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JTextField adTextField = null;
	private JLabel jLabel1 = null;
	private JTextField uDegeriTextField = null;
	private JLabel jLabel2 = null;
	private JTextField lambdaTextField = null;
	private JLabel jLabel3 = null;
	private JComboBox yonetmelikDegeriComboBox = null;
	private JButton tamamButton = null;
	private JButton vazgecButton = null;
	/**
	 * This is the default constructor
	 */
	public EkBilesenGirisiDialog(IsiYalitimiPanel panel) {
		super();
		initialize();
		this.originatingPanel = panel;
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Ek bileþen giriþi");
		this.setSize(467, 450);
		this.setContentPane(getJContentPane());
		this.addComponentListener(new java.awt.event.ComponentAdapter() { 
			public void componentShown(java.awt.event.ComponentEvent e) {    
				adTextField.setText(bilesen.getAd());
				uDegeriTextField.setText(""+bilesen.getU());
				lambdaTextField.setText(""+bilesen.getLambda());
				int count = yonetmelikDegeriComboBox.getItemCount();
				for(int index = 0; index<count; index++){
				    StandartBilesenDirenci direnc = (StandartBilesenDirenci)yonetmelikDegeriComboBox.getItemAt(index);
				    if(direnc.direnc==bilesen.getYonetmelikLambda()){
				        yonetmelikDegeriComboBox.setSelectedIndex(index);
				        break;
				    } 
				}
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
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getTamamButton(), null);
			jContentPane.add(getVazgecButton(), null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes cokKullanilanBilesenlerTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getCokKullanilanBilesenlerTable() {
		if (cokKullanilanBilesenlerTable == null) {
			cokKullanilanBilesenlerTable = new JTable();
			Collection yapiElemanlari = CogunluklaKullanilanYapiElemanlari.getInstance().getYapiElemanlari();			
			String[] headers = {"Kod","Açýklama","U","1/\u039B","Tür"};
			tableModel.setColumnHeaders(headers);
			tableModel.setYapiElemanilar(yapiElemanlari);
			cokKullanilanBilesenlerTable.setModel(tableModel);
			cokKullanilanBilesenlerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			cokKullanilanBilesenlerTable.addMouseListener(new java.awt.event.MouseAdapter() { 
				public void mouseClicked(java.awt.event.MouseEvent e) {    
					int row = cokKullanilanBilesenlerTable.getSelectedRow();
					setBilesenBilgileri(row);
				}
			});
		}
		return cokKullanilanBilesenlerTable;
	}
	protected void setBilesenBilgileri(int row) {
		YapiElemani selectedEleman = (YapiElemani)tableModel.getYapiElemanilar().get(row);
		uDegeriTextField.setText(""+selectedEleman.getIsiGecirgenlikKatsayisi());
		lambdaTextField.setText(""+selectedEleman.getLambda());
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(13, 15, 432, 150);
			jScrollPane.setViewportView(getCokKullanilanBilesenlerTable());
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
			jPanel = new JPanel();
			jLabel = new JLabel();
			jLabel1 = new JLabel();
			jLabel2 = new JLabel();
			jLabel3 = new JLabel();
			jPanel.setLayout(null);
			jPanel.setBounds(13, 172, 432, 170);
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bileþen bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jLabel.setText("Adý");
			jLabel.setBounds(21, 24, 128, 27);
			jLabel1.setBounds(21, 57, 128, 27);
			jLabel1.setText("U deðeri");
			jLabel2.setBounds(21, 91, 128, 27);
			jLabel2.setText("1/\u039B deðeri");
			jLabel3.setBounds(21, 124, 128, 30);
			jLabel3.setText("Yönetmelik 1/\u039B deðeri");
			jPanel.add(jLabel, null);
			jPanel.add(getAdTextField(), null);
			jPanel.add(jLabel1, null);
			jPanel.add(getUDegeriTextField(), null);
			jPanel.add(jLabel2, null);
			jPanel.add(getLambdaTextField(), null);
			jPanel.add(jLabel3, null);
			jPanel.add(getYonetmelikDegeriComboBox(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes adTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getAdTextField() {
		if (adTextField == null) {
			adTextField = new JTextField();
			adTextField.setBounds(167, 24, 127, 27);
		}
		return adTextField;
	}
	/**
	 * This method initializes uDegeriTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getUDegeriTextField() {
		if (uDegeriTextField == null) {
			uDegeriTextField = new JTextField();
			uDegeriTextField.setBounds(167, 57, 127, 27);
		}
		return uDegeriTextField;
	}
	/**
	 * This method initializes lambdaTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getLambdaTextField() {
		if (lambdaTextField == null) {
			lambdaTextField = new JTextField();
			lambdaTextField.setBounds(167, 91, 127, 27);
		}
		return lambdaTextField;
	}
	/**
	 * This method initializes yonetmelikDegeriComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getYonetmelikDegeriComboBox() {
		if (yonetmelikDegeriComboBox == null) {			
			ArrayList direncler = BolgeyeGoreStandartBilesenDirencleri.getInstance().getBolgeyeGoreDirencler(BolgeBroker.getActiveBolgeAdi());
			yonetmelikDegeriComboBox = new JComboBox(direncler.toArray());
			yonetmelikDegeriComboBox.setBounds(167, 126, 230, 27);
		}
		return yonetmelikDegeriComboBox;
	}
	/**
	 * This method initializes tamamButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTamamButton() {
		if (tamamButton == null) {
			tamamButton = new JButton();
			tamamButton.setBounds(106, 364, 100, 28);
			tamamButton.setText("Tamam");
			tamamButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {					
					bilesen.setAd(getAdTextField().getText());
					bilesen.setU(Double.parseDouble(getUDegeriTextField().getText()));
					bilesen.setLambda(Double.parseDouble(getLambdaTextField().getText()));
					bilesen.setYonetmelikLambda(((StandartBilesenDirenci)getYonetmelikDegeriComboBox().getSelectedItem()).getDirenc());
					originatingPanel.addYalitimBileseniToTable(bilesen);
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
			vazgecButton.setBounds(229, 364, 100, 28);
			vazgecButton.setText("Vazgeç");
			vazgecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					dispose();
				}
			});
		}
		return vazgecButton;
	}
	public void reset() {
		adTextField.setText("");
		uDegeriTextField.setText("");
		lambdaTextField.setText("");		
		ArrayList direncler = BolgeyeGoreStandartBilesenDirencleri.getInstance().getBolgeyeGoreDirencler(BolgeBroker.getActiveBolgeAdi());
		yonetmelikDegeriComboBox = new JComboBox(direncler.toArray());
	}
	
	
    public StandartYalitimBileseni getBilesen() {
        return bilesen;
    }
    public void setBilesen(StandartYalitimBileseni bilesen) {
        this.bilesen = bilesen;
    }
   }  //  @jve:decl-index=0:visual-constraint="10,10"
