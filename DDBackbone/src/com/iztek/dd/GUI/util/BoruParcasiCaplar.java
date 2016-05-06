/*
 * Created on 10.Oca.2005
 *
 */
package com.iztek.dd.GUI.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author CO SOL
 *
 */
public class BoruParcasiCaplar {
	public static final List CAPLAR;
	
	static {
		ArrayList list = new ArrayList();
		list.add(new Cap(0.375, "3/8\""));
		list.add(new Cap(0.5, "1/2\""));
		list.add(new Cap(0.75, "3/4\""));
		list.add(new Cap(1.0, "1\""));
		list.add(new Cap(1.25, "1 1/4\""));
		list.add(new Cap(1.05, "1 1/2\""));
		list.add(new Cap(2.0, "2\""));
		CAPLAR = Collections.unmodifiableList(list);
	}
	
	public static class Cap {
		 private double cap;
		 private String capStr;
		 
		 public Cap(){
		 }
		 
		 public Cap(double cap, String capStr){
		 	setCap(cap);
		 	setCapStr(capStr);
		 }
		 
		/**
		 * @return Returns the cap.
		 */
		public double getCap() {
			return cap;
		}
		/**
		 * @param cap The cap to set.
		 */
		public void setCap(double cap) {
			this.cap = cap;
		}
		/**
		 * @return Returns the capStr.
		 */
		public String getCapStr() {
			return capStr;
		}
		/**
		 * @param capStr The capStr to set.
		 */
		public void setCapStr(String capStr) {
			this.capStr = capStr;
		}
		
		public String toString() {
			return getCapStr();
		}
	}
}
