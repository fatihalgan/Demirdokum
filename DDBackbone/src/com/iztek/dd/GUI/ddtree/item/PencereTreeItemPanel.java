/*
 * Created on 08.Oca.2005
 *
 */
package com.iztek.dd.GUI.ddtree.item;


import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.iztek.dd.IsiKaybi.domain.PencereYapiElemani;
import com.iztek.dd.utilities.TreeItemSelectionEvent;
/**
 * @author Selim HENDRICKSON
 *
 */
public class PencereTreeItemPanel extends TreeItemPanel {
    private PencereYapiElemani activePencere = null;
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1770280209467756716L;
	
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
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	/**
	 * This method initializes 
	 * 
	 */
	public PencereTreeItemPanel() {
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
        isaretLabel.setLocation(57, 42);
        isaretLabel.setSize(111, 24);
        uzunlukLabel.setText("Uzunluk");
        uzunlukLabel.setLocation(57, 80);
        uzunlukLabel.setSize(111, 24);
        yukseklikGenislikLabel.setText("Yükseklik/Geniþlik");
        yukseklikGenislikLabel.setLocation(57, 118);
        yukseklikGenislikLabel.setSize(111, 24);
        kDegeriLabel.setText("U deðeri");
        kDegeriLabel.setLocation(57, 156);
        kDegeriLabel.setSize(111, 24);
        lUzunluguLabel.setText("L uzunluðu");
        lUzunluguLabel.setLocation(57, 194);
        lUzunluguLabel.setSize(111, 24);
        jLabel.setBounds(291, 80, 23, 24);
        jLabel.setText("m");
        jLabel1.setBounds(291, 118, 23, 24);
        jLabel1.setText("m");
        jLabel2.setBounds(291, 156, 48, 24);
        jLabel2.setText("<HTML>W/m<SUP>2</SUP> K</HTML>");
        jLabel3.setBounds(291, 194, 23, 24);
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
			isaretTextField.setLocation(178, 42);
			isaretTextField.setSize(106, 24);
			isaretTextField.setEditable(false);
			isaretTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
				    activePencere.setYapiElemaniKodu(isaretTextField.getText());
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
			uzunlukTextField.setLocation(178, 80);
			uzunlukTextField.setSize(106, 24);
			uzunlukTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					getUzunlukTextField().setText("");
				}
			});
			uzunlukTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getUzunlukTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					try {
						activePencere.setUzunluk(Double.parseDouble(text));
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
			yukseklikGenislikTextField.setLocation(178, 118);
			yukseklikGenislikTextField.setSize(106, 24);
			yukseklikGenislikTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					getYukseklikGenislikTextField().setText("");
				}
			});
			yukseklikGenislikTextField.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getYukseklikGenislikTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					try {
					    if(text=="") activePencere.setYukseklik(0);
					    else activePencere.setYukseklik(Double.parseDouble(text));
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
			kDegeriTextField.setLocation(178, 156);
			kDegeriTextField.setSize(106, 24);
			kDegeriTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					getKDegeriTextField().setText("");
				}
			});
			kDegeriTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getKDegeriTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					try {
						activePencere.setIsiGecirgenlikKatsayisi(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) getKDegeriTextField().setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
			kDegeriTextField.setEditable(false);
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
			lUzunluguTextField.setLocation(178, 194);
			lUzunluguTextField.setSize(106, 24);
			lUzunluguTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusGained(java.awt.event.FocusEvent e) {    
					getLUzunluguTextField().setText("");
				}
			});
			lUzunluguTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = getLUzunluguTextField().getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					try {
						activePencere.setAcilanKisminUzunlugu(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) getLUzunluguTextField().setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return lUzunluguTextField;
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

	public void addPencereTreeItemPanelIsaretTextFieldKeylistener(KeyListener pencereTreeItemPanelIsaretTextFieldKeylistener) {
	    getIsaretTextField().addKeyListener(pencereTreeItemPanelIsaretTextFieldKeylistener);
    }

	public void addPencereTreeItemPanelUzunlukTextFieldKeylistener(KeyListener pencereTreeItemPanelUzunlukTextFieldKeylistener) {
	    getUzunlukTextField().addKeyListener(pencereTreeItemPanelUzunlukTextFieldKeylistener);
	}

    public void addPencereTreeItemPanelYukseklikGenislikTextFieldKeylistener(KeyListener pencereTreeItemPanelYukseklikGenislikTextFieldKeylistener) {
        getYukseklikGenislikTextField().addKeyListener(pencereTreeItemPanelYukseklikGenislikTextFieldKeylistener);
    }

    public void addPencereTreeItemPanelKDegeriTextFieldKeylistener(KeyListener pencereTreeItemPanelKDegeriTextFieldKeylistener) {
        getKDegeriTextField().addKeyListener(pencereTreeItemPanelKDegeriTextFieldKeylistener);
    }

    public void addPencereTreeItemPanelLUzunluguTextFieldKeylistener(KeyListener pencereTreeItemPanelLUzunluguTextFieldKeylistener) {
        getLUzunluguTextField().addKeyListener(pencereTreeItemPanelLUzunluguTextFieldKeylistener);
    }

    public void setKDegeriTextFieldText(double isiGecirgenlikKatsayisi) {
        getKDegeriTextField().setText(twoDigits.format(isiGecirgenlikKatsayisi));
    }

    public void setIsaretTextFieldText(String yapiElemaniKodu) {
        getIsaretTextField().setText(yapiElemaniKodu);
        
    }
	public void updateSelf(TreeItemSelectionEvent e) {
        TreeItemInt item = e.getSelectedItem();
        if(item instanceof PencereYapiElemani){
            activePencere = (PencereYapiElemani) item;
            isaretTextField.setText(activePencere.getYapiElemaniKodu());
            uzunlukTextField.setText(""+activePencere.getUzunluk());
            yukseklikGenislikTextField.setText(""+activePencere.getYukseklik());
            kDegeriTextField.setText(""+activePencere.getIsiGecirgenlikKatsayisi());
            lUzunluguTextField.setText(""+activePencere.getAcilanKisminUzunlugu());            
        }
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
