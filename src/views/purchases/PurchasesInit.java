package views.purchases;

import java.awt.Color;
import java.awt.Font;
import utils.constants.ViewConstants;
import views.purchases.Purchases;

public class PurchasesInit {
   
    private final Purchases view;
    private final int WINDOW_WIDTH = 1500;
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
        view.title.setForeground(Color.decode(ViewConstants.titleColor));
    }
    
}
