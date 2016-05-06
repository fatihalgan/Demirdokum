/*
 * Created on 09.Oca.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKaybi.domain;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SabitZPolicy implements ZetaDirenciPolicy {

	private double zDirenci;
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKaybi.domain.ZDirenciPolicy#getZValue()
	 */
	public double getZetaValue(double boruCapi) {
		return zDirenci;
	}

}
