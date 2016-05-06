/*
 * Created on 07.Þub.2005
 *
 */
package com.iztek.dd.utilities;

import java.util.EventListener;

import javax.swing.event.EventListenerList;

import com.iztek.dd.GUI.ddtree.item.TreeItemInt;

/**
 * @author Selim HENDRICKSON
 *
 */
public class EventBroker {
	EventListenerList listeners = null;
	private static EventBroker instance = null;
	
	private EventBroker(){
		super();
	}
	
	public static EventBroker getInstance(){
		if(instance==null) instance = new EventBroker();
		return instance;
	}
	
	public synchronized void fireTreeItemSelectedEvent(TreeItemInt selectedItem){
		if(listeners!=null){
			TreeItemSelectionEvent e = new TreeItemSelectionEvent(this,selectedItem);
			EventListener[] list = listeners.getListeners(TreeItemSelectionListener.class);
			for (int i = 0; i < list.length; i++) {
				TreeItemSelectionListener tisl = (TreeItemSelectionListener) list[i];
				tisl.updateSelf(e);
			}
		}
	}
	
	public synchronized void addTreeItemSelectionListener(TreeItemSelectionListener listener){
		if(listeners==null) listeners = new EventListenerList();
		listeners.add(TreeItemSelectionListener.class,listener);
	}
	
	public synchronized void removeTreeITemSelectionListener(TreeItemSelectionListener listener){
		listeners.remove(TreeItemSelectionListener.class,listener);
	}
}
