package com.iztek.dd.GUI.ddtree;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;

/*
 * Created on 29.Kas.2004
 *
 * Selim HENDRICKSON
 */

public class DDTree extends JPanel {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -3175340681503185388L;
	
	private JScrollPane jScrollPane = null;
	private JTree jTree = null;
	private JPanel rightPanel = null;
	/**
	 * This is the default constructor
	 */
	public DDTree(JPanel rightPanel) {
		super();
		this.rightPanel = rightPanel;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new java.awt.BorderLayout());
		this.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
		this.setSize(300, 200);
	}
	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if(jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getJTree());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jTree
	 * 
	 * @return javax.swing.JTree
	 */
	public javax.swing.JTree getJTree() {
	    if(jTree==null) jTree= new JTree();
		return jTree;
	}
		
	public void setTree(JTree tree){
	    this.jTree = tree;
	}

	public void setTreeModel(TreeModel customBinaTreeModel) {
	    getJTree().setModel((TreeModel)customBinaTreeModel);
    }
}
