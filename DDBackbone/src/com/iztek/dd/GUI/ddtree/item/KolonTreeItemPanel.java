/*
 * Created on 08.Oca.2005
 *
 */
package com.iztek.dd.GUI.ddtree.item;


import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.iztek.dd.IsiKaybi.domain.KolonYapiElemani;
import com.iztek.dd.utilities.TreeItemSelectionEvent;
/**
 * @author Selim HENDRICKSON
 *
 */
public class KolonTreeItemPanel extends TreeItemPanel {
    private KolonYapiElemani activeKolon = null;
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1485899151390675990L;
	
	private JLabel isaretLabel = null;
	private JTextField isaretTextField = null;
	private JLabel uzunlukLabel = null;
	private JTextField uzunlukTextField = null;
	private JLabel yukseklikGenislikLabel = null;
	private JTextField yukseklikGenislikTextField = null;
	private JLabel kDegeriLabel = null;
	private JTextField kDegeriTextField = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	/**
	 * This method initializes 
	 * 
	 */
	public KolonTreeItemPanel() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        jLabel = new JLabel();
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
        jLabel.setBounds(290, 81, 25, 23);
        jLabel.setText("m");
        jLabel1.setBounds(290, 119, 25, 23);
        jLabel1.setText("m");
        jLabel2.setBounds(290, 157, 25, 23);
        jLabel2.setText("<HTML>W/m<SUP>2</SUP> K</HTML>");
        this.add(isaretLabel, null);
        this.add(getIsaretTextField(), null);
        this.add(uzunlukLabel, null);
        this.add(getUzunlukTextField(), null);
        this.add(yukseklikGenislikLabel, null);
        this.add(getYukseklikGenislikTextField(), null);
        this.add(kDegeriLabel, null);
        this.add(getKDegeriTextField(), null);
        this.add(jLabel, null);
        this.add(jLabel1, null);
        this.add(jLabel2, null);
			
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
			isaretTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					activeKolon.setYapiElemaniKodu(isaretTextField.getText()+e.getKeyChar());
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
					uzunlukTextField.setText("");
				}
			});
			uzunlukTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = uzunlukTextField.getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					try {
						activeKolon.setUzunluk(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) uzunlukTextField.setText(text.substring(0,text.length()-1));
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
					yukseklikGenislikTextField.setText("");
				}
			});
			yukseklikGenislikTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = yukseklikGenislikTextField.getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					try {
						activeKolon.setYukseklik(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) yukseklikGenislikTextField.setText(text.substring(0,text.length()-1));
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
					kDegeriTextField.setText("");
				}
			});
			kDegeriTextField.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyTyped(java.awt.event.KeyEvent e) {    
					String text = kDegeriTextField.getText();
					if(e.getKeyChar()!='f')text += e.getKeyChar();
					try {
						activeKolon.setIsiGecirgenlikKatsayisi(Double.parseDouble(text));
					} catch (NumberFormatException e1) {
						if(text.length()>1) kDegeriTextField.setText(text.substring(0,text.length()-1));
						e.consume();
					}
				}
			});
		}
		return kDegeriTextField;
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

	public void addKolonTreeItemPanelIsaretTextFieldKeylistener(KeyListener kolonTreeItemPanelIsaretTextFieldKeylistener) {
	    getIsaretTextField().addKeyListener(kolonTreeItemPanelIsaretTextFieldKeylistener);
    }

	public void addKolonTreeItemPanelUzunlukTextFieldKeylistener(KeyListener kolonTreeItemPanelUzunlukTextFieldKeylistener) {
	    getUzunlukTextField().addKeyListener(kolonTreeItemPanelUzunlukTextFieldKeylistener);
	}

    public void addKolonTreeItemPanelYukseklikGenislikTextFieldKeylistener(KeyListener kolonTreeItemPanelYukseklikGenislikTextFieldKeylistener) {
        getYukseklikGenislikTextField().addKeyListener(kolonTreeItemPanelYukseklikGenislikTextFieldKeylistener);
    }

    public void addKolonTreeItemPanelKDegeriTextFieldKeylistener(KeyListener kolonTreeItemPanelKDegeriTextFieldKeylistener) {
        getKDegeriTextField().addKeyListener(kolonTreeItemPanelKDegeriTextFieldKeylistener);
    }

    public void updateSelf(TreeItemSelectionEvent e) {
        TreeItemInt item = e.getSelectedItem();
        if (item instanceof KolonYapiElemani) {
            activeKolon = (KolonYapiElemani) item;
            isaretTextField.setText(activeKolon.getYapiElemaniKodu());
            uzunlukTextField.setText(""+activeKolon.getUzunluk());
            yukseklikGenislikTextField.setText(""+activeKolon.getYukseklik());
            kDegeriTextField.setText(""+activeKolon.getIsiGecirgenlikKatsayisi());
//            adetTextField.setText(activeKolon.geta)
        }
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
