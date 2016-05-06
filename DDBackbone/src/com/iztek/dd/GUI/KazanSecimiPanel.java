/*
 * Created on 10.Þub.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.iztek.dd.IsiKaybi.domain.Isitici;
import com.iztek.dd.IsiKaybi.domain.KritikHat;
/**
 * @author Selim HENDRICKSON
 *
 */
public class KazanSecimiPanel extends JPanel {
	DecimalFormat twoDigits = new DecimalFormat("0.00");
	Isitici kazan = new Isitici();
	KritikHat hat = new KritikHat();
	
	private double kazanKapasitesi = 0;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JLabel kazanKapasitesiLabel = null;
	private JTextField kazanKapasitesiTextField = null;
	private JLabel jLabel1 = null;
	private JComboBox dolasimIsiKaybiComboBox = null;
	private JLabel dolasimIsiKaybiLabel = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JTextField pompaDebisiTextField = null;
	private JTextField pompaBasinciTextField = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JTextField emniyetDegeriTextField = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JLabel jLabel11 = null;
	private JTextField statikYukseklikTextField = null;
	private JTextField suHacmiTextField = null;
	private JTextField genlesmeDeposuHacmiTextField = null;
	private JTextField genlesmeDeposuTipiTextField = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JLabel jLabel14 = null;
	private JButton genlesmeDeposuDegistirButton = null;
	private JLabel secilenKazanLabel = null;
	private JTextField secilenKazanModeliTextField = null;
	private JButton kazanSecButton = null;
	/**
	 * This is the default constructor
	 */
	public KazanSecimiPanel() {
		super();
		initialize();	
        DecimalFormatSymbols symbols = twoDigits.getDecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        twoDigits.setDecimalFormatSymbols(symbols);
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		this.setLayout(null);
		this.setSize(567, 408);
		this.add(getJPanel(), null);
		this.add(getJPanel1(), null);
		this.add(getJPanel2(), null);
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			kazanKapasitesiLabel = new JLabel();
			jLabel1 = new JLabel();
			dolasimIsiKaybiLabel = new JLabel();
			secilenKazanLabel = new JLabel();
			jPanel.setLayout(null);
			jPanel.setBounds(14, 20, 535, 103);
			kazanKapasitesiLabel.setText("<HTML>Isýtýcý kapasitesi(Q<SUB>K</SUB>)");
			kazanKapasitesiLabel.setBounds(31, 7, 131, 24);
			jLabel1.setBounds(394, 7, 27, 24);
			jLabel1.setText("kW");
			dolasimIsiKaybiLabel.setBounds(31, 38, 131, 24);
			dolasimIsiKaybiLabel.setText("Dolaþým ýsý kaybý (ZR)");
			secilenKazanLabel.setBounds(31, 69, 131, 24);
			secilenKazanLabel.setText("Seçilen kazan");
			jPanel.add(kazanKapasitesiLabel, null);
			jPanel.add(getKazanKapasitesiTextField(), null);
			jPanel.add(jLabel1, null);
			jPanel.add(getDolasimIsiKaybiComboBox(), null);
			jPanel.add(dolasimIsiKaybiLabel, null);
			jPanel.add(secilenKazanLabel, null);
			jPanel.add(getSecilenKazanModeliTextField(), null);
			jPanel.add(getKazanSecButton(), null);
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
			jLabel3 = new JLabel();
			jLabel4 = new JLabel();
			jLabel5 = new JLabel();
			jLabel6 = new JLabel();
			jLabel7 = new JLabel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(14, 136, 535, 97);
			jLabel3.setText("Dolaþým pompasý debisi (Vp)");
			jLabel3.setLocation(31, 18);
			jLabel3.setSize(164, 24);
			jLabel4.setText("Pompa basýncý (Hp)");
			jLabel4.setLocation(31, 51);
			jLabel4.setSize(164, 24);
			jLabel5.setText("m3/h");
			jLabel5.setLocation(357, 18);
			jLabel5.setSize(35, 24);
			jLabel6.setText("Pa");
			jLabel6.setPreferredSize(new java.awt.Dimension(27,24));
			jLabel6.setLocation(357, 51);
			jLabel6.setSize(35, 24);
			jLabel7.setBounds(412, 18, 92, 24);
			jLabel7.setText("Emniyet deðeri");
			jPanel1.add(jLabel3, null);
			jPanel1.add(jLabel4, null);
			jPanel1.add(getPompaDebisiTextField(), null);
			jPanel1.add(getPompaBasinciTextField(), null);
			jPanel1.add(jLabel5, null);
			jPanel1.add(jLabel6, null);
			jPanel1.add(jLabel7, null);
			jPanel1.add(getEmniyetDegeriTextField(), null);
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
			jLabel8 = new JLabel();
			jLabel9 = new JLabel();
			jLabel10 = new JLabel();
			jLabel11 = new JLabel();
			jLabel12 = new JLabel();
			jLabel13 = new JLabel();
			jLabel14 = new JLabel();
			jPanel2.setLayout(null);
			jPanel2.setBounds(13, 249, 538, 135);
			jLabel8.setText("Binanýn statik yüksekliði (Hst)");
			jLabel8.setLocation(34, 7);
			jLabel8.setSize(223, 24);
			jLabel9.setBounds(34, 38, 223, 24);
			jLabel9.setText("Sistemde dolaþan su hacmi (V)");
			jLabel10.setBounds(34, 69, 223, 24);
			jLabel10.setText("Kapalý genleþme deposu hacmi (Vgdk)");
			jLabel11.setBounds(34, 100, 223, 24);
			jLabel11.setText("Seçilen kapalý genleþme deposu");
			jLabel12.setText("m");
			jLabel12.setLocation(423, 7);
			jLabel12.setSize(35, 24);
			jLabel13.setText("lt");
			jLabel13.setLocation(423, 38);
			jLabel13.setSize(35, 24);
			jLabel14.setText("lt");
			jLabel14.setLocation(423, 69);
			jLabel14.setSize(35, 24);
			jPanel2.add(jLabel8, null);
			jPanel2.add(jLabel9, null);
			jPanel2.add(jLabel10, null);
			jPanel2.add(jLabel11, null);
			jPanel2.add(getStatikYukseklikTextField(), null);
			jPanel2.add(getSuHacmiTextField(), null);
			jPanel2.add(getGenlesmeDeposuHacmiTextField(), null);
			jPanel2.add(getGenlesmeDeposuTipiTextField(), null);
			jPanel2.add(jLabel12, null);
			jPanel2.add(jLabel13, null);
			jPanel2.add(jLabel14, null);
			jPanel2.add(getGenlesmeDeposuDegistirButton(), null);
		}
		return jPanel2;
	}
	/**
	 * This method initializes kazanKapasitesiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getKazanKapasitesiTextField() {
		if (kazanKapasitesiTextField == null) {
			kazanKapasitesiTextField = new JTextField();
			kazanKapasitesiTextField.setBounds(189, 7, 191, 24);
			kazanKapasitesiTextField.setEditable(false);
		}
		return kazanKapasitesiTextField;
	}
	/**
	 * This method initializes dolasimIsiK			dolasimIsiKaybiComboBox.setLocation(189, 34);
aybiComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getDolasimIsiKaybiComboBox() {
		if (dolasimIsiKaybiComboBox == null) {
			String[] values = {"0.05","0.10","0.15"};
			dolasimIsiKaybiComboBox = new JComboBox(values);
			dolasimIsiKaybiComboBox.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					kazan.setDolasimIsiKaybi(Double.parseDouble((String)dolasimIsiKaybiComboBox.getSelectedItem()));
					updateSelf(kazan,hat);
				}
			});
		}
		dolasimIsiKaybiComboBox.setSelectedIndex(0);
		dolasimIsiKaybiComboBox.setBounds(189,38,191,24);
		return dolasimIsiKaybiComboBox;
	}
	/**
	 * This method initializes pompaDebisiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getPompaDebisiTextField() {
		if (pompaDebisiTextField == null) {
			pompaDebisiTextField = new JTextField();
			pompaDebisiTextField.setLocation(212, 18);
			pompaDebisiTextField.setSize(133, 24);
			pompaDebisiTextField.setEditable(false);
		}
		return pompaDebisiTextField;
	}
	/**
	 * This method initializes pompaBasinciTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getPompaBasinciTextField() {
		if (pompaBasinciTextField == null) {
			pompaBasinciTextField = new JTextField();
			pompaBasinciTextField.setLocation(212, 51);
			pompaBasinciTextField.setSize(133, 24);
			pompaBasinciTextField.setEditable(false);
		}
		return pompaBasinciTextField;
	}
	/**
	 * This method initializes emniyetDegeriTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getEmniyetDegeriTextField() {
		if (emniyetDegeriTextField == null) {
			emniyetDegeriTextField = new JTextField();
			emniyetDegeriTextField.setBounds(412, 51, 92, 24);
			emniyetDegeriTextField.setText("4000");
			emniyetDegeriTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					getEmniyetDegeriTextField().setText("");
					kazan.setPompaEmniyetDegeri(0);
				}
			});
			emniyetDegeriTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getEmniyetDegeriTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					try {						
						kazan.setPompaEmniyetDegeri(Double.parseDouble(text));
						updateSelf(kazan,hat);
					} catch (NumberFormatException e1) {
						if(text.length()>1) getEmniyetDegeriTextField().setText(text.substring(0,text.length()-1));
						e.consume();
					}															
				}
			});
		}
		return emniyetDegeriTextField;
	}
	/**
	 * This method initializes statikYukseklikTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getStatikYukseklikTextField() {
		if (statikYukseklikTextField == null) {
			statikYukseklikTextField = new JTextField();
			statikYukseklikTextField.setBounds(261, 7, 152, 24);
			statikYukseklikTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					getStatikYukseklikTextField().setText("");
					kazan.setStatikYukseklik(0);
				}
			});
			statikYukseklikTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getStatikYukseklikTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					try {						
						kazan.setStatikYukseklik(Double.parseDouble(text));
						updateSelf(kazan,hat);
					} catch (NumberFormatException e1) {
						if(text.length()>1) getStatikYukseklikTextField().setText(text.substring(0,text.length()-1));
						e.consume();
					}															
				}
			});
		}
		return statikYukseklikTextField;
	}
	/**
	 * This method initializes suHacmiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getSuHacmiTextField() {
		if (suHacmiTextField == null) {
			suHacmiTextField = new JTextField();
			suHacmiTextField.setBounds(261, 38, 152, 24);
			suHacmiTextField.setEditable(false);
		}
		return suHacmiTextField;
	}
	/**
	 * This method initializes genlesmeDeposuHacmiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getGenlesmeDeposuHacmiTextField() {
		if (genlesmeDeposuHacmiTextField == null) {
			genlesmeDeposuHacmiTextField = new JTextField();
			genlesmeDeposuHacmiTextField.setBounds(261, 69, 152, 24);
			genlesmeDeposuHacmiTextField.setEditable(false);
		}
		return genlesmeDeposuHacmiTextField;
	}
	/**
	 * This method initializes genlesmeDeposuTipiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getGenlesmeDeposuTipiTextField() {
		if (genlesmeDeposuTipiTextField == null) {
			genlesmeDeposuTipiTextField = new JTextField();
			genlesmeDeposuTipiTextField.setBounds(261, 100, 152, 24);
			genlesmeDeposuTipiTextField.setEditable(false);
		}
		return genlesmeDeposuTipiTextField;
	}
	/**
	 * This method initializes genlesmeDeposuDegistirButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getGenlesmeDeposuDegistirButton() {
		if (genlesmeDeposuDegistirButton == null) {
			genlesmeDeposuDegistirButton = new JButton();
			genlesmeDeposuDegistirButton.setBounds(422, 100, 81, 24);
			genlesmeDeposuDegistirButton.setText("Deðiþtir");
		}
		return genlesmeDeposuDegistirButton;
	}
	/**
	 * This method initializes secilenKazanModeliTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getSecilenKazanModeliTextField() {
		if (secilenKazanModeliTextField == null) {
			secilenKazanModeliTextField = new JTextField();
			secilenKazanModeliTextField.setBounds(189, 69, 191, 24);
			secilenKazanModeliTextField.setEditable(false);
		}
		return secilenKazanModeliTextField;
	}
	/**
	 * This method initializes kazanSecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getKazanSecButton() {
		if (kazanSecButton == null) {
			kazanSecButton = new JButton();
			kazanSecButton.setLocation(394, 69);
			kazanSecButton.setSize(81, 24);
			kazanSecButton.setText("Seç");
		}
		return kazanSecButton;
	}
	
	public void updateSelf(Isitici kazan,KritikHat hat) {
		this.kazan = kazan; 
		this.hat = hat;
		getKazanKapasitesiTextField().setText(twoDigits.format(kazan.hesaplaKazanKapasiteIhtiyaci()));
		getPompaDebisiTextField().setText(twoDigits.format(kazan.hesaplaPompaDebisi()));
//		getEmniyetDegeriTextField().setText(""+kazan.getPompaEmniyetDegeri());
		getPompaBasinciTextField().setText(twoDigits.format(hat.getSurtunmeKaybiToplami()+hat.getOzelDirencToplami()+kazan.getPompaEmniyetDegeri()));
		getSuHacmiTextField().setText(twoDigits.format(kazan.hesaplaSuHacmi()));
		getGenlesmeDeposuHacmiTextField().setText(twoDigits.format(kazan.hesaplaDepoHacmi()));
		if(kazan.getSecilenIsitici()!=null){
		    getSecilenKazanModeliTextField().setText(kazan.getSecilenIsitici().getModelAdi()+" "+kazan.getSecilenIsitici().getTip());   
		}		
	}
	public void setLabels(String string) {
		if(string.equals("Kazan")){
			kazanKapasitesiLabel.setText("<HTML>Kazan kapasitesi(Q<SUB>K</SUB>)</HTML>");
			secilenKazanLabel.setText("Seçilen kazan");
		}
		if(string.equals("Kombi")){
			kazanKapasitesiLabel.setText("<HTML>Kombi kapasitesi(Q<SUB>K</SUB>)</HTML>");
			secilenKazanLabel.setText("Seçilen kombi");
		}
	}
	public void addKazanSecButtonActionListener(ActionListener listener) {
		getKazanSecButton().addActionListener(listener);
	}
	public void addGenlesmeDeposuDegistirButtonActionListener(ActionListener listener) {
		getGenlesmeDeposuDegistirButton().addActionListener(listener);
	}
	public String getGenlesmeDeposuHacmiTextFieldText() {
		return getGenlesmeDeposuHacmiTextField().getText();
	}
	public void setSelectedDepoModeliTextFieldText(String depoModeli) {
		getGenlesmeDeposuTipiTextField().setText(depoModeli);
	}
    public void setKazanModeliTextFieldText(String model) {
        getSecilenKazanModeliTextField().setText(model);
    }
    public void setDolasimIsiKaybiSelectedItem(String string) {
        getDolasimIsiKaybiComboBox().setSelectedItem(string);
    }
		
  }  //  @jve:decl-index=0:visual-constraint="10,10"
