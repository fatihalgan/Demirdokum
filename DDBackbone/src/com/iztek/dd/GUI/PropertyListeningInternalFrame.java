/*
 * Created on 29.Ara.2004
 *
 */
package com.iztek.dd.GUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JInternalFrame;

/**
 * @author Selim HENDRICKSON
 *
 */
public class PropertyListeningInternalFrame extends JInternalFrame implements
		PropertyChangeListener {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -7383828921368617879L;
	
	public PropertyListeningInternalFrame(String arg0, boolean arg1,
			boolean arg2, boolean arg3, boolean arg4) {
		super(arg0, arg1, arg2, arg3, arg4);
	}
	public void propertyChange(PropertyChangeEvent arg0) {		
		this.setTitle((String)arg0.getNewValue());
	}

}
