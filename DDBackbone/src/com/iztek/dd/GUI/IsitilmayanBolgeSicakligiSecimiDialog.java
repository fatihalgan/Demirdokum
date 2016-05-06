/*
 * Created on 01.Þub.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.iztek.dd.GUI.ddtree.item.DuvarTreeItemPanel;
import com.iztek.dd.GUI.ddtree.item.TreeItemPanel;
import com.iztek.dd.IsiKaybi.IsitilmayanBolgeSicakliklari;
import com.iztek.dd.utilities.Il;
/**
 * @author Selim HENDRICKSON
 *
 */
public class IsitilmayanBolgeSicakligiSecimiDialog extends JDialog {
    private TreeItemPanel originatingPanel = null;
    
	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel4 = null;
	ButtonGroup buttonGroup = new ButtonGroup();	
	private JRadioButton kucukURadioButton = null;
	private JRadioButton ortaURadioButton = null;
	private JRadioButton buyukURadioButton = null;
	private JRadioButton iceriyeAcikRadioButton = null;
	private JRadioButton disariyaAcikRadioButton = null;
	private JRadioButton dosemeAltindaRadioButton = null;
	private JRadioButton disDuvaraBitisikRadioButton = null;
	private JRadioButton merkeziIsitimaliRadioButton = null;
	private JRadioButton mahalliIsitmaliRadioButton = null;
	private JRadioButton kazanDairesiRadioButton = null;
	private JRadioButton komurlukRadioButton = null;
	private JTextField secilenSicaklikDegeriTextField = null;
	private JLabel birimLabel = null;
	private JLabel secilenSicaklikDegeriLabel = null;
	private JLabel birimLabel2 = null;
	private JButton tamamButton = null;
	private JButton vazgecButton = null;
	/**
	 * This is the default constructor
	 */
	public IsitilmayanBolgeSicakligiSecimiDialog(TreeItemPanel activePanel){
		super();
		initialize();
		this.originatingPanel = activePanel;
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(514, 533);
		this.setContentPane(getJContentPane());
		buttonGroup.add(getKucukURadioButton());
		buttonGroup.add(getOrtaURadioButton());
		buttonGroup.add(getBuyukURadioButton());
		buttonGroup.add(getIceriyeAcikRadioButton());
		buttonGroup.add(getDisariyaAcikRadioButton());
		buttonGroup.add(getDosemeAltindaRadioButton());
		buttonGroup.add(getDisDuvaraBitisikRadioButton());
		buttonGroup.add(getMerkeziIsitimaliRadioButton());
		buttonGroup.add(getMahalliIsitmaliRadioButton());
		buttonGroup.add(getKazanDairesiRadioButton());
		buttonGroup.add(getKomurlukRadioButton());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			birimLabel2 = new JLabel();
			secilenSicaklikDegeriLabel = new JLabel();
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			secilenSicaklikDegeriLabel.setBounds(59, 412, 131, 24);
			secilenSicaklikDegeriLabel.setText("Seçilen sýcaklýk deðeri");
			birimLabel2.setBounds(345, 412, 34, 24);
			birimLabel2.setText("\u00b0C");
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(getJPanel2(), null);
			jContentPane.add(getJPanel3(), null);
			jContentPane.add(getJPanel4(), null);
			jContentPane.add(getSecilenSicaklikDegeriTextField(), null);
			jContentPane.add(secilenSicaklikDegeriLabel, null);
			jContentPane.add(birimLabel2, null);
			jContentPane.add(getTamamButton(), null);
			jContentPane.add(getVazgecButton(), null);
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
			birimLabel = new JLabel();
			jPanel.setBounds(12, 7, 488, 73);
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Çatý arasýnda ýsýtýlmayan mahaller", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			birimLabel.setText("<HTML>W/m<SUP>2</SUP>K</HTML>");
			jPanel.add(birimLabel, null);
			jPanel.add(getKucukURadioButton(), null);
			jPanel.add(getOrtaURadioButton(), null);
			jPanel.add(getBuyukURadioButton(), null);
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
			jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
			jPanel1.setBounds(12, 87, 488, 73);
			jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Isýtýlmamýþ mahaller", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
			jPanel1.add(getIceriyeAcikRadioButton(), null);
			jPanel1.add(getDisariyaAcikRadioButton(), null);
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
			jPanel2.setBounds(12, 167, 488, 73);
			jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Toprak sýcaklýðý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel2.add(getDosemeAltindaRadioButton(), null);
			jPanel2.add(getDisDuvaraBitisikRadioButton(), null);
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
			jPanel3.setBounds(12, 247, 488, 73);
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evlerin bitiþik sýcaklýðý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel3.add(getMerkeziIsitimaliRadioButton(), null);
			jPanel3.add(getMahalliIsitmaliRadioButton(), null);
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
			jPanel4.setBounds(12, 327, 488, 73);
			jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diðer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel4.add(getKazanDairesiRadioButton(), null);
			jPanel4.add(getKomurlukRadioButton(), null);
		}
		return jPanel4;
	}
	/**
	 * This method initializes kucukURadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getKucukURadioButton() {
		if (kucukURadioButton == null) {
			kucukURadioButton = new JRadioButton();
			kucukURadioButton.setText("U < 2.33");
			kucukURadioButton.setActionCommand("KucukU");
			kucukURadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return kucukURadioButton;
	}
	/**
	 * This method initializes ortaURadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getOrtaURadioButton() {
		if (ortaURadioButton == null) {
			ortaURadioButton = new JRadioButton();
			ortaURadioButton.setText("2.33 < U < 5.82");
			ortaURadioButton.setActionCommand("OrtaU");
			ortaURadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return ortaURadioButton;
	}
	/**
	 * This method initializes buyukURadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getBuyukURadioButton() {
		if (buyukURadioButton == null) {
			buyukURadioButton = new JRadioButton();
			buyukURadioButton.setText("5.82 < U");
			buyukURadioButton.setActionCommand("BuyukU");
			buyukURadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return buyukURadioButton;
	}
	/**
	 * This method initializes iceriyeAcikRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getIceriyeAcikRadioButton() {
		if (iceriyeAcikRadioButton == null) {
			iceriyeAcikRadioButton = new JRadioButton();
			iceriyeAcikRadioButton.setText("Ýçeriye veya bodruma kapý ya da pencereli, bir kýsmý ýsýtýlmýþ mahallerle çevrili");
			iceriyeAcikRadioButton.setActionCommand("IceriAcik");
			iceriyeAcikRadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return iceriyeAcikRadioButton;
	}
	/**
	 * This method initializes disariyaAcikRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDisariyaAcikRadioButton() {
		if (disariyaAcikRadioButton == null) {
			disariyaAcikRadioButton = new JRadioButton();
			disariyaAcikRadioButton.setText("Dýþa kapý veya pencereli bir kýsmý ýsýtýlmýþ mahallerle çevrili");
			disariyaAcikRadioButton.setActionCommand("DisaAcik");
			disariyaAcikRadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return disariyaAcikRadioButton;
	}
	/**
	 * This method initializes dosemeAltindaRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDosemeAltindaRadioButton() {
		if (dosemeAltindaRadioButton == null) {
			dosemeAltindaRadioButton = new JRadioButton();
			dosemeAltindaRadioButton.setText("Döþeme altýndaki");
			dosemeAltindaRadioButton.setActionCommand("DosemeAltinda");
			dosemeAltindaRadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return dosemeAltindaRadioButton;
	}
	/**
	 * This method initializes disDuvaraBitisikRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDisDuvaraBitisikRadioButton() {
		if (disDuvaraBitisikRadioButton == null) {
			disDuvaraBitisikRadioButton = new JRadioButton();
			disDuvaraBitisikRadioButton.setText("Dýþ duvara bitiþik");
			disDuvaraBitisikRadioButton.setActionCommand("DisaBitisik");
			disDuvaraBitisikRadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return disDuvaraBitisikRadioButton;
	}
	/**
	 * This method initializes merkeziIsitimaliRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getMerkeziIsitimaliRadioButton() {
		if (merkeziIsitimaliRadioButton == null) {
			merkeziIsitimaliRadioButton = new JRadioButton();
			merkeziIsitimaliRadioButton.setText("Merkezi ýsýtmalý");
			merkeziIsitimaliRadioButton.setActionCommand("Merkezi");
			merkeziIsitimaliRadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return merkeziIsitimaliRadioButton;
	}
	/**
	 * This method initializes mahalliIsitmaliRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getMahalliIsitmaliRadioButton() {
		if (mahalliIsitmaliRadioButton == null) {
			mahalliIsitmaliRadioButton = new JRadioButton();
			mahalliIsitmaliRadioButton.setText("Mahalli ýsýtmalý");
			mahalliIsitmaliRadioButton.setActionCommand("Mahalli");
			mahalliIsitmaliRadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return mahalliIsitmaliRadioButton;
	}
	/**
	 * This method initializes kazanDairesiRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getKazanDairesiRadioButton() {
		if (kazanDairesiRadioButton == null) {
			kazanDairesiRadioButton = new JRadioButton();
			kazanDairesiRadioButton.setText("Isitici dairesi");
			kazanDairesiRadioButton.setActionCommand("Isitici");
			kazanDairesiRadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return kazanDairesiRadioButton;
	}
	/**
	 * This method initializes komurlukRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getKomurlukRadioButton() {
		if (komurlukRadioButton == null) {
			komurlukRadioButton = new JRadioButton();
			komurlukRadioButton.setText("Kömürlük");
			komurlukRadioButton.setActionCommand("Komurluk ");
			komurlukRadioButton.addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
		}
		return komurlukRadioButton;
	}
	/**
	 * This method initializes secilenSicaklikDegeriTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getSecilenSicaklikDegeriTextField() {
		if (secilenSicaklikDegeriTextField == null) {
			secilenSicaklikDegeriTextField = new JTextField();
			secilenSicaklikDegeriTextField.setBounds(208, 412, 132, 24);
			secilenSicaklikDegeriTextField.setEditable(false);
		}
		return secilenSicaklikDegeriTextField;
	}
	/**
	 * This method initializes tamamButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTamamButton() {
		if (tamamButton == null) {
			tamamButton = new JButton();
			tamamButton.setBounds(135, 456, 102, 27);
			tamamButton.setText("Tamam");
			tamamButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((DuvarTreeItemPanel)originatingPanel).setDisOrtamSicakligiTextFieldText(secilenSicaklikDegeriTextField.getText());
					((DuvarTreeItemPanel)originatingPanel).getActiveDuvar().setDisSicaklik(Double.parseDouble(secilenSicaklikDegeriTextField.getText()));
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
			vazgecButton.setBounds(255, 456, 102, 27);
			vazgecButton.setText("Vazgeç");
			vazgecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					dispose();
				}
			});
		}
		return vazgecButton;
	}

	public void setKucukURadioButtonActionCommand(String string) {
	    getKucukURadioButton().setActionCommand(string);
    }

	public void setOrtaURadioButtonActionCommand(String string) {	    
        getOrtaURadioButton().setActionCommand(string);
    }

	public void setBuyukURadioButtonActionCommand(String string) {
        getBuyukURadioButton().setActionCommand(string);
    }

	public void setSecilenSicaklikDegeriTextFieldText(int kucuk) {
	    getSecilenSicaklikDegeriTextField().setText(""+kucuk);
    }

	public void addKucukURadioButtonActionListener(ActionListener isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener) {
	    getKucukURadioButton().addActionListener(isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener);
    }

	ActionListener isitilmayanBolgeSicakligiSecimiDialogRadioButtonListener = new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
            String command = arg0.getActionCommand();
            Il il = ((DuvarTreeItemPanel)originatingPanel).getActiveDuvar().getMahal().getKat().getBina().getProje().getIl();
            double disSicaklik = 0;
            if(il!=null)disSicaklik = il.getIsiKaybiDisSicaklik();
            if(command=="KucukU") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getUKucuk());        
            if(command=="OrtaU") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getUOrta());
            if(command=="BuyukU") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getUBuyuk());
            if(command=="IceriAcik") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getIceAcik());
            if(command=="DisaAcik") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getDisaAcik());
            if(command=="DosemeAltinda") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getDosemeAltinda());
            if(command=="DisaBitisik") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getDisDuvaraBitisik());
            if(command=="Merkezi") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getMerkeziIsitmali());
            if(command=="Mahalli") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getMahalliIsitmali());
            if(command=="Isitici") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getKazanDairesi());
            if(command=="Komurluk") setSecilenSicaklikDegeriTextFieldText(IsitilmayanBolgeSicakliklari.getInstance().getIleGoreIsitilmayanBolgeSicakliklari(""+disSicaklik).getKomurluk());
        }
	};

}  //  @jve:decl-index=0:visual-constraint="10,10"
