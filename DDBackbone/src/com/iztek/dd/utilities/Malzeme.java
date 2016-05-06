/*
 * Created on 02.Oca.2005
 *
 */
package com.iztek.dd.utilities;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Malzeme {
	private String sir = "";
	private String id = "";
	private String cesit = "";
	private String birimHacim = "";
	private String isilIletkenlik = "";
	private String difuzyonFaktoru = "";
	private ArrayList children = null;
	
	public Malzeme(String sir, String sira_no, String bir, String iki, String uc, String dort){
		if(sir!=null)this.sir = sir.trim();
		if(sira_no!=null)this.id = sira_no.trim();
		if(bir!=null)this.cesit = bir.trim();
		if(iki!=null)this.birimHacim = iki.trim();
		if(uc!=null)this.isilIletkenlik = uc.trim();
		if(dort!=null)this.difuzyonFaktoru = dort.trim();
		children = new ArrayList();
	}
	
	public String toString() {
		return id +" - "+ cesit +" - "+ birimHacim +" - "+ isilIletkenlik +" - "+ difuzyonFaktoru; 
	}
	
	public String getBirimHacim() {
		return birimHacim;
	}
	public void setBirimHacim(String birimHacim) {
		this.birimHacim = birimHacim;
	}
	public String getCesit() {
		return cesit;
	}
	public void setCesit(String cesit) {
		this.cesit = cesit;
	}
	public String getDifuzyonFaktoru() {
		return difuzyonFaktoru;
	}
	public void setDifuzyonFaktoru(String difuzyonFaktoru) {
		this.difuzyonFaktoru = difuzyonFaktoru;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsilIletkenlik() {
		return isilIletkenlik;
	}
	public void setIsilIletkenlik(String isilIletkenlik) {
		this.isilIletkenlik = isilIletkenlik;
	}
	public String getSir() {
		return sir;
	}
	public void setSir(String sir) {
		this.sir = sir;
	}
	public void addChild(Malzeme childMalzeme){		
		children.add(childMalzeme);
	}
	public Malzeme getChild(String id){		
		Iterator it = children.iterator();
		while(it.hasNext()){
			Malzeme childMalzeme = (Malzeme)it.next();
			if(childMalzeme.getId().equals(id)) return childMalzeme;
		}			
		return null;
	}
	
	public ArrayList getChildren() {
		return children;
	}
}
