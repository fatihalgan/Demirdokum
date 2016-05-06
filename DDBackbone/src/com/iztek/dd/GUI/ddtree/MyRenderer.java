package com.iztek.dd.GUI.ddtree;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;

public class MyRenderer extends DefaultTreeCellRenderer {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 8875417037331316826L;

	public Component getTreeCellRendererComponent(
		JTree tree,
		Object value,
		boolean sel,
		boolean expanded,
		boolean leaf,
		int row,
		boolean hasFocus) {

		super.getTreeCellRendererComponent(
			tree,
			value,
			sel,
			expanded,
			leaf,
			row,
			hasFocus);
//		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
//		TreeItemInt item = (TreeItemInt) node.getUserObject();
		TreeItemInt item = (TreeItemInt) value;
		setIcon(createImageIcon(item.getIconURN()));
		return this;
	}

	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = DDTree.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

}