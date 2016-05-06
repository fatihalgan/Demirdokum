/*
 * Created on 09.Oca.2004
 *
 */
package com.iztek.dd.GUI.util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JOptionPane;

/**
 * @author Burak AYDIN
 *
 */
public class SwingUtils {

    public static void centerAndShowComponent(Component component){
		Dimension dimension = component.getToolkit().getScreenSize();
		double x = (dimension.getWidth() / 2.0) - (component.getSize().getWidth() / 2.0);
		double y = (dimension.getHeight() / 2.0) - (component.getSize().getHeight() / 2.0);
		component.setLocation((int)x, (int)y);
		component.setVisible(true);
	}
    
	
	private static final Object[] okOption = new Object[] {"Tamam"};
	private static final Object[] yesNoOption = new Object[] {"Evet", "Hayýr"};
	private static final Object[] okCancelOption = new Object[] {"Tamam", "Ýptal"};
	
	private static int genericYesNoConfirmation(String message, String title) {
		int confirm = JOptionPane.showOptionDialog(
						null,
						message,
						title,
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						yesNoOption,
						yesNoOption[1]);
		return confirm; 
	}
	
	private static void genericOkMessage(String message, String title, int messageIcon) {
		JOptionPane.showOptionDialog(
						null,
						message,
						title,
						JOptionPane.DEFAULT_OPTION,
						messageIcon,
						null,
						okOption,
						okOption[0]);
	}
	
    public static Object showInputDialog(String title, String message, String value) {
        JOptionPane pane = new JOptionPane(message);
        pane.setOptionType(javax.swing.JOptionPane.OK_CANCEL_OPTION);
        pane.setOptions(okCancelOption);
        pane.setWantsInput(true);
        pane.setInitialValue(okCancelOption[0]);
        pane.setInitialSelectionValue(value);
        pane.createDialog(null, title).setVisible(true);
        if(pane.getValue() != null && pane.getValue().equals(okCancelOption[0])) {
            return pane.getInputValue();
        }
        return null;
    }
    
	public static void centerJFrame(Component jFrame) {
		Dimension dim = jFrame.getToolkit().getScreenSize();
		jFrame.setLocation(
			dim.width / 2 - jFrame.getWidth() / 2,
			dim.height / 2 - jFrame.getHeight() / 2);
	}
	
	public static int exitConfirmation() {
		return genericYesNoConfirmation("Programdan Çýkmak Ýstediðinizden Emin misiniz ?", "Çýkýþ Onayý");
	}

	public static int deleteConfirmation() {
		return genericYesNoConfirmation("Bu Kaydý Silmek Ýstediðinizden Emin misiniz ?", "Silme Onayý");
	}
	
	public static int saveConfirmation() {
		return genericYesNoConfirmation("Yaptýðýnýz Deðiþiklikleri Kaydetmek Ýster misiniz ?", "Kaydetme Onayý");
	}	
	
	public static int customConfirmation(String message, String title) {
		return genericYesNoConfirmation(message, title);
	}
	
	public static void errorMessage(String message) {
		genericOkMessage(message, "HATA !!!", JOptionPane.ERROR_MESSAGE);		
	}
	
	public static void infoMessage(String message) {
		genericOkMessage(message, "BÝLGÝ", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void warnMessage(String message) {
		genericOkMessage(message, "UYARI", JOptionPane.WARNING_MESSAGE);
	}
}
