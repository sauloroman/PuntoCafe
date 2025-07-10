package views.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Input {
    
    public void roundedField( JTextField textField, String borderColor, int radius ) {
        textField.setFont( new Font("sansserif", Font.PLAIN, 12) );
        textField.setForeground(new Color(30, 30, 30));
        textField.setBackground(Color.WHITE);
        textField.setCaretColor(new Color(55, 123, 76));
        textField.setBorder( new CompoundBorder(
                new RoundedBorder(Color.decode(borderColor), radius),
                new EmptyBorder(5, 8, 5, 8)
        ));
    }
    
    public void roundedArea(JTextArea textArea, String borderColor, int radius) {
        textArea.setFont(new Font("sansserif", Font.PLAIN, 12));
        textArea.setForeground(new Color(30, 30, 30));
        textArea.setBackground(Color.WHITE);
        textArea.setCaretColor(new Color(55, 123, 76));
        textArea.setBorder(new CompoundBorder(
                new RoundedBorder(Color.decode(borderColor), radius),
                new EmptyBorder(5, 8, 5, 8)
        ));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }
    
    public void roundedComboBox(JComboBox<?> comboBox, String borderColor, int radius) {
        comboBox.setFont(new Font("sansserif", Font.PLAIN, 12));
        comboBox.setForeground(new Color(30, 30, 30));
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(new CompoundBorder(
                new RoundedBorder(Color.decode(borderColor), radius),
                new EmptyBorder(4, 7, 4, 7)
        ));
    }
    
    public void areaInfo(JTextArea area) {
        area.setEditable(false);
        roundedArea(area, "#FFFFFF", 10);
    }
    
}