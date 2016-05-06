/*
 * Created on 01.Ara.2004
 *
 */
package com.iztek.dd.GUI.ddtree.item;

import com.iztek.dd.IsiKaybi.domain.Kat;
import com.iztek.dd.utilities.TreeItemSelectionEvent;

/**
 * @author Selim HENDRICKSON
 *
 */
public class KatTreeItemPanel extends TreeItemPanel{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -4589733590780865001L;
	
	private javax.swing.JLabel katNameLabel = null;

	public KatTreeItemPanel() {		
		super();		
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.add(getKatNameLabel(), null);      
        this.setSize(212, 144);
			
	}
	/**
	 * This method initializes katNameLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getKatNameLabel() {
		if(katNameLabel == null) {
			katNameLabel = new javax.swing.JLabel();
		}
		return katNameLabel;
	}
	
	
	public void setJLabelText(String name){
		katNameLabel.setText(name);
	}
	
	public void updateSelf(TreeItemSelectionEvent e) {
		TreeItemInt item = e.getSelectedItem();
		if(item instanceof Kat){
			Kat kat = (Kat) item;
			getKatNameLabel().setText(item.toString());
		}
	}

}  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"
