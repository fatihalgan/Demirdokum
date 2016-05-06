/*
 * Created on 01.Ara.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.iztek.dd.GUI.util.BoruParcasiCaplar;
import com.iztek.dd.GUI.util.JDoubleTextField;
import com.iztek.dd.GUI.util.JIntegerTextField;
/**
 * @author db2admin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ParcaBilgileriDialog extends JDialog {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -3308883790945608711L;
	
	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JLabel jLabel = null;
	private JDoubleTextField parcaUzunluguTextField = null;
	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JLabel jLabel2 = null;
	private JDoubleTextField parcaninIsiYukuTextField = null;
	private javax.swing.JLabel jLabel3 = null;
	private javax.swing.JPanel jPanel = null;
	private javax.swing.JLabel jLabel5 = null;
	private JIntegerTextField kazanVeRadyatorTextField = null;
	private javax.swing.JLabel jLabel6 = null;
	private javax.swing.JLabel jLabel7 = null;
	private JIntegerTextField kollektorGirisVeyaCikisTextField = null;
	private javax.swing.JLabel jLabel8 = null;
	private javax.swing.JLabel jLabel9 = null;
	private JIntegerTextField tGecisTextField = null;
	private javax.swing.JLabel jLabel10 = null;
	private javax.swing.JLabel jLabel11 = null;
	private JIntegerTextField pantalonParcasiTextField = null;
	private javax.swing.JLabel jLabel12 = null;
	private javax.swing.JLabel jLabel13 = null;
	private JIntegerTextField sParcasiTextField = null;
	private javax.swing.JLabel jLabel14 = null;
	private javax.swing.JLabel jLabel15 = null;
	private JIntegerTextField genisCiftDirsekTextField = null;
	private javax.swing.JLabel jLabel16 = null;
	private JIntegerTextField darCiftDirsekTextField = null;
	private javax.swing.JLabel jLabel17 = null;
	private javax.swing.JLabel jLabel18 = null;
	private JIntegerTextField tBirleþmeTextField = null;
	private javax.swing.JLabel jLabel19 = null;
	private javax.swing.JLabel jLabel20 = null;
	private javax.swing.JLabel jLabel21 = null;
	private javax.swing.JLabel jLabel22 = null;
	private JIntegerTextField tAyrilmaTextField = null;
	private JIntegerTextField tKarsitAkimTextField = null;
	private javax.swing.JLabel jLabel23 = null;
	private javax.swing.JLabel jLabel24 = null;
	private javax.swing.JLabel jLabel25 = null;
	private javax.swing.JLabel jLabel26 = null;
	private javax.swing.JLabel jLabel27 = null;
	private javax.swing.JLabel jLabel28 = null;
	private javax.swing.JLabel jLabel29 = null;
	private javax.swing.JLabel jLabel30 = null;
	private javax.swing.JLabel jLabel31 = null;
	private javax.swing.JLabel jLabel32 = null;
	private JIntegerTextField tGirisTextField = null;
	private JIntegerTextField deveBoynuTextField = null;
	private JIntegerTextField dirsekTextField = null;
	private JIntegerTextField siberVanaTextField = null;
	private JIntegerTextField duzKolonVanasiTextField = null;
	private JIntegerTextField egikKolonVanasiTextField = null;
	private JIntegerTextField duzRadyatorVentiliTextField = null;
	private JIntegerTextField koseliRadyatorVentiliTextField = null;
	private javax.swing.JLabel jLabel33 = null;
	private javax.swing.JLabel jLabel34 = null;
	private javax.swing.JLabel jLabel35 = null;
	private javax.swing.JLabel jLabel36 = null;
	private javax.swing.JLabel jLabel37 = null;
	private javax.swing.JLabel jLabel38 = null;
	private javax.swing.JLabel jLabel39 = null;
	private javax.swing.JLabel jLabel40 = null;
	private javax.swing.JButton ekleButton = null;
	private javax.swing.JButton jButton1 = null;
	private JLabel jLabel4 = null;
	private JComboBox parcaninCapiComboBox = null;
	/**
	 * This is the default constructor
	 */
	public ParcaBilgileriDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() 
	{
		this.setTitle("Parça Bilgileri");
		this.setContentPane(getJContentPane());
		this.setSize(579, 465);
	}
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jLabel4 = new JLabel();
			jContentPane.setLayout(null);
			jContentPane.add(getJLabel(), null);
			jContentPane.add(getParcaUzunluguTextField(), null);
			jContentPane.add(getJLabel1(), null);
			jContentPane.add(getJLabel2(), null);
			jContentPane.add(getParcaninIsiYukuTextField(), null);
			jContentPane.add(getJLabel3(), null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getEkleButton(), null);
			jContentPane.add(getJButton1(), null);
			jLabel4.setBounds(19, 80, 110, 24);
			jLabel4.setText("Parçanýn çapý");
			jContentPane.add(jLabel4, null);
			jContentPane.add(getParcaninCapiComboBox(), null);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setBounds(19, 19, 108, 24);
			jLabel.setText("Parça uzunluðu");
		}
		return jLabel;
	}
	/**
	 * This method initializes parcaUzunluguTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JDoubleTextField getParcaUzunluguTextField() {
		if(parcaUzunluguTextField == null) {
			parcaUzunluguTextField = new JDoubleTextField();
			parcaUzunluguTextField.setBounds(138, 18, 93, 24);
		}
		return parcaUzunluguTextField;
	}
	/**
	 * This method initializes jLabel1
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new javax.swing.JLabel();
			jLabel1.setBounds(242, 18, 39, 24);
			jLabel1.setText("m");
		}
		return jLabel1;
	}
	/**
	 * This method initializes jLabel2
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new javax.swing.JLabel();
			jLabel2.setBounds(19, 49, 108, 24);
			jLabel2.setText("Parçanýn ýsý yükü");
		}
		return jLabel2;
	}
	/**
	 * This method initializes parcaninIsiYukuTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JDoubleTextField getParcaninIsiYukuTextField() {
		if(parcaninIsiYukuTextField == null) {
			parcaninIsiYukuTextField = new JDoubleTextField();
			parcaninIsiYukuTextField.setBounds(138, 48, 93, 24);
		}
		return parcaninIsiYukuTextField;
	}
	/**
	 * This method initializes jLabel3
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new javax.swing.JLabel();
			jLabel3.setBounds(242, 48, 48, 24);
			jLabel3.setText("W");
		}
		return jLabel3;
	}
	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel() {
		if(jPanel == null) {
			jPanel = new javax.swing.JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJLabel7(), null);
			jPanel.add(getKollektorGirisVeyaCikisTextField(), null);
			jPanel.add(getJLabel8(), null);
			jPanel.add(getJLabel5(), null);
			jPanel.add(getKazanVeRadyatorTextField(), null);
			jPanel.add(getJLabel6(), null);
			jPanel.add(getJLabel9(), null);
			jPanel.add(getTGecisTextField(), null);
			jPanel.add(getJLabel10(), null);
			jPanel.add(getJLabel11(), null);
			jPanel.add(getPantalonParcasiTextField(), null);
			jPanel.add(getJLabel12(), null);
			jPanel.add(getJLabel13(), null);
			jPanel.add(getSParcasiTextField(), null);
			jPanel.add(getJLabel14(), null);
			jPanel.add(getJLabel15(), null);
			jPanel.add(getGenisCiftDirsekTextField(), null);
			jPanel.add(getJLabel16(), null);
			jPanel.add(getDarCiftDirsekTextField(), null);
			jPanel.add(getJLabel17(), null);
			jPanel.add(getJLabel18(), null);
			jPanel.add(getTBirleþmeTextField(), null);
			jPanel.add(getJLabel19(), null);
			jPanel.add(getJLabel20(), null);
			jPanel.add(getJLabel21(), null);
			jPanel.add(getJLabel22(), null);
			jPanel.add(getTAyrilmaTextField(), null);
			jPanel.add(getTKarsitAkimTextField(), null);
			jPanel.add(getJLabel23(), null);
			jPanel.add(getJLabel24(), null);
			jPanel.add(getJLabel25(), null);
			jPanel.add(getJLabel26(), null);
			jPanel.add(getJLabel27(), null);
			jPanel.add(getJLabel28(), null);
			jPanel.add(getJLabel29(), null);
			jPanel.add(getJLabel30(), null);
			jPanel.add(getJLabel31(), null);
			jPanel.add(getJLabel32(), null);
			jPanel.add(getTGirisTextField(), null);
			jPanel.add(getDeveBoynuTextField(), null);
			jPanel.add(getDirsekTextField(), null);
			jPanel.add(getSiberVanaTextField(), null);
			jPanel.add(getDuzKolonVanasiTextField(), null);
			jPanel.add(getEgikKolonVanasiTextField(), null);
			jPanel.add(getDuzRadyatorVentiliTextField(), null);
			jPanel.add(getKoseliRadyatorVentiliTextField(), null);
			jPanel.add(getJLabel33(), null);
			jPanel.add(getJLabel34(), null);
			jPanel.add(getJLabel35(), null);
			jPanel.add(getJLabel36(), null);
			jPanel.add(getJLabel37(), null);
			jPanel.add(getJLabel38(), null);
			jPanel.add(getJLabel39(), null);
			jPanel.add(getJLabel40(), null);
			jPanel.setBounds(13, 116, 553, 265);
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parça Özellikleri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
		}
		return jPanel;
	}
	/**
	 * This method initializes jLabel5
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new javax.swing.JLabel();
			jLabel5.setBounds(21, 23, 138, 20);
			jLabel5.setText("Isýtýcý veya Radyatör");
			jLabel5.setPreferredSize(new java.awt.Dimension(118,20));
		}
		return jLabel5;
	}
	/**
	 * This method initializes kazanVeRadyatorTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getKazanVeRadyatorTextField() {
		if(kazanVeRadyatorTextField == null) {
			kazanVeRadyatorTextField = new JIntegerTextField();
			kazanVeRadyatorTextField.setBounds(180, 23, 50, 20);
			kazanVeRadyatorTextField.setPreferredSize(new java.awt.Dimension(50,20));
		}
		return kazanVeRadyatorTextField;
	}
	/**
	 * This method initializes jLabel6
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel6() {
		if(jLabel6 == null) {
			jLabel6 = new javax.swing.JLabel();
			jLabel6.setBounds(235, 23, 25, 20);
			jLabel6.setText("adet");
			jLabel6.setPreferredSize(new java.awt.Dimension(25,20));
		}
		return jLabel6;
	}
	/**
	 * This method initializes jLabel7
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new javax.swing.JLabel();
			jLabel7.setBounds(281, 23, 132, 20);
			jLabel7.setText("T Geçiþ (ayrýlma)");
			jLabel7.setPreferredSize(new java.awt.Dimension(95,20));
		}
		return jLabel7;
	}
	/**
	 * This method initializes kollektorGirisVeyaCikisTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getKollektorGirisVeyaCikisTextField() {
		if(kollektorGirisVeyaCikisTextField == null) {
			kollektorGirisVeyaCikisTextField = new JIntegerTextField();
			kollektorGirisVeyaCikisTextField.setBounds(180, 49, 50, 20);
			kollektorGirisVeyaCikisTextField.setPreferredSize(new java.awt.Dimension(50,20));
		}
		return kollektorGirisVeyaCikisTextField;
	}
	/**
	 * This method initializes jLabel8
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new javax.swing.JLabel();
			jLabel8.setBounds(235, 49, 25, 20);
			jLabel8.setText("adet");
			jLabel8.setPreferredSize(new java.awt.Dimension(25,20));
		}
		return jLabel8;
	}
	/**
	 * This method initializes jLabel9
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel9() {
		if(jLabel9 == null) {
			jLabel9 = new javax.swing.JLabel();
			jLabel9.setBounds(21, 49, 138, 20);
			jLabel9.setText("Kollektör giriþ veya çýkýþ");
			jLabel9.setPreferredSize(new java.awt.Dimension(138,20));
		}
		return jLabel9;
	}
	/**
	 * This method initializes tGecisTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getTGecisTextField() {
		if(tGecisTextField == null) {
			tGecisTextField = new JIntegerTextField();
			tGecisTextField.setBounds(434, 23, 50, 20);
			tGecisTextField.setPreferredSize(new java.awt.Dimension(50,20));
		}
		return tGecisTextField;
	}
	/**
	 * This method initializes jLabel10
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel10() {
		if(jLabel10 == null) {
			jLabel10 = new javax.swing.JLabel();
			jLabel10.setBounds(489, 25, 38, 16);
			jLabel10.setText("adet");
		}
		return jLabel10;
	}
	/**
	 * This method initializes jLabel11
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel11() {
		if(jLabel11 == null) {
			jLabel11 = new javax.swing.JLabel();
			jLabel11.setBounds(21, 75, 138, 20);
			jLabel11.setText("Pantalon parçasý");
		}
		return jLabel11;
	}
	/**
	 * This method initializes pantalonParcasiTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getPantalonParcasiTextField() {
		if(pantalonParcasiTextField == null) {
			pantalonParcasiTextField = new JIntegerTextField();
			pantalonParcasiTextField.setBounds(180, 75, 50, 20);
		}
		return pantalonParcasiTextField;
	}
	/**
	 * This method initializes jLabel12
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel12() {
		if(jLabel12 == null) {
			jLabel12 = new javax.swing.JLabel();
			jLabel12.setBounds(235, 75, 25, 20);
			jLabel12.setText("adet");
		}
		return jLabel12;
	}
	/**
	 * This method initializes jLabel13
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel13() {
		if(jLabel13 == null) {
			jLabel13 = new javax.swing.JLabel();
			jLabel13.setBounds(21, 101, 138, 20);
			jLabel13.setText("S parçasý");
		}
		return jLabel13;
	}
	/**
	 * This method initializes sParcasiTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getSParcasiTextField() {
		if(sParcasiTextField == null) {
			sParcasiTextField = new JIntegerTextField();
			sParcasiTextField.setBounds(180, 101, 50, 20);
		}
		return sParcasiTextField;
	}
	/**
	 * This method initializes jLabel14
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel14() {
		if(jLabel14 == null) {
			jLabel14 = new javax.swing.JLabel();
			jLabel14.setBounds(235, 101, 25, 20);
			jLabel14.setText("adet");
		}
		return jLabel14;
	}
	/**
	 * This method initializes jLabel15
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel15() {
		if(jLabel15 == null) {
			jLabel15 = new javax.swing.JLabel();
			jLabel15.setBounds(21, 127, 138, 20);
			jLabel15.setText("Çift dirsek (geniþ)");
		}
		return jLabel15;
	}
	/**
	 * This method initializes genisCiftDirsekTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getGenisCiftDirsekTextField() {
		if(genisCiftDirsekTextField == null) {
			genisCiftDirsekTextField = new JIntegerTextField();
			genisCiftDirsekTextField.setBounds(180, 127, 50, 20);
		}
		return genisCiftDirsekTextField;
	}
	/**
	 * This method initializes jLabel16
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel16() {
		if(jLabel16 == null) {
			jLabel16 = new javax.swing.JLabel();
			jLabel16.setBounds(235, 127, 25, 20);
			jLabel16.setText("adet");
		}
		return jLabel16;
	}
	/**
	 * This method initializes darCiftDirsekTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getDarCiftDirsekTextField() {
		if(darCiftDirsekTextField == null) {
			darCiftDirsekTextField = new JIntegerTextField();
			darCiftDirsekTextField.setBounds(180, 153, 50, 20);
		}
		return darCiftDirsekTextField;
	}
	/**
	 * This method initializes jLabel17
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel17() {
		if(jLabel17 == null) {
			jLabel17 = new javax.swing.JLabel();
			jLabel17.setBounds(235, 153, 25, 20);
			jLabel17.setText("adet");
		}
		return jLabel17;
	}
	/**
	 * This method initializes jLabel18
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel18() {
		if(jLabel18 == null) {
			jLabel18 = new javax.swing.JLabel();
			jLabel18.setBounds(21, 153, 138, 20);
			jLabel18.setText("Çift dirsek (dar)");
		}
		return jLabel18;
	}
	/**
	 * This method initializes tBirleþmeTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getTBirleþmeTextField() {
		if(tBirleþmeTextField == null) {
			tBirleþmeTextField = new JIntegerTextField();
			tBirleþmeTextField.setBounds(180, 179, 50, 20);
		}
		return tBirleþmeTextField;
	}
	/**
	 * This method initializes jLabel19
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel19() {
		if(jLabel19 == null) {
			jLabel19 = new javax.swing.JLabel();
			jLabel19.setBounds(235, 179, 25, 20);
			jLabel19.setText("adet");
		}
		return jLabel19;
	}
	/**
	 * This method initializes jLabel20
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel20() {
		if(jLabel20 == null) {
			jLabel20 = new javax.swing.JLabel();
			jLabel20.setBounds(21, 179, 138, 20);
			jLabel20.setText("T birleþme");
		}
		return jLabel20;
	}
	/**
	 * This method initializes jLabel21
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel21() {
		if(jLabel21 == null) {
			jLabel21 = new javax.swing.JLabel();
			jLabel21.setBounds(21, 205, 138, 20);
			jLabel21.setText("T Ayrýlma");
		}
		return jLabel21;
	}
	/**
	 * This method initializes jLabel22
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel22() {
		if(jLabel22 == null) {
			jLabel22 = new javax.swing.JLabel();
			jLabel22.setBounds(21, 231, 138, 20);
			jLabel22.setText("T karþýt akým");
		}
		return jLabel22;
	}
	/**
	 * This method initializes tAyrilmaTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getTAyrilmaTextField() {
		if(tAyrilmaTextField == null) {
			tAyrilmaTextField = new JIntegerTextField();
			tAyrilmaTextField.setBounds(180, 205, 50, 20);
		}
		return tAyrilmaTextField;
	}
	/**
	 * This method initializes tKarsitAkimTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getTKarsitAkimTextField() {
		if(tKarsitAkimTextField == null) {
			tKarsitAkimTextField = new JIntegerTextField();
			tKarsitAkimTextField.setBounds(180, 231, 50, 20);
		}
		return tKarsitAkimTextField;
	}
	/**
	 * This method initializes jLabel23
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel23() {
		if(jLabel23 == null) {
			jLabel23 = new javax.swing.JLabel();
			jLabel23.setBounds(235, 205, 25, 20);
			jLabel23.setText("adet");
		}
		return jLabel23;
	}
	/**
	 * This method initializes jLabel24
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel24() {
		if(jLabel24 == null) {
			jLabel24 = new javax.swing.JLabel();
			jLabel24.setBounds(235, 231, 25, 20);
			jLabel24.setText("adet");
		}
		return jLabel24;
	}
	/**
	 * This method initializes jLabel25
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel25() {
		if(jLabel25 == null) {
			jLabel25 = new javax.swing.JLabel();
			jLabel25.setBounds(281, 49, 132, 20);
			jLabel25.setText("T Giriþ (ayrýlma)");
		}
		return jLabel25;
	}
	/**
	 * This method initializes jLabel26
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel26() {
		if(jLabel26 == null) {
			jLabel26 = new javax.swing.JLabel();
			jLabel26.setBounds(281, 75, 132, 20);
			jLabel26.setText("Deve boynu 90");
		}
		return jLabel26;
	}
	/**
	 * This method initializes jLabel27
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel27() {
		if(jLabel27 == null) {
			jLabel27 = new javax.swing.JLabel();
			jLabel27.setBounds(281, 101, 132, 20);
			jLabel27.setText("Dirsek");
		}
		return jLabel27;
	}
	/**
	 * This method initializes jLabel28
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel28() {
		if(jLabel28 == null) {
			jLabel28 = new javax.swing.JLabel();
			jLabel28.setBounds(281, 127, 132, 20);
			jLabel28.setText("Þiber vana");
		}
		return jLabel28;
	}
	/**
	 * This method initializes jLabel29
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel29() {
		if(jLabel29 == null) {
			jLabel29 = new javax.swing.JLabel();
			jLabel29.setBounds(281, 153, 132, 20);
			jLabel29.setText("Kolon vanasý (düz)");
		}
		return jLabel29;
	}
	/**
	 * This method initializes jLabel30
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel30() {
		if(jLabel30 == null) {
			jLabel30 = new javax.swing.JLabel();
			jLabel30.setBounds(281, 179, 132, 20);
			jLabel30.setText("Kolon vanasý (eðik)");
		}
		return jLabel30;
	}
	/**
	 * This method initializes jLabel31
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel31() {
		if(jLabel31 == null) {
			jLabel31 = new javax.swing.JLabel();
			jLabel31.setBounds(281, 205, 132, 20);
			jLabel31.setText("Radyatör ventili (düz)");
		}
		return jLabel31;
	}
	/**
	 * This method initializes jLabel32
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel32() {
		if(jLabel32 == null) {
			jLabel32 = new javax.swing.JLabel();
			jLabel32.setBounds(281, 231, 132, 20);
			jLabel32.setText("Radyatör ventili (köþeli)");
		}
		return jLabel32;
	}
	/**
	 * This method initializes tGirisTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getTGirisTextField() {
		if(tGirisTextField == null) {
			tGirisTextField = new JIntegerTextField();
			tGirisTextField.setBounds(434, 49, 50, 20);
		}
		return tGirisTextField;
	}
	/**
	 * This method initializes deveBoynuTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getDeveBoynuTextField() {
		if(deveBoynuTextField == null) {
			deveBoynuTextField = new JIntegerTextField();
			deveBoynuTextField.setBounds(434, 75, 50, 20);
		}
		return deveBoynuTextField;
	}
	/**
	 * This method initializes dirsekTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getDirsekTextField() {
		if(dirsekTextField == null) {
			dirsekTextField = new JIntegerTextField();
			dirsekTextField.setBounds(434, 101, 50, 20);
		}
		return dirsekTextField;
	}
	/**
	 * This method initializes siberVanaTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getSiberVanaTextField() {
		if(siberVanaTextField == null) {
			siberVanaTextField = new JIntegerTextField();
			siberVanaTextField.setBounds(434, 127, 50, 20);
		}
		return siberVanaTextField;
	}
	/**
	 * This method initializes duzKolonVanasiTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getDuzKolonVanasiTextField() {
		if(duzKolonVanasiTextField == null) {
			duzKolonVanasiTextField = new JIntegerTextField();
			duzKolonVanasiTextField.setBounds(434, 153, 50, 20);
		}
		return duzKolonVanasiTextField;
	}
	/**
	 * This method initializes egikKolonVanasiTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getEgikKolonVanasiTextField() {
		if(egikKolonVanasiTextField == null) {
			egikKolonVanasiTextField = new JIntegerTextField();
			egikKolonVanasiTextField.setBounds(434, 179, 50, 20);
		}
		return egikKolonVanasiTextField;
	}
	/**
	 * This method initializes duzRadyatorVentiliTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getDuzRadyatorVentiliTextField() {
		if(duzRadyatorVentiliTextField == null) {
			duzRadyatorVentiliTextField = new JIntegerTextField();
			duzRadyatorVentiliTextField.setBounds(434, 205, 50, 20);
		}
		return duzRadyatorVentiliTextField;
	}
	/**
	 * This method initializes koseliRadyatorVentiliTextField
	 * 
	 * @return JIntegerTextField
	 */
	public JIntegerTextField getKoseliRadyatorVentiliTextField() {
		if(koseliRadyatorVentiliTextField == null) {
			koseliRadyatorVentiliTextField = new JIntegerTextField();
			koseliRadyatorVentiliTextField.setBounds(434, 231, 50, 20);
		}
		return koseliRadyatorVentiliTextField;
	}
	/**
	 * This method initializes jLabel33
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel33() {
		if(jLabel33 == null) {
			jLabel33 = new javax.swing.JLabel();
			jLabel33.setBounds(489, 51, 38, 16);
			jLabel33.setText("adet");
		}
		return jLabel33;
	}
	/**
	 * This method initializes jLabel34
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel34() {
		if(jLabel34 == null) {
			jLabel34 = new javax.swing.JLabel();
			jLabel34.setBounds(489, 77, 38, 16);
			jLabel34.setText("adet");
		}
		return jLabel34;
	}
	/**
	 * This method initializes jLabel35
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel35() {
		if(jLabel35 == null) {
			jLabel35 = new javax.swing.JLabel();
			jLabel35.setBounds(489, 103, 38, 16);
			jLabel35.setText("adet");
		}
		return jLabel35;
	}
	/**
	 * This method initializes jLabel36
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel36() {
		if(jLabel36 == null) {
			jLabel36 = new javax.swing.JLabel();
			jLabel36.setBounds(489, 129, 38, 16);
			jLabel36.setText("adet");
		}
		return jLabel36;
	}
	/**
	 * This method initializes jLabel37
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel37() {
		if(jLabel37 == null) {
			jLabel37 = new javax.swing.JLabel();
			jLabel37.setBounds(489, 155, 38, 16);
			jLabel37.setText("adet");
		}
		return jLabel37;
	}
	/**
	 * This method initializes jLabel38
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel38() {
		if(jLabel38 == null) {
			jLabel38 = new javax.swing.JLabel();
			jLabel38.setBounds(489, 181, 38, 16);
			jLabel38.setText("adet");
		}
		return jLabel38;
	}
	/**
	 * This method initializes jLabel39
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel39() {
		if(jLabel39 == null) {
			jLabel39 = new javax.swing.JLabel();
			jLabel39.setBounds(489, 207, 38, 16);
			jLabel39.setText("adet");
		}
		return jLabel39;
	}
	/**
	 * This method initializes jLabel40
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel40() {
		if(jLabel40 == null) {
			jLabel40 = new javax.swing.JLabel();
			jLabel40.setBounds(489, 233, 38, 16);
			jLabel40.setText("adet");
		}
		return jLabel40;
	}
	/**
	 * This method initializes ekleButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getEkleButton() {
		if(ekleButton == null) {
			ekleButton = new javax.swing.JButton();
			ekleButton.setBounds(191, 389, 80, 31);
			ekleButton.setText("Tamam");
		}
		return ekleButton;
	}
	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new javax.swing.JButton();
			jButton1.setBounds(296, 389, 81, 31);
			jButton1.setText("Vazgeç");			
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					dispose();
				}
			});
		}
		return jButton1;
	}
	
	public void addEkleListener(ActionListener listener){
	    getEkleButton().addActionListener(listener);
	}
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	public JComboBox getParcaninCapiComboBox() {
		if (parcaninCapiComboBox == null) {
			parcaninCapiComboBox = new JComboBox();
			parcaninCapiComboBox.setBounds(137, 80, 94, 23);
			parcaninCapiComboBox.setModel(new DefaultComboBoxModel(BoruParcasiCaplar.CAPLAR.toArray()));
		}
		return parcaninCapiComboBox;
	}
 }  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"
