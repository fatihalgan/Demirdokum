/*
 * Created on 01.Ara.2004
 *
 */
package com.iztek.dd.GUI.ddtree.item;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JPanel;

import com.iztek.dd.IsiKaybi.domain.IcSicaklik;
import com.iztek.dd.utilities.EventBroker;
import com.iztek.dd.utilities.TreeItemSelectionListener;

/**
 * @author Selim HENDRICKSON
 *
 */
public abstract class TreeItemPanel extends JPanel implements TreeItemSelectionListener{
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 3497206776302289327L;
	
	private int panelId = 0;
	private String identifier = null;
	DecimalFormat twoDigits = null;
	
	public TreeItemPanel(){
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		twoDigits = new DecimalFormat("##.##",symbols);
		EventBroker.getInstance().addTreeItemSelectionListener(this);
	}

	public int getPanelId() {
		return panelId;
	}

	public void setPanelId(int i) {
		panelId = i;
	}
	
	public String getPanelName(){
		return ""+panelId;
	}	
	
    public String getIdentifier() {
        return ""+identifier;
    }
    
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

	public void setSicaklik(IcSicaklik icSicaklik){		
	}
}
