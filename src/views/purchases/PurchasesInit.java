package views.purchases;

import java.awt.Font;

public class PurchasesInit {
   
    private final Purchases view;
    private final int WINDOW_WIDTH = 1320;
    private final int WINDOW_HEIGHT = 1000;

    public PurchasesInit(Purchases view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        view.navegationPane.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Font tabFont = new Font("sansserif", Font.BOLD, 12 );
        view.navegationPane.setFont( tabFont );
        view.navegationPane.setSelectedIndex(0);
        view.navegationPane.setEnabledAt(0, true);
    }
    
}
