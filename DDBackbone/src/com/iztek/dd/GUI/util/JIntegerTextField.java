package com.iztek.dd.GUI.util;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JIntegerTextField extends JTextField {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 335964910120738604L;
	
	private int minValue = Integer.MIN_VALUE;
	private int maxValue = Integer.MAX_VALUE;
	
    public JIntegerTextField() {
        initialize();
    }
    
    public JIntegerTextField(int minValue, int maxValue) {
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
    	}else {
    		try {
    			Integer.parseInt(ch+"");
    		}catch(NumberFormatException nfe) {
    			e.consume();
    		}
    	}
    }
       
    private void focusLostAction() {
	    Integer number = getInteger();
	    if(number != null) {
	    	if(number.intValue() < minValue) {
	    		SwingUtils.warnMessage("Lütfen "+minValue+" veya üzerinde bir sayý giriniz.");
				super.setText("");
				grabFocus();
			}else if(maxValue < number.intValue()) {
				SwingUtils.warnMessage("Lütfen "+maxValue+" veya altýnda bir sayý giriniz.");
				super.setText("");
				grabFocus();
			}
	    }
	}
    
    private void focusGainedAction() {
	    super.setSelectionStart(0);
	}
    
    public Integer getInteger() {
    	String str = super.getText();
    	if(str != null && str.trim().length() > 0) {
      		try {
    			return new Integer(str.trim());
    		}catch(NumberFormatException nfe) {
    			SwingUtils.warnMessage("Lütfen geçerli bir sayý giriniz.");
    			super.setText("");
    		}    		
    	}
    	return null;
    }
        
    public void setText(String text) {
    	if(text != null) {
          	try {
          		int number = Integer.parseInt(text.trim());
          		super.setText(number+"");
          	}catch(NumberFormatException nfe) {
          		super.setText("");
          	}
        }
    }
    
    public void setText(Integer number) {
       if(number != null) {
       		if(minValue <= number.intValue() && number.intValue() <= maxValue) {
       			super.setText(number.toString());
       		}
       }        
    }
    
    public void setText(int number) {
    	if(minValue <= number && number <= maxValue) {
   			super.setText(number+"");
   		}
    }
        
	public int getMaxValue() {
		return maxValue;
	}
	
	public int getMinValue() {
		return minValue;
	}
	
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
} 
