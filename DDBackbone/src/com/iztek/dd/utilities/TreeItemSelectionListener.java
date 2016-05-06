/*
 * Created on 07.Þub.2005
 *
 */
package com.iztek.dd.utilities;

import java.util.EventListener;

/**
 * @author Selim HENDRICKSON
 *
 */
public interface TreeItemSelectionListener extends EventListener{
	public void updateSelf(TreeItemSelectionEvent e);
}
