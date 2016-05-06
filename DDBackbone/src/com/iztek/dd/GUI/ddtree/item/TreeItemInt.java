package com.iztek.dd.GUI.ddtree.item;

/*
 * Created on 29.Kas.2004
 *
 */

/**
 * @author Selim HENDRICKSON
 *
 */
public interface TreeItemInt{	
	public String getIconURN();
	public String getItemName();
	public String[] getMenuChoices();
	public Object getSubItem(int index);
	public int getSubItemCount();
	public boolean isLeaf();
	public int getIndexOfSubItem(Object child);
    public TreeItemInt cloneSelf();    
    public void addChild(TreeItemInt child);
    public void removeChild(TreeItemInt child);
    public void setParent(TreeItemInt parent);
    public TreeItemInt getParent();
    public void loadSelf(TreeItemInt copiedObject);
}
