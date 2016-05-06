package com.iztek.dd.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.iztek.dd.GUI.ddtree.item.TreeItemPanel;
import com.iztek.dd.GUI.wrappers.IcSicaklikSecimTableModel;
import com.iztek.dd.IsiKaybi.domain.IcSicaklik;
import com.iztek.dd.IsiKaybi.domain.IcSicakliklar;
/**
 * @author Selim HENDRICKSON
 *
 */
public class IcSicaklikSecimiDialog extends JDialog {
	private TreeItemPanel originatingPanel = null;
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 4611914139496412798L;

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton secButton = null;
	private JButton vazgecButton = null;
	private JScrollPane jScrollPane = null;
	private JTable icSicakliklarTable = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private JRadioButton hepsiRadioButton = null;
	private JRadioButton konutlarRadioButton = null;
	private JRadioButton isVeIdareBinalariRadioButton = null;
	private JRadioButton okullarRadioButton = null;
	private JRadioButton hastaneYapilariRadioButton = null;
	private JRadioButton fabrikaYapilariRadioButton = null;
	private JRadioButton cezaVeTutukeviRadioButton = null;
	private JRadioButton digerRadioButton = null;
	/**
	 * This is the default constructor
	 */
	public IcSicaklikSecimiDialog(JPanel originatingPanel) {
		super();
		initialize();
		this.originatingPanel= (TreeItemPanel) originatingPanel;
		addIcSicaklikTipListener();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setPreferredSize(new java.awt.Dimension(491,237));
		this.setMinimumSize(new java.awt.Dimension(491,237));
		this.setSize(600, 293);
		this.setContentPane(getJContentPane());
		this.setTitle("Mahal iç sýcaklýklarý");
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new BoxLayout(jContentPane, BoxLayout.Y_AXIS));
			jContentPane.add(getJPanel2(), null);
			jContentPane.add(getJPanel1(), null);
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
			jPanel.setLayout(new BorderLayout());
			jPanel.setPreferredSize(new java.awt.Dimension(200,200));
			jPanel.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
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
			jPanel1.setLayout(null);
			jPanel1.setPreferredSize(new java.awt.Dimension(30,40));
			jPanel1.add(getSecButton(), null);
			jPanel1.add(getVazgecButton(), null);
		}
		return jPanel1;
	}
	/**
	 * This method initializes secButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getSecButton() {
		if (secButton == null) {
			secButton = new JButton();
			secButton.setBounds(5, 5, 72, 30);
			secButton.setText("Seç");
			secButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
	                int index = getIcSicaklikModelleriTableSelectedIndex();
	                if (index < 0)
	                    return;
	                IcSicaklikSecimTableModel model = (IcSicaklikSecimTableModel)getIcSicaklikModelleriTableModel();
	                List list = model.getIcSicaklikler();
	                IcSicaklik icSicaklik = null;
	                if (index < list.size()){
	                    icSicaklik = (IcSicaklik)list.get(index);
	                }
	                originatingPanel.setSicaklik(icSicaklik);
	                dispose();
				}
			});
		}
		return secButton;
	}
	/**
	 * This method initializes vazgecButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getVazgecButton() {
		if (vazgecButton == null) {
			vazgecButton = new JButton();
			vazgecButton.setBounds(85, 5, 86, 30);
			vazgecButton.setText("Vazgeç");
			vazgecButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					setVisible(false);
				}
			});
		}
		return vazgecButton;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getIcSicaklikModelleriTable());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes radyatorModelleriTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getIcSicaklikModelleriTable() {
		if (icSicakliklarTable == null) {
			icSicakliklarTable = new JTable();
		}
		return icSicakliklarTable;
	}
	/**
	 * @param tableModel
	 */
	public void setYapiBilesenleriTable(TableModel tableModel) {
		getIcSicaklikModelleriTable().setModel(tableModel);
	}
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.X_AXIS));
			jPanel2.setPreferredSize(new java.awt.Dimension(200,100));
			jPanel2.add(getJPanel(), null);
			jPanel2.add(getJPanel3(), null);
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
			jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bina Türü", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
			jPanel3.setPreferredSize(new java.awt.Dimension(150,140));
			jPanel3.add(getHepsiRadioButton(), null);
			jPanel3.add(getKonutlarRadioButton(), null);
			jPanel3.add(getÝsVeIdareBinalariRadioButton(), null);
			jPanel3.add(getOkullarRadioButton(), null);
			jPanel3.add(getHastaneYapilariRadioButton(), null);
			jPanel3.add(getFabrikaYapilariRadioButton(), null);
			jPanel3.add(getCezaVeTutukeviRadioButton(), null);
			jPanel3.add(getDigerRadioButton(), null);
		}
		return jPanel3;
	}
	/**
	 * This method initializes hepsiRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getHepsiRadioButton() {
		if (hepsiRadioButton == null) {
			hepsiRadioButton = new JRadioButton();
			hepsiRadioButton.setText("Hepsi");
			hepsiRadioButton.setActionCommand("Hepsi");
		}
		return hepsiRadioButton;
	}
	/**
	 * This method initializes dokmeDilimliKolonRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getKonutlarRadioButton() {
		if (konutlarRadioButton == null) {
			konutlarRadioButton = new JRadioButton();
			konutlarRadioButton.setText("Konutlar");
			konutlarRadioButton.setActionCommand("Konutlar");
		}
		return konutlarRadioButton;
	}
	/**
	 * This method initializes dokmeDilimliPerkolonRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getÝsVeIdareBinalariRadioButton() {
		if (isVeIdareBinalariRadioButton == null) {
			isVeIdareBinalariRadioButton = new JRadioButton();
			isVeIdareBinalariRadioButton.setText("Ýþ ve Ýdare Binalarý");
			isVeIdareBinalariRadioButton.setActionCommand("Ýþ ve Ýdare Binalarý");
		}
		return isVeIdareBinalariRadioButton;
	}
	/**
	 * This method initializes dokmeDilimliRidomRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getOkullarRadioButton() {
		if (okullarRadioButton == null) {
			okullarRadioButton = new JRadioButton();
			okullarRadioButton.setText("Okullar");
			okullarRadioButton.setActionCommand("Okullar");
		}
		return okullarRadioButton;
	}
	/**
	 * This method initializes dilimliCelikRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getHastaneYapilariRadioButton() {
		if (hastaneYapilariRadioButton == null) {
			hastaneYapilariRadioButton = new JRadioButton();
			hastaneYapilariRadioButton.setText("Hastane Yapýlarý");
			hastaneYapilariRadioButton.setActionCommand("Hastane Yapýlarý");
		}
		return hastaneYapilariRadioButton;
	}
	/**
	 * This method initializes panelRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getFabrikaYapilariRadioButton() {
		if (fabrikaYapilariRadioButton == null) {
			fabrikaYapilariRadioButton = new JRadioButton();
			fabrikaYapilariRadioButton.setText("Fabrika Yapýlarý");
			fabrikaYapilariRadioButton.setActionCommand("Fabrika Yapýlarý");
		}
		return fabrikaYapilariRadioButton;
	}
    /**
     * @param secListener
     */
    public void addSecButtonListener(ActionListener secListener) {
        getSecButton().addActionListener(secListener);
    }
    /**
     * @param model
     */
    public void setIcSicaklikModelleriTableModel(TableModel model) {
        getIcSicaklikModelleriTable().setModel(model);
    }
    /**
     * @param radyatorTipListener
     */
    public void addIcSicaklikTipListener() {
        ButtonGroup group = new ButtonGroup();
        group.add(getHepsiRadioButton());
        group.add(getKonutlarRadioButton());
        group.add(getÝsVeIdareBinalariRadioButton());
        group.add(getOkullarRadioButton());
        group.add(getHastaneYapilariRadioButton());
        group.add(getFabrikaYapilariRadioButton());
        group.add(getCezaVeTutukeviRadioButton());
        group.add(getDigerRadioButton());
        
        getHepsiRadioButton().addActionListener(icSicaklikTipListener);
        getKonutlarRadioButton().addActionListener(icSicaklikTipListener);
        getÝsVeIdareBinalariRadioButton().addActionListener(icSicaklikTipListener);
        getOkullarRadioButton().addActionListener(icSicaklikTipListener);
        getHastaneYapilariRadioButton().addActionListener(icSicaklikTipListener);
        getFabrikaYapilariRadioButton().addActionListener(icSicaklikTipListener);
        getCezaVeTutukeviRadioButton().addActionListener(icSicaklikTipListener);
        getDigerRadioButton().addActionListener(icSicaklikTipListener);
        
        group.setSelected(getHepsiRadioButton().getModel(), true);
    }
    /**
     * @return
     */
    public int getIcSicaklikModelleriTableSelectedIndex() {
        return getIcSicaklikModelleriTable().getSelectedRow();
    }
    /**
     * @return
     */
    public TableModel getIcSicaklikModelleriTableModel() {
        return getIcSicaklikModelleriTable().getModel();
    }

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getCezaVeTutukeviRadioButton() {
		if (cezaVeTutukeviRadioButton == null) {
			cezaVeTutukeviRadioButton = new JRadioButton();
			cezaVeTutukeviRadioButton.setText("Ceza ve Tutukevi");
			cezaVeTutukeviRadioButton.setActionCommand("Ceza ve Tutukevi");
		}
		return cezaVeTutukeviRadioButton;
	}
	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getDigerRadioButton() {
		if (digerRadioButton == null) {
			digerRadioButton = new JRadioButton();
			digerRadioButton.setText("Diðer");
			digerRadioButton.setActionCommand("Diðer");
		}
		return digerRadioButton;
	}
  
    ActionListener icSicaklikTipListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
            JRadioButton button = (JRadioButton)e.getSource();
            String actionCommand = button.getActionCommand();
            String tip = actionCommand;
                Collection icSicaklikler = IcSicakliklar.getInstance().getIcSicakliklar();
                Collection filtered = null;
                if ( tip.equals("Hepsi"))
                    filtered = icSicaklikler;
                else
                    filtered = IcSicaklik.filterByTip(icSicaklikler, tip);
                
    			IcSicaklikSecimTableModel model = new IcSicaklikSecimTableModel(filtered);
    			setIcSicaklikModelleriTableModel(model);
        }
    };
}  //  @jve:decl-index=0:visual-constraint="10,10"

