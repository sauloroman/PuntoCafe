package views.components;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public final class TabPane {
 
    public static void styleGeneralTab(JTabbedPane pane) {
        pane.setVisible(true);
        pane.setBackground(Color.WHITE);
        UIManager.put("TabbedPane.selectedBackground", Color.decode("#f7fcfa"));
        UIManager.put("TabbedPane.background", Color.WHITE);
        UIManager.put("TabbedPane.foreground", Color.decode("#121615"));
        UIManager.put("TabbedPane.focus", Color.decode("#121615"));
        UIManager.put("TabbedPane.tabAreaBackground", Color.WHITE);
    } 
    
}
