package com.iztek.dd.IsiKaybi;

import java.io.Serializable;

/*
 * Created on 13.Þub.2005
 *
 */

/**
 * @author Selim HENDRICKSON
 *
 */
public class GenlesmeDeposu implements Serializable{
	private String model = "";
	private double hacim = 0;

	public GenlesmeDeposu(String model,double hacim){
		this.model = model;
		this.hacim = hacim;
	}
	
	public double getHacim() {
		return hacim;
	}
	public void setHacim(double hacim) {
		this.hacim = hacim;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}
