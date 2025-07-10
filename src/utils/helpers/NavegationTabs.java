package utils.helpers;

import javax.swing.JTabbedPane;

public final class NavegationTabs {
    
    public static void activateTabPane( JTabbedPane pane, int quantityTabs, int activatePane ) {
        deactivateTabsPane( pane, quantityTabs );
        pane.setEnabledAt(activatePane, true);
        pane.setSelectedIndex(activatePane);
    }
    
    public static void deactivateTabsPane( JTabbedPane pane, int quantityTabs ) {
        for( int i = 0; i < quantityTabs; i++ ) {
            pane.setEnabledAt(i, false);
        }
    }
    
}
