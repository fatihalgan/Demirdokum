package com.iztek.dd.aktarim.model.camSC;

/**
 * @author Yasin
 */
public class KeyValueBean {
	private String key;
	private double value;
	
	public KeyValueBean(String key, double value){
		this.key = key;
		this.value = value;
	}
	
	public KeyValueBean(){
		
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
}
