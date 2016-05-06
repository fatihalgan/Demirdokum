/*
 * Created on 04.Oca.2005
 *
 */
package com.iztek.dd.GUI;

import java.io.IOException;

import javax.swing.JDialog;

import javax.swing.JEditorPane;
/**
 * @author Selim HENDRICKSON
 *
 */
public class InfoDialog extends JDialog {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -3790305998570541424L;

	private javax.swing.JPanel jContentPane = null;

	private JEditorPane jEditorPane = null;
	/**
	 * This is the default constructor
	 */
	public InfoDialog() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 200);
		this.setContentPane(getJContentPane());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJEditorPane(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}
	public void setText(String page){
		try {
			jEditorPane.setPage(getClass().getResource(page));
		} catch (IOException e) {
			e.printStackTrace();
		}	    
	}
	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */    
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setContentType("text/html");
		}
		jEditorPane.setEditable(false);
		return jEditorPane;
	}
  }
