/*
 * Created on 07.Þub.2005
 *
 */
package com.iztek.dd.utilities;

import java.util.EventObject;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class TreeItemSelectionEvent extends EventObject {
	private TreeItemInt selectedItem = null;

	public TreeItemSelectionEvent(Object source,TreeItemInt selectedItem) {
		super(source);
		this.selectedItem = selectedItem;
	}
	
	public TreeItemInt getSelectedItem() {
		return selectedItem;
	}
	
	public void setSelectedItem(TreeItemInt selectedItem) {
		this.selectedItem = selectedItem;
	}
}
