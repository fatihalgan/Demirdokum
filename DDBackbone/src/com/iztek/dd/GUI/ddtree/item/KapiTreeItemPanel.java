/*
 * Created on 08.Oca.2005
 *
 */
package com.iztek.dd.GUI.ddtree.item;


import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.iztek.dd.IsiKaybi.domain.KapiYapiElemani;
import com.iztek.dd.utilities.TreeItemSelectionEvent;
/**
 * @author Selim HENDRICKSON
 *
 */
public class KapiTreeItemPanel extends TreeItemPanel {
    private KapiYapiElemani activeKapi = null; 
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 7556985841086216022L;
	
	private JLabel isaretLabel = null;
	private JTextField isaretTextField = null;
	private JLabel uzunlukLabel = null;
	private JTextField uzunlukTextField = null;
	private JLabel yukseklikGenislikLabel = null;
	private JTextField yukseklikGenislikTextField = null;
	private JLabel kDegeriLabel = null;
	private JTextField kDegeriTextField = null;
	private JLabel lUzunluguLabel = null;
	private JTextField lUzunluguTextField = null;
	private JPanel jPanel = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	/**
	 * This method initializes 
	 * 
	 */
	public KapiTreeItemPanel() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        jLabel3 = new JLabel();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        jLabel = new JLabel();
        lUzunluguLabel = new JLabel();
        kDegeriLabel = new JLabel();
        yukseklikGenislikLabel = new JLabel();
        uzunlukLabel = new JLabel();
        isaretLabel = new JLabel();
        this.setLayout(null);
        this.setSize(352, 399);
        isaretLabel.setText("Ýþaret");
        isaretLabel.setLocation(58, 118);
        isaretLabel.setSize(111, 24);
        uzunlukLabel.setText("Uzunluk");
        uzunlukLabel.setLocation(58, 156);
        uzunlukLabel.setSize(111, 24);
        yukseklikGenislikLabel.setText("Yükseklik/Geniþlik");
        yukseklikGenislikLabel.setLocation(58, 194);
        yukseklikGenislikLabel.setSize(111, 24);
        kDegeriLabel.setText("U deðeri");
        kDegeriLabel.setLocation(58, 232);
        kDegeriLabel.setSize(111, 24);
        lUzunluguLabel.setText("L uzunluðu");
        lUzunluguLabel.setLocation(58, 270);
        lUzunluguLabel.setSize(111, 24);
        jLabel.setBounds(293, 156, 25, 24);
        jLabel.setText("m");
        jLabel1.setBounds(293, 194, 25, 24);
        jLabel1.setText("m");
        jLabel2.setBounds(293, 232, 54, 24);
        jLabel2.setText("<HTML>W/m<SUP>2</SUP> K</HTML>");
        jLabel3.setBounds(293, 270, 25, 24);
        jLabel3.setText("m");
        this.add(isaretLabel, null);
        this.add(getIsaretTextField(), null);
        this.add(uzunlukLabel, null);
        this.add(getUzunlukTextField(), null);
        this.add(yukseklikGenislikLabel, null);
        this.add(getYukseklikGenislikTextField(), null);
        this.add(kDegeriLabel, null);
        this.add(getKDegeriTextField(), null);
        this.add(lUzunluguLabel, null);
        this.add(getLUzunluguTextField(), null);
        this.add(getJPanel(), null);
        this.add(jLabel, null);
        this.add(jLabel1, null);
        this.add(jLabel2, null);
        this.add(jLabel3, null);
			
	}
	/**
	 * This method initializes isaretTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIsaretTextField() {
		if (isaretTextField == null) {
			isaretTextField = new JTextField();
			isaretTextField.setLocation(179, 118);
			isaretTextField.setSize(106, 24);
			isaretTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					activeKapi.setYapiElemaniKodu(isaretTextField.getText());
				}
			});
		}
		return isaretTextField;
	}
	/**
	 * This method initializes uzunlukTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getUzunlukTextField() {
		if (uzunlukTextField == null) {
			uzunlukTextField = new JTextField();
			uzunlukTextField.setLocation(179, 156);
			uzunlukTextField.setSize(106, 24);
			uzunlukTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					uzunlukTextField.setText("");
				}
			});
			uzunlukTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getUzunlukTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();					
					try {
						activeKapi.setUzunluk(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) getUzunlukTextField().setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return uzunlukTextField;
	}
	/**
	 * This method initializes yukseklikGenislikTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getYukseklikGenislikTextField() {
		if (yukseklikGenislikTextField == null) {
			yukseklikGenislikTextField = new JTextField();
			yukseklikGenislikTextField.setLocation(179, 194);
			yukseklikGenislikTextField.setSize(106, 24);
			yukseklikGenislikTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					yukseklikGenislikTextField.setText("");
				}
			});
			yukseklikGenislikTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getYukseklikGenislikTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					
					try {
						activeKapi.setYukseklik(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) getYukseklikGenislikTextField().setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return yukseklikGenislikTextField;
	}
	/**
	 * This method initializes kDegeriTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getKDegeriTextField() {
		if (kDegeriTextField == null) {
			kDegeriTextField = new JTextField();
			kDegeriTextField.setLocation(179, 232);
			kDegeriTextField.setSize(106, 24);
			kDegeriTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					kDegeriTextField.setText("");
				}
			});
			kDegeriTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getKDegeriTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					
					try {
						activeKapi.setIsiGecirgenlikKatsayisi(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) getKDegeriTextField().setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return kDegeriTextField;
	}
	/**
	 * This method initializes lUzunluguTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getLUzunluguTextField() {
		if (lUzunluguTextField == null) {
			lUzunluguTextField = new JTextField();
			lUzunluguTextField.setLocation(179, 270);
			lUzunluguTextField.setSize(106, 24);
			lUzunluguTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					lUzunluguTextField.setText("");
				}
			});
			lUzunluguTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getLUzunluguTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					
					try {
						activeKapi.setAcilanKisminUzunlugu(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) getLUzunluguTextField().setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return lUzunluguTextField;
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLocation(27, 14);
			jPanel.setSize(303, 63);
			ButtonGroup group = new ButtonGroup();
			group.add(getJRadioButton());
			group.add(getJRadioButton1());
			group.add(getJRadioButton2());
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kapý Türü", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel.add(getJRadioButton(), null);
			jPanel.add(getJRadioButton1(), null);
			jPanel.add(getJRadioButton2(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setText("Ýç kapý");
			jRadioButton.setSelected(false);
		}
		return jRadioButton;
	}
	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("Dýþ kapý");
			jRadioButton1.setSelected(true);
		}
		return jRadioButton1;
	}
	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setText("Balkon kapýsý");
		}
		return jRadioButton2;
	}

	public String getIsaretTextFieldText() {
        return getIsaretTextField().getText();
    }

	public double getUzunlukTextFieldText() {
        return Double.parseDouble(getUzunlukTextField().getText());
    }

	public double getYukseklikGenislikTextFieldText() {
        return Double.parseDouble(getYukseklikGenislikTextField().getText());
    }

	public double getKDegeriTextFieldText() {
        return Double.parseDouble(getKDegeriTextField().getText());
    }

	public double getLUzunluguTextFieldText() {
        return Double.parseDouble(getLUzunluguTextField().getText());
    }

	public void addKapiTreeItemPanelIsaretTextFieldKeylistener(KeyListener kapiTreeItemPanelIsaretTextFieldKeylistener) {
	    getIsaretTextField().addKeyListener(kapiTreeItemPanelIsaretTextFieldKeylistener);
    }

	public void addKapiTreeItemPanelUzunlukTextFieldKeylistener(KeyListener kapiTreeItemPanelUzunlukTextFieldKeylistener) {
	    getUzunlukTextField().addKeyListener(kapiTreeItemPanelUzunlukTextFieldKeylistener);
	}

    public void addKapiTreeItemPanelYukseklikGenislikTextFieldKeylistener(KeyListener kapiTreeItemPanelYukseklikGenislikTextFieldKeylistener) {
        getYukseklikGenislikTextField().addKeyListener(kapiTreeItemPanelYukseklikGenislikTextFieldKeylistener);
    }

    public void addKapiTreeItemPanelKDegeriTextFieldKeylistener(KeyListener kapiTreeItemPanelKDegeriTextFieldKeylistener) {
        getKDegeriTextField().addKeyListener(kapiTreeItemPanelKDegeriTextFieldKeylistener);
    }

    public void addKapiTreeItemPanelLUzunluguTextFieldKeylistener(KeyListener kapiTreeItemPanelLUzunluguTextFieldKeylistener) {
        getLUzunluguTextField().addKeyListener(kapiTreeItemPanelLUzunluguTextFieldKeylistener);
    }

    public void setKDegeriTextFieldText(double isiGecirgenlikKatsayisi) {
        getKDegeriTextField().setText(twoDigits.format(isiGecirgenlikKatsayisi));
    }

    public void setIsaretTextFieldText(String yapiElemaniKodu) {
        getIsaretTextField().setText(yapiElemaniKodu);
    }
	
    public void updateSelf(TreeItemSelectionEvent e) {
        TreeItemInt item = e.getSelectedItem();
        if(item instanceof KapiYapiElemani){
            activeKapi = (KapiYapiElemani) item;
            isaretTextField.setText(activeKapi.getYapiElemaniKodu());
            uzunlukTextField.setText(""+activeKapi.getUzunluk());
            yukseklikGenislikTextField.setText(""+activeKapi.getYukseklik());
            kDegeriTextField.setText(""+activeKapi.getIsiGecirgenlikKatsayisi());
            lUzunluguTextField.setText(""+activeKapi.getAcilanKisminUzunlugu());            
        }
	}
          
}  //  @jve:decl-index=0:visual-constraint="10,10"
