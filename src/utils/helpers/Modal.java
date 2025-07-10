package utils.helpers;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import utils.constants.ViewConstants;
import utils.enums.ModalTypeEnum;

public class Modal {
    
    private final String titleWindow;
    
    public Modal(String titleWindow) {
        UIManager.put("OptionPane.background", ViewConstants.mainColor);
        UIManager.put("Panel.background", new Color(245, 245, 245));
        UIManager.put("OptionPane.messageForeground", new Color(33, 33, 33));
        UIManager.put("OptionPane.messageFont", new Font("Sansserif", Font.PLAIN, 14));
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        this.titleWindow = titleWindow;
    }
    
    public void show( String message, ModalTypeEnum type ) {
        switch (type) {
            case ModalTypeEnum.success -> JOptionPane.showMessageDialog(null, message, titleWindow, JOptionPane.INFORMATION_MESSAGE);
            case ModalTypeEnum.error -> JOptionPane.showMessageDialog(null, message, titleWindow, JOptionPane.ERROR_MESSAGE);
            case ModalTypeEnum.warning -> JOptionPane.showMessageDialog(null, message, titleWindow, JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public int confirm (String messsage) {
        int answer = JOptionPane.showConfirmDialog(null, messsage, this.titleWindow, JOptionPane.YES_NO_OPTION);
        return answer;
    }
}
