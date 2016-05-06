package com.iztek.dd.GUI;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
public class MekanikHavalandirmaDialog extends JDialog
{

    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -7928064085650962432L;
	
	public MekanikHavalandirmaDialog()
    {
        jContentPane = null;
        jPanel = null;
        jPanel1 = null;
        jPanel2 = null;
        jPanel3 = null;
        havaGirisDebiLabel = null;
        havaCikisDebiLabel = null;
        birimLabel = null;
        birimLabel1 = null;
        havaDegisimDebiLabel = null;
        birimLabel2 = null;
        havaGirisDebiTextField = null;
        havaDegisimDebiTextField = null;
        havaCikisDebiTextField = null;
        yuzeySayisiLabel = null;
        esit1RadioButton = null;
        buyuk1RadioButton = null;
        acikAlanLabel = null;
        agacliLabel = null;
        sehirMerkezindeLabel = null;
        korumasizRadioButton = null;
        tamKorumaliRadioButton = null;
        yariKorumaliRadioButton = null;
        surekliLabel = null;
        aralikliLabel = null;
        feedbackLabel = null;
        surekliRadioButton = null;
        aralikliRadioButton = null;
        feedbackCheckBox = null;
        jPanel4 = null;
        havaDegisimSayisiLabel = null;
        havaDegisimSayisiTextField = null;
        initialize();
    }

    private void initialize()
    {
        setSize(600, 600);
        setContentPane(getJContentPane());
    }

    private JPanel getJContentPane()
    {
        if(jContentPane == null)
        {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.setPreferredSize(new Dimension(0, 0));
            jContentPane.add(getJPanel(), null);
            jContentPane.add(getJPanel1(), null);
            jContentPane.add(getJPanel2(), null);
            jContentPane.add(getJPanel3(), null);
            jContentPane.add(getJPanel4(), null);
            jContentPane.add(getJPanel5(), null);
            jContentPane.add(getJPanel6(), null);
        }
        return jContentPane;
    }

    private JPanel getJPanel()
    {
        if(jPanel == null)
        {
            birimLabel5 = new JLabel();
            birimLabel4 = new JLabel();
            birimLabel3 = new JLabel();
            jPanel = new JPanel();
            havaGirisDebiLabel = new JLabel();
            havaCikisDebiLabel = new JLabel();
            birimLabel = new JLabel();
            birimLabel1 = new JLabel();
            havaDegisimDebiLabel = new JLabel();
            birimLabel2 = new JLabel();
            jPanel.setLayout(null);
            jPanel.setBounds(31, 4, 533, 89);
            jPanel.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, null, null));
            havaGirisDebiLabel.setBounds(39, 6, 172, 21);
            havaGirisDebiLabel.setText("Hava giriþ debisi");
            havaCikisDebiLabel.setBounds(39, 33, 172, 21);
            havaCikisDebiLabel.setText("Hava çýkýþ debisi");
            birimLabel.setBounds(395, 6, 39, 21);
            birimLabel.setText("<HTML>m<SUP>3</SUP>/h</HTML>");
            birimLabel1.setBounds(395, 33, 39, 21);
            birimLabel1.setText("<HTML>m<SUP>3</SUP>/h</HTML>");
            havaDegisimDebiLabel.setBounds(39, 60, 172, 21);
            havaDegisimDebiLabel.setText("Hacimsel hava deðiþim debisi");
            birimLabel2.setText("<HTML>m<SUP>3</SUP>/h</HTML>");
            birimLabel2.setSize(39, 21);
            birimLabel2.setLocation(395, 60);
            birimLabel3.setBounds(217, 6, 23, 21);
            birimLabel3.setText("<HTML>V<SUB>S</SUB></HTML>");
            birimLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            birimLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
            birimLabel4.setBounds(217, 33, 23, 21);
            birimLabel4.setText("<HTML>V<SUB>E</SUB></HTML>");
            birimLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            birimLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
            birimLabel5.setBounds(217, 60, 23, 21);
            birimLabel5.setText("<HTML>V<SUB>f</SUB></HTML>");
            birimLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            birimLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
            jPanel.add(havaGirisDebiLabel, null);
            jPanel.add(havaCikisDebiLabel, null);
            jPanel.add(birimLabel, null);
            jPanel.add(birimLabel1, null);
            jPanel.add(havaDegisimDebiLabel, null);
            jPanel.add(birimLabel2, null);
            jPanel.add(getHavaGirisDebiTextField(), null);
            jPanel.add(getHavaDegisimDebiTextField(), null);
            jPanel.add(getHavaCikisDebiTextField(), null);
            jPanel.add(birimLabel3, null);
            jPanel.add(birimLabel4, null);
            jPanel.add(birimLabel5, null);
        }
        return jPanel;
    }

    private JPanel getJPanel1()
    {
        if(jPanel1 == null)
        {
            jPanel1 = new JPanel();
            yuzeySayisiLabel = new JLabel();
            jPanel1.setLayout(null);
            jPanel1.setBounds(31, 97, 533, 58);
            jPanel1.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, null, null));
            yuzeySayisiLabel.setBounds(20, 16, 219, 20);
            yuzeySayisiLabel.setText("Binada d\u0131\u015F ortama a\347\u0131k y\374zey say\u0131s\u0131 f");
            jPanel1.add(yuzeySayisiLabel, null);
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(getEsit1RadioButton());
            buttonGroup.add(getBuyuk1RadioButton());
            jPanel1.add(getEsit1RadioButton(), null);
            jPanel1.add(getBuyuk1RadioButton(), null);
        }
        return jPanel1;
    }

    private JPanel getJPanel2()
    {
        if(jPanel2 == null)
        {
            jPanel2 = new JPanel();
            acikAlanLabel = new JLabel();
            agacliLabel = new JLabel();
            sehirMerkezindeLabel = new JLabel();
            jPanel2.setLayout(null);
            jPanel2.setBounds(31, 159, 533, 103);
            jPanel2.setBorder(BorderFactory.createTitledBorder(null, "e de\u011Feri", 0, 0, new Font("Dialog", 1, 12), new Color(51, 51, 51)));
            acikAlanLabel.setText("A\347\u0131k alanda veya \u015Fehir i\347indeki 10 kattan y\374ksek binalar");
            acikAlanLabel.setSize(325, 21);
            acikAlanLabel.setLocation(20, 17);
            agacliLabel.setBounds(20, 44, 325, 21);
            agacliLabel.setText("\307evresi a\u011Fa\347 veya di\u011Fer binalarla k\u0131smen korunan binalar");
            sehirMerkezindeLabel.setBounds(20, 71, 325, 21);
            sehirMerkezindeLabel.setText("Þehir merkezlerindeki 10 kattan daha az katlý binalar");
            jPanel2.add(acikAlanLabel, null);
            jPanel2.add(agacliLabel, null);
            jPanel2.add(sehirMerkezindeLabel, null);
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(getKorumasizRadioButton());
            buttonGroup.add(getTamKorumaliRadioButton());
            buttonGroup.add(getYariKorumaliRadioButton());
            jPanel2.add(getKorumasizRadioButton(), null);
            jPanel2.add(getTamKorumaliRadioButton(), null);
            jPanel2.add(getYariKorumaliRadioButton(), null);
        }
        return jPanel2;
    }

    private JPanel getJPanel3()
    {
        if(jPanel3 == null)
        {
            feedbackLabel = new JLabel();
            aralikliLabel = new JLabel();
            surekliLabel = new JLabel();
            jPanel3 = new JPanel();
            jPanel3.setLayout(null);
            jPanel3.setBounds(31, 266, 533, 101);
            jPanel3.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, null, null));
            surekliLabel.setBounds(20, 9, 421, 21);
            surekliLabel.setText("Havaland\u0131rma sistemi s\374rekli kararl\u0131 halde \347al\u0131\u015F\u0131yor");
            aralikliLabel.setBounds(20, 39, 421, 21);
            aralikliLabel.setText("Havaland\u0131rma sistemi g\374n i\347inde zaman zaman kapat\u0131l\u0131yor");
            feedbackLabel.setBounds(20, 69, 421, 21);
            feedbackLabel.setText("Sistemden d\u0131\u015Far\u0131 at\u0131lan hava sisteme verilen havay\u0131 \u0131s\u0131tma i\347in kullan\u0131yor");
            feedbackLabel.setToolTipText("Is\u0131 geri kazan\u0131m sistemi var");
            jPanel3.add(surekliLabel, null);
            jPanel3.add(aralikliLabel, null);
            jPanel3.add(feedbackLabel, null);
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(getSurekliRadioButton());
            buttonGroup.add(getAralikliRadioButton());
            jPanel3.add(getSurekliRadioButton(), null);
            jPanel3.add(getAralikliRadioButton(), null);
            jPanel3.add(getFeedbackCheckBox(), null);
        }
        return jPanel3;
    }

    private JTextField getHavaGirisDebiTextField()
    {
        if(havaGirisDebiTextField == null)
        {
            havaGirisDebiTextField = new JTextField();
            havaGirisDebiTextField.setBounds(256, 6, 125, 21);
            havaGirisDebiTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        }
        return havaGirisDebiTextField;
    }

    private JTextField getHavaDegisimDebiTextField()
    {
        if(havaDegisimDebiTextField == null)
        {
            havaDegisimDebiTextField = new JTextField();
            havaDegisimDebiTextField.setBounds(256, 60, 125, 21);
        }
        return havaDegisimDebiTextField;
    }

    private JTextField getHavaCikisDebiTextField()
    {
        if(havaCikisDebiTextField == null)
        {
            havaCikisDebiTextField = new JTextField();
            havaCikisDebiTextField.setBounds(256, 33, 125, 21);
        }
        return havaCikisDebiTextField;
    }

    private JRadioButton getEsit1RadioButton()
    {
        if(esit1RadioButton == null)
        {
            esit1RadioButton = new JRadioButton();
            esit1RadioButton.setText("1");
            esit1RadioButton.setSize(44, 21);
            esit1RadioButton.setLocation(395, 7);
        }
        return esit1RadioButton;
    }

    private JRadioButton getBuyuk1RadioButton()
    {
        if(buyuk1RadioButton == null)
        {
            buyuk1RadioButton = new JRadioButton();
            buyuk1RadioButton.setText(">1");
            buyuk1RadioButton.setSize(44, 21);
            buyuk1RadioButton.setLocation(395, 33);
        }
        return buyuk1RadioButton;
    }

    private JRadioButton getKorumasizRadioButton()
    {
        if(korumasizRadioButton == null)
        {
            korumasizRadioButton = new JRadioButton();
            korumasizRadioButton.setText("Korumas\u0131z");
            korumasizRadioButton.setSize(111, 21);
            korumasizRadioButton.setLocation(395, 17);
        }
        return korumasizRadioButton;
    }

    private JRadioButton getTamKorumaliRadioButton()
    {
        if(tamKorumaliRadioButton == null)
        {
            tamKorumaliRadioButton = new JRadioButton();
            tamKorumaliRadioButton.setBounds(395, 71, 111, 21);
            tamKorumaliRadioButton.setText("Tam korumal\u0131");
        }
        return tamKorumaliRadioButton;
    }

    private JRadioButton getYariKorumaliRadioButton()
    {
        if(yariKorumaliRadioButton == null)
        {
            yariKorumaliRadioButton = new JRadioButton();
            yariKorumaliRadioButton.setBounds(395, 44, 111, 21);
            yariKorumaliRadioButton.setText("Yar\u0131 korumal\u0131");
        }
        return yariKorumaliRadioButton;
    }

    private JRadioButton getSurekliRadioButton()
    {
        if(surekliRadioButton == null)
        {
            surekliRadioButton = new JRadioButton();
            surekliRadioButton.setBounds(474, 9, 21, 21);
        }
        return surekliRadioButton;
    }

    private JRadioButton getAralikliRadioButton()
    {
        if(aralikliRadioButton == null)
        {
            aralikliRadioButton = new JRadioButton();
            aralikliRadioButton.setBounds(474, 39, 21, 21);
            aralikliRadioButton.addItemListener(new java.awt.event.ItemListener() { 
            	public void itemStateChanged(java.awt.event.ItemEvent e) {    
            		boolean state = getAralikliRadioButton().isSelected();
            		getFansizHavaDegisimDebiTextField().setEnabled(state);
            		getFanCalismaOraniTextField().setEnabled(state);
            	}
            });
        }
        return aralikliRadioButton;
    }

    private JCheckBox getFeedbackCheckBox()
    {
        if(feedbackCheckBox == null)
        {
            feedbackCheckBox = new JCheckBox();
            feedbackCheckBox.setBounds(474, 69, 21, 21);
            feedbackCheckBox.addItemListener(new java.awt.event.ItemListener() { 
            	public void itemStateChanged(java.awt.event.ItemEvent e) {    
            		boolean state = getFeedbackCheckBox().isSelected();
            		getFeedbackVerimTextField().setEnabled(state);
            	}
            });
        }
        return feedbackCheckBox;
    }

    private JPanel getJPanel4()
    {
        if(jPanel4 == null)
        {
            birimLabel6 = new JLabel();
            jPanel4 = new JPanel();
            havaDegisimSayisiLabel = new JLabel();
            jPanel4.setLayout(null);
            jPanel4.setBounds(29, 476, 533, 42);
            jPanel4.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, null, null));
            jPanel4.setToolTipText("<html> " +
            		"<p>Bina dýþ kabuðunun sýzdýrmazlýk seviyesine göre alýnabilecek n<sub>50</sub>" +
            		"  deðerleri</p>" +
            		"  <table border=1>" +
            		"  	<tr>" +
            		"		<td><B>katta birden fazla daire varsa</B></td>" +
            		"		<td><B>katta bir daire varsa</B></td>" +
            		"		<td><B>Bina dýþ kabuðunun sýzdýrmazlýðý</B></td>" +
            		"	</tr>" +
            		"	<tr>" +
            		"		<td>2'den küçük</td>" +
            		"		<td>4'den küçük</td>" +
            		"		<td>Ýyi</td>" +
            		"	</tr>" +
            		"	<tr>" +
            		"		<td>2-5 arasý</td>" +
            		"		<td>4-10 arasý</td>" +
            		"		<td>Orta</td>" +
            		"	</tr>" +
            		"	<tr>" +
            		"		<td>5'den büyük</td>" +
            		"		<td>10'dan büyük</td>" +
            		"		<td>Kötü</td>" +
            		"	</tr>" +
            		"  </table>" +
            		"</html>");
            havaDegisimSayisiLabel.setText("Ýç ve dýþ ortam arasýnda 50 Pa basýnç farký varken hava deðiþim sayýsý");
            havaDegisimSayisiLabel.setSize(404, 21);
            havaDegisimSayisiLabel.setLocation(18, 10);
            birimLabel6.setText("<HTML>n<SUB>50</SUB></HTML>");
            birimLabel6.setLocation(427, 10);
            birimLabel6.setSize(23, 21);
            jPanel4.add(havaDegisimSayisiLabel, null);
            jPanel4.add(getHavaDegisimSayisiTextField(), null);
            jPanel4.add(birimLabel6, null);
        }
        return jPanel4;
    }

    private JTextField getHavaDegisimSayisiTextField()
    {
        if(havaDegisimSayisiTextField == null)
        {
            havaDegisimSayisiTextField = new JTextField();
            havaDegisimSayisiTextField.setBounds(454, 10, 65, 21);
        }
        return havaDegisimSayisiTextField;
    }

    private JPanel jContentPane;
    private JPanel jPanel;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JLabel havaGirisDebiLabel;
    private JLabel havaCikisDebiLabel;
    private JLabel birimLabel;
    private JLabel birimLabel1;
    private JLabel havaDegisimDebiLabel;
    private JLabel birimLabel2;
    private JTextField havaGirisDebiTextField;
    private JTextField havaDegisimDebiTextField;
    private JTextField havaCikisDebiTextField;
    private JLabel yuzeySayisiLabel;
    private JRadioButton esit1RadioButton;
    private JRadioButton buyuk1RadioButton;
    private JLabel acikAlanLabel;
    private JLabel agacliLabel;
    private JLabel sehirMerkezindeLabel;
    private JRadioButton korumasizRadioButton;
    private JRadioButton tamKorumaliRadioButton;
    private JRadioButton yariKorumaliRadioButton;
    private JLabel surekliLabel;
    private JLabel aralikliLabel;
    private JLabel feedbackLabel;
    private JRadioButton surekliRadioButton;
    private JRadioButton aralikliRadioButton;
    private JCheckBox feedbackCheckBox;
    private JPanel jPanel4;
    private JLabel havaDegisimSayisiLabel;
    private JTextField havaDegisimSayisiTextField;
	private JPanel jPanel5 = null;
	private JButton tamamButton = null;
	private JButton vazgecButton = null;
	private JPanel jPanel6 = null;
	private JTextField fansizHavaDegisimDebiTextField = null;
	private JLabel fanCalismaOraniLabel = null;
	private JLabel birimLabel7 = null;
	private JTextField fanCalismaOraniTextField = null;
	private JLabel feedbackVerimLabel = null;
	private JLabel fansizHavaDegisimDebiLabel = null;
	private JLabel birimLabel3 = null;
	private JLabel birimLabel4 = null;
	private JLabel birimLabel5 = null;
	private JLabel birimLabel8 = null;
	private JLabel birimLabel10 = null;
	private JTextField feedbackVerimTextField = null;
	private JLabel birimLabel9 = null;
	private JLabel birimLabel6 = null;
	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setBounds(30, 522, 533, 39);
			jPanel5.add(getTamamButton(), null);
			jPanel5.add(getVazgecButton(), null);
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
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			birimLabel9 = new JLabel();
			birimLabel10 = new JLabel();
			birimLabel8 = new JLabel();
			jPanel6 = new JPanel();
			fanCalismaOraniLabel = new JLabel();
			birimLabel7 = new JLabel();
			feedbackVerimLabel = new JLabel();
			fansizHavaDegisimDebiLabel = new JLabel();
			jPanel6.setLayout(null);
			jPanel6.setBounds(30, 371, 533, 101);
			jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			fanCalismaOraniLabel.setText("Fanlarýn çalýþtýðý zaman oraný");
			fanCalismaOraniLabel.setLocation(20, 39);
			fanCalismaOraniLabel.setSize(364, 21);
			birimLabel7.setText("<HTML>m<SUP>3</SUP>/h</HTML>");
			birimLabel7.setLocation(499, 9);
			birimLabel7.setSize(31, 21);
			feedbackVerimLabel.setText("Havadan havaya ýsý geri kazaným sisteminin verimi");
			feedbackVerimLabel.setLocation(20, 69);
			feedbackVerimLabel.setSize(364, 21);
			fansizHavaDegisimDebiLabel.setText("Fanlarýn çalýþmadýðý durum için hacimsel hava deðiþim debisi");
			fansizHavaDegisimDebiLabel.setLocation(20, 9);
			fansizHavaDegisimDebiLabel.setSize(364, 21);
			birimLabel8.setText("<HTML>V<SUB>0</SUB></HTML>");
			birimLabel8.setLocation(396, 9);
			birimLabel8.setSize(23, 21);
			birimLabel10.setText("\u03B2");
			birimLabel10.setLocation(396, 39);
			birimLabel10.setSize(23, 21);
			birimLabel9.setBounds(396, 69, 23, 21);
			birimLabel9.setText("<HTML>\u03B7<SUB>V</SUB></HTML>");
			jPanel6.add(getFansizHavaDegisimDebiTextField(), null);
			jPanel6.add(fanCalismaOraniLabel, null);
			jPanel6.add(birimLabel7, null);
			jPanel6.add(getFanCalismaOraniTextField(), null);
			jPanel6.add(feedbackVerimLabel, null);
			jPanel6.add(fansizHavaDegisimDebiLabel, null);
			jPanel6.add(birimLabel8, null);
			jPanel6.add(birimLabel10, null);
			jPanel6.add(getFeedbackVerimTextField(), null);
			jPanel6.add(birimLabel9, null);
		}
		return jPanel6;
	}
	/**
	 * This method initializes fansizHavaDegisimDebiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getFansizHavaDegisimDebiTextField() {
		if (fansizHavaDegisimDebiTextField == null) {
			fansizHavaDegisimDebiTextField = new JTextField();
			fansizHavaDegisimDebiTextField.setLocation(423, 9);
			fansizHavaDegisimDebiTextField.setSize(67, 21);
			fansizHavaDegisimDebiTextField.setEnabled(false);
		}
		return fansizHavaDegisimDebiTextField;
	}
	/**
	 * This method initializes fanCalismaOraniTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getFanCalismaOraniTextField() {
		if (fanCalismaOraniTextField == null) {
			fanCalismaOraniTextField = new JTextField();
			fanCalismaOraniTextField.setLocation(423, 39);
			fanCalismaOraniTextField.setSize(67, 21);
			fanCalismaOraniTextField.setEnabled(false);
		}
		return fanCalismaOraniTextField;
	}
	/**
	 * This method initializes feedbackVerimTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getFeedbackVerimTextField() {
		if (feedbackVerimTextField == null) {
			feedbackVerimTextField = new JTextField();
			feedbackVerimTextField.setBounds(423, 69, 67, 21);
			feedbackVerimTextField.setEnabled(false);
		}
		return feedbackVerimTextField;
	}
	
	//********************************************************************************************************
	// MVP Methods *******************************************************************************************
	//********************************************************************************************************

	public void setHavaGirisDebiTextFieldText(String text){
		getHavaGirisDebiTextField().setText(text);
	}
	
	public String getHavaGirisDebiTextFieldText(){
		return getHavaGirisDebiTextField().getText();
	}
	
	public void setHavaCikisDebiTextFieldText(String text){
		getHavaCikisDebiTextField().setText(text);
	}
	
	public String getHavaCikisDebiTextFieldText(){
		return getHavaCikisDebiTextField().getText();
	}

	public void setHavaDegisimDebiTextFieldText(String text){
		getHavaDegisimDebiTextField().setText(text);
	}
	
	public String getHavaDegisimDebiTextFieldText(){
		return getHavaDegisimDebiTextField().getText();
	}

	public void setEsit1RadioButtonSelected(boolean state){
		getEsit1RadioButton().setSelected(state);
	}
	
	public boolean isEsit1RadioButtonSelected(){
		return getEsit1RadioButton().isSelected();
	}

	public void setBuyuk1KorumaliRadioButtonSelected(boolean state){
		getBuyuk1RadioButton().setSelected(state);
	}
	
	public boolean isBuyuk1KorumaliRadioButtonSelected(){
		return getBuyuk1RadioButton().isSelected();
	}

	public void setKorumasizRadioButtonSelected(boolean state){
		getKorumasizRadioButton().setSelected(state);
	}
	
	public boolean isKorumasizRadioButtonSelected(){
		return getKorumasizRadioButton().isSelected();
	}

	public void setTamKorumaliRadioButtonSelected(boolean state){
		getTamKorumaliRadioButton().setSelected(state);
	}
	
	public boolean isTamKorumaliRadioButtonSelected(){
		return getTamKorumaliRadioButton().isSelected();
	}

	public void setYariKorumaliRadioButtonSelected(boolean state){
		getYariKorumaliRadioButton().setSelected(state);
	}
	
	public boolean isYariKorumaliRadioButtonSelected(){
		return getYariKorumaliRadioButton().isSelected();
	}

	public void setSurekliRadioButtonSelected(boolean state){
		getSurekliRadioButton().setSelected(state);
	}
	
	public boolean isSurekliRadioButtonSelected(){
		return getSurekliRadioButton().isSelected();
	}

	public void setAralikliRadioButtonSelected(boolean state){
		getAralikliRadioButton().setSelected(state);
	}
	
	public boolean isAralikliRadioButtonSelected(){
		return getAralikliRadioButton().isSelected();
	}

	public void setFeedbackCheckBoxSelected(boolean state){
		getFeedbackCheckBox().setSelected(state);
	}
	
	public boolean isFeedbackRadioButtonSelected(){
		return getFeedbackCheckBox().isSelected();
	}

	public void setHavaDegisimSayisiTextFieldText(String text){
		getHavaDegisimSayisiTextField().setText(text);
	}
	
	public String getHavaDegisimSayisiTextFieldText(){
		return getHavaDegisimSayisiTextField().getText();
	}

	public void setFansizHavaDegisimDebiTextFieldText(String text){
		getFansizHavaDegisimDebiTextField().setText(text);
	}
	
	public String getFansizHavaDegisimDebiTextFieldText(){
		return getFansizHavaDegisimDebiTextField().getText();
	}

	public void setFanCalismaOraniTextFieldText(String text){
		getFanCalismaOraniTextField().setText(text);
	}
	
	public String getFanCalismaOraniTextFieldText(){
		return getFanCalismaOraniTextField().getText();
	}

	public void setFeedbackVerimTextFieldText(String text){
		getFeedbackVerimTextField().setText(text);
	}
	
	public String getFeedbackVerimTextFieldText(){
		return getFeedbackVerimTextField().getText();
	}
	
	public void addTamamButtonActionListener(ActionListener listener){
		getTamamButton().addActionListener(listener);		
	}	
	
	public void setEsit1RadioButtonActionCommand(String command){
		getEsit1RadioButton().setActionCommand(command);
	}
	
	public void setBuyuk1RadioButtonActionCommand(String command){
		getBuyuk1RadioButton().setActionCommand(command);
	}

	public void addBuyuk1RadioButtonListener(ActionListener mekanikHavalandirmaRadioButtonListener) {
		getBuyuk1RadioButton().addActionListener(mekanikHavalandirmaRadioButtonListener);
	}

	public void addEsit1RadioButtonListener(ActionListener mekanikHavalandirmaRadioButtonListener) {
		getEsit1RadioButton().addActionListener(mekanikHavalandirmaRadioButtonListener);
	}

	public void setKorumasizRadioButtonActionCommand(String string) {
		getKorumasizRadioButton().setActionCommand(string);
	}

	public void setTamKorumaliRadioButtonActionCommand(String string) {
		getTamKorumaliRadioButton().setActionCommand(string);
	}

	public void setYariKorumaliRadioButtonAction(String string) {
		getYariKorumaliRadioButton().setActionCommand(string);
	}

	public void addKorumasizRadioButtonActionListener(ActionListener mekanikHavalandirmaRadioButtonListener) {
		getKorumasizRadioButton().addActionListener(mekanikHavalandirmaRadioButtonListener);
	}

	public void addTamKorumaliRadioButtonActionListener(ActionListener mekanikHavalandirmaRadioButtonListener) {
		getTamKorumaliRadioButton().addActionListener(mekanikHavalandirmaRadioButtonListener);
	}

	public void addYariKorumaliRadioButtonActionListener(ActionListener mekanikHavalandirmaRadioButtonListener) {
		getYariKorumaliRadioButton().addActionListener(mekanikHavalandirmaRadioButtonListener);
	}

	public void setSurekliRadioButtonActionCommand(String string) {
		getSurekliRadioButton().setActionCommand(string);
	}

	public void addSurekliRadioButtonActionListener(ActionListener mekanikHavalandirmaRadioButtonListener) {
		getSurekliRadioButton().addActionListener(mekanikHavalandirmaRadioButtonListener);
	}

	public void addAralikliRadioButtonActionListener(ActionListener mekanikHavalandirmaRadioButtonListener) {
		getAralikliRadioButton().addActionListener(mekanikHavalandirmaRadioButtonListener);
	}

	public void setAralikliRadioButtonActionCommand(String string) {
		getAralikliRadioButton().setActionCommand(string);
	}

 }