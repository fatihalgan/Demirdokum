/*
 * Created on 09.Oca.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.util.Comparator;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BasincKaybiCizelgeComparator implements Comparator {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(T, T)
	 */
	public int compare(Object arg0, Object arg1) {
		BasincKaybiCizelgeRow row1 = (BasincKaybiCizelgeRow)arg0;
		BasincKaybiCizelgeRow row2 = (BasincKaybiCizelgeRow)arg1;
		if(row1.getIsiYuku() > row2.getIsiYuku()) return 1;
		else if(row1.getIsiYuku() < row2.getIsiYuku()) return -1;
		return 0;
	}

}
