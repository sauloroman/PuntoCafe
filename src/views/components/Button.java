package views.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public final class Button {
    
    public void solidButton(JButton button, String mainColor, String textColor, int fontSize ) {
        button.setBackground(Color.decode(mainColor));
        button.setForeground(Color.decode(textColor));
        button.setFont(new Font("sansserif", Font.PLAIN, fontSize ));
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.decode(mainColor)),
            BorderFactory.createEmptyBorder(3, 10, 3, 10) 
        ));
    }
    
    public void outlineButton(JButton button, String borderColor, String textColor) {
        button.setBackground(new Color(0, 0, 0, 0)); 
        button.setForeground(Color.decode(textColor));
        button.setFont(new Font("sansserif", Font.PLAIN, 11));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode(borderColor)),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
    }

    public void addIcon(JButton button, String nameIcon, int size) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/views/images/" + nameIcon + ".png"));
        Image img = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));
    }
    
    public void addLeftPadding(JButton button, int leftPadding) {
        if (button.getBorder() instanceof CompoundBorder compound) {
            if (compound.getInsideBorder() instanceof EmptyBorder) {
                LineBorder lineBorder = (LineBorder) compound.getOutsideBorder();
                button.setBorder(BorderFactory.createCompoundBorder(
                    lineBorder,
                    BorderFactory.createEmptyBorder(3, leftPadding, 3, 10)
                ));
            } else {
                button.setBorder(BorderFactory.createEmptyBorder(3, leftPadding, 3, 10));
            }
        } else {
            button.setBorder(BorderFactory.createEmptyBorder(3, leftPadding, 3, 10));
        }
    }

    
}