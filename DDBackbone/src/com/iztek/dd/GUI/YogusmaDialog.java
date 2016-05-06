/*
 * Created on 09.Þub.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.BilesikYapiElemani;
import com.iztek.dd.domain.BinaDuvari;
import com.iztek.dd.domain.Yogusabilen;
/**
 * @author Selim HENDRICKSON
 *
 */
public class YogusmaDialog extends JDialog {
	DecimalFormat threeDigits = new DecimalFormat("#.###");	
    private BilesikYapiElemani selectedEleman = null;
    
	private javax.swing.JPanel jContentPane = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel sinirlandirmaSartlariPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel = null;
	private JPanel jPanel3 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField yogusmaIcHavaSicakligiTextField = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextField yogusmaIcBagilNemTextField = null;
	private JTextField yogusmaDisBagilNemTextField = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JTextField yogusmaIcDoymusBasincTextField = null;
	private JTextField yogusmaDisDoymusBasincTextField = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JTextField yogusmaIcKismiBasincTextField = null;
	private JTextField yogusmaDisKismiBasincTextField = null;
	private JLabel jLabel14 = null;
	private JLabel jLabel15 = null;
	private JTextField yogusmaSuresiTextField = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel16 = null;
	private JLabel jLabel17 = null;
	private JLabel jLabel18 = null;
	private JLabel jLabel19 = null;
	private JTextField buharlasmaIcHavaSicakligiTextField = null;
	private JTextField buharlasmaIcBagilNemTextField = null;
	private JTextField buharlasmaIcDoymusBasincTextField = null;
	private JTextField buharlasmaIcKismiBasincTextField = null;
	private JTextField buharlasmaSuresiTextField = null;
	private JTextField buharlasmaDisHavaSicakligiTextField = null;
	private JTextField buharlasmaDisBagilNemTextField = null;
	private JTextField buharlasmaDisDoymusBasincTextField = null;
	private JTextField buharlasmaDisKismiBasincTextField = null;
	private JComboBox disHavaSicakligiComboBox = null;
	private JLabel jLabel20 = null;
	private JLabel jLabel21 = null;
	private JEditorPane jEditorPane = null;
	private JPanel jPanel4 = null;
	private JLabel jLabel22 = null;
	private JTextField toplamHavaTabakasiKalinligiTextField = null;
	private JLabel jLabel23 = null;
	private JLabel jLabel24 = null;
	private JTextField toplamIsilGecirgenlikTextField = null;
	private JLabel jLabel25 = null;
	private JLabel jLabel26 = null;
	private JTextField isiAkisiTextField = null;
	private JLabel jLabel27 = null;
	private JLabel jLabel28 = null;
	private JLabel jLabel29 = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel5 = null;
	private JButton tamamButton = null;
	/**
	 * This is the default constructor
	 */
	public YogusmaDialog() {
		super();
		initialize();
	}
	/**
     * @param selectedEleman
     */
    public YogusmaDialog(BilesikYapiElemani selectedEleman) {
        super();
        this.selectedEleman = selectedEleman;
        initialize();
    }
    /**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Yoðuþma bilgileri");
		this.setSize(786, 558);
		this.setContentPane(getJContentPane());
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
			jContentPane.add(getJTabbedPane(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getJPanel5(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */    
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("Sýnýrlandýrma Þartlarý", null, getSinirlandirmaSartlariPanel(), null);
			jTabbedPane.addTab("Yoðuþma Çizelgesi", null, getJPanel1(), null);
			jTabbedPane.addTab("Yoðuþma Grafiði", null, getJPanel2(), null);
		}
		return jTabbedPane;
	}
	/**
	 * This method initializes sinirlandirmaSartlariPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getSinirlandirmaSartlariPanel() {
		if (sinirlandirmaSartlariPanel == null) {
			jLabel21 = new JLabel();
			jLabel20 = new JLabel();
			sinirlandirmaSartlariPanel = new JPanel();
			sinirlandirmaSartlariPanel.setLayout(null);
			jLabel20.setText("Ýç Ýklim Þartlarý");
			jLabel20.setLocation(390, 11);
			jLabel20.setSize(106, 25);
			jLabel20.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			jLabel21.setText("Dýþ Ýklim Þartlarý");
			jLabel21.setLocation(499, 11);
			jLabel21.setSize(122, 25);
			jLabel21.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			sinirlandirmaSartlariPanel.add(getJPanel(), null);
			sinirlandirmaSartlariPanel.add(getJPanel3(), null);
			sinirlandirmaSartlariPanel.add(jLabel20, null);
			sinirlandirmaSartlariPanel.add(jLabel21, null);
		}
		return sinirlandirmaSartlariPanel;
	}
	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jLabel22 = new JLabel();
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BorderLayout());
			jLabel22.setText("\u03A3 Sd");
			jLabel22.setToolTipText("Toplam difüzyon dengi hava tabakasý kalýnlýðý");
			jPanel1.add(getJPanel4(), java.awt.BorderLayout.SOUTH);
			jPanel1.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
			jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() { 
				public void componentShown(java.awt.event.ComponentEvent e) {    
					updateHTMLTable();
					Iterator it = ((BinaDuvari)selectedEleman).getBilesenler().iterator();
					double toplamHavaTabakasiKalinligi = 0;
					while(it.hasNext()){						
						Bilesen bilesen = ((Bilesen)it.next());
						 toplamHavaTabakasiKalinligi += bilesen.hesaplaDifuzyonDengiHavaTabakasiKalinligi(); 
					}
					getToplamHavaTabakasiKalinligiTextField().setText(threeDigits.format(toplamHavaTabakasiKalinligi));
					getToplamIsilGecirgenlikTextField().setText(threeDigits.format(((BinaDuvari)selectedEleman).getIsiGecirgenlikKatsayisi()));
					getIsiAkisiTextField().setText(threeDigits.format(((BinaDuvari)selectedEleman).hesaplaIsiAkisi()));
				}
			});
		}
		return jPanel1;
	}

	protected void updateHTMLTable() {
	    if(selectedEleman!=null)
	    getJEditorPane().setText(((Yogusabilen)selectedEleman).getYogusmaCizelgesi());
    }
    /**s
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new GrafikPanel(selectedEleman);
			jPanel2.setLayout(null);
		}
		return jPanel2;
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
			jLabel4 = new JLabel();
			jLabel5 = new JLabel();
			jLabel12 = new JLabel();
			jLabel13 = new JLabel();
			jLabel14 = new JLabel();
			jLabel15 = new JLabel();
			jPanel.setLayout(null);
			jPanel.setBounds(158, 39, 457, 190);
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Yoðuþma Periyodu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jLabel.setText("Hava Sýcaklýðý");
			jLabel.setBounds(7, 25, 154, 25);
			jLabel1.setText("\u00B0C");
			jLabel1.setBounds(181, 25, 40, 25);
			jLabel2.setText("Baðýl Nem");
			jLabel2.setBounds(7, 57, 154, 25);
			jLabel3.setText("%");
			jLabel3.setBounds(181, 57, 40, 25);
			jLabel4.setText("Doymuþ Su Buharý Basýncý");
			jLabel4.setBounds(7, 89, 154, 25);
			jLabel5.setText("Pa");
			jLabel5.setBounds(181, 89, 40, 25);
			jLabel12.setText("Su Buharý Kýsmi Basýncý");
			jLabel12.setBounds(7, 121, 154, 25);
			jLabel13.setText("Pa");
			jLabel13.setBounds(181, 121, 40, 25);
			jLabel14.setBounds(7, 153, 154, 25);
			jLabel14.setText("Yoðuþma Süresi");
			jLabel15.setBounds(181, 153, 40, 25);
			jLabel15.setText("h");
			jPanel.add(jLabel, null);
			jPanel.add(jLabel1, null);
			jPanel.add(getYogusmaIcHavaSicakligiTextField(), null);
			jPanel.add(jLabel2, null);
			jPanel.add(jLabel3, null);
			jPanel.add(getYogusmaIcBagilNemTextField(), null);
			jPanel.add(getYogusmaDisBagilNemTextField(), null);
			jPanel.add(jLabel4, null);
			jPanel.add(jLabel5, null);
			jPanel.add(getYogusmaIcDoymusBasincTextField(), null);
			jPanel.add(getYogusmaDisDoymusBasincTextField(), null);
			jPanel.add(jLabel12, null);
			jPanel.add(jLabel13, null);
			jPanel.add(getYogusmaIcKismiBasincTextField(), null);
			jPanel.add(getYogusmaDisKismiBasincTextField(), null);
			jPanel.add(jLabel14, null);
			jPanel.add(jLabel15, null);
			jPanel.add(getYogusmaSuresiTextField(), null);
			jPanel.add(getDisHavaSicakligiComboBox(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jLabel6 = new JLabel();
			jLabel7 = new JLabel();
			jLabel8 = new JLabel();
			jLabel9 = new JLabel();
			jLabel10 = new JLabel();
			jLabel11 = new JLabel();
			jLabel16 = new JLabel();
			jLabel17 = new JLabel();
			jLabel18 = new JLabel();
			jLabel19 = new JLabel();
			jPanel3.setLayout(null);
			jLabel6.setText("Hava Sýcaklýðý");
			jLabel6.setSize(154, 25);
			jLabel6.setLocation(7, 25);
			jLabel7.setText("Baðýl Nem");
			jLabel7.setLocation(7, 57);
			jLabel7.setSize(154, 25);
			jLabel8.setText("Doymuþ Su Buharý Basýncý");
			jLabel8.setSize(154, 25);
			jLabel8.setLocation(7, 89);
			jLabel9.setText("Buharlaþma Süresi");
			jLabel9.setSize(154, 25);
			jLabel9.setLocation(7, 153);
			jLabel10.setText("Su Buharý Kýsmi Basýncý");
			jLabel10.setSize(154, 25);
			jLabel10.setLocation(7, 121);
			jPanel3.setLocation(158, 240);
			jPanel3.setSize(457, 190);
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buharlaþma Periyodu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jLabel11.setText("\u00B0C");
			jLabel11.setSize(40, 25);
			jLabel11.setLocation(181, 25);
			jLabel16.setBounds(181, 57, 40, 25);
			jLabel16.setText("%");
			jLabel17.setBounds(181, 89, 40, 25);
			jLabel17.setText("Pa");
			jLabel18.setBounds(181, 121, 40, 25);
			jLabel18.setText("Pa");
			jLabel19.setBounds(181, 153, 40, 25);
			jLabel19.setText("h");
			jPanel3.add(jLabel7, null);
			jPanel3.add(jLabel6, null);
			jPanel3.add(jLabel8, null);
			jPanel3.add(jLabel9, null);
			jPanel3.add(jLabel10, null);
			jPanel3.add(jLabel11, null);
			jPanel3.add(jLabel16, null);
			jPanel3.add(jLabel17, null);
			jPanel3.add(jLabel18, null);
			jPanel3.add(jLabel19, null);
			jPanel3.add(getBuharlasmaIcHavaSicakligiTextField(), null);
			jPanel3.add(getBuharlasmaIcBagilNemTextField(), null);
			jPanel3.add(getBuharlasmaIcDoymusBasincTextField(), null);
			jPanel3.add(getBuharlasmaIcKismiBasincTextField(), null);
			jPanel3.add(getBuharlasmaSuresiTextField(), null);
			jPanel3.add(getBuharlasmaDisHavaSicakligiTextField(), null);
			jPanel3.add(getBuharlasmaDisBagilNemTextField(), null);
			jPanel3.add(getBuharlasmaDisDoymusBasincTextField(), null);
			jPanel3.add(getBuharlasmaDisKismiBasincTextField(), null);
		}
		return jPanel3;
	}
	/**
	 * This method initializes yogusmaIcHavaSicakligiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYogusmaIcHavaSicakligiTextField() {
		if (yogusmaIcHavaSicakligiTextField == null) {
			yogusmaIcHavaSicakligiTextField = new JTextField();
			yogusmaIcHavaSicakligiTextField.setBounds(230, 25, 110, 25);
			yogusmaIcHavaSicakligiTextField.setEditable(false);
		}
		return yogusmaIcHavaSicakligiTextField;
	}
	/**
	 * This method initializes yogusmaIcBagilNemTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYogusmaIcBagilNemTextField() {
		if (yogusmaIcBagilNemTextField == null) {
			yogusmaIcBagilNemTextField = new JTextField();
			yogusmaIcBagilNemTextField.setBounds(230, 57, 110, 25);
			yogusmaIcBagilNemTextField.setEditable(false);
		}
		return yogusmaIcBagilNemTextField;
	}
	/**
	 * This method initializes yogusmaDisBagilNemTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYogusmaDisBagilNemTextField() {
		if (yogusmaDisBagilNemTextField == null) {
			yogusmaDisBagilNemTextField = new JTextField();
			yogusmaDisBagilNemTextField.setBounds(340, 57, 110, 25);
			yogusmaDisBagilNemTextField.setEditable(false);
		}
		return yogusmaDisBagilNemTextField;
	}
	/**
	 * This method initializes yogusmaIcDoymusBasincTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYogusmaIcDoymusBasincTextField() {
		if (yogusmaIcDoymusBasincTextField == null) {
			yogusmaIcDoymusBasincTextField = new JTextField();
			yogusmaIcDoymusBasincTextField.setBounds(230, 89, 110, 25);
			yogusmaIcDoymusBasincTextField.setEditable(false);
		}
		return yogusmaIcDoymusBasincTextField;
	}
	/**
	 * This method initializes yogusmaDisDoymusBasincTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYogusmaDisDoymusBasincTextField() {
		if (yogusmaDisDoymusBasincTextField == null) {
			yogusmaDisDoymusBasincTextField = new JTextField();
			yogusmaDisDoymusBasincTextField.setBounds(340, 89, 110, 25);
			yogusmaDisDoymusBasincTextField.setEditable(false);
		}
		return yogusmaDisDoymusBasincTextField;
	}
	/**
	 * This method initializes yogusmaIcKismiBasincTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYogusmaIcKismiBasincTextField() {
		if (yogusmaIcKismiBasincTextField == null) {
			yogusmaIcKismiBasincTextField = new JTextField();
			yogusmaIcKismiBasincTextField.setBounds(230, 121, 110, 25);
			yogusmaIcKismiBasincTextField.setEditable(false);
		}
		return yogusmaIcKismiBasincTextField;
	}
	/**
	 * This method initializes yogusmaDisKismiBasincTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYogusmaDisKismiBasincTextField() {
		if (yogusmaDisKismiBasincTextField == null) {
			yogusmaDisKismiBasincTextField = new JTextField();
			yogusmaDisKismiBasincTextField.setBounds(340, 121, 110, 25);
			yogusmaDisKismiBasincTextField.setEditable(false);
		}
		return yogusmaDisKismiBasincTextField;
	}
	/**
	 * This method initializes yogusmaSuresiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYogusmaSuresiTextField() {
		if (yogusmaSuresiTextField == null) {
			yogusmaSuresiTextField = new JTextField();
			yogusmaSuresiTextField.setBounds(286, 153, 110, 25);
			yogusmaSuresiTextField.setEditable(false);
		}
		return yogusmaSuresiTextField;
	}
	/**
	 * This method initializes buharlasmaIcHavaSicakligiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBuharlasmaIcHavaSicakligiTextField() {
		if (buharlasmaIcHavaSicakligiTextField == null) {
			buharlasmaIcHavaSicakligiTextField = new JTextField();
			buharlasmaIcHavaSicakligiTextField.setLocation(230, 25);
			buharlasmaIcHavaSicakligiTextField.setSize(110, 25);
			buharlasmaIcHavaSicakligiTextField.setEditable(false);
		}
		return buharlasmaIcHavaSicakligiTextField;
	}
	/**
	 * This method initializes buharlasmaIcBagilNemTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBuharlasmaIcBagilNemTextField() {
		if (buharlasmaIcBagilNemTextField == null) {
			buharlasmaIcBagilNemTextField = new JTextField();
			buharlasmaIcBagilNemTextField.setBounds(230, 57, 110, 25);
			buharlasmaIcBagilNemTextField.setEditable(false);
		}
		return buharlasmaIcBagilNemTextField;
	}
	/**
	 * This method initializes buharlasmaIcDoymusBasincTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBuharlasmaIcDoymusBasincTextField() {
		if (buharlasmaIcDoymusBasincTextField == null) {
			buharlasmaIcDoymusBasincTextField = new JTextField();
			buharlasmaIcDoymusBasincTextField.setBounds(230, 89, 110, 25);
			buharlasmaIcDoymusBasincTextField.setEditable(false);
		}
		return buharlasmaIcDoymusBasincTextField;
	}
	/**
	 * This method initializes buharlasmaIcKismiBasincTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBuharlasmaIcKismiBasincTextField() {
		if (buharlasmaIcKismiBasincTextField == null) {
			buharlasmaIcKismiBasincTextField = new JTextField();
			buharlasmaIcKismiBasincTextField.setBounds(230, 121, 110, 25);
			buharlasmaIcKismiBasincTextField.setEditable(false);
		}
		return buharlasmaIcKismiBasincTextField;
	}
	/**
	 * This method initializes buharlasmaSuresiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBuharlasmaSuresiTextField() {
		if (buharlasmaSuresiTextField == null) {
			buharlasmaSuresiTextField = new JTextField();
			buharlasmaSuresiTextField.setSize(110, 25);
			buharlasmaSuresiTextField.setLocation(286, 153);
			buharlasmaSuresiTextField.setEditable(false);
		}
		return buharlasmaSuresiTextField;
	}
	/**
	 * This method initializes buharlasmaDisHavaSicakligiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBuharlasmaDisHavaSicakligiTextField() {
		if (buharlasmaDisHavaSicakligiTextField == null) {
			buharlasmaDisHavaSicakligiTextField = new JTextField();
			buharlasmaDisHavaSicakligiTextField.setSize(110, 25);
			buharlasmaDisHavaSicakligiTextField.setLocation(340, 25);
			buharlasmaDisHavaSicakligiTextField.setEditable(false);
		}
		return buharlasmaDisHavaSicakligiTextField;
	}
	/**
	 * This method initializes buharlasmaDisBagilNemTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBuharlasmaDisBagilNemTextField() {
		if (buharlasmaDisBagilNemTextField == null) {
			buharlasmaDisBagilNemTextField = new JTextField();
			buharlasmaDisBagilNemTextField.setBounds(340, 57, 110, 25);
			buharlasmaDisBagilNemTextField.setEditable(false);
		}
		return buharlasmaDisBagilNemTextField;
	}
	/**
	 * This method initializes buharlasmaDisDoymusBasincTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBuharlasmaDisDoymusBasincTextField() {
		if (buharlasmaDisDoymusBasincTextField == null) {
			buharlasmaDisDoymusBasincTextField = new JTextField();
			buharlasmaDisDoymusBasincTextField.setBounds(340, 89, 110, 25);
			buharlasmaDisDoymusBasincTextField.setEditable(false);
		}
		return buharlasmaDisDoymusBasincTextField;
	}
	/**
	 * This method initializes buharlasmaDisKismiBasincTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBuharlasmaDisKismiBasincTextField() {
		if (buharlasmaDisKismiBasincTextField == null) {
			buharlasmaDisKismiBasincTextField = new JTextField();
			buharlasmaDisKismiBasincTextField.setBounds(340, 121, 110, 25);
			buharlasmaDisKismiBasincTextField.setEditable(false);
		}
		return buharlasmaDisKismiBasincTextField;
	}
	/**
	 * This method initializes disHavaSicakligiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getDisHavaSicakligiComboBox() {
		if (disHavaSicakligiComboBox == null) {
		    String[] values = {"-3","-10"};
			disHavaSicakligiComboBox = new JComboBox(values);
			disHavaSicakligiComboBox.setBounds(340, 25, 110, 25);
			disHavaSicakligiComboBox.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					selectedEleman.setSinirlamaSartlariDisSicaklik(Double.parseDouble((String)disHavaSicakligiComboBox.getSelectedItem()));
					updateSelf();
				}
			});
		}
		return disHavaSicakligiComboBox;
	}
	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */    
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setEditable(false);
			jEditorPane.setContentType("text/html");
//			try {
//                jEditorPane.setPage(getClass().getResource("sampletable.htm"));
//                jEditorPane.setBackground(new java.awt.Color(238,238,238));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
		}
		return jEditorPane;
	}
	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jLabel29 = new JLabel();
			jLabel28 = new JLabel();
			jLabel27 = new JLabel();
			jLabel26 = new JLabel();
			jLabel25 = new JLabel();
			jLabel24 = new JLabel();
			jLabel23 = new JLabel();
			jPanel4 = new JPanel();
			jLabel23.setText("m");
			jLabel24.setText("U");
			jLabel24.setToolTipText("Isýl geçirgenlik deðeri");
			jLabel25.setText("<HTML>W/m<SUP>2</SUP>K</HTML>");
			jLabel26.setText("q");
			jLabel26.setToolTipText("Isý akýsý");
			jLabel27.setText("<HTML>W/m<SUP>2</SUP></HTML>");
			jLabel28.setText("                ");
			jLabel29.setText("                ");
			jPanel4.add(jLabel22, null);
			jPanel4.add(getToplamHavaTabakasiKalinligiTextField(), null);
			jPanel4.add(jLabel23, null);
			jPanel4.add(jLabel28, null);
			jPanel4.add(jLabel24, null);
			jPanel4.add(getToplamIsilGecirgenlikTextField(), null);
			jPanel4.add(jLabel25, null);
			jPanel4.add(jLabel29, null);
			jPanel4.add(jLabel26, null);
			jPanel4.add(getIsiAkisiTextField(), null);
			jPanel4.add(jLabel27, null);
		}
		return jPanel4;
	}
	/**
	 * This method initializes toplamHavaTabakasiKalinligiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getToplamHavaTabakasiKalinligiTextField() {
		if (toplamHavaTabakasiKalinligiTextField == null) {
			toplamHavaTabakasiKalinligiTextField = new JTextField();
			toplamHavaTabakasiKalinligiTextField.setPreferredSize(new java.awt.Dimension(40,20));
			toplamHavaTabakasiKalinligiTextField.setEditable(false);
		}
		return toplamHavaTabakasiKalinligiTextField;
	}
	/**
	 * This method initializes toplamIsilGecirgenlikTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getToplamIsilGecirgenlikTextField() {
		if (toplamIsilGecirgenlikTextField == null) {
			toplamIsilGecirgenlikTextField = new JTextField();
			toplamIsilGecirgenlikTextField.setPreferredSize(new java.awt.Dimension(40,20));
			toplamIsilGecirgenlikTextField.setEditable(false);
		}
		return toplamIsilGecirgenlikTextField;
	}
	/**
	 * This method initializes isiAkisiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIsiAkisiTextField() {
		if (isiAkisiTextField == null) {
			isiAkisiTextField = new JTextField();
			isiAkisiTextField.setPreferredSize(new java.awt.Dimension(40,20));
			isiAkisiTextField.setEditable(false);
		}
		return isiAkisiTextField;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJEditorPane());
		}
		return jScrollPane;
	}
    /**
     * 
     */
    public void updateSelf() {
        if(selectedEleman!=null){
            getYogusmaIcHavaSicakligiTextField().setText(""+selectedEleman.getYOGUSMA_IC_SICAKLIK());
            getYogusmaIcBagilNemTextField().setText(""+selectedEleman.getIC_BAGIL_NEM());
            getYogusmaIcDoymusBasincTextField().setText(""+selectedEleman.getIC_DOYMUS_SU_BUHARI_BASINCI());
            getYogusmaIcKismiBasincTextField().setText(""+selectedEleman.getIC_SU_BUHARI_KISMI_BASINCI());
            getYogusmaDisBagilNemTextField().setText(""+selectedEleman.getDIS_BAGIL_NEM());
            getYogusmaDisDoymusBasincTextField().setText(""+selectedEleman.getDisDoymusSuBuhariBasinci());
            getYogusmaDisKismiBasincTextField().setText(""+selectedEleman.getDisSuBuhariKismiBasinci());
            getYogusmaSuresiTextField().setText(""+selectedEleman.getYOGUSMA_SURESI());
            
            getBuharlasmaIcHavaSicakligiTextField().setText(""+selectedEleman.getBUHARLASMA_HAVA_SICAKLIGI());
            getBuharlasmaIcBagilNemTextField().setText(""+selectedEleman.getBUHARLASMA_BAGIL_NEM());
            getBuharlasmaIcDoymusBasincTextField().setText(""+selectedEleman.getBUHARLASMA_DOYMUS_SU_BUHARI_BASINCI());
            getBuharlasmaIcKismiBasincTextField().setText(""+selectedEleman.getBUHARLASMA_SU_BUHARI_KISMI_BASINCI());
            getBuharlasmaDisHavaSicakligiTextField().setText(""+selectedEleman.getBUHARLASMA_HAVA_SICAKLIGI());
            getBuharlasmaDisBagilNemTextField().setText(""+selectedEleman.getBUHARLASMA_BAGIL_NEM());
            getBuharlasmaDisDoymusBasincTextField().setText(""+selectedEleman.getBUHARLASMA_DOYMUS_SU_BUHARI_BASINCI());
            getBuharlasmaDisKismiBasincTextField().setText(""+selectedEleman.getBUHARLASMA_SU_BUHARI_KISMI_BASINCI());
            getBuharlasmaSuresiTextField().setText(""+selectedEleman.getBUHARLASMA_SURESI());
            }
    }
	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.add(getTamamButton(), null);
		}
		return jPanel5;
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
					dispose();
				}
			});
		}
		return tamamButton;
	}
             }  //  @jve:decl-index=0:visual-constraint="10,10"
