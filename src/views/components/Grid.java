package views.components;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Grid {
    
    public static void create(JPanel panel, int quantityCols, int gap) { 
        panel.setLayout(new GridLayout(0, quantityCols, gap, gap));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
    
}
