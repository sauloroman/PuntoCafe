package views.inits;

import java.awt.Font;
import views.warehouse.Warehouse;

public class WarehouseInit {
    
    private final Warehouse view;
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 1300;

    public WarehouseInit(Warehouse view) {
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
