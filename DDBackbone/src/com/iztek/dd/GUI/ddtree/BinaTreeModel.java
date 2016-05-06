/*
 * Created on 07.Þub.2005
 *
 */
package com.iztek.dd.GUI.ddtree;

import java.util.Vector;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;
import com.iztek.dd.IsiKaybi.domain.Bina;

/**
 * @author Selim HENDRICKSON
 *
 */
public class BinaTreeModel implements TreeModel {
	private Bina bina = null;
	private Vector treeModelListeners = new Vector();

	public BinaTreeModel(Bina bina){
		this.bina = bina;
	}
	
	public Object getRoot() {
		return bina;
	}

	public Object getChild(Object parent, int index) {
		TreeItemInt item = (TreeItemInt) parent;
		return item.getSubItem(index);
	}

	public int getChildCount(Object parent) {
		TreeItemInt item = (TreeItemInt) parent;
		return item.getSubItemCount();
	}

	public boolean isLeaf(Object node) {
		TreeItemInt item = (TreeItemInt) node;
		return item.isLeaf();
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
		//Not used in this model
		System.out.println("Implement this!");
	}

	public int getIndexOfChild(Object parent, Object child) {
		TreeItemInt item = (TreeItemInt) parent;
		return item.getIndexOfSubItem(child);
	}

	public void addTreeModelListener(TreeModelListener l) {
		treeModelListeners.addElement(l);
	}

	public void removeTreeModelListener(TreeModelListener l) {
		treeModelListeners.removeElement(l);
	}

    public void fireTreeStructureChanged() {
        int len = treeModelListeners.size();
        TreeModelEvent e = new TreeModelEvent(this, 
                                              new Object[] {bina});
        for (int i = 0; i < len; i++) {
            ((TreeModelListener)treeModelListeners.elementAt(i)).
                    treeStructureChanged(e);
        }
    }
}
