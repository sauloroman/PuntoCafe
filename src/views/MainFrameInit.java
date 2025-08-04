package views;

import entities.User;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;

public class MainFrameInit {
    
    private final MainFrame view; 
    private final String COLOR_SIDE_BAR = ViewConstants.mainColor;
    private final String COLOR_SETTINGS_BTN = "#f9f9f9";
    private final Button buttonGenerator  = new Button();
    private final ImageCustom imageGenerator = new ImageCustom();
    private final User user;

    public MainFrameInit(MainFrame view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        view.setExtendedState(MAXIMIZED_BOTH);
        view.setTitle("PuntoCafé - Sistema de control de inventario y registro de ventas");
        view.header.setVisible(true);
        view.header.setBackground(Color.WHITE);

        imageGenerator.addImageFixNoCache(view.boxLogo, "logo-3", 200, 200);
        view.sidebar.setBackground(Color.decode(COLOR_SIDE_BAR));
        
        buttonGenerator.solidButton(view.btnWarehouse, ViewConstants.mainColor, ViewConstants.whiteColor, 14);
        buttonGenerator.solidButton(view.btnPurchases, ViewConstants.mainColor, ViewConstants.whiteColor, 14 );
        buttonGenerator.solidButton(view.btnSales, ViewConstants.mainColor, ViewConstants.whiteColor, 14 );
        buttonGenerator.solidButton(view.btnAccess, ViewConstants.mainColor, ViewConstants.whiteColor, 14 );
        buttonGenerator.solidButton(view.btnQueries, ViewConstants.mainColor, ViewConstants.whiteColor, 14 );
        buttonGenerator.solidButton(view.btnLogout, ViewConstants.mainColor, ViewConstants.whiteColor, 14);
        
        buttonGenerator.addIcon(view.btnWarehouse, "icon-box", 24);
        buttonGenerator.addIcon(view.btnPurchases, "icon-bag", 24);
        buttonGenerator.addIcon(view.btnSales, "icon-coins", 24);
        buttonGenerator.addIcon(view.btnAccess, "icon-key", 24);
        buttonGenerator.addIcon(view.btnQueries, "icon-document", 24);
        buttonGenerator.addIcon(view.btnLogout, "icon-logout", 24);
        
        buttonGenerator.addLeftPadding(view.btnWarehouse, 50);
        buttonGenerator.addLeftPadding(view.btnPurchases, 50);
        buttonGenerator.addLeftPadding(view.btnSales, 50);
        buttonGenerator.addLeftPadding(view.btnAccess, 50);
        buttonGenerator.addLeftPadding(view.btnQueries, 50);
        buttonGenerator.addLeftPadding(view.btnLogout, 50);
                
        view.mainPanel.setSize( 900, 900 );
        
        hideButtonsDependingRole();
    }
    
    private void hideButtonsDependingRole() {
        
        switch (user.getRoleId()) {
            case 2 -> {
                view.btnQueries.setVisible(false);
            }
            case 3 -> {
                view.btnAccess.setVisible(false);
                view.btnQueries.setVisible(false);
                view.btnPurchases.setVisible(false);
            }
            default -> {
            }
        }
        
    }
}
