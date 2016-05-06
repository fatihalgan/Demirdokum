package com.iztek.dd.GUI.util;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JDoubleTextField extends JTextField {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6636670801642168552L;
	
	private double minValue = Integer.MIN_VALUE;
	private double maxValue = Double.MAX_VALUE;
	
    public JDoubleTextField() {
        initialize();
    }
    
    public JDoubleTextField(double minValue, double maxValue) {
    	this.minValue = minValue;
    	this.maxValue = maxValue;
        initialize();
    }
    
    private void initialize() {
    	this.addKeyListener(new java.awt.event.KeyAdapter() { 
        	public void keyTyped(java.awt.event.KeyEvent e) {  
        		keyTypedAction(e);
        	}
        });
        this.addFocusListener(new java.awt.event.FocusAdapter() { 
			public void focusLost(java.awt.event.FocusEvent e) {    
				focusLostAction();
			}
		});
        this.addFocusListener(new java.awt.event.FocusAdapter() { 
			public void focusGained(java.awt.event.FocusEvent e) {    
				focusGainedAction();
			}
		});
    }
    
    private void keyTypedAction(KeyEvent e) {
    	char ch = e.getKeyChar();
    	if(ch == '-' && minValue < 0) {
    		String text = super.getText();
    		if(text.length() > 0) {
    			text = text.replaceFirst("-", "");
    			text = ch+text;
    			super.setText(text);
    			e.consume();
    		}
    	}else if(ch == '.' || ch == ',') {
    		String text = super.getText();
    		if(text.length() > 0) {
    			text = text.replaceFirst(",", "");
    			text = text+ch;
    			super.setText(text);
    			e.consume();
    		}
    	}else {
    		try {
    			Integer.parseInt(ch+"");
    		}catch(NumberFormatException nfe) {
    			e.consume();
    		}
    	}
    }
        
    private void focusLostAction() {
    	Double number = getDouble();
	    if(number != null) {
	    	if(number.doubleValue() < minValue) {
	    		SwingUtils.warnMessage("Lütfen "+minValue+" veya üzerinde bir sayý giriniz.");
				super.setText("");
				grabFocus();
			}else if(maxValue < number.doubleValue()) {
	    		SwingUtils.warnMessage("Lütfen "+maxValue+" veya altýnda bir sayý giriniz.");
				super.setText("");
				grabFocus();
			}
			else {
				setText(number.doubleValue());
			}
	    }    	
	}
    
    private void focusGainedAction() {
	    super.setSelectionStart(0);
	}
    
    public Double getDouble() {
    	String str = super.getText();
    	if(str != null && str.trim().length() > 0) {
//    		str = str.replaceAll("\\.", "");
    		str = str.replaceFirst(",", "\\.");
    		try {
    			return new Double(str.trim());
    		}catch(NumberFormatException nfe) {
    			SwingUtils.warnMessage("Lütfen "+Double.MIN_VALUE+" ile "+Double.MAX_VALUE+" arasýnda bir sayý giriniz.");
    			super.setText("");
    		}    		
    	}
    	return null;
    }
    
    public String getText() {
    	String text = super.getText();
    	if(text != null) {
    		text.replaceFirst(",", "\\.");
    	}
    	return text;
    }
    
    public void setText(String text) {
    	if(text != null) {
          	try {
          		double number = Double.parseDouble(text.trim());
          		setText(number);
          	}catch(NumberFormatException nfe) {
          		super.setText("");
          	}
        }
    }
    
    public void setText(Double number) {
       if(number != null) {
       		setText(number.doubleValue());
       }        
    }
    
    public void setText(double number) {
    	String text = DoubleFormatter.formatDouble(number);
    	super.setText(text);
    }
        
	public double getMaxValue() {
		return maxValue;
	}
	
	public double getMinValue() {
		return minValue;
	}
	
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}
	
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}
} 
