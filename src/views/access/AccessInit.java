package views.access;

import java.awt.Font;

public class AccessInit {
    private final Access view;
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 1300;

    public AccessInit(Access view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        view.navegationPanel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Font tabFont = new Font("sansserif", Font.BOLD, 12 );
        view.navegationPanel.setFont( tabFont );
        view.navegationPanel.setSelectedIndex(0);
        view.navegationPanel.setEnabledAt(0, true);
    }
}
