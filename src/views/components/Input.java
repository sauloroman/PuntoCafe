package views.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Input {
    
    public void roundedField( JTextField textField, String borderColor, int radius, String placeholder ) {
        textField.setFont( new Font("sansserif", Font.PLAIN, 12) );
        textField.setForeground(new Color(30, 30, 30));
        textField.setBackground(Color.WHITE);
        textField.setCaretColor(new Color(55, 123, 76));
        textField.setBorder( new CompoundBorder(
                new RoundedBorder(Color.decode(borderColor), radius),
                new EmptyBorder(5, 8, 5, 8)
        ));
        
        if (placeholder != null && !placeholder.isEmpty()) {
            addPlaceholder(textField, placeholder);
        }
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
    
    public void roundedPasswordField(final JPasswordField passwordField, String borderColor, int radius, final String placeholder) {
        passwordField.setFont(new Font("sansserif", Font.PLAIN, 12));
        passwordField.setForeground(new Color(30, 30, 30));
        passwordField.setBackground(Color.WHITE);
        passwordField.setCaretColor(new Color(55, 123, 76));
        passwordField.setBorder(new CompoundBorder(
                new RoundedBorder(Color.decode(borderColor), radius),
                new EmptyBorder(5, 8, 5, 8)
        ));

        if (placeholder != null && !placeholder.isEmpty()) {
            addPlaceholder(passwordField, placeholder);
        }
    }
    
    public void addPlaceholder(final JTextField field, final String placeholder) {
        final Color placeholderColor = Color.GRAY;
        final Color textColor = new Color(30, 30, 30);

        field.setForeground(placeholderColor);
        field.setText(placeholder);

        if (field instanceof JPasswordField) {
            ((JPasswordField) field).setEchoChar((char) 0);
        }

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(textColor);
                    if (field instanceof JPasswordField) {
                        ((JPasswordField) field).setEchoChar('•');
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(placeholderColor);
                    field.setText(placeholder);
                    if (field instanceof JPasswordField) {
                        ((JPasswordField) field).setEchoChar((char) 0);
                    }
                }
            }
        });
    }
    
}