package com.iztek.dd.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;

import com.iztek.dd.IsiKazanci.domain.AktiviteCatalog;
import com.iztek.dd.IsiKazanci.domain.CatiCLTD;
import com.iztek.dd.IsiKazanci.domain.CatiCLTDs;
public class IsiKazanciPanel extends JPanel {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -5453593568059464851L;
	
	private JTabbedPane jTabbedPane = null;
	private JPanel tasarimSartlariPanel = null;
	private JPanel iletimTasinimPanel = null;
	private JPanel bjPanel2 = null;
	private JPanel bjPanel3 = null;
	private JPanel bjPanel4 = null;
	private JPanel bjPanel66 = null;
	private JLabel bjLabel4 = null;
	private JLabel bjLabel5 = null;
	private JLabel bjLabel6 = null;
	private JLabel bjLabel7 = null;
	private JTextField icOzgulNemTextField = null;  //  @jve:decl-index=0:visual-constraint="-26,479"
	private JTextField icKuruTermometreSicakligiTextField = null;  //  @jve:decl-index=0:visual-constraint="-26,444"
	private JTextField disOzgulNemTextField = null;  //  @jve:decl-index=0:visual-constraint="-26,407"
	private JTextField disSicaklikTextField = null;  //  @jve:decl-index=0:visual-constraint="-26,368"
	private JPanel bjPanel11 = null;
	private JPanel bjPanel12 = null;
	private JLabel bjLabel9 = null;
	private JLabel bjLabel10 = null;
	private JLabel bjLabel11 = null;
	private JLabel bjLabel13 = null;
	private JLabel bjLabel15 = null;
	private JLabel bjLabel16 = null;
	private JPanel bjPanel6 = null;
	private JButton bjButton3 = null;
	private JPanel bjPanel7 = null;
	private JTextField catiAlaniTextField = null;
	private JTextField catiUTextField = null;
	private JLabel bjLabel19 = null;
	private JTextField disDuvarIsiTransferKatsayisiTextField = null;
	private JComboBox catiTipiComboBox = null;
	private JTextField pencereIsiTransferKatsayisiTextField = null;
	private JTextField icDuvarIsiTransferKatsayisiTextField = null;
	private JTextField sicaklikFarkiTextField = null;
	private JButton bjButton4 = null;
	private JButton bjButton5 = null;
	private JLabel bjLabel21 = null;
	private JTextField iletimIsiKazanciTextField = null;
	private JPanel bjPanel8 = null;
	private JPanel bjPanel13 = null;
	private JPanel bjPanel14 = null;
	private JPanel bjPanel15 = null;
	private JPanel bjPanel16 = null;
	private JPanel bjPanel17 = null;
	private JRadioButton golgelemesizTekPencereRadioButton = null;
	private JRadioButton golgelemesizCiftPencereRadioButton = null;
	private JLabel bjLabel22 = null;
	private JComboBox camKalinligiComboBox = null;
	private JRadioButton koyuJaluziRadioButton = null;
	private JRadioButton acikJaluziRadioButton = null;
	private JRadioButton koyuPerdeRadioButton = null;
	private JRadioButton acikPerdeRadioButton = null;
	private JRadioButton isikGecirgenRadioButton = null;
	private JRadioButton normalCamKalinligi3RadioButton = null;
	private JRadioButton normalCamKalinligi6RadioButton = null;
	private JRadioButton absorbsiyonluCamKalinligi6RadioButton = null;
	private JRadioButton aynaliCamRadioButton = null;
	private JRadioButton normalCamRadioButton = null;
	private JRadioButton isiAbsorbsiyonluCamRadioButton = null;
	private JRadioButton normalCiftCamRadioButton = null;
	private JPanel bjPanel18 = null;
	private JButton bjButton7 = null;
	private JButton bjButton8 = null;
	private JLabel bjLabel26 = null;
	private JTextField direktGunesYukuTextField = null;
	private JPanel bjPanel20 = null;
	private JPanel bjPanel21 = null;
	private JPanel bjPanel22 = null;
	private JPanel bjPanel23 = null;
	private JPanel bjPanel24 = null;
	private JLabel bjLabel29 = null;
	private JLabel bjLabel30 = null;
	private JLabel bjLabel31 = null;
	private JLabel bjLabel32 = null;
	private JRadioButton aydinlanmaSuresi8RadioButton = null;
	private JRadioButton aydinlanmaSuresi12RadioButton = null;
	private JComboBox isikSonrasiZamanComboBox = null;
	private JLabel bjLabel34 = null;
	private JLabel bjLabel35 = null;
	private JTextField aydinlanmaElemanlariToplamGucTextField = null;
	private JTextField aydinlatmaIsiKazanciTextField = null;
	private JButton bjButton11 = null;
	private JButton bjButton12 = null;
	private JPanel bjPanel25 = null;
	private JPanel bjPanel26 = null;
	private JLabel bjLabel36 = null;
	private JLabel bjLabel37 = null;
	private JComboBox aktivitelerComboBox = null;
	private JLabel bjLabel38 = null;
	private JLabel bjLabel39 = null;
	private JLabel bjLabel40 = null;
	private JLabel bjLabel41 = null;
	private JTextField insanlardanIsiKazanciTextField = null;
	private JTextField insanSayisiTextField = null;
	private JButton bjButton16 = null;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private ButtonGroup evetHayirBGroup = new ButtonGroup();
	private ButtonGroup pencereTipiBGroup = new ButtonGroup();
	private ButtonGroup camTipiBGroup = new ButtonGroup();
//	private ButtonGroup jaluziBGroup = new ButtonGroup();
//	private ButtonGroup dikeyPerdeBGroup = new ButtonGroup();
	private ButtonGroup golgeTipiBGroup = new ButtonGroup();
	private ButtonGroup icCamTipiBGroup = new ButtonGroup();
	private ButtonGroup aydinlatmaSuresiBGroup = new ButtonGroup();
	
	private JLabel jLabel = null;
	private JTextField enfiltrasyonHavalandirmaYukuTextField = null;
	private JLabel jLabel1 = null;
	private JTextField toplamIsiKazanciTextField = null;
	private JList disDuvarList = null;
	private JList pencereList = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JButton duvarEkleButton = null;
	private JButton duvarSilButton = null;
	private JButton pencereEkleButton = null;
	private JButton pencereSilButton = null;
	private JCheckBox mustakilMahalCheckBox = null;
	private JLabel jLabel5 = null;
	private JComboBox hesapAyiComboBox = null;
	private JComboBox hesapSaatiComboBox = null;
	private JPanel jPanel = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JTextField duvarAlaniTextField = null;
	private JComboBox duvarYonuComboBox = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JTextField pencereAlaniTextField = null;
	private JComboBox pencereYonuComboBox = null;
	private JCheckBox mahalIciSicaklikFarkiCheckBox = null;
	private JLabel jLabel10 = null;
	private JTextField icDuvarAlaniTextField = null;
	private JPanel jPanel3 = null;
	private JLabel jLabel11 = null;
	private JTextField disDuvarToplamBoyuTextField = null;
	private JRadioButton golgelemeliCiftPencereRadioButton = null;
	private JComboBox aynaTipiComboBox = null;
	private JComboBox mobilyaTipiComboBox = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JLabel jLabel14 = null;
	private JTextField cihazlarinToplamGucuTextField = null;
	private JTextField ekipmanlarIsiKazanciTextField = null;
	private JButton cihazSecButton = null;
	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;
	private JPanel jPanel4 = null;
	private JCheckBox cihazDavlumbazliCheckBox = null;
	private JLabel jLabel2 = null;
	private JComboBox toplamCalismaSuresiComboBox = null;
	private JLabel jLabel3 = null;
	private JComboBox toplamIsletmeSuresiComboBox = null;
	private JPanel jPanel5 = null;
	private JPanel jPanel6 = null;
	private JLabel jLabel4 = null;
	private JTextField havaDebisiTextField = null;
	private JComboBox hacimdeKalmaSuresiComboBox = null;
	private JComboBox hacimeGirdiktenSonraGecenSureComboBox = null;
	private JLabel jLabel15 = null;
	private JTextField secilenKlimaTextField = null;
	private JButton klimaSecButton = null;
	private JLabel jLabel16 = null;
	private JLabel jLabel17 = null;
	private JLabel jLabel18 = null;
	/**
	 * This is the default constructor
	 */
	public IsiKazanciPanel() {
		super();
		initialize();
		
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		this.setLayout(new BorderLayout());
		this.setSize(726, 495);
		this.setPreferredSize(new java.awt.Dimension(458,506));
		this.add(getBJTabbedPane(), java.awt.BorderLayout.CENTER);
	}
	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */    
	private JTabbedPane getBJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("Tasarým Þartlarý", null, getTasarimSartlariPanel(), null);			
			jTabbedPane.addTab("Ýletim ve Taþýným ile", null, getIletimTasinimPanel(), null);
			jTabbedPane.addTab("Camlardan Güneþ Iþýnýmý ile", null, getBJPanel2(), null);
			jTabbedPane.addTab("Aydýnlatma ve Ekipmanlar", null, getBJPanel3(), null);
			jTabbedPane.addTab("Ýnsanlardan", null, getBJPanel4(), null);
		}
		return jTabbedPane;
	}
	/**
	 * This method initializes tasarimSartlariPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getTasarimSartlariPanel() {
		if (tasarimSartlariPanel == null) {
			jLabel5 = new JLabel();
			tasarimSartlariPanel = new JPanel();
			tasarimSartlariPanel.setLayout(null);
			jLabel5.setBounds(15, 38, 250, 21);
			jLabel5.setText("Hesabýn yapýlacaðý ayý ve saati seçiniz");
			tasarimSartlariPanel.add(getBJPanel6(), null);
			tasarimSartlariPanel.add(getBJPanel7(), null);
			tasarimSartlariPanel.add(getJPanel1(), null);
			tasarimSartlariPanel.add(getJPanel2(), null);
			tasarimSartlariPanel.add(getMustakilMahalCheckBox(), null);
			tasarimSartlariPanel.add(jLabel5, null);
			tasarimSartlariPanel.add(getHesapAyiComboBox(), null);
			tasarimSartlariPanel.add(getHesapSaatiComboBox(), null);
		}
		return tasarimSartlariPanel;
	}
	/**
	 * This method initializes iletimTasinimPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getIletimTasinimPanel() {
		if (iletimTasinimPanel == null) {
			iletimTasinimPanel = new JPanel();
			iletimTasinimPanel.setLayout(null);
			iletimTasinimPanel.add(getBJPanel11(), null);
			iletimTasinimPanel.add(getBJPanel12(), null);
		}
		return iletimTasinimPanel;
	}
	/**
	 * This method initializes bjPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel2() {
		if (bjPanel2 == null) {
			bjLabel26 = new JLabel();
			bjPanel2 = new JPanel();
			bjPanel2.setLayout(null);
			bjLabel26.setBounds(183, 379, 194, 24);
			bjLabel26.setText("Direkt güneþ yükü (Qdcs, Watt) :");
			bjPanel2.add(getBJPanel8(), null);
			bjPanel2.add(getBJPanel13(), null);
			bjPanel2.add(getBJPanel14(), null);
			bjPanel2.add(getBJPanel15(), null);
			bjPanel2.add(getBJPanel16(), null);
			bjPanel2.add(getBJPanel17(), null);
			bjPanel2.add(getBJPanel18(), null);
			bjPanel2.add(bjLabel26, null);
			bjPanel2.add(getDirektGunesYukuTextField(), null);
		}
		return bjPanel2;
	}
	/**
	 * This method initializes bjPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel3() {
		if (bjPanel3 == null) {
			bjPanel3 = new JPanel();
			bjPanel3.setLayout(null);
			bjPanel3.add(getBJPanel20(), null);
			bjPanel3.add(getBJPanel21(), null);
			bjPanel3.add(getBJPanel22(), null);
			bjPanel3.add(getBJPanel23(), null);
			bjPanel3.add(getBJPanel24(), null);
			bjPanel3.add(getJPanel4(), null);
		}
		return bjPanel3;
	}
	/**
	 * This method initializes bjPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel4() {
		if (bjPanel4 == null) {
			bjPanel4 = new JPanel();
			bjPanel4.setLayout(null);
			bjPanel4.add(getBJPanel25(), null);
			bjPanel4.add(getBJPanel26(), null);
		}
		return bjPanel4;
	}
	/**
	 * This method initializes icOzgulNemTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIcOzgulNemTextField() {
		if (icOzgulNemTextField == null) {
			icOzgulNemTextField = new JTextField();
			icOzgulNemTextField.setBounds(385, 26, 133, 22);
			icOzgulNemTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					icOzgulNemTextField.setText("");
				}
			});
		}
		return icOzgulNemTextField;
	}
	/**
	 * This method initializes icKuruTermometreSicakligiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIcKuruTermometreSicakligi() {
		if (icKuruTermometreSicakligiTextField == null) {
			icKuruTermometreSicakligiTextField = new JTextField();
			icKuruTermometreSicakligiTextField.setBounds(385, 86, 133, 22);
			icKuruTermometreSicakligiTextField.setText("25.5");
			icKuruTermometreSicakligiTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					icKuruTermometreSicakligiTextField.setText("");
				}
			});
		}
		return icKuruTermometreSicakligiTextField;
	}
	/**
	 * This method initializes disOzgulNemTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getDisOzgulNemTextField() {
		if (disOzgulNemTextField == null) {
			disOzgulNemTextField = new JTextField();
			disOzgulNemTextField.setBounds(385, 55, 133, 22);
			disOzgulNemTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					disOzgulNemTextField.setText("");
				}
			});
		}
		return disOzgulNemTextField;
	}
	/**
	 * This method initializes disSicaklikTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getDisSicaklikTextField() {
		if (disSicaklikTextField == null) {
			disSicaklikTextField = new JTextField();
			disSicaklikTextField.setBounds(385, 116, 133, 22);
			disSicaklikTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					disSicaklikTextField.setText("");
				}
			});
		}
		return disSicaklikTextField;
	}
	/**
	 * This method initializes bjPanel11	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel11() {
		if (bjPanel11 == null) {
			jLabel10 = new JLabel();
			bjLabel21 = new JLabel();
			bjLabel19 = new JLabel();
			jLabel11 = new JLabel();
			bjPanel11 = new JPanel();
			bjLabel9 = new JLabel();
			bjLabel10 = new JLabel();
			bjLabel11 = new JLabel();
			bjLabel13 = new JLabel();
			bjLabel15 = new JLabel();
			bjLabel16 = new JLabel();
			bjPanel11.setLayout(null);
			bjPanel11.setBounds(6, 4, 714, 372);
			bjLabel9.setText("Çatý alanýný giriniz :");
			bjLabel9.setBounds(39, 16, 105, 21);
			bjLabel10.setText("<html><body>Çatý için ýsý transfer katsayýsýný giriniz (Uç,W/m<sup>2</sup>)</body></html>) :");
			bjLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
			bjLabel10.setBounds(39, 42, 281, 21);
			bjLabel11.setText("Çatý tipini seçiniz :");
			bjLabel11.setBounds(39, 68, 101, 21);
			bjLabel13.setBounds(43, 172, 294, 20);
			bjLabel13.setText("Dýþ duvarlarýn toplam boyu (Lf, m) ");
			bjLabel15.setText("<html><body>Ýç duvarlar için ýsý transfer katsayýsý (U, W/m<sup>2</sup>C)</body></html>)");
			bjLabel15.setBounds(20, 57, 267, 21);
			bjLabel16.setText("<html><body>Ýç duvar alaný (A, m<sup>2</sup>)</body></html>)");
			bjLabel16.setBounds(20, 82, 117, 21);
			bjLabel19.setBounds(43, 148, 294, 20);
			bjLabel19.setText("<html><body>Pencere için ýsý transfer katsayýsý (Uc,W/m<sup>2</sup>\u00B0C)</body></html>) :"); 
			bjLabel21.setBounds(132, 342, 284, 20);
			bjLabel21.setText("Toplam iletim yolu ile ýsý kazancý (Qd, Watt) :");
			jLabel10.setText("Sýcaklýk farký");
			jLabel10.setBounds(20, 32, 104, 21);
			jLabel11.setBounds(43, 123, 294, 20);
			jLabel11.setText("<html><body>Dýþ duvarlar için ýsý transfer katsayýsý (Ud,W/m<sup>2</sup>°C)</body></html>) :");
			bjPanel11.add(bjLabel13, null);
			bjPanel11.add(bjLabel19, null);
			bjPanel11.add(getDisDuvarIsiTransferKatsayisiTextField(), null);
			bjPanel11.add(getPencereIsiTransferKatsayisiTextField(), null);
			bjPanel11.add(bjLabel21, null);
			bjPanel11.add(getIletimIsiKazanciTextField(), null);
			bjPanel11.add(jLabel11, null);
			bjPanel11.add(getDisDuvarToplamBoyuTextField(), null);
			bjPanel11.add(getJPanel(), null);
			bjPanel11.add(getJPanel3(), null);
		}
		return bjPanel11;
	}
	/**
	 * This method initializes bjPanel12	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel12() {
		if (bjPanel12 == null) {
			bjPanel12 = new JPanel();
			bjPanel12.setLayout(new FlowLayout());
			bjPanel12.setLocation(13, 422);
			bjPanel12.setSize(693, 40);
			bjPanel12.add(getBJButton5(), null);
			bjPanel12.add(getBJButton4(), null);
		}
		return bjPanel12;
	}
	/**
	 * This method initializes bjPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel6() {
		if (bjPanel6 == null) {
			bjPanel6 = new JPanel();
			bjPanel6.setLayout(null);
			bjPanel6.setBounds(12, 70, 669, 149);
			bjLabel7 = new JLabel();
			bjLabel6 = new JLabel();
			bjLabel5 = new JLabel();
			bjLabel4 = new JLabel();
			bjLabel4.setBounds(66, 116, 305, 22);
			bjLabel4.setText("Dýþ kuru termometre sýcaklýðýný giriniz (Tdýþ, C):");
			bjLabel5.setBounds(66, 86, 305, 22);
			bjLabel5.setText("Ýç kuru termometre sýcaklýðýný giriniz (Tiç, C)");
			bjLabel6.setText("Dýþ özgül nemi giriniz (w1, gr/kg) :");
			bjLabel6.setBounds(66, 55, 305, 22);
			bjLabel7.setText("Ýç özgül nemi giriniz (w2, gr/kg) :");
			bjLabel7.setBounds(66, 26, 305, 21);
			bjPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dizayn Þartlarý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			bjPanel6.add(bjLabel7, null);
			bjPanel6.add(bjLabel6, null);
			bjPanel6.add(bjLabel5, null);
			bjPanel6.add(bjLabel4, null);
			bjPanel6.add(getDisSicaklikTextField(), null);
			bjPanel6.add(getDisOzgulNemTextField(), null);
			bjPanel6.add(getIcOzgulNemTextField(), null);
			bjPanel6.add(getIcKuruTermometreSicakligi(), null);
		}
		return bjPanel6;
	}
	/**
	 * This method initializes bjButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBJButton3() {
		if (bjButton3 == null) {
			bjButton3 = new JButton();
			bjButton3.setText("Ýleri >>");
			bjButton3.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					showPanel(1);
				}
			});
		}
		return bjButton3;
	}
	/**
	 * This method initializes bjPanel7	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel7() {
		if (bjPanel7 == null) {
			bjPanel7 = new JPanel();
			bjPanel7.setLayout(new FlowLayout());
			bjPanel7.setBounds(13, 422, 693, 40);
			bjPanel7.add(getBJButton3(), null);
		}
		return bjPanel7;
	}
	/**
	 * This method initializes catiAlaniTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getCatiAlaniTextField() {
		if (catiAlaniTextField == null) {
			catiAlaniTextField = new JTextField();
			catiAlaniTextField.setBounds(328, 16, 112, 21);
			catiAlaniTextField.setEnabled(false);
			catiAlaniTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					catiAlaniTextField.setText("");
				}
			});
		}
		return catiAlaniTextField;
	}
	/**
	 * This method initializes catiUTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getCatiUTextField() {
		if (catiUTextField == null) {
			catiUTextField = new JTextField();
			catiUTextField.setBounds(328, 42, 112, 21);
			catiUTextField.setEnabled(false);
			catiUTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					catiUTextField.setText("");
				}
			});
		}
		return catiUTextField;
	}
	/**
	 * This method initializes disDuvarIsiTransferKatsayisiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getDisDuvarIsiTransferKatsayisiTextField() {
		if (disDuvarIsiTransferKatsayisiTextField == null) {
			disDuvarIsiTransferKatsayisiTextField = new JTextField();
			disDuvarIsiTransferKatsayisiTextField.setBounds(344, 123, 99, 20);
			disDuvarIsiTransferKatsayisiTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					disDuvarIsiTransferKatsayisiTextField.setText("");
				}
			});
		}
		return disDuvarIsiTransferKatsayisiTextField;
	}
	/**
	 * This method initializes catiTipiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getCatiTipiComboBox() {
		if (catiTipiComboBox == null) {
		    Object[] values = CatiCLTDs.getInstance().getCltdsArray();
			catiTipiComboBox = new JComboBox(values);
			catiTipiComboBox.setBounds(328, 68, 335, 21);
			catiTipiComboBox.setEnabled(false);
		}
		return catiTipiComboBox;
	}
	/**
	 * This method initializes pencereIsiTransferKatsayisiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getPencereIsiTransferKatsayisiTextField() {
		if (pencereIsiTransferKatsayisiTextField == null) {
			pencereIsiTransferKatsayisiTextField = new JTextField();
			pencereIsiTransferKatsayisiTextField.setBounds(344, 148, 99, 20);
			pencereIsiTransferKatsayisiTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					pencereIsiTransferKatsayisiTextField.setText("");
				}
			});
		}
		return pencereIsiTransferKatsayisiTextField;
	}
	/**
	 * This method initializes icDuvarIsiTransferKatsayisiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIcDuvarIsiTransferKatsayisiTextField() {
		if (icDuvarIsiTransferKatsayisiTextField == null) {
			icDuvarIsiTransferKatsayisiTextField = new JTextField();
			icDuvarIsiTransferKatsayisiTextField.setBounds(329, 57, 100, 20);
			icDuvarIsiTransferKatsayisiTextField.setEnabled(false);
			icDuvarIsiTransferKatsayisiTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					icDuvarIsiTransferKatsayisiTextField.setText("");
				}
			});
		}
		return icDuvarIsiTransferKatsayisiTextField;
	}
	/**
	 * This method initializes sicaklikFarkiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getSicaklikFarkiTextField() {
		if (sicaklikFarkiTextField == null) {
			sicaklikFarkiTextField = new JTextField();
			sicaklikFarkiTextField.setBounds(329, 32, 100, 20);
			sicaklikFarkiTextField.setEnabled(false);
			sicaklikFarkiTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					sicaklikFarkiTextField.setText("");
				}
			});
		}
		return sicaklikFarkiTextField;
	}
	/**
	 * This method initializes bjButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBJButton4() {
		if (bjButton4 == null) {
			bjButton4 = new JButton();
			bjButton4.setText("Ýleri >>");
			bjButton4.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					showPanel(2);
				}
			});
		}
		return bjButton4;
	}
	/**
	 * This method initializes bjButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBJButton5() {
		if (bjButton5 == null) {
			bjButton5 = new JButton();
			bjButton5.setText("<< Geri");
			bjButton5.setActionCommand("<< Geri");
			bjButton5.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					showPanel(0);
				}
			});
		}
		return bjButton5;
	}
	/**
	 * This method initializes iletimIsiKazanciTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIletimIsiKazanciTextField() {
		if (iletimIsiKazanciTextField == null) {
			iletimIsiKazanciTextField = new JTextField();
			iletimIsiKazanciTextField.setBounds(432, 342, 99, 20);
			iletimIsiKazanciTextField.setEnabled(true);
			iletimIsiKazanciTextField.setEditable(false);
			iletimIsiKazanciTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					iletimIsiKazanciTextField.setText("");
				}
			});
		}
		return iletimIsiKazanciTextField;
	}
	/**
	 * This method initializes bjPanel8	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel8() {
		if (bjPanel8 == null) {
			bjPanel8 = new JPanel();
			bjPanel8.add(getGolgelemesizTekPencereRadioButton(), null);
			bjPanel8.add(getGolgelemesizCiftPencereRadioButton(), null);
			bjPanel8.add(getGolgelemeliCiftPencereRadioButton(), null);
			bjPanel8.setLayout(new BoxLayout(bjPanel8, BoxLayout.Y_AXIS));
			bjPanel8.setBounds(16, 10, 685, 97);
			bjPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pencere tipini belirleyiniz", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
		}
		return bjPanel8;
	}
	/**
	 * This method initializes bjPanel13	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel13() {
		if (bjPanel13 == null) {
			bjPanel13 = new JPanel();
			bjPanel13.setLayout(null);
			bjPanel13.setBounds(15, 110, 685, 48);
			bjPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cam tipini seçiniz", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			bjPanel13.add(getNormalCamRadioButton(), null);
			bjPanel13.add(getIsiAbsorbsiyonluCamRadioButton(), null);
			bjPanel13.add(getNormalCiftCamRadioButton(), null);
		}
		return bjPanel13;
	}
	/**
	 * This method initializes bjPanel14	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel14() {
		if (bjPanel14 == null) {
			bjPanel14 = new JPanel();
			bjLabel22 = new JLabel();
			bjPanel14.setLayout(null);
			bjPanel14.setBounds(16, 163, 685, 42);
			bjLabel22.setBounds(9, 8, 181, 22);
			bjLabel22.setText("Cam kalýnlýðýný seçiniz (mm) :");
			bjPanel14.add(bjLabel22, null);
			bjPanel14.add(getCamKalinligiComboBox(), null);
		}
		return bjPanel14;
	}
	/**
	 * This method initializes bjPanel15	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel15() {
		if (bjPanel15 == null) {
			bjPanel15 = new JPanel();
			bjPanel15.setLayout(null);
			bjPanel15.setBounds(16, 209, 222, 54);
			bjPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jaluzi rengini seçiniz", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			bjPanel15.add(getKoyuJaluziRadioButton(), null);
			bjPanel15.add(getAcikJaluziRadioButton(), null);
		}
		return bjPanel15;
	}
	/**
	 * This method initializes bjPanel16	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel16() {
		if (bjPanel16 == null) {
			bjPanel16 = new JPanel();
			bjPanel16.add(getAynaTipiComboBox(), null);
			bjPanel16.setLayout(null);
			bjPanel16.setBounds(250, 209, 451, 160);
			bjPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ýç gölgeleme yapýlan camýn tipini seçiniz", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			bjPanel16.add(getNormalCamKalinligi3RadioButton(), null);
			bjPanel16.add(getNormalCamKalinligi6RadioButton(), null);
			bjPanel16.add(getAbsorbsiyonluCamKalinligi6RadioButton(), null);
			bjPanel16.add(getAynaliCamRadioButton(), null);
		}
		return bjPanel16;
	}
	/**
	 * This method initializes bjPanel17	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel17() {
		if (bjPanel17 == null) {
			bjPanel17 = new JPanel();
			bjPanel17.setLayout(null);
			bjPanel17.setBounds(16, 265, 222, 105);
			bjPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dikey perde tipini seçiniz", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			bjPanel17.add(getKoyuPerdeRadioButton(), null);
			bjPanel17.add(getAcikPerdeRadioButton(), null);
			bjPanel17.add(getIsikGecirgenPerdeRadioButton(), null);
		}
		return bjPanel17;
	}
	/**
	 * This method initializes golgelemesizTekPencereRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getGolgelemesizTekPencereRadioButton() {
		if (golgelemesizTekPencereRadioButton == null) {
			golgelemesizTekPencereRadioButton = new JRadioButton();
			golgelemesizTekPencereRadioButton.setText("Ýç gölgeleme yapýlmamýþ, tek camlý pencereler");
			golgelemesizTekPencereRadioButton.setActionCommand("GYT");
			pencereTipiBGroup.add(golgelemesizTekPencereRadioButton);
		}
		return golgelemesizTekPencereRadioButton;
	}
	/**
	 * This method initializes golgelemesizCiftPencereRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getGolgelemesizCiftPencereRadioButton() {
		if (golgelemesizCiftPencereRadioButton == null) {
			golgelemesizCiftPencereRadioButton = new JRadioButton();
			golgelemesizCiftPencereRadioButton.setText("Ýç gölgeleme yapýlmamýþ, çift camlý pencereler");
			golgelemesizCiftPencereRadioButton.setActionCommand("GYC");
			pencereTipiBGroup.add(golgelemesizCiftPencereRadioButton);
		}
		return golgelemesizCiftPencereRadioButton;
	}
	/**
	 * This method initializes camKalinligiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getCamKalinligiComboBox() {
		if (camKalinligiComboBox == null) {
			camKalinligiComboBox = new JComboBox();
			camKalinligiComboBox.setBounds(196, 8, 107, 22);
			camKalinligiComboBox.addItem("3 mm");
			camKalinligiComboBox.addItem("6 mm");
			camKalinligiComboBox.addItem("10 mm");
			camKalinligiComboBox.addItem("12 mm");
		}
		return camKalinligiComboBox;
	}
	/**
	 * This method initializes koyuJaluziRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getKoyuJaluziRadioButton() {
		if (koyuJaluziRadioButton == null) {
			koyuJaluziRadioButton = new JRadioButton();
			koyuJaluziRadioButton.setBounds(7, 26, 65, 21);
			koyuJaluziRadioButton.setText("Koyu");
			koyuJaluziRadioButton.setActionCommand("JK");
			koyuJaluziRadioButton.setEnabled(false);
			golgeTipiBGroup.add(koyuJaluziRadioButton);
		}
		return koyuJaluziRadioButton;
	}
	/**
	 * This method initializes acikJaluziRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getAcikJaluziRadioButton() {
		if (acikJaluziRadioButton == null) {
			acikJaluziRadioButton = new JRadioButton();
			acikJaluziRadioButton.setBounds(103, 26, 60, 21);
			acikJaluziRadioButton.setText("Açýk");
			acikJaluziRadioButton.setActionCommand("JA");
			acikJaluziRadioButton.setEnabled(false);
			golgeTipiBGroup.add(acikJaluziRadioButton);
		}
		return acikJaluziRadioButton;
	}
	/**
	 * This method initializes koyuPerdeRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getKoyuPerdeRadioButton() {
		if (koyuPerdeRadioButton == null) {
			koyuPerdeRadioButton = new JRadioButton();
			koyuPerdeRadioButton.setBounds(10, 18, 135, 24);
			koyuPerdeRadioButton.setText("Koyu");
			koyuPerdeRadioButton.setActionCommand("PK");
			koyuPerdeRadioButton.setEnabled(false);
			golgeTipiBGroup.add(koyuPerdeRadioButton);
		}
		return koyuPerdeRadioButton;
	}
	/**
	 * This method initializes acikPerdeRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getAcikPerdeRadioButton() {
		if (acikPerdeRadioButton == null) {
			acikPerdeRadioButton = new JRadioButton();
			acikPerdeRadioButton.setBounds(10, 42, 141, 23);
			acikPerdeRadioButton.setText("Açýk");
			acikPerdeRadioButton.setActionCommand("PA");
			acikPerdeRadioButton.setEnabled(false);
			golgeTipiBGroup.add(acikPerdeRadioButton);
		}
		return acikPerdeRadioButton;
	}
	/**
	 * This method initializes isikGecirgenRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getIsikGecirgenPerdeRadioButton() {
		if (isikGecirgenRadioButton == null) {
			isikGecirgenRadioButton = new JRadioButton();
			isikGecirgenRadioButton.setBounds(10, 65, 165, 24);
			isikGecirgenRadioButton.setText("Iþýk geçirgen");
			isikGecirgenRadioButton.setActionCommand("PI");
			isikGecirgenRadioButton.setEnabled(false);
			golgeTipiBGroup.add(isikGecirgenRadioButton);
		}
		return isikGecirgenRadioButton;
	}
	/**
	 * This method initializes normalCamKalinligi3RadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getNormalCamKalinligi3RadioButton() {
		if (normalCamKalinligi3RadioButton == null) {
			normalCamKalinligi3RadioButton = new JRadioButton();
			normalCamKalinligi3RadioButton.setBounds(14, 21, 363, 23);
			normalCamKalinligi3RadioButton.setText("Normal Ýç/Dýþ, cam kalýnlýðý 3 mm");
			normalCamKalinligi3RadioButton.setActionCommand("N3");
			normalCamKalinligi3RadioButton.setEnabled(false);
			icCamTipiBGroup.add(normalCamKalinligi3RadioButton);
		}
		return normalCamKalinligi3RadioButton;
	}
	/**
	 * This method initializes normalCamKalinligi6RadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getNormalCamKalinligi6RadioButton() {
		if (normalCamKalinligi6RadioButton == null) {
			normalCamKalinligi6RadioButton = new JRadioButton();
			normalCamKalinligi6RadioButton.setBounds(14, 49, 363, 24);
			normalCamKalinligi6RadioButton.setText("Normal Ýç/Dýþ, cam kalýnlýðý 6 mm");
			normalCamKalinligi6RadioButton.setActionCommand("N6");
			normalCamKalinligi6RadioButton.setEnabled(false);
			icCamTipiBGroup.add(normalCamKalinligi6RadioButton);
		}
		return normalCamKalinligi6RadioButton;
	}
	/**
	 * This method initializes absorbsiyonluCamKalinligi6RadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getAbsorbsiyonluCamKalinligi6RadioButton() {
		if (absorbsiyonluCamKalinligi6RadioButton == null) {
			absorbsiyonluCamKalinligi6RadioButton = new JRadioButton();
			absorbsiyonluCamKalinligi6RadioButton.setBounds(14, 77, 363, 23);
			absorbsiyonluCamKalinligi6RadioButton.setText("Dýþ ýsý absorbsiyonlu, iç normal, cam kalýnlýðý 6 mm");
			absorbsiyonluCamKalinligi6RadioButton.setActionCommand("D6");
			absorbsiyonluCamKalinligi6RadioButton.setEnabled(false);
			icCamTipiBGroup.add(absorbsiyonluCamKalinligi6RadioButton);
		}
		return absorbsiyonluCamKalinligi6RadioButton;
	}
	/**
	 * This method initializes aynaliCamRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getAynaliCamRadioButton() {
		if (aynaliCamRadioButton == null) {
			aynaliCamRadioButton = new JRadioButton();
			aynaliCamRadioButton.setBounds(14, 103, 113, 24);
			aynaliCamRadioButton.setText("Aynalý cam");
			aynaliCamRadioButton.setActionCommand("A");
			aynaliCamRadioButton.setEnabled(false);
			aynaliCamRadioButton.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
					if(getAynaliCamRadioButton().isSelected()==true) getAynaTipiComboBox().setEnabled(true);
					else getAynaTipiComboBox().setEnabled(false);
				}
			});
			icCamTipiBGroup.add(aynaliCamRadioButton);
		}
		return aynaliCamRadioButton;
	}
	/**
	 * This method initializes normalCamRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getNormalCamRadioButton() {
		if (normalCamRadioButton == null) {
			normalCamRadioButton = new JRadioButton();
			normalCamRadioButton.setBounds(8, 20, 86, 21);
			normalCamRadioButton.setText("Normal");
			normalCamRadioButton.setActionCommand("Normal");
			camTipiBGroup.add(normalCamRadioButton);
		}
		return normalCamRadioButton;
	}
	/**
	 * This method initializes isiAbsorbsiyonluCamRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getIsiAbsorbsiyonluCamRadioButton() {
		if (isiAbsorbsiyonluCamRadioButton == null) {
			isiAbsorbsiyonluCamRadioButton = new JRadioButton();
			isiAbsorbsiyonluCamRadioButton.setBounds(106, 20, 173, 21);
			isiAbsorbsiyonluCamRadioButton.setText("Isý absorbsiyonlu (renkli)");
			isiAbsorbsiyonluCamRadioButton.setActionCommand("Isý Absorblama");
			camTipiBGroup.add(isiAbsorbsiyonluCamRadioButton);
		}
		return isiAbsorbsiyonluCamRadioButton;
	}
	/**
	 * This method initializes normalCiftCamRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getNormalCiftCamRadioButton() {
		if (normalCiftCamRadioButton == null) {
			normalCiftCamRadioButton = new JRadioButton();
			normalCiftCamRadioButton.setBounds(287, 20, 182, 21);
			normalCiftCamRadioButton.setText("Normal çift camlý pencere");
			normalCiftCamRadioButton.setActionCommand("Normal çift camlý pencere");
			camTipiBGroup.add(normalCiftCamRadioButton);
		}
		return normalCiftCamRadioButton;
	}
	/**
	 * This method initializes bjPanel18	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel18() {
		if (bjPanel18 == null) {
			bjPanel18 = new JPanel();
			bjPanel18.setLayout(new FlowLayout());
			bjPanel18.setLocation(13, 422);
			bjPanel18.setSize(693, 40);
			bjPanel18.add(getBJButton8(), null);
			bjPanel18.add(getBJButton7(), null);
		}
		return bjPanel18;
	}
	/**
	 * This method initializes bjButton7	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBJButton7() {
		if (bjButton7 == null) {
			bjButton7 = new JButton();
			bjButton7.setText("Ýleri >>");
			bjButton7.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					showPanel(3);
				}
			});
		}
		return bjButton7;
	}
	/**
	 * This method initializes bjButton8	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBJButton8() {
		if (bjButton8 == null) {
			bjButton8 = new JButton();
			bjButton8.setText("<< Geri");
			bjButton8.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					showPanel(1);
				}
			});
		}
		return bjButton8;
	}
	/**
	 * This method initializes direktGunesYukuTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getDirektGunesYukuTextField() {
		if (direktGunesYukuTextField == null) {
			direktGunesYukuTextField = new JTextField();
			direktGunesYukuTextField.setBounds(380, 380, 123, 23);
			direktGunesYukuTextField.setEditable(false);
		}
		return direktGunesYukuTextField;
	}
	/**
	 * This method initializes bjPanel20	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel20() {
		if (bjPanel20 == null) {
			bjPanel20 = new JPanel();
			bjPanel20.setLayout(null);
			bjPanel20.setBounds(89, 189, 252, 46);
			bjPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aydýnlatma süresi(saat) :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
			bjPanel20.add(getAydinlanmaSuresi8RadioButton(), null);
			bjPanel20.add(getAydinlanmaSuresi12RadioButton(), null);
		}
		return bjPanel20;
	}
	/**
	 * This method initializes bjPanel21	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel21() {
		if (bjPanel21 == null) {
			bjPanel21 = new JPanel();
			bjPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Iþýklar yandýktan sonra geçen zaman(saat) :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			bjPanel21.setLayout(null);
			bjPanel21.setBounds(348, 189, 276, 46);
			bjPanel21.add(getIsikSonrasiZamanComboBox(), null);
		}
		return bjPanel21;
	}
	/**
	 * This method initializes bjPanel22	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel22() {
		if (bjPanel22 == null) {
			bjPanel22 = new JPanel();
			bjPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			bjPanel22.add(getEkipmanlarIsiKazanciTextField(), null);
			jLabel14 = new JLabel();
			jLabel13 = new JLabel();
			bjLabel34 = new JLabel();
			bjLabel35 = new JLabel();
			jLabel13.setText("Mahal içindeki cihazlarýn toplam anma gücü (P, Watt)");
			jLabel14.setBounds(12, 65, 323, 21);
			jLabel14.setText("Ekipmanlardan gelen ýsý kazancý (Qe,Watt)");
			bjPanel22.add(jLabel14, null);
			bjPanel22.setLayout(null);
			bjPanel22.setBounds(14, 326, 682, 91);
			bjLabel34.setBounds(12, 9, 323, 21);
			bjLabel34.setText("Aydýnlatma elemanlarýnýn toplam gücünü giriniz (N, Watt)");
			bjLabel35.setBounds(11, 39, 323, 21);
			bjLabel35.setText("Aydýnlatma ýsý kazancý (Qýþýk, Watt) ");
			jLabel13.setBounds(9, 8, 323, 21);
			bjPanel22.add(bjLabel34, null);
			bjPanel22.add(bjLabel35, null);
			bjPanel22.add(getAydinlanmaElemanlariToplamGucTextField(), null);
			bjPanel22.add(getAydinlatmaIsiKazanciTextField(), null);
		}
		return bjPanel22;
	}
	/**
	 * This method initializes bjPanel23	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel23() {
		if (bjPanel23 == null) {
			bjPanel23 = new JPanel();
			bjPanel23.setLayout(new FlowLayout());
			bjPanel23.setLocation(13, 422);
			bjPanel23.setSize(682, 40);
			bjPanel23.add(getBJButton12(), null);
			bjPanel23.add(getBJButton11(), null);
		}
		return bjPanel23;
	}
	/**
	 * This method initializes bjPanel24	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel24() {
		if (bjPanel24 == null) {
			bjPanel24 = new JPanel();
			bjPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ýklimlendirme, havalandýrma, mobilya tipi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			bjPanel24.add(getMobilyaTipiComboBox(), null);			
			jLabel12 = new JLabel();
			bjLabel29 = new JLabel();
			bjLabel30 = new JLabel();
			bjLabel31 = new JLabel();
			bjLabel32 = new JLabel();
			jLabel12.setBounds(6, 24, 77, 22);
			jLabel12.setText("Tip");
			bjPanel24.setLayout(null);
			bjPanel24.setBounds(14, 7, 682, 176);
			bjLabel29.setBounds(6, 53, 670, 22);
			bjLabel29.setText("A: Halýsýz, aðýr basit mobilya, düþük debili iklimlendirme, aydýnlatma havalandýrma yok");
			bjLabel30.setBounds(6, 83, 670, 22);
			bjLabel30.setText("B: Halýsýz, normal mobilya, orta veya yüksek debili iklimlendirme, aydýnlatma havalandýrma yok. ");
			bjLabel31.setBounds(6, 115, 670, 22);
			bjLabel31.setText("C: Halýlý veya halýsýz normal mobilya, orta veya yüksek debili iklimlendirme veya fan-coil, aydýnlatma havalandýrýlýyor.");
			bjLabel32.setBounds(6, 147, 670, 22);
			bjLabel32.setText("D: Herhangi bir tür mobilya, aydýnlatma elemanlarý ayrý kanallarla havalandýrýlýr.");
			bjPanel24.add(jLabel12, null);
			bjPanel24.add(bjLabel29, null);
			bjPanel24.add(bjLabel30, null);
			bjPanel24.add(bjLabel31, null);
			bjPanel24.add(bjLabel32, null);
		}
		return bjPanel24;
	}
	/**
	 * This method initializes aydinlanmaSuresi8RadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getAydinlanmaSuresi8RadioButton() {
		if (aydinlanmaSuresi8RadioButton == null) {
			aydinlanmaSuresi8RadioButton = new JRadioButton();
			aydinlanmaSuresi8RadioButton.setBounds(49, 16, 53, 20);
			aydinlanmaSuresi8RadioButton.setText("8");
			aydinlatmaSuresiBGroup.add(aydinlanmaSuresi8RadioButton);
		}
		return aydinlanmaSuresi8RadioButton;
	}
	/**
	 * This method initializes aydinlanmaSuresi12RadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getAydinlanmaSuresi12RadioButton() {
		if (aydinlanmaSuresi12RadioButton == null) {
			aydinlanmaSuresi12RadioButton = new JRadioButton();
			aydinlanmaSuresi12RadioButton.setBounds(123, 15, 56, 23);
			aydinlanmaSuresi12RadioButton.setText("12");
			aydinlatmaSuresiBGroup.add(aydinlanmaSuresi12RadioButton);
		}
		return aydinlanmaSuresi12RadioButton;
	}
	/**
	 * This method initializes isikSonrasiZamanComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getIsikSonrasiZamanComboBox() {
		if (isikSonrasiZamanComboBox == null) {
		    String[] saatler = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
			isikSonrasiZamanComboBox = new JComboBox(saatler);
			isikSonrasiZamanComboBox.setBounds(83, 18, 100, 22);
			for(int i=1; i<=24; i++) {
			    isikSonrasiZamanComboBox.addItem(i+"");
			}
		}
		return isikSonrasiZamanComboBox;
	}
	/**
	 * This method initializes aydinlanmaElemanlariToplamGucTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getAydinlanmaElemanlariToplamGucTextField() {
		if (aydinlanmaElemanlariToplamGucTextField == null) {
			aydinlanmaElemanlariToplamGucTextField = new JTextField();
			aydinlanmaElemanlariToplamGucTextField.setBounds(340, 9, 128, 21);
			aydinlanmaElemanlariToplamGucTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					aydinlanmaElemanlariToplamGucTextField.setText("");
				}
			});
			
		}
		return aydinlanmaElemanlariToplamGucTextField;
	}
	/**
	 * This method initializes aydinlatmaIsiKazanciTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getAydinlatmaIsiKazanciTextField() {
		if (aydinlatmaIsiKazanciTextField == null) {
			aydinlatmaIsiKazanciTextField = new JTextField();
			aydinlatmaIsiKazanciTextField.setEditable(false);
			aydinlatmaIsiKazanciTextField.setBounds(340, 39, 128, 21);
		}
		return aydinlatmaIsiKazanciTextField;
	}
	/**
	 * This method initializes bjButton11	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBJButton11() {
		if (bjButton11 == null) {
			bjButton11 = new JButton();
			bjButton11.setText("Ýleri >>");
			bjButton11.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					showPanel(4);
				}
			});
		}
		return bjButton11;
	}
	/**
	 * This method initializes bjButton12	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBJButton12() {
		if (bjButton12 == null) {
			bjButton12 = new JButton();
			bjButton12.setText("<< Geri");
			bjButton12.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					showPanel(2);
				}
			});
		}
		return bjButton12;
	}
	/**
	 * This method initializes bjPanel25	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	public JPanel getBJPanel25() {
		if (bjPanel25 == null) {
			jLabel18 = new JLabel();
			jLabel15 = new JLabel();
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			bjPanel25 = new JPanel();
			bjLabel36 = new JLabel();
			bjLabel37 = new JLabel();
			bjLabel38 = new JLabel();
			bjLabel39 = new JLabel();
			bjLabel40 = new JLabel();
			bjLabel41 = new JLabel();
			bjPanel25.setLayout(null);
			bjPanel25.setBounds(5, 5, 688, 413);
			bjLabel36.setText("Mahal içinde bulunan insalarýn aktivite türünü belirleyiniz.");
			bjLabel36.setBounds(10, 9, 391, 24);
			bjLabel37.setText("Aktivite türü :");
			bjLabel37.setBounds(10, 40, 84, 24);
			bjLabel38.setText("Hacime girdikten sonra geçen zamaný seçiniz(saat) :");
			bjLabel38.setBounds(10, 138, 300, 24);
			bjLabel39.setText("Hacimdeki insan sayýsýný giriniz (s) :");
			bjLabel39.setBounds(10, 105, 300, 24);
			bjLabel40.setText("Hacimde kalma süresi (saat)");
			bjLabel40.setBounds(10, 72, 300, 24);
			bjLabel41.setText("Ýnsanlardan olan ýsý kazancý (Qinsan, W) :");
			bjLabel41.setBounds(10, 169, 300, 24);
			jLabel.setText("Enfiltrasyon ve Havalandýrma Yükü :");
			jLabel.setBounds(10, 37, 236, 24);
			jLabel1.setBounds(17, 329, 231, 24);
			jLabel1.setText("<html><body>Toplam Isý Kazancý Q<sub>K</sub></body></html>");
			jLabel15.setBounds(17, 366, 231, 24);
			jLabel15.setText("Seçilen klima modeli");
			jLabel18.setBounds(373, 329, 34, 24);
			jLabel18.setText("Watt");
			bjPanel25.add(jLabel1, null);
			bjPanel25.add(getToplamIsiKazanciTextField(), null);
			bjPanel25.add(getJPanel5(), null);
			bjPanel25.add(getJPanel6(), null);
			bjPanel25.add(jLabel15, null);
			bjPanel25.add(getSecilenKlimaTextField(), null);
			bjPanel25.add(getKlimaSecButton(), null);
			bjPanel25.add(jLabel18, null);
		}
		return bjPanel25;
	}
	/**
	 * This method initializes bjPanel26	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBJPanel26() {
		if (bjPanel26 == null) {
			bjPanel26 = new JPanel();
			bjPanel26.setLayout(new FlowLayout());
			bjPanel26.setLocation(13, 422);
			bjPanel26.setSize(693, 40);
			bjPanel26.add(getBJButton16(), null);
		}
		return bjPanel26;
	}
	/**
	 * This method initializes aktivitelerComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getAktivitelerComboBox() {
		if (aktivitelerComboBox == null) {
		    ArrayList aktiviteler = AktiviteCatalog.getInstance().getAktiviteler();
			aktivitelerComboBox = new JComboBox(aktiviteler.toArray());
			aktivitelerComboBox.setSize(294, 24);
			aktivitelerComboBox.setLocation(107, 40);
			aktivitelerComboBox.setPreferredSize(new java.awt.Dimension(100,10));
		}
		return aktivitelerComboBox;
	}
	/**
	 * This method initializes insanlardanIsiKazanciTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getInsanlardanIsiKazanciTextField() {
		if (insanlardanIsiKazanciTextField == null) {
			insanlardanIsiKazanciTextField = new JTextField();
			insanlardanIsiKazanciTextField.setEditable(false);
			insanlardanIsiKazanciTextField.setBounds(315, 169, 99, 24);
		}
		return insanlardanIsiKazanciTextField;
	}
	/**
	 * This method initializes insanSayisiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getInsanSayisiTextField() {
		if (insanSayisiTextField == null) {
			insanSayisiTextField = new JTextField();
			insanSayisiTextField.setBounds(315, 105, 99, 24);
			insanSayisiTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					insanSayisiTextField.setText("");
				}
			});
		}
		return insanSayisiTextField;
	}
	/**
	 * This method initializes bjButton16	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBJButton16() {
		if (bjButton16 == null) {
			bjButton16 = new JButton();
			bjButton16.setText("<< Geri");
			bjButton16.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					showPanel(3);
				}
			});
		}
		return bjButton16;
	}
	/********************************************************/
	/********************* BUSINESS METHODS *****************/
	/********************************************************/
	private void showPanel(int panelIndex) {
	    jTabbedPane.setSelectedIndex(panelIndex);
	}
	
	private void resetPanel(JPanel panel) {
	    for(int i=0; i<panel.getComponentCount(); i++) {
	        Component component = panel.getComponent(i);
	        if(component instanceof JTextComponent) {
	            ((JTextComponent)component).setText("");
	        }else if(component instanceof JToggleButton) {
	            ((JToggleButton)component).setSelected(false);
	        }else if(component instanceof JComboBox) {
	            JComboBox comboBox = (JComboBox)component;
	            if(comboBox.getModel().getSize() > 0) {
	                comboBox.setSelectedIndex(0);
	            }
	        }
	    }
	}
	/**
	 * This method initializes enfiltrasyonHavalandirmaYukuTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getEnfiltrasyonHavalandirmaYukuTextField() {
		if (enfiltrasyonHavalandirmaYukuTextField == null) {
			enfiltrasyonHavalandirmaYukuTextField = new JTextField();
			enfiltrasyonHavalandirmaYukuTextField.setEditable(false);
			enfiltrasyonHavalandirmaYukuTextField.setBounds(250, 37, 99, 24);
		}
		return enfiltrasyonHavalandirmaYukuTextField;
	}
	/**
	 * This method initializes toplamIsiKazanciTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getToplamIsiKazanciTextField() {
		if (toplamIsiKazanciTextField == null) {
			toplamIsiKazanciTextField = new JTextField();
			toplamIsiKazanciTextField.setBounds(254, 329, 99, 24);
			toplamIsiKazanciTextField.setEditable(false);
		}
		return toplamIsiKazanciTextField;
	}
	// Add action listeners	
	/**
	 * This method initializes disDuvarList	
	 * 	
	 * @return javax.swing.JList	
	 */    
	private JList getDisDuvarList() {
		if (disDuvarList == null) {
		    DefaultListModel model = new DefaultListModel();
			disDuvarList = new JList(model);
		}
		return disDuvarList;
	}
	/**
	 * This method initializes pencereList	
	 * 	
	 * @return javax.swing.JList	
	 */    
	private JList getPencereList() {
		if (pencereList == null) {
		    DefaultListModel model = new DefaultListModel();
			pencereList = new JList(model);
		}
		return pencereList;
	}
	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jLabel7 = new JLabel();
			jLabel6 = new JLabel();
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duvarlar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel1.setBounds(25, 224, 316, 186);
			jLabel6.setBounds(34, 120, 84, 26);
			jLabel6.setText("Alan");
			jLabel7.setBounds(34, 150, 84, 26);
			jLabel7.setText("Yön");
			jPanel1.add(getJScrollPane(), null);
			jPanel1.add(getDuvarEkleButton(), null);
			jPanel1.add(getDuvarSilButton(), null);
			jPanel1.add(jLabel6, null);
			jPanel1.add(jLabel7, null);
			jPanel1.add(getDuvarAlaniTextField(), null);
			jPanel1.add(getDuvarYonuComboBox(), null);
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
			jLabel9 = new JLabel();
			jLabel8 = new JLabel();
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pencereler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel2.setBounds(353, 224, 314, 186);
			jLabel8.setText("Alan");
			jLabel8.setLocation(34, 120);
			jLabel8.setSize(84, 26);
			jLabel9.setText("Yön");
			jLabel9.setLocation(34, 150);
			jLabel9.setSize(84, 26);
			jPanel2.add(getPencereEkleButton(), null);
			jPanel2.add(getPencereSilButton(), null);
			jPanel2.add(jLabel8, null);
			jPanel2.add(jLabel9, null);
			jPanel2.add(getPencereAlaniTextField(), null);
			jPanel2.add(getPencereYonuComboBox(), null);
			jPanel2.add(getJScrollPane1(), null);
		}
		return jPanel2;
	}
	/**
	 * This method initializes duvarEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getDuvarEkleButton() {
		if (duvarEkleButton == null) {
			duvarEkleButton = new JButton();
			duvarEkleButton.setText("Ekle");
			duvarEkleButton.setLocation(33, 22);
			duvarEkleButton.setSize(72, 26);
		}
		return duvarEkleButton;
	}
	/**
	 * This method initializes duvarSilButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getDuvarSilButton() {
		if (duvarSilButton == null) {
			duvarSilButton = new JButton();
			duvarSilButton.setText("Sil");
			duvarSilButton.setLocation(34, 69);
			duvarSilButton.setSize(72, 26);
		}
		return duvarSilButton;
	}
	/**
	 * This method initializes pencereEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getPencereEkleButton() {
		if (pencereEkleButton == null) {
			pencereEkleButton = new JButton();
			pencereEkleButton.setLocation(33, 22);
			pencereEkleButton.setSize(72, 26);
			pencereEkleButton.setText("Ekle");
		}
		return pencereEkleButton;
	}
	/**
	 * This method initializes pencereSilButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getPencereSilButton() {
		if (pencereSilButton == null) {
			pencereSilButton = new JButton();
			pencereSilButton.setText("Sil");
			pencereSilButton.setSize(72, 26);
			pencereSilButton.setLocation(34, 69);
		}
		return pencereSilButton;
	}
	/**
	 * This method initializes mustakilMahalCheckBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */    
	private JCheckBox getMustakilMahalCheckBox() {
		if (mustakilMahalCheckBox == null) {
			mustakilMahalCheckBox = new JCheckBox();
			mustakilMahalCheckBox.setText("Hesabý yapýlacak mahalin üstü çatý");
			mustakilMahalCheckBox.setBounds(15, 13, 250, 21);
		}
		return mustakilMahalCheckBox;
	}
	/**
	 * This method initializes hesapAyiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getHesapAyiComboBox() {
		if (hesapAyiComboBox == null) {
		    String[] aylar = {"Ocak","Þubat","Mart","Nisan","Mayýs","Haziran","Temmuz","Aðustos","Eylül","Ekim","Kasým","Aralýk"};
			hesapAyiComboBox = new JComboBox(aylar);
			hesapAyiComboBox.setBounds(287, 38, 114, 21);
		}
		return hesapAyiComboBox;
	}
	/**
	 * This method initializes hesapSaatiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getHesapSaatiComboBox() {
		if (hesapSaatiComboBox == null) {
		    String[] saatler = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
			hesapSaatiComboBox = new JComboBox(saatler);
			hesapSaatiComboBox.setBounds(413, 38, 114, 21);
		}
		return hesapSaatiComboBox;
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
			jPanel.setBounds(17, 12, 671, 96);
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Çatý Bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel.add(bjLabel9, null);
			jPanel.add(bjLabel10, null);
			jPanel.add(bjLabel11, null);
			jPanel.add(getCatiTipiComboBox(), null);
			jPanel.add(getCatiAlaniTextField(), null);
			jPanel.add(getCatiUTextField(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes duvarAlaniTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getDuvarAlaniTextField() {
		if (duvarAlaniTextField == null) {
			duvarAlaniTextField = new JTextField();
			duvarAlaniTextField.setBounds(131, 120, 110, 26);
			duvarAlaniTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					duvarAlaniTextField.setText("");
				}
			});
		}
		return duvarAlaniTextField;
	}
	/**
	 * This method initializes duvarYonuComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getDuvarYonuComboBox() {
		if (duvarYonuComboBox == null) {
		    String[] yonler = {"Kuzey","Kuzeydoðu","Doðu","Güneydoðu","Güney","Güneybatý","Batý","Kuzeybatý"};
			duvarYonuComboBox = new JComboBox(yonler);
			duvarYonuComboBox.setBounds(131, 150, 110, 26);
		}
		return duvarYonuComboBox;
	}
	/**
	 * This method initializes pencereAlaniTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getPencereAlaniTextField() {
		if (pencereAlaniTextField == null) {
			pencereAlaniTextField = new JTextField();
			pencereAlaniTextField.setLocation(131, 120);
			pencereAlaniTextField.setSize(110, 26);
			pencereAlaniTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					pencereAlaniTextField.setText("");
				}
			});
		}
		return pencereAlaniTextField;
	}
	/**
	 * This method initializes pencereYonuComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getPencereYonuComboBox() {
		if (pencereYonuComboBox == null) {
		    String[] yonler = {"Kuzey","Kuzeykuzeydoðu","Kuzeydoðu","Doðukuzeydoðu","Doðu","Doðugüneydoðu","Güneydoðu","Güneygüneydoðu","Güney","Güneygüneybatý","Güneybatý","Batýgüneybatý","Batý","Batýkuzeybatý","Kuzeybatý","Kuzeykuzeybatý","Yatay"};
			pencereYonuComboBox = new JComboBox(yonler);
			pencereYonuComboBox.setLocation(131, 150);
			pencereYonuComboBox.setSize(144, 26);
		}
		return pencereYonuComboBox;
	}
	/**
	 * This method initializes mahalIciSicaklikFarkiCheckBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */    
	private JCheckBox getMahalIciSicaklikFarkiCheckBox() {
		if (mahalIciSicaklikFarkiCheckBox == null) {
			mahalIciSicaklikFarkiCheckBox = new JCheckBox();
			mahalIciSicaklikFarkiCheckBox.setText("Mahal içi sýcaklýk farký var");
			mahalIciSicaklikFarkiCheckBox.setBounds(20, 4, 172, 24);
			mahalIciSicaklikFarkiCheckBox.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
					getSicaklikFarkiTextField().setEnabled(!getSicaklikFarkiTextField().isEnabled());
					getIcDuvarAlaniTextField().setEnabled(!getIcDuvarAlaniTextField().isEnabled());
					getIcDuvarIsiTransferKatsayisiTextField().setEnabled(!getIcDuvarIsiTransferKatsayisiTextField().isEnabled());
				}
			});
		}
		return mahalIciSicaklikFarkiCheckBox;
	}
	/**
	 * This method initializes icDuvarAlaniTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIcDuvarAlaniTextField() {
		if (icDuvarAlaniTextField == null) {
			icDuvarAlaniTextField = new JTextField();
			icDuvarAlaniTextField.setBounds(329, 82, 100, 20);
			icDuvarAlaniTextField.setEnabled(false);
			icDuvarAlaniTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					icDuvarAlaniTextField.setText("");
				}
			});
		}
		return icDuvarAlaniTextField;
	}
	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel3.setLayout(null);
			jPanel3.setBounds(16, 217, 671, 110);
			jPanel3.add(getMahalIciSicaklikFarkiCheckBox(), null);
			jPanel3.add(jLabel10, null);
			jPanel3.add(bjLabel15, null);
			jPanel3.add(bjLabel16, null);
			jPanel3.add(getSicaklikFarkiTextField(), null);
			jPanel3.add(getIcDuvarIsiTransferKatsayisiTextField(), null);
			jPanel3.add(getIcDuvarAlaniTextField(), null);
		}
		return jPanel3;
	}
	/**
	 * This method initializes disDuvarToplamBoyuTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getDisDuvarToplamBoyuTextField() {
		if (disDuvarToplamBoyuTextField == null) {
			disDuvarToplamBoyuTextField = new JTextField();
			disDuvarToplamBoyuTextField.setBounds(344, 172, 99, 20);
			disDuvarToplamBoyuTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					disDuvarToplamBoyuTextField.setText("");
				}
			});
		}
		return disDuvarToplamBoyuTextField;
	}
	/**
	 * This method initializes golgelemeliCiftPencereRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getGolgelemeliCiftPencereRadioButton() {
		if (golgelemeliCiftPencereRadioButton == null) {
			golgelemeliCiftPencereRadioButton = new JRadioButton();
			golgelemeliCiftPencereRadioButton.setText("Ýç gölgeleme yapýlmýþ, çift camlý pencereler");
			golgelemeliCiftPencereRadioButton.setActionCommand("GC");
			golgelemeliCiftPencereRadioButton.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
					if (golgelemeliCiftPencereRadioButton.isSelected()) { 
						 enableWidgetsWithRespectToGolgeleme(true);
					}else{
						 enableWidgetsWithRespectToGolgeleme(false);
					}
				}
			});
			pencereTipiBGroup.add(golgelemeliCiftPencereRadioButton);
		}
		return golgelemeliCiftPencereRadioButton;
	}
	
    public void enableWidgetsWithRespectToGolgeleme(boolean b) {
        getKoyuJaluziRadioButton().setEnabled(b);
         getAcikJaluziRadioButton().setEnabled(b);
         getKoyuPerdeRadioButton().setEnabled(b);
         getAcikPerdeRadioButton().setEnabled(b);
         getIsikGecirgenPerdeRadioButton().setEnabled(b);
         getNormalCamKalinligi3RadioButton().setEnabled(b);
         getNormalCamKalinligi6RadioButton().setEnabled(b);
         getAbsorbsiyonluCamKalinligi6RadioButton().setEnabled(b);
         getAynaliCamRadioButton().setEnabled(b);
         
         getNormalCamRadioButton().setEnabled(!b);
         getIsiAbsorbsiyonluCamRadioButton().setEnabled(!b);
         getNormalCiftCamRadioButton().setEnabled(!b);
         getCamKalinligiComboBox().setEnabled(!b);
    }

	/**
	 * This method initializes aynaTipiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getAynaTipiComboBox() {
		if (aynaTipiComboBox == null) {
		    String[] values = {"ST=0.20","ST=0.30","ST=0.40"};
			aynaTipiComboBox = new JComboBox(values);
			aynaTipiComboBox.setBounds(147, 103, 113, 24);
			aynaTipiComboBox.setEnabled(false);
		}
		return aynaTipiComboBox;
	}
	/**
	 * This method initializes mobilyaTipiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getMobilyaTipiComboBox() {
		if (mobilyaTipiComboBox == null) {
		    String[] values = {"A","B","C","D"};
			mobilyaTipiComboBox = new JComboBox(values);
			mobilyaTipiComboBox.setBounds(98, 24, 154, 22);
		}
		return mobilyaTipiComboBox;
	}
	/**
	 * This method initializes cihazlarinToplamGucuTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getCihazlarinToplamGucuTextField() {
		if (cihazlarinToplamGucuTextField == null) {
			cihazlarinToplamGucuTextField = new JTextField();
			cihazlarinToplamGucuTextField.setBounds(338, 8, 128, 21);
			cihazlarinToplamGucuTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					cihazlarinToplamGucuTextField.setText("");
				}
			});
		}
		return cihazlarinToplamGucuTextField;
	}
	/**
	 * This method initializes ekipmanlarIsiKazanciTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getEkipmanlarIsiKazanciTextField() {
		if (ekipmanlarIsiKazanciTextField == null) {
			ekipmanlarIsiKazanciTextField = new JTextField();
			ekipmanlarIsiKazanciTextField.setBounds(341, 65, 128, 21);
			ekipmanlarIsiKazanciTextField.setEditable(false);
		}
		return ekipmanlarIsiKazanciTextField;
	}
	/**
	 * This method initializes cihazSecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getCihazSecButton() {
		if (cihazSecButton == null) {
			cihazSecButton = new JButton();
			cihazSecButton.setText("Cihaz seç");
			cihazSecButton.setBounds(471, 8, 94, 21);
		}
		return cihazSecButton;
	}
    public void addMustakilMahalCheckBoxListener(ActionListener listener) {
        getMustakilMahalCheckBox().addActionListener(listener);
    }
    public boolean isMustakilCheckBoxChecked() {
        return getMustakilMahalCheckBox().isSelected();
    }
    public void addHesapAyiComboBoxActionListener(ActionListener listener) {
        getHesapAyiComboBox().addActionListener(listener);
    }
    public int getHesapAyiComboBoxSelectedIndex() {
        return getHesapAyiComboBox().getSelectedIndex();
    }
    public void addHesapSaatiComboBoxActionListener(ActionListener listener) {
        getHesapSaatiComboBox().addActionListener(listener);
    }
    public int getHesapSaatiComboBoxSelectedIndex() {
        return getHesapSaatiComboBox().getSelectedIndex();
    }
    public void addTasarimSartlariPanelComponentListener(ComponentListener listener) {
        getTasarimSartlariPanel().addComponentListener(listener);
    }
    
    public void setDisSicaklikTextFieldTextFieldText(double value) {
        getDisSicaklikTextField().setText(""+value);
    }
    
    public void setDisOzgulNemTextFieldText(double value) {
        getDisOzgulNemTextField().setText(""+value);
    }
    public void addIKPanelComponentShownListener(ComponentListener ilDegerleriSetter) {
        this.addComponentListener(ilDegerleriSetter);
    }
    public void addDuvarToDisDuvarList(String string) {
        ((DefaultListModel)getDisDuvarList().getModel()).addElement(string);
    }
    public void addDuvarSilButtonActionListener(ActionListener listener) {
        getDuvarSilButton().addActionListener(listener);
    }
    public void addDuvarEkleButtonActionListener(ActionListener listener) {
        getDuvarEkleButton().addActionListener(listener);
    }
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getDisDuvarList());
			jScrollPane.setLocation(130, 17);
			jScrollPane.setSize(164, 95);
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
			jScrollPane1.setViewportView(getPencereList());
			jScrollPane1.setSize(164, 95);
			jScrollPane1.setLocation(130, 17);
		}
		return jScrollPane1;
	}
    public String getSelectedDisDuvarIdentifier() {
        return (String)getDisDuvarList().getSelectedValue();
    }
    public void removeDuvarFromDisDuvarList() {
        ((DefaultListModel)getDisDuvarList().getModel()).remove(getDisDuvarList().getSelectedIndex());
    }
    public void addDuvarAlaniTextFieldKeyAdapter(KeyAdapter adapter) {
        getDuvarAlaniTextField().addKeyListener(adapter);
    }
    public Object getDuvarAlaniTextFieldText() {
        return getDuvarAlaniTextField().getText();
    }
    public void setDuvarAlaniTextFieldText(String string) {
        getDuvarAlaniTextField().setText(string);
    }
    public void addDuvarListSelectionListener(ListSelectionListener listener) {
        getDisDuvarList().addListSelectionListener(listener);
    }
    public void addDuvarYonuComboBoxListener(ActionListener listener) {
        getDuvarYonuComboBox().addActionListener(listener);
    }
    public void setDuvarYonuComboBoxSelectedYon(String yon) {
        getDuvarYonuComboBox().setSelectedItem(yon);
    }
    public void addPencereEkleButtonActionListener(ActionListener listener) {
        getPencereEkleButton().addActionListener(listener);
    }
    
    public void addPencereToPencereList(String string) {
        ((DefaultListModel)getPencereList().getModel()).addElement(string);
    }
    public void addPencereSilButtonActionListener(ActionListener listener) {
        getPencereSilButton().addActionListener(listener);
    }
    public String getSelectedPencereIdentifier() {
        return (String)getPencereList().getSelectedValue();
    }
    public void removePencereFromPencereList() {
        ((DefaultListModel)getPencereList().getModel()).remove(getPencereList().getSelectedIndex());
    }
    public void addPencereAlaniTextFieldKeyAdapter(KeyAdapter adapter) {
        getPencereAlaniTextField().addKeyListener(adapter);
    }
    public String getPencereAlaniTextFieldText() {
        return getPencereAlaniTextField().getText();
    }
    public void addPencereListSelectionListener(ListSelectionListener listener) {
        getPencereList().addListSelectionListener(listener);
    }
    public void setPencereAlaniTextFieldText(String string) {
        getPencereAlaniTextField().setText(string);
    }
    public void setPencereYonuComboBoxSelectedYon(String yon) {
        getPencereYonuComboBox().setSelectedItem(yon);
    }
    public void addPencereYonuComboBoxListener(ActionListener listener) {
        getPencereYonuComboBox().addActionListener(listener);
    }
    public boolean isPencereListEmpty() {
        return ((DefaultListModel)getPencereList().getModel()).isEmpty();
    }
    public boolean isDuvarListEmpty() {
        return ((DefaultListModel)getDisDuvarList().getModel()).isEmpty();
    }
    public void setCatilAlaniTextFieldEnabled(boolean b) {
        getCatiAlaniTextField().setEnabled(b);
    }
    public void setCatiUTextFieldEnabled(boolean b) {
        getCatiUTextField().setEnabled(b);
    }
    public void setCatiTipiComboBoxEnabled(boolean b) {
        getCatiTipiComboBox().setEnabled(b);
    }
    public String getCatiAlaniTextFieldText() {
        return getCatiAlaniTextField().getText();
    }
    public void addCatiAlaniTextFieldKeyAdapter(KeyAdapter adapter) {
        getCatiAlaniTextField().addKeyListener(adapter);
    }
    public void setCatiAlaniTextFieldText(String string) {
        getCatiAlaniTextField().setText(string);
    }
    public void addCatiUTextFieldKeyAdapter(KeyAdapter adapter) {
        getCatiUTextField().addKeyListener(adapter);
    }
    public String getCatiUTextFieldText() {
        return getCatiUTextField().getText();
    }
    public void setCatiUTextFieldText(String string) {
        getCatiUTextField().setText(string);
    }
    public void addCatiTipiComboBoxSelectionListener(ActionListener listener) {
        getCatiTipiComboBox().addActionListener(listener);
    }
    public void addDisDuvarToplamBoyuTextFieldActionListener(KeyAdapter adapter) {
        getDisDuvarToplamBoyuTextField().addKeyListener(adapter);
    }
    public String getDisDuvarToplamBoyuTextFieldText() {
        return getDisDuvarToplamBoyuTextField().getText();
    }
    public void DisDuvarToplamBoyuTextFieldText(String string) {
        getDisDuvarToplamBoyuTextField().setText(string);
    }
    public void addPencereIsiTransferKatsayisiTextFieldActionListener(KeyAdapter adapter) {
        getPencereIsiTransferKatsayisiTextField().addKeyListener(adapter);
    }
    public String getPencereIsiTransferKatsayisiTextFieldText() {
        return getPencereIsiTransferKatsayisiTextField().getText();
    }
    public void setPencereIsiTransferKatsayisiTextFieldText(String string) {
        getPencereIsiTransferKatsayisiTextField().setText(string);
    }
    public void addDisDuvarIsiTransferKatsayisiTextFieldActionListener(KeyAdapter adapter) {
        getDisDuvarIsiTransferKatsayisiTextField().addKeyListener(adapter);
    }
    public String getDisDuvarIsiTransferKatsayisiTextFieldText() {
        return getDisDuvarIsiTransferKatsayisiTextField().getText();
    }
    public void setDisDuvarIsiTransferKatsayisiTextFieldText(String string) {
        getDisDuvarIsiTransferKatsayisiTextField().setText(string);
    }
    public void addMahalIciSicaklikFarkiCheckBoxListener(ActionListener listener) {
        getMahalIciSicaklikFarkiCheckBox().addActionListener(listener);
    }
    public void setSicaklikFarkiTextFieldText(String string) {
        getSicaklikFarkiTextField().setText(string);
    }
    public String getSicaklikFarkiTextFieldText() {
        return getSicaklikFarkiTextField().getText();
    }
    public void addSicaklikFarkiTextFieldKeyListener(KeyAdapter adapter) {
        getSicaklikFarkiTextField().addKeyListener(adapter);
    }
    public void addIcDuvarIsiTransferKatsayisiTextFieldKeyListener(KeyAdapter adapter) {
        getIcDuvarIsiTransferKatsayisiTextField().addKeyListener(adapter);
    }
    public String getIcDuvarIsiTransferKatsayisiTextFieldText() {
        return getIcDuvarIsiTransferKatsayisiTextField().getText();
    }
    public void setIcDuvarIsiTransferKatsayisiTextFieldText(String string) {
        getIcDuvarIsiTransferKatsayisiTextField().setText(string);
    }
    public void addIcDuvarAlaniTextFieldKeyListener(KeyAdapter adapter) {
        getIcDuvarAlaniTextField().addKeyListener(adapter);
    }
    public String getIcDuvarAlaniTextFieldText() {
        return getIcDuvarAlaniTextField().getText();
    }
    public void setIcDuvarAlaniTextFieldText(String string) {
        getIcDuvarAlaniTextField().setText(string);
    }
    public void setIletimYoluIleIsiKazanciTextFieldText(int i) {
        getIletimIsiKazanciTextField().setText(""+i);
    }
    public void addGolgelemeRadioButtonListener(ActionListener golgelemeRadioButtonsListener) {        
        getGolgelemesizTekPencereRadioButton().addActionListener(golgelemeRadioButtonsListener);
        getGolgelemesizCiftPencereRadioButton().addActionListener(golgelemeRadioButtonsListener);
        getGolgelemeliCiftPencereRadioButton().addActionListener(golgelemeRadioButtonsListener);
    }
    public void addCamTipiRadioButtonsListener(ActionListener listener) {
        getNormalCamRadioButton().addActionListener(listener);
        getIsiAbsorbsiyonluCamRadioButton().addActionListener(listener);
        getNormalCiftCamRadioButton().addActionListener(listener);
    }
    public void addCamKalinligiComboBoxListener(ActionListener listener) {
        getCamKalinligiComboBox().addActionListener(listener);
    }
    public void addGolgelemeTipiRadioButtonsListener(ActionListener golgelemeRadioButtonsListener) {
        getKoyuJaluziRadioButton().addActionListener(golgelemeRadioButtonsListener);
        getAcikJaluziRadioButton().addActionListener(golgelemeRadioButtonsListener);
        getKoyuPerdeRadioButton().addActionListener(golgelemeRadioButtonsListener);
        getAcikPerdeRadioButton().addActionListener(golgelemeRadioButtonsListener);
        getIsikGecirgenPerdeRadioButton().addActionListener(golgelemeRadioButtonsListener);
    }
    public void addGolgelemeliCamTipiRadioButttonsListener(ActionListener listener) {
        getNormalCamKalinligi3RadioButton().addActionListener(listener);
        getNormalCamKalinligi6RadioButton().addActionListener(listener);
        getAbsorbsiyonluCamKalinligi6RadioButton().addActionListener(listener);
        getAynaliCamRadioButton().addActionListener(listener);
    }
    public void addAynaTipiComboBoxListener(ActionListener listener) {
        getAynaTipiComboBox().addActionListener(listener);
    }
    public void setDirektGunesYukuTextFieldText(String string) {
        getDirektGunesYukuTextField().setText(string);
    }
    public void addMobilyaTipiComboBoxActionListener(ActionListener listener) {
        getMobilyaTipiComboBox().addActionListener(listener);
    }
    public void addAydinlatmaSuresiRadioButtonListener(ActionListener aydinlatmaSuresiRadioButtonListener) {
        getAydinlanmaSuresi12RadioButton().addActionListener(aydinlatmaSuresiRadioButtonListener);
        getAydinlanmaSuresi8RadioButton().addActionListener(aydinlatmaSuresiRadioButtonListener);
    }
    public void addIsikSonrasiZamanComboBoxListener(ActionListener listener) {
        getIsikSonrasiZamanComboBox().addActionListener(listener);
    }
    public void addAydinlatmaIsiKazanciTextFieldKeyListener(KeyAdapter adapter) {
        getAydinlanmaElemanlariToplamGucTextField().addKeyListener(adapter);
    }
    public String getAydinlatmaEkipmanlariToplamGucuTextFieldText() {
        return getAydinlanmaElemanlariToplamGucTextField().getText();
    }
    public void setAydinlatmaEkipmanlariToplamGucuTextFieldText(String string) {
        getAydinlanmaElemanlariToplamGucTextField().setText(string);
    }
    public void setAydinlanmaToplamIsiKazanciTextFieldText(int i) {
        getAydinlatmaIsiKazanciTextField().setText(""+i);
    }
    public void addAktivitelerComboBoxListener(ActionListener listener) {
        getAktivitelerComboBox().addActionListener(listener);
    }
    public void addHacimdeKalmaSuresiComboBoxListener(ActionListener listener) {
        getHacimdeKalmaSuresiComboBox().addActionListener(listener);
    }
    public void addHacimdeGecenSureComboBoxListener(ActionListener listener) {
        getHacimeGirdiktenSonraGecenSureComboBox().addActionListener(listener);
    }
    public void addInsanSayisiTextFieldKeyListener(KeyAdapter adapter) {
        getInsanSayisiTextField().addKeyListener(adapter);        
    }
    public String getInsanSayisiTextFieldText() {
        return getInsanSayisiTextField().getText();
    }
    public void setInsanSayisiTextFieldText(String string) {
        getInsanSayisiTextField().setText(string);
    }
    public void setInsanlardanIsiKazanciTextFieldText(int i) {
        getInsanlardanIsiKazanciTextField().setText(""+i);
    }
    /**
     * @param adapter
     */
    public void addIsinimKazanciPanelComponentShownListener(ComponentAdapter adapter) {
        
    }
    /**
     * @param alan
     */
    public void setCatiAlaniTextFieldText(float alan) {
        getCatiAlaniTextField().setText(""+alan);
    }
	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jLabel2 = new JLabel();
			jLabel3 = new JLabel();
			jPanel4.setLayout(null);
			jPanel4.setBounds(14, 239, 682, 83);
			jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jLabel2.setBounds(32, 54, 135, 25);
			jLabel2.setText("Toplam çalýþma süresi");
			jLabel3.setBounds(359, 54, 128, 25);
			jLabel3.setText("Toplam iþletme süresi");
			jPanel4.add(jLabel13, null);
			jPanel4.add(getCihazlarinToplamGucuTextField(), null);
			jPanel4.add(getCihazSecButton(), null);
			jPanel4.add(getCihazDavlumbazliCheckBox(), null);
			jPanel4.add(jLabel2, null);
			jPanel4.add(getToplamCalismaSuresiComboBox(), null);
			jPanel4.add(jLabel3, null);
			jPanel4.add(getToplamIsletmeSuresiComboBox(), null);
		}
		return jPanel4;
	}
	/**
	 * This method initializes cihazDavlumbazliCheckBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */    
	private JCheckBox getCihazDavlumbazliCheckBox() {
		if (cihazDavlumbazliCheckBox == null) {
			cihazDavlumbazliCheckBox = new JCheckBox();
			cihazDavlumbazliCheckBox.setBounds(9, 29, 135, 21);
			cihazDavlumbazliCheckBox.setText("Cihaz davlumbazlý");
		}
		return cihazDavlumbazliCheckBox;
	}
	/**
	 * This method initializes toplamCalismaSuresiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getToplamCalismaSuresiComboBox() {
		if (toplamCalismaSuresiComboBox == null) {
		    String[] saatler = {"2","4","6","8","10","12","14","16","18"};
			toplamCalismaSuresiComboBox = new JComboBox(saatler);
			toplamCalismaSuresiComboBox.setBounds(199, 54, 128, 25);
		}
		return toplamCalismaSuresiComboBox;
	}
	/**
	 * This method initializes toplamIsletmeSuresiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getToplamIsletmeSuresiComboBox() {
		if (toplamIsletmeSuresiComboBox == null) {
		    String[] saatler = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
			toplamIsletmeSuresiComboBox = new JComboBox(saatler);
			toplamIsletmeSuresiComboBox.setBounds(519, 54, 128, 25);
		}
		return toplamIsletmeSuresiComboBox;
	}
    public void addCihazlarýnToplamGuceTextFieldListener(KeyAdapter adapter) {
        getCihazlarinToplamGucuTextField().addKeyListener(adapter);
    }
    public String getCihazlarinToplamGucuTextFieldText() {
        return getCihazlarinToplamGucuTextField().getText();
    }
    /**
     * @param string
     */
    public void setCihazlarinToplamGucuTextFieldText(String string) {
        getCihazlarinToplamGucuTextField().setText(string);
    }
    /**
     * @param listener
     */
    public void addCihazDavlumbazliCheckBoxListener(ActionListener listener) {
        getCihazDavlumbazliCheckBox().addActionListener(listener);
    }
    /**
     * @param listener
     */
    public void addCihazToplamCalismaSuresiComboBoxListener(ActionListener listener) {
        getToplamCalismaSuresiComboBox().addActionListener(listener);
    }
    /**
     * @param listener
     */
    public void addcihazToplamIsletmeSuresiComboBoxListener(ActionListener listener) {
        getToplamIsletmeSuresiComboBox().addActionListener(listener);
    }
    /**
     * @param adapter
     */
    public void addCihazToplamGucuTextFieldKeyListener(KeyAdapter adapter) {
        getCihazlarinToplamGucuTextField().addKeyListener(adapter);
    }
    /**
     * @return
     */
    public String getCihazToplamGucuTextFieldText() {
        return getCihazlarinToplamGucuTextField().getText();
    }
    /**
     * @param string
     */
    public void setCihazToplamGucuTextFieldText(String string) {
        getCihazlarinToplamGucuTextField().setText(string);
    }
    /**
     * @param value
     */
    public void updateCihazlarToplamGucuTextFieldText(String value) {
        getEkipmanlarIsiKazanciTextField().setText(value);
    }
	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jLabel17 = new JLabel();
			jLabel16 = new JLabel();
			jPanel5 = new JPanel();
			jLabel4 = new JLabel();
			jPanel5.setLayout(null);
			jPanel5.setBounds(18, 235, 658, 69);
			jLabel4.setBounds(11, 10, 235, 24);
			jLabel4.setText("Hava debisi");
			jLabel16.setBounds(359, 10, 25, 24);
			jLabel16.setText("1/h");
			jLabel17.setBounds(359, 37, 25, 24);
			jLabel17.setText("W");
			jPanel5.add(jLabel, null);
			jPanel5.add(getEnfiltrasyonHavalandirmaYukuTextField(), null);
			jPanel5.add(jLabel4, null);
			jPanel5.add(getHavaDebisiTextField(), null);
			jPanel5.add(jLabel16, null);
			jPanel5.add(jLabel17, null);
		}
		return jPanel5;
	}
	/**
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setLayout(null);
			jPanel6.setBounds(17, 14, 658, 204);
			jPanel6.add(bjLabel36, null);
			jPanel6.add(bjLabel37, null);
			jPanel6.add(getAktivitelerComboBox(), null);
			jPanel6.add(getHacimdeKalmaSuresiComboBox(), null);
			jPanel6.add(getHacimeGirdiktenSonraGecenSureComboBox(), null);
			jPanel6.add(bjLabel38, null);
			jPanel6.add(bjLabel39, null);
			jPanel6.add(bjLabel40, null);
			jPanel6.add(bjLabel41, null);
			jPanel6.add(getInsanlardanIsiKazanciTextField(), null);
			jPanel6.add(getInsanSayisiTextField(), null);
		}
		return jPanel6;
	}
	/**
	 * This method initializes havaDebisiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getHavaDebisiTextField() {
		if (havaDebisiTextField == null) {
			havaDebisiTextField = new JTextField();
			havaDebisiTextField.setBounds(250, 10, 99, 24);
			havaDebisiTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					havaDebisiTextField.setText("");
				}
			});
		}
		return havaDebisiTextField;
	}
    /**
     * @param adapter
     */
    public void addHavaDebisiTextFieldKeyListener(KeyAdapter adapter) {
        getHavaDebisiTextField().addKeyListener(adapter);
    }
    /**
     * @return
     */
    public String getHavaDebisiTextFieldText() {
        return getHavaDebisiTextField().getText();
    }
    /**
     * @param string
     */
    public void sethavaDebisiTextFieldText(String string) {
        getHavaDebisiTextField().setText(string);
    }
    /**
     * @param string
     */
    public void setEnfiltrasyonYukuTextFieldText(String string) {
        getEnfiltrasyonHavalandirmaYukuTextField().setText(string);
    }
	/**
	 * This method initializes hacimdeKalmaSuresiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getHacimdeKalmaSuresiComboBox() {
		if (hacimdeKalmaSuresiComboBox == null) {
		    String[] saatler = {"2","4","6","8","10","12","14","16","18"};
			hacimdeKalmaSuresiComboBox = new JComboBox(saatler);
			hacimdeKalmaSuresiComboBox.setBounds(315, 74, 99, 24);
		}
		return hacimdeKalmaSuresiComboBox;
	}
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getHacimeGirdiktenSonraGecenSureComboBox() {
		if (hacimeGirdiktenSonraGecenSureComboBox == null) {
		    String[] saatler = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
		    hacimeGirdiktenSonraGecenSureComboBox = new JComboBox(saatler);
		    hacimeGirdiktenSonraGecenSureComboBox.setBounds(316, 135, 97, 24);
		}
		return hacimeGirdiktenSonraGecenSureComboBox;
	}
    public void addIcOzgulNemTextFieldListener(KeyAdapter adapter) {
        getIcOzgulNemTextField().addKeyListener(adapter);
    }
    public String getIcOzgulNemTextFieldText() {
        return getIcOzgulNemTextField().getText();
    }
    public void setIcOzgulNemTextFieldText(String string) {
        getIcOzgulNemTextField().setText(string);
    }
    public void addIletimTasinimPanelComponentShownListener(ComponentAdapter adapter) {
        getIletimTasinimPanel().addComponentListener(adapter);
    }
    public void addInsanlardanPanelComponentShownListener(ComponentAdapter adapter) {
        getBJPanel4().addComponentListener(adapter);
    }
    public void setToplamIsiKazanciTextFieldText(double d) {
        getToplamIsiKazanciTextField().setText(""+d);
    }
    public void setMustakilMahalCheckBoxSelected(boolean b) {
        getMustakilMahalCheckBox().setSelected(b);
    }
    public void setHesapAyiComboBoxSelectedItem(int ay) {
        getHesapAyiComboBox().setSelectedIndex(ay);
    }
    public void setHesapSattiComboBoxSelectedItem(String string) {
        getHesapSaatiComboBox().setSelectedItem(string);
    }
    public void setCatiTipiComboBoxSelectedItem(CatiCLTD catiCLDT) {
        getCatiTipiComboBox().setSelectedItem(catiCLDT);
    }
    public void setMahalIciSicaklikFarkiVarCheckBoxSelected(boolean b) {
        getMahalIciSicaklikFarkiCheckBox().setSelected(b);
    }
    public void setSicaklikFarkiTextFieldEnabled(boolean b) {
        getSicaklikFarkiTextField().setEnabled(b);
    }
    public void setIcDuvarAlaniTextFieldEnabled(boolean b) {
        getIcDuvarAlaniTextField().setEnabled(b);
    }
    public void setIcDuvarIsiTransferKatsayisiTextField(boolean b) {
        getIcDuvarIsiTransferKatsayisiTextField().setEnabled(b);
    }
    public void setGolgelemeliCiftPencereRadioButtonSelected(boolean state) {
        getGolgelemeliCiftPencereRadioButton().setSelected(state);
    }
    public void setGolgelemesizTekPencereRadioButtonSelected(boolean b) {
        getGolgelemesizTekPencereRadioButton().setSelected(b);
    }
    public void setNormalCamTipiRadioButtonSelected(boolean b) {
        getNormalCamRadioButton().setSelected(b);
    }
    public void setIsiAbsorbsiyonluCamTipiRadioButtonSelected(boolean b) {
        getIsiAbsorbsiyonluCamRadioButton().setSelected(b);
    }
    public void setNormalCiftCamRadioButtonSelected(boolean b) {
        getNormalCiftCamRadioButton().setSelected(b);
    }
    public void setCamKalinligiComboBoxSelectedItem(String string) {
        getCamKalinligiComboBox().setSelectedItem(string);
    }
    public void setKoyuJaluziRadioButtonSelected(boolean b) {
        getKoyuJaluziRadioButton().setSelected(b);
    }
    public void setAcikJaluziRadioButtonSelected(boolean b) {
        getAcikJaluziRadioButton().setSelected(b);
    }
    public void setKoyuPerdeRadioButtonSelected(boolean b) {
        getKoyuPerdeRadioButton().setSelected(b);
    }
    public void setAcikPerdeRadioButtonSelected(boolean b) {
        getAcikPerdeRadioButton().setSelected(b);
    }
    public void setIsikGecirgenPerdeRadioButtonSelected(boolean b) {
        getIsikGecirgenPerdeRadioButton().setSelected(b);
    }
    public void setNormalCamKalinligi3RadioButtonSelected(boolean b) {
        getNormalCamKalinligi3RadioButton().setSelected(b);
    }
    public void setNormalCamKalinligi6RadioButtonSelected(boolean b) {
        getNormalCamKalinligi6RadioButton().setSelected(b);
    }
    public void setMobilyaTipiComboBoxSelectedValue(String mobilyaTipi) {
        getMobilyaTipiComboBox().setSelectedItem(mobilyaTipi);
    }
    public void setAydinlatmaSuresi8RadioBoxSelected(boolean b) {
        getAydinlanmaSuresi8RadioButton().setSelected(b);
    }
    public void setAydinlatmaSuresi12RadioBoxSelected(boolean b) {
        getAydinlanmaSuresi12RadioButton().setSelected(b);
    }
    public void setAydinlanmaSonrasiGecenZamanComboBoxSelectedItem(String string) {
        getIsikSonrasiZamanComboBox().setSelectedItem(string);
    }
    public void setCihazlarinToplamGucuTextField(double guc) {
        getCihazlarinToplamGucuTextField().setText(""+guc);
    }
    public void setCihazDavlumbazliCheckBoxSelected(boolean b) {
        getCihazDavlumbazliCheckBox().setSelected(b);
    }
    public void setToplamCalismaSuresiComboBoxSelectedItem(int calistigiToplamSaat) {
        getToplamCalismaSuresiComboBox().setSelectedItem(""+calistigiToplamSaat);
    }
    public void setToplamIsletmeSuresiComboBoxSelectedItem(int isletmeyeAlindiktanSonraGecenSaat) {
        getToplamIsletmeSuresiComboBox().setSelectedItem(""+isletmeyeAlindiktanSonraGecenSaat);
    }
    public void setAydinlatnaElemanlarininToplamGucuTextField(double guc) {
        getAydinlanmaElemanlariToplamGucTextField().setText(""+guc);
    }
    public void setAktivitelerComboBoxSelectedItem(String aktiviteTuru) {
        if(aktiviteTuru!=null)
        getAktivitelerComboBox().setSelectedItem(AktiviteCatalog.getInstance().getAktivite(aktiviteTuru));
    }
    public void setHacimdeKalmaSuresiComboBoxSelectedItem(int hacimdeToplamKalmaSuresi) {
        getHacimdeKalmaSuresiComboBox().setSelectedItem(""+hacimdeToplamKalmaSuresi);
    }
    public void setHacimeGirdiktenSonraGecenZaman(int hacimeGirdiktenSonraGecenZaman) {
        getHacimeGirdiktenSonraGecenSureComboBox().setSelectedItem(""+hacimeGirdiktenSonraGecenZaman);
    }
    public void setHacimdekiInsanSayisi(int insanSayisi) {
        getInsanSayisiTextField().setText(""+insanSayisi);
    }
	/**
	 * This method initializes secilenKlimaTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getSecilenKlimaTextField() {
		if (secilenKlimaTextField == null) {
			secilenKlimaTextField = new JTextField();
			secilenKlimaTextField.setBounds(254, 366, 99, 24);
			secilenKlimaTextField.setEditable(false);
		}
		return secilenKlimaTextField;
	}
	/**
	 * This method initializes klimaSecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getKlimaSecButton() {
		if (klimaSecButton == null) {
			klimaSecButton = new JButton();
			klimaSecButton.setBounds(373, 366, 75, 24);
			klimaSecButton.setText("Seç");
		}
		return klimaSecButton;
	}
	
	public void setJTextFieldText(String model){
	    getSecilenKlimaTextField().setText(model);
	}
    public void addKlimaSecButtonActionListener(ActionListener listener) {
        getKlimaSecButton().addActionListener(listener);
    }
    public void setSecilenKlimaTextField(String klimaModeli) {
        getSecilenKlimaTextField().setText(klimaModeli);
    }
    public void addCihazSecButtonActionListener(ActionListener listener) {
        getCihazSecButton().addActionListener(listener);
    }
       }  //  @jve:decl-index=0:visual-constraint="10,10"
