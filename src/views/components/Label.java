package views.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class Label {
    
    public static final String COLOR_RESTRICTION_TEXT = "#888888";
    
     public static void styleRestriction(JLabel label) {
        label.setFont(new Font("sansserif", 1, 10));
        label.setForeground(Color.decode(COLOR_RESTRICTION_TEXT));
    }
    
    public static void styleWrongRestrictionField(JTextField input, JLabel label) {
        input.requestFocus();
        label.setForeground(Color.red);
    }
    
    public static void styleWrongRestrictionArea(JTextArea area, JLabel label) {
        area.requestFocus();
        label.setForeground(Color.red);
    }
}
