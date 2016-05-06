/*
 * Created on 28.Ara.2004
 *
 */
package com.iztek.dd;

import com.iztek.dd.GUI.MainGUI;

/**
 * @author Selim HENDRICKSON
 *
 */
public class Starter {
	public static void main(String[] args) {		
		MainGUI mainGUI = new MainGUI();
		MainController mainController = new MainController(mainGUI);
		mainGUI.setVisible(true);
	}
}
