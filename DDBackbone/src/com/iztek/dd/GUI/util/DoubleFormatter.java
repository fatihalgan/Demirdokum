package com.iztek.dd.GUI.util;

import java.text.DecimalFormat;

public class DoubleFormatter {
	private static DecimalFormat decimalFormat = null;
	
	static {
		decimalFormat = new DecimalFormat();
		decimalFormat.applyPattern("#,###.##");
	}
		
	public static String formatDouble(double number) {
		String text = number+"";		
		decimalFormat.applyPattern("#,###.##");
		//text = decimalFormat.format(number);	
		if(text.indexOf(".") == -1) {
			text = text+".0";
		}
    	return text;
	}
}
